<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<title>공지사항</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
	
	<script>
		function body(){
		
			for(var i=0; i<=9; i++){
				var type = document.getElementsByName("q_type")[i].value;
				var code = document.getElementsByName("q_code")[i].value;
				var table = document.getElementsByName("q_table")[i].value;
				var name = document.getElementsByName("q_name")[i].value;
				var hakjum = document.getElementsByName("q_hakjum")[i].value;
				var professor = document.getElementsByName("q_professor")[i].value;
				
				var day = document.getElementsByName("q_day")[i].value;
				var sch = document.getElementsByName("q_sch")[i].value;
				var time = document.getElementsByName("q_time")[i].value;
				
				var num = document.getElementsByName("num")[i].value;
				
				var j = (Math.round(Math.random()*6));
				
				for(var k=0; k<time; k++){   			// 시간표에 색 표시
					var i_sch = Number(day)+Number(sch)+Number(k);
					var c = document.getElementById(i_sch);
					var color = ["#FF5E00","FFBB00","FFE400","#ABF200","#1DDB16","#0054FF","#0100FF"];
					c.style.backgroundColor=color[j]; 
					
					document.getElementsByName("sch_"+i_sch)[0].value = name;
				}
			}
		}
</script>
</head>


<body onload="body()">

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
	<br/>
<table width="900" border="0" cellspacing="0" cellpadding="0" bgcolor="#C9C9C9" >
	<tr align="center" height="30">
		<td width="13%"><font size="2"><b>학과</b></font></td>
		<td bgcolor="#F3F3F3" width="15%"><font size="2">${member.major }</font></td>
		<td width="13%"><font size="2"><b>학년</b></font></td>
		<td bgcolor="#F3F3F3" width="15%"><font size="2">${member.grade }</font></td>
		<td width="7%"><font size="2"><b>학번</b></font></td>
		<td bgcolor="#F3F3F3" width="15%"><font size="2">${member.id }</font></td>
		<td width="7%"><font size="2"><b>이름</b></font></td>
		<td bgcolor="#F3F3F3" width="15%"><font size="2">${member.name }</font></td>
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

<br/>

<table width="900" border="0" cellspacing="0" cellpadding="0">
               <!--    
									시간표     
											        -->
											        
				<c:forEach var="list" items="${list}">
					<input type="hidden" name="q_type" value="${list.l_type}"/> <!-- 전 선, 전 필 -->
					<input type="hidden" name="q_code" value="${list.l_code}"/> <!-- 과목 코드 -->
					<input type="hidden" name="q_table" value="${list.m_code}"/> <!--  테이블 이름 -->
					<input type="hidden" name="q_name" value="${list.l_name}"/> <!-- 과목 이름 -->
					<input type="hidden" name="q_hakjum" value="${list.f_grade}"/> <!-- 학 점 -->
					<input type="hidden" name="q_professor" value="${list.professor}"/> <!-- 담당 교수 -->
		
					<input type="hidden" name="q_day" value="${list.time_day}"/> <!-- 요일 String -->
					<input type="hidden" name="q_sch" value="${list.l_start}"/> <!-- 교시 -->
					<input type="hidden" name="q_time" value="${list.l_end}"/> <!-- 시간 -->
					<input type="hidden" name="num" value="${list.num}"/> <!-- 시간 -->
					
					<c:forEach  var="i" begin="1" end="${list.l_end}"  >     <!--     요일  + 시간 = 시간표위치 값을 히든값으로 가져옴       -->
						<input type="hidden" name="q_sch_time${list.num}" value="${list.time_day + list.l_start+(i-1)}"/>
					</c:forEach>
				</c:forEach>
<tr> 
	<td>
		<table align="center" border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
		
			<tr>
				<td width="80"></td>
				<td width="150" bgcolor="#b1b1b1" align="center"><font size="2"><b>월</b></font></td>
				<td width="150" bgcolor="#b1b1b1" align="center"><font size="2"><b>화</b></font></td>
				<td width="150" bgcolor="#b1b1b1" align="center"><font size="2"><b>수</b></font></td>
				<td width="150" bgcolor="#b1b1b1" align="center"><font size="2"><b>목</b></font></td>
				<td width="150" bgcolor="#b1b1b1" align="center"><font size="2"><b>금</b></font></td>
			</tr>
			<c:forEach var="i" begin="1" end="12"  step="1">
				<tr>
					<td bgcolor="#b1b1b1" align="center" height="50"><font size="2"><b>${i}교시</b></font></td>
					<td id="${100+i}"><input type="text" readonly="readonly" style="width:150; height:100%; text-align:center;" name="sch_${100+i}" /></td>
					<td id="${200+i}"><input type="text" readonly="readonly" style="width:150; height:100%; text-align:center;" name="sch_${200+i}" /></td>
					<td id="${300+i}"><input type="text" readonly="readonly" style="width:150; height:100%; text-align:center;" name="sch_${300+i}" /></td>
					<td id="${400+i}"><input type="text" readonly="readonly" style="width:150; height:100%; text-align:center;" name="sch_${400+i}" /></td>
					<td id="${500+i}"><input type="text" readonly="readonly" style="width:150; height:100%; text-align:center;" name="sch_${500+i}" /></td>
				</tr>
			</c:forEach>
				
		</table>
		
	</td>
</tr>
</table>
</div>
</div>

</body>