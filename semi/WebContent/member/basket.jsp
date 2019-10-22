<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="main">
	<div style="margin-top: 50px;margin-left:50px;">
		<form method="get" action="${cp }/orderY/orderinsert">
		<input type="text" name="id" id="id" value="${sessionScope.id}" hidden="" ><br>
		<div style="margin-bottom: 30px;"><h3>장바구니 목록</h3></div>
			<table style="width:1300px; text-align: center;">
				<colgroup>
					<col width="5%">
					<col width="15%">
					<col width="25%">
					<col width="10%">
					<col width="15%">
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
				
				<c:forEach var="basket" items="${requestScope.basketList }" varStatus="ii">
					<tr>
						<td>
							<span>${(pageNum-1)*5+ii.index+1 }</span>
						</td>
						<td>
							<img src="${cp }/upload/${basket.savefilename }" style="width:70px;height:70px;">
						</td>
						<td>
							<div><a href="${cp }/product/detail?inum=${basket.inum }" style="color:black;text-decoration: none;">${basket.pname }</a></div>
							<div><span style="color:gray;">[${basket.colorname }]</span>&nbsp;&nbsp;<span style="color:gray;">[size : ${basket.psize }]</span></div>
						</td>
						<td>
							<span>${dc.format(basket.price) }원</span>
						</td>
						<td>
							<input type="button" value="-" style="width:20px;height:20px;font-size:20px;background-color: white;" onclick="bplus('${ii.index}')">
							<input type="text" style="width:20px;" id="cnt_${ii.index }" name="cnt" value="${basket.cnt}">
							<input type="button" value="+" style="width:20px;height:20px;font-size:20px;background-color: white;" onclick="bplus('${ii.index}')">
							<input type="button" value="수정" style="width:30px;height:20px;font-size:12px;background-color: white;" onclick="cupdate(${ii.index},${basket.bnum})">
						</td>
						<td>
							<span>${dc.format(basket.price * basket.cnt) }원</span>
						</td>
						<td>
							<input type="button" value="상품 삭제" style="width:80px;height:40px;background-color: white;" onclick="bdelete(${basket.bnum})">
						</td>
						<td>
							<span>${basket.regdate }</span>
						</td>
					</tr>
				</c:forEach>
			</table>
				<div style="text-align: right;width:1300px;">
					<input type="submit" value="주문하기" style="width:150px;height:50px;color:white;background-color: black;">
				</div>
		</form>	
			<!-- 장바구니 페이징처리 -->
			<div style="text-align: center;font-size:20px;">
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
			<div>
				<c:if test="${endPageNum<basketCount }">
					<a href="${cp }/member/basket?pageNum=${startPageNum-1}">다음</a>
				</c:if>
			</div>
		</div>
	</div>
</div>
<script>
//장바구니에서 선택한거 삭제
var dxhr=null;
function bdelete(bnum) {

		dxhr=new XMLHttpRequest();
		dxhr.onreadystatechange=deleteOk;
		dxhr.open('post', '${cp }/member/basket?bnum='+bnum,true);
		dxhr.send();
}
function deleteOk(){
	if(dxhr.readyState==4 && dxhr.status==200){
		var data=dxhr.responseText;
		var json=JSON.parse(data);
		if(json.code=='success'){
			location.href="${cp }/member/basket?id=${sessionScope.id}";
		}else{
			alert("삭제실패!");
		}
	}
}
//장바구니 물품 갯수 변경
function bplus(a) {
	
	var cnt=document.getElementById("cnt_"+a);
	console.log(cnt.value);
	cnt.value=parseInt(cnt.value)+1;
}

function bminus(a) {
	var cnt=document.getElementById("cnt_"+a);
	cnt.value=parseInt(cnt.value)-1;
	if(cnt.value==0){
		cnt.value=1;
	}
}
//장바구니 물품 갯수 수정
var cxhr=null;
function cupdate(a,bnum) {
	var cnt=document.getElementById("cnt_"+a).value;
	cxhr=new XMLHttpRequest();
	cxhr.onreadystatechange=updateOk;
	cxhr.open('post', '${cp }/member/basketupdate?cnt='+cnt+'&bnum='+bnum,true);
	cxhr.send();
}
function updateOk(){
	if(cxhr.readyState==4 && cxhr.status==200){
		var data=cxhr.responseText;
		var json=JSON.parse(data);
		if(json.code=='success'){
			location.href="${cp }/member/basket?id=${sessionScope.id}";
		}else{
			alert("삭제실패!");
		}
	}
}
</script>

