package com.semi.dao.managerP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.managerP.ViewVo;

import jdbc.JdbcUtil;

public class ManagerDAO {

	private static ManagerDAO managerdao = new ManagerDAO();

	private ManagerDAO() {

	}

	public static ManagerDAO getManagerDao() {
		return managerdao;
	}

	public boolean exist(String id, String pwd) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT * FROM MANAGER WHERE ID=? AND PWD=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
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
					"from s_members s,orderdetail o,product_list p,payment m,orderinfo i " + 
					"where i.ornum=m.ornum and i.ornum=o.ornum and p.inum=o.inum and s.mnum=i.mnum and s.mnum=m.mnum";
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
	public int insert(ViewVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=JdbcUtil.getConn();
			String sql="insert into orderdetail values(order_seq.nextval,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,vo.getOrnum());
			pstmt.setInt(2,vo.getInum());
			pstmt.setString(3,vo.getPpname());
			pstmt.setInt(4,vo.getPpsize());
			pstmt.setString(5,vo.getCcolor());
			pstmt.setInt(6,vo.getCcnt());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con,pstmt,null);
		}
	}

	public ArrayList<ViewVo> list(int startRow,int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "select * from(select aa.*,rownum as rnum from(select s.name,s.id,o.pname,o.psize,o.color,o.cnt,p.price,m.status,i.delivery " + 
					"from s_members s,orderdetail o,product_list p,payment m,orderinfo i " + 
					")aa) where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			rs = pstmt.executeQuery();
			ArrayList<ViewVo> list = new ArrayList<ViewVo>();
			while (rs.next()) {
				ViewVo vo = new ViewVo(rs.getString("name"), rs.getString("id"), rs.getString("pname"),
						rs.getInt("psize"), rs.getString("color"), rs.getInt("cnt"), rs.getInt("price"),
						rs.getString("status"), rs.getString("delivery"));
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
}
