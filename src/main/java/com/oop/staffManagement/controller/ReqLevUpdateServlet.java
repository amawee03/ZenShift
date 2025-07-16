package com.oop.staffManagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.model.RequestLevModel;
//update - navod
@WebServlet("/ReqLevUpdateServlet")
public class ReqLevUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String leaveID = request.getParameter("leaveID");
		String empID = request.getParameter("empID");
		String leaveType = request.getParameter("leaveType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String reason = request.getParameter("reason");
		
		
		boolean isTrue;
		
		isTrue = ReqLeaveController.updatedata(leaveID, empID, leaveType, startDate, endDate, reason);
				
		
		if(isTrue == true) {
			
			List<RequestLevModel> leave  = ReqLeaveController.getById(leaveID);
			request.setAttribute("leave", leave);
			
			String alertMessage = "Data Update Successful";
			//response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='reqUpdateServlet'</script>");
			//response.sendRedirect("getAllRequestServlet");

			
			 response.setContentType("text/html;charset=UTF-8");
			    response.getWriter().println("<script>");
			    response.getWriter().println("alert('Data Updated Successfully');");
			    response.getWriter().println("window.location.href='LeaveAllServlet';");
			    response.getWriter().println("</script>");
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
		}
	}
		
		
		
	

}