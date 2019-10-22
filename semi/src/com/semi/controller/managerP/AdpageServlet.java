package com.semi.controller.managerP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/manager/adpage")
public class AdpageServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/adnav.jsp");
		req.setAttribute("content", "/manager/adpage.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/main").forward(req, resp);
	}
}
