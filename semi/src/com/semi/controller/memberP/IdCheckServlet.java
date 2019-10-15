package com.semi.controller.memberP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import jdbc.JdbcUtil;
@WebServlet("/member/idcheck")
public class IdCheckServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		boolean find = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = JdbcUtil.getConn();
			String sql = "SELECT * FROM S_MEMBERS WHERE ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				find = true;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}finally{
			JdbcUtil.close(con, pstmt, rs);
		}
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject json = new JSONObject();
		PrintWriter pw = resp.getWriter();
		System.out.println(find);
		json.put("check",find);
		pw.print(json);
	}
}
