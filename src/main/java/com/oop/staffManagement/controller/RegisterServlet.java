package com.oop.staffManagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.util.LoggerUtil;
import com.oop.staffManagement.util.ValidateTaskInputs;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerUtil.getLogger(RegisterServlet.class.getName());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        // Get parameters from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
       
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
            boolean isSuccess = StaffUserController.insertData(name, email, password, phone);
            
            if (isSuccess) {
				logger.info("Employee" + name + " created successfully.");
                response.getWriter().println(
                    "<script>alert('Registration Successful!'); window.location.href='login.jsp';</script>");
            } else {
				logger.warning("Failed to create employee: " + email);
                response.getWriter().println(
                    "<script>alert('Registration Failed!'); window.location.href='register.jsp';</script>");
            }
        } catch (SQLException e) {
            response.getWriter().println(
                "<script>alert('Database Error: " + e.getMessage() + "'); window.location.href='register.jsp';</script>");
        }
    }
   

}




