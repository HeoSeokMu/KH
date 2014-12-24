<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>도서관 메인페이지</title>
</head>

<body>
<h1>KH대학교 학술 정보원</h1>
<form action="libraryNotice.kh">
	<table border="1" width="300">
		<tr align="center">
		<td>공지사항</td>
		<td><input type="button" value="More" onClick="javascript:location.href='libraryNoticeList.kh'"></td>
		<c:if test="${memId == 'liadmin' }">
		<input type="button" value="공지사항 쓰기" onClick="javascript:location.href='libraryNoticeForm.kh'">
		</c:if></tr>
		<tr>
		<td colspan="2">
			<c:forEach var="list" items="${list}">
			<tr>
			<td colspan="2"><a href="libraryNoticeView.kh?no=${list.no}">${list.subject}</a>
			<span style="float:right;"><fmt:formatDate value="${list.reg_date}" type="date" pattern="[yyyy-MM-dd]"/></span></td>
		
			</tr>
			</c:forEach>
		
		</td>
		</tr>
	</table>
</form>


<form action="bookList.kh" method="get">
도서검색 	<select name="searchType" >
		<option value="all">전체</option>
		<option value="title">서명</option>
		<option value="writer">저자</option>
	</select>
	<input type="text" name="keyword" />
	<input type="submit" value="검색" />
</form>

</body>