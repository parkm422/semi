package com.semi.dao.deliveryl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.deliveryl.DeliveryVo;
import com.semi.vo.managerP.ViewVo;

import jdbc.JdbcUtil;

public class DeliveryDao {
	public ArrayList<DeliveryVo> list(int mnum,int startRow,int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "select * from(select aa.*,rownum as rnum from(select o.ornum,i.getname,o.pname,i.delivery " + 
					"from orderdetail o, orderinfo i " + 
					"where i.mnum=?  and i.ornum=o.ornum ) aa) where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,mnum);
			pstmt.setInt(2,startRow);
			pstmt.setInt(3,endRow);
			rs = pstmt.executeQuery();
			ArrayList<DeliveryVo> list = new ArrayList<DeliveryVo>();
			while (rs.next()) {
				DeliveryVo vo =new DeliveryVo(rs.getInt("ornum"),
						rs.getString("getname"),rs.getString("pname"),rs.getString("delivery"));
				list.add(vo);
			}
			return list;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select nvl(count(*),0) as cnt " + 
					"from orderdetail o,product_list p,orderinfo i " + 
					"where i.ornum=o.ornum and p.inum=o.inum";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int num=rs.getInt("cnt");
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
	public int getCounts(int mnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			String sql="select nvl(count(*),0) as cnt " + 
					"from orderdetail o,product_list p,orderinfo i " + 
					"where i.ornum=o.ornum and p.inum=o.inum and i.mnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,mnum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int num=rs.getInt("cnt");
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
}
