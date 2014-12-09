<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<font size="6">
<table border="1">
<tr>
	<td>책번호 : ${dto.book_id}</td>
	<td>제목 : ${dto.book_title}</td>
	<td>위치 : ${dto.book_location}</td>
</tr>
<tr>
	<td>저자 : ${dto.book_writer}</td>
	<td>출판사 : ${dto.book_publisher}</td>
	<td>출판년도 : ${dto.book_year}</td>
	
</tr>
<tr>
	<td>부록 : ${dto.book_supplement}</td>
	<td>책 이미지: <img src="/KH_School/upload/book_img/${book.book_img}" width=100 height=100></td>
	<td>isbn : ${dto.isbn}</td>
	</tr>
	
	<tr>
		<td><a href="/KH_School/bookDelete.kh?book_id=${dto.book_id}">삭제하기</a>
		<td><a href="/KH_School/bookModifyForm.kh?book_id=${dto.book_id}">책수정하기</a>
		<td><a href="/KH_School/bookView.kh?book_id=${dto.book_id }">책보기</a>
	</table>
</font>
