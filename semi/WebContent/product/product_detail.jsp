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
				<p>
					상품명 : ${vo.pname }
				</p>
				<p>
					가격 : ${vo.price }
				</p>
				<p>
					하이
				</p>
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
	<div>
		<h3>리뷰게시판</h3>
		<c:forEach var="review" items="${reviewList }">
			<div>
				<div>${review.writer }</div>
				<div>${vo.pname }</div>
				<div>${review.title }</div>
				<div>${review.content }</div>
				<div><img src="${cp }/upload/${review.savefilename }">5</div>
				<div><textarea rows="2" cols="100"></textarea><input type="button" value="등록" onclick="insert()"></div>
			</div>
		</c:forEach>
		
	</div>
</div>
<script type="text/javascript">
	
	var putxhr = null;
	function itemPut(){
		var id = '${sessionScope.id}';
		if(id == null || id == ""){
			alert("로그인 후 이용해 주세요.");
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
</script>