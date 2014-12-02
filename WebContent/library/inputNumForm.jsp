<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="inputNumPro.kh" method="post" name="userinput" onsubmit="return checkit()">
		<table>	
			<tr>
				<td>
					책번호
				</td>
				<td>
					<input type="text" name="b_num" value="${b_num}" readonly="readonly"/>
				</td>
				<td>
					책제목
				</td>
				<td>
					<input type="text" name="b_name" value="${b_name}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					학번
				</td>
				<td>
					<input type="text" name="s_num" onkeydown="return selectUser()"/>
				</td>
				<td>
					이름
				</td>
				<td>
					<input type="text" name="s_name" value="${s_name}" />
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