<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>공지사항</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
		
	<script src="/KH_School/member/script/noticeView.js"></script>
	
	<script type="text/javascript">
		function Processing(processing, num, id, board_type, value) {
			alert("Pro");
			alert("result : " + result + " / " + value);
			if(value == "승인" || value == "거절") {
				window.location = "RestReturn_Pro.kh?board_type="+board_type+"&num="+num+"&id="+id+"&result="+value;	
			}
		}
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
			<form name="chartForm">
				<br/><br/>
				<h2>휴학신청서</h2>
				<br/>
				<table width="700">
					<tr>
						<td>
							<table border="1" width="700">
								<tr>
									<td colspan="2" width="20%" bgcolor="#ffff99" align="center">학   과</td><td colspan="2" width="20%" align="center">${rrb_DTO.major}</td>
									<td colspan="2" width="20%" bgcolor="#ffff99" align="center">성   명</td><td colspan="2" width="20%" align="center">${rrb_DTO.name}</td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#ffff99" align="center">학   번</td><td colspan="2" align="center">${rrb_DTO.id}</td>
									<td colspan="2" bgcolor="#ffff99" align="center">학   년</td><td colspan="2" align="center">${rrb_DTO.grade}</td>
								</tr>
								<tr>
									<td rowspan="2" width="10%" bgcolor="#ffff99" align="center">연락처</td><td bgcolor="#ffff99" align="center">E-mail</td><td colspan="5" align="center">${rrb_DTO.email}</td>
								</tr>
								<tr>
									<td bgcolor="#ffff99" align="center">휴대폰</td><td colspan="5" align="center">${rrb_DTO.phone}</td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#ffff99" align="center">주   소</td><td colspan="5" align="center">${rrb_DTO.addr}</td>
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
									<td align="center" colspan="3">${rrb_DTO.time}</td>
									<td align="center" colspan="4">${rrb_DTO.why}</td>
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
									<td colspan="8">${rrb_DTO.why_detail}</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td><br/></td>
					</tr>
					<c:if test="${rrrb_check == '신청'}">
					<tr>
						<td align="center">
							<input type="button" name="result" value="승인" onclick="Processing(this.form, ${rrb_DTO.num}, ${rrb_DTO.id},휴학, this.value);"/>
							&nbsp;&nbsp;
							<input type="button" name="result" value="거절" onclick="Processing(this.form, ${rrb_DTO.num}, ${rrb_DTO.id},, this.value););"/>
						</td>
					</tr>
					</c:if>
				</table>
			</form>
			</center>
			<br/><br/>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>