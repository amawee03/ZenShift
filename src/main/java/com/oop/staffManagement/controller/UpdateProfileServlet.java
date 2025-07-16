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
import com.oop.staffManagement.util.ValidateTaskInputs;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        // Check if user is logged in
        if (session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        // Get current user
        UserModel currentUser = (UserModel) session.getAttribute("userObject");
        
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        
        if (!ValidateTaskInputs.isName(name)) {
        	response.getWriter().println("<script>alert('Employee name must contain only letters.'); window.history.back();</script>");
            return;
        }
        if (!ValidateTaskInputs.isValidEmail(email)) {
        	response.getWriter().println("<script>alert('Invalid email address.'); window.history.back();</script>");
            return;
        }

       
        try {
            // Verify current password
            if (!currentUser.getPassword().equals(currentPassword)) {
                response.getWriter().println(
                    "<script>alert('Current password is incorrect!'); window.location.href='profile.jsp';</script>");
                return;
            }
            
            // Update user details
            boolean isSuccess = StaffUserController.updateUserProfile(
                currentUser.getId(),
                name,
                email,
                phone,
                newPassword.isEmpty() ? currentPassword : newPassword
            );
            
            if (isSuccess) {
                // Update session data
                currentUser.setName(name);
                currentUser.setEmail(email);
                currentUser.setPhone(phone);
                if (!newPassword.isEmpty()) {
                    currentUser.setPassword(newPassword);
                }
                session.setAttribute("userObject", currentUser);
                session.setAttribute("user", name);
                session.setAttribute("userName", name);
                session.setAttribute("userEmail", email);
                
                response.getWriter().println(
                    "<script>alert('Profile updated successfully!'); window.location.href='welcome.jsp';</script>");
            } else {
                response.getWriter().println(
                    "<script>alert('Failed to update profile!'); window.location.href='profile.jsp';</script>");
            }
        } catch (SQLException e) {
            response.getWriter().println(
                "<script>alert('Database Error: " + e.getMessage() + "'); window.location.href='profile.jsp';</script>");
        }
    }
} 