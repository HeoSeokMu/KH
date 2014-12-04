<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>도서목록</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<center>
<body>
<b>도서목록(전체 도서:${count}권)</b>

<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
    	등록된 책이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="true">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="200" >이미지</td> 
      <td align="center"  width="100" >제목</td>
      <td align="center"  width="100" >저자</td>
      <td align="center"  width="100" >출판사</td>
      <td align="center"  width="100" >출판년도</td>
      <td align="center"  width="100" >부록</td>
      <td align="center"  width="100" >위치</td>
      <td align="center"  width="100" >등록번호</td>
      <td align="center"  width="100" >대출여부</td>
      <c:if test="${memId}=='book_admin'">
      	<td align="center"  width="100" >대출</td>
      </c:if>
      <c:if test="${memId}!='book_admin'">
      	<td align="center"  width="100" >알림서비스</td>
      </c:if>
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr height="60">
    <td align="center"  width="100" >
	  <img src="/KH_School/book_image/${article.imagename}" width="100%" height="100%"/>
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
    <td align="center"  width="100">
    	<c:out value="${article.book_year}"/>
    </td>
    <td align="center"  width="100">
    	<c:out value="${article.book_supplement}"/>
    </td>
    <td align="center"  width="100">
    	<c:out value="${article.book_location}"/>
    </td>
    <td align="center"  width="100">
    	<c:out value="${article.book_id}"/>
    </td>
    <td align="center"  width="100">
    	<c:out value="${article.loan}"/>
    </td>
    <td align="center" width="100" >
    	<c:if test="${article.loan}=='보관중'">
    		<c:if test="${memId}=='book_admin'">
      			<a href="/KH_School/numInputForm.kh">대출</a>
      		</c:if>
      		<c:out value=""/>
    	</c:if>
    	<c:if test="${article.loan}=='대출중'">
    		<a href="/KH_School/noticeForm.kh">반납알림받기</a>
    	</c:if>
    </td>
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
        <a href="/KH_School/bookList.kh?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/KH_School/bookList.kh?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/KH_School/bookList.kh?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>


</body>
</center>
</html>