package com.semi.controller.paymentl;

import java.io.IOException;
import java.text.DecimalFormat;
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
		String[] imgs=(String[])req.getSession().getAttribute("imgs");
		req.getSession().removeAttribute("imgs");
		int amount =Integer.parseInt(req.getParameter("amount"));
		String getname=req.getParameter("getname");
		String status=req.getParameter("status");
		String deladd=req.getParameter("deladd");
		String delivery=req.getParameter("delivery");
		String[] pname=req.getParameterValues("pname");
		String[] cnt=req.getParameterValues("cnt");
		String[] price=req.getParameterValues("price");
		System.out.println(cnt);
		ArrayList<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<pname.length;i++) {
			HashMap<String,Object> map=new HashMap<String, Object>();
			map.put("pname", pname[i]);
			map.put("cnt", cnt[i]);
			map.put("price", price[i]);
			map.put("imgs",imgs[i]);
			list.add(map);
			
		}
		DecimalFormat dc = new DecimalFormat("###,###,###,###");
		
		req.setAttribute("dc", dc);
		
		//req.setAttribute("pname",pname);
		//req.setAttribute("cnt",cnt);
		//req.setAttribute("price",price);
		req.setAttribute("getname",getname);
		req.setAttribute("amount",amount);
		req.setAttribute("status",status);
		req.setAttribute("delivery",delivery);
		req.setAttribute("deladd",deladd);
		req.setAttribute("top", "/header.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("content","/paymentl/payment.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.setAttribute("list",list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
