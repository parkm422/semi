<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.DateBox {
	display: inline-block;
}

#title {
	display: flex;
	min-height: 130px;
}

.dateContainer {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-items: center;
	border-top-width: 3px;
	border-bottom-width: 3px;
	border-top-color: black;
	border-bottom-color: black;
	justify-content: flex-start;
}

.dateContainer .Date {
	margin-left: 60px;
	min-height: 60px;
}

body:before {
	content: '';
	height: 100%;
	display: inline-block;
	vertical-align: middle;
}

button {
	background: black;
	color: white;
	border: none;
	height: 30px;
	font-size: 1em;
	padding: 0 2em;
	cursor: pointer;
	transition: 300ms ease all;
	outline: none;
	margin-left: 1200px;
}

button:hover {
	background: white;
	color: black;
}
#inqList {
	min-width: 100px;
	min-height: 100px;
}
#inqResult {
	width: 1500px;
	min-width: 100px;
	min-height: 100px;
	display: flex;
  	justify-content: space-around;
  	border: 2px;
}
th{
	min-width:200px;
	height:40px;
}
td{
	min-width:200px;
	height:40px;
	text-align: center;
}
#totalAmount {
	height:200px;
	display: flex;
	align-items: center;
}
</style>
<div id="main">
	<div id="title">
		<h1 style="margin-left: 37%; margin-top: 10px;">매출 통계</h1>
	</div>
	<div class="dateContainer">
		<div class="Date">
			<span>시작 날짜</span>
			<div class="DateBox">
				<select id="startYear" name="startYear" required>

				</select>
			</div>
			<div class="DateBox">
				<select id="startMonth" name="startMonth" required>
					<c:forEach var="i" begin="1" end="12" step="1">
						<option label="${i }">${i }</option>
					</c:forEach>
				</select>
			</div>
			<div class="DateBox">
				<select id="startDay" name="startDay" required>
					<c:forEach var="i" begin="1" end="31" step="1">
						<option label="${i }">${i }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="Date">
			<span>종료 날짜</span>
			<div class="DateBox">
				<select id="endYear" name="endYear" required>

				</select>
			</div>
			<div class="DateBox">
				<select id="endMonth" name="endMonth" required>
					<c:forEach var="i" begin="1" end="12" step="1">
						<option label="${i }">${i }</option>
					</c:forEach>
				</select>
			</div>
			<div class="DateBox">
				<select id="endDay" name="endDay" required>
					<c:forEach var="i" begin="1" end="31" step="1">
						<option label="${i }">${i }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div>
		<button type="button" id="inqButton" onclick="arst()">조회</button>
	</div>
	<div id="inqResult">
		<table id="inqList">
		</table>
	</div>
	<div id="totalAmount"></div>
</div>
<script type="text/javascript">

	//달력
	var day5month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	var date = new Date();
	
	var startMonth = document.getElementById("startMonth");
	var startYear = document.getElementById("startYear");
	var startDay = document.getElementById("startDay");
	for (var i=2016; i<=date.getFullYear(); i++) {
		startYear.innerHTML += "<option label=\"i\">" + i + "</option>"
	}
	startYear.addEventListener("click", () => {
		if ((startYear.value%4 === 0 && startYear.value%100 !== 0) || startYear%400 === 0) {
			day5month[1] = 29;
		} else {
			day5month[1] = 28;
		}
	});
	startMonth.addEventListener("click", () => {
		startDay.innerHTML = "";
		for (var i=1; i<=day5month[startMonth.value-1]; i++) {
			startDay.innerHTML += "<option label=\"i\">" + i + "</option>";
		}
	}, false);

	var endYear = document.getElementById("endYear");
	var endMonth = document.getElementById("endMonth");
	var endDay = document.getElementById("endDay");
	for (var i=2016; i<=date.getFullYear(); i++) {
		endYear.innerHTML += "<option label=\"i\">" + i + "</option>"
	}
	endYear.addEventListener("click", () => {
		if ((endYear.value%4 === 0 && endYear.value%100 !== 0) || endYear%400 === 0) {
				day5month[1] = 29;
		} else {
				day5month[1] = 28;
		}
	});
	endMonth.addEventListener("click", () => {
		endDay.innerHTML = "";
		for (var i=1; i<=day5month[endMonth.value-1]; i++) {
			endDay.innerHTML += "<option label=\"i\">" + i + "</option>";
		}
	}, false);
	
	
	//AJAX로 조회
	
	var xhr = null;
	function arst() {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open('get', '${cp }/manager/salesStatistics?startYear=' + startYear.value + '&startMonth=' + startMonth.value + '&startDay=' + startDay.value
												+ '&endYear=' + endYear.value + '&endMonth=' + endMonth.value + '&endDay=' + endDay.value, true);
		xhr.send();
	}
	
	function callback() {
		if(xhr.readyState==4 && xhr.status==200) {
			var data = xhr.responseText;
			var json = JSON.parse(data)[0];
			var inqList = document.getElementById("inqList");
			inqList.innerHTML = "<tr><th>주문번호</th><th>주문일자</th><th>주문인</th><th>주문액수</th></tr>" 
			var total = 0;
			for(var i in json) {
				inqList.innerHTML += "<tr><td>" + json[i].ornum + "</td><td>" + json[i].orderdate + "</td><td>" + json[i].getName + "</td><td>" + json[i].amount + "</td></tr>"
				total += json[i].amount;
			}
			
			var totalAmount = document.getElementById("totalAmount")
			console.log(total);
			totalAmount.innerHTML = "<h4>매출 합계: " + total + "</h4>"
		}
	}
	
	//var inqButton = document.getElementById("inqButton");
	//inqButton.addEventListener("click", function () {
	//	xhr = new XMLHttpRequest();
	//	xhr.onreadystatechange = callback;
	//	xhr.open('get', '/manager/salesStatistics?startYear=' + startYear.value + '&startMonth=' + startMonth.value + '&startDay=' + startDay.value
	//											+ '&endYear=' + endYear.value + '&endMonth=' + endMonth.value + '&endDay=' + endDay.value, true);
	//	xhr.send();
	//}, false);
</script>


