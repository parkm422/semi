<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
	<h1 style="text-align:center;color:skyblue;">상품 리스트</h1>
	<ul>
		<c:forEach var="vo" items="${list }">
			<li style="display:inline-block;">
				<div style="border:1px solid black;margin-left:15px;margin-bottom:15px;">
					<div>
						<a href="">
							<img src="${cp }/upload/${vo.savefilename}" style="width:250px;heigth:300px;">
						</a>
					</div>
					<div>
						<p style="text-align: center;font-size:12px;">
							<a href="">${vo.pname }</a>
						</p>
						<p style="text-align: center;font-size:12px;">${vo.price }</p>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
	
	<c:if test="${startPageNum>5 }">
		<a href="${cp }/product/list?pageNum=${startPageNum-1}&major=OUTER&sub=코트">[이전]</a>
	</c:if>
	
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum == i }">
				<a href="${cp }/product/list?pageNum=${i}&major=OUTER&sub=코트">
					<span style="color:blue;">[${i }]</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/product/list?pageNum=${i}&major=OUTER&sub=코트">
					<span style="color:gray;">[${i }]</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${endPageNum<pageCount }">
		<a href="${pageContext.request.contextPath }/board/list?pageNum=${endPageNum+1}&major=OUTER&sub=코트">[다음]</a>
	</c:if>
</div>