<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
	.DateBox {
		display: inline-block;
	}
</style>
<div style="display:flex; justify-content: center;"><h1>매출 통계</h1></div>
<div>
	<span>시작 날짜</span>
	<div class="DateBox">
		<select id="startYear">
			
		</select>
	</div>
	<div class="DateBox">
		<select id="startMonth">
			<c:forEach var="i" begin="1" end="12" step="1">
			<option label="${i }">${i }</option>
			</c:forEach>
		</select>
	</div>
	<div class="DateBox">
		<select id="startDay">
			<c:forEach var="i" begin="1" end="31" step="1">
			<option label="${i }">${i }</option>
			</c:forEach>
		</select>
	</div>
</div>
<div>
	<span>종료 날짜</span>
	<div class="DateBox">
		<select id="endYear">
			
		</select>
	</div>
	<div class="DateBox"">
		<select id="endMonth">
			<c:forEach var="i" begin="1" end="12" step="1">
			<option label="${i }">${i }</option>
			</c:forEach>
		</select>
	</div>
	<div class="DateBox">
	<select id="endDay">
		<c:forEach var="i" begin="1" end="31" step="1">
		<option label="${i }">${i }</option>
		</c:forEach>
	</select>
	</div>
</div>
<script type="text/javascript">

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
</script>


