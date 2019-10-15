package com.semi.dao.orderY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.semi.vo.orderY.OrderVo;

import jdbc.JdbcUtil;

public class OrderDao {

		private  static OrderDao instance=new OrderDao();
		private OrderDao() {}
		public static OrderDao getInstance() {
			return instance;
		}
		
		public int getCount(String field,String keyword) {//전체 글의 갯수 구하기
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=JdbcUtil.getConn();
				String sql="select NVL(count(*),0) from orderinfo";
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
		public ArrayList<OrderVo> list(String id,int startRow,int endRow,
					String field,String keyword){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=JdbcUtil.getConn();
				String sql="";
				if(field==null) {
					sql="select * from(select aa.*,rownum rnum from"
							+ "(SELECT o.ornum,o.mnum,o.amount,o.status,o.deladd,o.delivery,o.orderdate FROM orderinfo o,s_members s WHERE o.mnum=s.mnum and id=?"
							+ " order by ornum asc)aa)where rnum>=? and  rnum<=?";
				}else {
					sql="select * from " + 
						"(" + 
						"   select aa.*,rownum rnum from" + 
						"    (" + 
						"        select * orderinfo " + 
						"	     where " + field + " like '%" + keyword +"%'" + 
						"	     order by fnum asc " + 
						"     )aa" + 
						")where rnum>=? and  rnum<=?";
				}
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,id);
				pstmt.setInt(2,startRow);
				pstmt.setInt(3,endRow);
				rs=pstmt.executeQuery();
				ArrayList<OrderVo> list=new ArrayList<OrderVo>();
				while(rs.next()) {
					OrderVo vo2=new OrderVo(
							rs.getInt("ornum"),
							rs.getInt("mnum"),
							rs.getInt("amount"), 
							rs.getString("status"), 
							rs.getString("deladd"),
							rs.getString("delivery"), 
							rs.getDate("orderdate")); 
						list.add(vo2);
				}
				return list;
			}catch(SQLException se) {
				System.out.println(se.getMessage());
				return null;
			}finally {
				JdbcUtil.close(con, pstmt, rs);
			}	
		}
		
		public int insert(OrderVo vo) {
			Connection con=null;
			PreparedStatement pstmt=null;
			String sql=
				"insert into orderinfo values(faq_seq.nextval,?,?,?,?,?,sysdate)";
			try {
				con=JdbcUtil.getConn();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,vo.getMnum());
				pstmt.setInt(2,vo.getAmount());
				pstmt.setString(3,vo.getStatus());
				pstmt.setString(4,vo.getDeladd());
				pstmt.setString(5,vo.getDelivery());
				return pstmt.executeUpdate();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
				return -1;
			}finally {
				JdbcUtil.close(con, pstmt, null);
			}
		}
	}