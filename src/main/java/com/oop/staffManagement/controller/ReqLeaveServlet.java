package com.oop.staffManagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.util.ValidateTaskInputs;

//INSERT Servlet - Request Leaves

@WebServlet("/ReqLeaveServlet")
public class ReqLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empID = request.getParameter("empID");
		String leaveType = request.getParameter("leaveType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String reason = request.getParameter("reason");
		
		 //validate inputs - abstraction is used here
		if(!ValidateTaskInputs.empId(empID)) {
			response.getWriter().println("<script>alert('Invalid Employee ID.'); window.history.back();</script>");
            return;
		}
		
		boolean isTrue;
		
		isTrue = ReqLeaveController.insertdata(empID, leaveType, startDate, endDate, reason);
		
		if(isTrue == true) {
			String alertMessage = "Data Insert Successful";//getAllRequestServlet
			//response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='getAllRequestServlet'</script>");
			//response.sendRedirect("getAllRequestServlet");
			 response.setContentType("text/html;charset=UTF-8");
			    response.getWriter().println("<script>");
			    response.getWriter().println("alert('Data Inserted Successfully');");
			    response.getWriter().println("window.location.href='LeaveAllServlet';");
			    response.getWriter().println("</script>");

		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
		}
	}
	

}