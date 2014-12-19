<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
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
		<c:if test="${type == '학생'}">
			<jsp:include page="/main/s_sidebar.jsp" />
		</c:if>
<div id="box3">
<br/>
<table>	
			<tr>
				<td>
					책번호
				</td>
				<td>
					${dto.book_id}
				</td>
				<td>
					책제목
				</td>
				<td>
					${dto.book_title}
				</td>
			</tr>
			<tr>
				<td>
					학번
				</td>
				<td>
					${dto.s_num}
				</td>
				<td>
					이름
				</td>
				<td>
					${s_name}
				</td>
			</tr>
			<tr>
				<td>
					전화번호
				</td>
				<td colspan="3">
					${s_phone}
				</td>
			</tr>
			<tr>
				<td>
					반납날짜
				</td>
				<td>
					<fmt:formatDate value="${dto.turnin}" pattern="yyyy년 MM월 dd일" />
				</td>
			</tr>
		</table>
			<br/>
			<input type="button" class="next" value="도서관 홈" onclick="javascript:window.location='bookList.kh'"/>
			<br/>
	</div>

	<div id="box4"><center><br /><br /></center></div>
</body>
</html>