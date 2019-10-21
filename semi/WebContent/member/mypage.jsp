<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="main">
	<h3>마이페이지</h3>
	<a href="${cp }/deliveryl/del">주문상태보기</a>
	<a href="${cp }/orderY/porderlist?id=${sessionScope.id}">주문내역보기</a>
	<a href="${cp }/memberinfoupdateY/memberupdate?id=${sessionScope.id}">회원정보수정</a>
</div>