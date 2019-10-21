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
		<li><a href="${cp }/orderY/porderlist?id=${sessionScope.id}">주문리스트보기</a></li>
		
	</ul>
</div>
<div id="slide" style="text-align: center;">
  <input type="radio" name="pos" id="pos1" checked>
  <input type="radio" name="pos" id="pos2">
  <input type="radio" name="pos" id="pos3">
  <input type="radio" name="pos" id="pos4">
  <ul>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
  </ul>
  <p class="pos">
    <label for="pos1"></label>
    <label for="pos2"></label>
    <label for="pos3"></label>
    <label for="pos4"></label>
  </p>
</div>
</div>
