<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="main">
	<div>
		<form method="post" action="${cp }/member/login">
			<div><input type="text" name="id" placeholder="아이디"></div>
			<div><input type="password" name="pwd" placeholder="비밀번호"></div>
			<div style="color:red;">${errMsg }</div>
			<div><input type="submit" value="로그인"></div>
		</form>
	</div>
</div>