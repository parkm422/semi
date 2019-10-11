package com.semi.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.board.ReviewVO;

import jdbc.JdbcUtil;

public class ReviewDAO {
	
	private static ReviewDAO reviewDao = new ReviewDAO();
	
	private ReviewDAO() {
		
	}
	public static ReviewDAO getReviewDao() {
		return reviewDao;
	}
	/*
	public int review_Insert(ReviewVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getInum());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getOrgfilename());
			pstmt.setString(6, vo.getSavefilename());
			pstmt.setInt(7, vo.getRating());
			pstmt.setInt(8, vo.getRef());
			pstmt.setInt(9, vo.getLev());
			pstmt.setInt(10, vo.getStep());
			
			
			
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
		
	}
	*/
	public ArrayList<ReviewVO> review_list(int startRow, int endRow, int inum){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT * " + 
					"FROM(SELECT AA.*,ROWNUM AS RRNUM FROM(SELECT * FROM REVIEW WHERE INUM=? ORDER BY REF DESC, STEP ASC)AA)"
					+ "WHERE RRNUM>=? AND RRNUM<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>();
			while(rs.next()) {
				
				int rnum = rs.getInt("rnum");
				int inum2 = rs.getInt("inum");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String orgfilename = rs.getString("orgfilename");
				String savefilename = rs.getString("savefilename");
				int rating = rs.getInt("rating");
				int ref = rs.getInt("ref");
				int lev = rs.getInt("lev");
				int step = rs.getInt("step");
				
				ReviewVO vo = new ReviewVO(rnum, inum2, writer, title, content, orgfilename, savefilename, rating, ref, lev, step);
				reviewList.add(vo);
			}
			return reviewList;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
}











