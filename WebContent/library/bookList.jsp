<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>도서목록</title>
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
<script type="text/javascript">
	function checkIt() {
		q = confirm("가입시 등록된 이메일을 통해 알람을 받으시겠습니까");
		if(q==true){
			return;
		}else{
			return false;
		}
	}
</script>

<body>

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
<br/>
도서검색 <form action="bookList.kh" method="get">
	<select name="searchType" >
		<option value="all">전체</option>
		<option value="title">서명</option>
		<option value="writer">저자</option>
	</select>
	<input type="text" name="keyword" />
	<input type="submit" value="검색" />
</form>

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
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="100" >이미지</td> 
      <td align="center"  width="100" >제목</td>
      <td align="center"  width="100" >저자</td>
      <td align="center"  width="100" >출판사</td>
      <td align="center"  width="100" >출판년도</td>
      <td align="center"  width="100" >부록</td>
      <td align="center"  width="100" >위치</td>
      <td align="center"  width="100" >등록번호</td>
      <td align="center"  width="100" >대출여부</td>
      <c:if test="${memId=='book_admin'}">
      	<td align="center"  width="100" >대출</td>
      </c:if>
      <c:if test="${memId!='book_admin'}">
      	<td align="center" width="100" >알림서비스</td>
      </c:if>
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
    	<c:if test="${article.loan=='대출가능'}">
    		<c:if test="${memId=='2014001002'}">
      			<a href="/KH_School/inputNumForm.kh?book_id=${article.book_id}&book_title=${article.book_title}">대출</a>
      		</c:if>
      		<c:out value=""/>
    	</c:if>
    	<c:if test="${article.loan=='대출중'}">
    		<a href="/KH_School/inputNumForm.kh?book_id=${article.book_id}&book_title=${article.book_title}">대출</a>
    		<a href="/KH_School/notice.kh?b_num=${article.book_id}&s_num=${memId}" onclick="return checkIt()">반납알림받기</a>
    		<c:if test="${memId=='2014001002'}">
      			<a href="/KH_School/turnin.kh?book_id=${article.book_id}">반납</a>
      		</c:if>
    	</c:if>
    </td>
  </tr>
  </c:forEach>
</table>
</c:if>
<br/>
<c:if test="${totalCount > 0}">
	${pagingHtml}
</c:if>


</center>
<br/>

</div>

	<div id="box4"><center><br /><br /></center></div>

</body>


</html>