<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function find(e){
		var outlist = document.getElementById("outer_list");
		if(outlist.style.display == 'block'){
			outlist.style.display="none";	
		}else{
			outlist.style.display="block";
		}
		
	}
</script>
<div id="nav">
	<div onclick="find(event)">아우터</div>
	<div id="outer_list" style="height:100px;display:none;">
		<ul>
			<li><a href="" class="outer_type">패딩</a></li>
			<li><a href="" class="outer_type">코트</a></li>
			<li><a href="" class="outer_type">야상</a></li>
			<li><a href="" class="outer_type">자켓</a></li>
		</ul>
	</div>
	<div>상의</div>
	<div>바텀</div>
	<div>원피스</div>
	<div>가방</div>
	<div><a href="${cp }/member/QnA" class="outer_type">질답게시판</a></div>
</div>