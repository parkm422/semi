<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<h1>주문하기</h1>
<form method="post" action="${cp }/orderY/orderinsert">
	<c:forEach var="vo1" items="${list }">
	<input type="text" name="id" id="id" value="${sessionScope.id}" hidden="" ><br>
	주문인<br>
	<input type="text" id ="name" name="name" value="${vo1.name}"><br>
	받는사람<br>
	<input type="text" id="getname" name="getname"><br>
	주소<br>
	<input type="text" size="50" id="address" name="address" value="${vo1.address}"><br>
	휴대전화번호<br>
	<input type="text" id="phone" name="phone" value="${vo1.phone}"><br>
	상품설명<br>
	<input type="text" id="pinfo" name="pinfo" readonly="readonly"><br>
	총계산액<br>
	<input type="text" id="tatcount" name="tatcount"  readonly="readonly"><br>
	<input type="text" name="amount" id="amount" hidden="" value="0"><br>
	<input type="text" name="status" id="status" hidden="" value="준비중"><br>
	<input type="text" name="delivery" id="delivery" hidden="" value="준비중"><br>
	<input type="submit" value="등록">
	</c:forEach>
</form>
</div>








