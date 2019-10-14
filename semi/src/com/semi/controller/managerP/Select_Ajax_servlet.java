package com.semi.controller.managerP;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.semi.dao.productP.CategoryDAO;

@WebServlet("/manager/select")
public class Select_Ajax_servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String type = req.getParameter("type");
		String choice = req.getParameter("choice");
		String sub = req.getParameter("sub");
		
		if (type != null && type.equals("sub")) {
			
			sub(req, resp, choice);

		} else if (type != null && type.equals("size")) {

			size(req, resp, choice);

		} else if (type != null && type.equals("color")) {
			
			color(req, resp, choice,sub);
		}

	}

	protected void sub(HttpServletRequest req, HttpServletResponse resp, String choice) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		CategoryDAO dao = CategoryDAO.getCategoryDao();

		ArrayList<String> sub = dao.getS_category(choice);
		
		/*
		for(String s : sub) {
			System.out.println(s);
		}
		*/
		
		resp.setContentType("text/plain; charset=utf-8");
		
		JSONArray json = new JSONArray();
		PrintWriter pw = resp.getWriter();
		
		
		
		
		json.put(sub);
		//System.out.println(json);
		pw.print(json);

	}

	protected void size(HttpServletRequest req, HttpServletResponse resp, String choice) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		CategoryDAO dao = CategoryDAO.getCategoryDao();
		
		ArrayList<Integer> sizeList = dao.getSize(choice);
		
		resp.setContentType("text/plain; charset=utf-8");
		
		JSONArray json = new JSONArray();
		PrintWriter pw = resp.getWriter();
		
		json.put(sizeList);
		
		pw.print(json);
	}

	protected void color(HttpServletRequest req, HttpServletResponse resp, String choice, String sub) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		CategoryDAO dao = CategoryDAO.getCategoryDao();
		
		ArrayList<String> colorList = dao.getColor(Integer.parseInt(choice),sub);
		
		resp.setContentType("text/plain; charset=utf-8");
		
		JSONArray json = new JSONArray();
		PrintWriter pw = resp.getWriter();
		
		
		
		
		json.put(colorList);
		//System.out.println(json);
		pw.print(json);
	}
}
