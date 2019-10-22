<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<div>
<h1>주문하기</h1>

<form method="get" action="${cp }/paymentl/pay">
	<c:forEach var="vo1" items="${list }">
	<input type="text" name="id" id="id" value="${sessionScope.id}" hidden="" ><br>
	
	주문인<br>
	<input type="text" id ="name" name="name" value="${vo1.name}"><br>
	받는사람<br>
	<input type="text" id="getname" name="getname"><br>
	주소<br>
	<input type="text" size="50" id="deladd" name="deladd" value="${vo1.address}"><br>
	휴대전화번호<br>
	<input type="text" id="phone" name="phone" value="${vo1.phone}"><br>
	
</c:forEach>
상품설명<br>

<c:forEach var="basket1" items="${requestScope.basketList1}" varStatus="ss">
	<input type="text" size="30" id="pname_${ss.index }" name="pname" readonly="readonly" value="${basket1.pname},${basket1.colorname }, size : ${basket1.psize },갯수:${basket1.cnt}"><br>
	<input type="text" size="10" class="price"id="price_${ss.index }" name="price"  readonly="readonly" value="금액:${basket1.price*basket1.cnt}원"><br>
	<input type="text" name="cnt" value="${requestScope.cnt }" hidden="">
	<input type="text" name="savefilename" value="${requestScope.savefilename }" hidden="">
	</c:forEach>
	총계산액<br>
	<input type="text" size="10" name="amount" id="amount"  value="${requestScope.nn}원" readonly="readonly"><br>
	<input type="text" name="pnames" id="pnames" value="${requestScope.pnames }" hidden=""><br>
	
 	
 	<input type="text" name="status" id="status" hidden="" value="결제완료"><br>


	<input type="text" name="delivery" id="delivery" hidden="" value="준비중"><br>
	
	


	<input type="submit" value="결제하기">

</form>
</div>








