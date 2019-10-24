<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	xhr = null;
	function idcheck(){
		var id = document.getElementById("id").value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open('get','${pageContext.request.contextPath}/member/idcheck?id='+id,true);
		xhr.send();
	}
	function callback(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var data = xhr.responseText;
			var check = JSON.parse(data);
			var idcheck = document.getElementById("idc");
			var id = document.getElementById("id").value;
			if(check.check == true || id.length<4 || id == ""){
				idcheck.innerHTML = "사용할 수 없는 아이디입니다.";
			}else if(check.check == false && id.length>3 || id != ""){
				idcheck.innerHTML = "사용 가능한 아이디입니다.";
			}
			
		}
	}
	
	function pwdcheck(){
		var pwd1 = document.getElementById("pwd1").value;
		var pwd2 = document.getElementById("pwd2").value;
		
		var pwdc = document.getElementById("pwdc");
		
		if(pwd1 != pwd2){
			pwdc.style.color = "red";
			pwdc.innerHTML = "비밀번호가 일치하지 않습니다.";
		}else if(pwd1 == pwd2){
			pwdc.style.color = "blue";
			pwdc.innerHTML = "비밀번호가 일치합니다.";
		}
		
	}
	
	
	//회원가입 유효성 체크
	function join(){
		
		var docId = document.getElementById("id");
		var id = docId.value;
		
		var docName = document.getElementById("name");
		var name = docName.value;
		
		if(name == ""){
			alert("이름을 입력해주세요.");
			docName.focus();
			return false;
		}
		if(name.length<2){
			alert("이름은 2자이상 입력해주세요.");
			docName.focus();
			return false;
		}
		
		for(var i = 0; i<id.length; i++){
			var ch = id.charAt(i);
			if(!(ch>='a' && ch<='z') && !(ch>='A' && ch<='Z') && !(ch>='1' && ch<='9')){
				alert("아이디는 영문과 숫자만 입력 가능합니다.");
				docId.focus();
				return false;
			}
		}
		
		if(id.length<4 || id.length>12){
			alert("아이디는 4~12자까지 입력가능합니다.");
			docId.focus();
			return false;
		}
		
		var docPwd = document.getElementsByName("pwd");
		var pwd1 = docPwd[0].value;
		var pwd2 = docPwd[1].value;
		
		if(pwd1 != pwd2){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		if(pwd1.length<8 || pwd1.length>15){
			alert("비밀번호는 8~15자까지 입력가능합니다.");
			return false;
		}
		return true;
		
	}
	
</script>
</head>
<body>
<div style="margin: auto;width:450px;">
	<div style="width:100%; margin:30px;">
		<div style="padding-left: 70px;"><a href="${cp }/main" style="font-size: 30px;font-weight: bold; text-decoration: none;color:green;">테스트 쇼핑몰</a></div>
		<h1 style="margin-left:100px;">회원가입</h1>
		<form method="post" action="${pageContext.request.contextPath }/member/join" onsubmit="return join()">
		
			<div style="margin-bottom: 10px;">이름</div>
			<div style="width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;margin-bottom: 30px;">
				<input type="text" name="name" id="name" style="border:none;width:300px;height:25px;">
			</div>
			<div style="margin-bottom: 10px;">아이디</div>
			<div style="width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;margin-bottom: 5px;">
				<input type="text" name="id" id="id" style="border:none;width:300px;height:25px;" onkeyup="idcheck()">
			</div>
			
			<div style="color:red;font-size:12px;width:350px;height:30px;" id="idc"></div>
			
			<div style="margin-bottom: 10px;">비밀번호</div>
			<div style="width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;margin-bottom: 30px;">
				<input type="password" name="pwd" id="pwd1" style="border:none;width:300px;height:25px;">
			</div>
			
			<div style="margin-bottom: 10px;">비밀번호확인</div>
			<div style="width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;margin-bottom: 5px;">
				<input type="password" name="pwd" id="pwd2" style="border:none;width:300px;height:25px;" onkeyup="pwdcheck()">
			</div>
			
			<div style="color:red;font-size:12px;width:350px;height:30px;" id="pwdc"></div>
			
			<div style="margin-bottom: 10px;">이메일</div>
			<div style="width:350px;height:40px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;margin-bottom: 30px;">
				<input type="text" size="50" name="email" style="border:none;width:300px;height:25px;">
			</div>
			<div style="margin-bottom: 10px;">주소</div>
			<div style="width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;margin-bottom: 30px;">
				<input type="text" size="100" name="address" style="border:none;width:340px;height:25px;">
			</div>
			
			<div style="margin-bottom: 10px;">연락처</div>
			<div style="width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;margin-bottom: 30px;">
				<input type="text" name="phone" style="border:none;width:300px;height:25px;">
			</div>
			
			<div style="margin-top: 20px;">
				<input type="submit" value="가입" style="width:360px; height:60px; background-color: black;color:white;margin-bottom: 30px;cursor: pointer;border:none;">
			</div>
		</form>
	</div>
</div>
</body>
</html>