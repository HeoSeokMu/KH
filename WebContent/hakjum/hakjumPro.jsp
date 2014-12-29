<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form action="hakjumInsert.kh" method="post" name="">
<table border="1" cellspacing="0" cellpadding="3" bordercolor="gray" width="500">
		<tr>
			<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>학 번</b></font></td>
			<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>학 년</b></font></td>	
			<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>이 름</b></font></td>	
			<td bgcolor="#b1b1b1" align="center"><font size="2"><b></b></font></td>
			<td bgcolor="#b1b1b1" align="center"><font size="2"><b></b></font></td>
		</tr>
	<c:forEach var="list" items="${list}">
		<tr>		
			<td align="center" width="150"><input type="hidden" name="num" value="${list.num}"/>${list.s_code }</td>
			<td align="center" width="50">${list.s_grade }</td>	
			<td align="center" width="100">${list.s_name }</td>
			
			<c:if test="${list.resultA != 0 }">
				<td align="center"><input type="text" style="width:80; text-align: center; font-size: large;" name="A${list.num}" onchange="result('${list.num}')" value="${list.resultA }"></td>
				<td align="center"><input type="text" readonly="readonly" style="width:80; text-align: center; font-size: large;" name="B${list.num}" value="${list.resultB }"></td>
			</c:if>
			
			<c:if test="${list.resultA == 0 }">
				<td align="center"><input type="text" style="width:80; text-align: center; font-size: large;" name="A${list.num}" onchange="result('${list.num}')"></td>
				<td align="center"><input type="text" readonly="readonly" style="width:80; text-align: center; font-size: large;" name="B${list.num}"></td>
			</c:if>
		</tr><br/>	
	</c:forEach> 
				
</table>

<br/>

<table border="1" cellspacing="0" cellpadding="3" bordercolor="gray" width="500">
	<tr>
		<td align="center">
			<input type="submit" value="성적 처리 하기"/>
		</td>
	</tr>
	
</table>

</form>