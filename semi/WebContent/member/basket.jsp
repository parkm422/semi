<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="main">
	<h3>회원 장바구니 페이지</h3>
	<div>
		<table style="width:1500px; text-align: center;">
			<colgroup>
				<col width="10%">
				<col width="20%">
				<col width="30%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
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
					<td>
						<span>${basket.bnum }</span>
					</td>
					<td>
						<img src="${cp }/upload/${basket.savefilename }" style="width:100px;height:100px;">
					</td>
					<td>
						<div><p>${basket.pname } [${basket.colorname }]</p></div>
						<div><p>[size : ${basket.psize }]</p></div>
					</td>
					<td>
						<span>${basket.price }</span>
					</td>
					<td>
						<input type="button" value="-" style="width:20px;height:20px;font-size:20px;">
						<span>${basket.cnt }</span>
						<input type="button" value="+" style="width:20px;height:20px;font-size:20px;">
					</td>
					<td>
						<span>${basket.price * basket.cnt }</span>
					</td>
					<td>
						<input type="button" value="상품삭제">
					</td>
				</tr>		
			</c:forEach>
		</table>
	</div>
</div>