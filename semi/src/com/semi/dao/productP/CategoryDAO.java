package com.semi.dao.productP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import jdbc.JdbcUtil;

public class CategoryDAO {
	
	private static CategoryDAO categoryDao = new CategoryDAO();
	
	private CategoryDAO() {
		
	}
	public static CategoryDAO getCategoryDao() {
		return categoryDao;
	}
	
	
	// 카테고리 등록하기
	public int addCategory(String major,String sub,int minSize,int maxSize,String color) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "INSERT INTO MAJOR_CATEGORY VALUES(MC_SEQ.NEXTVAL,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, major);
			
			int n = pstmt.executeUpdate();
			if( n > 0 ) {
				
				sql = "INSERT INTO SUB_CATEGORY VALUES('A'||SUB_SEQ.NEXTVAL,MC_SEQ.CURRVAL,?)";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, sub);
				int n2 = pstmt2.executeUpdate();
				
				if( n2 > 0 ) {
					sql = "INSERT INTO PRODUCT_SIZE VALUES('B'||SIZE_SEQ.NEXTVAL,'A'||SUB_SEQ.CURRVAL,?)";
					String sql1 = "INSERT INTO COLOR VALUES('C'||COL_SEQ.NEXTVAL,'B'||SIZE_SEQ.CURRVAL,?)";
					pstmt3 = con.prepareStatement(sql);
					pstmt4 = con.prepareStatement(sql1);
					int n3 = 0;
					for(int i = minSize; i<=maxSize; i+=5) {
						System.out.println("minSize:"+minSize);
						System.out.println("maxSize:"+maxSize);
						System.out.println("color:"+color);
						pstmt3.setInt(1, i);
						pstmt3.executeUpdate();
						pstmt4.setString(1, color);
						n3 = pstmt4.executeUpdate();
					}
					if(n3 > 0) {
						con.commit();
						return n3;
					}
				}
			}
			con.rollback();
			return 0;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JdbcUtil.close(pstmt4);
			JdbcUtil.close(pstmt3);
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
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
			String sql = "SELECT DISTINCT PSIZE FROM PRODUCT_SIZE PS,SUB_CATEGORY S WHERE PS.SCNUM=S.SCNUM AND S.S_CATEGORY=?";
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
	
	//맵으로 색상명 얻어오기
	public String getMapColor(HashMap<String, Object> map) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT C.CNUM FROM major_category MC,sub_category SUB,product_size PS,COLOR C " + 
					"WHERE MC.MCNUM=SUB.MCNUM AND SUB.SCNUM=PS.SCNUM AND PS.SIZENUM=C.SIZENUM AND mc.m_category=? AND sub.s_category=? AND PS.PSIZE=? AND C.COLORNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, (String)map.get("major"));
			pstmt.setString(2, (String)map.get("sub"));
			pstmt.setInt(3, (int)map.get("size"));
			pstmt.setString(4, (String)map.get("color"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				String cnum = rs.getString("cnum");
				return cnum;
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
}






