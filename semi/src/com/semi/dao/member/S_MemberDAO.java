package com.semi.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.semi.email.SendEmail;
import com.semi.vo.member.S_MemberVO;

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
			con.commit();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
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
	
	//회원 아이디 찾기
	public String findID(String email) {
		String id = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("SELECT id FROM s_members WHERE email=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
				return id;
			} else {
				return "해당 이메일로 가입된 회원은 없습니다.";
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	//회원 비밀번호 찾기
	public String findPW(String email, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("SELECT id FROM s_members WHERE email=? id=?");
			pstmt.setString(1, email);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String randomPwPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789!@#$%+-^&*()[]";
				char[] randomPwCharArray = new char[15];
				Random rnd = new Random(); 
				for (int i=0; i<15; i++) {
					randomPwCharArray[i] = randomPwPool.charAt(rnd.nextInt(randomPwPool.length()));
				}
				String randomPw = new String(randomPwCharArray, 0, randomPwCharArray.length);
				pstmt2 = con.prepareStatement("UPDATE s_members)
				String content = "확인 후 비밀번호를 재설정해주세요.\r\n" + randomPw;
				SendEmail sendEmail = new SendEmail();
				sendEmail.send(email, content);
				return "비밀번호를 발송했습니다. 이메일을 확인해주세요.";
			} else {
				return "이메일 또는 아이디가 잘못되었습니다.";
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
			JdbcUtil.close(pstmt2);
		}
	}
}
