package com.semi.dao.boardK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.boardK.ItemQA_Vo;

import jdbc.JdbcUtil;

public class ItemQA_Dao {
	private ItemQA_Dao() {};
	private static ItemQA_Dao itemQA_Dao = new ItemQA_Dao();
	public static ItemQA_Dao getItemQADao() {
		return itemQA_Dao;
	}
	
	public int insertQ(int inum, String writer, String title, String content) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("INSERT INTO item_qna VALUES(QnA_SEQ.nextval, ?, ?, ?, ?, null");
			pstmt.setInt(1, inum);
			pstmt.setString(2, writer);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	
	public int insertA(int qnum, String answer) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("UPDATE item_qna SET answer=? WHERE qnum=?");
			pstmt.setString(1, answer);
			pstmt.setInt(2, qnum);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	
	public int updateQ(int qnum, String writer, String content) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("UPDATE item_qna SET writer=?, content? WHERE qnum=?");
			pstmt.setString(1, writer);
			pstmt.setString(2, content);
			pstmt.setInt(3, qnum);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	
	public int updateA(int qnum, String answer) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("UPDATE item_qna SET answer=? WHERE qnum=?");
			pstmt.setString(1, answer);
			pstmt.setInt(2, qnum);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	
	public int delete(int qnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("DELETE FROM item_qna WHERE qnum=?");
			pstmt.setInt(1, qnum);
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	
	public ArrayList<ItemQA_Vo> list() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("SELECT * FROM item_qna");
			rs = pstmt.executeQuery();
			ArrayList<ItemQA_Vo> list = null;
			ItemQA_Vo vo = null;
			while(rs.next()) {
				int qnum = rs.getInt("qnum");
				int inum = rs.getInt("inum");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String answer = rs.getString("answer");
				vo = new ItemQA_Vo(qnum, inum, writer, title, content, answer);
				list.add(vo);
			}
			return list;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	public ItemQA_Vo select(int qnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("SELECT * From item_qna WHERE qnum=?");
			pstmt.setInt(1, qnum);
			rs = pstmt.executeQuery();
			ItemQA_Vo vo = null;
			if (rs.next()) {
				vo = new ItemQA_Vo(rs.getInt("qnum"), rs.getInt("inum"), rs.getString("writer"), rs.getString("title"), rs.getString("content"), rs.getString("answer"));
			}
			return vo;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
}
