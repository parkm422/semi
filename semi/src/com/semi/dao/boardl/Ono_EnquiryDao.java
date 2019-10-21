package com.semi.dao.boardl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.boardl.Ono_EnquiryVO;

import jdbc.JdbcUtil;

public class Ono_EnquiryDao {
	public Ono_EnquiryVO update(int ennum){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from ono_enquiry where ennum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,ennum);
			rs=pstmt.executeQuery();
	
			if(rs.next()) {
				String category=rs.getString("category");
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String answer=rs.getString("answer");
				Ono_EnquiryVO vo = new Ono_EnquiryVO(ennum, category, writer, title, content, answer);
				return vo;
			}
			return null;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con,pstmt,rs);
		}
	}
	
	
	public int updatego(String content,int ennum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update ono_enquiry set content=? where ennum=?";
		System.out.println(content);
		System.out.println(ennum);
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,content);
			pstmt.setInt(2,ennum);
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
	public int askgo(String answer,int ennum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update ono_enquiry set answer=? where ennum=?";
		System.out.println(answer);
		System.out.println(ennum);
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,answer);
			pstmt.setInt(2,ennum);
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
	
	public int insert(Ono_EnquiryVO vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into ono_enquiry(ennum,category,writer,title,content)values(ono_seq.nextval,?,?,?,?)";
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getCategory());
			pstmt.setString(2,vo.getWriter());
			pstmt.setString(3,vo.getTitle());
			pstmt.setString(4,vo.getContent());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}
	public int getCount(String field,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select NVL(count(ennum),0) from ono_enquiry";
			if(field!=null && !field.equals("")) {
				sql +=" where "+ field +" like '%" + keyword + "%'";
			}
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
			JdbcUtil.close(con,pstmt,rs);
		}
	}
	
	public ArrayList<Ono_EnquiryVO> list(int startRow,int endRow,String field,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql=null;
			
				sql="select * from" + 		
						"    (" + 
						"        select aa.*,rownum rnum from" + 
						"        (" + 
						"            select * from ono_enquiry order by ennum asc" + 
						"        )aa" + 
						")where rnum>=? and  rnum<=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			ArrayList<Ono_EnquiryVO> list=new ArrayList<Ono_EnquiryVO>();
			while(rs.next()) {
				Ono_EnquiryVO vo=new Ono_EnquiryVO(rs.getInt("ennum"),
						rs.getString("category"), 
						rs.getString("writer"),
						rs.getString("title"), 
						rs.getString("content"),
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
	public Ono_EnquiryVO detail(int ennum){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select * from ono_enquiry where ennum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,ennum);
			rs=pstmt.executeQuery();
	
			if(rs.next()) {
				String category=rs.getString("category");
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String answer=rs.getString("answer");
				Ono_EnquiryVO vo = new Ono_EnquiryVO(ennum, category, writer, title, content, answer);
				return vo;
			}
			return null;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con,pstmt,rs);
		}
	}
	
}
