<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1" width="600">
	<tr>
		<th>주문번호</th><th>수령인</th><th>주문상품</th><th>주문상태</th><th>배송정보</th>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.ornum }</td>
			<td>미정</td>
			<td>${vo.pname }</td>
			<td>${vo.status }</td>
			<td>${vo.delivery }</td>
		</tr>
		
		</c:forEach>
</table>
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