<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>강의평가</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
	<script src="/KH_School/library/script/library.js"></script>    
</head>

<body>
	<jsp:include page="/main/s_sidebar.jsp" />
		<div id="box3">
			<center>
			<form action="RestRequestInsert.kh" method="post">
				<br/><br/>

    
<h2>도서관 공지사항</h2>

<form method="post" name="libraryNoticeForm" action="libraryNoticeFormPro.kh" enctype="multipart/form-data">
<input type="hidden" name="writer" value="${memId }">								
<table border="1">
<tr>
	
	<td>작성자</td>
	<td>${memId }</td>
</tr>
<tr>
	<td>제목</td>
	<td><input type="text" name="subject" value=""></td>
	
</tr>
<tr>
	<td>내용</td>
	<td><textarea rows="30" cols="70" name="content"></textarea></td>
	
</tr>
<tr>
	<td colspan="2">
	<input type="file" name="upload" id="upload">
	</td>
</tr>
<tr>
	
	<td colspan="2" align="center">
	<input type="submit">
	</td>
</tr>


</table>
</form>
</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>