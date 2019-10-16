package com.semi.controller.boardl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.boardl.Ono_EnquiryDao;
import com.semi.vo.boardl.Ono_EnquiryVO;
@WebServlet("/boardl/go")

public class askGO extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int ennum=Integer.parseInt(req.getParameter("ennum"));
		String answer=req.getParameter("answer");

		Ono_EnquiryDao dao=new Ono_EnquiryDao();
		int n=dao.askgo(answer, ennum);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/main");
		}
	}
}
