package com.semi.dao.memberP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semi.vo.memberP.S_MemberVO;

import jdbc.JdbcUtil;

public class S_MemberDAO {
	
	private static S_MemberDAO s_memberDao = new S_MemberDAO(); 
	
	private S_MemberDAO() {
		
	}
	public static S_MemberDAO getSmemberDao() {
		return s_memberDao;
	}
	
	//회원 추가
	public int insert(S_MemberVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "INSERT INTO S_MEMBERS VALUES(SMEM_SEQ.NEXTVAL,?,?,?,?,?,?,0,SYSDATE)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getPhone());
			
			int n = pstmt.executeUpdate();
			if(n>0) {
				con.commit();
			}else {
				con.rollback();
			}
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	
	// 아이디로 회원찾기
	public S_MemberVO select(String id) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT * FROM S_MEMBERS WHERE ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				int mnum = rs.getInt("mnum");
				String name = rs.getString("name");
				String id2 = rs.getString("id");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				int point = rs.getInt("point");
				Date joindate = rs.getDate("joindate");
				
				S_MemberVO vo = new S_MemberVO(mnum, name, id2, pwd, email, address, phone, point, joindate);
				return vo;
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	//회원 검색
	public boolean exist(String id,String pwd) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT * FROM S_MEMBERS WHERE ID=? AND PWD=?";
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
