package com.semi.dao.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import com.semi.vo.product.Product_ImgVO;
import com.semi.vo.product.Product_ListVO;

import jdbc.JdbcUtil;

public class ProductDAO {
	
	private static ProductDAO productDao = new ProductDAO();
	
	private ProductDAO() {
		
	}
	public static ProductDAO getProductDao() {
		return productDao;
	}
	
	public int img_insert(Product_ImgVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = JdbcUtil.getConn();
			String sql="INSERT INTO PRODUCT_IMG VALUES(IMG_SEQ.NEXTVAL,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getImgnum());
			pstmt.setString(2, vo.getOrgfilename());
			pstmt.setString(3, vo.getSavefilename());
			int n = pstmt.executeUpdate();
			if(n>0) {
				con.commit();
				return n;
			}
			return 0;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	
	public int getCount() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT NVL(COUNT(*),0) AS CNT FROM PRODUCT_LIST";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int num = rs.getInt("CNT");
				return num;
			} else {
				return 0;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<Product_ListVO> list(int startRow,int endRow,String type){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT * FROM(SELECT AA.*,ROWNUM AS RNUM FROM" + 
						"(SELECT * FROM PRODUCT_LIST ORDER BY INUM DESC)AA)" + 
						"WHERE RNUM>=? AND RNUM<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			ArrayList<Product_ListVO> list = new ArrayList<Product_ListVO>();
			while(rs.next()) {
				
				int inum = rs.getInt("inum");
				String cnum = rs.getString("cnum");
				String pname = rs.getString("pname");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				int salecnt = rs.getInt("salecnt");
				
				Product_ListVO vo = new Product_ListVO(inum, cnum, pname, price, cnt, salecnt);
				list.add(vo);
				
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
		
	}
}
