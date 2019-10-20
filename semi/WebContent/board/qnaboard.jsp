<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/qnaboard</title>
</head>
<body>
	<table>
		<tr>
			<th>글번호</th>
			<th>질문제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach var="post" items="${list }" >
			<tr>
				<td>${post.qnum }</td>
				<td>${post.title }</td>
				<td>${post.writer }</td>
			</tr>
		</c:forEach>
		<div>
			<c:choose>
				<c:when test="${startPageNum>10 }">
					<a href="${cp }/board/qnaboard?pageNum=${startPageNum-1}">[이전]</a>
				</c:when>
				<c:otherwise>
					[이전]
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }" step="1">
				<c:choose>
					<c:when test="${pageNum==i }">
						<a href="${cp }/board/list?pageNum=${i}"> <span
							style="color: red;">[${i }]</span>
						</a>
					</c:when>
					<c:otherwise>
						<a href="${cp }/board/list?pageNum=${i}"> <span
							style="color: #555;">[${i }]</span>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${endPageNum<pageCount }">
					<a href="${cp }/board/list?pageNum=${endPageNum+1}">[다음]</a>
				</c:when>
				<c:otherwise>
			[다음]
		</c:otherwise>
			</c:choose>
		</div>
	</table>


	<script type="text/javascript">
	var xhr = null;
	function() loadAnswer {
		xhr = XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open('post', '/board/item_qna?')
		xhr.send();
	}
	
	function() callback {
		
	}
</script>
</body>
</html>