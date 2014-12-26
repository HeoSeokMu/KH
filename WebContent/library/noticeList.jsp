<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>알림 목록</title>
<link href="style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
<link rel="stylesheet" href="css/left_menu.css"></link>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/leftMenu_jquery.js"></script>
<style>
.login {
	background-color: #7eb813;
	color: #ffffff;
	border: 1px #dddddd dashed;
	width: 70px;
	height: 60px;
	text-align: center;
	padding: 3px;
}

.trTitle {
	height: 15px;
}

.input {
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
		if (q == true) {
			return;
		} else {
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
	<c:if test="${type != '교수' && type != '교직원'}">
		<jsp:include page="/main/s_sidebar.jsp" />
	</c:if>
	<div id="box3">
		<center>
			<br />

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
						<td align="center" width="100">이미지</td>
						<td align="center" width="100">제목</td>
						<td align="center" width="100">신청 이메일</td>
						<td align="center" width="100">신청날짜</td>
						<td align="center" width="100">삭제</td>
					</tr>

					<c:forEach var="article" items="${list}">
						<tr>
							<td align="center" width="100" height="110"><img src="/KH_School/upload/book_img/${article.book_img}" width="100%" height="100%" /></td>
							<td align="center" width="100"><c:out value="${article.b_num}" /></td>
							<td align="center" width="100"><c:out value="${article.email}" /></td>
							<td align="center" width="100"><fmt:formatDate value="${article.rent}" pattern="yyyy년 MM월 dd일" /></td>
							<td align="center" width="100"><a href="/KH_School/noticeDelete.kh?b_num=${article.b_num}">삭제</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<br />
		</center>
		<br />

	</div>

	<div id="box4">
		<center>
			<br />
			<br />
		</center>
	</div>

</body>


</html>