package com.oop.staffManagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.staffManagement.model.UserModel;

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // Check if user is logged in and is admin
        if (session.getAttribute("user") == null || 
            !"admin".equalsIgnoreCase((String) session.getAttribute("userRole"))) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        
        // Get user ID from request
        String userId = request.getParameter("id");
        
        try {
            // Get user details
            UserModel user = StaffUserController.getUserById(Integer.parseInt(userId));
            
            if (user != null) {
                // Set user details in request attribute
                request.setAttribute("user", user);
                
                // Forward to update.jsp in admin folder
                request.getRequestDispatcher("/admin/update.jsp").forward(request, response);
            } else {
                response.getWriter().println(
                    "<script>alert('User not found!'); window.location.href='" + 
                    request.getContextPath() + "UsersListServlet';</script>");
            }
        } catch (SQLException e) {
            response.getWriter().println(
                "<script>alert('Database Error: " + e.getMessage() + "'); window.location.href='" + 
                request.getContextPath() + "UsersListServlet';</script>");
        }
    }
} 