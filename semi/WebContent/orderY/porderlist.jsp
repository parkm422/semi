<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>주문내역</h1>
<p><a href="${cp }/orderY/porderlist?id=${sessionScope.id}">전체글목록</a> | <a href="${cp }/main">홈으로</a>
</p>
<table border="1" width="600">
	<tr>
		<th>주문번호</th><th>회원번호</th><th>총계산금액</th><th>배송주소</th><th>주문상태</th><th>배송상태</th><th>주문날짜</th>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.ornum }</td>
			<td>${vo.mnum }</td>
			<td>${vo.amount }</td>
			<td>${vo.deladd}</td>
			<td>${vo.status}</td>
			<td>${vo.delivery }</td>
			<td>${vo.orderdate}</td>
		</tr>
	</c:forEach>
</table>
<br>
<div>
<c:choose>
	<c:when test="${startPage>10 }">
		<a href="${cp }/orderY/porderlist?pageNum=${startPage-1 }&field=${field}&keyword=${keyword}">[이전]</a>
	</c:when>
	<c:otherwise>
		이전
	</c:otherwise>
</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/orderY/porderlist?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style='color:blue'>[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/orderY/porderlist?pageNum=${i}&field=${field}&keyword=${keyword}"><span style='color:#999'>[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
<c:choose>
	<c:when test="${endPage<pageCount}">
		<a href="${cp }/orderY/porderlist?pageNum=${endPage+1 }&field=${field}&keyword=${keyword}">[다음]</a>
	</c:when>
	<c:otherwise>
		다음
	</c:otherwise>
</c:choose>
</div>

































