package com.semi.controller.managerP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.managerP.ManagerDAO;
@WebServlet("/managerP/deliveryup")
public class viewupServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int ornumm=Integer.parseInt(req.getParameter("ornumm"));
		String delivery=req.getParameter("delivery");
		ManagerDAO dao=ManagerDAO.getManagerDao();
		if(delivery.equals("준비중")) {
		int n=dao.viewup(ornumm);
		if(n>0) {
			resp.sendRedirect(req.getContextPath()+"/manager/view");
		}
		}else {
			int n=dao.viewups(ornumm);
			if(n>0) {
				resp.sendRedirect(req.getContextPath()+"/manager/view");
			}
		}
		
	}
}
