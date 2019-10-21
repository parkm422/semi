<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script>
	
</script>
    
<div id="main">
	
	<div>
		
		<div>대분류명</div>
		<div>
			<input type="text" name="major" id="major" class="category">
		</div>
		<div>소분류명</div>
		<div>
			<input type="text" name="sub" id="sub" class="category">
		</div>
		<div>사이즈</div>
		<div>
			최소 사이즈<input type="text" name="min_size" id="min_size" class="category">
			최대 사이즈<input type="text" name="max_size" id="max_size" class="category">
		</div>
		<div>색상</div>
		<div>
			색상명<input type="text" name="color" id="color" class="category">
		</div>
	</div>
	
	<div>
		<input type="button" value="카테고리 등록" onclick="addCategory()">
	</div>
	
</div>