<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>도서 수정</title>
</head>
<center><b>도서 수정</b>
<br/>
<form action="/KH_School/bookModifyForm.kh?pageNum=${pageNum}" method="post" name="bookModify">
<tr>
	<td>책 번호 : ${dto.book_id}
	<input type="hidden" name="book_id" value="${dto.book_id}"></td>
	<td>제목 : <input type="text" name="book_title" value="${dto.book_title}"></td>
	<td>위치 : <input type="text" name="book_location" value="${dto.book_location}"></td>
</tr>
<tr>
	<td>저자 : <input type="text" name="book_writer" value="${dto.book_writer}"></td>
	<td>출판사 : <input type="text" name="book_publisher" value="${dto.book_publisher }"></td>
	<td>출판년도 : <input type="text" name="book_year" value="${dto.book_year }"></td>
	
</tr>
<tr>
	<td>부록 : <input type="text" name="book_supplement" value="${dto.book_supplement}"></td>
	<td>책이미지 <input type="file" name="file_orgname" value=""></td>
	</tr>

</form>

</html>