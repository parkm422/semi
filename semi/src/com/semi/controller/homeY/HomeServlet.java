package com.semi.controller.homeY;

import java.io.IOException;
import java.text.DecimalFormat;
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
@WebServlet("/main")
public class HomeServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
	
		ProductDAO productDao = ProductDAO.getProductDao();
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
			
				productDao.basket_list_delete();
				System.out.println("장바구니 목록 삭제...");
				
			}
		};
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2019,9,24,23,5,0);
		
		timer.scheduleAtFixedRate(task, new Date(), 5000);
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String top=(String)req.getAttribute("top");
		String nav=(String)req.getAttribute("nav");
		String content=(String)req.getAttribute("content");
		String footer=(String)req.getAttribute("footer");
		//
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










