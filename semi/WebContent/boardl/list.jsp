<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>나의 문의 내역</h1>

<table style="width: 1500px; text-align: center;">
	<tr>
		<th>글번호</th><th>작성자</th><th>제목</th><th>관리자답변</th>
	</tr>
	
	<c:forEach var="vo" items="${list }">
		<c:if test="${sessionScope.id == vo.writer or sessionScope.id=='ADMIN'}">
		<tr>
			<td>${vo.ennum }</td>
			<td>${vo.writer }</td>
			<td><a href="${cp }/boardl/detail?ennum=${vo.ennum }">${vo.title }</a></td>
			<c:choose >
			<c:when test="${vo.answer!=null }">
			<td><div style="color: red;">확인</div></td>
			</c:when>
			
			<c:otherwise>
			<td>미확인</td>
			</c:otherwise>
			</c:choose>
		</tr>
		</c:if>
	</c:forEach>
	
</table>
<br>
<div>
<c:choose>
	<c:when test="${startPage>10 }">
		<a href="${cp }/boardl/list?pageNum=${startPage-1 }&field=${field}&keyword=${keyword}">[이전]</a>
	</c:when>
	<c:otherwise>
		이전
	</c:otherwise>
</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/boardl/list?pageNum=${i}&field=${field}&keyword=${keyword}"><span style='color:blue'>[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/boardl/list?pageNum=${i}&field=${field}&keyword=${keyword}"><span style='color:#999'>[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
<c:choose>
	<c:when test="${endPage<pageCount}">
		<a href="${cp }/boardl/list?pageNum=${endPage+1 }&field=${field}&keyword=${keyword}">[다음]</a>
	</c:when>
	<c:otherwise>
		다음
	</c:otherwise>
</c:choose>
</div>