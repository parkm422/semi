package com.semi.controller.boardP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/member/comment")
public class ReviewCommentServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String parentNum = req.getParameter("parentNum");
		
		int rnum = 0;
		int ref = 0;
		int lev = 0;
		int step = 0;
		
		if(parentNum != null && parentNum.equals("")) {
			rnum = Integer.parseInt(parentNum);
			ref = Integer.parseInt("ref");
			lev = Integer.parseInt("lev");
			step = Integer.parseInt("step");
		}

	}
}
