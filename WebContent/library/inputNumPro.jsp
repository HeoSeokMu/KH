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
					책번호
				</td>
				<td>
					${dto.book_id}
				</td>
				<td>
					책제목
				</td>
				<td>
					${dto.book_title}
				</td>
			</tr>
			<tr>
				<td>
					학번
				</td>
				<td>
					${dto.s_num}
				</td>
				<td>
					이름
				</td>
				<td>
					${s_name}
				</td>
			</tr>
			<tr>
				<td>
					전화번호
				</td>
				<td colspan="3">
					${s_phone}
				</td>
			</tr>
			<tr>
				<td>
					반납날짜
				</td>
				<td>
					<fmt:formatDate value="${dto.turnin}" pattern="yyyy년 MM월 dd일" />
				</td>
			</tr>
		</table>
			<br/>
			<input type="button" class="next" value="도서관 홈" onclick="javascript:window.location='bookList.kh'"/>
</body>
</html>