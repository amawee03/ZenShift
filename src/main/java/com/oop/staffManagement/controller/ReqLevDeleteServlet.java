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

import com.oop.staffManagement.model.RequestLevModel;
import com.oop.staffManagement.util.LoggerUtil;

//delete servlet - navod


@WebServlet("/ReqLevDeleteServlet")
public class ReqLevDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private static final Logger logger = LoggerUtil.getLogger(ReqLevDeleteServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Empty
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String leaveID = request.getParameter("leaveID");
		
		boolean isTrue;
		isTrue = ReqLeaveController.deletedata(leaveID);
		
		if(isTrue == true) {
			logger.info("Received request to delete leave request with ID: " + leaveID);
			String alertMessage = "Data Delete Successful";
			response.getWriter().println("<script> alert('"+alertMessage+"');"+" window.location.href='LeaveAllServlet';</script>");
			
		}
		else {
			List<RequestLevModel> reqDetails = ReqLeaveController.getById(leaveID);
			request.setAttribute("reqDetails", reqDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("wrong.jsp");
			dispatcher.forward(request, response);
		}
	
	}

}