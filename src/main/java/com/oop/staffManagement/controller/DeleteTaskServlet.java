package com.oop.staffManagement.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.model.TaskModel;
import com.oop.staffManagement.util.LoggerUtil;

@WebServlet("/DeleteTaskServlet")
public class DeleteTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = LoggerUtil.getLogger(DeleteTaskServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int taskID = Integer.parseInt(request.getParameter("taskID"));
            logger.info("Received request to delete task with ID: " + taskID);

            boolean isDeleted = TaskController.deleteData(taskID);

            if (isDeleted) {
                logger.info("Task with ID " + taskID + " deleted successfully.");

                response.setContentType("text/html");
                List<TaskModel> tasks = TaskController.getAllTasks();
                request.setAttribute("allTask", tasks);
                request.setAttribute("message", "Task deleted successfully!");

                RequestDispatcher dispatcher = request.getRequestDispatcher("Tasks.jsp");
                dispatcher.forward(request, response);
            } else {
                logger.warning("Failed to delete task with ID: " + taskID);

                response.setContentType("text/html");
                response.getWriter().println("<script>alert('Failed to delete task.'); window.location.href='Tasks.jsp';</script>");
            }
        } catch (NumberFormatException e) {
            logger.severe("Invalid task ID provided: " + e.getMessage());
            response.getWriter().println("<script>alert('Invalid Task ID.'); window.location.href='Tasks.jsp';</script>");
        } catch (Exception e) {
            logger.severe("Exception while deleting task: " + e.getMessage());
            e.printStackTrace();
            response.getWriter().println("<script>alert('Something went wrong.'); window.location.href='Tasks.jsp';</script>");
        }
    }
}
