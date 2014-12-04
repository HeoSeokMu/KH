<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>�������</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<center>
<body>
<b>�������(��ü ����:${count}��)</b>

<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
    	��ϵ� å�� �����ϴ�.
    </td>
  </tr>
</table>
</c:if>

<c:if test="true">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="200" >�̹���</td> 
      <td align="center"  width="100" >����</td>
      <td align="center"  width="100" >����</td>
      <td align="center"  width="100" >���ǻ�</td>
      <td align="center"  width="100" >���ǳ⵵</td>
      <td align="center"  width="100" >�η�</td>
      <td align="center"  width="100" >��ġ</td>
      <td align="center"  width="100" >��Ϲ�ȣ</td>
      <td align="center"  width="100" >���⿩��</td>
      <td align="center"  width="100" >����</td>
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" >
	  <img src="/KH_School/book_image/${article.}" width="100%" height="100%"/>
	</td>
    <td  width="250" >
	  <c:if test="${article.re_level > 0}">
	  	<img src="images/level.gif" width="${5 * article.re_level}" height="16">
	    <img src="images/re.gif">
	  </c:if>
	  <c:if test="${article.re_level == 0}">
	    <img src="images/level.gif" width="${5 * article.re_level}" height="16">
	  </c:if>
          
      <c:if test="${memId=='admin'}"> 
     	<a href="/framework/ch19/content.do?num=${article.num}&pageNum=${currentPage}">
          ${article.subject}</a>
      </c:if>
      <c:if test="${memId!='admin'}">
      	<a href="/framework/ch19/contentScr.do?num=${article.num}&pageNum=${currentPage}">
          ${article.subject}</a>
      </c:if>
          <c:if test="${article.readcount >= 20}">
            <img src="images/hot.gif" border="0"  height="16">
		  </c:if>
	</td>
    <td align="center"  width="100"> 
       <a href="mailto:${article.email}">${article.writer}</a>
	</td>
    <td align="center"  width="150">${article.reg_date}
	</td>
    <td align="center"  width="50">${article.readcount}</td>
    <td align="center" width="100" >${article.ip}</td>
  </tr>
  </c:forEach>
</table>
</c:if>

<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if> 

   <c:if test="${startPage > 10}">
        <a href="/framework/ch19/list.do?pageNum=${startPage - 10 }">[����]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/framework/ch19/list.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/framework/ch19/list.do?pageNum=${startPage + 10}">[����]</a>
   </c:if>
</c:if>


</body>
</center>
</html>