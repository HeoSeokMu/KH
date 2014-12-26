<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>교적부</title>
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
<link rel="stylesheet" href="css/left_menu.css"></link>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/leftMenu_jquery.js"></script>

<script type="text/javascript">
	
</script>

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
		<center>
		<br/><br/>
			<form method="post" name="vacationForm">
				<h1>휴가 신청 내역</h1>
				<hr width="1000px" size="1" color="gray" align="center" />
				<hr width="1000px" size="1" align="center" />
				<table align="center">
					<tr align="center">
						<td width="50px"><g>등록번호</g></td>
						<td width="100px"><g>이름</g></td>
						<td width="50px"><g>성별</g></td>
						<td width="150px"><g>전공(소속)</g></td>
						<td width="100px"><g>상태</g></td>
						<td width="150px"><g>메일</g></td>
						<td width="150px"><g>연락처</g></td>
						<td width="100px"><g>입학구분</g></td>
						<td width="100px"><g>등록일자</g></td>
					</tr>
				</table>
				<hr width="1000px" size="3" color="#CC3D3D" align="center" />

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
							<tr align="center" height="25px" style="cursor:pointer;" onclick="window.location='vacationView.kh?no=${list.no}'">
								<td width="50px">${(currentPage-1) * blockCount + (checkValue.index + 1)}
								</td>
								<td width="100px">${list.type}</td>
								<td width="100px">${list.major}</td>
								<td width="150px">${list.name}</td>
								<td width="250px">${list.vacStart_yy}년 ${list.vacStart_mm}월 ${list.vacStart_dd}일
								 ~ ${list.vacEnd_yy}년 ${list.vacEnd_mm}월 ${list.vacEnd_dd}일</td>
								<td width="100px">
									<fmt:formatDate value="${list.reg_date}" type="date" pattern="yy-MM-dd" var="writeDate"/>
									<c:if test="${writeDate == toDate}">
										<fmt:formatDate value="${list.reg_date}" type="date" pattern="HH시 mm분"/>
									</c:if>
									<c:if test="${writeDate != toDate}">
										<fmt:formatDate value="${list.reg_date}" type="date" pattern="yy년 MM월 dd일"/>
									</c:if>
								</td>
								
								<td width="100px">${list.result}</td>
								
							</tr>
						</table>
						<hr width="1000px" size="1" color="gray" align="center" />
					</c:forEach>
				</c:if>
				<hr width="1000px" size="1" align="center" />
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