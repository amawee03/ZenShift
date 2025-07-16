package com.oop.staffManagement.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.model.TaskModel;

@WebServlet("/ViewTaskServlet")
public class ViewTaskServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch all tasks from the database using the TaskController
        List<TaskModel> tasks = TaskController.getAllTasks();
        
        // Set tasks in the request scope to forward to JSP
        request.setAttribute("allTask", tasks);
        
        // Forward to the JSP page to display the tasks
      request.getRequestDispatcher("Tasks.jsp").forward(request, response);
    }
}

