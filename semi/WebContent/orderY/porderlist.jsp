<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>주문내역</h1>
<p><a href="${cp }/orderY/porderlist?id=${sessionScope.id}">전체글목록</a> | <a href="${cp }/main">홈으로</a>
</p>
<table style="width:1500px;text-align:center;">
<colgroup>
	<col width="5%">
	<col width="20%">
	<col width="8%">
	<col width="5%">
	<col width="5%">
	<col width="5%">
	<col width="5%">
	<col width="5%">
	<col width="5%">
	<col width="5%">
	<col width="10%">
</colgroup>
	<tr>
		<th>주문번호</th><th>상품 이미지</th><th>상품이름</th><th>사이즈</th><th>색상</th><th>수량</th><th>배송지</th><th>배송상태</th><th>금액</th><th>구매날짜</th>
		<th>리뷰작성하기</th>
	</tr>
	<c:forEach var="vo2" items="${list}" varStatus="ss">
		<tr style="height:100px;">
			<td>${(pageNum-1)*10+ss.index+1}</td>
			<td><img src="${cp }/upload/${vo2.savefilename}" style="width:100px;heigth:150px;"></td>
			<td>${vo2.pname }</td>
			<td>${vo2.psize }</td>
			<td>${vo2.color}</td>
			<td>${vo2.cnt}</td>
			<td>${vo2.deladd}</td>
			<td>${vo2.delivery}</td>
			<td>${vo2.price*vo2.cnt}</td>
			<td>${vo2.orderdate}</td>
			<td><a href="${cp }/member/review_insert?inum=${vo2.inum }">리뷰작성</a></td>
		</tr>
	</c:forEach>
</table>
<br>
<div>
<c:choose>
	<c:when test="${startPage>10 }">
		<a href="${cp }/orderY/porderlist?pageNum=${startPage-1 }&id=${sessionScope.id}">[이전]</a>
	</c:when>
	<c:otherwise>
		이전
	</c:otherwise>
</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/orderY/porderlist?pageNum=${i}&id=${sessionScope.id}">
				<span style='color:blue'>[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/orderY/porderlist?pageNum=${i}&id=${sessionScope.id}"><span style='color:#999'>[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
<c:choose>
	<c:when test="${endPage<pageCount}">
		<a href="${cp }/orderY/porderlist?pageNum=${endPage+1 }&id=${sessionScope.id}">[다음]</a>
	</c:when>
	<c:otherwise>
		다음
	</c:otherwise>
</c:choose>
</div>

































