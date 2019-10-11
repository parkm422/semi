package com.semi.dao.product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import com.semi.vo.product.BasketVO;
import com.semi.vo.product.List_img_joinVO;
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
	
	
	// 상품등록
	public int productInsert(Product_ListVO vo,String orgfilename,String savefilename) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		try {
			
			con = JdbcUtil.getConn();
			
			String sql = "INSERT INTO PRODUCT_LIST VALUES(LIST_SEQ.NEXTVAL,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCnum());
			pstmt.setString(2, vo.getPname());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setInt(4, vo.getCnt());
			pstmt.setInt(5, vo.getSalecnt());
			int n = pstmt.executeUpdate();
			
			if(n>0) {
				Product_ImgVO imgvo = new Product_ImgVO(0, 0, orgfilename, savefilename);
				String sql2 = "INSERT INTO PRODUCT_IMG VALUES(IMG_SEQ.NEXTVAL,LIST_SEQ.CURRVAL,?,?)";
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setString(1, orgfilename);
				pstmt2.setString(2, savefilename);
				int n2 = pstmt2.executeUpdate();
				if(n2>0) {
					con.commit();
					return n2;
				}else {
					con.rollback();
				}
			}else {
				con.rollback();
			}
			return 0;
			
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(con, pstmt, null);
		}
	}
	
	//장바구니 추가
	public int basketInsert(BasketVO vo) {
		System.out.println(vo);
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = JdbcUtil.getConn();
			
			String sql = "INSERT INTO BASKET VALUES(BASKET_SEQ.NEXTVAL,?,?,?,1,SYSDATE)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getMnum());
			pstmt.setInt(2, vo.getInum());
			pstmt.setString(3, vo.getPname());
			int n = pstmt.executeUpdate();
			if(n>0) {
				con.commit();
				return n;
			}
			con.rollback();
			return 0;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}
	
	// 해당 회원 장바구니 목록 얻어오기
	public ArrayList<BasketVO> basketList(int mnum){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT * FROM BASKET WHERE MNUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			rs = pstmt.executeQuery();
			ArrayList<BasketVO> bList = new ArrayList<BasketVO>();
			while(rs.next()) {
				
				int bnum = rs.getInt("bnum");
				int mnum2 = rs.getInt("mnum");
				int inum = rs.getInt("inum");
				String pname = rs.getString("pname");
				int cnt = rs.getInt("cnt");
				Date regdate = rs.getDate("regdate");
				
				BasketVO vo = new BasketVO(bnum, mnum2, inum, pname, cnt, regdate);
				bList.add(vo);
			}
			return bList;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	// 상품번호로 이미지 찾기
	public String img_name(int inum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT SAVEFILENAME FROM PRODUCT_IMG WHERE INUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				String savefilename = rs.getString("savefilename");
				return savefilename;
				
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	// 상품 이미지 추가
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
	
	// 상품 갯수 얻어오기
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
	
	//상품번호에 해당하는 상품 이미지 얻어오기
	public ArrayList<Product_ImgVO> getImg(int inum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT * FROM PRODUCT_IMG WHERE INUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inum);
			rs = pstmt.executeQuery();
			ArrayList<Product_ImgVO> imgList = new ArrayList<Product_ImgVO>();
			while(rs.next()) {
				int imgnum = rs.getInt("imgnum");
				int inum2 = rs.getInt("inum");
				String orgfilename = rs.getString("orgfilename");
				String savefilename = rs.getString("savefilename");
				
				Product_ImgVO vo = new Product_ImgVO(imgnum, inum2, orgfilename, savefilename);
				imgList.add(vo);
			}
			return imgList;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	//상세정보 얻어오기
	public Product_ListVO getDetail(int inum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT * FROM PRODUCT_LIST WHERE INUM=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				String cnum = rs.getString("cnum");
				String pname = rs.getString("pname");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				int salecnt = rs.getInt("salecnt");
				
				Product_ListVO vo = new Product_ListVO(inum, cnum, pname, price, cnt, salecnt);
				return vo;
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	//상품 리스트
	public ArrayList<List_img_joinVO> list(int startRow,int endRow,String major,String sub){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConn();
			String sql = "SELECT BB.*,PIMG.IMGNUM,PIMG.SAVEFILENAME FROM(SELECT AA.*,ROWNUM AS RNUM FROM(SELECT P.INUM INUM,P.PNAME PNAME,P.PRICE PRICE,p.cnt cnt, p.cnum cnum,p.salecnt salecnt " + 
					"FROM PRODUCT_LIST P,COLOR C,PRODUCT_SIZE S,SUB_CATEGORY SUB,MAJOR_CATEGORY MAJOR "+ 
					"WHERE P.CNUM=C.CNUM AND C.SIZENUM=S.SIZENUM AND S.SCNUM=SUB.SCNUM AND SUB.MCNUM=MAJOR.MCNUM AND M_CATEGORY=? AND S_CATEGORY=?)AA)BB,PRODUCT_IMG PIMG "
					+ "WHERE BB.INUM=PIMG.INUM AND RNUM>=? AND RNUM<=?";
			pstmt = con.prepareStatement(sql);
			System.out.println(major);
			System.out.println(sub);
			pstmt.setString(1, major);
			pstmt.setString(2, sub);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			ArrayList<List_img_joinVO> list = new ArrayList<List_img_joinVO>();
			while(rs.next()) {
				
				int inum = rs.getInt("inum");
				String pname = rs.getString("pname");
				int imgnum = rs.getInt("imgnum");
				String cnum = rs.getString("cnum");
				int price = rs.getInt("price");
				int cnt = rs.getInt("cnt");
				int salecnt = rs.getInt("salecnt");
				String savefilename = rs.getString("savefilename");
				
				List_img_joinVO vo = new List_img_joinVO(inum, pname, price, cnt, cnum, salecnt, imgnum, savefilename);
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
