<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
	<h1>상품 리스트</h1>
	<ul>
		<c:forEach var="vo" items="${list }">
			<li>
				<div>
					<div>
						<img src="${cp }/upload/${vo.savefilename}">
					</div>
					<div>
						<p>${vo.pname }</p>
						<p>${vo.price }</p>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
	
</div>