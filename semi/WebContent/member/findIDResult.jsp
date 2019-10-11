<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div>
		<p>${findID }</p>
		<p><span id="count"></span>초 후 로그인 페이지로 이동합니다.</p>
	</div>
<script type="text/javascript">
	(() => {
		var count = document.getElementById("count");
		var countN = 4;
		count.innerHTML = countN;
		() => {
			setInterval(() => {
				countN = parseInt(countN)-1;
				count.innerHTML = countN;
			}, 1000);
		}
		() => {
			if (parseInt(countN) === 0) {
				location.href="${cp}/member/login";
			}
		//setTimeout(location.href="${cp}/member/login", 4000);
		}
	})();
</script>