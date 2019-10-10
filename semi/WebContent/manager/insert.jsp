<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div id="main">
	<h1>상품등록 페이지</h1>
	<div>
		<select id="major" name="major">
			<option value="OUTER">아우터</option>
			<option value="TOP">상의</option>
			<option value="ONEPIECE">원피스</option>
			<option value="BOTTOM">하의</option>
			<option value="BAG">가방</option>
		</select>&nbsp;&nbsp;&nbsp;
		
		<select id="sub" name="sub">
			<option value="코트">코트</option>
			<option value="패딩">패딩</option>
			<option value="자켓">원피스</option>
			<option value="야상">야상</option>
		</select>&nbsp;&nbsp;&nbsp;
		
		<select id="size" name="size">
			<option value="95">95</option>
			<option value="100">100</option>
			<option value="105">105</option>
			<option value="110">110</option>
		</select>&nbsp;&nbsp;&nbsp;
		
		<select id="color" name="color">
			<option value="black">블랙</option>
			<option value="brown">브라운</option>
			<option value="gray">그레이</option>
		</select>&nbsp;&nbsp;&nbsp;
	</div>
	<div>
		<form method="post" action="${cp }/manager/insert" enctype="multipart/form-data">
		<div>상품명<input type="text" name="pname"></div>
		<div>가격<input type="text" name="price"></div>
		<div>재고<input type="text" name="cnt"></div>
		<div>이미지<input type="file" name="pimg"></div>
		<div><input type="submit" value="상품등록"></div>
		</form>
	</div>
</div>