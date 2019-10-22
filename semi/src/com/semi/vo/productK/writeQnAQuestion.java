package com.semi.vo.productK;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcUtil;

@WebServlet("/writeQnAQuestion")
public class writeQnAQuestion extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/product/writeQnAQuestion.jsp").forward(request, response);
	}
	
	@Override
	protected int doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inum = Integer.parseInt(request.getParameter("inum"));
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("INSERT INTO item_qna VALUES()");
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
}
