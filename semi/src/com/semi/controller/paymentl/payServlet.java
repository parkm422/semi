package com.semi.controller.paymentl;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.paymentl.PaymentDao;
import com.semi.dao.productP.ProductDAO;
import com.semi.vo.paymentl.PaymentVo;
import com.semi.vo.product.PaymentVO;
import com.semi.vo.productP.Product_ListVO;
@WebServlet("/paymentl/pay")
public class payServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=(String)req.getSession().getAttribute("id");
		int amount =Integer.parseInt(req.getParameter("amount"));
		String getname=req.getParameter("getname");
		String status=req.getParameter("status");
		String deladd=req.getParameter("deladd");
		String delivery=req.getParameter("delivery");
		
	
		req.setAttribute("getname",getname);
		req.setAttribute("amount",amount);
		req.setAttribute("status",status);
		req.setAttribute("delivery",delivery);
		req.setAttribute("deladd",deladd);
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("content","/paymentl/payment.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
