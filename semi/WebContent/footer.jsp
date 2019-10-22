<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="footer">
<div id="board_menu" style="text-align: right;">
<c:choose>
		<c:when test="${sessionScope.id !=null }">
			<hr size="1px" color="red" noshade="noshade"></hr>
			<div style="text-align: center; color: pink;"><h2>주소 : 구매할시 마구 뿌립니동~</h2></div>
			<hr size="2px" color="black" noshade="noshade"></hr>
			
		</c:when>
		<c:otherwise>
			<div style="text-align: center; color: pink;"><h2>주소 : 구매할시 마구 뿌립니동~</h2></div>
		</c:otherwise>
	</c:choose>
</div>
</div>