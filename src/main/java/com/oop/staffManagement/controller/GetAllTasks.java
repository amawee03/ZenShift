package com.oop.staffManagement.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.model.TaskModel;


@WebServlet("/GetAllTasks")
public class GetAllTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//System.out.println("GetAllTasks servlet triggered");
		List<TaskModel> allTask = TaskController.getAllTasks();
		request.setAttribute("allTask", allTask);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Tasks.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,response);
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to retrieve tasks.");
	}

}
