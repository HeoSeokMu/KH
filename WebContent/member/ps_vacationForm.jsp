<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<head>
<title>휴가신청</title>
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

<body onload="auto_default('${mDTO.type}', '${mDTO.major}');">

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
					<td colspan=4 align=center><font size=6 face="휴먼엽서체"><b>휴가신청서</b></font>
					</td>
				</tr>
				
				<tr bgcolor="BBEE99" height=40>
					<th width = 130 align=center>신청 구분</th>
					<td>
						&nbsp;
						&nbsp;<input type="radio" name="type" value="교수" checked disabled>교수
						&nbsp;<input type="radio" name="type" value="교직원" disabled>교직원
					</td>
					<input type="hidden" value="${mDTO.name}" name="name">
					<input type="hidden" value="${mDTO.type}" name="type">
					<input type="hidden" value="${mDTO.id}" name="id">
				</tr>
				
				<tr bgcolor="BBEE99" height=40>
					<th width = 130 align="center">소속</th>
					<td>
						&nbsp;&nbsp;&nbsp;<select name="part">
							<option value="${mDTO.major}" selected>${mDTO.major}</option>
						</select>
					</td>
					<input type="hidden" value="${mDTO.major}" name="major">
				</tr>
				
				<tr bgcolor="BBEE99" height=40>
					<th width = 130 align=center>희망일자</th>
					<td onchange="dateSum();">
						&nbsp;&nbsp;
						<select name="vacStart_yy">
							<option>연도</option>
								
								<!-- 휴가신청 연도는 올해와 내년으로 한정한다. -->
								<fmt:formatDate value="<%=new java.util.Date()%>" var="thisYear" pattern="yyyy" />
								
								
								<c:forEach var="y" begin="${thisYear}" end="${thisYear + 1}">
									<option value="${y}">${y}</option>
								</c:forEach>
						</select>
						<select name="vacStart_mm">
							<option >월</option>
							
								<c:forEach var="m" begin="1" end="12">
									<option value="${m}">${m}</option>
								</c:forEach>
						</select>
							
						<select name="vacStart_dd" onchange="chk_dd(vacStart_yy.value, vacStart_mm.value, vacStart_dd.value, 'start' )">
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
						
						<select name="vacEnd_yy" onchange="chk_dd(vacEnd_yy.value, vacEnd_mm.value, vacEnd_dd.value, 'end' ,'y')">
							<option value="0">연도</option>
							
								<c:forEach var="y" begin="${thisYear}" end="${thisYear + 1}">
									<option value="${y}">${y}</option>
								</c:forEach>
						</select>
						<select name="vacEnd_mm" onchange="chk_dd(vacEnd_yy.value, vacEnd_mm.value, vacEnd_dd.value, 'end', 'm' )">
							<option value="0">월</option>
								<c:forEach var="m" begin="1" end="12">
									<option value="${m}">${m}</option>
								</c:forEach>
						</select>
							
						<select name="vacEnd_dd" onchange="chk_dd(vacEnd_yy.value, vacEnd_mm.value, vacEnd_dd.value, 'end', 'd' )">
							<option value="0">일</option>
							<c:forEach var="d" begin="1" end="31">
								<option value="${d}" >${d}</option>
							</c:forEach>
						</select>
						<br />
						<span id="dateError" style="display:none;"><font color="red" size="2">&nbsp;&nbsp;#날짜를 확인해주세요.</font></span>
						<span id="dateOk" style="display:none;"><font color="blue" size="2">&nbsp;&nbsp;#신청 가능한 날짜입니다.</font></span>
					</td>
				<input type="hidden" name="vacation_start">
				<input type="hidden" name="vacation_end">
				</tr>
		
				<tr bgcolor="BBEE99" height=40 >
					<th width = 130 align=center>휴가사유</th>
						
					<td>
						&nbsp;&nbsp;
						<textarea name="vacation_reason" cols="55" rows="15" style="padding:10px;"></textarea>
					</td>
				</tr>
						
				<tr bgcolor="BBEE99" height=40>
				
					<th width = 130 align=center>신청인</th>
					<td align="center">
							&nbsp;&nbsp;
							<font size="4">
							<b>
							${mDTO.name}
							</b>
							</font>
					</td>
				<tr bgcolor="BBEE99" height=40>
					<th width = 130 align=center>신청일자</th>
					<td align="center">		
							<font size="3">
							<b> 
							<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy년  MM월  dd일"/>
							</b>
							</font>
					</td>
				</tr>
				<tr bgcolor="77CC55" height=40>
					<td width = 500 colspan=2 align=center>
						<input type="button" value="작성" onClick="hugaGo();">
						<input type="button" value="취소" onclick="window.history.go(-1)">
					</td>
				</tr>
		
		</table>
		
	</form>
		
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>