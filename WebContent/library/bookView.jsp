<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<font size="6">
<table border="1">
<tr>
	<td>책 이름 : ${book.book_id}</td>
	<td>제목 : ${book.book_title}</td>
	<td>위치 : ${book.book_location}</td>
</tr>
<tr>
	<td>저자 : ${book.book_writer}</td>
	<td>출판사 : ${book.book_publisher }</td>
	<td>출판년도 : ${book.book_year }</td>
	
</tr>
<tr>
	<td>부록 : ${book.book_supplement}</td>
	<td>책이미지: 
	
	<img src="/KH_School/upload/book_img/${book.book_id}.jpg"> </td>
	<td>isbn: ${book.isbn}</td>
	</tr>
	
	<tr>
		<td><a href="/KH_School/bookDelete.kh?book_id=${book.book_id}">삭제하기</a>
		<td><a href="/KH_School/bookModifyForm.kh?book_id=${book.book_id}">책수정하기</a>
		<td><a href="/KH_School/bookView.kh">책보기</a>
	</table>
</font>
