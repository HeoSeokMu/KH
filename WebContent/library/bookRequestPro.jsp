<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<font size="6">
<table border="1">

<tr>
	<td>제목 : ${dto.book_title}</td>
	<td>저자 : ${dto.book_writer}</td>
	<td>출판사 : ${dto.book_publisher}</td>
	<td>isbn : ${dto.isbn}</td>
</tr>
<tr>
	</tr>
	
		<tr>
			<td><a href="/KH_School/bookRequestDelete.kh?book_id=${dto.book_id}">취소하기</a>
			
		</td>
	</tr>
	</table>
</font>
