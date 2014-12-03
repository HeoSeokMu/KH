<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>리스트</title>
</head>

<center><b>목록(전체:${count})</b>
<table width="700">
  <tr>
    <td align="right">
       <a href="/KH_School/bookInsertForm.kh">글쓰기</a>
    </td>
  </tr>
</table>

<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      게시판에 저장된 글이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="${count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="${value_c}"> 
      <td align="center"  width="50"  >책이름</td> 
      <td align="center"  width="250" >제목</td> 
      <td align="center"  width="100" >위치</td>
      <td align="center"  width="150" >저자</td> 
      <td align="center"  width="50" >출판사</td> 
      <td align="center"  width="100" >출판년도</td>
      <td align="center"  width="100" >부록</td>
      <td align="center"  width="100" >이미지</td>    
    </tr>

   <c:forEach var="list" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" >
	  <c:out value="${number}"/>
	  <c:set var="number" value="${number - 1}"/>
	</td>
    <td  width="250" >
	  <c:if test="${list.re_level > 0}">
	  	<img src="images/level.gif" width="${5 * list.re_level}" height="16">
	    <img src="images/re.gif">
	  </c:if>
	  <c:if test="${article.re_level == 0}">
	    <img src="images/level.gif" width="${5 * list.re_level}" height="16">
	  </c:if>
           
      <a href="/cyworldboard/content.do?num=${list.num}&pageNum=${currentPage}">
          ${article.subject}</a> 
          <c:if test="${article.readcount >= 20}">
            <img src="images/hot.gif" border="0"  height="16">
		  </c:if>
	</td>
    <td align="center"  width="100"> 
       ${list.book_writer}</a>
	</td>
    <td align="center"  width="150">${list.reg_date}
	</td>
    <td align="center"  width="50">${list.book_id}</td>
    <td align="center" width="100" >${list.book_title}</td>
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
   <c:if test="${endPage > pageCount }">
        <c:set var="endPage" value="${pageCount }"/>
   </c:if> 
          
   <c:if test="${startPage > 10}">
        <a href="/cyworldboard/list.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/cyworldboard/list.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/cyworldboard/list.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>

</center>
</body>
</html>