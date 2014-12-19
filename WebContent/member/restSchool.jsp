<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>휴학 신청 페이지</title>
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
			<center>
			<form action="restInsert.kh" method="post">
				<br/><br/>
				<h2>휴학신청서</h2>
				<table width="700">
					<tr>
						<td>
							<table border="1" width="700">
								<tr>
									<td colspan="2" width="20%" bgcolor="#ffff99" align="center">학   과</td><td colspan="2" width="20%" align="center">${mDTO.major}</td>
									<td colspan="2" width="20%" bgcolor="#ffff99" align="center">성   명</td><td colspan="2" width="20%" align="center">${mDTO.name}</td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#ffff99" align="center">학   번</td><td colspan="2" align="center">${mDTO.id}</td>
									<td colspan="2" bgcolor="#ffff99" align="center">학   년</td><td colspan="2" align="center">${mDTO.grade}</td>
								</tr>
								<tr>
									<td rowspan="2" width="10%" bgcolor="#ffff99" align="center">연락처</td><td bgcolor="#ffff99" align="center">E-mail</td><td colspan="5" align="center">${mDTO.email}</td>
								</tr>
								<tr>
									<td bgcolor="#ffff99" align="center">휴대폰</td><td colspan="5" align="center">${mDTO.s_phone}</td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#ffff99" align="center">주   소</td><td colspan="5" align="center">${mDTO.addr}</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="30"></td>
					</tr>
					<tr>
						<td>
							<table width="700" border="1">
								<tr>
									<td colspan="7" bgcolor="#ffff99" align="center">휴학종류</td>
								</tr>
								<tr>
									<td colspan="3" bgcolor="#ffff99" width="50%" align="center">시  기</td>
									<td colspan="4" bgcolor="#ffff99" width="50%" align="center">사  유</td>
								</tr>
								<tr>
									<td bgcolor="#ffff99" align="center">등록 휴학</td><td bgcolor="#ffff99" align="center">중도 휴학</td>
									<td bgcolor="#ffff99" align="center">미등록 휴학</td><td bgcolor="#ffff99" align="center">군입대</td>
									<td bgcolor="#ffff99" align="center">학 비</td><td bgcolor="#ffff99" align="center">유 학</td><td bgcolor="#ffff99" align="center">기 타</td>
								</tr>
								<tr>
									<td align="center"><input type="radio" name="time" value="register"/></td>
									<td align="center"><input type="radio" name="time" value="stop"/></td>
									<td align="center"><input type="radio" name="time" value="non_register"/></td>
									<td align="center"><input type="radio" name="why" value="army"/></td>
									<td align="center"><input type="radio" name="why" value="tuition"/></td>
									<td align="center"><input type="radio" name="why" value="abroad"/></td>
									<td align="center"><input type="radio" name="why" value="etc"/></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="30"></td>
					</tr>
					<tr>
						<td>
							<table border="1" width="700">
								<tr>
									<td colspan="8" width="100%" bgcolor="#ffff99" align="center">사 유(구체적으로)</td>
								</tr>
								<tr>
									<td colspan="8"><textarea rows="10" cols="95" name="why_detail"></textarea></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td align="left">위와 같이 휴학을 신청합니다.</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td align="center"><input type="submit" value="신청하기"/></td>
					</tr>					
				</table>
				<input type="hidden" name="major" value="${mDTO.major}"/>
				<input type="hidden" name="name" value="${mDTO.name}"/>
				<input type="hidden" name="id" value="${mDTO.id}"/>
				<input type="hidden" name="grade" value="${mDTO.grade}"/>
				<input type="hidden" name="email" value="${mDTO.email}"/>
				<input type="hidden" name="phone" value="${mDTO.s_phone}"/>
				<input type="hidden" name="addr" value="${mDTO.addr}"/>
			</form>
			</center>
			<br/><br/>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>