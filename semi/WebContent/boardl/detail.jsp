<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="main">
<div style="margin-top:50px; margin-left: 10px; margin-bottom: 50px; border: 1px solid black; width: 750px;"  align="left">
<div style="margin-top: 20px;">제목: <input type="text" value="${vo.title }" readonly="readonly"></div><br>
<div style="margin-top: 3px;">작성자: <input type="text" value="${vo.writer }" readonly="readonly"></div><br>
<div style="margin-top: 3px;">${vo.category }<input type="radio" checked="checked"><br></div>
<div style="margin-top: 3px;">내용<br>
<textarea rows="10" cols="100" readonly="readonly">${vo.content }</textarea><br></div>

<c:if test="${vo.answer==null }">
<a href="${cp }/boardl/updatego?ennum=${vo.ennum}">수정</a>
</c:if>

<c:if test="${vo.answer!=null }">
관리자 답변<br>
<textarea rows="5" cols="50" readonly="readonly">${vo.answer }</textarea><br>
</c:if>
<c:choose>

		<c:when test="${sessionScope.id == 'ADMIN'}">
<form method="post" action="${cp }/boardl/go?ennum=${param.ennum }">
답변<br>
<textarea rows="5" cols="50" name="answer"></textarea>
<input type="submit" name="go" value="등록">
</form>
	</c:when>
	</c:choose>
</div>
</div>
</div>


