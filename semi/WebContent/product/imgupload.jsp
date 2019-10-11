<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="main">
<h1>파일업로드하기</h1>
	<!-- 
		파일업로드할때는 반드시 method="post",enctype="multipart/form-date" 설정해야함
	 -->
	<form method="post" action="fileuploadOK.jsp" enctype="multipart/form-data">
		첨부파일<input type="file" name="file1"><br>
		<input type="submit" value="전송">
		<input type="reset" value="취소">
	</form>
</div>