package com.semi.controller.managerP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.productP.CategoryDAO;

@WebServlet("/manager/addCategory")
public class AddCategoryServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/adnav.jsp");
		req.setAttribute("content", "/manager/addCategory.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/main").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String major = req.getParameter("major");
		String sub = req.getParameter("sub");
		int minSize = Integer.parseInt(req.getParameter("min_size"));
		int maxSize = Integer.parseInt(req.getParameter("max_size"));
		String color = req.getParameter("color");
		
		CategoryDAO categoryDao = CategoryDAO.getCategoryDao();
		
		int n = categoryDao.addCategory(major, sub, minSize, maxSize, color);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/main");
		}
	}
}
