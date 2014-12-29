<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>도서대여목록</title>
<link href="style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
	<style>
		.login{
			background-color:#7eb813;
			color:#ffffff;
			border:1px #dddddd dashed;
			width:70px;
			height:60px;
			text-align:center;
			padding:3px;
		}
		.trTitle {
			height:15px;
		}
		.input{
			size: 15px;
		}
		
		.lineX {
			border-bottom: 1px solid #dddddd;
		}
		.tablepadding {
			padding-left: 15px;
			padding-right: 15px;
		}
	</style>
	
</head>

<body>
	<c:if test="${type == '교직원'}">
      <jsp:include page="/main/e_sidebar.jsp" />
   </c:if>
   <c:if test="${type == '교수'}">
      <jsp:include page="/main/p_sidebar.jsp" />
   </c:if>
   <c:if test="${type != '교수' && type != '교직원'}">
      <jsp:include page="/main/s_sidebar.jsp" />
   </c:if>
   <div id="box3">
<center>
<br/>
<c:if test="${totalCount == 0}">
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
    	검색결과가 없습니다.
    </td>
  </tr>
</table>
</c:if>

<h2>도서 대출 내역</h2>
<table border="1" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="100" >이미지</td> 
      <td align="center"  width="100" >제목</td>
      <td align="center"  width="100" >반납날짜</td>
    </tr>

   <c:forEach var="article" items="${list}">
   <tr height="60">
    <td align="center"  width="100" height="110">
	  		<img src="/KH_School/upload/book_img/${article.book_img}" width="100%" height="100%"/>
	</td>
    <td align="center" width="100" >
		<a href="/KH_School/bookView.kh?book_id=${article.book_id}"><c:out value="${article.book_title}"/></a>
	</td>
    <td align="center"  width="100"> 
       <c:out value="${article.turnin}"/>
	</td>
  </tr>
  </c:forEach>
</table>

<br/>

</center>
<br/>

</div>

	<div id="box4"><center><br /><br /></center></div>

</body>


</html>