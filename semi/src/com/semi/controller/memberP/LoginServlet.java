package com.semi.controller.memberP;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.semi.dao.memberP.S_MemberDAO;
@WebServlet("/member/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("content","/member/login.jsp");
		req.setAttribute("footer","/footer.jsp");
		
		req.getRequestDispatcher("/main").forward(req, resp);
		*/
		resp.sendRedirect(req.getContextPath()+"/member/login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		S_MemberDAO dao = S_MemberDAO.getSmemberDao();
		
		boolean exist = dao.exist(id, pwd);
		if(exist) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			req.setAttribute("content","/main.jsp");
		}else {
			req.setAttribute("errMsg", "아이디 또는 비밀번호를 다시 확인하세요.<br>등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.");
			req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav","/nav.jsp");
		
		req.setAttribute("footer","/footer.jsp");
		
		req.getRequestDispatcher("/main").forward(req, resp);
	}
}
