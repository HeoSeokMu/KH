<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>학적</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
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
		<br/><br/>
		<form action="myInfo_Edit.kh" method="post">
		<table align="center">
			<tr>
				<td>
					<c:if test="${type == '학생'}">학적</c:if>
					<c:if test="${type == '교수'}">교수</c:if>
					<c:if test="${type == '교직원'}">직원</c:if>
					기본정보
				</td>
				</tr>
			<tr>
				<td width="130px" height="70px" align="center">
					<table border="1">
						<tr>
							<td>
								<img src="/KH_School/upload/mem_img/${mDTO.pro_img}" width="150px" height="150px"/>
							</td>
						</tr>
					</table>
				</td>
				<td colspan="5">
					<table border="1">
						<tr align="center">
							<td>
								<c:if test="${type == '교직원' || type == '교수'}">교번</c:if>
								<c:if test="${type == '학생'}">학번</c:if>
								&nbsp;</td><td width="170px">${mDTO.id}
								<input name="id" type="hidden" value="${mDTO.id}"/>
							</td>
							<td>성명(국)&nbsp;</td><td width="170px">${mDTO.name}</td>
							<td>성별&nbsp;</td><td width="170px">${mDTO.sex}</td>
						</tr>
						<tr align="center">
							<td>이메일&nbsp;</td><td><input type="text" name="email" value="${mDTO.email}"/></td>
							<td>
								<c:if test="${type == '학생' || type == '교수'}">학과</c:if>
								<c:if test="${type == '교직원'}">근무부서</c:if>
								&nbsp;</td><td>${mDTO.major}</td>
							<td>
								<c:if test="${type == '교수' || type == '교직원'}">	재직</c:if>
								<c:if test="${type == '학생'}">교육과정</c:if>
								년도
							</td><td>${mDTO.birth_yy}</td>
						</tr>
						<tr align="center">
							<c:if test="${type == '교직원' || type == '교수'}">
								<td>재적상태&nbsp;</td><td>${mDTO.status}</td>
							</c:if>
							<c:if test="${type == '학생'}">
								<td>학적상태&nbsp;</td><td>${mDTO.status}</td>
							<td>학년&nbsp;</td><td>${mDTO.grade}</td>
							<td>이수학기&nbsp;</td><td>${mDTO.semester}</td>
							</c:if>
						</tr>
						<tr align="center">
							<td>연락처&nbsp;</td><td><input type="text" name="s_phone" value="${mDTO.s_phone}"/></td>
						</tr>
					</table>
				</td>	
			</tr>
			<c:if test="${type == '학생'}">
			<tr><td height="30px"></td></tr>
			<tr><td>신상정보</td></tr>
			<tr>
				<td colspan="5">
					<table border="1">
						<tr align="center">
							<td width="123px">보호자 이름&nbsp;</td><td width="170px">${mDTO.name}</td>
							<td width="123px">보호자 연락처&nbsp;</td><td width="173px">${mDTO.p_phone}</td>
							<td width="123px">보호자 직업&nbsp;</td><td width="170px"></td>
						</tr>
						<tr align="center">
							<td>보호자 우편번호&nbsp;</td><td>${mDTO.post}</td>
							<td>보호자 주소&nbsp;</td><td colspan="3">${mDTO.addr}</td>
						</tr>
						<tr align="center">
							<td>학생 우편번호&nbsp;</td><td>${mDTO.post}</td>
							<td>학생 주소&nbsp;</td><td colspan="3">${mDTO.addr}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr><td height="30px"></td></tr>
			<tr><td>출신고등학교</td></tr>
			<tr>
				<td colspan="5">
					<table border="1">
						<tr align="center">
							<td width="123px">출신고교&nbsp;</td><td width="170px">${mDTO.before_school}</td>
							<td width="123px">입학구분&nbsp;</td><td width="170px">${mDTO.enter_way}</td>
						</tr>
					</table>
				</td>
			</tr>
			</c:if>
		</table>
		<br/>
		<center>
			<input type="submit" value="정보 수정하기"/>
		</center>
		</form>
		<br/><br/>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>