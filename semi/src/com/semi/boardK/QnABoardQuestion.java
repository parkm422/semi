package com.semi.boardK;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/writeQnAQuestion")
public class QnABoardQuestion extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/writeQnAQuestion.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inum = Integer.parseInt(request.getParameter("inum"));
		String sub = request.getParameter("sub");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		QnABoardDAO dao = QnABoardDAO.getQnABoardDAO();
		dao.insertQuestion(inum, writer, title, content);
		
		request.setAttribute("sub", sub);
		request.setAttribute("top", "/header.jsp");
		request.setAttribute("nav", "/nav.jsp");
		request.setAttribute("content", "/product/product_detail?inum="+inum+"&sub="+sub);
		request.setAttribute("footer", "/footer.jsp");
		
		request.getRequestDispatcher("/main").forward(request, response);
	}
}
