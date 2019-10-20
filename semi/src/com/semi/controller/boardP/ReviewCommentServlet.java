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
		
		String rcnum = req.getParameter("rcnum");
		String rnum = req.getParameter("rnum");
		String comments = req.getParameter("comments");
		
		HttpSession session = req.getSession();
		String rcwriter = (String)session.getAttribute("id");
		
		int rcnum1 = 0;
		int rnum1 = Integer.parseInt(rnum);
		int ref = 0;
		int lev = 0;
		int step = 0;
		
		
		if(rcnum != null && !rcnum.equals("0")) {
			rcnum1 = Integer.parseInt(rcnum);
			ref = Integer.parseInt(req.getParameter("ref"));
			lev = Integer.parseInt(req.getParameter("lev"));
			step = Integer.parseInt(req.getParameter("step"));
		}
		
		System.out.println("ref="+ref);
		System.out.println("lev="+lev);
		System.out.println("step="+step);
		System.out.println("rcnum="+rcnum);
		
		ReviewChildVO vo = new ReviewChildVO(rcnum1, rnum1, rcwriter, comments, ref, lev, step);
		
		
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
