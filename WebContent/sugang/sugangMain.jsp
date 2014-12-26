<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script  charset="UTF-8" src="sugang/sugang.js">
</script>

<body onload="body()">
<form name='sugangForm' action="sugangPro.kh" method="post" onsubmit="return chk_it()"> 	

<table width="700" border="1" bordercolor="gray" cellspacing="0" cellpadding="3">
	<tr>
		<td align="center">
			<input type="text"  name="year" readonly="readonly" style="width:80; font-size: large; text-align: center;" value="2014"> 년  
			<input type="text"  name="semester" readonly="readonly" style="width:40; font-size: large; text-align: center;" value="1"> 학기
		</td>
	</tr>
</table>

<br/>

	<table width="700" border="1" bordercolor="gray" cellspacing="0" cellpadding="3">
		<tr height="30" bgcolor="#b1b1b1">
			<td align="center" width="100"><font size="2"><b>학 번</b></font></td>
			<td align="center" width="150"><font size="2"><b>학 과</b></font></td>
			<td align="center" width="50"><font size="2"><b>학 년</b></font></td>
			<td align="center"><font size="2"><b>이 름</b></font></td>
			<td align="center" bgcolor="#b1b1b1"><font size="2"><b>신청과목 수</b></font></td>
			<td align="center" bgcolor="#b1b1b1"><font size="2"><b>신청학점 (최저/학점/최고)</b></font></td>
		</tr>
		<tr height="30">
			<td align="center" ><input type="text" readonly="readonly" name="stu_num" value="${member.id }"  style="width:120; text-align:center;"/><font size="2"></font></td>
			<td align="center" ><input type="text" readonly="readonly" name="stu_code" value="${member.major }" style="width:120; text-align:center;"/><font size="2"></font></td>
			<td align="center" ><input type="text" readonly="readonly" name="stu_grade" value="${member.grade }" style="width:30; text-align:center;"/><font size="2"></font></td>
			<td align="center" ><input type="text" readonly="readonly" name="stu_name" value="${member.name }" style="width:60; text-align:center;"/><font size="2"></font></td>	
			<td align="center">
						<c:if test="${stu.subject_sum != null}">
							<input type="text" readonly="readonly" style="width:40; font-size: large; text-align: center;" name="subject_sum" value="${stu.subject_sum}"></td>
						</c:if>
						
						<c:if test="${stu.subject_sum == null}">
							<input type="text" readonly="readonly" style="width:40; font-size: large; text-align: center;" name="subject_sum" ></td>
						</c:if>
						
			<td align="center">16/
							<input type="hidden"  name="get_hakjum_sum" value="${stu.hakjum_sum}">	
							<input type="text" readonly="readonly" style="width:40; font-size: large; text-align: center;" name="hakjum_sum" >	
						
						/23
				<input type="hidden" name="lowlimit_hakjum" value="16"/>   <!-- 최저 요구 학점 -->    
				<input type="hidden" name="highlimit_hakjum" value="23"/>  <!-- 최고 요구 학점 -->    
			</td>
		</tr>
	</table>
	
<br/>


	<table width="500" border="1" bordercolor="gray" cellspacing="0" cellpadding="3">
		<tr>
			<td width="60"><font size="2"><b>전 공</b></font><input type="radio" id="A" name="A" value="m_code,y_grade" onclick="thisA()" checked /></td>
			<td width="60"><font size="2"><b>교 양</b></font><input type="radio" id="B" name="A" value="t_code,z_grade" onclick="thisB()"/></td>
			<td align="center" >
				<select name="search_sugang">
					<option >검색 조건</option>
					<option value="l_name">과목 명</option>
					<option value="professor">교수 명</option>
				</select>
				<input type="search" name="search" />
				<input type="button" value="검 색" onclick="selectSearch( search_sugang.value, search.value, stu_num.value, semester.value )"/>
			</td>
		</tr>
	</table>

	<table width="500" border="1" bordercolor="gray" cellspacing="0" cellpadding="3" id="typeA">
		<tr >
			<td width="200">
				<select name="m_code">
					<option>과 선택 </option>
					<option value="001">영어영문학과</option>
					<option value="002">국어국문학과</option>
					<option value="003">국제경영학과</option>
					<option value="004">컴퓨터공학과</option>
					<option value="005">정보보안학과</option>
				</select>
				<font size="2"><b>학과 선택</b></font>
			</td>
			<td width="200">
				<select name="y_grade">
					<option>학년 선택 </option>
					<option value="1">1 학년</option>
					<option value="2">2 학년</option>
					<option value="3">3 학년</option>
					<option value="4">4 학년</option>
				</select>
				<font size="2"><b>학년 선택</b></font>
			</td>
			<td width="100">
				<input type="button" value="확 인" onclick="selectRadio('major', m_code.value, y_grade.value, stu_num.value, semester.value )" />
			</td>
		</tr>
	</table>
	
	<table width="500" border="1" bordercolor="gray" cellspacing="0" cellpadding="3" id="typeB">
		<tr>
			<td width="200">
				<select name="t_code">
					<option value="">계열 선택</option>
					<option value=""></option>
					<option value=""></option>
					<option value=""></option>
				</select>
				<font size="2"><b>계열 선택</b></font>
			</td>
			<td width="200">
				<select name="z_grade">
					<option>학년 선택 </option>
					<option value="1">1 학년</option>
					<option value="2">2 학년</option>
					<option value="3">3 학년</option>
					<option value="4">4 학년</option>
				</select>
				<font size="2"><b>학년 선택</b></font>
			</td>
			<td width="100">
				<input type="button" value="확 인" onclick="selectRadio('liberal', t_code.value, z_grade.value, stu_num.value, semester.value)"/>
			</td>
		</tr>
	</table>

<br/>

		<!--        
						전체 테이블                  
										   -->
<table border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
<tr><td valign="top" rowspan="2">
	                          								
		<table width="500" border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
			<tr>
				<td rowspan="2" width="50"></td>
				<td align="center" width="100" bgcolor="#b1b1b1"><font size="2"><b>구 분</b></font></td>
				<td align="center" width="130" bgcolor="#b1b1b1"><font size="2"><b>과 목</b></font></td>
				<td align="center" bgcolor="#b1b1b1"><font size="2"><b>담당 교수</b></font></td>
				<td align="center" width="50" bgcolor="#b1b1b1"><font size="2"><b>학 점</b></font></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#b1b1b1"><font size="2"><b>인 원 (현재/총)</b></font></td>
				<td align="center" bgcolor="#b1b1b1"><font size="2"><b>강의실</b></font></td>
				<td align="center" colspan="2" bgcolor="#b1b1b1"><font size="2"><b>요일 / 시간</b></font></td>
				
			</tr>
		</table>
		
			<!--     
						수강 할 과목  리스트            
											   -->				
					<!--   innerHTML    -->
		<div id="selected"  style="height:680; overflow:auto;"> 		
		
		</div>
</td>

<td height="350" valign="top">	
													       
		<table border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" align="right" bgcolor="#b1b1b1">
					<input type="submit" value="수강 신청하기" style="width:100;"/>
				</td>
			</tr>
			<tr>
				<td align="center" width="50" bgcolor="#b1b1b1"><font size="2"><b>구 분</b></font></td>
				<td align="center" width="120" bgcolor="#b1b1b1"><font size="2"><b>과 목</b></font></td>
				<td align="center" width="50" bgcolor="#b1b1b1"><font size="2"><b>학 점</b></font></td>
				<td align="center" width="80" bgcolor="#b1b1b1"><font size="2"><b>담당 교수</b></font></td>
				<td align="center" width="100" bgcolor="#b1b1b1"><font size="2"><b>비 고</b></font></td>
				<td align="center" width="50"></td>
			</tr>
		</table>
				 <!--     
				 			수강신청 한 리스트             
				 							  -->
				 							  
				<c:forEach var="list" items="${list}">
					<input type="hidden" name="q_type" value="${list.l_type}"/> <!-- 전 선, 전 필 -->
					<input type="hidden" name="q_code" value="${list.l_code}"/> <!-- 과목 코드 -->
					<input type="hidden" name="q_table" value="${list.m_code}"/> <!--  테이블 이름 -->
					<input type="hidden" name="q_name" value="${list.l_name}"/> <!-- 과목 이름 -->
					<input type="hidden" name="q_hakjum" value="${list.f_grade}"/> <!-- 학 점 -->
					<input type="hidden" name="q_professor" value="${list.professor}"/> <!-- 담당 교수 -->
		
					<input type="hidden" name="q_day" value="${list.l_day}"/> <!-- 요일 String -->
					<input type="hidden" name="q_sch" value="${list.l_start}"/> <!-- 교시 -->
					<input type="hidden" name="q_time" value="${list.l_end}"/> <!-- 시간 -->
					<input type="hidden" name="num" value="${list.num}"/> <!-- 시간 -->
					
					<c:forEach  var="i" begin="1" end="${list.l_end}"  >     <!--     요일  + 시간 = 시간표위치 값을 히든값으로 가져옴       -->
						<input type="hidden" name="q_sch_time${list.num}" value="${list.l_day + list.l_start+(i-1)}"/>
					</c:forEach>
		
				</c:forEach>
				
	<c:forEach var="i" begin="0" end="9" step="1">  	                 
		<table border="1" bordercolor="gray" cellpadding="3" cellspacing="0" >
			
				<tr>
					<td align="center" width="50">
					
						<input type="hidden" name="sugang"/> <!-- list.length값  -->
						<input type="hidden" name="set_sch${i}" /><!-- num -->
						<input type="hidden" name="code${i}"/>  <!--  과목 코드  -->
						<input type="hidden" name="table${i}"/> <!--  테이블 이름 -->
						
						<input type="text" style="width:50; text-align: center;" readonly="readonly" name="subject${i}" /></td>
					<td align="center" width="120"><input type="text" style="width:120; text-align: center;" readonly="readonly" name="${i}" /></td>
					<td align="center" width="50"><input type="text" style="width:50; text-align: center;" readonly="readonly" name="hakjum${i}" /></td>
					<td align="center" width="80"><input type="text" style="width:80; text-align: center;" readonly="readonly" name="professor${i}" /></td>
					<td align="center" width="100"></td>
					<td align="center" width="50" bgcolor="#b1b1b1">
						<input type="button" value="취소 " onclick="no('${i}',set_sch${i}.value)"/>
					</td>
				</tr>
				
			<%-- </c:forEach> --%>
			
		</table>
	</c:forEach>

</td>
</tr>
<tr>                 <!--    
									시간표     
											        -->
	<td>
		<table align="center" border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
		
			<tr>
				<td width="50"></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>월</b></font></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>화</b></font></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>수</b></font></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>목</b></font></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>금</b></font></td>
			</tr>
			<c:forEach var="i" begin="1" end="12"  step="1">
				<tr>
					<td bgcolor="#b1b1b1" align="center"><font size="2"><b>${i}교시</b></font></td>
					<td id="${100+i}"><input type="text" readonly="readonly" style="width:80; text-align:center;" name="sch_${100+i}" /></td>
					<td id="${200+i}"><input type="text" readonly="readonly" style="width:80; text-align:center;" name="sch_${200+i}" /></td>
					<td id="${300+i}"><input type="text" readonly="readonly" style="width:80; text-align:center;" name="sch_${300+i}" /></td>
					<td id="${400+i}"><input type="text" readonly="readonly" style="width:80; text-align:center;" name="sch_${400+i}" /></td>
					<td id="${500+i}"><input type="text" readonly="readonly" style="width:80; text-align:center;" name="sch_${500+i}" /></td>
				</tr>
			</c:forEach>
				
		</table>
		
	</td>
</tr>
</table> <!--     전체 테이블             -->
</form>

</body>