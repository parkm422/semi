package com.semi.dao.basketY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.basketY.BasketVo;

import jdbc.JdbcUtil;

public class BasketDao {
	private  static BasketDao instance=new BasketDao();
	private BasketDao() {}
	public static BasketDao getInstance() {
		return instance;
	}
	
	public int delete(int mnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=
			"delete from basket where mnum=?";
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			pstmt.executeUpdate();
			return 1;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
}