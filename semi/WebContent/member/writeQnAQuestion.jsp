<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

</head>
<body>
<h1 style="justify-content: center; text-align: center; height: 120px;">질문 작성</h1>
<form action="/member/writeQnAQuestion" method="post">
작성자&nbsp;&nbsp;<input type="text" name="writer">
제목&nbsp;&nbsp;<input type="text" name="title"><br><br>
<textarea name="content" id="summernote"></textarea>
<button type="submit">질문 올리기</button>
</form>
<script>
$(document).ready(function() {
    $('#summernote').summernote({
    		width: 600,					 // 가로길이
            height: 300,                 // set editor height
            minHeight: null,             // set minimum height of editor
            maxHeight: null,             // set maximum height of editor
            focus: true                  // set focus to editable area after initializing summernote
    });
});
</script>
</body>
</html>