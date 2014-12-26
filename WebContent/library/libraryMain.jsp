<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>도서관 메인페이지</title>
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
</head>

<body onload="">
		<c:if test="${type == '교직원'}">
			<jsp:include page="/main/e_sidebar.jsp" />
		</c:if>
		<c:if test="${type == '교수'}">
			<jsp:include page="/main/p_sidebar.jsp" />
		</c:if>
		<c:if test="${type == '학생'}">
			<jsp:include page="/main/s_sidebar.jsp" />
		</c:if>
		<div id="box3">
			<center>
<h1>KH대학교 학술 정보원</h1>
<form action="libraryNotice.kh">
	<table border="1" width="300">
		<tr align="center">
		<td>공지사항</td>
		<td><input type="button" value="More" onClick="javascript:location.href='libraryNoticeList.kh'"></td>
		<input type="button" value="학교메인페이지로" onClick="javascript:location.href='KHInfo.kh'">
		<c:if test="${type == '교직원' }">
		<input type="button" value="공지사항 쓰기" onClick="javascript:location.href='libraryNoticeForm.kh'">
		<input tyep="button" value="관리자 페이지" onClick="javascript:location.href='libraryAdmin.kh'">
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
<table border="1">
<tr>
	<td><input type="button" name="List" value="도서리스트" onClick="javascript:location.href='bookList.kh'"></td>
	<c:if test="${memId!=null }"><td><input type="button" name="Request" value="도서구입신청" onClick="javascript:location.href='bookRequest.kh'"></td>
	<td><input type="button" name="MyRequest" value="도서구입신청내역" onClick="javascript:location.href='myBookRequestList.kh'"></td></c:if>
</tr>
</table>

</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>