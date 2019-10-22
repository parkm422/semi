package com.semi.controller.memberY;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.memberY.MemberDao;
import com.semi.vo.memberY.MemberVo;

@WebServlet("/memberinfoupdateY/memberupdate")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		MemberVo vo=new MemberVo(0, null,id,null, null, null,null,0,null);
		MemberDao dao=MemberDao.getInstance();
		int n=dao.select(id);
		if(n>0) {
			req.setAttribute("code","success");
		}else {
			req.setAttribute("code","fail");
		}
		req.setAttribute("top","/header.jsp");
		req.setAttribute("content","/memberinfoupdateY/memberupdate.jsp");
		req.setAttribute("nav","/mypagenav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/main").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		MemberVo vo=new MemberVo(0, null,id,pwd, email, address,phone,0,null);
		MemberDao dao=MemberDao.getInstance();
		int n=dao.update(vo);
		if(n>0) {
			req.setAttribute("code","success");
		}else {
			req.setAttribute("code","fail");
		}

		req.setAttribute("top","/header.jsp");
		req.setAttribute("content","/memberinfoupdateY/result.jsp");
		req.setAttribute("nav","/mypagenav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/main").forward(req, resp);
	}
}
