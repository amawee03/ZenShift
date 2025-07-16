package com.oop.staffManagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.staffManagement.model.UserModel;

@WebServlet("/UsersListServlet")
public class UsersListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // Check if user is logged in and is admin
        if (session.getAttribute("user") == null || 
            !"admin".equalsIgnoreCase((String) session.getAttribute("userRole"))) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        try {
            // Get all users
            List<UserModel> users = StaffUserController.getAllStaff();
            
            // Set users list in request attribute
            request.setAttribute("users", users);
            
            // Forward to users.jsp in admin folder
            request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
            
        } catch (SQLException e) {
            response.getWriter().println(
                "<script>alert('Database Error: " + e.getMessage() + "'); window.location.href='adminDashboard.jsp';</script>");
        }
    }
} 