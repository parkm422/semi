package com.semi.controller.orderY;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.memberY.MemberDao;
import com.semi.dao.orderY.OrderDao;
import com.semi.vo.orderY.OrderVo;


@WebServlet("/orderY/porderlist")
public class OrderListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		System.out.println("리스트페이지서버릿");
		if(id==null || id=="") {
			req.setAttribute("top","/header.jsp");
			req.setAttribute("content","/member/login.jsp");
			req.setAttribute("nav","/nav.jsp");
			req.setAttribute("footer","/footer.jsp");
			req.getRequestDispatcher("/main").forward(req, resp);
		}
		String spageNum = req.getParameter("pageNum");
		int pageNum = 1;
		if (spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		int endRow = pageNum * 10;
		int startRow = endRow - 9;
		
		OrderDao dao=new OrderDao();
		MemberDao dao1=MemberDao.getInstance();
		
		int mnum=dao1.select(id);
		int pageCount = (int) (Math.ceil(dao.getCount(mnum) / 10.0));
		// 시작페이지 번호
		int startPageNum = ((pageNum - 1) / 10 * 10) + 1;
		// 끝페이지 번호
		int endPageNum = startPageNum + 9;
		if (endPageNum > pageCount) {
			endPageNum = pageCount;
		}
		
		System.out.println(pageCount);
		ArrayList<OrderVo> list=dao.list(mnum,startRow, endRow);
		int startPage=(pageNum-1)/10*10+1;
		int endPage=startPage+9;
		if(endPage>pageCount) {
			endPage=pageCount;
		}
		req.setAttribute("list",list);
		req.setAttribute("pageCount",pageCount);
		req.setAttribute("startPage",startPage);
		req.setAttribute("endPage",endPage);
		req.setAttribute("pageNum",pageNum);
		req.setAttribute("top","/header.jsp");
		req.setAttribute("content","/orderY/porderlist.jsp");
		req.setAttribute("nav","/mypagenav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/main").forward(req, resp);
	}
}