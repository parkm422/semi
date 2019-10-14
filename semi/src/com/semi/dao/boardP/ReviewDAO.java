package com.semi.dao.boardP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.boardP.ReviewChildVO;
import com.semi.vo.boardP.ReviewVO;

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
	
	// 상품번호에 해당 하는 리뷰 개수 얻어오기
	public int getReviewCount(int inum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT NVL(COUNT(*),0) AS CNT FROM REVIEW WHERE INUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				int cnt = rs.getInt("cnt");
				
				return cnt;
			}
			return 0;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	// 리뷰게시판 목록 얻어오기 페이징처리
	public ArrayList<ReviewVO> review_list(int startRow, int endRow, int inum){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT * FROM(SELECT AA.*,ROWNUM AS RRNUM "
						+ "FROM(SELECT * FROM REVIEW WHERE INUM=? ORDER BY RNUM DESC)AA) "
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
				
				ReviewVO vo = new ReviewVO(rnum, inum2, writer, title, content, orgfilename, savefilename, rating);
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
	
	public ArrayList<ReviewChildVO> reviewChild_list(ArrayList<Integer> rnum){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			int len = rnum.size();
			String sql = "";
			if(len == 1) {
				sql = "SELECT * FROM REVIEWCHILD WHERE RNUM=?";
			}else if(len == 2){
				sql = "SELECT * FROM REVIEWCHILD WHERE RNUM=? OR RNUM=?";
			}else if(len == 3) {
				sql = "SELECT * FROM REVIEWCHILD WHERE RNUM=? OR RNUM=? OR RNUM=?";
			}else if(len == 4) {
				sql = "SELECT * FROM REVIEWCHILD WHERE RNUM=? OR RNUM=? OR RNUM=? OR RNUM=?";
			}else {
				sql = "SELECT * FROM REVIEWCHILD WHERE RNUM=? OR RNUM=? OR RNUM=? OR RNUM=? OR RNUM=?";
			}
			
			pstmt = con.prepareStatement(sql);
			for(int i = 0; i<len; i++) {
				pstmt.setInt(i+1, rnum.get(i));
			}
			rs = pstmt.executeQuery();
			ArrayList<ReviewChildVO> childList = new ArrayList<ReviewChildVO>();
			while(rs.next()) {
				
				int rcnum = rs.getInt("rcnum");
				int rnum2 = rs.getInt("rnum");
				String rcwriter = rs.getString("rcwriter");
				String comments = rs.getString("comments");
				int ref = rs.getInt("ref");
				int lev = rs.getInt("lev");
				int step = rs.getInt("step");
				
				ReviewChildVO vo = new ReviewChildVO(rcnum, rnum2, rcwriter, comments, ref, lev, step);
				childList.add(vo);
			}
			
			return childList;
			
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
}











