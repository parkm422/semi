<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="main">
	<h3>회원 장바구니 페이지</h3>
	<div>
		<table style="width:1500px;">
			<colgroup>
				<col width="100px">
			</colgroup>
			<tr>
				<th>번호</th>
				<th>이미지</th>
				<th>상품명(옵션)</th>
				<th>판매가</th>
				<th>수량</th>
				<th>주문금액</th>
				<th>주문관리(삭제)</th>
			</tr>
			<c:forEach var="basket" items="${requestScope.basketList }">
				<tr>
					<td><c:out value="${basket.savefilename }"/></td>
					
				</tr>		
			</c:forEach>
		</table>
	</div>
</div>