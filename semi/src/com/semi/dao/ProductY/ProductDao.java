package com.semi.dao.ProductY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import jdbc.JdbcUtil;

public class ProductDao {
	//결제후 재고 수정
	public int update(int cnt,int inum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=
			"update product_list set cnt=cnt-"+cnt+""
					+ " where inum=?";
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,inum);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	//총 재고와  팔린 갯수 불러오기
	public ArrayList<HashMap<String, Integer>> select(int mnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select b.cnt,b.inum from basket b,product_list l where b.inum= l.inum and b.mnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			rs=pstmt.executeQuery();
			ArrayList<HashMap<String, Integer>> list = new ArrayList<HashMap<String,Integer>>();
			while(rs.next()) {
				int count=rs.getInt("cnt");
				int allinum=rs.getInt("inum");
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put("count", count);
				map.put("allinum", allinum);
				list.add(map);
				System.out.println("처음리스트:"+list);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
	
}
