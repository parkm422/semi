<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<h1>FAQ 질문 작성하기</h1>
<form method="post" action="${cp }/faqboardY/faqinsert">
	카테고리<br>
	<input type="text" name="category"><br>
	질문<br>
	<textarea rows="5" cols="60" name="question"></textarea><br>
	답변<br>
	<textarea rows="5" cols="60" name="answer"></textarea><br><br>
	<input type="submit" value="등록">
</form>
</div>








