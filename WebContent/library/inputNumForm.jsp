<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function selectInform(form) {
		if(form.s_num.value.length==10){
			window.location="selectInform.kh?num="+form.s_num.value+"&book_id="+form.book_id.value+"&book_title="+form.book_title.value;
		}
		
	}
</script>

<body>
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
</body>
</html>