<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<font size="6">
<table border="1">
<tr>
	<td>${notice.subject}</td>
</tr>
<tr>
	<td>작성자 |${notice.writer } 작성일 | <fmt:formatDate value="${notice.reg_date}" type="date" pattern="[yyyy-MM-dd]"/></span>조회수 | ${notice.readhit }
</tr>
<tr>
	<td>${notice.content }</td>
	
</tr>
<tr>
	<td><input type="button" name="list" value="목록으로" onClick="javascript:location.href='libraryNoticeList.kh'">
	<c:if test="${memId =='liadmin'}">
	
	<input type="button" name="modify" value="수정하기" onClick="javascript:location.href='libraryNoticeModify.kh?no=${notice.no}'">
	<input type="button" name="delete" value="삭제하기" onClick="javascript:location.href='libraryNoticeDelete.kh?no=${notice.no}'">
	</c:if></td>
	</tr>
	
	</table>
</font>

