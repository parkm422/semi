<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	
	var xhr = null;
	//대분류명에 따라 서브카테고리 목록 얻어오기
	function subList(){
		deleteScategory();
		deleteSize();
		deleteColor();
		var choice = document.getElementById("major").value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = subOk;
		xhr.open('get',"${cp}/manager/select?type=sub&choice="+choice,true);
		xhr.send();
	}
	
	//sub category 초기화 작업
	function deleteScategory(){
		var sub = document.getElementById("sub");
		var child = sub.childNodes;
		for(var i = child.length-1; i>=0; i--){
			if(i == 0){
				break;
			}
			sub.remove(i);
		}
		
	}
	
	//대분류명에 따라 서브카테고리 목록 얻어오기
	function subOk(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			var json = JSON.parse(data)[0];
			var sub = document.getElementById("sub");
			
			/*
			var firstoption = document.createElement("option");
			firstoption.value= "";
			firstoption.text = "소분류";
			sub.options.add(firstoption);
			*/
			for(var i = 0; i<json.length; i++){
				var s_category = json[i];
				var option = document.createElement("option");
				
				option.value = s_category;
				option.text = s_category; 	
				
				sub.options.add(option);
			}
		}
	}
	
	var sizexhr = null;
	//소분류 선택시 사이즈 얻어오기
	function sizeList(){
		deleteSize();
		deleteColor();
		var choice = document.getElementById("sub").value;
		sizexhr = new XMLHttpRequest();
		sizexhr.onreadystatechange = sizeOk;
		sizexhr.open('get','${cp}/manager/select?type=size&choice='+choice,true);
		sizexhr.send();
	}
	
	//사이즈 초기화
	function deleteSize(){
		var size = document.getElementById("size");
		var child = size.childNodes;
		for(var i = child.length-1; i>=0; i--){
			if(i == 0){
				break;
			}
			size.remove(i);
		}
		
	}
	
	//소분류 선택시 사이즈 얻어오기
	function sizeOk(){
		if(sizexhr.readyState == 4 && sizexhr.status == 200){
			
			var data = sizexhr.responseText;
			var json = JSON.parse(data)[0];
			
			var size = document.getElementById("size");
			/*
			var firstop = document.createElement("option");
			firstop.text = "사이즈";
			firstop.value="";
			size.options.add(firstop);
			*/
			for(var i = 0; i<json.length; i++){
				
				var psize = json[i];
				var sizeop = document.createElement("option");
				sizeop.value = psize;
				sizeop.text = psize;
				size.options.add(sizeop);
			}
			
		}
	}
	
	var colorxhr = null;
	// 색상 얻어오기
	function colorList(){
		deleteColor();
		var sub = document.getElementById("sub").value;
		var choice = document.getElementById("size").value;
		colorxhr = new XMLHttpRequest();
		colorxhr.onreadystatechange = colorOk;
		colorxhr.open('get',"${cp}/manager/select?type=color&choice="+choice+"&sub="+sub,true);
		colorxhr.send();
	}
	
	// 색상 초기화 
	function deleteColor(){
		var color = document.getElementById("color");
		var child = color.childNodes;
		for(var i = child.length-1; i>=0; i--){
			if(i == 0){
				break;
			}
			color.remove(i);
		}
	}
	
	function colorOk(){
		if(colorxhr.readyState == 4 && colorxhr.status == 200){
			var data = colorxhr.responseText;
			var json = JSON.parse(data)[0];
			var color = document.getElementById("color");
			
			/*
			var firstcolor = document.createElement("option");
			firstcolor.value = "";
			firstcolor.text = "색상";
			color.options.add(firstcolor);
			*/
			
			for(var i = 0; i<json.length; i++){
				
				var colorname = json[i];
				
				var colorop = document.createElement("option");
				
				colorop.value = colorname;
				colorop.text = colorname;
				color.options.add(colorop);
			}
		}
	}
	
	
</script>
<div id="main">
	<div style="width:600px;margin: 0 auto;margin-top: 50px;">
		<div style="margin-bottom: 30px;"><h1>상품등록 페이지</h1></div>
		<form method="post" action="${cp }/manager/insert" enctype="multipart/form-data">
			<div style="margin-bottom: 20px;">
				<select id="major" name="major" onchange="subList()" style="width:100px;height:30px;">
					<option value="">대분류</option>
					<c:forEach var="m_c" items="${mcategory }">
						<option value="${m_c }">${m_c }</option>
					</c:forEach>
				</select>&nbsp;&nbsp;&nbsp;
				
				<select id="sub" name="sub" onchange="sizeList()" style="width:100px;height:30px;">
					<option value="">소분류</option>
					
				</select>&nbsp;&nbsp;&nbsp;
				
				<select id="size" name="size" onchange="colorList()" style="width:100px;height:30px;">
					<option value="">사이즈</option>
					
				</select>&nbsp;&nbsp;&nbsp;
				
				<select id="color" name="color" style="width:100px;height:30px;">
					<option value="">색상</option>
					
				</select>&nbsp;&nbsp;&nbsp;
			</div>
			<div>
				<div>상품명</div>
				<div style="margin-bottom: 20px;width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;">
					<input type="text" name="pname" style="border:none;width:300px;height:25px;">
				</div>
				<div>가격</div>
				<div style="margin-bottom: 20px;width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;">
					<input type="text" name="price" style="border:none;width:300px;height:25px;">
				</div>
				<div>재고</div>
				<div style="margin-bottom: 20px;width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;">
					<input type="text" name="cnt" style="border:none;width:300px;height:25px;">
				</div>
				<div>이미지</div>
				<div style="margin-bottom: 20px;width:350px;height:35px;border:1px solid lightgray;padding-left: 10px;padding-top:13px;">
					<input type="file" name="pimg" style="border:none;width:300px;height:25px;">
				</div>
				<div>
					<input type="submit" value="상품등록" style="width:360px;height:50px;cursor: pointer;font-weight: bold;font-size:20px;background-color: black;color:white;border:none;">
				</div>
			</div>
		</form>
	</div>
</div>