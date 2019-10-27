package com.semi.controller.homeY;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.productP.ProductDAO;
import com.semi.vo.productP.List_img_joinVO;
@WebServlet("/main")
public class HomeServlet extends HttpServlet{

	ProductDAO productDao = ProductDAO.getProductDao();
	
	@Override
	public void init() throws ServletException {
	
		
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
			
				productDao.bakset_list_delete();
				System.out.println("장바구니 목록 삭제...");
				
			}
		};
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2019,9,27,21,18,0);
		
		timer.scheduleAtFixedRate(task, new Date(cal.getTimeInMillis()), 86400);
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String top=(String)req.getAttribute("top");
		String nav=(String)req.getAttribute("nav");
		String content=(String)req.getAttribute("content");
		String footer=(String)req.getAttribute("footer");
		
		if(top==null) {
			top="/header.jsp";
		}
		if(nav==null) {
			nav="/nav.jsp";
		}
		if(content==null) {
			content="/main.jsp";
		}
		if(footer==null) {
			footer="/footer.jsp";
		}
		
		//메인화면에 등록될 판매개수 가장 높은 5개 상품
		ArrayList<List_img_joinVO> hit = productDao.hit_item();
		
		req.setAttribute("hit", hit);
		
		//화폐 단위 ,(콤마)
		DecimalFormat dc = new DecimalFormat("###,###,###,###");
						
		req.setAttribute("dc", dc);
		
		req.setAttribute("top",top);
		req.setAttribute("nav",nav);
		req.setAttribute("content",content);
		req.setAttribute("footer",footer);
		getServletContext().setAttribute("cp",req.getContextPath());
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}










