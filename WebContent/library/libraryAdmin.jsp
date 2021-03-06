<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>도서관리자페이지</title>
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<center>
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
도서검색 <form action="bookList.kh" method="get">
	<select name="searchType" >
		<option value="all">전체</option>
		<option value="title">서명</option>
		<option value="writer">저자</option>
	</select>
	<input type="text" name="keyword" />
	<input type="submit" value="검색" />
</form>
<input type="button" name="bookInsert" value="책 등록" onClick="javascript:location.href='bookInsertForm.kh'">

<input type="button" name="bookRequest" value="구입신청내역" onClick="javascript:location.href='bookRequestList.kh'">
<input tyep="button" name="retrun" value="메인페이지" onClick="javascript:location.href='libraryMain.kh'">
<table width="700" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td>
			<c:if test="${searchType=='all'}">
				<strong>검색어[키워드/전체:${keyword}]</strong>
			</c:if>
			<c:if test="${searchType=='title'}">
				<strong>검색어[키워드/서명:${keyword}]</strong>
			</c:if>
			<c:if test="${searchType=='writer'}">
				<strong>검색어[키워드/저자:${keyword}]</strong>
			</c:if>
			<c:if test="${searchType=='' || searchType==null}">
				<strong>검색어[키워드/전체:${keyword}]</strong>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			총 <strong>${totalCount}</strong>건 중 <strong>${totalCount}</strong>건 출력
		</td>
	</tr>
</table>

<c:if test="${totalCount == 0}">
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
    	검색결과가 없습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="${totalCount > 0}">
<table border="1" cellpadding="0" cellspacing="0" align="center"> 


   <c:forEach var="article" items="${list}">
   <tr height="60">
   <td align="center">${article.book_id }</td>
    <td align="center"  width="100" height="110">
	  <img src="/KH_School/upload/book_img/${article.book_img}" width="100%" height="100%"/>
	</td>
    <td >
		<c:out value="${article.book_title}"/><br/>
	   <c:out value="${article.book_writer}"/>
		<c:out value="${article.book_publisher}"/>
		<c:out value="${article.book_year}"/>
    	<c:out value="${article.book_supplement}"/>
    	<c:out value="${article.book_location}"/>
    	<br/>
    	<fmt:formatDate value="${article.reg_date}" type="date" pattern="yyyy-MM-dd "/>
    	
   </td>
   <td>${article.loan}</td>
   <td>
   <input type="button" name="bookModify" value="수정" onClick="javascript:location.href='bookModifyForm.kh?book_id=${article.book_id}'">
   <c:if test="${article.loan =='대출가능' }">
   <input type="button" name="bookDelete" value="삭제" onClick="javascript:location.href='bookDelete.kh?book_id=${article.book_id}'">
   </c:if></td>
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
