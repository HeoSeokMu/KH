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
    
<h2>도서관 공지사항 수정</h2>

<form method="post" name="libraryNoticeForm" action="libraryNoticeModifyFormPro.kh" enctype="multipart/form-data">
<input type="hidden" name="no" value="${notice.no }">	
<table border="1" width="500" cellspacing="0" cellpadding="0" style="word-break: break-all;">
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
	<td><textarea rows="25" cols="70" name="content" >${notice.content}</textarea></td>
	
</tr>
<tr>
	<td colspan="2">
	<input type="file" name="upload" id="upload">
	</td>
</tr>
<tr>
	
	<td colspan="2" align="center">
	<input type="submit" value="작성완료">
	<input type="button" value="취소" onClick="javascript:location.href='libraryNoticeView.kh?no=${notice.no}'">
	</td>
</tr>


</table>
</form>
</center>
			<br/><br/>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>
