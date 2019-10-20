package com.semi.controller.managerP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manager/addCategory")
public class AddCategoryServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/manager/addCategory.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/main").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String major = req.getParameter("major");
		String sub = req.getParameter("sub");
		int minSize = Integer.parseInt(req.getParameter("minSize"));
		int maxSize = Integer.parseInt(req.getParameter("maxSize"));
		String color = req.getParameter("color");
		
		
		
	}
}
