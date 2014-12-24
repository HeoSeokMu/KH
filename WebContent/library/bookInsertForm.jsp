<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/KH_School/library/script/library.js"></script>    
    
<h2>책 등록</h2>

<form method="post" name="bookInsert" action="#" enctype="multipart/form-data">
															
<table border="1">
<tr>
	
	<td>제목</td>
	<td><input type="text" name="book_title" value=""></td>
	<td>위치</td>
	<td><input type="text" name="book_location" value=""></td>
	<td>저자</td>
	<td><input type="text" name="book_writer" value=""></td>
</tr>
<tr>
	<td>출판사</td>
	<td><input type="text" name="book_publisher" value=""></td>
	<td>출판년도</td>
	<td><input type="text" name="book_year" value=""></td>
	<td>부록</td>
	<td><input type="text" name="book_supplement" value=""></td>
	
</tr>
<tr>
	<td>isbn</td>	
	<td><input type="text" name="isbn" value=""></td>
	<td>책 이미지 </td>
	<td><input type="file" name="upload" id="upload" accept="image/*" onChange="hideDefaultPic()"></td>
	<td colspan="2" align="center"><input type="button" name="join" value="책등록하기" onClick="enter();"></td>
</tr>


</table>
</form>