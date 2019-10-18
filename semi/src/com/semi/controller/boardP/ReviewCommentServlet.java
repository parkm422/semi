package com.semi.controller.boardP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.semi.dao.boardP.ReviewDAO;
import com.semi.vo.boardP.ReviewChildVO;
@WebServlet("/member/comment")
public class ReviewCommentServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String parentNum = req.getParameter("parentNum");
		String rcnum = req.getParameter("rcnum");
		String comments = req.getParameter("comments");
		
		HttpSession session = req.getSession();
		String rcwriter = (String)session.getAttribute("id");
		
		
		
		int rcnum1 = 0;
		int rnum = 0;
		int ref = 0;
		int lev = 0;
		int step = 0;
		
		if(rcnum != null && rcnum.equals("")) {
			rcnum1 = Integer.parseInt(rcnum);
		}
		
		if(parentNum != null && parentNum.equals("")) {
			rnum = Integer.parseInt(parentNum);
			ref = Integer.parseInt("ref");
			lev = Integer.parseInt("lev");
			step = Integer.parseInt("step");
		}
		
		ReviewChildVO vo = new ReviewChildVO(rcnum1, rnum, rcwriter, comments, ref, lev, step);
		
		
		ReviewDAO reviewDao = ReviewDAO.getReviewDao();
		
		int n = reviewDao.child_insert(vo);
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject json = new JSONObject();
		PrintWriter pw = resp.getWriter();
		
		if(n>0) {
			json.put("code", "success");
			
		}else {
			json.put("code", "fail");
		}
		pw.print(json);
	}
}
