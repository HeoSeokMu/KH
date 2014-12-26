<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>도서관공지사항</title>
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
    
<h2>도서관 공지사항 </h2>

<table border="2" width="500" cellspacing="0" cellpadding="0" style="word-break: break-all;">
<tr>
	<td>&nbsp;${notice.subject}</td>
</tr>
<tr>
	<td>&nbsp;작성자 | 도서관 <span style="float:right;">작성일 | <fmt:formatDate value="${notice.reg_date}" type="date" pattern="[yyyy-MM-dd]"/>&nbsp;&nbsp;&nbsp;조회수 | ${notice.readhit }&nbsp;</span>
</tr>
<tr valign="top">
	<td height="400" align="left">&nbsp;${notice.content }</td>
	
</tr>
<tr>
	<td>&nbsp;<input type="button" name="list" value="목록으로" onClick="javascript:location.href='libraryNoticeList.kh'">
	<c:if test="${type == '교직원' }">
	
	&nbsp;<input type="button" name="modify" value="수정하기" onClick="javascript:location.href='libraryNoticeModify.kh?no=${notice.no}'">
	<input type="button" name="delete" value="삭제하기" onClick="javascript:location.href='libraryNoticeDelete.kh?no=${notice.no}'">
	</c:if></td>
	</tr>
	
	</table>

	</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>
