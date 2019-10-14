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
		
		//리뷰게시판 페이지 얻어오기
		String spageNum = req.getParameter("pageNum");
		String sub = req.getParameter("sub");
		
		//상품 DAO
		ProductDAO dao = ProductDAO.getProductDao();
		//리뷰게시판 DAO
		ReviewDAO reviewDao = ReviewDAO.getReviewDao();
		
		//상품 정보 얻어오기
		Product_ListVO vo = dao.getDetail(inum);
		
		//해당 상품 이미지 얻어오기
		ArrayList<Product_ImgVO> imgList = dao.getImg(inum);
		
		//상품 사이즈표 얻어오기
		//상품 사이즈표 얻어오기는 오라클 distinct사용해서 중복제거하기(아직 처리안함)
		ArrayList<Integer> sizeList = dao.getSize(sub);
		
		req.setAttribute("vo", vo);
		req.setAttribute("imgList", imgList);
		req.setAttribute("sizeList", sizeList);
		
		
		int pageNum = 1;
		
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		
		int startRow = 1+(pageNum-1)*5;
		int endRow = startRow + 4;
		
		int reviewPageCount = (int) Math.ceil(reviewDao.getReviewCount(inum)/5.0);
		
		int startPageNum = ((pageNum-1)/5*5)+1;
		int endPageNum = startPageNum+4;
		
		if(endPageNum>reviewPageCount) {
			endPageNum = reviewPageCount;
		}
		
		//리뷰게시판 목록 얻어오기
		ArrayList<ReviewVO> reviewList = reviewDao.review_list(startRow, endRow, inum);
		
		//리뷰게시판 목록 담기
		req.setAttribute("reviewList", reviewList);
		
		//리뷰게시판 페이징처리 담기
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("startRow", startRow);
		req.setAttribute("endRow", endRow);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("reviewPageCount", reviewPageCount);
		
		//레이아웃 페이지 담기
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/product/product_detail.jsp");
		req.setAttribute("footer", "/footer.jsp");

		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}









