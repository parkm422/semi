<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="main">
	<div style="margin-top:10px;width:98%; height:150px;background-color: black;">
		<div style="color:white;"><h3 style="margin-left: 20px;">My Page</h3></div>
		<div style="color:white;">
			<div style="float: left;margin-left: 20px;">
				<img src="${cp }/upload/프로필아이콘.png" style="width:100px;height:100px;">
			</div>
			<div>
				<span style="font-size: 25px;font-weight: bold">${vo.name }</span>&nbsp;
				<span style="font-size: 18px;font-weight: bold">${vo.id }</span>
				<span style="font-size: 18px;">가입일 : ${vo.joindate }</span>
			</div>
			<div>
				<span style="font-size: 18px;">이메일 : ${vo.email }</span>
			</div>
			<div style="font-size: 18px;">포인트 : ${vo.point }점</div>
		</div>
	</div>
</div>