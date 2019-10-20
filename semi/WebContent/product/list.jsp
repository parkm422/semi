<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
	<div style="margin: 50px;">
	<h1 style="text-align:center;color:skyblue;">상품 리스트</h1>
	<div style="margin-top: 30px;margin-bottom: 30px;text-align: right;">
		<a href="${cp }/product/list?pageNum=${pageNum}&major=${param.major }&sub=${param.sub }&sort=high">[높은 가격순]</a>
		<a href="${cp }/product/list?pageNum=${pageNum}&major=${param.major }&sub=${param.sub }&sort=low">[낮은 가격순]</a>
		<a href="${cp }/product/list?pageNum=${pageNum}&major=${param.major }&sub=${param.sub }&sort=popular">[인기 순]</a>
	</div>
	<div style="width:1500px;height:1500px;padding-left: 70px;">
		<ul>
			<c:forEach var="vo" items="${list }">
				<li style="display:inline-block;">
					<div style="margin-left:15px;margin-bottom:15px;">
						<div>
							<a href="${cp }/product/detail?inum=${vo.inum }&sub=${param.sub }&sort=${sort}">
								<img src="${cp }/upload/${vo.savefilename}" style="width:250px;height:250px;">
							</a>
						</div>
						<div>
							<p style="text-align: center;font-size:12px;">
								<a href="${cp }/product/detail?inum=${vo.inum }&sub=${param.sub }&sort=${sort}">${vo.pname }</a>
							</p>
							<p style="text-align: center;font-size:12px;">${dc.format(vo.price) }원</p>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
		<div style="text-align: right;">
			<c:if test="${startPageNum>5 }">
				<a href="${cp }/product/list?pageNum=${startPageNum-1}&major=${param.major }&sub=${param.sub }&sort=${sort}">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${pageNum == i }">
						<a href="${cp }/product/list?pageNum=${i}&major=${param.major }&sub=${param.sub }&sort=${sort}">
							<span style="color:blue;">[${i }]</span>
						</a>
					</c:when>
					<c:otherwise>
						<a href="${cp }/product/list?pageNum=${i}&major=${param.major }&sub=${param.sub }&sort=${sort}">
							<span style="color:gray;">[${i }]</span>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:if test="${endPageNum<pageCount }">
				<a href="${pageContext.request.contextPath }/board/list?pageNum=${endPageNum+1}&major=${param.major }&sub=${param.sub }&sort=${sort}">[다음]</a>
			</c:if>
		</div>
	</div>
	<div style="position: fixed; bottom: 40px; right: 40px;">
		<a href="#header" style="background-color: gray;color:white;">TOP</a>
	</div>
</div>