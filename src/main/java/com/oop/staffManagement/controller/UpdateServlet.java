package com.oop.staffManagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.model.RequestModel;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String amount=request.getParameter("amount");
		String reson=request.getParameter("reson");
		String date=request.getParameter("date");
		
		boolean isTrue;
		isTrue=Requestcontrole.updatedata(id, name, amount, reson, date);
		
		if(isTrue==true) {
			List<RequestModel>reqd=Requestcontrole.getBYId(id);
			request.setAttribute("reqd",reqd);
			
			String alertMessage="Data update Successful";
			response.getWriter().println("<script> alert('"+alertMessage+"');window.location.href='GetAllServlet'</script>");
			
		}
		else {
			RequestDispatcher dis2=request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
			
		}
		
		
	}

}