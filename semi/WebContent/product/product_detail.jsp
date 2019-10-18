<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
<div style="margin: 30px;">
	<h1>상품상세정보</h1>
	<div style="margin-left:50px;margin-top:50px;">
		<div style="margin:10px;">
			<div style="float:left;width:400px; height:500px;margin-right:20px;margin-top:10px;">
				<img src="${cp }/upload/${imgList.get(0).savefilename }" style="width:400px; height:500px;">
			</div>
			<div style="float:left;width:300px; height:500px;margin-top:10px;margin-left:100px; text-align: center;">
				<div class="detail_info">
					<span>상품명 : ${vo.pname }</span>
				</div>
				<div class="detail_info">
					<span>가격 : ${vo.price }</span>
				</div>
				<div class="detail_info">
					<select id="item_size" name="item_size" style="font-size: 12px;">
						<option value="">옵션 선택</option>
						<c:forEach var="sizeList" items="${sizeList }">
							<option value="${sizeList }">${sizeList }</option>
						</c:forEach>
					</select>
				</div>
				<div class="detail_info" style="color: orange; font-size: 20px;">
					<span style="font-size:15px;color:black;">평점 : </span>
					<c:choose>
						<c:when test="${rating_avg == 0 }">☆☆☆☆☆</c:when>
						<c:when test="${rating_avg == 1 }">★☆☆☆☆</c:when>
						<c:when test="${rating_avg == 2 }">★★☆☆☆</c:when>
						<c:when test="${rating_avg == 3 }">★★★☆☆</c:when>
						<c:when test="${rating_avg == 4 }">★★★★☆</c:when>
						<c:when test="${rating_avg == 5 }">★★★★★</c:when>
					</c:choose>
				</div>
				<div class="detail_info">
					<input type="button" value="장바구니담기" onclick="itemPut()">
				</div>
			</div>
		</div>
	</div>
	<div style="clear: both;">
		상품상세
	</div>
	<br><br>
	<div>
		<h3>상품 리뷰</h3>
		<c:forEach var="review" items="${reviewList }">
			<div>
				<div><span>${review.rnum }</span></div>
				<div>
					<span>${review.writer }</span>&nbsp;&nbsp;
					<span>평점 :</span>
					<c:choose>
						<c:when test="${review.rating == 5 }"><span style="color:orange;">★★★★★</span></c:when>
						<c:when test="${review.rating == 4 }"><span style="color:orange;">★★★★</span></c:when>
						<c:when test="${review.rating == 3 }"><span style="color:orange;">★★★</span></c:when>
						<c:when test="${review.rating == 2 }"><span style="color:orange;">★★</span></c:when>
						<c:when test="${review.rating == 1 }"><span style="color:orange;">★</span></c:when>
					</c:choose>
					
				</div>
				<div>${vo.pname }</div>
				<div style="font-weight: bold;">${review.title }</div><br>
				<div>${review.content }</div>
				<div><img src="${cp }/upload/${review.savefilename }" style="width:150px;height:150px;"></div>
				<div>
					<div>
						<c:forEach var="child" items="${reviewchild }" varStatus="st">
							<c:if test="${child.rnum == review.rnum }">
								<div style="border:1px solid black;width:500px;">
									<div>
										<span>아이디 : ${child.rcwriter }</span>
									</div>
									<div>
										<span>댓글 : ${child.comments }</span>
									</div>
									<a href="#" onclick="aa(event,'${st.index }','${child.rcnum}','${review.rnum }','${child.ref }','${child.lev }','${child.step }')">
										답글 작성
									</a>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- 리뷰게시판 페이징처리 -->
	<div>
		<c:if test="${startPageNum>5 }">
			<a href="${cp }/product/detail?pageNum=${startPageNum-1 }&inum=${vo.inum }&sub=${param.sub }">[이전]</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${pageNum == i }">
					<a href="${cp }/product/detail?pageNum=${i }&inum=${vo.inum }&sub=${param.sub }" style="color:blue;">[${i }]</a>
				</c:when>
				<c:otherwise>
					<a href="${cp }/product/detail?pageNum=${i }&inum=${vo.inum }&sub=${param.sub }" style="color:gray;">[${i }]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${endPageNum<reviewPageCount }">
			<a href="${cp }/product/detail?pageNum=${startPageNum-1 }&inum=${vo.inum }&sub=${param.sub }">[다음]</a>
		</c:if>
		
	</div>
</div>
</div>
<script type="text/javascript">

	var rcnum1=0;
	var rnum1=0;
	var ref1 = 0;
	var lev1 = 0;
	var step1 = 0;
	var textid= "";
	
	function aa(e,id,rcnum,rnum,ref,lev,step){
		
		rcnum1 = rcnum;
		rnum1 = rnum;
		ref1 = ref;
		lev1 = lev;
		step1 = step;
		
		var a = e.target.parentElement.parentElement;
		var text = document.createElement("textarea");
		var btn = document.createElement("input");
		text.id="com" + id;
		textid="com" + id;
		btn.type = "button";
		btn.value = "등록";
		btn.onclick = comment;
		
		text.style.width = "70%";
		text.style.height = "50px";
		a.appendChild(text);
		a.appendChild(btn);
		
	}

	commentxhr = null;
	function comment(){
		
		
		var textarea=document.getElementById(textid);
		var comments = textarea.value;

		commentxhr = new XMLHttpRequest();
		commentxhr.onreadystatechange = comm;
		commentxhr.open('get','${cp}/member/comment?comments'+comments+'&rcnum='+rcnum1+'&rnum='+rnum1+'&ref='+ref1+'&lev='+lev1+'&step='+step1,true);
		commentxhr.send();
	}
	
	function comm(){
		if(commentxhr.readyState == 4 && commentxhr.status == 200){
			alert("여기까지 실행됨...");
			
			var data = commentxhr.responseText;
			var json = JSON.parse(data);
			
			if(json.code == 'success'){
				var tt = document.getElementsByTagName("taxtarea");
				for(var i = tt.length-1; i>=0; i++){
					tt[i].remov
				}
			}
		}
	}
	
	
	//장바구니 담기
	var putxhr = null;
	function itemPut(){
		var id = '${sessionScope.id}';
		if(id == null || id == ""){
			alert("로그인 후 이용해 주세요.");
			return;
		}
		
		var item_size = document.getElementById("item_size").value;
		
		if(item_size == null || item_size == ""){
			alert("옵션을 선택해주세요.");
			return;
		}
		
		putxhr = new XMLHttpRequest();
		putxhr.onreadystatechange = putOk;
		putxhr.open('get',"${cp}/member/basket?type=put&id=${sessionScope.id}&inum=${vo.inum}",true);
		putxhr.send();
		
	}
	function putOk(){
		if(putxhr.readyState == 4 && putxhr.status == 200){
			var data = putxhr.responseText;
			var json = JSON.parse(data);
			if(json.put == 'success'){
				alert("상품을 장바구니에 담았습니다.");
			}else{
				alert("상품을 담지 못했습니다.");
			}
		}
	}
	
	function commentInsert(){
		
	}
	
</script>















