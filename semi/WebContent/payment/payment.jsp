<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>payment.jsp</title>
<script type="text/javascript">
	
	function gopay() {
		var paymethod=document.getElementsByName("paymethod")[0];
		var i=paymethod.selectedIndex;
		if(i==0){
			document.getElementById("main").style.display="block";
		}else if(i==1){
			document.getElementById("main1").style.display="block";
		}
	}
	function acount() {
		var bank=document.getElementsByName("bank")[0];
		var i=bank.selectedIndex;
		
		if(i==0){
			alert("국민은행 계좌번호:123456789-55-123456789 입금할 금액:");
		
			location.href="${pageContext.request.contextPath}/main";
		}
	}
	function card() {
		var card=document.getElementsByName("card")[0];
		var i=card.selectedIndex;
		if(i!=null){
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
		if(i!=null){
			alert("카드사:"+card.value+" "+"카드번호:"+num+"-"+num1+"-"+num2+"-"+num3);
			location.href=${cp}"/main";
		}
	}


</script>
</head>
<body>
총 금액 = <input type="text" name="amount" size="10" value="${vo.AMOUNT }"><br><br>
<select name="paymethod">
<option value="계좌이체">계좌이체</option>
<option value="카드">카드</option>
<option value="무통장입금">무통장입금</option>
<option value="핸드폰">핸드폰</option>
</select><br>
<input type="button" value="확인" onclick="gopay()">
<div id="main" style="display: none">
	<select name="bank">
		<option value="국민은행">국민은행</option>
		<option value="우리은행">우리은행</option>
	</select>
	<input type="button" value="확인" onclick="acount()">
</div>
<div id="main1" style="display: none">
	카드사선택 <select name="card">
		<option value="국민카드">국민</option>
		<option value="우리카드">우리</option>
		<option value="신한카드">신한</option>
		<option value="농협카드">농협</option>
		<option value="삼성카드">삼성</option>
	</select>
	<input type="button" value="확인" onclick="card()">
	<div id="information" style="display: none">
		카드번호 : <input type="text" size="5" name="num">-<input type="text" size="5"name="num1">-<input type="text" size="5" name="num2">-<input type="password" size="5" name="num3"><br>
		cvv번호: <input type="text" size="3" name="num4">
		<input type="button" value="확인" onclick="completion()">		
	</div>

</div>
</body>
</html>