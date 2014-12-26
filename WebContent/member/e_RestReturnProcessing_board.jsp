<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${board_type}신청 처리 게시판</title>
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
<link rel="stylesheet" href="css/left_menu.css"></link>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/leftMenu_jquery.js"></script>
</head>
<body>
	<jsp:include page="/main/e_sidebar.jsp"/>
	<div id="box3">
		<center>
		<br/>
			<form method="post" name="chartForm">
				<h1>${board_type}신청 처리내역</h1>
				<hr width="880px" size="1" color="gray" align="center" />
				<hr width="880px" size="1" align="center" />
				<table align="center">
					<tr align="center">
						<td width="50px"><g>NO</g></td>
						<td width="120px"><g>학과</g></td>
						<td width="120px"><g>학번</g></td>
						<td width="120px"><g>학년</g></td>
						<td width="120px"><g>신청자</g></td>
						<td width="230px"><g>신청일자</g></td>
						<td width="120px"><g>처리</g></td>
					</tr>
				</table>
				<hr width="880px" size="3" color="#CC3D3D" align="center" />

				<c:if test="${totalCount < 1}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<table>
						<tr>
							<td align="left">게시물이 존재하지 않습니다.</td>
						</tr>
					</table>
				</c:if>

				<c:if test="${totalCount > 0}">
					<c:forEach var="list" items="${list}" varStatus="checkValue">
						<table align="center">
							<tr align="center" height="25px">
								<td width="50px">${(currentPage-1) * blockCount + (checkValue.index + 1)}
								</td>
								<td width="120px">${list.major}</td>
								<td width="120px">${list.id}</td>
								<td width="120px">${list.grade}</td>
								<td width="120px">
									<a href="RestContent.kh?num=${list.num}">${list.name}</a>
								</td>
								<td width="230px">
<<<<<<< HEAD
									<fmt:formatDate value="<%=new java.util.Date()%>" var="toDate" pattern="yy-MM-dd" />
									<fmt:formatDate value="${list.reg_date}" type="date" pattern="yy-MM-dd" var="writeDate"/>
									<c:if test="${writeDate == toDate}">
										<fmt:formatDate value="${list.reg_date}" type="both" pattern="HH시 mm분"/>
									</c:if>
									<c:if test="${writeDate != toDate}">
=======
									<fmt:formatDate value="<%=new java.util.Date()%>" var="toDate" pattern="dd" />
									<fmt:formatDate value="${list.reg_date}" type="date" pattern="dd" var="writeDay"/>
									<c:if test="${writeDay == toDate}">
										<fmt:formatDate value="${list.reg_date}" type="date" pattern="HH시 mm분"/>
									</c:if>
									<c:if test="${writeDay != toDate}">
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
										<fmt:formatDate value="${list.reg_date}" type="date" pattern="yy년 MM월 dd일"/>
									</c:if>
								</td>
								<td width="120px">${list.result}</td>
							</tr>
						</table>
						<hr width="880px" size="1" color="gray" align="center" />
						<input type="hidden" name="num" value="${list.num}" />
					</c:forEach>
				</c:if>
				<hr width="880px" size="1" align="center" />
				<br />
				<center>${pagingHtml}</center>
				<br />
				<br />
			</form>
		</center>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>
