<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${code=='success' }">
		<h1>주문완료!!!!!</h1>
	</c:when>
	<c:otherwise>
		<h1>주문 실패!!!!!</h1>
	</c:otherwise>
</c:choose>