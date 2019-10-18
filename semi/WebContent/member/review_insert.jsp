<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

	function star(e){
		var rating = document.getElementsByClassName("star");
		
		for(var i = 0; i<rating.length; i++){
			if(rating[i] == e.target){
				//rating[i].innerHTML="★";
				for(var j = 0; j<=i; j++){
					rating[j].innerHTML = "★";
				}
			}
		}
		
	}
	function star2(e){
		
		var rating = document.getElementsByClassName("star");
			
		for(var i = 0; i<rating.length; i++){
			if(e.target == rating[i]){
				for(var j = i+1; j<=4; j++){
					rating[j].innerHTML = "☆";
				}
			}
		}
		
	}
	
	function rating(e){
		var star = e.target;
		var star2 = document.getElementsByClassName("star");
		var rating = document.getElementById("rating");
		for(var i = 0; i<star2.length; i++){
			if(star == star2[i]){
				rating.value = i+1;
				for(var j = 0; j<=i; j++){
					star2[j].innerHTML = "★";
				}
			}
		}
		alert(rating.value);
	}
	
</script>
<div id="main">
	<h1>리뷰 작성 페이지</h1>
	<form method="post" action="${cp }/member/review_insert" enctype="multipart/form-data">
		<input type="hidden" name="inum" value="${param.inum }">
		<input type="hidden" id="rating" name="rating" value="0">
		<div>작성자<input type="text" name="writer" value="${sessionScope.id }" disabled></div>
		<div>제목 <input type="text" name="title"></div>
		<div>
			내용 <br>
			<textarea name="content" cols="100" rows="5"></textarea>
		</div>
		<div>사진 <input type="file" name="file"></div>
		<div>
			<span>상품 평점 : </span>
			<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" style="font-size: 1.5em;color:orange;">☆</span>
			<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" style="font-size: 1.5em;color:orange;">☆</span>
			<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" style="font-size: 1.5em;color:orange;">☆</span>
			<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" style="font-size: 1.5em;color:orange;">☆</span>
			<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" style="font-size: 1.5em;color:orange;">☆</span>
		</div>
		<div><input type="submit" value="리뷰 등록"></div>
	</form>
</div>