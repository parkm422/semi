<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="main">
	<h1>회원 로그인</h1>
	<div>
		<form method="post" action="${cp }/member/login">
			<div><input type="text" name="id" placeholder="아이디"></div>
			<div><input type="password" name="pwd" placeholder="비밀번호"></div>
			<div style="color:red;">${errMsg }</div>
			<div><input type="submit" value="로그인"></div>
		</form>
	</div>
	<div>
		<a href="${cp }/member/findIDnPW">아이디/비밀번호 찾기</a>
	</div>
</div>