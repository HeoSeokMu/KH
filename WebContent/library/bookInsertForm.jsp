<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>책 등록</h2>

<form method="post" action="bookInsertFormPro.kh" enctype="multipart/form-data">
															
<table border="1">
<tr>
	<td>책 번호</td>
	<td><input type="text" name="book_id" value=""></td>
	<td>제목</td>
	<td><input type="text" name="book_title" value=""></td>
	<td>위치</td>
	<td><input type="text" name="book_location" value=""></td>
</tr>
<tr>
	<td>저자</td>
	<td><input type="text" name="book_writer" value=""></td>
	<td>출판사</td>
	<td><input type="text" name="book_publisher" value=""></td>
	<td>출판년도</td>
	<td><input type="text" name="book_year" value=""></td>
	
</tr>
<tr>
	
	<td>부록</td>
	<td><input type="text" name="book_supplement" value=""></td>
	<td>isbn</td>	
	<td><input type="text" name="isbn" value=""></td>
	<td>책 이미지</td>
	<td><input type="file" name="upload" id="upload" accept="image/*" onChange="hideDefaultPic()">
					</td>
	
</tr>
<tr>
	<td colspan="6"><input type="submit" value="등록"></td>
</tr>

</table>
</form>