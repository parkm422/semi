<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<h1>주문하기</h1>
<form method="post" action="${cp }/orderY/orderinsert">
	주문인<br>
	<input type="text" id ="ordername" name="ordername"><br>
	받는사람<br>
	<input type="text" id="getname" name="getname"><br>
	주소<br>
	<input type="text" size="50" name="address"><br>
	휴대전화번호<br>
	<input type="text" name="phone"><br><br>
	<input type="text" id="stuts" hidden="" value="준비중"><br>
	<input type="text" id="delivery" hidden="" value="준비중"><br>
	<input type="submit" value="등록">
</form>
</div>








