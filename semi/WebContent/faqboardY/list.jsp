<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript">
	var xhr=null;
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
				for(var i=0;i<json.length;i++){
					if(json[i].fnum>=10){
						if((json[i].fnum)%10==0){
							if((div[9].innerHTML)==""){
								div[9].innerHTML="<질문번호>"+json[i].fnum+"<br><카테고리>"+json[i].category+"<br><질문>"+json[i].question+"<br><답변>"+json[i].answer+"<br>";
								}else{
								div[9].innerHTML="";
										}
							}
						if(div[(json[i].fnum)%10-1].innerHTML==""){
						div[(json[i].fnum)%10-1].innerHTML="<질문번호>"+json[i].fnum+"<br><카테고리>"+json[i].category+"<br><질문>"+json[i].question+"<br><답변>"+json[i].answer+"<br>";
						}else{
						div[(json[i].fnum)%10-1].innerHTML="";
								}
							}else{
								if((div[(json[i].fnum)%10-1].innerHTML)==""){
									div[(json[i].fnum)%10-1].innerHTML="<질문번호>"+json[i].fnum+"<br><카테고리>"+json[i].category+"<br><질문>"+json[i].question+"<br><답변>"+json[i].answer+"<br>";
									}else{
									div[(json[i].fnum)%10-1].innerHTML="";
											}
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
	<c:forEach var="vo" items="${list}" varStatus="aa">
		<tr>
			<td>${(pageNum-1)*10+aa.index+1}</td>
			<td onclick="lookanswer(event)">${vo.question}</td>
		</tr>
		<tr>
		<td class="result" colspan="2" ></td>
		</tr>
	</c:forEach>
</table>
<br>
<div>
<c:choose>
	<c:when test="${startPage>10 }">
		<a href="${cp }/faqboardY/list?pageNum=${startPage-1 }">[이전]</a>
	</c:when>
	<c:otherwise>
		이전
	</c:otherwise>
</c:choose>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/faqboardY/list?pageNum=${i}">
				<span style='color:blue'>[${i }]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/faqboardY/list?pageNum=${i}"><span style='color:#999'>[${i }]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
<c:choose>
	<c:when test="${endPage<pageCount}">
		<a href="${cp }/faqboardY/list?pageNum=${endPage+1 }">[다음]</a>
	</c:when>
	<c:otherwise>
		다음
	</c:otherwise>
</c:choose>
</div>




































