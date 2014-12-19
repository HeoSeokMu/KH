<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</head>
<script type="text/javascript">
	function selectInform(form) {
		if(form.s_num.value.length==10){
			window.location="selectInform.kh?num="+form.s_num.value+"&book_id="+form.book_id.value+"&book_title="+form.book_title.value;
		}
		
	}
</script>
<jsp:include page="/member/sidebar.jsp" />
<div id="box3">
<body>
<br/>
	<form action="inputNumPro.kh" method="post" name="userinput">
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
					<input type="text" name="s_num" value="${s_num}" maxlength="10" onchange="return selectInform(this.form)"/>
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