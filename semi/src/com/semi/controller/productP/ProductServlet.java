package com.semi.controller.productP;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.productP.ProductDAO;
import com.semi.vo.productP.List_img_joinVO;
import com.semi.vo.productP.Product_ListVO;

@WebServlet("/product/list")
public class ProductServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String spageNum = req.getParameter("pageNum");
		String major = req.getParameter("major");
		String sub = req.getParameter("sub");
		
		int pageNum = 1;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		
		//System.out.println(pageNum);
		
		int startRow = 1+(pageNum-1)*30;
		int endRow = startRow+29;
		
		ProductDAO dao = ProductDAO.getProductDao();
		
		ArrayList<List_img_joinVO> list = dao.list(startRow, endRow,major,sub);
		int pageCount = (int)Math.ceil(dao.getCount()/30.0);
		
		int startPageNum = ((pageNum-1)/4*4)+1;
		int endPageNum = startPageNum+4;
		
		if(endPageNum>pageCount) {
			endPageNum = pageCount;
		}
		
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
