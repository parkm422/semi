<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">

Table td:nth-child(even){background-color: #f2f2f2;}
td, th{
 	padding:10px 30px;
 	border-bottom: 2px solid gray;
}
th{
	background-color:silver;
}
td{
	background-color: 	#8c8c8c;
}
	.blinking{
	-webkit-animation:blink 0.3s ease-in-out infinite alternate;
    -moz-animation:blink 0.3s ease-in-out infinite alternate;
    animation:blink 0.3s ease-in-out infinite alternate;
}
@-webkit-keyframes blink{
    0% {opacity:0;}
    100% {opacity:1;}
}
@-moz-keyframes blink{
    0% {opacity:0;}
    100% {opacity:1;}
}
@keyframes blink{
    0% {opacity:0;}
    100% {opacity:1;}
}

</style>

<div style="text-align: center;">

 <h1 style="margin-bottom: 20px;">주문 상세정보</h1>

<table style="width: 1500px; text-align: center;">
	<tr>
		<th>주문번호</th><th>고객명</th><th>아이디</th><th>상품명</th><th>사이즈</th><th>색상</th><th>수량</th><th>가격</th><th>결제상태 확인</th><th>배송정보 확인</th>
	</tr>
	
	<c:forEach var="vo" items="${list }" >
		<form method="post" action="${cp }/managerP/deliveryup?ornumm=${vo.ornumm }&delivery=${vo.delivery}">
		<tr>
			<td id="ornumm">${vo.ornumm }</td>
			<td >${vo.name }</td>
			<td >${vo.id }</td>
			<td >${vo.pname }</td>
			<td >${vo.psize }</td>
			<td >${vo.color }</td>
			<td >${vo.cnt }</td>
			<td >${dc.format((vo.price) * vo.cnt)}원</td>
			<td style="color: red;">${vo.status }</td>
			<c:if test="${vo.delivery=='배송중' }">
			<td ><button type="submit" style="width: 100px; border-radius: 0.8em; color: blue;"><span class="image blinking">${vo.delivery }</span></button></td>
			</c:if>		
			<c:if test="${vo.delivery=='배송완료' }">
			<td><button type="submit" style="width: 100px; border-radius: 0.8em; color: red;">${vo.delivery }</button>
			</c:if>
			<c:if test="${vo.delivery=='준비중' }">
			<td><button type="submit" style="width: 100px; border-radius: 0.8em; color: #66CC99;">${vo.delivery }</button></td>
			</c:if>
		</tr>
		</form>
	</c:forEach>
	</table>
</div>
<br>
<div>
		<!-- 페이징처리 -->
		<c:choose>
			<c:when test="${startPageNum>10 }">
				<a href="${cp }/manager/view?pageNum=${startPageNum-1}">[이전]</a>
			</c:when>
			<c:otherwise>
				[이전]
	</c:otherwise>
		</c:choose>

		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${pageNum==i }">
					<%--현재페이지 색 다르게 표시하기 --%>
					<a href="${cp }/manager/view?pageNum=${i}"> <span
						style="color: red;">[${i }]</span>
					</a>
				</c:when>
				<c:otherwise>
					<a href="${cp }/manager/view?pageNum=${i}"> <span
						style="color: #555;">[${i }]</span>
					</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${startPageNum<pageCount }">
				<a href="${cp }/manager/view?pageNum=${endPageNum+1}">[다음]</a>
			</c:when>
			<c:otherwise>
				[다음]
	</c:otherwise>
		</c:choose>

	</div>