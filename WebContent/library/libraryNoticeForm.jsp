<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/KH_School/library/script/library.js"></script>    
    
<h2>도서관 공지사항</h2>

<form method="post" name="libraryNoticeForm" action="libraryNoticeFormPro.kh" enctype="multipart/form-data">
															
<table border="1">
<tr>
	
	<td>작성자</td>
	<td><input type="text" name="writer" value=""></td>
</tr>
<tr>
	<td>제목</td>
	<td><input type="text" name="subject" value=""></td>
	
</tr>
<tr>
	<td>내용</td>
	<td><textarea rows="30" cols="70" name="content"></textarea></td>
	
</tr>
<tr>
	<td colspan="2">
	<input type="file" name="upload" id="upload">
	</td>
</tr>
<tr>
	
	<td colspan="2" align="center">
	<input type="submit">
	<input type="button" name="join" value="작성완료" onClick="enter();"></td>
</tr>


</table>
</form>