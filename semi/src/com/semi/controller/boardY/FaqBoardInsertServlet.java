package com.semi.controller.boardY;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.boardY.BoardDao;
import com.semi.vo.boardY.BoardVo;



@WebServlet("/faqboardY/faqinsert")
public class  FaqBoardInsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top","/header.jsp");
		req.setAttribute("content","/faqboardY/faqinsert.jsp");
		req.setAttribute("nav","/adnav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/main").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String category=req.getParameter("category");
		String question=req.getParameter("question");
		String answer=req.getParameter("answer");
		BoardVo vo=new BoardVo(0, category, question, answer);
		BoardDao dao=new BoardDao();
		int n=dao.insert(vo);
		if(n>0) {
			req.setAttribute("code","success");
		}else {
			req.setAttribute("code","fail");
		}

		req.setAttribute("top","/header.jsp");
		req.setAttribute("content","/faqboardY/result.jsp");
		req.setAttribute("nav","/adnav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/main").forward(req, resp);
	}
	
}
















