package com.semi.controller.memberP;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.dao.boardP.ReviewDAO;
import com.semi.dao.productP.ProductDAO;
import com.semi.vo.boardP.ReviewVO;
import com.semi.vo.productP.Product_ListVO;
@WebServlet("/member/review_insert")
public class Review_InsertServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int inum = Integer.parseInt(req.getParameter("inum"));
		
		req.setAttribute("inum", inum);
		
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/adnav.jsp");
		req.setAttribute("content", "/member/review_insert.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/main").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ServletContext application = req.getServletContext();
		
		String saveDirectory = application.getRealPath("/upload");//업로드할 디렉토리
		MultipartRequest mr = new MultipartRequest(
				req,// request객체
				saveDirectory,// 업로드할 디렉토리 경로
				1024*1024*5, // 최대 업로드 크기(byte단위 -> 5mb로 설정함)
				"utf-8", // 인코딩방식
				new DefaultFileRenamePolicy());
		
		int inum = Integer.parseInt(mr.getParameter("inum"));
		int rating = Integer.parseInt(mr.getParameter("rating"));
		
		String writer = (String)req.getSession().getAttribute("id");
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		
		String orgfilename = mr.getOriginalFileName("file");
		String savefilename = mr.getFilesystemName("file");
		
		// 상품dao객체 생성
		ProductDAO productDao = ProductDAO.getProductDao();
		
		Product_ListVO itemVO = productDao.getDetail(inum);
		
		// 상품가격의 1% 포인트로 적립
		int point = (int) Math.round(itemVO.getPrice()/100.0);
		
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		// 리뷰 정보 VO에 담아서 저장
		ReviewVO vo = new ReviewVO(0, inum, writer, title, content, orgfilename, savefilename, rating);
		
		// 리뷰DAO객체 생성
		ReviewDAO reviewDao = ReviewDAO.getReviewDao();
		
		int n = reviewDao.review_Insert(vo,point,id);
		
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/main");
		}
	}
}
