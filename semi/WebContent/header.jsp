<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
	<div>
		<div id="login_menu" style="text-align: right;padding:10px;">
			<c:choose>
				<c:when test="${empty sessionScope.id }">
		
					<span><a href="${cp }/member/join" style="color:white;margin-left: 10px;text-decoration: none;">회원가입</a></span>
					<span><a href="${cp }/member/login" style="color:white;margin-left: 10px;text-decoration: none;">회원로그인</a></span>
					<span><a href="${cp }/manager/login" style="color:white;margin-left: 10px;text-decoration: none;">관리자로그인</a></span>
		
				</c:when>
				
				<c:when test="${not empty sessionScope.id && empty sessionScope.type  }">
					<span><a href="${cp }/member/basket?id=${sessionScope.id }" style="text-decoration: none;color:white;">장바구니</a></span>
					<span><a href="${cp }/member/mypage" style="color:white;margin-left: 10px;text-decoration: none;">마이페이지</a></span>
					<span><a href="${cp }/member/logout" style="color:white;margin-left: 10px;text-decoration: none;">로그아웃</a></span>
				</c:when>
				<c:when test="${not empty sessionScope.id && not empty sessionScope.type }">
						<span><a href="${cp }/manager/adpage" style="color:white;margin-left: 10px;text-decoration: none;">관리자페이지</a></span>
						<span><a href="${cp }/member/logout" style="color:white;margin-left: 10px;text-decoration: none;">로그아웃</a></span>
				</c:when>
			</c:choose>
			<div style="margin:30px;"><h1><a href="${cp }/main" style="text-decoration: none;color: white;">테스트 쇼핑몰</a></h1></div>
		</div>
	
	</div>
	<div style="position: absolute;top: 170px;left:30px;"><a href="${cp }/faqboardY/list" style="color:white;text-decoration: none;">FAQ</a></div>
</div>
