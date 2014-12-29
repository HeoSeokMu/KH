<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>강의등록</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
	
	<script type="text/javascript">
		function inChk() {
			if(document.lecture_form.m_code.value == "") {
				alert("학과를 입력하세요");
				return false;
			}
			if(document.lecture_form.l_type.value == "") {
				alert("타입을 입력하세요");
				return false;
			}
			if(document.lecture_form.l_code.value == "") {
				alert("강의코드를 입력하세요");
				return false;
			}
			if(document.lecture_form.l_name.value == "") {
				alert("강의명을 입력하세요");
				return false;
			}
			if(document.lecture_form.l_room.value == "") {
				alert("강의실을 입력하세요");
				return false;
			}
			if(document.lecture_form.semester1.value == "") {
				alert("학기를 입력하세요");
				return false;
			}
			if(document.lecture_form.y_grade1.value == "") {
				alert("학년을 입력하세요");
				return false;
			}
			if(document.lecture_form.f_grade1.value == "") {
				alert("이수학점을 입력하세요");
				return false;
			}
			if(document.lecture_form.l_day.value == "") {
				alert("요일을 입력하세요");
				return false;
			}
			if(document.lecture_form.l_start1.value == "") {
				alert("시작시간을 입력하세요");
				return false;
			}
			if(document.lecture_form.l_end1.value == "") {
				alert("강의시간을 입력하세요");
				return false;
			}
			if(document.lecture_form.limit_stu1.value == "") {
				alert("수강인원을 입력하세요");
				return false;
			}
		}
		
	</script>
</head>

<body>
	<c:if test="${type == '교직원'}">
      <jsp:include page="/main/e_sidebar.jsp" />
   </c:if>
   <c:if test="${type == '교수'}">
      <jsp:include page="/main/p_sidebar.jsp" />
   </c:if>
   <c:if test="${type != '교수' && type != '교직원'}">
      <jsp:include page="/main/s_sidebar.jsp" />
   </c:if>
		<div id="box3">
			<center>
			<form name="lecture_form" action="lectureInsertPro.kh" method="post" onsubmit="return inChk();">
				<br/>
				<h2>강의 등록</h2>
				<table border="1">
					<tr>
						<td colspan="2">교수번호</td><td>${p_code}<input type="hidden" name="p_code" value="${memId}"/></td>
					</tr>
					<tr>
						<td colspan="2">교수명</td><td>${name}<input type="hidden" name="professor" value="${name}"/></td>
					</tr>
					<tr>
						<td rowspan="5">강의</td>
						<td>학과</td><td><input type="text" name="m_code" value="${major}"/></td>
					</tr>
					<tr>
						<td>타입<br/>(전필 : e, 전선 : c)</td><td><input type="text" name="l_type"/></td>
					</tr>
					<tr>
						<td>강의코드</td><td><input type="text" name="l_code"/></td>
					</tr>
					<tr>
						<td>강의명</td><td><input type="text" name="l_name"/></td>
					</tr>
					<tr>
						<td>강의실</td><td><input type="text" name="l_room"/></td>
					</tr>
					<tr>
						<td rowspan="7">수업</td>
						<td>학기</td><td><input type="text" name="semester1"/></td>
					</tr>
					<tr>
						<td>학년</td><td><input type="text" name="y_grade1"/></td>
					</tr>
					<tr>
						<td>이수학점</td><td><input type="text" name="f_grade1"/></td>
					</tr>
					<tr>
						<td>요일</td><td><input type="text" name="l_day"/></td>
					</tr>
					<tr>
						<td>시작시간</td><td><input type="text" name="l_start1"/></td>
					</tr>
					<tr>
						<td>강의시간</td><td><input type="text" name="l_end1"/></td>
					</tr>
					<tr>
						<td>수강인원</td><td><input type="text" name="limit_stu1"/></td>
					</tr>
					<tr>
						<td colspan="3"><input type="submit" value="강의등록"/></td>
					</tr>
				</table>
			</form>
			</center>
			<br/><br/>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>