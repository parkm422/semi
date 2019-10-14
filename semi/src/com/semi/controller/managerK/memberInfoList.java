package com.semi.controller.managerK;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.managerK.ManagerDAO;
import com.semi.vo.memberP.S_MemberVO;


@WebServlet("/manager/memberInfoList")
public class memberInfoList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ManagerDAO dao = ManagerDAO.getManagerDAO();
		ArrayList<S_MemberVO> list  = dao.getMemberInfoList();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (S_MemberVO i : list) {
			int j = 1;
			String joinDate = transFormat.format(i.getJoindate());
			request.setAttribute("joinDate"+j, joinDate);
			j++;
		}
		request.setAttribute("listSize", list.size());
		request.setAttribute("list", list); 
		request.getRequestDispatcher("/manager/memberInfoList.jsp").forward(request, response);
	}
}
