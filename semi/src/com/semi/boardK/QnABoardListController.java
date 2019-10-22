package com.semi.boardK;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/item_qna")
public class QnABoardListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String spageNum = request.getParameter("pageNum");
		String snum = request.getParameter("inum");
		int inum = Integer.parseInt(snum);
		int pageNum = 1;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		int endRow = pageNum * 10;
		int startRow = endRow - 9;
		QnABoardDAO dao = QnABoardDAO.getQnABoardDAo();
		ArrayList<QnABoardVO> list = dao.getPostList(inum, startRow, endRow);
		
		
		int totalPage = (int)Math.ceil(dao.getTotalPost(inum) / 10.0);
		int startPageNum = ((pageNum - 1) / 10 * 10) + 1;
		int endPageNum = startPageNum + 9;
		if (endPageNum > totalPage) {
			endPageNum = totalPage;
		}
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("pageNum", pageNum);
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
