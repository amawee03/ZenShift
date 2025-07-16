package com.oop.staffManagement.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.model.TaskModel;
import com.oop.staffManagement.util.ValidateTaskInputs;

@WebServlet("/UpdateTaskServlet")
public class UpdateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Empty Method
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String taskID = request.getParameter("taskID");
		 String employeeID=request.getParameter("employeeID");
		 String employeeName=request.getParameter("employeeName");
		 String taskName=request.getParameter("taskName");
		 String taskDescription=request.getParameter("taskDescription");
		 String assignedDate=request.getParameter("assignedDate");
		 String dueDate=request.getParameter("dueDate");
		 String priority=request.getParameter("priority");
		 
		// Convert dueDate string to LocalDate
	        LocalDate dueDateObj = null;
	        if (dueDate != null && !dueDate.trim().isEmpty()) {
	            dueDateObj = LocalDate.parse(dueDate);
	        }

	        if (!ValidateTaskInputs.isName(employeeName)) {
	        	response.getWriter().println("<script>alert('Employee name must contain only letters.'); window.history.back();</script>");
	            return;
	        }

	        if (!ValidateTaskInputs.isValidDescription(taskDescription)) {
	        	response.getWriter().println("<script>alert('Task description must be at least 30 characters.'); window.history.back();</script>");
	        	return;
	        }

	        if (!ValidateTaskInputs.isDueDateValid(dueDateObj)) {
	        	response.getWriter().println("<script>alert('Due Date Not valid.'); window.history.back();</script>");
	        	return;
	        }
	        
		 boolean isTrue;
		 
		 isTrue =TaskController.updateData(taskID, employeeID, employeeName, taskName, taskDescription, dueDateObj, priority);
		
		 if(isTrue==true) {
			
			 List<TaskModel> tasks = TaskController.getAllTasks();
			 request.setAttribute("allTask", tasks);

			 request.setAttribute("message", "Task updated successfully!");
			 RequestDispatcher dispatcher = request.getRequestDispatcher("Tasks.jsp");
				dispatcher.forward(request, response);
		 }else {
			 RequestDispatcher dis2 = request.getRequestDispatcher("home.jsp");
			 dis2.forward(request,response);
			 
		 }
		 
	}

}
