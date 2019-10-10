<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="footer">
<div id="board_menu" style="text-align: right;">
<c:choose>
		<c:when test="${sessionScope.id !=null }">
			<span><a href="${cp }/board/1and1board.jsp">1:1게시판</a></span>
			<span><a href="${cp }/board/list.jsp">글목록</a></span>
		</c:when>
		<c:otherwise>
			<h2>메롱</h2>
		</c:otherwise>
	</c:choose>
</div>
</div>