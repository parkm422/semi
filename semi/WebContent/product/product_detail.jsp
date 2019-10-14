<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">
	<h1>상품상세정보</h1>
	<div style="margin-left:50px;margin-top:50px;">
		<div style="margin:10px;">
			<div style="float:left;width:400px; height:500px;margin-right:20px;margin-top:10px;">
				<img src="${cp }/upload/${imgList.get(0).savefilename }" style="width:400px; height:500px;">
			</div>
			<div style="float:left;width:300px; height:500px;margin-top:10px;margin-left:100px; text-align: center;">
				<div>
					<span>상품명 : ${vo.pname }</span>
				</div>
				<div>
					<span>가격 : ${vo.price }</span>
				</div>
				<div>
					<select id="item_size" name="item_size">
						<option value="">옵션</option>
						<c:forEach var="sizeList" items="${sizeList }">
							<option value="${sizeList }">${sizeList }</option>
						</c:forEach>
					</select>
				</div>
				<p>
					하이
				</p>
				<div>
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
						<textarea rows="4" cols="100"></textarea><input type="button" value="댓글쓰기" onclick="commentInsert(event)">
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
<script type="text/javascript">
	
	function commentInsert(e){
		var comment = e.target.firstChild.nextSibling.nextSibling;
		alert(comment)
		comment.style.display = "block";
	}
	
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















