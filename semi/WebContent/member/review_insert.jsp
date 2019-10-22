<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	var s = 0;
	function star(e){
		if(s>0){
			return;
		}
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
		if(s>0){
			return;
		}
		var rating = document.getElementsByClassName("star");
			
		for(var i = 0; i<rating.length; i++){
			
			rating[i].innerHTML = "☆";
			
		}
		
	}
	
	function rating(e){
		var star = e.target;
		var star2 = document.getElementsByClassName("star");
		var rating = document.getElementById("rating");
		var starMsg = document.getElementById("starMsg");
		for(var i = 0; i<star2.length; i++){
			if(star == star2[i]){
				rating.value = i+1;
				for(var j = 0; j<=4; j++){
					if(j<=i){
						star2[j].innerHTML = "★";
					}else{
						star2[j].innerHTML = "☆";
					}
				}
			}
		}
		if(rating.value == 5){
			starMsg.innerHTML = "아주 좋아요";
		}else if(rating.value == 4){
			starMsg.innerHTML = "좋아요";
		}else if(rating.value == 3){
			starMsg.innerHTML = "보통이에요";
		}else if(rating.value == 2){
			starMsg.innerHTML = "별로예요";
		}else if(rating.value == 1){
			starMsg.innerHTML = "사지마세요";
		}
		s = parseInt(rating.value);
	}
	
</script>
<div id="main">
	<div style="margin:50px;">
		<div style="margin-bottom: 30px;"><h1>포토 후기 작성</h1></div>
		<div>
			<p class="guide">- 포토 후기 작성 시, 내용에 따라 500원 / 1,000원의 적립금을 드립니다.</p>
			<p class="guide">- 직접 상품만을 촬영한 사진을 등록하셔야 합니다.(착용 사진 불가).</p>
			<p class="guide">- 상품에 대한 평가를 20자 이상 작성하셔야 합니다. 단순 문자 및 기호의 나열/반복은 적립금이 지급되지 않습니다.</p>
			<p class="guide">- 이미지 폭이 300px 미만, 2000px 초과 시 등록되지 않습니다.</p>
			<p class="guide">- 등록하신 후기는 공개되어 회원이 조회 가능하며, 댓글이 등록될 수 있습니다.</p>
			<p class="guide">- 작성된 후기는 홍보 콘텐츠로 사용될 수 있습니다.</p>
			<br>
		</div>
		<form method="post" action="${cp }/member/review_insert" enctype="multipart/form-data">
			<input type="hidden" name="inum" value="${param.inum }">
			<input type="hidden" id="rating" name="rating" value="0">
			<input type="hidden" name="writer" value="${sessionScope.id }">
			
			<div style="margin-bottom: 12px;">후기 제목을 입력해주세요</div>
			<div>
				<input type="text" name="title" style="width:1422px;height:30px;border:1px solid lightgray;padding-left: 5px;margin-bottom: 18px;" placeholder="제목">
			</div>
			
			<div>
				<div style="margin-bottom: 12px;">내용</div>
				<textarea name="content" cols="200" rows="15" placeholder="내용" style="padding:5px;border:1px solid lightgray;"></textarea>
			</div>
			<div style="margin-top: 12px;margin-bottom: 12px;">사진</div>
			<div>
				<input type="file" name="file">
			</div>
			<div>
				<span>별점을 매겨주세요 </span>
				<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" >☆</span>
				<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" >☆</span>
				<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" >☆</span>
				<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" >☆</span>
				<span class="star" onmouseover="star(event)" onmouseout="star2(event)" onclick="rating(event)" >☆</span>
				<span id="starMsg" style="color:red;font-size: 12px;"></span>
			</div>
			<div style="text-align: center;margin-top: 30px;">
				<input type="submit" value="리뷰 등록" style="width:100px;height:50px;background-color: black;color:white;border:none;cursor: pointer;">
			</div>
		</form>
	</div>
</div>