package com.semi.controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.product.ProductDAO;
import com.semi.vo.product.Product_ListVO;

@WebServlet("/product/list")
public class ProductServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String spageNum = req.getParameter("pageNum");
		
		int pageNum = 1;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		
		int startRow = (pageNum-1)*5+1;
		int endRow = startRow+4;
		
		ProductDAO dao = ProductDAO.getProductDao();
		
		ArrayList<Product_ListVO> list = dao.list(startRow, endRow);
		int pageCount = (int)Math.ceil(dao.getCount()/5.0);
		
		int startPageNum = ((pageNum-1)/4*4)+1;
		int endPageNum = startPageNum+3;
		
		req.setAttribute("list", list);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/product/list.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
