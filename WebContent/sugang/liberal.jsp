<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
<tr><td>
	<c:forEach var="i" begin="1" end="10" step="1">    
	                              									 <!--     수강 할 과목  리스트               -->
		<table width="500" border="1" bordercolor="gray" cellpadding="3" cellspacing="0"  id="${i}">
			<tr>
				<td align="center" rowspan="2" width="50" bgcolor="#b1b1b1">
					<input type="button" value="신청 " onclick="ok('${i}','${100+i}')"/>
					
				</td>
				<td align="center" width="100"><font size="2">교 양</font>
					<input type="hidden" name="subjectlist" value="교 양"/>
				</td>
				<td align="center" width="120"><font size="2">
					<input type="hidden" id="suganglist" name="suganglist" value="${i}_과목"/>
					<input type="hidden" id="checklist" name="checklist" value="${i}"/>${i}_과목
					</font>
				</td>
				<td align="center"><font size="2">노 현태</font>
					<input type="hidden" name="professorlist" value="노 현태"/>
				</td>
				<td align="center" width="50"><font size="2">3</font>
					<input type="hidden" name="hakjumlist" value="3"/>
				</td>
			</tr>
			<tr>
				<td align="center"><font size="2">16 / 30</font></td>
				<td align="center"><font size="2"> E_강의실 </font></td>
				<td align="center" colspan="2"><font size="2">요일  / 시간</font>
					<input type="hidden" name="sch_time${i}" value="${100+i}"/>     <!--     요일  + 시간 = 시간표위치 값을 히든값으로 가져옴       -->
				</td>
				
			</tr>
		</table>
	</c:forEach>
</td></tr>
</table>
