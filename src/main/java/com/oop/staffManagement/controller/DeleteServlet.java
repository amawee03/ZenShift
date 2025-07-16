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

import com.oop.staffManagement.model.RequestModel;
import com.oop.staffManagement.util.LoggerUtil;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private static final Logger logger = LoggerUtil.getLogger(DeleteServlet.class.getName());
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Empty
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		boolean isTrue;
		isTrue=Requestcontrole.deletedata(id);
		if(isTrue ==true) {
			logger.info("Received request to delete user salary request with ID: " + id);
			String alertMessage ="Data delete Successfull";
			response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='GetAllServlet';</script>");
		}
		else {
			List<RequestModel>reqq=Requestcontrole.getBYId(id);
			request.setAttribute("reqq", reqq);
			
			RequestDispatcher dispacher=request.getRequestDispatcher("wrong.jsp");
			dispacher.forward(request,response);
		}
	}

}