<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>도서 수정</title>
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
</head>
<body>
		<div id="box3">
<center><b>도서 수정</b>
<br/>
<form method="post" action="bookModifyFormPro.kh" enctype="multipart/form-data">
<input type="hidden" name="book_id" value="${book.book_id}">
<table border="1">
<tr>
	<td>책 번호 :${book.book_id}</td>
	<td>제목 : <input type="text" name="book_title" value="${book.book_title}"></td>
	<td>위치 : <input type="text" name="book_location" value="${book.book_location}"></td>
</tr>
<tr>
	<td>저자 : <input type="text" name="book_writer" value="${book.book_writer}"></td>
	<td>출판사 : <input type="text" name="book_publisher" value="${book.book_publisher }"></td>
	<td>출판년도 : <input type="text" name="book_year" value="${book.book_year }"></td>
	
</tr>
<tr>
	<td>부록 : <input type="text" name="book_supplement" value="${book.book_supplement}"></td>
	<td>isbn : <input type="text" name="isbn" value="${book.isbn}"></td>
	<td>책이미지:	<img src="/KH_School/upload/book_img/${book.book_img}" width=100 height=100> 
	
	<input type="file" name="upload" id="upload" accept="image/*" onChange="hideDefaultPic()">
					</td></td>
	</tr>
<tr>
	<td><a href="/KH_School/libraryAdmin.kh">취소하기</a>
	<td colspan="6"><input type="submit" value="등록"></td>
</tr>
</table>
</form>
</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>
