<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${cp }/css/common.css">
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	xhr = null;
	function idcheck(){
		var id = document.getElementById("id").value;
		alert(id);
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open('get','${cp}/member/idcheck?id='+id,true);
		xhr.send();
	}
	function callback(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var data = xhr.responseText;
			var check = JSON.parse(data);
			var idcheck = document.getElementById("idc");
			if(check.check == true){
				idcheck.innerHTML = "이미 사용중인 아이디입니다.";
			}else{
				idcheck.innerHTML = "사용 가능한 아이디입니다.";
			}
			
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
<div style="margin:0 auto;">
	<div style="width:90%; height:800px; margin:30px;">
		<h1>회원가입</h1>
		<form method="post" action="${pageContext.request.contextPath }/member/join" onsubmit="return join()">
			<div><label>이름</label><input type="text" name="name" id="name"></div>
			<div>
				<label>아이디</label>
				<input type="text" name="id" id="id">
				<input type="button" value="중복검사" onclick="idcheck()">
				<span style="color:red;font-size:12px;" id="idc"></span>
			</div>
			<div><label>비밀번호</label><input type="password" name="pwd" id="pwd1"></div>
			<div><label>비밀번호확인</label><input type="password" name="pwd" id="pwd2"></div>
			<div><label>이메일</label><input type="text" size="50" name="email"></div>
			<div><label>주소</label><input type="text" size="100" name="address"></div>
			<div><label>연락처</label><input type="text" name="phone"></div>
			<input type="submit" value="가입">
		</form>
	</div>
</div>
</body>
</html>