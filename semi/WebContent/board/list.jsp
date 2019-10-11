<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>1:1게시판</h1>
<a href="${cp }/main">홈으로</a>
<table border="1" width="600">
	<tr>
		<th>글번호</th><th>작성자</th><th>제목</th>
	</tr>
	<c:if test="${sessionScope.id == vo.writer}">
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.ennum }</td>
			<td>${vo.writer }</td>
			<td><a href="${cp }/board/detail?ennum=${vo.ennum }">${vo.title }</a></td>
		</tr>
	</c:forEach>
	</c:if>
</table>
<br>
<div>
<c:choose>
	<c:when test="${startPage>10 }">
		<a href="${cp }/board/list?pageNum=${startPage-1 }&field=${field}&keyword=${keyword}">[이전]</a>
	</c:when>
	<c:otherwise>
		이전
	</c:otherwise>
</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/board/list?pageNum=${i}&field=${field}&keyword=${keyword}"><span style='color:blue'>[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/board/list?pageNum=${i}&field=${field}&keyword=${keyword}"><span style='color:#999'>[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
<c:choose>
	<c:when test="${endPage<pageCount}">
		<a href="${cp }/board/list?pageNum=${endPage+1 }&field=${field}&keyword=${keyword}">[다음]</a>
	</c:when>
	<c:otherwise>
		다음
	</c:otherwise>
</c:choose>
</div>