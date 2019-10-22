package com.semi.controller.memberP;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.semi.dao.memberP.S_MemberDAO;

import com.semi.vo.memberP.S_MemberVO;
@WebServlet("/member/mypage")
public class MypageServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session  = req.getSession();
		String id = (String)session.getAttribute("id");
		
		S_MemberDAO memDao = S_MemberDAO.getSmemberDao();
		S_MemberVO vo = memDao.getMemberInfo(id);
		
		req.setAttribute("vo", vo);
		
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/mypagenav.jsp");
		req.setAttribute("content", "/member/mypage.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/main").forward(req, resp);
	}
}
