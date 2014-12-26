<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<head>
<title>휴가 신청 수정</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
	<style>
		.login{
			background-color:#7eb813;
			color:#ffffff;
			border:1px #dddddd dashed;
			width:70px;
			height:60px;
			text-align:center;
			padding:3px;
		}
		.trTitle {
			height:15px;
		}
		.input{
			size: 15px;
		}
		
		.lineX {
			border-bottom: 1px solid #dddddd;
		}
		.tablepadding {
			padding-left: 15px;
			padding-right: 15px;
		}
	</style>
	
	<script src="/KH_School/member/script/vacation.js"></script>
	
</head>

<body onload="viewSet('${article.type}','${article.major}');">

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
		<form action="#" method="post" name="user_input">
			<table border=1 align="center" width="600">
				<tr bgcolor="77CC55" height=50>
					<td colspan=4 align=center><font size=6 face="휴먼엽서체"><b>휴가 신청 수정</b></font>
					</td>
				</tr>
				
				<tr bgcolor="BBEE99" height=40>
					<th width = 130 align=center>신청 구분</th>
					<td>
						&nbsp;
						&nbsp;<input type="radio" name="type" value="교수" checked disabled>교수
						&nbsp;<input type="radio" name="type" value="교직원" disabled>교직원
					</td>
					<input type="hidden" value="${article.name}" name="name">
					<input type="hidden" value="${article.type}" name="type">
				</tr>
				
				<tr bgcolor="BBEE99" height=40>
					<th width = 130 align="center">소속</th>
					<td>
						&nbsp;&nbsp;&nbsp;<select name="part" disabled>
							<option value="${article.major}" selected>${article.major}</option>
						</select>
					</td>
					<input type="hidden" value="${article.major}" name="major">
				</tr>
				
				<tr bgcolor="BBEE99" height=40>
					<th width = 130 align=center>희망일자
					<br />
							<sub>
								&nbsp;<input type="checkbox" id="changeCheck" name="changeCheck" value="1" onclick="ChangeDate();">희망 일자 변경
							</sub>
					</th>
					<td id="original">
						&nbsp;&nbsp;
						<input type="text" value="${article.vacStart_yy}년 ${article.vacStart_mm}월 ${article.vacStart_dd}일 ~ ${article.vacEnd_yy}년 ${article.vacEnd_mm}월 ${article.vacEnd_dd}일" readOnly style="width:230px; padding:7px">
					</td>
				
					<td id="newDate" onchange="dateSum();" style="display:none;">
						&nbsp;&nbsp;
						<select name="vacStart_yy" disabled="disabled">
							<option>연도</option>
								
								<!-- 휴가신청 연도는 올해와 내년으로 한정한다. -->
								<fmt:formatDate value="<%=new java.util.Date()%>" var="thisYear" pattern="yyyy" />
								
								
								<c:forEach var="y" begin="${thisYear}" end="${thisYear + 1}">
									<option value="${y}">${y}</option>
								</c:forEach>
						</select>
						<select name="vacStart_mm" disabled="disabled">
							<option >월</option>
								<c:forEach var="m" begin="1" end="12">
									<option value="${m}">${m}</option>
								</c:forEach>
						</select>
							
						<select name="vacStart_dd" onchange="chk_dd(vacStart_yy.value, vacStart_mm.value, vacStart_dd.value, 'start' )" disabled="disabled">
							<option>일</option>
							<c:forEach var="d" begin="1" end="31" >
								<option value="${d}" >${d}</option>
							</c:forEach>
						</select>
						
						&nbsp;&nbsp;
						~
						&nbsp;&nbsp;
						
			<!-- 
						뒤			 -->	
						
						<select name="vacEnd_yy" onchange="chk_dd(vacEnd_yy.value, vacEnd_mm.value, vacEnd_dd.value, 'end' ,'y')" disabled="disabled">
							<option value="0">연도</option>
							
								<c:forEach var="y" begin="${thisYear}" end="${thisYear + 1}">
									<option value="${y}">${y}</option>
								</c:forEach>
						</select>
						<select name="vacEnd_mm" onchange="chk_dd(vacEnd_yy.value, vacEnd_mm.value, vacEnd_dd.value, 'end', 'm' )" disabled="disabled">
							<option value="0">월</option>
								<c:forEach var="m" begin="1" end="12">
									<option value="${m}">${m}</option>
								</c:forEach>
						</select>
							
						<select name="vacEnd_dd" onchange="chk_dd(vacEnd_yy.value, vacEnd_mm.value, vacEnd_dd.value, 'end', 'd' )" disabled="disabled">
							<option value="0">일</option>
							<c:forEach var="d" begin="1" end="31">
								<option value="${d}" >${d}</option>
							</c:forEach>
						</select>
						<br />
						<span id="dateError" style="display:none;"><font color="red" size="2">&nbsp;&nbsp;#날짜를 확인해주세요.</font></span>
						<span id="dateOk" style="display:none;"><font color="blue" size="2">&nbsp;&nbsp;#신청 가능한 날짜입니다.</font></span>
					</td>
				</tr>
		
				<tr bgcolor="BBEE99" height=40 >
					<th width = 130 align=center>휴가사유</th>
						
					<td height="300px">
						&nbsp;&nbsp;
						<textarea name="vacation_reason" cols="55" rows="15" style="padding:10px;">${vacation_reason}</textarea>
					</td>
				</tr>
						
				<tr bgcolor="BBEE99" height=40>
				
					<th width = 130 align=center>신청인</th>
					<td align="center">
							&nbsp;&nbsp;
							<font size="4">
							<b>
							${article.name}
							</b>
							</font>
					</td>
				<tr bgcolor="BBEE99" height=40>
					<th width = 130 align=center>신청 수정 일자</th>
					<td align="center">		
							<font size="3">
							<b> 
							<fmt:formatDate value="${article.reg_date}" pattern="yyyy년  MM월  dd일"/>
							</b>
							</font>
					</td>
				</tr>
				<tr bgcolor="77CC55" height=40>
					<input type="hidden" name="no" value="${article.no}">
					<input type="hidden" name="origin_syy" value="${article.vacStart_yy}">
					<input type="hidden" name="origin_smm" value="${article.vacStart_mm}">
					<input type="hidden" name="origin_sdd" value="${article.vacStart_dd}">
					
					<input type="hidden" name="origin_eyy" value="${article.vacEnd_yy}">
					<input type="hidden" name="origin_emm" value="${article.vacEnd_mm}">
					<input type="hidden" name="origin_edd" value="${article.vacEnd_dd}">
					
					<td width = 500 colspan=2 align=center>
						<input type="button" value="수정" onClick="goModify();">
					</td>
				</tr>
		
		</table>
		
	</form>
		
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>