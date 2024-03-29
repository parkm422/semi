package com.semi.controller.productP;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.boardK.QnABoardDAO;
import com.semi.boardK.QnABoardVO;
import com.semi.dao.boardP.ReviewDAO;
import com.semi.dao.productP.ProductDAO;
import com.semi.vo.boardP.ReviewChildVO;
import com.semi.vo.boardP.ReviewVO;
import com.semi.vo.productP.Product_ImgVO;
import com.semi.vo.productP.Product_ListVO;

@WebServlet("/product/detail")
public class DetailServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int inum = Integer.parseInt(req.getParameter("inum"));

		// 리뷰게시판 페이지 얻어오기
		String spageNum = req.getParameter("pageNum");
		
		String sub = req.getParameter("sub");
		
		//상품 DAO
		ProductDAO dao = ProductDAO.getProductDao();
		//리뷰게시판 DAO
		ReviewDAO reviewDao = ReviewDAO.getReviewDao();
		
		//상품 정보 얻어오기
		Product_ListVO vo = dao.getDetail(inum);
		
		// 해당 상품 평균 평점 얻어오기
		int rating_avg = dao.getRating(inum);
		
		//해당 상품 이미지 얻어오기
		ArrayList<Product_ImgVO> imgList = dao.getImg(inum);
		
		//상품 사이즈표 얻어오기
		//상품 사이즈표 얻어오기는 오라클 distinct사용해서 중복제거하기(아직 처리안함)
		ArrayList<Integer> sizeList = dao.getSize(sub);
		
		req.setAttribute("vo", vo);
		req.setAttribute("imgList", imgList);
		req.setAttribute("sizeList", sizeList);
		req.setAttribute("rating_avg", rating_avg);
		
		int pageNum = 1;

		if (spageNum != null) {
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
		
		// QnA게시판 목록 처리
		// 상품번호 inum은 공유
		String qnaSPageNum = req.getParameter("qnaPageNum");
		int qnaPageNum = 1;
		if (qnaSPageNum != null) {
			qnaPageNum = Integer.parseInt(qnaSPageNum);
		}
		int qnaEndRow = qnaPageNum * 10;
		int qnaStartRow = qnaEndRow - 9;
		QnABoardDAO qnaDAO = QnABoardDAO.getQnABoardDAo();
		ArrayList<QnABoardVO> qnaList = qnaDAO.getPostList(inum, qnaStartRow, qnaEndRow);
		int qnaTotalPage = (int) Math.ceil(qnaDAO.getTotalPost(inum) / 10.0);
		int qnastartPageNum = ((qnaPageNum - 1) / 10 * 10) + 1;
		int qnaendPageNum = qnastartPageNum + 9;
		if (qnaendPageNum > qnaTotalPage) {
			qnaendPageNum = qnaTotalPage;
		}

		req.setAttribute("list", qnaList);
		req.setAttribute("qnaTotalPage", qnaTotalPage);
		req.setAttribute("qnastartPageNum", qnastartPageNum);
		req.setAttribute("qnaendPageNum", qnaendPageNum);
		req.setAttribute("qnaPageNum", qnaPageNum);

		
		
		//리뷰자식게시판의 부모 번호 얻어오기
		ArrayList<Integer> rnum = new ArrayList<Integer>();
		
		for(ReviewVO n : reviewList) {
			rnum.add(n.getRnum());
		}
		
		ArrayList<ReviewChildVO> reviewchild = reviewDao.reviewChild_list(rnum);
		//리뷰자식게시판 목록 담기
		req.setAttribute("reviewchild", reviewchild);
		

		
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
		
		req.getRequestDispatcher("/main").forward(req, resp);
		

	}
}
