package com.oop.staffManagement.controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.model.UserModel;

@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response type to plain text or HTML
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        
        // Get user ID from request
        String userId = request.getParameter("id");
        
        // Check if user ID is provided
        if (userId == null || userId.isEmpty()) {
            response.getWriter().write("Please provide a user ID.");
            return;
        }
        
        try {
            // Convert user ID to integer
            int id = Integer.parseInt(userId);
            
            // Get user from database
            UserModel user = StaffUserController.getUserById(id);
            
            if (user != null) {
                // Output user info in plain text
                response.getWriter().write(
                    "ID: " + user.getId() + "\n" +
                    "Name: " + user.getName() + "\n" +
                    "Email: " + user.getEmail() + "\n" +
                    "Phone: " + user.getPhone() + "\n" +
                    "Role: " + user.getRole()
                );
            } else {
                response.getWriter().write("User not found.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().write("Invalid user ID.");
        } catch (SQLException e) {
            response.getWriter().write("Database error occurred.");
        }
    }
}