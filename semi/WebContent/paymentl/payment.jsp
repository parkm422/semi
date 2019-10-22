<%@page import="jdbc.JdbcUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
td, th{
 padding:10px 30px;
 border-radius: 10px;
}
th{
	background-color: pink;
}
</style>

<script type="text/javascript">
	
	function gopay() {
		var paymethod=document.getElementsByName("paymethod")[0];
		var i=paymethod.selectedIndex;
		if(i==0){
			document.getElementById("main1").style.display="block";
		}else if(i==1){
			document.getElementById("main2").style.display="block";
		}else if(i==2){
			document.getElementById("main1").style.display="block";
		}
	}
	function acount() {
		var bank=document.getElementsByName("bank")[0];
		var i=bank.selectedIndex;
		var main3 = document.getElementById("main3");
		if(i==0){
			main3.style.display = "block";
		}else{
			alert("우리은행 계좌번호:987654321-33-987654321 입금할 금액:");
			location.href="${pageContext.request.contextPath}/main";
		}
		
	}
	function selcard() {
		var card=document.getElementsByName("card")[0];
		var i=card.selectedIndex;
		if(i!=-1){
			document.getElementById("information").style.display="block";
		}
	}
	function completion(){
		var card=document.getElementsByName("card")[0];
		var i=card.value;
		var num=document.getElementsByName("num").value;
		var num1=document.getElementsByName("num1").value;
		var num2=document.getElementsByName("num2").value;
		var num3=document.getElementsByName("num3").value;
		if(i!=-1){
			alert("카드사:"+card.value+" "+"카드번호:"+num+"-"+num1+"-"+num2+"-"+num3);
			location.href="${pageContext.request.contextPath}/main";
		}
	}


</script>


<div id="main">
	
	<table border="1" style="width: 1000px; text-align: center;">
		<tr>
			<th>상품명</th><th>상품이미지</th><th>수량</th><th>가격</th>
			
		</tr>
		
		<c:forEach var="map" items="${list }">
		<tr>
		<td>${map.pname}</td>
		<td><img src="${cp }/upload/${map.savefilename }" style="width:100px;height:100px;"></td>
		<td>${map.cnt }</td>
			
		<td>${map.price }</td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan="3" style="background-color: #787878;">총결제금액</td>
		<td style="background-color: #787878;">${amount }</td>
		</tr>
		
		
	</table>
<form method="post" action="${cp }/orderY/orderinsert">
<input type="text" name="amount" value="${amount }" hidden="">
<select name="paymethod">
<option value="계좌이체">계좌이체</option>
<option value="카드">카드</option>
<option value="무통장입금">무통장입금</option>
<option value="핸드폰">핸드폰</option>
</select><br>
<input type="button" value="확인" onclick="gopay()">
<div id="main1" style="display: none;">
	<select name="bank">
		<option value="국민은행">국민은행</option>
		<option value="우리은행">우리은행</option>
	</select>
	
	
	<input type="button" value="확인" onclick="acount()">
	
</div>
<div id="main3" style="display:none;">
	<textarea rows="10" cols="140">국민은행 계좌번호:123456789-55-123456789 입금할 금액:${amount }원</textarea><br>
	<input type="text" name="status" id="status"  value="${status }" hidden=""><br>
	<input type="text" name="delivery" id="delivery"  value="${delivery }" hidden=""><br>
	<input type="text" size="50" id="deladd" name="deladd" value="${deladd }" hidden=""><br>
	<input type="text" name="getname" id="getname" value="${getname }" hidden=""><br>
	<div style="margin-right:650px; text-align: right;">
			총금액:${amount }
			<br>입금액:<input type="text" style="width: 100px;" name="inamount">
			<input type="submit" value="결제">
		</div>
	
</div>
</form>
<form method="post" action="${cp }/orderY/orderinsert">
<input type="text" name="amount" value="${amount }" hidden="">
<div id="main2" style="display: none">
	카드사선택 <select name="card">
		<option value="국민카드">국민</option>
		<option value="우리카드">우리</option>
		<option value="신한카드">신한</option>
		<option value="농협카드">농협</option>
		<option value="삼성카드">삼성</option>
	</select>
	<input type="button" value="확인" onclick="selcard()">
	<div id="information" style="display: none">
		카드번호 : <input type="text" size="5" name="num">-<input type="text" size="5"name="num1">-<input type="text" size="5" name="num2">-<input type="password" size="5" name="num3"><br>
		cvv번호: <input type="text" size="3" name="num4">
		<br>입금액:<input type="text" style="width: 100px;" name="inamount">
		
		<input type="submit" value="확인">	
		<input type="text" name="status" id="status"  value="${status }" hidden=""><br>
		<input type="text" name="delivery" id="delivery"  value="${delivery }" hidden=""><br>
		<input type="text" size="50" id="deladd" name="deladd" value="${deladd }" hidden=""><br>
		<input type="text" name="getname" id="getname" value="${getname }" hidden=""><br>	
	</div>

</div>
</form>
</div>