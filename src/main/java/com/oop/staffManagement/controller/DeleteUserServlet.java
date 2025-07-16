package com.oop.staffManagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.staffManagement.util.LoggerUtil;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    private static final Logger logger = LoggerUtil.getLogger(DeleteUserServlet.class.getName());
    
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
        
        // Get user ID to delete
        int userId = Integer.parseInt(request.getParameter("userId"));
        
        try {
            // Delete user
            boolean isSuccess = StaffUserController.deleteUser(userId);
            
            if (isSuccess) {
            	 logger.info("Received request to delete user with ID: " + userId);
                response.getWriter().println(
                    "<script>alert('User deleted successfully!'); window.location.href='" + 
                    request.getContextPath() + "/UsersListServlet';</script>");
            } else {
                response.getWriter().println(
                    "<script>alert('Failed to delete user!'); window.location.href='" + 
                    request.getContextPath() + "/UsersListServlet';</script>");
            }
        } catch (SQLException e) {
            response.getWriter().println(
                "<script>alert('Database Error: " + e.getMessage() + "'); window.location.href='" + 
                request.getContextPath() + "/UsersListServlet';</script>");
        }
    }
} 