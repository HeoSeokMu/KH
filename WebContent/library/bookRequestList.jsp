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
도서신청목록<br/><br/>
<body>
<tr><td>
<input type="button" name="libraryAdmin" value="돌아가기" onClick="javascript:location.href='libraryAdmin.kh'"><br/>
</td></tr>
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
      <td align="center"  width="100" >학번</td>
      <td align="center"  width="100" >이름</td>
      <td align="center"  width="100" >전화번호</td>
      
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
    	<input type="button" name="bookRequestOk" value="승인" onClick="javascript:location.href='bookRequestOk.kh?book_id=${article.book_id}'">
    	<input type="button" name="bookRequestNo" value="반려" onClick="javascript:location.href='bookRequestNo.kh?book_id=${article.book_id}'">
    	</c:if>
    	<c:if test="${article.bookcheck=='1'}">도서구입중</c:if>
    	<c:if test="${article.bookcheck=='2'}">취소상태</c:if>
    </td>
    <td align="center"  width="100">
    	<c:out value="${article.id}"/>
    </td>
    <td align="center"  width="100">
    	<c:out value="${article.name}"/>
    </td>
    <td align="center"  width="100">
    	<c:out value="${article.s_phone}"/>
    </td>
    
  </tr>
  </c:forEach>
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
