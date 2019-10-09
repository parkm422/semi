<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
<div id="login_menu" style="text-align: right;">
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<span><a href="${cp }/member/join">회원가입</a></span>
			<span><a href="${cp }/member/login">회원로그인</a></span>
			<span><a href="${cp }/manager/login">관리자로그인</a></span>
		</c:when>
		<c:otherwise>
			<span><a href="${cp }/member/join">마이페이지</a></span>
			<span><a href="${cp }/member/login">로그아웃</a></span>
			<span><a href="">관리자로그인</a></span>
		</c:otherwise>
	</c:choose>
	<h1>테스트 쇼핑몰</h1>
</div>
</div>
