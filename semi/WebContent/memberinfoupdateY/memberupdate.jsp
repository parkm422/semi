<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function pwd1check() {
		var pwd = document.getElementById("pwd").value;
		var span1 = document.getElementById("pwdchk1");
		if(pwd==""){
			span1.style.color="red";
			span1.innerHTML="입력하세요.";
		}else if(pwd.length<8){
			span1.innerHTML="8자이상 입력하세요."
		}else if(pwd.length>=8){
			span1.innerHTML="";
		}
	}
	function pwd2check() {
		var pwd = document.getElementById("pwd").value;
		var chkpwd = document.getElementById("chkpwd").value;
		var span2 = document.getElementById("pwdchk2");
		if (pwd ==chkpwd ) {
			span2.style.color="blue";
			span2.innerHTML = "비밀번호가 일치합니다.";
		}else if(chkpwd==""){
			span2.style.color="red";
			span2.innerHTML="입력하세요.";
		}else{
			span2.style.color="red";
			span2.innerHTML = "비밀번호가 불일치합니다.";
		}
	}
	function allcheck() {
		var chk=document.getElementById("chk");
		var id=document.getElementById("id").value;
		var pwd=document.getElementById("pwd").value;
		var chkpwd=document.getElementById("chkpwd").value;
		var email=document.getElementById("email").value;
		var address=document.getElementById("address").value;
		var phone=document.getElementById("phone").value;
		if(id!=="" && pwd!=="" && chkpwd!=="" && email!=="" && address!=="" && phone!=""){
			chk.disabled=false;
		}
	}
</script>
<div>
<h1>회원정보수정하기</h1>
<form method="post" action="${cp }/memberinfoupdateY/memberupdate">
	아이디<br>
	<input type="text" name="id" id="id" value="${sessionScope.id}" readonly="readonly" ><br>
	비밀번호<br>
	<input type="text" name="pwd" id="pwd" value="${vo.pwd }" onkeyup="pwd1check()"><br>
	<span id="pwdchk1"></span><br>
	비밀번호 확인<br>
	<input type="text" name="chkpwd" id="chkpwd" value="${vo.pwd}"  onkeyup="pwd2check()"><br>
	<span id="pwdchk2"></span>
	<br>
	이메일<br>
	<input type="text" name="email" id="email" size="50" value="${vo.email}" "><br>
	주소<br>
	<textarea rows="5" cols="60" name="address" id="address" >${vo.address}</textarea><br><br>
	연락처<br>
	<input type="text" name="phone" id="phone" value="${vo.phone }" onkeyup="allcheck()"><br><br>
	<input type="submit" id="chk" value="등록" disabled="disabled" >
</form>
</div>








