<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
<table>
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>주소</th>
		<th>연락처</th>
		<th>포인트</th>
		<th>가입일</th>
	</tr>
	<c:forEach items="${list }" var="mInfo">
	
	<tr>
		<td>${mInfo.mnum }</td>
		<td>${mInfo.id }</td>
		<td>${mInfo.pwd }</td>
		<td>${mInfo.name }</td>
		<td>${mInfo.email }</td>
		<td>${mInfo.address }</td>
		<td>${mInfo.phone }</td>
		<td>${mInfo.point }</td>
		<td>${mInfo.joindate }</td>
	</tr>
	</c:forEach>
</table>
</div>
