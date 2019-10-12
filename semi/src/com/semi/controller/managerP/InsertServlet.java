package com.semi.controller.managerP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.dao.productP.CategoryDAO;
import com.semi.dao.productP.ProductDAO;
import com.semi.vo.productP.Product_ListVO;
@WebServlet("/manager/insert")
public class InsertServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		CategoryDAO dao = CategoryDAO.getCategoryDao();
		ArrayList<String> mcategory = dao.getM_category();
		
		req.setAttribute("mcategory", mcategory);
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav", "/nav.jsp");
		req.setAttribute("content", "/manager/insert.jsp");
		req.setAttribute("footer", "/footer.jsp");
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		
		String path = context.getRealPath("/upload");
		MultipartRequest mr = new MultipartRequest(
					req,
					path,
					1024*1024*5,
					"utf-8",
					new DefaultFileRenamePolicy()
		);
		System.out.println(path);
		
		String pname = mr.getParameter("pname");
		int price = Integer.parseInt(mr.getParameter("price"));
		int cnt = Integer.parseInt(mr.getParameter("cnt"));
		String orgfilename = mr.getOriginalFileName("pimg");
		String savefilename = mr.getFilesystemName("pimg");
		
		String major = mr.getParameter("major");
		String sub = mr.getParameter("sub");
		int size = Integer.parseInt(mr.getParameter("size"));
		String color = mr.getParameter("color");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("major",major);
		map.put("sub",sub);
		map.put("size",size);
		map.put("color",color);
		
		System.out.println((String)map.get("major"));
		System.out.println((String)map.get("sub"));
		System.out.println((int)map.get("size"));
		System.out.println((String)map.get("color"));
		
		CategoryDAO categorydao = CategoryDAO.getCategoryDao();
		
		String cnum = categorydao.getMapColor(map);
		
		Product_ListVO vo = new Product_ListVO(0, cnum, pname, price, cnt, 0);
		ProductDAO dao = ProductDAO.getProductDao();
		
		int n = dao.productInsert(vo, orgfilename, savefilename);
		
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/main");
		}
	}
}
