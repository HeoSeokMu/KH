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

<body onload="viewSet('${article.type}','${article.result}');">

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
					<th width = 130 align=center>처리 상태</th>
					<td>
						&nbsp;
						&nbsp;<input type="radio" name="result" value="미처리" checked disabled>미처리
						&nbsp;<input type="radio" name="result" value="승인" disabled>승인
						&nbsp;<input type="radio" name="result" value="거절" disabled>거절
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
					<input type="hidden" value="${article.id}" name="id">
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
					<th width = 130 align=center>희망일자</th>
					<td id="original">
						&nbsp;&nbsp;
						<input type="text" value="${article.vacStart_yy}년 ${article.vacStart_mm}월 ${article.vacStart_dd}일 ~ ${article.vacEnd_yy}년 ${article.vacEnd_mm}월 ${article.vacEnd_dd}일" readOnly style="width:230px; padding:7px">
					</td>
				</tr>
		
				<tr bgcolor="BBEE99" height=40 >
					<th width = 130 align=center>휴가사유</th>
						
					<td height="300px" style="padding:20px;">
						${article.vacation_reason}
					</td>
					<input type="hidden" value="${article.no}" name="no">
					<input type="hidden" value="${article.vacation_reason}" name="vacation_reason">
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
					<th width = 130 align=center>신청일자</th>
					<td align="center">		
							<font size="3">
							<b> 
							<fmt:formatDate value="${article.reg_date}" pattern="yyyy년  MM월  dd일"/>
							</b>
							</font>
					</td>
				</tr>
				<tr bgcolor="77CC55" height=40>
					<td width = 500 colspan=2 align=center>
						<c:if test="${article.result == '미처리'}">
						<input type="button" value="승인" onClick="acceptHuga();">
						<input type="button" value="거절" onClick="denyHuga();">
						<input type="button" value="수정" onClick="hugaModify();">
						<input type="button" value="삭제" onclick="delHuga();">
						</c:if>
					</td>
				</tr>
		
		</table>
		
	</form>
		
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>