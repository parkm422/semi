<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="nav">
	<div style="margin-top: 20px;margin-right: 20px;font-weight: bold;">
		<div><a href="${cp }/deliveryl/del">주문상태보기</a></div>
		<div><a href="${cp }/orderY/porderlist?id=${sessionScope.id}">주문내역보기</a></div>
		<div><a href="${cp }/memberinfoupdateY/memberupdate?id=${sessionScope.id}">회원정보수정</a></div>
		<div><a href="${cp }/boardl/1and1board">1:1문의하기</a></div>
		<div><a href="${cp }/boardl/list">1:1문의내역</a></div>
	</div>
</div>