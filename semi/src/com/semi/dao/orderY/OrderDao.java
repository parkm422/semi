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
/*
		private  static OrderDao instance=new OrderDao();
		private OrderDao() {}
		public static OrderDao getInstance() {
			return instance;
		}
*/		
		public int getCount(int mnum) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=JdbcUtil.getConn();
				String sql="select NVL(count(*),0) from orderinfo o,s_members s,orderdetail d WHERE o.mnum=s.mnum and o.ornum=d.ornum and o.mnum=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, mnum);
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
		public ArrayList<OrderVo> list(int mnum,int startRow,int endRow){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=JdbcUtil.getConn();
					String sql="select * from (select aa.*,rownum rnum from(SELECT o.ornum,m.savefilename,m.inum,d.pname,d.psize,d.color,d.cnt,o.deladd,o.delivery,l.price,o.orderdate"
							+ " FROM orderinfo o,s_members s,orderdetail d,product_list l,product_img m WHERE o.mnum=s.mnum and o.ornum=d.ornum and l.inum=d.inum and m.inum=l.inum and o.mnum=?"
							+ " order by ornum asc)aa)where rnum>=? and  rnum<=?";
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,mnum);
				pstmt.setInt(2,startRow);
				pstmt.setInt(3,endRow);
				rs=pstmt.executeQuery();
				ArrayList<OrderVo> list=new ArrayList<OrderVo>();
				while(rs.next()) {
					OrderVo vo2=new OrderVo(
							rs.getInt("ornum"),
							rs.getString("savefilename"),
							rs.getInt("inum"),
							rs.getString("pname"),
							rs.getInt("psize"), 
							rs.getString("color"),
							rs.getInt("cnt"),
							rs.getString("deladd"),
							rs.getString("delivery"), 
							rs.getInt("price"), 
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
				"insert into orderinfo values(order_seq.nextval,?,?,?,?,?,sysdate,?)";
			try {
				con=JdbcUtil.getConn();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,vo.getMnum());
				pstmt.setInt(2,vo.getAmount());
				pstmt.setString(3,vo.getStatus());
				pstmt.setString(4,vo.getDeladd());
				pstmt.setString(5,vo.getDelivery());
				pstmt.setString(6,vo.getGetname());
				return pstmt.executeUpdate();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
				return -1;
			}finally {
				JdbcUtil.close(con, pstmt, null);
			}
		}
		public int select() {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=JdbcUtil.getConn();
				String sql="select Max(ornum) from orderinfo";
				pstmt=con.prepareStatement(sql);

				rs=pstmt.executeQuery();
				if(rs.next()) {
					int ornum=rs.getInt("Max(ornum)");
					return ornum;
				}
				return 0;
			}catch(SQLException se) {
				System.out.println(se.getMessage());
				return 0;
			}finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null) con.close();
				}catch(SQLException se) {}
			}
		}
	}