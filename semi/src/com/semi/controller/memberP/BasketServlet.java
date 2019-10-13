package com.semi.controller.memberP;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.semi.dao.memberP.S_MemberDAO;
import com.semi.dao.productP.ProductDAO;
import com.semi.vo.memberP.S_MemberVO;
import com.semi.vo.productP.BasketVO;
import com.semi.vo.productP.Product_ListVO;
@WebServlet("/member/basket")
public class BasketServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		String type = req.getParameter("type");
		
		String id = req.getParameter("id");
		
		if(type != null && type.equals("put")) {
			
			itemPut(req,resp);
			return;
		}
		
		S_MemberDAO dao = S_MemberDAO.getSmemberDao();
		
		S_MemberVO vo = dao.getMemberInfo(id);
		
		ProductDAO itemDao = ProductDAO.getProductDao();
		
		ArrayList<HashMap<String, Object>> basketList = itemDao.getBasketList(vo.getMnum());
		
		req.setAttribute("basketList", basketList);
		
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/member/basket.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
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
