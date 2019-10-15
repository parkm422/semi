<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.JdbcUtil"%>
<%@page import="com.semi.vo.boardY.BoardVo"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String question=request.getParameter("question");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ArrayList<BoardVo> list=new ArrayList<BoardVo>();
	try{
		con=JdbcUtil.getConn();
		String sql="Select * from faq_board where question=?" ;
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,question);
		rs=pstmt.executeQuery();
		if(rs.next()){
			int fnum=rs.getInt("fnum");
			String category=rs.getString("category");
			String answer=rs.getString("answer");
			list.add(new BoardVo(fnum, category, question, answer));
		}
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		JdbcUtil.close(con, pstmt, rs);
	}
	JSONArray arr=new JSONArray();
	for(int i=0;i<list.size();i++){
		BoardVo vo=list.get(i);
		JSONObject json=new JSONObject();
		json.put("fnum",vo.getFnum());
		json.put("category",vo.getCategory());
		json.put("question",vo.getQuestion());
		json.put("answer",vo.getAnswer());
		arr.put(json);
	}
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print(arr.toString());
%>