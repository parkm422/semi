package com.semi.controller.orderY;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.basketY.BasketDao;
import com.semi.dao.memberY.MemberDao;
import com.semi.dao.orderY.OrderDao;
import com.semi.vo.memberY.MemberVo;
import com.semi.vo.orderY.OrderVo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@WebServlet("/orderY/orderinsert")
public class OrderInsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		MemberDao dao1=MemberDao.getInstance();
		ArrayList<MemberVo> list=dao1.list(id);
		System.out.println(list);
		
		req.setCharacterEncoding("utf-8");
		req.setAttribute("list",list);
		req.setAttribute("top","/header.jsp");
		req.setAttribute("content","/orderY/orderinsert.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		int amount=Integer.parseInt(req.getParameter("amount"));
		String status=req.getParameter("status");
		String deladd=req.getParameter("deladd");
		String delivery=req.getParameter("delivery");
		MemberDao dao1=MemberDao.getInstance();
		int mnum=dao1.select(id);
		OrderVo vo2=new OrderVo(0,mnum, amount, status, deladd, delivery, null);
		OrderDao dao=OrderDao.getInstance();
		int n=dao.insert(vo2);
		BasketDao dao2=BasketDao.getInstance();
		int m=dao2.delete(mnum);
		if(n>0 && m>0) {
			req.setAttribute("code","success");
		}else {
			req.setAttribute("code","fail");
		}

		req.setAttribute("top","/header.jsp");
		req.setAttribute("content","/orderY/result.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
}

