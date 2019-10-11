package com.semi.controller.productP;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.boardP.ReviewDAO;
import com.semi.dao.productP.ProductDAO;
import com.semi.vo.boardP.ReviewVO;
import com.semi.vo.productP.Product_ImgVO;
import com.semi.vo.productP.Product_ListVO;
@WebServlet("/product/detail")
public class DetailServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int inum = Integer.parseInt(req.getParameter("inum"));
		
		String spageNum = req.getParameter("pageNum");
		
		int pageNum = 1;
		
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		
		int startRow = 1+(pageNum-1)*10;
		int endRow = startRow + 9;
		
		ProductDAO dao = ProductDAO.getProductDao();
		
		Product_ListVO vo = dao.getDetail(inum);
		
		ArrayList<Product_ImgVO> imgList = dao.getImg(inum);
		//System.out.println(inum);
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/product/product_detail.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.setAttribute("vo", vo);
		req.setAttribute("imgList", imgList);
		
		
		
		ReviewDAO reviewDao = ReviewDAO.getReviewDao();
		
		ArrayList<ReviewVO> reviewList = reviewDao.review_list(startRow, endRow, inum);
		
		req.setAttribute("reviewList", reviewList);
		
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}









