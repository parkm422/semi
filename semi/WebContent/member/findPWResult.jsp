<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div>
		<p>${findPW }</p>
		<p><span id="count">4</span>초 후 로그인 페이지로 이동합니다.</p>
	</div>
<script type="text/javascript">
(() => {
	var count = document.getElementById("count");
	var countN = 4;
	count.innerHTML = countN;
	() => {
		setInterval(() => {
			countN -= 1; 
		}, 1000);
	}
	() => {
		if (countN === 0) {
			location.href="${cp}/member/login";
		}
	//setTimeout(location.href="${cp}/member/login", 4000);
	}
})();
	
</script>