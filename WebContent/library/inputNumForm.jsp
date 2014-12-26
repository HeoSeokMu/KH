<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
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

<script type="text/javascript">
	function selectInform(form) {
		if(form.s_num.value.length==10){
			form.id_check.value = "check";
			window.location="selectInform.kh?num="+form.s_num.value+"&book_id="+form.book_id.value+"&book_title="+form.book_title.value+"&id_check="+form.id_check.value;
		}else{
			alert("학번을 정확하게 입력하여주세요");
		}
	}
	
	function idcheck() {
		if(document.userinput.id_check.value == "check") {
			document.userinput.id_check.value = "no";
		}
	}
	
	function allCheck() {
		if(document.userinput.id_check.value != "check") {
			alert(document.userinput.id_check.value);
			return false;
		}
	}
	
	if("${check}"=="check"){
		alert("해당 아이디는 없습니다.");
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
<br/>
	<form action="inputNumPro.kh" method="post" name="userinput" onsubmit="return allCheck()">
		<table>	
			<tr>
				<td>
					책번호
				</td>
				<td>
					<input type="text" name="book_id" value="${book_id}" readonly="readonly"/>
				</td>
				<td>
					책제목
				</td>
				<td>
					<input type="text" name="book_title" value="${book_title}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					학번
				</td>
				<td>
					<input type="text" name="s_num" value="${s_num}" maxlength="10" onkeydown="idcheck()"/>
					<input type="text" name="id_check" value="${id_check}"/>
					<input type="button" value="입력" onclick="return selectInform(this.form)"/>
				</td>
				<td>
					이름
				</td>
				<td>
					<input type="text" name="s_name" value="${s_name}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					전화번호
				</td>
				<td colspan="3">
					<input type="text" name="s_phone" value="${s_phone}" readonly="readonly"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="대여완료"/>
	</form>
	<br/>
	</div>
	<div id="box4"><center><br /><br /></center></div>
</body>
</html>