package com.semi.boardK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;

public class QnABoardDAO {
	private QnABoardDAO() {}
	private static QnABoardDAO qnaBoardDAO = new QnABoardDAO();
	public static QnABoardDAO getQnABoardDAo() {
		return qnaBoardDAO;
	}
	
	public int getTotalPost(int inum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalPost = 0;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("SELECT NVL(MAX(qnum),0) \"total\" FROM item_qna WHERE inum=?");
			pstmt.setInt(1, inum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalPost = rs.getInt("total");
			}
			return totalPost;
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<QnABoardVO> getPostList(int inum, int startRow, int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QnABoardVO> postList = new ArrayList<QnABoardVO>();
		QnABoardVO vo = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("SELECT * "
					+ "FROM (SELECT rownum as rnum, a.* "
					+ 	"FROM (SELECT * "
					+ 		"FROM item_qna WHERE inum=? ORDER BY qnum DESC) a "
					+ 	"WHERE rownum <=?) b "
					+ "WHERE b.rnum >=?");
			pstmt.setInt(1, inum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new QnABoardVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				postList.add(vo);
			}
			return postList;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	public QnABoardVO getPost(int qnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnABoardVO vo = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("SELECT * FROM item_qna WHERE qnum=?");
			pstmt.setInt(1, qnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new QnABoardVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				return vo;
			} else {
				return null;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
}
