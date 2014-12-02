<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>책 등록</h2>

<form method="post" action="bookInsertFormPro.kh" enctype="mulipart/form-data">
<table border="1">
<tr>
	<td>책 이름</td>
	<td><input type="text" name="book_id" value="book_id"></td>
	<td>제목</td>
	<td><input type="text" name="book_title" value="booK_title"></td>
	<td>위치</td>
	<td><input type="text" name="book_location" value="booK_location"></td>
</tr>
<tr>
	<td>저자</td>
	<td><input type="text" name="book_writer" value="book_writer"></td>
	<td>출판사</td>
	<td><input type="text" name="book_publisher" value="booK_pubilsher"></td>
	<td>출판년도</td>
	<td><input type="text" name="book_year" value="booK_year"></td>
	
</tr>
<tr>
	<td>isbn</td>	
	<td><input type="text" name="isbn" value="isbn"></td>
	<td>부록</td>
	<td><input type="text" name="book_supplement" value="booK_supplement"></td>
	<td>책이미지</td>
	<td><input type="file" name="book_image" value="book_image"></td>
	
</tr>
<tr>
	<td colspan="6"><input type="submit" value="등록"></td>
</tr>

</table>
</form>