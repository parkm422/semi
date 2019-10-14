package com.semi.controller.boardl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.boardl.Ono_EnquiryDao;
import com.semi.vo.boardl.Ono_EnquiryVO;
@WebServlet("/board/1and1board")
public class boardServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/board/1and1board.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String writer=(String)session.getAttribute("id");
		
		req.setCharacterEncoding("utf-8");
		
		String category=req.getParameter("ask");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		Ono_EnquiryVO vo=new Ono_EnquiryVO(0, category, writer, title, content, null);
		Ono_EnquiryDao dao=new Ono_EnquiryDao();
		int n=dao.insert(vo);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/main");
		}
	}
}
