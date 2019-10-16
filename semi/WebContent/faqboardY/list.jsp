<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript">
	var xhr=null;
	var cnt=0;
	function lookanswer(e) {
		var txts=document.getElementsByClassName("txts");
		var question=e.target.textContent;
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=success;
		xhr.open('get', 'faqlist.jsp?question='+question,true);
		xhr.send();
	}
	function success() {
		if(xhr.readyState==4 && xhr.status==200){
			var data=xhr.responseText;
			var json=JSON.parse(data);
			var div=document.getElementsByClassName("result");
			cnt++;
			for(var i=0;i<json.length;i++){
					div[(json[i]).fnum-1].innerHTML="<질문번호>"+json[i].fnum+"<br><카테고리>"+json[i].category+"<br><질문>"+json[i].question+"<br><답변>"+json[i].answer+"<br>";
					 if(cnt==2){
						div[(json[i].fnum-1)].innerHTML="";
						cnt=0;
							}
					}
				}
			}
	</script>
<h1>FAQ게시판</h1>
<c:set var="cp" value="${pageContext.request.contextPath }"/>
<p><a href="${cp }/faqboardY/list">전체글목록</a> | <a href="${cp }/main">홈으로</a>
</p>
<table border="1" width="800">
	<tr>
		<th>번호</th><th>질문</th>
	</tr>
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.fnum }</td>
			<td onclick="lookanswer(event)">${vo.question}</td>
		</tr>
		<tr>
		<td class="result" colspan="2" ></td>
		</tr>
	</c:forEach>
</table>
<br>
<div><!-- 페이징처리 -->
<a href="${cp }/faqboardY/list?pageNum=${startPageNum}">[맨앞으로]</a>
<c:if test="${pageNum > 1}">
<a href="${cp }/faqboardY/list?pageNum=${pageNum-1}">[이전]</a>
</c:if>
	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${pageNum==i }"><%--현재페이지 색 다르게 표시하기 --%>
				<a href="${cp }/faqboardY/list?pageNum=${i}">
				<span style="color:red;">[${i }]</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/faqboardY/list?pageNum=${i}">
				<span style="color:#555;">[${i }]</span>
				</a>
			</c:otherwise>
		</c:choose>					
	</c:forEach>
<c:if test="${pageNum < endPageNum}">
	<a href="${cp }/faqboardY/list?pageNum=${pageNum+1}">[다음]</a>
</c:if>
<a href="${cp }/faqboardY/list?pageNum=${endPageNum}">[맨뒤로]</a>
</div>
</body>
</html>


































