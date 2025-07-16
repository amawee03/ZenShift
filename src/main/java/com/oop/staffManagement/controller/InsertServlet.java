package com.oop.staffManagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.staffManagement.util.ValidateTaskInputs;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String amount=request.getParameter("amount");
		String reson=request.getParameter("reson");
		String date=request.getParameter("date");
		
		
		 //validate inputs - abstraction is used here
		if (!ValidateTaskInputs.isName(name)) {
        	response.getWriter().println("<script>alert('Employee name must contain only letters.'); window.history.back();</script>");
            return;
        }
		if (!ValidateTaskInputs.isValidSalary(amount)) {
        	response.getWriter().println("<script>alert('Amount must only contain numbers.'); window.history.back();</script>");
            return;
        }
		boolean isTrue;
		
		isTrue =Requestcontrole.insertdata(name,amount,reson,date);
		
		if(isTrue==true) {
			String alertMessage="Data Insert Successful";
			response.getWriter().println("<script> alert('"+alertMessage+"');window.location.href='GetAllServlet'</script>");
			
		}
		else {
			RequestDispatcher dis2=request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
			
		}
		
	}

}