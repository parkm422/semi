package com.semi.controller.orderY;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.orderY.OrderDao;
import com.semi.vo.orderY.OrderVo;


@WebServlet("/orderY/porderlist")
public class OrderListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String spageNum=req.getParameter("pageNum");	
		String field=req.getParameter("field");
		String keyword=req.getParameter("keyword");
		String id=req.getParameter("id");
		System.out.println(id);
	
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		OrderDao dao=OrderDao.getInstance();
		ArrayList<OrderVo> list=dao.list(id,startRow, endRow,field,keyword);
		int pageCount=(int)Math.ceil(dao.getCount(field,keyword)/10.0);	
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
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.setAttribute("field",field);
		req.setAttribute("keyword",keyword);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}