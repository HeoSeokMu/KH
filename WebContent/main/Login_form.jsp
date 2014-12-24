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
	
	<script language="javascript">
		function focusIt() {
			alert("${check}");
			if("${check}"== 2){
				alert("아이디 또는 패스워드가 틀렸습니다.");
			}else if("${check}" == 3){
				alert("입력하신 아이디는 존재하지 않습니다.");
			}
		}
		
		function checkIt() {
			inputForm = eval("document.inform");
			if (!inputForm.id.value) {
				alert("아이디를 입력하세요..");
				inputForm.id.focus();
				return false;
			}
			if (!inputForm.passwd.value) {
				alert("패스워드를 입력하세요..");
				inputForm.passwd.focus();
				return false;
			}
			return ture;
		}
		
		function login_check(check) {
			if(check == -1) {
				alert("입력하신 아이디는 존재하지 않습니다.");
			} else if(check == 0) {
				alert("아이디 or 비밀번호를 틀리셨습니다.");
			}
		}
	</script>
</head>

<body onload="focusIt();">
<div id="box">
		<div id="header">
			<div id="header_1">
				
			</div>
			<div id="header_2">
				<center>
					<c:if test="${memId != null}">
						${memId} 님 어서오세요 ~~~ 
					
						<form name="logout" method="post" action="LoginOut.kh">
							<input type="submit" name="logout" value="로그아웃"/>
						</form>
					</c:if>
				</center>
			</div>
		</div>
	</div>

	<div id="box">
		<div id="box2">
			<div id="content">
			</div>	
		</div>		 
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
								<a href="joinForm.kh" title="회원가입" style="color: gray;">회원가입</a>
								&nbsp;&nbsp;<a href="findIdForm.action" title="아이디/비밀번호 찾기" style="color: gray;">아이디/비밀번호 찾기</a>
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


