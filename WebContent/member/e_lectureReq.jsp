<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>강의개설 신청</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
</head>

<body>
	<jsp:include page="/main/e_sidebar.jsp" />
		<div id="box3">
			<center>
			<form method="post" name="chartForm">
			<fmt:formatDate value="<%=new java.util.Date()%>" var="toDate" pattern="yy-MM-dd" />
			
				<br/><br/>
				<h1>강의개설 신청</h1>
				<table align="center" width="900" >
					<tr>
						<td colspan="5">
						<hr width="880px" size="1" align="center" />
						</td>
					</tr>
					<tr>
						<td colspan="5">
						<hr width="880px" size="1" align="center" />
						</td>
					</tr>
					
					<tr align="center">
						<td width="50px"><g>NO</g></td>
						<td width="350px"><g>강의명</g></td>
						<td width="100px"><g>담당 교수</g></td>
						<td width="100px"><g>날짜</g></td>
						<td width="100px"><g>처리여부</g></td>
					</tr>
				</table>
				<hr width="880px" size="3" color="#CC3D3D" align="center" />
		
				<c:if test="${totalCount < 1}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<table width="900" align="center">
						<tr>
							<td align="center">게시물이 존재하지 않습니다.</td>
						</tr>
						<tr>
							<td align="center"><br /><hr color="gray"></hr></td>
						</tr>
					</table>
				</c:if>
			<table align="center" width="900">		
				<c:if test="${totalCount > 0}">
					<c:forEach var="list" items="${list}" varStatus="checkValue">
						
							<tr align="center" height="25px">
								<td width="50px">
									${totalCount - ((currentPage-1) * blockCount + (checkValue.index + 1)) + 1}
								</td>
								<td width="50px">
									${list.writer}
								</td>
								<td width="250px">
									<a href="notice_boardView.kh?currentPage=${currentPage}&num=${list.num}">${list.title}</a>
								</td>
								<td width="50px">
									<fmt:formatDate value="${list.reg_date}" type="date" pattern="yy-MM-dd" var="writeDate"/>
										<c:if test="${writeDate == toDate}">
											<fmt:formatDate value="${list.reg_date}" type="date" pattern="HH시 mm분"/>
										</c:if>
										<c:if test="${writeDate != toDate}">
											<fmt:formatDate value="${list.reg_date}" type="date" pattern="yy년 MM월 dd일"/>
										</c:if>
								</td>
							</tr>
				
							<tr>
								<td colspan="5">
								<hr width="880px" size="1" align="center" />
								</td>
							</tr>
							<tr>
								<td colspan="5">
								<hr width="880px" size="1" align="center" />
								</td>
							</tr>
					</c:forEach>
				</c:if>
			</table>
				<br/>
				<center>
					${pagingHtml}
				</center>
				<br/><br/>
			</form>
			</center>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>