<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="nav">
	<div style="margin-top: 20px;margin-right: 20px;font-weight: bold;">
		<div><a class="mypagenve_link" href="${cp }/memberinfoupdateY/memberupdate?id=${sessionScope.id}">회원 정보 수정</a></div>
		<div><a class="mypagenve_link" href="${cp }/deliveryl/del">주문 배송 조회</a></div>
		<div><a class="mypagenve_link" href="${cp }/orderY/porderlist?id=${sessionScope.id}">주문 내역</a></div>
		<div><a class="mypagenve_link" href="${cp }/boardl/1and1board">1:1 문의</a></div>
		<div><a class="mypagenve_link" href="${cp }/boardl/list">1:1 문의내역</a></div>
	</div>
	<!--  -->
</div>