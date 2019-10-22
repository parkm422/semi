<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
</head>
<body>
<form method="post" action="${cp }/boardl/updateok">
제목<input type="text" value="${vo.title }" readonly="readonly"><br>
작성자<input type="text" value="${vo.writer }" readonly="readonly"><br>
${vo.category }<input type="radio" checked="checked"><br>
내용<br>
<textarea rows="10" cols="100" name="content">${vo.content }</textarea><br>
<input type="text" name="ennum" value="${vo.ennum }" hidden=""> 
<input type="submit" value="수정완료">
</form>
</body>
</html>