<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="get" action="${cp }/orderY/orderinsert">
<div id="main">
<input type="text" name="id" id="id" value="${sessionScope.id}" hidden="" ><br>
	<h3>회원 장바구니 페이지</h3>
	<div>
		<table style="width:1500px; text-align: center;">
			<colgroup>
				<col width="10%">
				<col width="20%">
				<col width="25%">
				<col width="10%">
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
				<th>등록일</th>
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
						<div ><p >${basket.pname } [${basket.colorname }]</p></div>
						<div ><p >[size : ${basket.psize }]</p></div>
					</td>
					<td>
						<span >${basket.price }</span>
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
						<input type="button" value="상품삭제" onclick="bdelete(${basket.bnum})">
					</td>
					<td>
						<span>${basket.regdate }</span>
					</td>
				</tr>
			</c:forEach>
		</table>
			<div style="text-align: center;">
				<input type="submit" value="주문하기">
			</div>
</form>
		
		<!-- 장바구니 페이징처리 -->
		<div style="text-align: center;">
			<c:if test="${startPageNum>5 }">
				<a href="${cp }/member/basket?pageNum=${startPageNum-1}">이전</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum == i }">
				<a href="${cp }/member/basket?pageNum=${i}">
					<span style="color:blue;">[${i }]</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/member/basket?pageNum=${i}">
					<span style="color:gray;">[${i }]</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
			
			<c:if test="${endPageNum<basketCount }">
				<a href="${cp }/member/basket?pageNum=${startPageNum-1}">다음</a>
			</c:if>
		</div>
		
	</div>
</div>
<script>
var dxhr=null;
function bdelete(bnum) {

		dxhr=new XMLHttpRequest();
		dxhr.onreadystatechange=deleteOk;
		xhr.onreadystatechange=success;
		xhr.open('get', '${cp }/member/basket?bnum='+bnum,true);
		xhr.send();
}
function deleteOk(){
	if(dxhr.readyState==4 && dxhr.status==200){
		var data=dxhr.responseText;
		var json=JSON.parse(data);
		if(json.code=='success'){
			location.href="${cp }/member/basket.jsp?id=${sessionScope.id}";
		}else{
			alert("삭제실패!");
		}
	}
}
</script>

