<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
	<div style="text-align: center;">
	<h1>hit 상품</h1>
	<div style="padding-left: 70px;">
		<ul>
			<c:forEach var="hit" items="${hit }">
				<li style="display:inline-block;">
					<div style="margin-left:15px;margin-bottom:15px;overflow: hidden;">
						<div>
							<a href="${cp }/product/detail?inum=${hit.inum }&sub=${param.sub }&sort=${param.sort}">
								<img src="${cp }/upload/${hit.savefilename}" style="width:250px;height:250px;">
							</a>
						</div>
						<div>
							<div style="width:250px;height:50px;text-align: center;font-size:17px;text-overflow:ellipsis;overflow:hidden;">
								<a href="${cp }/product/detail?inum=${hit.inum }&sub=${param.sub }&sort=${param.sort}" style="text-decoration: none;color: black;font-size:12px;">${hit.pname }</a>
							</div>
							<div style="text-align: center;font-size:17px;"><strong>${dc.format(hit.price) }원</strong></div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<div style="position: fixed; bottom: 70px; right: 40px;">
				<a href="#header" style="background-color: gray;color:white;">▲</a>
		</div>
		<div style="position: fixed; bottom: 40px; right: 40px;">
				<a href="#footer" style="background-color: gray;color:white;">▼</a>
		</div>
	</div>
	</div>
</div>

