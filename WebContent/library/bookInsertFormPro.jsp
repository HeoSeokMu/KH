<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<font size="6">
<table border="1">
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
	<td>책이미지: ${dto.file_orgname } </td>
	</tr>
	</table>
</font>
