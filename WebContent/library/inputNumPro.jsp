<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<table>	
			<tr>
				<td>
					å��ȣ
				</td>
				<td>
					${dto.b_num}
				</td>
				<td>
					å����
				</td>
				<td>
					${b_name}
				</td>
			</tr>
			<tr>
				<td>
					�й�
				</td>
				<td>
					${dto.s_num}
				</td>
				<td>
					�̸�
				</td>
				<td>
					${s_name}
				</td>
			</tr>
			<tr>
				<td>
					��ȭ��ȣ
				</td>
				<td colspan="3">
					${s_phone}
				</td>
			</tr>
			<tr>
				<td>
					�ݳ���¥
				</td>
				<td>
					<fmt:formatDate value="${tDate}" pattern="yyyy�� MM�� dd�� hh��" />
				</td>
			</tr>
		</table>
			<br/>
			<input type="button" class="next" value="������ Ȩ" onclick="javascript:window.location='test.kh'"/>
</body>
</html>