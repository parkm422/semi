package com.semi.controller.memberK;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.memberK.S_MemberDAO;

@WebServlet("/member/findIDnPW")
public class FindIDnPWServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("top", "/header.jsp");
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("content", "/member/findIDnPW.jsp");
		request.setAttribute("footer", "/footer.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkFind = request.getParameter("check");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		if (checkFind.equals("findID")) {
			findID(request, response);
			return;
		} else if (checkFind.equals("findPW")) {
			findPW(request, response);
			return;
		}
		
		//request.setAttribute("top", "/header.jsp");
		//request.setAttribute("nav", "nav.jsp");
		//request.setAttribute("content", "/member/myPage.jsp");
		//request.setAttribute("footer", "/footer.jsp");
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		//response.sendRedirect(location);
	}
	
	protected void findID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		S_MemberDAO dao = S_MemberDAO.getSmemberDao();
		String findID = dao.findID(email);
		request.setAttribute("findID", findID);
		
		request.setAttribute("top", "/header.jsp");
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("content", "/member/findIDResult.jsp");
		request.setAttribute("footer", "/footer.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	protected void findPW(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		S_MemberDAO dao = S_MemberDAO.getSmemberDao();
		String findPW = dao.findPW(email, id);
		request.setAttribute("findPW", findPW);
		
		request.setAttribute("top", "/header.jsp");
		request.setAttribute("nav", "nav.jsp");
		request.setAttribute("content", "/member/findPWResult.jsp");
		request.setAttribute("footer", "/footer.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
