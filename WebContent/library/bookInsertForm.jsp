<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>도서관공지사항리스트</title>
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
	<script src="/KH_School/library/script/library.js"></script> 
<link href="style.css" rel="stylesheet" type="text/css">
</head>
   
    
<center>
책등록<br/><br/>
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
<form method="post" name="bookInsert" action="#" enctype="multipart/form-data">
															
<table border="1">
<tr>
	
	<td>제목</td>
	<td><input type="text" name="book_title" value=""></td>
	<td>위치</td>
	<td><input type="text" name="book_location" value=""></td>
	<td>저자</td>
	<td><input type="text" name="book_writer" value=""></td>
</tr>
<tr>
	<td>출판사</td>
	<td><input type="text" name="book_publisher" value=""></td>
	<td>출판년도</td>
	<td><input type="text" name="book_year" value=""></td>
	<td>부록</td>
	<td><input type="text" name="book_supplement" value=""></td>
	
</tr>
<tr>
	<td>isbn</td>	
	<td><input type="text" name="isbn" value=""></td>
	<td>책 이미지 </td>
	<td><input type="file" name="upload" id="upload" accept="image/*" onChange="hideDefaultPic()"></td>
	<td colspan="2" align="center"><input type="button" name="join" value="책등록하기" onClick="enter();">
	<input type="button" name="no" value="취소하기" onClick="javascript:location.href='libraryAdmin.kh'">
	</td>
</tr>


</table>
</form>
</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>