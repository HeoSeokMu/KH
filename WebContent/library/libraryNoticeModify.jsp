<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/KH_School/library/script/library.js"></script>    
    
<h2>도서관 공지사항 수정</h2>

<form method="post" name="libraryNoticeForm" action="libraryNoticeModifyFormPro.kh" enctype="multipart/form-data">
<input type="hidden" name="no" value="${notice.no }">	
<table border="1">
<tr>
	
	<td>작성자</td>
	<td>${notice.writer }</td>
</tr>
<tr>
	<td>제목</td>
	<td><input type="text" name="subject" value="${notice.subject }"><span style="float:right;">작성일<fmt:formatDate value="${notice.reg_date}" type="date" pattern="[yyyy-MM-dd]"/></span></td>
	
</tr>
<tr>
	<td>내용</td>
	<td><textarea rows="30" cols="70" name="content" >${notice.content}</textarea></td>
	
</tr>
<tr>
	<td colspan="2">
	<input type="file" name="upload" id="upload">
	</td>
</tr>
<tr>
	
	<td colspan="2" align="center">
	<input type="submit">
	<input type="button" name="join" value="작성완료" ></td>
</tr>


</table>
</form>