<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
<tr><td>
  	<c:forEach var="sugangList" items="${sugangList}">   
	            									 <!--     수강 할 과목  리스트               -->            
		<c:if test="${sugangList.count%2 == 0}">
			<table width="480" border="1" bordercolor="gray" cellpadding="3" cellspacing="0"  id="${sugangList.count}" >
		</c:if>
		
		<c:if test="${sugangList.count%2 != 0}">
			<table width="480" border="1" bordercolor="gray" cellpadding="3" cellspacing="0"  id="${sugangList.count}" bgcolor="#E7E7E7">
		</c:if>

		
		<tr>
			<td align="center" rowspan="2" width="50" bgcolor="#b1b1b1" id="Abutton${sugangList.count}">
				<input type="button" value="신청" onclick="ok('${sugangList.count}')"/>
				<input type="hidden" name="l_code" value="${sugangList.l_code}"/>	
			</td>
			
	<!-- ------------------    -->
	
			<c:if test="${chk == 0 }">
				<td align="center" rowspan="2" width="50" bgcolor="#b1b1b1" id="Bbutton${sugangList.count}">
					<font size="2" color="red"><b>신청 불가</b></font>
				</td>
			</c:if>
			
			<c:if test="${chk == 1 }">
				<td align="center" rowspan="2" width="50" bgcolor="#b1b1b1" id="Bbutton${sugangList.count}">
					<font size="2" color="blue"><b>신청 됨</b></font>
				</td>
			</c:if>
				
	<!-- ------------------    -->		
				
				<td align="center" width="100">
				
				<c:if test="${sugangList.l_type == '전 필'}">
					<font color="blue"><b>
				</c:if>
					
					<font size="2">${sugangList.l_type}</font></b></font>
					<input type="hidden" name="subjectlist" value="${sugangList.l_type}"/>
					<input type="hidden" name="tablename" value="${sugangList.m_code}"/>
				</td>
				<td align="center" width="120"><font size="2">
					<input type="hidden" id="suganglist" name="suganglist" value="${sugangList.l_name}"/>
					<input type="hidden" id="checklist" name="checklist" value="${sugangList.count}"/>${sugangList.l_name}
					<input type="hidden" name="sugangsubject${sugangList.count}" value="${sugangList.l_name}"/>
					</font>
				</td>
				<td align="center"><font size="2">${sugangList.professor}</font>
					<input type="hidden" name="professorlist" value="${sugangList.professor}"/>
				</td>
				<td align="center" width="50"><font size="2">${sugangList.f_grade}</font>  <!-- 학점  -->
					<input type="hidden" name="hakjumlist" id="hakjumlist" value="${sugangList.f_grade}"/>
				</td>
			</tr>
			<tr>
				<td align="center"><font size="2">${sugangList.in_stu} / ${sugangList.limit_stu}</font></td>
				<td align="center"><font size="2">${sugangList.l_room}</font></td>
				<td align="center" colspan="2"><font size="2"><b>${sugangList.l_day}</b> 요일  / <b>${sugangList.l_start}, ${sugangList.l_start+sugangList.l_end-1}</b> 교시</font>
					
					<c:forEach  var="i" begin="1" end="${sugangList.l_end}"  >     <!--     요일  + 시간 = 시간표위치 값을 히든값으로 가져옴       -->
						<input type="hidden" name="sch_time${sugangList.count}" value="${sugangList.day + sugangList.l_start+(i-1)}"/>
					</c:forEach>
				</td>
				
			</tr>
		</table>
	</c:forEach>   
</td></tr>
</table>


