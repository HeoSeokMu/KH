<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<font size="6">
<table border="1">
<tr>
	<td>책번호 : ${book.book_id}</td>
	<td>제목 : ${book.book_title}</td>
	<td>위치 : ${book.book_location}</td>
</tr>
<tr>
	<td>저자 : ${book.book_writer}</td>
	<td>출판사 : ${book.book_publisher}</td>
	<td>출판년도 : ${book.book_year}</td>
	
</tr>
<tr>
	<td>부록 : ${book.book_supplement}</td>
	<td><img src="/KH_School/upload/book_img/${book.book_img}" width=100 height=100> </td>
	<td>isbn: ${book.isbn}</td>
	</tr>
	
	<tr>
		<td colspan="3" align="center"><a href="/KH_School/bookList.kh">확인</a>
		</td>
	</tr>
	</table>
</font>
