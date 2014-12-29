<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:forEach var="list" items="${list}">
	db_seq : ${list.num } <br/>
	구분 : ${list.type } <br/>
	과목 코드 : ${list.code } <br/>
	과목 : ${list.name } <br/>
	교수  : ${list.professor } <br/>
	교수 코드 : ${list.p_code } <br/>
	학년 : ${list.s_grade } <br/>
	수강생 : ${list.s_name } <br/>
	수강생 학번 : ${list.s_code } <br/>
	학점 : ${list.f_grade } <br/>
	결과 A : ${list.resultA } <br/>
	결과 B : ${list.resultB }<br/>
	수강 이수 여부 : ${list.chk } <br/>
	
---------------------------------------------------- <br/>
	
</c:forEach> --%>
<c:forEach var="list" items="${list}">
<table border="1" cellspacing="0" cellpadding="3" bordercolor="gray" >
	<tr>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>구 분</b></font></td>
		<td align="center" width="80">${list.type }</td>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>과 목</b></font></td>
		<td align="center" width="130"> ${list.name }</td>
		<td bgcolor="#b1b1b1" align="center"  width="130"><font size="2"><b>담당 교수</b></font></td>
		<td align="center"  width="100">${list.professor }</td>
	</tr>
</table>

<table border="1" cellspacing="0" cellpadding="3" bordercolor="gray" >

	<tr>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>학 번</b></font></td>
		<td align="center" width="150">${list.s_code }</td>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>학 년</b></font></td>
		<td align="center" width="50">${list.s_grade }</td>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>이 름</b></font></td>
		<td align="center" width="100">${list.s_name }</td>
		<td bgcolor="#b1b1b1" align="center"><font size="2"><b>A</b></font></td>
		<td><input type="text" style="width:80; text-align: center; font-size: large;" name="resultA"></td>
		<td><input type="checkbox" name="chk" value="${list.num }"></td>
		<td bgcolor="#b1b1b1" align="center"><font size="2"><b>B</b></font></td>
		<td><input type="text" style="width:80; text-align: center; font-size: large;" name="resultB"></td>
	</tr>

</table>

<br/>

</c:forEach>









