package com.semi.controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.product.ProductDAO;
import com.semi.vo.product.Product_ImgVO;
import com.semi.vo.product.Product_ListVO;
@WebServlet("/product/detail")
public class DetailServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int inum = Integer.parseInt(req.getParameter("inum"));
		
		ProductDAO dao = ProductDAO.getProductDao();
		
		Product_ListVO vo = dao.getDetail(inum);
		
		ArrayList<Product_ImgVO> imgList = dao.getImg(inum);
		System.out.println(inum);
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/product/product_detail.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.setAttribute("vo", vo);
		req.setAttribute("imgList", imgList);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}









