<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="main">

	<div style="margin: 30px;">
		<div style="margin:60px;"><h1>상품상세정보</h1></div>
		<div style="margin-left:50px;margin-top:50px;">
			<div style="margin:10px;">
				<div style="float:left;width:400px; height:500px;margin-right:20px;margin-top:10px;margin-bottom: 20px;">
					<img src="${cp }/upload/${imgList.get(0).savefilename }" style="width:400px; height:500px;">
				</div>
				<div style="float:left;width:300px; height:500px;margin-top:10px;margin-left:100px;margin-bottom: 20px; text-align: center;">
					<div class="detail_info">
						<span>상품명 : ${vo.pname }</span>
					</div>
					<div class="detail_info">
						<span>가격 : ${dc.format(vo.price) }원</span>
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
			<div style="margin: 60px;">
				<h3>상품 상세</h3>
			</div>
		</div>
		<br><br>
		<div style="margin: 60px;">
		<h3>상품 Q&A</h3>
		<table id="question">
			<tr>
				<th>글번호</th>
				<th>질문제목</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="post" items="${list }" varStatus="postId" >
				<tr>
					<td>${post.rnum }</td>
					<td><a href="#!" onclick="viewContent('${postId.index }')">${post.title }</a></td>
					<td>${post.writer }</td>
				</tr>
				<tr style="display:none" id="a_${postId.index }">
					<td colspan="3">질문: ${post.content }</td>
				</tr>
				<tr style="display:none" id="b_${postId.index }">
					<td colspan="3">답변: ${post.answer }</td>
				</tr>
			</c:forEach>
		</table>
		<c:choose>
			<c:when test="${qnastartPageNum>10 }">
				<a href="${cp }/product/detail?qnaPageNum=${qnastartPageNum-1}&inum=${vo.inum}">[이전]</a>
			</c:when>
			<c:otherwise>
					[이전]
				</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${qnastartPageNum }" end="${qnaendPageNum }"
			step="1">
			<c:choose>
				<c:when test="${qnaPageNum==i }">
					<a href="${cp }/product/detail?qnaPageNum=${i}&inum=${vo.inum}"> <span
						style="color: red;">[${i }]</span>
					</a>
				</c:when>
				<c:otherwise>
					<a href="${cp }/product/detail?qnaPageNum=${i}&inum=${vo.inum}"> <span
						style="color: #555;">[${i }]</span>
					</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${qnaendPageNum<qnaTotalPage }">
				<a href="${cp }/product/detail?qnaPageNum=${qnaendPageNum+1}&inum=${vo.inum}">[다음]</a>
			</c:when>
			<c:otherwise>
			[다음]
		</c:otherwise>
		</c:choose>
	</div>
	
		<div>
			<div style="margin: 60px; border: 1px solid gray; ">
				<h3>상품 리뷰</h3>
				<c:forEach var="review" items="${reviewList }" varStatus="bb">
					<div style="margin-left: 30px;">
						<div>
							<span>글번호 : ${review.rnum }</span>&nbsp;&nbsp;
							<span>작성자 : ${review.writer }</span>&nbsp;&nbsp;
							<span>평점 :</span>
							<c:choose>
								<c:when test="${review.rating == 5 }"><span style="color:orange;">★★★★★</span></c:when>
								<c:when test="${review.rating == 4 }"><span style="color:orange;">★★★★</span></c:when>
								<c:when test="${review.rating == 3 }"><span style="color:orange;">★★★</span></c:when>
								<c:when test="${review.rating == 2 }"><span style="color:orange;">★★</span></c:when>
								<c:when test="${review.rating == 1 }"><span style="color:orange;">★</span></c:when>
							</c:choose>
						</div>
						<div>상품명 : ${vo.pname }</div>
						<div style="font-weight: bold;">${review.title }</div>
						<div>${review.content }</div>
						<div><img src="${cp }/upload/${review.savefilename }" style="width:150px;height:150px;cursor: pointer;" onclick="imgSize(event)"></div>
						<div>
							<div style="padding:10px;">
								<textarea rows="3" cols="100" id="firstcomment_${bb.index }" onclick="loginCheck('${bb.index}')"></textarea>
								<input type="button" style="height:30px;" value="댓글작성" onclick="comment(0,'${bb.index }',0,'${review.rnum}',0,0,0)">
							</div>
						</div>
						<div>
							<div>
								<c:forEach var="child" items="${reviewchild }" varStatus="st">
									<c:if test="${child.rnum == review.rnum }">
									<div>
										<c:forEach begin="0" end="${child.lev }">
												<div style="display: inline-block; margin-left:20px;"></div>
										</c:forEach>
										<div style="display: inline-block;">
											
											<div>
												<span>└아이디 : ${child.rcwriter }</span>
												<span>
													<a href="#content" id="cc_${st.index }" onclick="aa('${st.index }')">답글 작성</a>
												</span>
											</div>
											<div>
												<span>댓글 : ${child.comments }</span>
											</div>
											
											<div id="comm${st.index }" style="display:none;">
												<textarea rows="3" cols="100" id="comm_${st.index }"></textarea>
												<input type="button" value="등록" onclick="comment(1,'${st.index}','${child.rcnum }','${child.rnum }','${child.ref }','${child.lev }','${child.step }')">
											</div>
										</div>
									</div>
									</c:if>
								</c:forEach>
							</div>
						</div>
					</div>
					<br>
				</c:forEach>
			</div>
		</div>
		<!-- 리뷰게시판 페이징처리 -->
		<div>
			<div style="margin: 60px;font-size: 25px; text-align: center;">
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
					<a href="${cp }/product/detail?pageNum=${endPageNum+1 }&inum=${vo.inum }&sub=${param.sub }">[다음]</a>
				</c:if>
			</div>
		</div>
		<!-- 최상단으로 최하단으로 버튼 -->
		<div style="position: fixed; bottom: 70px; right: 40px;">
			<a href="#header" style="background-color: gray;color:white;">▲</a>
		</div>
		<div style="position: fixed; bottom: 40px; right: 40px;">
			<a href="#footer" style="background-color: gray;color:white;">▼</a>
		</div>
	</div>
</div>

<script type="text/javascript">

	function imgSize(e){
		var img = e.target;
		if(img.style.width == '150px'){
			img.style.width = '300px';
			img.style.height ='300px';
		}else{
			img.style.width = '150px';
			img.style.height ='150px';
		}
	}
	
	// 비로그인 상태로 textarea창 클릭시 호출
	function loginCheck(bb){
		var sessionId = '${sessionScope.id}';
		if(sessionId == null || sessionId == ''){
			var text = document.getElementById("firstcomment_"+bb);
			text.disabled = true;
			text.style.fontWeight = "bold";
			text.value = "로그인 후 작성 할 수 있습니다.";
		}
	}
	
	// 비로그인 상태에서 대댓글 작성 클릭시 호출
	function aa(id){
		
		var sessionId = '${sessionScope.id}';
		if(sessionId == null || sessionId == ''){
			alert("로그인 후 이용해주세요.");
			location.href="${cp}/member/login";
			return;
		}
		var cc = document.getElementById("cc_"+id);
		if(cc.text == '답글 작성'){
			cc.text = '답글 취소';
		}else{
			cc.text = '답글 작성';
		}
		var a = document.getElementById("comm"+id);
		if(a.style.display == 'block'){
			a.style.display = "none";
		}else{
			a.style.display = "block";	
		}
		
		
	}
	
	//댓글 작성
	commentxhr = null;
	function comment(a,id,rcnum,rnum,ref,lev,step){
		
		//로그인 체크 비로그인시 로그인 페이지 이동 후 함수 종료
		var sessionId = '${sessionScope.id}';
		if(sessionId == null || sessionId == ''){
			alert("로그인 후 이용해주세요.");
			location.href="${cp}/member/login";
			return;
		}
		
		commentxhr = new XMLHttpRequest();
		commentxhr.onreadystatechange = comm;
		var comments = "";
		if(a == 0){
			comments = document.getElementById("firstcomment_"+id).value;
			
		}else if(a == 1){
			comments = document.getElementById("comm_"+id).value;
		}
		commentxhr.open('get','${cp}/member/comment?comments='+comments+'&rcnum='+rcnum+'&rnum='+rnum+'&ref='+ref+'&lev='+lev+'&step='+step,true);
		commentxhr.send();
	}
	//댓글 작성 콜백함수
	function comm(){
		if(commentxhr.readyState == 4 && commentxhr.status == 200){
			
			var data = commentxhr.responseText;
			var json = JSON.parse(data);
			
			if(json.code == 'success'){
				alert("댓글 등록 성공");
			}else{
				alert("댓글 등록 실패!");
			}
		}
	}
	
	
	//장바구니 담기
	var putxhr = null;
	function itemPut() {
		var id = '${sessionScope.id}';
		if (id == null || id == "") {
			alert("로그인 후 이용해 주세요.");
			return;
		}

		var item_size = document.getElementById("item_size").value;

		if (item_size == null || item_size == "") {
			alert("옵션을 선택해주세요.");
			return;
		}

		putxhr = new XMLHttpRequest();
		putxhr.onreadystatechange = putOk;
		putxhr.open('get',"${cp}/member/basket?type=put&id=${sessionScope.id}&inum=${vo.inum}",true);
		putxhr.send();

	}
	//장바구니 담기 콜백함수
	function putOk(){
		if(putxhr.readyState == 4 && putxhr.status == 200){
			var data = putxhr.responseText;
			var json = JSON.parse(data);
			if (json.put == 'success') {
				alert("상품을 장바구니에 담았습니다.");
			} else {
				alert("상품을 담지 못했습니다.");
			}
		}
	}
	function viewContent(id) {
		var a = document.getElementById("a_" + id);
		var b = document.getElementById("b_" + id);

		if (a.style.display == "block" & b.style.display == "block") {
			a.style.display = "none";
			b.style.display = "none";
			//c.style.display = "none";

		} else if (a.style.display == "none" & b.style.display == "none") {
			a.style.display = "block";
			b.style.display = "block";
			//console.log(sessionStorage.getItem("adminId"));
			//if (sessionStorage.getItem("adminId") !== null) {
			//	c.style.display = "block";
			//}
		}
	}
</script>
