package com.oop.staffManagement.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.util.LoggerUtil;
import com.oop.staffManagement.util.ValidateTaskInputs;


@WebServlet("/InsertTaskServlet")
public class InsertTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerUtil.getLogger(InsertTaskServlet.class.getName());   
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
		 String employeeID = request.getParameter("employeeID");
	     String employeeName = request.getParameter("employeeName");
	     String taskName = request.getParameter("taskName") ;
	     String taskDescription = request.getParameter("taskDescription");
	     String dueDateStr = request.getParameter("dueDate"); 
	     String priority =request.getParameter("priority") ;
	     
	     LocalDate dueDate = null;
	     
	        try {
	            dueDate = LocalDate.parse(dueDateStr);
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("<script>alert('Invalid date format! Use YYYY-MM-DD.'); window.history.back();</script>");
	            return;
	        }
	        //validate inputs - abstraction is used here
	        
	        if (!ValidateTaskInputs.isName(employeeName)) {
	        	response.getWriter().println("<script>alert('Employee name must contain only letters.'); window.history.back();</script>");
	            return;
	        }
	        if (!ValidateTaskInputs.empId(employeeID)) {
	        	response.getWriter().println("<script>alert('Employee ID name must contain only numbers.'); window.history.back();</script>");
	            return;
	        }
	        if (!ValidateTaskInputs.isValidDescription(taskDescription)) {
	        	response.getWriter().println("<script>alert('Task description must be at least 30 characters.'); window.history.back();</script>");
	        	return;
	        }

	        if (!ValidateTaskInputs.isDueDateValid(dueDate)) {
	        	response.getWriter().println("<script>alert('Due Date Not valid.'); window.history.back();</script>");
	        	return;
	        }
	        
	        boolean isTrue;
	     
	        //Data insertions logic - abstraction is used here
	     isTrue=TaskController.insertData(employeeID, employeeName, taskName, taskDescription, dueDate, priority);
	     
	     if(isTrue==true) {
	    	
	    	 logger.info("Task Assigned to employee with  ID " + employeeID + "  successfully.");

	    	 request.setAttribute("message", "Task inserted successfully!");
	    	 request.setAttribute("allTask", TaskController.getAllTasks());
	    	 request.getRequestDispatcher("Tasks.jsp").forward(request, response);

	     }else {
	    	 response.getWriter().println("<script>alert('Insert failed. Check logs.'); window.history.back();</script>");
	     }
		 }catch(Exception e){
			 logger.severe("Exception during task insertion: " + e.getMessage());
	         e.printStackTrace();
		 }
	}

}
