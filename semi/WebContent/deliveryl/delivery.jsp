<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <script type="text/javascript">
function doBlink() { 
	var blink = document.all.tags("BLINK") 
	for (var i=0; i < blink.length; i++) 
	blink[i].style.visibility = blink[i].style.visibility == "" ? "hidden" : "" 
	} 
	function startBlink() { 
	if (document.all) 
	setInterval("doBlink()",350);
	} 
	window.onload = startBlink; 

</script>
--%>
<style type="text/css">
	Table tr:nth-child(even){background-color: #f2f2f2;}


	
	th,td{
		padding: 10px 20px;
		border-radius: 10px;
	
	}
	th{
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


출처: https://pikabu.tistory.com/77 [피카부]

</style>
<div style="margin-top: 50px;">
<table border="1" style="width: 1500px; text-align: center;">
	<tr>
		<th>주문번호</th><th>수령인</th><th>주문상품</th><th>결제상태</th><th>배송정보</th>
	</tr>
	<c:forEach var="vo" items="${list3 }">
	
		<tr>
			<td>${vo.ornum }</td>
			<td>${vo.getname}</td>
			<td>${vo.pname }</td>
			<td style="color: red;"><span class="image blinking">${vo.status }</span></td>
			<c:if test="${vo.delivery=='배송중' }">
			<td style="color: #FF6EED;"><span class="image blinking">${vo.delivery }</span></td>
			</c:if>
			<c:if test="${vo.delivery=='준비중' }">
			<td >${vo.delivery }</td>
			</c:if>
			<c:if test="${vo.delivery=='배송완료' }">
			<td style="color: blue;">${vo.delivery }</td>
			</c:if>
		</tr>
		
		</c:forEach>
</table>
</div>
<br>
<div>
		<!-- 페이징처리 -->
		<c:choose>
			<c:when test="${startPageNum>10 }">
				<a href="${cp }/deliveryl/del?pageNum=${startPageNum-1}">[이전]</a>
			</c:when>
			<c:otherwise>
				[이전]
	</c:otherwise>
		</c:choose>

		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${pageNum==i }">
					<%--현재페이지 색 다르게 표시하기 --%>
					<a href="${cp }/deliveryl/del?pageNum=${i}"> <span
						style="color: red;">[${i }]</span>
					</a>
				</c:when>
				<c:otherwise>
					<a href="${cp }/deliveryl/del?pageNum=${i}"> <span
						style="color: #555;">[${i }]</span>
					</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${startPageNum<pageCount }">
				<a href="${cp }/deliveryl/del?pageNum=${endPageNum+1}">[다음]</a>
			</c:when>
			<c:otherwise>
				[다음]
	</c:otherwise>
		</c:choose>

</div>