package com.semi.dao.boardY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.boardY.BoardVo;

import jdbc.JdbcUtil;
/*
 * [싱글톤패턴 객체 만들기]
 * - 객체가 하나만 생성되게 하는 기법,객체를 공유해서 사용한다.
 * - 만드는 방법
 *   1.객체자신을 static멤버변수로 생성한다.
 *   2.생성자를 private로 만들어 외부에서 생성하지 못하게 만든다.
 *   3.1에서 생성한 객체를 리턴하는 static메소드를 만든다.
 */
public class BoardDao {
	public int getCount() {//전체글의 갯수 구하기
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select NVL(count(fnum),0) from faq_board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int num=rs.getInt(1);
				return num;	
			}else {
				return 0;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, rs);		
		}
	}
	public int getMaxNum() {//가장 큰 글번호 얻어오기
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select NVL(max(fnum),0) as maxnum from faq_board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				//int num=rs.getInt(1);
				int num=rs.getInt("maxnum");
				return num;	
			}else {
				return 0;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, rs);		
		}
	}
	public ArrayList<BoardVo> list(int startRow,int endRow){
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con=JdbcUtil.getConn();
		String sql="select * from" + 		
				"    (" + 
				"        select aa.*,rownum rnum from" + 
				"        (" + 
				"            select * from faq_board order by fnum asc" + 
				"        )aa" + 
				")where rnum>=? and  rnum<=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,startRow);
		pstmt.setInt(2,endRow);
		rs=pstmt.executeQuery();
		ArrayList<BoardVo> list=new ArrayList<BoardVo>();
		while(rs.next()) {
			BoardVo vo=new BoardVo(rs.getInt("fnum"),
					rs.getString("category"), 
					rs.getString("question"), 
					rs.getString("answer"));
			list.add(vo);
		}
		return list;
	}catch(SQLException se) {
		System.out.println(se.getMessage());
		return null;
	}finally {
		JdbcUtil.close(con, pstmt, rs);
	}	
}
	/*
	public int getCount(String field,String keyword) {//전체 글의 갯수 구하기
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select NVL(count(*),0) from faq_board";
			if(field!=null && !field.equals("")) {
				sql += " where " + field +" like '%" + keyword + "%'";
			}
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int cnt=rs.getInt(1);
				return cnt;
			}
			return 0;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}	
	}
	public ArrayList<BoardVo> list(int startRow,int endRow,
				String field,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="";
			if(field==null) {//검색조건이 없는 경우
				sql="select * from" + 		
					"    (" + 
					"        select aa.*,rownum rnum from" + 
					"        (" + 
					"            select * from faq_board order by fnum asc" + 
					"        )aa" + 
					")where rnum>=? and  rnum<=?";
			}else {//검색조건이 있는 경우
				sql="select * from " + 
					"(" + 
					"   select aa.*,rownum rnum from" + 
					"    (" + 
					"        select * from faq_board " + 
					"	     where " + field + " like '%" + keyword +"%'" + 
					"	     order by fnum asc " + 
					"     )aa" + 
					")where rnum>=? and  rnum<=?";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			ArrayList<BoardVo> list=new ArrayList<BoardVo>();
			while(rs.next()) {
				BoardVo vo=new BoardVo(rs.getInt("fnum"),
						rs.getString("category"), 
						rs.getString("question"), 
						rs.getString("answer"));
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}	
	}
	*/
	public int insert(BoardVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=
			"insert into faq_board values(faq_seq.nextval,?,?,?)";
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getCategory());
			pstmt.setString(2,vo.getQuestion());
			pstmt.setString(3,vo.getAnswer());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
}













