<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>나의도서신청목록</title>
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<center>
나의도서신청목록<br/><br/>

<body>
<jsp:include page="/main/s_sidebar.jsp" />
		<div id="box3">
<tr>
	<td>
	<input type="button" name="ok" value="돌아가기" onClick="javascript:location.href='libraryMain.kh'"/>
	</td>
</tr>
<c:if test="${totalCount > 0}">
<table border="1" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="${value_c}">
	  <td align="center"  width="100" >신청번호</td>   
      <td align="center"  width="100" >제목</td>
      <td align="center"  width="100" >저자</td>
      <td align="center"  width="100" >출판사</td>
      <td align="center"  width="100" >등록일</td>
      <td align="center"  width="100" >ISBN</td>
      <td align="center"  width="100" >신청상황</td>
      
    </tr>

   <c:forEach var="article" items="${list}">
      <tr height="60">
   <td align="center" width="100" >
		<c:out value="${article.book_id}"/>
	</td>
    <td align="center" width="100" >
		<c:out value="${article.book_title}"/>
	</td>
    <td align="center"  width="100"> 
       <c:out value="${article.book_writer}"/>
	</td>
    <td align="center"  width="100">
    	<c:out value="${article.book_publisher}"/>
	</td>
    <td align="center"  width="130">
    	<fmt:formatDate value="${article.reg_date}" type="date" pattern="yyyy-MM-dd "/>
    	
    </td>
    <td align="center"  width="100">
    	<c:out value="${article.isbn}"/>
    </td>
    <td align="center"  width="100">
    	<c:if test="${article.bookcheck=='0'}">구입신청중
    	<input type="button" name="cencle" value="취소하기" onClick="javascript:location.href='myBookRequestDelete.kh?book_id=${article.book_id}'">
    	</c:if>
    	<c:if test="${article.bookcheck=='1'}">도서구입중</c:if>
    	<c:if test="${article.bookcheck=='2'}">취소상태</c:if>
    </td>
    
  </tr>
  </c:forEach>
</table>
</c:if>
<c:if test="${totalCount == 0}">
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
    	신청내역이 없습니다.
    </td>
  </tr>
</table>
</c:if>
<c:if test="${totalCount > 0}">
	${pagingHtml}
</c:if>

	</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>