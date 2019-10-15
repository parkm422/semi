package com.semi.dao.paymentl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public class PaymentDao {
	public int insert(int ornum,int mnum,int amount) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into payment(pnum,ornum,mnum,payamount,status)values(payment_seq.nextval,?,?,?,?)";
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,ornum);
			pstmt.setInt(2,mnum);
			pstmt.setInt(3,amount);
			pstmt.setString(4,"결제대기");
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
}
