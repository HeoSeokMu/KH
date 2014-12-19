<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<table width="900" border="0" cellspacing="0" cellpadding="0" bgcolor="#C9C9C9" >

	<tr align="center" height="30">
		<td width="13%"><font size="2"><b>학과</b></font></td>
		<td bgcolor="#F3F3F3" width="15%"><font size="2">${stu.stu_code}</font></td>
		<td width="13%"><font size="2"><b>학년</b></font></td>
		<td bgcolor="#F3F3F3" width="15%"><font size="2">${stu.stu_grade}</font></td>
		<td width="7%"><font size="2"><b>학번</b></font></td>
		<td bgcolor="#F3F3F3" width="15%"><font size="2">${stu.stu_num}</font></td>
		<td width="7%"><font size="2"><b>이름</b></font></td>
		<td bgcolor="#F3F3F3" width="15%"><font size="2">${stu.stu_name}</font></td>
	</tr>
							
	<tr bgcolor="#777777">
        <td height="1" colspan="8"></td>
   </tr>

	<tr align="center" height="30">
		<td><font size="2"><b>총 취득학점</b></font></td>
		<td bgcolor="#F3F3F3"><font size="2"><b>/140</b></font></td>
		<td><font size="2"><b>총 신청학점</b></font></td>
		<td bgcolor="#F3F3F3"><font size="2">${stu.hakjum_sum}<b>/23</b></font></td>
		<td><font size="2"><b>전공</b></font></td>
		<td bgcolor="#F3F3F3"><font size="2"><b></b></font></td>
		<td><font size="2"><b>교양</b></font></td>
		<td bgcolor="#F3F3F3"><font size="2"><b></b></font></td>
	</tr>
</table>

<br /><br />

<table width="900" border="0" cellspacing="0" cellpadding="0" bgcolor="#C9C9C9" >
	<tr bgcolor="#777777">
       <td height="2" colspan="8"></td>
    </tr>
</table>

<br />

							
<table width="900" border="0" cellspacing="0" cellpadding="0">
		<tr>
		<td align="center">
			<h3><b>수강신청 조회</b></h3>
		</td>
	</tr>	
</table>

<table width="900" border="0" cellspacing="0" cellpadding="0" bgcolor="#C9C9C9" >
	<tr bgcolor="#777777">
       <td height="2" colspan="8"></td>
    </tr>
    <tr height="30" bgcolor="white">
			<td colspan="8"><font size="2"><b>신청 과목 개수</b>
				<input type="text" readonly="readonly" style="width:50; text-align:center; font-size:large;" value="${stu.subject_sum}"/></font></td>
	</tr>
</table>

<table  width="900" border="0" cellspacing="0" cellpadding="0">
		<tr height="50">
			<td align="center" bgcolor="#C9C9C9" width="50"><font size="3"><b>구 분</b></font></td>
			<td align="center" bgcolor="#C9C9C9" width="150"><font size="3"><b>과 목</b></font></td>
			<td align="center" bgcolor="#C9C9C9" width=100><font size="3"><b>담당 교수</b></font></td>
			<td align="center" bgcolor="#C9C9C9" width="100"><font size="3"><b>강의실</b></font></td>
			<td align="center" bgcolor="#C9C9C9" width="50"><font size="3"><b>학 점</b></font></td>
			<td align="center" bgcolor="#C9C9C9" width=""><font size="3"><b>강의 시간</b></font></td>
			<td align="center" bgcolor="#C9C9C9" width=""><font size="3"><b>개 강</b></font></td>
			<td align="center" bgcolor="#C9C9C9" width=""><font size="3"><b>종 강</b></font></td>	
		</tr>
		
		<tr bgcolor="#777777">
      		 <td height="2" colspan="8"></td>
  	   </tr>
    
	<c:forEach var="list" items="${list}">
		<c:if test="${list.count%2 == 0}">
			<tr bgcolor="#F3F3F3" height="40">
		</c:if>
		
		<c:if test="${list.count%2 != 0}" >
			<tr height="40">
		</c:if>
			
			<td align="center" width="50">
				<c:if test="${list.l_type == '전 필'}">
			<font size="2" color="blue">
				</c:if>
				<c:if test="${list.l_type != '전 필'}">
			<font size="2">
				</c:if>
					${list.l_type}</font></td>
					
			<td align="center" width="150"><font size="2">${list.l_name}</font></td>
			<td align="center" width="100"><font size="2">${list.professor}</font></td>
			<td align="center" width="100"><font size="2">${list.l_room}</font></td>
			<td align="center" width="50"><font size="2">${list.f_grade}</font></td>
			<td align="center" width=""><font size="2">${list.l_day}요일 ( ${list.l_start}교시  부터  ${list.l_end}시간 )</font></td>
			<td align="center" width=""><font size="2">${list.s_date}</font></td>
			<td align="center" width=""><font size="2">${list.l_date}</font></td>	
		</tr>	
	<tr bgcolor="#777777">
       <td height="2" colspan="8"></td>
    </tr>
</c:forEach>

</table>
</div>
</div>