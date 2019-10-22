<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
	<div style="margin-top:50px; margin-left: 500px; margin-bottom: 50px;"  align="left" ><h1>1:1문의 게시판</h1></div>
	<div style="margin-left: 500px;" align="left">
	<form method="post" action="${cp }/boardl/1and1board">
		<div style="margin-bottom: 20px;">
		<input type="radio" name="ask" value="사이즈">사이즈<br>
		<input type="radio" name="ask" value="교환">교환<br>
		<input type="radio" name="ask" value="환불">환불<br>
		<input type="radio" name="ask" value="기타">기타<br>
		</div>
		<div style="margin-bottom: 20px;">제목<br>
		<input type="text" name="title" size="50"><br></div>
		<div style="margin-bottom: 20px;">내용<br>
		<textarea rows="10" cols="100" name="content"></textarea><br></div>
		<div ><input type="submit" value="등록"></div>
	</form>
	</div>
