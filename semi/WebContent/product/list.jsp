<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String saveDirectory = application.getRealPath("/upload");//업로드할 디렉토리
	MultipartRequest mr = new MultipartRequest(
			request,// request객체
			saveDirectory,// 업로드할 디렉토리 경로
			1024*1024*5, // 최대 업로드 크기(byte단위 -> 5mb로 설정함)
			"utf-8", // 인코딩방식
			new DefaultFileRenamePolicy()// 동일한 파일명이 존재할시 파일명에 일련번호를 붙여서 파일생성하는 객체
	);
%>
<div id="main">
	<h1>상품 리스트</h1>
	<ul>
		<li>
			<div>
				<div>
					
				</div>
				<div>
					<h1>하이</h1>
				</div>
			</div>
		</li>
	</ul>
	
</div>