<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/KH_School/library/script/bookrequest.js"></script>    
    
<h2>책 신청</h2>

<form method="post" name="bookRequest" action="#" enctype="multipart/form-data">
															
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
	<td><input type="text" name="id" value=""></td>
	<td>이름</td>
	<td><input type="text" name="name" value=""></td>
	<td>전화번호</td>
	<td><input type="text" name="s_phone" value=""></td>
</tr>
<tr>
	<td colspan="10" align="center"><input type="button" name="reqeust" value="책신청하기" onClick="bookR();"><br/>
	
	</td>
</tr>


</table>
</form>