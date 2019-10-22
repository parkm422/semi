<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="main">
	<h1>상품상세정보</h1>
	<div style="margin-left: 50px; margin-top: 50px;">
		<div style="margin: 10px;">
			<div
				style="float: left; width: 400px; height: 500px; margin-right: 20px; margin-top: 10px;">
				<img src="${cp }/upload/${imgList.get(0).savefilename }"
					style="width: 400px; height: 500px;">
			</div>
			<div
				style="float: left; width: 300px; height: 500px; margin-top: 10px; margin-left: 100px; text-align: center;">
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
				<p>하이</p>
				<div>
					<input type="button" value="장바구니담기" onclick="itemPut()">
				</div>
			</div>
		</div>
	</div>
	<div style="clear: both;">상품상세</div>

	<div>
		<h3>상품 Q&A</h3>
		<table id="question">
			<tr>
				<th>글번호</th>
				<th>질문제목</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="post" items="${list }" varStatus="postId">
				<tr>
					<td>${post.rnum }</td>
					<td><a href="#!" onclick="viewContent('${postId.index}')">${post.title }</a></td>
					<td>${post.writer }</td>
				</tr>
				<tr style="display: none;" id="a_${postId.index }">
					<td colspan="3">질문: ${post.content }</td>
				</tr>
				<tr style="display: none;" id="b_${postId.index }">
					<td colspan="3">답변: ${post.answer }</td>
				</tr>
				<tr style="display: none;" id="c_${postId.index }">
					<td><button type="button">답변 작성</button></td>
				</tr>
			</c:forEach>
		</table>
		<c:choose>
			<c:when test="${startPageNum>10 }">
				<a
					href="${cp }/product/detail?qnaPageNum=${startPageNum-1}&inum=${vo.inum}">[이전]</a>
			</c:when>
			<c:otherwise>
					[이전]
				</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }"
			step="1">
			<c:choose>
				<c:when test="${qnaPageNum==i }">
					<a href="${cp }/product/detail?qnaPageNum=${i}&inum=${vo.inum}">
						<span style="color: red;">[${i }]</span>
					</a>
				</c:when>
				<c:otherwise>
					<a href="${cp }/product/detail?qnaPageNum=${i}&inum=${vo.inum}">
						<span style="color: #555;">[${i }]</span>
					</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${endPageNum<qnaTotalPage }">
				<a
					href="${cp }/product/detail?qnaPageNum=${endPageNum+1}&inum=${vo.inum}">[다음]</a>
			</c:when>
			<c:otherwise>
			[다음]
		</c:otherwise>
		</c:choose>
		<div>
			<button type="button" id="writeQuestion">질문 작성</button>
		</div>
	</div>


</div>


<div>
	<h3>리뷰게시판</h3>
	<c:forEach var="review" items="${reviewList }">
		<div>
			<div>${review.writer }</div>
			<div>${vo.pname }</div>
			<div>${review.title }</div>
			<div>${review.content }</div>
			<div>
				<img src="${cp }/upload/${review.savefilename }">5
			</div>
			<div>
				<textarea rows="2" cols="100"></textarea>
				<input type="button" value="등록" onclick="insert()">
			</div>
		</div>
	</c:forEach>
</div>
<script type="text/javascript">
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
		putxhr
				.open(
						'get',
						"${cp}/member/basket?type=put&id=${sessionScope.id}&inum=${vo.inum}",
						true);
		putxhr.send();

	}
	function putOk() {
		if (putxhr.readyState == 4 && putxhr.status == 200) {
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

		if (a.style.display === "block" & b.style.display === "block") {
			a.style.display = "none";
			b.style.display = "none";
			//c.style.display = "none";

		} else if (a.style.display === "none" & b.style.display === "none") {
			a.style.display = "block";
			b.style.display = "block";
			//console.log(sessionStorage.getItem("adminId"));
			//if (sessionStorage.getItem("adminId") !== null) {
			//	c.style.display = "block";
			//}
		}
	}
	
	var writeQuestionBtn = document.getElementById("writeQuestion");
	writeQuestionBtn.addEventListener("click", () => {
		location.href="${cp}/member/writeQnAQuestion?inum=${vo.inum}";
	}, false);
</script>