package com.semi.controller.boardl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.boardl.Ono_EnquiryDao;
import com.semi.vo.boardl.Ono_EnquiryVO;
@WebServlet("/board/detail")
public class detailServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int ennum=Integer.parseInt(req.getParameter("ennum"));
		Ono_EnquiryDao dao=new Ono_EnquiryDao();
		Ono_EnquiryVO vo=dao.detail(ennum);
		req.setAttribute("vo",vo);
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("content","/board/detail.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}
