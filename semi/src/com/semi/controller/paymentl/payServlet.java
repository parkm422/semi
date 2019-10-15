package com.semi.controller.paymentl;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.productP.ProductDAO;
import com.semi.vo.productP.Product_ListVO;
@WebServlet("/paymentl/pay")
public class payServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String price = req.getParameter("price");
		System.out.println(price);
		//int price=Integer.parseInt();
		req.setAttribute("price",price);
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("content","/paymentl/payment.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
