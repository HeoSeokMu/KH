<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>휴학 신청 페이지</title>
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
	
</head>

<body onload="focusIt();">
	<div id="box">
		<div id="header">
			<div id="header_1">
				
			</div>
			<div id="header_2">
				<center>
					<c:if test="${memId != null}">
						${memId} 님 어서오세요 ~~~ 
					
						<form name="logout" method="post" action="LoginOut.kh">
							<input type="submit" name="logout" value="로그아웃"/>
						</form>
					</c:if>
				</center>
			</div>
		</div>
	</div>

	<div id="box">
		<div id="box2">
	    	<div id="content">
	    		<c:if test="${memId != null}">
		    		<div id="tab_menu">					
						<ul>
							<li class="btn"><a class="menu1">공지사항</a></li>
							<li class="ly" style="display:list-item;">
								<dl>
									<dt>공지사항</dt>
									<dd><a href="#">공지사항</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="menu2">학적</a></li>
							<li class="ly">
								<dl>
									<dt>학적</dt>
									<dd><a href="myInfo.kh">학적기본사항조회 및 수정</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="menu3">휴학/복학</a></li>
							<li class="ly">
								<dl>
									<dt>휴학/복학</dt>
									<dd><a href="restSchool.kh?id=${memId}">휴학신청</a></dd>
									<dd><a href="returnSchool.kh?id=${memId}">복학신청</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="menu4">교과/수강</a></li>
							<li class="ly">
								<dl>
									<dt>교과/수강</dt>
									<dd><a href="#">교과과정</a></dd>
									<dd><a href="#">수강신청</a></dd>
									<dd><a href="#">개설과목 조회</a></dd>
									<dd><a href="#">수강신청 내역조회</a></dd>
									<dd><a href="#">개인 시간표 조회</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="menu5">수업/성적</a></li>
							<li class="ly">
								<dl>
									<dt>수업/성적</dt>
									<dd><a href="#">강의평가</a></dd>
									<dd><a href="#">금학기 성적조회</a></dd>
									<dd><a href="#">전체 성적조회</a></dd>
									<dd><a href="#">출석조회</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="menu6">등록/장학</a></li>
							<li class="ly">
								<dl>
									<dt>등록/장학</dt>
									<dd><a href="#">금학기 장학내역</a></dd>
									<dd><a href="#">근로장학 신청</a></dd>
									<dd><a href="#">근로장학 결과</a></dd>
									<dd><a href="#">교육비 납입 증명서</a></dd>
									<dd><a href="#">등록금 고지서</a></dd>
									<dd><a href="#">분납등록금 고지서</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="menu7">도서관</a></li>
							<li class="ly">
								<dl>
									<dt>도서관</dt>
									<dd><a href="#">책 대여 신청</a></dd>
									<dd><a href="#">책 대여 리스트</a></dd>
									<dd><a href="#">책 예약 취소</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="menu8">예비군</a></li>
							<li class="ly">
								<dl>
									<dt>예비군</dt>
									<dd><a href="#">예비군 신청</a></dd>
									<dd><a href="#">훈련일자 조회</a></dd>
									<dd><a href="#">훈련결과 조회</a></dd>
								</dl>
							</li>
						</ul>
					</div>
				</c:if>
		   	</div>
		</div>
		 
		<div id="box3">
			<center>
			<form action="restInsert.kh" method="post">
				<br/><br/>
				<h2>휴학신청서</h2>
				<table width="700">
					<tr>
						<td>
							<table border="1" width="700">
								<tr>
									<td colspan="2" width="20%" bgcolor="#ffff99" align="center">학   과</td><td colspan="2" width="20%" align="center">${mDTO.major}</td>
									<td colspan="2" width="20%" bgcolor="#ffff99" align="center">성   명</td><td colspan="2" width="20%" align="center">${mDTO.name}</td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#ffff99" align="center">학   번</td><td colspan="2" align="center">${mDTO.id}</td>
									<td colspan="2" bgcolor="#ffff99" align="center">학   년</td><td colspan="2" align="center">${mDTO.grade}</td>
								</tr>
								<tr>
									<td rowspan="2" width="10%" bgcolor="#ffff99" align="center">연락처</td><td bgcolor="#ffff99" align="center">E-mail</td><td colspan="5" align="center">${mDTO.email}</td>
								</tr>
								<tr>
									<td bgcolor="#ffff99" align="center">휴대폰</td><td colspan="5" align="center">${mDTO.s_phone}</td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#ffff99" align="center">주   소</td><td colspan="5" align="center">${mDTO.addr}</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="30"></td>
					</tr>
					<tr>
						<td>
							<table width="700" border="1">
								<tr>
									<td colspan="7" bgcolor="#ffff99" align="center">휴학종류</td>
								</tr>
								<tr>
									<td colspan="3" bgcolor="#ffff99" width="50%" align="center">시  기</td>
									<td colspan="4" bgcolor="#ffff99" width="50%" align="center">사  유</td>
								</tr>
								<tr>
									<td bgcolor="#ffff99" align="center">등록 휴학</td><td bgcolor="#ffff99" align="center">중도 휴학</td>
									<td bgcolor="#ffff99" align="center">미등록 휴학</td><td bgcolor="#ffff99" align="center">군입대</td>
									<td bgcolor="#ffff99" align="center">학 비</td><td bgcolor="#ffff99" align="center">유 학</td><td bgcolor="#ffff99" align="center">기 타</td>
								</tr>
								<tr>
									<td align="center"><input type="radio" name="time" value="register"/></td>
									<td align="center"><input type="radio" name="time" value="stop"/></td>
									<td align="center"><input type="radio" name="time" value="non_register"/></td>
									<td align="center"><input type="radio" name="why" value="army"/></td>
									<td align="center"><input type="radio" name="why" value="tuition"/></td>
									<td align="center"><input type="radio" name="why" value="abroad"/></td>
									<td align="center"><input type="radio" name="why" value="etc"/></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="30"></td>
					</tr>
					<tr>
						<td>
							<table border="1" width="700">
								<tr>
									<td colspan="8" width="100%" bgcolor="#ffff99" align="center">사 유(구체적으로)</td>
								</tr>
								<tr>
									<td colspan="8"><textarea rows="10" cols="95" name="why_detail"></textarea></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td align="left">위와 같이 휴학을 신청합니다.</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td align="center"><input type="submit" value="신청하기"/></td>
					</tr>					
				</table>
				<input type="hidden" name="major" value="${mDTO.major}"/>
				<input type="hidden" name="name" value="${mDTO.name}"/>
				<input type="hidden" name="id" value="${mDTO.id}"/>
				<input type="hidden" name="grade" value="${mDTO.grade}"/>
				<input type="hidden" name="email" value="${mDTO.email}"/>
				<input type="hidden" name="phone" value="${mDTO.s_phone}"/>
				<input type="hidden" name="addr" value="${mDTO.addr}"/>
			</form>
			</center>
			<br/><br/>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>