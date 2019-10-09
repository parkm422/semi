package com.semi.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.manager.ManagerDAO;
@WebServlet("/manager/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("content","/manager/login.jsp");
		req.setAttribute("footer","/footer.jsp");
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		ManagerDAO dao = ManagerDAO.getManagerDao();
		
		boolean exist = dao.exist(id, pwd);
		if(exist) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			req.setAttribute("content","/main.jsp");
		}else {
			req.setAttribute("errMsg", "아이디 또는 비밀번호를 다시 확인하세요.<br>등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.");
			req.setAttribute("content","/manager/login.jsp");
		}
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav","/nav.jsp");
		
		req.setAttribute("footer","/footer.jsp");
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
