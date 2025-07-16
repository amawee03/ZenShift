package com.oop.staffManagement.controller;




import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@WebServlet("/UsersReadServlet")
public class UsersReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
    	
    	    
    	    try {
    	        // Get all staff from controller
    	        List<UserModel> allStaffs = StaffUserController.getAllStaff();
    	        
    	        // Set attribute for JSP (corrected variable name)
    	        request.setAttribute("allStaffs", allStaffs);
    	        
    	        // Forward to display page
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("StaffDetails.jsp");
    	        
    	        dispatcher.forward(request, response);
    	        
    	    } catch (Exception e) {
    	        // Log error and redirect to error page
    	        e.printStackTrace();
    	       
    	    }
    	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response); // Typically GET is used for retrieval operations
    }
}
