<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="post" action="${cp }/boardl/1and1board">
<div id="main">
<table>
<tr>
	<td>
	<table width="1500px" cellpadding="0" cellspacing="0" border="0">
	<tr style="text-align: left;">
	<td width="10"></td>
	<td><h1>1:1문의 게시판</h1></td>
	</tr>
	</table>
	<table>
	<tr>
	<td>&nbsp;</td>
	<td><h5>질문유형</h5>  <input type="radio" name="ask" value="사이즈">사이즈  <input type="radio" name="ask" value="교환">교환  <input type="radio" name="ask" value="환불">환불  <input type="radio" name="ask" value="기타">기타</td>
	<td>&nbsp;</td>
	</tr>
	<tr height="1" bgcolor="black"><td colspan="4"></td></tr>
	<tr>
	<td>&nbsp;</td>
	<td align="center">제목</td>
	<td><input type="text" name="title" size="50"><br></div></td>
	<td>&nbsp;</td>
	</tr>
	<tr height="1" bgcolor="black"><td colspan="4"></td></tr>
	<tr>
	<td>&nbsp;</td>
	<td align="center">내용</td>
	<td><textarea rows="10" cols="100" name="content"></textarea></td>
	<td>&nbsp;</td>
	</tr>
	<tr height="1" bgcolor="black"><td colspan="4"></td></tr>
	<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
	<tr align="center">
	</table>
</tr>
</table>
<div ><input type="submit" value="등록"></div>
</div>

