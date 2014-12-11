<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>나의도서신청목록</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<center>
<body>


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
    	<c:if test="${article.bookcheck=='0'}">구입신청중</c:if>
    	<c:if test="${article.bookcheck=='1'}">도서구입중</c:if>
    	<c:if test="${article.bookcheck=='2'}">취소상태</c:if>
    </td>
    
  </tr>
  </c:forEach>
</table>
</c:if>
<c:if test="${totalCount > 0}">
	${pagingHtml}
</c:if>

</body>
</center>
</html>