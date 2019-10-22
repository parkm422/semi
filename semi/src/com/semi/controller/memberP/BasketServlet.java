package com.semi.controller.memberP;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.semi.dao.basketY.BasketDao;
import com.semi.dao.memberP.S_MemberDAO;
import com.semi.dao.productP.ProductDAO;
import com.semi.vo.memberP.S_MemberVO;
import com.semi.vo.productP.BasketVO;
import com.semi.vo.productP.Product_ListVO;
@WebServlet("/member/basket")
public class BasketServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//장바구니에서 삭제
				
				int bnum = Integer.parseInt(req.getParameter("bnum"));
				
				
				if(bnum!=0 ) {
					ProductDAO dao=ProductDAO.getProductDao();
					int n=dao.delete(bnum);
					resp.setContentType("text/plain;charset=utf-8");
					PrintWriter pw=resp.getWriter();
					JSONObject json=new JSONObject();
					if(n>0) {
						json.put("code","success");
					}else {
						json.put("code","fail");
					}
					pw.print(json);
				}
	}
				
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String type = req.getParameter("type");
	
		//type값이 put이면 장바구니 담기
		if(type != null && type.equals("put")) {
					
			itemPut(req,resp);
			return;
		}
		
		S_MemberDAO memberDao = S_MemberDAO.getSmemberDao();
		ProductDAO itemDao = ProductDAO.getProductDao();
		
		HttpSession session = req.getSession();
		
		String id = (String) session.getAttribute("id");
		
		String basketPageNum = req.getParameter("pageNum");
			
		int pageNum = 1;
		if(basketPageNum != null) {
			pageNum = Integer.parseInt(basketPageNum);
		}
		
		int startRow = 1+(pageNum-1)*5;
		int endRow = startRow+4;
		
		int startPageNum = ((pageNum-1)/5*5)+1;
		int endPageNum = startPageNum+4;
		
		S_MemberVO vo = memberDao.getMemberInfo(id);
		
		int basketPageCount = (int) Math.ceil(itemDao.getBasketCount(vo.getMnum())/5.0);
		
		if(endPageNum>basketPageCount) {
			endPageNum = basketPageCount;
		}

		

		ArrayList<HashMap<String, Object>> basketList = itemDao.getBasketList(vo.getMnum(),startRow,endRow);
		
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("startRow", startRow);
		req.setAttribute("endRow", endRow);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("basketPageCount", basketPageCount);
		
		
		req.setAttribute("basketList", basketList);
		
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/member/basket.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/main").forward(req, resp);
	}
	
	//장바구니 담기 메소드
	protected void itemPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		int inum = Integer.parseInt(req.getParameter("inum"));
		
		// 상품 DAO 객체 생성
		ProductDAO productDao = ProductDAO.getProductDao();
		
		// 회원 DAO 객체 생성
		S_MemberDAO memDao = S_MemberDAO.getSmemberDao();
		
		S_MemberVO vo = memDao.getMemberInfo(id);
		
		Product_ListVO pvo = productDao.getDetail(inum);
		
		String pname = pvo.getPname();

		int mnum = vo.getMnum();
		
		BasketVO basket = new BasketVO(0, mnum, inum, pname, 1, null);
		
		int n = productDao.basketInsert(basket);
		JSONObject json = new JSONObject();
		PrintWriter pw = resp.getWriter();
		if(n>0) {
			json.put("put", "success");
		}else {
			json.put("put", "fail");
		}
		pw.print(json.toString());
	}
	
}
