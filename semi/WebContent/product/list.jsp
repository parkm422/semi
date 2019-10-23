<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
	<div style="margin: 50px;">
	<h1 style="text-align:center;color:skyblue;">상품 리스트</h1>
	<div style="margin-top: 30px;margin-bottom: 30px;text-align: right;">
		<a href="${cp }/product/list?pageNum=${pageNum}&major=${param.major }&sub=${param.sub }&sort=high" style="text-decoration: none;color:gray;">[높은 가격순]</a>
		<a href="${cp }/product/list?pageNum=${pageNum}&major=${param.major }&sub=${param.sub }&sort=low" style="text-decoration: none;color:gray;">[낮은 가격순]</a>
		<a href="${cp }/product/list?pageNum=${pageNum}&major=${param.major }&sub=${param.sub }&sort=popular" style="text-decoration: none;color:gray;">[인기 순]</a>
	</div>
	<div style="padding-left: 70px;">
		<ul>
			<c:forEach var="vo" items="${list }">
				<li style="display:inline-block;">
					<div style="margin-left:15px;margin-bottom:15px;overflow: hidden;">
						<div>
							<a href="${cp }/product/detail?inum=${vo.inum }&sub=${param.sub }&sort=${param.sort}">
								<img src="${cp }/upload/${vo.savefilename}" style="width:250px;height:250px;">
							</a>
						</div>
						<div>
							<div style="width:250px;height:50px;text-align: center;font-size:17px;text-overflow:ellipsis;overflow:hidden;">
								<a href="${cp }/product/detail?inum=${vo.inum }&sub=${param.sub }&sort=${param.sort}" style="text-decoration: none;color: black;font-size:12px;">${vo.pname }</a>
							</div>
							<div style="text-align: center;font-size:17px;"><strong>${dc.format(vo.price) }원</strong></div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
		<div style="text-align: center;">
			<c:if test="${startPageNum>5 }">
				<a href="${cp }/product/list?pageNum=${startPageNum-1}&major=${param.major }&sub=${param.sub }&sort=${param.sort}" style="text-decoration: none;">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${pageNum == i }">
						<a href="${cp }/product/list?pageNum=${i}&major=${param.major }&sub=${param.sub }&sort=${param.sort}" style="text-decoration: none;">
							<span style="color:blue;">[${i }]</span>
						</a>
					</c:when>
					<c:otherwise>
						<a href="${cp }/product/list?pageNum=${i}&major=${param.major }&sub=${param.sub }&sort=${param.sort}" style="text-decoration: none;">
							<span style="color:gray;">[${i }]</span>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:if test="${endPageNum<pageCount }">
				<a href="${pageContext.request.contextPath }/board/list?pageNum=${endPageNum+1}&major=${param.major }&sub=${param.sub }&sort=${param.sort}" style="text-decoration: none;">[다음]</a>
			</c:if>
		</div>
	</div>
	<!-- 최상단으로 최하단으로 버튼 -->
	<div>
		<div style="position: fixed; bottom: 70px; right: 40px;">
				<a href="#header" style="background-color: gray;color:white;">▲</a>
		</div>
		<div style="position: fixed; bottom: 40px; right: 40px;">
				<a href="#footer" style="background-color: gray;color:white;">▼</a>
		</div>
	</div>
</div>