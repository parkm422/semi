package com.semi.controller.orderY;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.websocket.Session;

import com.semi.dao.basketY.BasketDao;
import com.semi.dao.managerP.ManagerDAO;
import com.semi.dao.memberP.S_MemberDAO;
import com.semi.dao.memberY.MemberDao;

import com.semi.dao.orderY.OrderDao;


import com.semi.dao.paymentl.PaymentDao;

import com.semi.dao.productP.ProductDAO;

import com.semi.vo.managerP.ViewVo;
import com.semi.vo.memberP.S_MemberVO;


import com.semi.dao.paymentl.PaymentDao;


import com.semi.vo.memberY.MemberVo;
import com.semi.vo.orderY.OrderVo;
import com.semi.vo.paymentl.PaymentVo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@WebServlet("/orderY/orderinsert")
public class OrderInsertServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");

		MemberDao dao1=MemberDao.getInstance();
		ArrayList<MemberVo> list=dao1.list(id);


		S_MemberDAO memberDao = S_MemberDAO.getSmemberDao();
		ProductDAO itemDao = ProductDAO.getProductDao();
		
		HttpSession session = req.getSession();
		
		String basketPageNum = req.getParameter("pageNum");
			
		int pageNum = 1;
		if(basketPageNum != null) {
			pageNum = Integer.parseInt(basketPageNum);
		}
		
		int startRow = 1+(pageNum-1)*5;
		int endRow = startRow+4;
		
		int startPageNum = ((pageNum-1)/5*5)+1;
		int endPageNum = startPageNum+4;
		
		S_MemberVO vo = memberDao.getMemberInfo(id);
		
		int basketPageCount = (int) Math.ceil(itemDao.getBasketCount(vo.getMnum())/5.0);
		
		if(endPageNum>basketPageCount) {
			endPageNum = basketPageCount;
		}
		
		int nn=0;
		ArrayList<HashMap<String, Object>> basketList1 = itemDao.getBasketList(vo.getMnum(),startRow,endRow);
		System.out.println(basketList1);
		for(int i=0;i<basketList1.size();i++) {
			System.out.println(basketList1.get(i).get("price"));
			nn+=(Integer)basketList1.get(i).get("price"); 
		}

		req.setAttribute("pageNum", pageNum);
		req.setAttribute("startRow", startRow);
		req.setAttribute("endRow", endRow);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("basketPageCount", basketPageCount);
		
		req.setAttribute("nn", nn);

		req.setAttribute("basketList1", basketList1);


		

		req.setCharacterEncoding("utf-8");
		req.setAttribute("list",list);
		req.setAttribute("top","/header.jsp");
		req.setAttribute("content","/orderY/orderinsert.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=(String)req.getSession().getAttribute("id");
		int amount=Integer.parseInt(req.getParameter("amount"));
		String status=req.getParameter("status");
		String deladd=req.getParameter("deladd");
		String delivery=req.getParameter("delivery");
		String getname=req.getParameter("getname");
		MemberDao dao1=MemberDao.getInstance();
		int mnum=dao1.select(id);

		
		
		
		if(mnum!=0) {
			//주문내역 삽입
			OrderVo vo2=new OrderVo(0,mnum, amount, status, deladd, delivery, null,getname);
			OrderDao dao=new OrderDao();
			int n=dao.insert(vo2);
			
			BasketDao dao2=BasketDao.getInstance();
			PaymentDao dao3=new PaymentDao();
			int mornum=dao3.select(mnum);
			int payamount=Integer.parseInt(req.getParameter("amount"));
			int enpay=Integer.parseInt(req.getParameter("amount"));
			PaymentVo vo=new PaymentVo(0, mornum, mnum, payamount, enpay, null);
			System.out.println(mornum);
			PaymentDao dao4=new PaymentDao();
			int n1=dao4.insert(vo);
			MemberDao dao5=MemberDao.getInstance();
			ArrayList<MemberVo> list=dao1.list(id);

			S_MemberDAO memberDao = S_MemberDAO.getSmemberDao();
			ProductDAO itemDao = ProductDAO.getProductDao();
			
			HttpSession session = req.getSession();
			
			String basketPageNum = req.getParameter("pageNum");
				
			int pageNum = 1;
			if(basketPageNum != null) {
				pageNum = Integer.parseInt(basketPageNum);
			}
			
			int startRow = 1+(pageNum-1)*5;
			int endRow = startRow+4;
			
			int startPageNum = ((pageNum-1)/5*5)+1;
			int endPageNum = startPageNum+4;
			
			S_MemberVO vo3 = memberDao.getMemberInfo(id);
			
			int basketPageCount = (int) Math.ceil(itemDao.getBasketCount(vo3.getMnum())/5.0);
			
			if(endPageNum>basketPageCount) {
				endPageNum = basketPageCount;
			}
			OrderDao dao8=new OrderDao();
			int lastornum=dao8.select();
			ArrayList<HashMap<String, Object>> basketList1 = itemDao.getBasketList(vo.getMnum());
			ManagerDAO dao7=ManagerDAO.getManagerDao();
			
			int m=dao2.delete(mnum);
			//주문디테일 삽입
			if(n>0 && m>0) {
				req.setAttribute("code","success");
				for (int i = 0; i < basketList1.size(); i++) {
					ViewVo vo4= new ViewVo(0,lastornum,(int)basketList1.get(i).get("inum"),(String)basketList1.get(i).get("pname"), (int)basketList1.get(i).get("psize"),(String)basketList1.get(i).get("colorname"), (int)basketList1.get(i).get("cnt"));
					int ss=dao7.insert(vo4);
					}
			}else {
				req.setAttribute("code","fail");
			}

		}
		
		
		
		
		req.setAttribute("top","/header.jsp");
		req.setAttribute("content","/orderY/result.jsp");
		req.setAttribute("nav","/nav.jsp");
		req.setAttribute("footer","/footer.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
}

