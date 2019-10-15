package com.semi.dao.memberY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		public ArrayList<MemberVo> list(String id){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from s_members where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			ArrayList<MemberVo> list=new ArrayList<MemberVo>();
			while(rs.next()) {
				MemberVo vo1=new MemberVo(
						rs.getInt("mnum"),
						rs.getString("name"),
						rs.getString("id"), 
						rs.getString("pwd"), 
						rs.getString("email"),
						rs.getString("address"), 
						rs.getString("phone"),
						rs.getInt("point"),
						rs.getDate("joindate")); 
					list.add(vo1);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}	
	}
}
