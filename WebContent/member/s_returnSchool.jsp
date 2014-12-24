<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>복학 신청 페이지</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
</head>

<body>
	<jsp:include page="/main/s_sidebar.jsp" />
		<div id="box3">
			<center>
			<form action="RestReturnRequestInsert.kh" method="post">
				<br/>
				<h2>복학신청서</h2>
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
						<td align="left">위와 같이 복학을 신청합니다.</td>
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
				<input type="hidden" name="board_type" value="복학"/>
			</form>
			</center>
			<br/><br/>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>