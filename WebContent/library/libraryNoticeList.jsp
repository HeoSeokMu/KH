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
<table cellpadding="0" cellspacing="0" align="center"  style="border-collapse:collapse; border:0 solid slategray;"> 
<tr>
		<td colspan="6"><hr width="600"></td>
	</tr>
	
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="100" >번호</td>
      <td align="center"  width="100" >제목</td>
      <td align="center"  width="100" >내용</td>
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="100" >등록일</td>
      <td align="center"  width="100" >조회수</td>
	</tr>
	<tr>
		<td colspan="6"><hr width="600"></td>
	</tr>
		
   <c:forEach var="article" items="${list}">
   <tr height="60">
   <td align="center" width="100" >
		${article.no}
	</td>
    <td align="center" width="100" >
		<a href="libraryNoticeView.kh?no=${article.no}" style="text-decoration:none"/>${article.subject}
	</td>
    <td align="center"  width="100"> 
       <c:out value="${article.content}"/>
	</td>
	<td align="center"  width="100"> 
       <c:out value="${article.writer}"/>
	</td>
    <td align="center"  width="130">
    	<fmt:formatDate value="${article.reg_date}" type="date" pattern="yyyy-MM-dd "/>
    	<c:if test="${article.reg_date >= now}"><img src="http://library.yonsei.ac.kr/korea/images/list_new.gif"></a></c:if>
    	
    </td>
    <td align="center"  width="100"> 
       <c:out value="${article.readhit}"/>
	</td>
  </tr>
  <tr>
		<td colspan="6"><hr width="600"></td>
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