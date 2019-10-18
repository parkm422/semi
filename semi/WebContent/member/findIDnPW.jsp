<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/findIdnPW</title>
</head>
<body>
	<h1>아이디 찾기</h1>
	<form method="post" action="${cp}/member/findIDnPW">
	<input type="hidden" value="findID" name="check"><br>
	<label for="email">이메일 입력</label>
	<input type="text" name="email" id="email">
	<button type="submit">찾기</button>
	</form>
	<br>
	<br>
	<h1>비밀번호 찾기</h1>
	<form method="post" action="${cp}/member/findIDnPW">
	<input type="hidden" value="findPW" name="check"><br>
	<label for="email">아이디 입력</label>
	<input type="text" name="id" id="id">
	<label for="email">이메일 입력</label>
	<input type="txet" name="email" id="email">
	<button type="submit">찾기</button>
	</form>
</body>
</html>