<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
				<%@include file="/main/header1.jsp" %>
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
	    		<c:if test="${memId != null}">
		    		<div id="tab_menu">					
						<%@include file="/main/tab_menu.jsp" %>
					</div>
				</c:if>
		   	</div>
		</div>
		 
		<div id="box3">
			<center>
			<form method="post" name="chartForm">
				<br/><br/>
				<h1>공지사항</h1>
				<table align="center" width="900" >
					<c:if test="${type == '교직원'}">
					<tr>
						<td align="right" colspan="4">
						<a href="#"><font size="4.5"><b>글쓰기</b></font></a>
						</td>
					</tr>
					</c:if>
					<tr>
						<td colspan="4">
						<hr width="880px" size="1" align="center" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
						<hr width="880px" size="1" align="center" />
						</td>
					</tr>
					
					<tr align="center">
						<td width="50px"><g>NO</g></td>
						<td width="150px"><g>제목</g></td>
						<td width="150px"><g>날짜</g></td>
						<td width="100px"><g>작성자</g></td>
					</tr>
				</table>
				<hr width="880px" size="3" color="#CC3D3D" align="center" />
		
				<c:if test="${totalCount < 1}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<table width="900">
						<tr>
							<td align="left">게시물이 존재하지 않습니다.</td>
						</tr>
					</table>
				</c:if>
			<table align="center">		
				<c:if test="${totalCount > 0}">
					<c:forEach var="list" items="${list}" varStatus="checkValue">
						
							<tr align="center" height="25px">
								<td width="50px">
									${(currentPage-1) * blockCount + (checkValue.index + 1)}
								</td>
								<td width="150px">
									<a href="#">${list.title}</a>
								</td>
								<td width="150px">
									${list.reg_date}
								</td>
								<td width="100px">
									${list.writer}
								</td>
							</tr>
				
							<tr>
								<td colspan="4">
								<hr width="880px" size="1" align="center" />
								</td>
							</tr>
							<tr>
								<td colspan="4">
								<hr width="880px" size="1" align="center" />
								</td>
							</tr>
						
					</c:forEach>
				</c:if>
				<c:if test="${type == '교직원'}">
					<tr>
						<td align="right" colspan="4">
						<a href="#"><font size="4.5"><b>글쓰기</b></font></a>
						</td>
					</tr>
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