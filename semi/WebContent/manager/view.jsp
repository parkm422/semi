<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div style="text-align: center;">
 <h1>주문 상세정보</h1>
 </div>
<table border="1" width="1000">
	<tr>
		<th>주문번호</th><th>고객명</th><th>아이디</th><th>받는사람명</th><th>상품명</th><th>사이즈</th><th>색상</th><th>수량</th><th>가격</th><th>결제상태 확인</th><th>배송정보 확인</th>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.ornum }</td>
			<td>${vo.name }</td>
			<td>${vo.id }</td>
			<td>${vo.gname }</td>
			<td>${vo.pname }</td>
			<td>${vo.psize }</td>
			<td>${vo.color }</td>
			<td>${vo.cnt }</td>
			<td>${vo.price }</td>
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