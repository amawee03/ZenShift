package com.oop.staffManagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.staffManagement.controller.StaffUserController;
import com.oop.staffManagement.model.UserModel;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
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
        
        // Get and validate user ID
        String userIdStr = request.getParameter("userId");
        if (userIdStr == null || userIdStr.trim().isEmpty()) {
            response.getWriter().println(
                "<script>alert('User ID is required!'); window.location.href='" + 
                request.getContextPath() + "/UsersListServlet';</script>");
            return;
        }
        
        try {
            int userId = Integer.parseInt(userIdStr);
            
            // Get other form data
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String role = request.getParameter("role");
            String password = request.getParameter("password");
            
            // Validate required fields
            if (name == null || name.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                phone == null || phone.trim().isEmpty() ||
                role == null || role.trim().isEmpty()) {
                response.getWriter().println(
                    "<script>alert('All fields are required!'); window.location.href='" + 
                    request.getContextPath() + "/EditUserServlet?id=" + userId + "';</script>");
                return;
            }
            
            // If password is empty, get the current password
            if (password == null || password.trim().isEmpty()) {
                UserModel currentUser = StaffUserController.getUserById(userId);
                if (currentUser != null) {
                    password = currentUser.getPassword();
                }
            }
            
            // Update user details
            boolean isSuccess = StaffUserController.updateUser(userId, name, email, phone, role, password);
            
            if (isSuccess) {
                response.getWriter().println(
                    "<script>alert('User updated successfully!'); window.location.href='" + 
                    request.getContextPath() + "/UsersListServlet';</script>");
            } else {
                response.getWriter().println(
                    "<script>alert('Failed to update user!'); window.location.href='" + 
                    request.getContextPath() + "/EditUserServlet?id=" + userId + "';</script>");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println(
                "<script>alert('Invalid user ID!'); window.location.href='" + 
                request.getContextPath() + "/UsersListServlet';</script>");
        } catch (SQLException e) {
            response.getWriter().println(
                "<script>alert('Database Error: " + e.getMessage() + "'); window.location.href='" + 
                request.getContextPath() + "/UsersListServlet';</script>");
        }
    }
} 