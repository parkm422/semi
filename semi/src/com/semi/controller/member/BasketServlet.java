package com.semi.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.semi.dao.member.S_MemberDAO;
import com.semi.dao.product.ProductDAO;
import com.semi.vo.member.S_MemberVO;
import com.semi.vo.product.BasketVO;
import com.semi.vo.product.Product_ListVO;
@WebServlet("/member/basket")
public class BasketServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		String type = req.getParameter("type");
		System.out.println(type);
		if(type != null && type.equals("put")) {
			
			itemPut(req,resp);
			return;
		}
		
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
		
		ProductDAO productDao = ProductDAO.getProductDao();
		S_MemberDAO memDao = S_MemberDAO.getSmemberDao();
		
		S_MemberVO vo = memDao.select(id);
		
		Product_ListVO pvo = productDao.getDetail(inum);
		
		String pname = pvo.getPname();
		System.out.println(vo.getMnum());
		System.out.println(vo.getMnum());
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
