<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>KH 통합정보시스템</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
		
</head>

<body>
	<jsp:include page="/main/s_sidebar.jsp" />
		<div id="box3">
			<c:if test="${memId == null}">
				<form name="inform" method="post" action="LoginPro.kh"	onsubmit="return checkIt();">
					<table class="tablepadding" align="center" cellspacing="10">
						<tr>
							<td colspan="2">
								<input type="radio" name="type" value="학생" checked/> 학생
								&nbsp;&nbsp;<input type="radio" name="type" value="교수"/> 교수
								&nbsp;&nbsp;<input type="radio" name="type" value="교직원"/> 교직원
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" name="id" class="input" placeholder="아이디" maxlength="10"/>
							</td>
							<td rowspan="2">
								<input type="submit" class="login" name="Submit" value="로그인"/>
							</td>
						</tr>
						<tr>
							<td>
								<input type="password" name="passwd" placeholder="패스워드" class="input" maxlength="10"/>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="lineX">
								<font style="font-size: 8pt">
								&nbsp;<a href="findIdForm.action" title="아이디/비밀번호 찾기" style="color: gray;">아이디/비밀번호 찾기</a>
								</font>
							</td>
						</tr>
					</table>
				</form>
			</c:if>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>


