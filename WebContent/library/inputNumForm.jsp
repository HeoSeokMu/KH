<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function selectInform(form) {
		alert(form.s_num.value.length);
	}
</script>

<body>
	<form action="inputNumPro.kh" method="post" name="userinput">
		<table>	
			<tr>
				<td>
					å��ȣ
				</td>
				<td>
					<input type="text" name="book_id" value="${book_id}" readonly="readonly"/>
				</td>
				<td>
					å����
				</td>
				<td>
					<input type="text" name="book_title" value="${book_title}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					�й�
				</td>
				<td>
					<input type="text" name="s_num" onchange="return selectInform(this.form)"/>
				</td>
				<td>
					�̸�
				</td>
				<td>
					<input type="text" name="s_name" value="${s_name}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					��ȭ��ȣ
				</td>
				<td colspan="3">
					<input type="text" name="s_phone" value="${s_phone}" readonly="readonly"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="�뿩�Ϸ�"/>
	</form>
</body>
</html>