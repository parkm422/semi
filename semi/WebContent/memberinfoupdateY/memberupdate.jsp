<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	var a=false;
	var b=false;
	function pwd1check() {
		var pwd = document.getElementById("pwd").value;
		var span1 = document.getElementById("pwdchk1");
		if(pwd==""){
			span1.style.color="red";
			span1.innerHTML="입력하세요.";
			a=false;
		}else if(pwd.length<8){
			span1.innerHTML="8자이상 입력하세요."
			a=false;
		}else if(pwd.length>=8){
			span1.innerHTML="";
			a=true;
		}
	}
	function pwd2check() {
		var pwd = document.getElementById("pwd").value;
		var chkpwd = document.getElementById("chkpwd").value;
		var span2 = document.getElementById("pwdchk2");
		if (pwd ==chkpwd ) {
			span2.style.color="blue";
			span2.innerHTML = "비밀번호가 일치합니다.";
			b=true;
		}else if(chkpwd==""){
			span2.style.color="red";
			span2.innerHTML="입력하세요.";
			b=false;
		}else{
			span2.style.color="red";
			span2.innerHTML = "비밀번호가 불일치합니다.";
			b=false;
		}
	}
	function allcheck() {
		var chk=document.getElementById("chk");
		var chkpwd=document.getElementById("chkpwd").value;
		var email=document.getElementById("email").value;
		var address=document.getElementById("address").value;
		var phone=document.getElementById("phone").value;
		if(a==true && b==true && chkpwd!=="" && email!=="" && address!=="" && phone!=""){
			chk.disabled=false;
			allcheck();
		}else{
			allcheck();
		}
	}
	function home() {
		location.href="${cp }/member/mypage";
	}
</script>
<div>
<h1>회원정보수정하기</h1><br><br>
<form method="post" action="${cp }/memberinfoupdateY/memberupdate">
	<a style="font-size: 25px">아이디</a><br>
	<input type="text" name="id" id="id" value="${sessionScope.id}" readonly="readonly" ><br>
	<a style="font-size: 25px">비밀번호</a><br>
	<input type="text" name="pwd" id="pwd" value="${vo.pwd }" onkeyup="pwd1check()"><br>
	<span id="pwdchk1"></span><br>
	<a style="font-size: 25px">비밀번호 확인</a><br>
	<input type="text" name="chkpwd" id="chkpwd" value="${vo.pwd}"  onkeyup="pwd2check()"><br>
	<span id="pwdchk2"></span> item="${email}"
	<br>
	<a style="font-size: 20px">이메일</a><br>
	<c:forEach var="vo1" items="${email}" varStatus="ss">
	<input type="text"name="email" id="email" value="${vo1.email}" ><br>
	</c:forEach>
	<a style="font-size: 20px">주소</a><br>
	<textarea rows="5" cols="60" name="address" id="address" >${vo.address}</textarea><br><br>
	<a style="font-size: 20px">전화번호</a><br>
	<input type="text" name="phone" id="phone" value="${vo.phone }" onkeyup="allcheck()"><br><br>
	<input style="width:70px;height: 35px; text-align: center;font-size: 20px" type="submit" id="chk" value="등록" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input style="width:70px;height: 38px; text-align: center;font-size: 25px" type="button" id="re" value="취소" onclick="home()" >
</form>
</div>








