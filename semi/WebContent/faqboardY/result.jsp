<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${code=='success' }">
		<h1>faq글등록성공!!!!!</h1>
	</c:when>
	<c:otherwise>
		<h1>faq글등록실패!!!!!</h1>
	</c:otherwise>
</c:choose>