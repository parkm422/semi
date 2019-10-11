package com.semi.dao.memberY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semi.vo.memberY.MemberVo;
import com.semi.vo.orderY.OrderVo;

import jdbc.JdbcUtil;


public class MemberDao {
		private  static MemberDao instance=new MemberDao();
		private MemberDao() {}
		public static MemberDao getInstance() {
			return instance;
		}
		public int update(MemberVo vo) {
			Connection con=null;
			PreparedStatement pstmt=null;
			String sql=
				"update s_members set pwd=?,email=?,address=?,phone=? where id=?";
			try {
				con=JdbcUtil.getConn();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,vo.getPwd());
				pstmt.setString(2,vo.getEmail());
				pstmt.setString(3,vo.getAddress());
				pstmt.setString(4,vo.getPhone());
				pstmt.setString(5,vo.getId());
				return pstmt.executeUpdate();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
				return -1;
			}finally {
				JdbcUtil.close(con, pstmt, null);
			}
		}
		public MemberVo select(String id) {
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
					MemberVo vo=new MemberVo(mnum, null,null,null,null,null,null,0,null);
					return vo;
				}
				return null;
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
