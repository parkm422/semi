package com.semi.dao.managerK;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.semi.vo.memberP.S_MemberVO;
import com.semi.vo.productK.OrderInfoVO;

import jdbc.JdbcUtil;

public class ManagerDAO {
	private ManagerDAO() {}
	private static ManagerDAO managerDAO = new ManagerDAO();
	public static ManagerDAO getManagerDAO() {
		return managerDAO;
	}
	
	public ArrayList<S_MemberVO> getMemberInfoList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("SELECT * FROM S_Members");
			rs = pstmt.executeQuery();
			S_MemberVO vo = null;
			ArrayList<S_MemberVO> list = new ArrayList<S_MemberVO>();
			while (rs.next()) {
				int mnum = rs.getInt("mnum");
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				int point = rs.getInt("point");
				Date joinDate = rs.getDate("joinDate");
				vo = new S_MemberVO(mnum, name, id, pwd, email, address, phone, point, joinDate);
				list.add(vo);
			}
			return list;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<OrderInfoVO> getSalesStatistics(String startDate, String endDate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			pstmt = con.prepareStatement("SELECT * FROM orderInfo WHERE orderDate>=? AND orderDate<=? AND delivery='배송완료'");
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();
			ArrayList<OrderInfoVO> orderList = new ArrayList<OrderInfoVO>();
			OrderInfoVO orderInfoVO = null;
			while(rs.next()) {
				orderInfoVO = new OrderInfoVO(rs.getInt("ornum"), rs.getInt("mnum"), rs.getString("status"), rs.getString("deladd"), rs.getString("delivery"), rs.getInt("amount"), rs.getDate(7), rs.getString(8));
				orderList.add(orderInfoVO);
			}
			return orderList;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
}
