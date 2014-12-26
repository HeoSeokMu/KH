<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>도서신청목록</title>
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">
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
<br/><br/>

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


</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>
