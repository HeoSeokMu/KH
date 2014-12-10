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
	<table border="1">
		<tr>
			<td rowspan="2" width="150px" height="150px"><img src="${mDTO.pro_img}"/></td>
			<td>학번&nbsp;</td><td width="150px">${mDTO.id}</td>
			<td>성명(국)&nbsp;</td><td width="150px">${mDTO.name}</td>
			<td>성별&nbsp;</td><td width="150px">${mDTO.sex}</td>
		</tr>
		<tr>
			<td>이메일&nbsp;</td><td><input type="text" value="${mDTO.e_mail}"></input></td>
			<td>학과&nbsp;</td><td><input type="text" value="${mDTO.major}"></input></td>
			<td>교육과정년도&nbsp;</td><td width="150px">${mDTO.birth_yy}</td>
		</tr>
		<tr>
			<td>이메일&nbsp;</td><td><input type="text" value="${mDTO.e_mail}"></input></td>
			<td>학과&nbsp;</td><td><input type="text" value="${mDTO.major}"></input></td>
			<td>교육과정년도&nbsp;</td><td width="150px">${mDTO.birth_yy}</td>
		</tr>
	</table>
</body>
</html>