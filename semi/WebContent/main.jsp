<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<script	type="text/javascript">
	var index=0;
	window.onload=function(){
		slideShow();
	}
	function slideShow() {
		var i;
		var x= document.getElementsByClassName("slide1");
		for(i=0;i<x.length;i++){
			x[i].style.display="none";
		}
		index++;
		if(index>x.length){
			index=1;
		}
		x[index-1].style.display="block";
		setTimeout(slideShow,4000);
	}


</script>

--%>
<div id="main">
	<h1>어서와 처음이지?</h1>
	
</div>
<%-- 
<div id="main">
	<h1>어서와 처음이지?</h1>
	<img class="slide1" src="${cp }/images/images1.jpg" style="max-width: 500px;" height="auto;" hidden="">
	<img class="slide1" src="${cp }/images/images2.jpg" style="max-width: 500px;" height="auto;" hidden="">
	<img class="slide1" src="${cp }/images/images3.jpg" style="max-width: 500px;" height="auto;" hidden="">
</div>
--%>