<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/KH_School/library/script/bookrequest.js"></script>    
    
<h2>책 신청</h2>

<form method="post" name="bookRequest" action="#" enctype="multipart/form-data">
<input type="hidden" name="id" value="${id }">
<input type="hidden" name="name" value="${name}">
<input type="hidden" name="s_phone" value="${s_phone}">											
<table border="1">
<tr>
	
	<td>제목</td>
	<td><input type="text" name="book_title" value=""></td>
	<td>저자</td>
	<td><input type="text" name="book_writer" value=""></td>
	<td>출판사</td>
	<td><input type="text" name="book_publisher" value=""></td>
	<td>isbn</td>	
	<td><input type="text" name="isbn" value=""></td>
			
</tr>
<tr>
	<td>학번</td>
	<td>${id}</td>
	<td>이름</td>
	<td>${name }</td>
	<td>전화번호</td>
	<td>${s_phone}</td>
</tr>
<tr>
	<td colspan="10" align="center"><input type="button" name="reqeust" value="책신청하기" onClick="bookR();"><br/>
	
	</td>
</tr>


</table>
</form>