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
			<span><a href="${cp }/member/basket?id=${sessionScope.id }">장바구니</a></span>
			<span><a href="${cp }/member/mypage">마이페이지</a></span>
			<c:if test="${sessionScope.id == 'ADMIN' }">
				<span><a href="${cp }/manager/adpage">관리자페이지</a></span>
			</c:if>
			<span><a href="${cp }/member/logout">로그아웃</a></span>
		</c:otherwise>
	</c:choose>
	<h1>테스트 쇼핑몰</h1>
</div>
<div>
	<ul>
		<li><a href="${cp }/faqboardY/list">faq리스트</a></li>
		<li><a href="${cp }/faqboardY/faqinsert">faq작성하기</a></li>
		<li><a href="${cp }/memberinfoupdateY/memberupdate?id=${sessionScope.id}">회원정보수정</a></li>
		<li><a href="${cp }/orderY/porderlist?id=${sessionScope.id}">주문리스트보기</a></li>
		
	</ul>
</div>
</div>
