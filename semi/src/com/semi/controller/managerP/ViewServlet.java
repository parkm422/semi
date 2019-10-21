package com.semi.controller.managerP;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.deliveryl.DeliveryDao;
import com.semi.dao.managerP.ManagerDAO;
import com.semi.dao.productP.CategoryDAO;
import com.semi.vo.managerP.ViewVo;
@WebServlet("/manager/view")
public class ViewServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum = req.getParameter("pageNum");
		int pageNum = 1;
		if (spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		int endRow = pageNum * 10;
		int startRow = endRow - 9;
		ManagerDAO dao = ManagerDAO.getManagerDao();
		ArrayList<ViewVo> list = dao.list(startRow, endRow);
		// 전체페이지 갯수 구하기
		DeliveryDao dao1=new DeliveryDao();
		int pageCount = (int) (Math.ceil(dao1.getCount() / 10.0));
		// 시작페이지 번호
		int startPageNum = ((pageNum - 1) / 10 * 10) + 1;
		// 끝페이지 번호
		int endPageNum = startPageNum + 9;
		if (endPageNum > pageCount) {
			endPageNum = pageCount;
		}
		
		DecimalFormat dc = new DecimalFormat("###,###,###,###");
		
		req.setAttribute("dc", dc);
		
		req.setAttribute("list",list);
		req.setAttribute("pageCount",pageCount);
		req.setAttribute("pageNum",pageNum);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("content","/manager/view.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
