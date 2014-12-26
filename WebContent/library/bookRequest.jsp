<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>책 신청</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
	<script src="/KH_School/library/script/bookrequest.js"></script>    
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
			<form action="RestRequestInsert.kh" method="post">
				<br/><br/>

    
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
	<td colspan="10" align="center"><input type="button" name="reqeust" value="책신청하기" onClick="bookR();">
	<input type="button" name="Main" value="취소하기" onClick="javascript:location.href='libraryMain.kh'"/>
	
	</td>
</tr>


</table>
</form>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>