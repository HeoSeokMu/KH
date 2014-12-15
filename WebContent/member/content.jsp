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
		
		function modify(){
			document.chartForm.action = "modifyNotice_board.kh";
			document.chartForm.submit();
		}
		
		function modifyGo(){
			document.chartForm.action = "modifyNotice_boardPro.kh";
			document.chartForm.submit();
		}
		
		function del(){
			if(confirm("해당 게시글을 정말 삭제하시겠습니까?")){
			document.chartForm.action = "delNotice_board.kh";
			document.chartForm.submit();
			}
		}
			 
/* 		function where(select){
				  
				 var xmlhttp;
				  
				  if (window.XMLHttpRequest) {  
				   xmlhttp = new XMLHttpRequest(); //  IE7+, Firefox, Chrome, Opera, Safari
				  } else {    
				   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");  // IE6, IE5 
				  }
				  
				  xmlhttp.onreadystatechange = function() {
				   if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				    document.getElementById("").innerHTML = xmlhttp.responseText;
				    
				   }
				  };
				  
				  if (select == "") {
					   xmlhttp.open("GET", ".kh", true);
					  }
				  if (select == "") {
					   xmlhttp.open("GET", ".kh", true);
					  }
					  
					  xmlhttp.send();
		
			 }  */
			 
			 
	</script>
</head>

<body onload="focusIt();">
<jsp:include page="/member/sidebar.jsp" />
		 
		<div id="box3">
			<center>
			<form method="post" name="chartForm" action="writeNotice_boardPro.kh">
				<br/><br/>
				<h1>게시글</h1>
				<br />
				
				<table width="700" align="center">
					<tr>
						<td align="right">
							<c:if test="${type == '교직원'}">
									<c:if test="${not empty article}">
										<input type="button" value="수정하기" onclick="modify();"></input>
										<input type="button" value="삭제" onclick="del();"></input>
									</c:if>
							</c:if>
							<input type="button" value="목록보기" onclick="window.location='notice_board.kh'"></input>
						</td>
					</tr>
				</table>
				
				<table width="700" align="center" border="1" cellspacing="3">
				
				<c:if test="${not empty article.writer}">
					<input type="hidden" name="writer" value="${article.writer}"></input>
				</c:if>
				<c:if test="${empty article.writer}">
					<input type="hidden" name="writer" value="${name}"></input>
				</c:if>
				<c:if test="${not empty article.num}">
					<input type="hidden" name="num" value="${article.num}"></input>
				</c:if>
				<c:if test="${not empty article.title}">
					<input type="hidden" name="title" value="${article.title}"></input>
				</c:if>
				<c:if test="${not empty article.content}">
					<input type="hidden" name="content" value="${article.content}"></input>
				</c:if>
				
				
					<tr align="center">
						<c:if test="${not empty num}">
							<td width="50px"><g>No</g></td><td width="50px" colspan="2">${num}</td>
						</c:if>
							<td width="50px" colspan="2"><g>작성자</g></td>
						<c:if test="${not empty article.writer}">
							<td width="150px">${article.writer}</td>
						</c:if>
						<c:if test="${empty article.writer}">
							<td width="150px">${name}</td>
						</c:if>
						<c:if test="${not empty article.reg_date}">
							<td width="50px"><g>날짜</g></td><td width="150px">
								<fmt:formatDate value="${article.reg_date}" type="date" pattern="MM월 dd일 HH시 mm분"/>
							</td>
						</c:if>
					</tr>
					<tr>
						<td width="50px" align="center"><g>제목</g></td>
						<td width="150px" colspan="7">
						
						<c:if test="${empty article.title}">
							<c:if test="${not empty title}">
								<input type="text" name="title" value="${title}" style="width:620px"></input>
							</c:if>
						</c:if>
						
						<c:if test="${empty article.title}">
							<c:if test="${empty title}">
								<input type="text" name="title" style="width:620px"></input>
							</c:if>
						</c:if>
						
						<c:if test="${not empty article.title}">
							&nbsp;&nbsp;${article.title}
						</c:if>
						
						</td>
					</tr>
					<tr>
						<td width="50px" align="center"><g>내용</g></td>
						<td width="150px" height="500px" colspan="7">
						
						<c:if test="${empty article.content}">
							<textarea name="content" rows="20" cols="85">${content}</textarea>
						</c:if>
						
						<c:if test="${not empty article.content}">
							&nbsp;&nbsp;${article.content}
						</c:if>
						
						</td>
					</tr>
					
					<c:if test="${empty article}">
						<c:if test="${empty num}">
							<tr>
								<td width="50px" align="center" colspan="6"><input type="submit" value="작성"></input></td>
							</tr>
						</c:if>
					</c:if>
					
					<c:if test="${empty article}">
						<c:if test="${not empty num}">
							<tr>
								<td width="50px" align="center" colspan="6"><input type="button" value="수정" onclick="modifyGo();">
								</input></td>
							</tr>
						</c:if>
					</c:if>
				</table>
				
				<c:if test="${totalCount < 1}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<table>
						<tr>
							<td align="left">게시물이 존재하지 않습니다.</td>
						</tr>
					</table>
				</c:if>
		
				<c:if test="${totalCount > 0}">
					<c:forEach var="list" items="${list}" varStatus="checkValue">
						<table align="center">
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
						</table>
						<hr width="880px" size="1" color="gray" align="center" />
					</c:forEach>
					<hr width="880px" size="1" align="center" />
				</c:if>
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