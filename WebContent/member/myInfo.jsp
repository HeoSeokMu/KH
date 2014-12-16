<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>학적</title>
</head>
<body>
	<table align="center" border="1">
		<tr><td>학적기본정보</td></tr>
		<tr>
			<td width="130px" height="70px" align="center">
				<table border="1">
					<tr>
						<td>
							<img src="/KH_School/upload/mem_img/${mDTO.pro_img}" width="100%" height="50%"/>
						</td>
					</tr>
				</table>
			</td>
			<td colspan="5">
				<table border="1">
					<tr align="center">
						<td>학번&nbsp;</td><td width="170px">${mDTO.id}</td>
						<td>성명(국)&nbsp;</td><td width="170px">${mDTO.name}</td>
						<td>성별&nbsp;</td><td width="170px">${mDTO.sex}</td>
					</tr>
					<tr align="center">
						<td>이메일&nbsp;</td><td>${mDTO.email}</td>
						<td>학과&nbsp;</td><td>${mDTO.major}</td>
						<td>교육과정년도&nbsp;</td><td>${mDTO.birth_yy}</td>
					</tr>
					<tr align="center">
						<td>학적상태&nbsp;</td><td>${mDTO.status}</td>
						<td>학년&nbsp;</td><td>${mDTO.grade}</td>
						<td>이수학기&nbsp;</td><td>${mDTO.semester}</td>
					</tr>
				</table>
			</td>	
		</tr>
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
	</table>
</body>
</html>