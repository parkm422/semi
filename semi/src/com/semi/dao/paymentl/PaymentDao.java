package com.semi.dao.paymentl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semi.vo.paymentl.PaymentVo;
import com.semi.vo.product.PaymentVO;

import jdbc.JdbcUtil;

public class PaymentDao {
	
	public int insert(PaymentVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into payment values(payment_seq.nextval,?,?,?,?,?)";
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,vo.getOrnum());
			pstmt.setInt(2,vo.getMnum());
			pstmt.setInt(3,vo.getPayamount());
			pstmt.setInt(4,vo.getEnpay());
			pstmt.setString(5,"결제완료");
			int n=pstmt.executeUpdate();
			if(n>0) {
				con.commit(); return n;
			}
			con.rollback();
			return 0;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	public int select(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from s_members where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int mnum=rs.getInt("mnum");
				return mnum;
			}
			return 0;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return 0;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
	public int select(int mnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select Max(ornum) from orderinfo where mnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,mnum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int mornum=rs.getInt("Max(ornum)");
				return mornum;
			}
			return 0;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
}
