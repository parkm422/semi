package com.semi.controller.paymentl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.memberP.S_MemberDAO;
import com.semi.dao.memberY.MemberDao;
import com.semi.dao.paymentl.PaymentDao;
import com.semi.dao.productP.ProductDAO;
import com.semi.vo.memberP.S_MemberVO;
import com.semi.vo.memberY.MemberVo;
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
		
		MemberDao dao1=MemberDao.getInstance();
		ArrayList<MemberVo> list=dao1.list(id);

		S_MemberDAO memberDao = S_MemberDAO.getSmemberDao();
		ProductDAO itemDao = ProductDAO.getProductDao();
		
		HttpSession session = req.getSession();
		
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
