package com.semi.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.board.Ono_EnquiryVO;

import jdbc.JdbcUtil;

public class Ono_EnquiryDao {
	
	public int insert(Ono_EnquiryVO vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into ono_enquiry(enum,category,writer,title,content)values(ono_seq.nextval,?,?,?,?)";
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
			String sql="select NVL(count(enum),0) from ono_enquiry";
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
			if(field==null) {
				sql="select * from" + 
					"    (" + 
					"        select aa.*,rownum rnum from" + 
					"        (" + 
					"            select * from ono_enquiry order by num desc" + 
					"        )aa" + 
					")where rnum>=? and  rnum<=?";
			}else {
				sql="select * from" + 
						"    (" + 
						"        select aa.*,rownum rnum from" + 
						"        (" + 
						"            select * from ono_enquiry where "+ field+" like '%" +keyword+ "%' order by num desc" + 
						"        )aa" + 
						")where rnum>=? and  rnum<=?";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs=pstmt.executeQuery();
			ArrayList<Ono_EnquiryVO> list=new ArrayList<Ono_EnquiryVO>();
			while(rs.next()) {
				Ono_EnquiryVO vo=new Ono_EnquiryVO(rs.getInt("enum"),
						rs.getString("writer"), 
						rs.getString("category"),
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
}
