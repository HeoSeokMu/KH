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
			<form>
				<br/><br/>
				<h2>복학신청서</h2>
				<table width="700">
					<tr>
						<td>
							<table border="1" width="700">
								<tr>
									<td colspan="2" width="20%" bgcolor="#ffff99" align="center">학   과</td><td colspan="2" width="20%"></td>
									<td colspan="2" width="20%" bgcolor="#ffff99" align="center">성   명</td><td colspan="2" width="20%"></td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#ffff99" align="center">학   번</td><td colspan="2"></td>
									<td colspan="2" bgcolor="#ffff99" align="center">학   년</td><td colspan="2"></td>
								</tr>
								<tr>
									<td rowspan="2" width="10%" bgcolor="#ffff99" align="center">연락처</td><td bgcolor="#ffff99" align="center">일   반</td><td colspan="5"></td>
								</tr>
								<tr>
									<td bgcolor="#ffff99" align="center">휴대폰</td><td colspan="5"></td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#ffff99" align="center">주   소</td><td colspan="5"></td>
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
			</form>
			</center>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>