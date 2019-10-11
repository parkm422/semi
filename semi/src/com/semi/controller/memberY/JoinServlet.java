package com.semi.controller.memberY;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.memberY.S_MemberDAO;
import com.semi.vo.memberY.S_MemberVO;
@WebServlet("/memberY/join")
public class JoinServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/memberY/join.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/main").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		S_MemberVO vo = new S_MemberVO(0, name, id, pwd, email, address, phone, 0, null);
		S_MemberDAO dao = S_MemberDAO.getSmemberDao();
		
		int n = dao.insert(vo);
		
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/main");
		}
	}
}
