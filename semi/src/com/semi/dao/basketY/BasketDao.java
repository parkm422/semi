package com.semi.dao.basketY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.basketY.BasketVo;
import com.semi.vo.memberY.MemberVo;

import jdbc.JdbcUtil;

public class BasketDao {
	private  static BasketDao instance=new BasketDao();
	private BasketDao() {}
	public static BasketDao getInstance() {
		return instance;
	}
	//
	public int delete(int mnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=
			"delete from basket where mnum=?";
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			int n = pstmt.executeUpdate();
			if(n>0) {
				con.commit();
				return n;
			}else {
				con.rollback();
				return 0;
			}
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	public int update(int cnt,int bnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=
			"update basket set cnt=? where bnum=?";
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,cnt);
			pstmt.setInt(2,bnum);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
}