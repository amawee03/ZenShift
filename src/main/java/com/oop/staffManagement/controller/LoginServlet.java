package com.oop.staffManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.staffManagement.model.UserModel;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Basic validation
        if (email == null || email.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            out.println("<script>");
            out.println("alert('Email and password are required');");
            out.println("window.location.href='login.jsp';");
            out.println("</script>");
            return;
        }
        
        try {
            List<UserModel> users = StaffUserController.loginValidate(email, password);
            
            if (!users.isEmpty()) {
                UserModel user = users.get(0);
                HttpSession session = request.getSession();
                
                // Store user information in session
                session.setAttribute("userObject", user); // Store full object for easy access later
                session.setAttribute("user", user.getName()); // User name for greeting
                session.setAttribute("userName", user.getName());
                session.setAttribute("userEmail", user.getEmail());
                session.setAttribute("userRole", user.getRole()); // Role for access control
                
                // Redirect based on role
                if ("admin".equalsIgnoreCase(user.getRole())) {
                    response.sendRedirect("adminDashboard.jsp");
                } else {
                    response.sendRedirect("userDashboard.jsp"); // New dashboard for regular users
                }
            } else {
                out.println("<script>");
                out.println("alert('Invalid email or password');");
                out.println("window.location.href='login.jsp';");
                out.println("</script>");
            }
        } catch (SQLException e) {
            out.println("<script>");
            out.println("alert('Database error occurred. Please try again later.');");
            out.println("window.location.href='login.jsp';");
            out.println("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}
