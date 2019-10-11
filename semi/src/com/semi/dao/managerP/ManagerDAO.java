package com.semi.dao.managerP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public class ManagerDAO {
	
	private static ManagerDAO managerdao = new ManagerDAO();
	
	private ManagerDAO() {
		
	}
	public static ManagerDAO getManagerDao() {
		return managerdao;
	}
	
	public boolean exist(String id, String pwd) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql ="SELECT * FROM MANAGER WHERE ID=? AND PWD=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return false;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
}
