package com.semi.controller.memberP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.semi.dao.basketY.BasketDao;

@WebServlet("/member/basketupdate")
public class BasketUpdateServlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			
					
					int bnum = Integer.parseInt(req.getParameter("bnum"));
					int cnt=Integer.parseInt(req.getParameter("cnt"));			
					
					
					//장바구니 갯수 수정
					if(cnt!=0 && bnum!=0)
					{
						BasketDao dao=BasketDao.getInstance();
						int n=dao.update(cnt,bnum);
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
}
