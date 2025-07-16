package com.oop.staffManagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.staffManagement.util.ValidateTaskInputs;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        // Check if user is logged in and is admin
        if (session.getAttribute("user") == null || 
            !"admin".equalsIgnoreCase((String) session.getAttribute("userRole"))) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");
        
        // Validate required fields
        if (name == null || name.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            phone == null || phone.trim().isEmpty() ||
            role == null || role.trim().isEmpty()) {
            response.getWriter().println(
                "<script>alert('All fields are required!'); window.location.href='" + 
                request.getContextPath() + "/UsersListServlet';</script>");
            return;
        }
        //validate inputs - abstraction is used here
	     if (!ValidateTaskInputs.isName(name)) {
       	response.getWriter().println("<script>alert('Employee name must contain only letters.'); window.history.back();</script>");
           return;
       }

       if (!ValidateTaskInputs.isValidEmail(email)) {
       	response.getWriter().println("<script>alert('Email Invalid.'); window.history.back();</script>");
           return;
       }
      
        
        try {
            // Add user with specified role
            boolean isSuccess = StaffUserController.insertDataWithRole(name, email, password, phone, role);
            
            if (isSuccess) {
                response.getWriter().println(
                    "<script>alert('User added successfully!'); window.location.href='" + 
                    request.getContextPath() + "/UsersListServlet';</script>");
            } else {
                response.getWriter().println(
                    "<script>alert('Failed to add user!'); window.location.href='" + 
                    request.getContextPath() + "UsersListServlet';</script>");
            }
        } catch (SQLException e) {
            response.getWriter().println(
                "<script>alert('Database Error: " + e.getMessage() + "'); window.location.href='" + 
                request.getContextPath() + "UsersListServlet';</script>");
        }
    }
} 