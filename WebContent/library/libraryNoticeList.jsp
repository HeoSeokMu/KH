 	<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>도서관공지사항리스트</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<center>
도서관공지사항<br/><br/>
<body>
<tr><td>
<input type="button" name="libraryBack" value="돌아가기" onClick="javascript:location.href='libraryMain.kh'"><br/>
</td></tr>
<c:if test="${totalCount > 0}">
<table border="1" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="100" >번호</td>
      <td align="center"  width="100" >제목</td>
      <td align="center"  width="100" >내용</td>
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="100" >등록일</td>
    </tr>

   <c:forEach var="article" items="${list}">
   <tr height="60">
   <td align="center" width="100" >
		${article.no}
	</td>
    <td align="center" width="100" >
		<a href="libraryNoticeView.kh?no=${article.no}"/>${article.subject}
	</td>
    <td align="center"  width="100"> 
       <c:out value="${article.content}"/>
	</td>
	<td align="center"  width="100"> 
       <c:out value="${article.writer}"/>
	</td>
    <td align="center"  width="130">
    	<fmt:formatDate value="${article.reg_date}" type="date" pattern="yyyy-MM-dd "/>
    	
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