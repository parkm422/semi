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
제목<input type="text" value="${vo.title }" readonly="readonly"><br>
작성자<input type="text" value="${vo.writer }" readonly="readonly"><br>
${vo.category }<input type="radio" checked="checked"><br>
내용<br>
<textarea rows="10" cols="100" readonly="readonly">${vo.content }</textarea><br>
<c:if test="${vo.answer!=null }">
<textarea rows="5" cols="50" readonly="readonly">${vo.answer }</textarea><br>
</c:if>
<c:choose>
		<c:when test="${sessionScope.id == 'ADMIN'}">
<form method="post" action="${cp }/board/go?ennum=${param.ennum }">
답변<br>
<textarea rows="5" cols="50" name="answer"></textarea>
<input type="submit" name="go" value="등록">
</form>
	</c:when>
	</c:choose>
</body>
</html>

