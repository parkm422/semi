<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>

	// 대분류 선택시 소분류 리스트 얻어오기
	function list(e){
		var list = document.getElementsByClassName("major_type");
		var len = list.length;

		for(var i = 0;i<len; i++){
			if(list[i] == e.target.nextSibling.nextSibling){
				
				if(list[i].style.display=="block"){
					
					list[i].style.display="none";
					
				}else{
					
					list[i].style.display="block";	
					
				}
				
			}else{
				
				if(list[i].style.display == 'block'){
					
					list[i].style.display="none";	
					
				}	
			}
			
		}
		/*
		if(e.target.nextSibling.nextSibling.style.display == "block"){
			e.target.nextSibling.nextSibling.style.display="none";	
		}else{
			e.target.nextSibling.nextSibling.style.display="block";
		}
		*/
		/*
		if(outlist.style.display == 'block'){
			outlist.style.display="none";	
		}else{
			outlist.style.display="block";
		}
		*/
	}
	
	/*
	// 하의 리스트 목록 얻어오기
	function bottomList(e){
		var bottomlist = document.getElementById("bottom_list");
		if(bottomlist.style.display == 'block'){
			bottomlist.style.display="none";	
		}else{
			bottomlist.style.display="block";
		}
		
	}
	*/
</script>
<div id="nav">
	<div style="margin-top: 20px;margin-right: 20px;">
	<div onclick="list(event)">아우터</div>
	<div id="outer_list" style="height:100px;display:none;" class="major_type">
		<ul>
			<li><a href="${cp }/product/list?major=OUTER&sub=패딩" class="outer_type">패딩</a></li>
			<li><a href="${cp }/product/list?major=OUTER&sub=코트" class="outer_type">코트</a></li>
			<li><a href="${cp }/product/list?major=OUTER&sub=야상" class="outer_type">야상</a></li>
			<li><a href="${cp }/product/list?major=OUTER&sub=자켓" class="outer_type">자켓</a></li>
		</ul>
	</div>
	<div onclick="list(event)">상의</div>
	<div id="top_list" style="height:100px;display:none;" class="major_type">
		<ul>
			<li><a href="${cp }/product/list?major=TOP&sub=티셔츠 " class="outer_type">티셔츠</a></li>
			<li><a href="${cp }/product/list?major=TOP&sub=맨투맨" class="outer_type">맨투맨</a></li>
			<li><a href="${cp }/product/list?major=TOP&sub=스웨터" class="outer_type">스웨터</a></li>
			<li><a href="${cp }/product/list?major=TOP&sub=셔츠" class="outer_type">셔츠</a></li>
		</ul>
	</div>
	<div onclick="list(event)">하의</div>
	<div id="bottom_list" style="height:100px;display:none;" class="major_type">
		<ul>
			<li><a href="${cp }/product/list?major=BOTTOM&sub=청바지" class="bottom_type">청바지</a></li>
			<li><a href="${cp }/product/list?major=BOTTOM&sub=면바지" class="bottom_type">면바지</a></li>
			<li><a href="${cp }/product/list?major=BOTTOM&sub=슬랙스" class="bottom_type">슬랙스</a></li>
		</ul>
	</div>
	<div onclick="list(event)">원피스</div>
		<div id="top_list" style="height:100px;display:none;" class="major_type">
		<ul>
			<li><a href="${cp }/product/list?major=ONEPIECE&sub=미니원피스" class="outer_type">미니 원피스</a></li>
			<li><a href="${cp }/product/list?major=ONEPIECE&sub=맥시원피스" class="outer_type">맥시 원피스</a></li>
			<li><a href="${cp }/product/list?major=ONEPIECE&sub=미디원피스" class="outer_type">미디 원피스</a></li>
			<li><a href="${cp }/product/list?major=ONEPIECE&sub=점프수트" class="outer_type">점프수트</a></li>
		</ul>
	</div>
	<div onclick="list(event)">가방</div>
	<div id="top_list" style="height:100px;display:none;" class="major_type">
		<ul>
			<li><a href="${cp }/product/list?major=BAG&sub=패딩" class="outer_type">백팩</a></li>
			<li><a href="${cp }/product/list?major=BAG&sub=코트" class="outer_type">크로스백</a></li>
			<li><a href="${cp }/product/list?major=BAG&sub=야상" class="outer_type">클러치/파우치</a></li>
			<li><a href="${cp }/product/list?major=BAG&sub=자켓" class="outer_type">숄더/토트/에코 백</a></li>
		</ul>
	</div>
	</div>
</div>