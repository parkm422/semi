<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${cp }/css/common.css">
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<div style="margin: 0 auto;width:100%;margin-left: 450px;">
	<div style="margin-left: 410px;margin-top: 30px;"><a href="${cp }/main" style="font-size:30px;"><strong>테스트 쇼핑몰</strong></a></div>
	<div style="text-align: center;width:1000px;height:500px;">
		<h1 style="margin-bottom: 30px;margin-top: 200px;">회원 로그인</h1>
		<div style="">
			<form method="post" action="${cp }/member/login">
				<div style="margin-bottom: 30px;"><input type="text" name="id" placeholder="아이디" style="width:280px;height:60px;font-size:15px;padding-left: 20px;"></div>
				<div style="margin-bottom: 30px;"><input type="password" name="pwd" placeholder="비밀번호" style="width:280px;height:60px;font-size:15px;padding-left: 20px;"></div>
				<div style="color:red;margin-bottom: 30px;">${errMsg }</div>
				<div style="margin-bottom: 30px;"><input type="submit" value="로그인" style="width:300px;height:60px;background-color: black;color:white;font-size:20px;"></div>
			</form>
		</div>
	</div>
	<div>
		<a href="${cp }/member/findIDnPW">아이디/비밀번호 찾기</a>
	</div>
</div>
</body>
</html>

