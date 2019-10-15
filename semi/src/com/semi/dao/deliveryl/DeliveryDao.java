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
	public ArrayList<DeliveryVo> list(int startRow,int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "select * from(select aa.*,rownum as rnum from(select o.ornum,o.pname,i.status,i.delivery " + 
					"from orderdetail o,product_list p,orderinfo i " + 
					"where i.ornum=o.ornum and p.inum=o.inum)aa) where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs = pstmt.executeQuery();
			ArrayList<DeliveryVo> list = new ArrayList<DeliveryVo>();
			while (rs.next()) {
				DeliveryVo vo =new DeliveryVo(rs.getInt("ornum"),
						rs.getString("pname"),rs.getString("status"),rs.getString("delivery"));
				list.add(vo);
			}
			return list;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
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
}
