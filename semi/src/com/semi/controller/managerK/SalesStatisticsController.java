package com.semi.controller.managerK;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.semi.dao.managerK.ManagerDAO;
import com.semi.vo.productK.OrderInfoVO;

@WebServlet("/manager/salesStatistics")
public class SalesStatisticsController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		String startYear = request.getParameter("startYear");
		String startMonth = request.getParameter("startMonth");
		String startDay = request.getParameter("startDay");
		String startDate = startYear + "/" + startMonth + "/" + startDay;
		
		String endYear = request.getParameter("endYear");
		String endMonth = request.getParameter("endMonth");
		String endDay = request.getParameter("endDay");
		String endDate = endYear + "/" + endMonth + "/" + endDay;
		
		ManagerDAO managerDAO = ManagerDAO.getManagerDAO();
		ArrayList<OrderInfoVO> orderList = managerDAO.getSalesStatistics(startDate, endDate);
		
		int totalAmount = 0;
		for(OrderInfoVO i : orderList) {
			totalAmount = i.getAmount();
		}  
		request.setAttribute("totalAmount", totalAmount);
		
		PrintWriter pwriter = response.getWriter();
		JSONArray jArray = new JSONArray();
		jArray.put(orderList);
		pwriter.print(jArray);
	}
}
