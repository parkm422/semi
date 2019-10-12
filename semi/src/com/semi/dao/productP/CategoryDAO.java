package com.semi.dao.productP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;

public class CategoryDAO {
	
	private static CategoryDAO categoryDao = new CategoryDAO();
	
	private CategoryDAO() {
		
	}
	public static CategoryDAO getCategoryDao() {
		return categoryDao;
	}
	
	//대분류명 얻어오기
	public ArrayList<String> getM_category(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT M_CATEGORY FROM MAJOR_CATEGORY";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<String> mc_list = new ArrayList<String>();
			while(rs.next()) {
				
				String m_category = rs.getString("m_category");
				
				mc_list.add(m_category);
				
			}
			return mc_list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	//소분류명 얻어오기
	public ArrayList<String> getS_category(String major){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			System.out.println(major);
			String sql = "SELECT S.S_CATEGORY FROM SUB_CATEGORY S,MAJOR_CATEGORY M WHERE S.MCNUM=M.MCNUM AND M.M_CATEGORY=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, major);
			rs = pstmt.executeQuery();
			ArrayList<String> sub = new ArrayList<String>();
			while(rs.next()) {
				
				String s_category = rs.getString("s_category");
				
				sub.add(s_category);
			}
			return sub;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	// 서브카테고리명에 따라 사이즈 얻어오기
	public ArrayList<Integer> getSize(String sub){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT PSIZE FROM PRODUCT_SIZE PS,SUB_CATEGORY S WHERE PS.SCNUM=S.SCNUM AND S.S_CATEGORY=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sub);
			rs = pstmt.executeQuery();
			ArrayList<Integer> sizeList = new ArrayList<Integer>();
			while(rs.next()) {
				
				int psize = rs.getInt("psize");
				
				sizeList.add(psize);
			}
			return sizeList;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	// 색상명 얻어오기
	public ArrayList<String> getColor(int size, String sub){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT COLORNAME FROM COLOR C,PRODUCT_SIZE PS,SUB_CATEGORY SUB " + 
					"WHERE C.SIZENUM=PS.SIZENUM AND PS.SCNUM=SUB.SCNUM AND SUB.S_CATEGORY=? AND PS.PSIZE=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sub);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			ArrayList<String> colorList = new ArrayList<String>();
			while(rs.next()) {
				
				String colorname = rs.getString("colorname");
				
				colorList.add(colorname);
			}
			return colorList;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
}






