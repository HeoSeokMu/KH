<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>도서 삭제</title>
</head>
<center><b>도서 삭제</b>
<br/>
<form action="/KH_School/bookForm.kh?pageNum=${pageNum}" method="post" name="bookDelete">
<tr>
	<td>책 이름 : ${dto.book_id}</td>
	<td>제목 : ${dto.book_title}</td>
	<td>위치 : ${dto.book_location}</td>
</tr>
<tr>
	<td>저자 : ${dto.book_writer}</td>
	<td>출판사 : ${dto.book_publisher }</td>
	<td>출판년도 : ${dto.book_year }</td>
	
</tr>
<tr>
	<td>부록 : ${dto.book_supplement}</td>
	<td>책이미지 </td>
	</tr>
<tr>
	<td><input type="submit" value="책 삭제">
	<input type="button" value="책 목록" onclick="document.location.href='KH_School/bookInsertList.kh?pageNum=${pageNum}'">
</form>

</html>