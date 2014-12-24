<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<title>KH 통합정보시스템</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
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
							<li class="btn"><a class="p_menu1" href="notice_board.kh">공지사항</a></li>
							<li class="ly" style="display:list-item;">
								<dl>
									<dt>공지사항</dt>
									<dd><a href="notice_board.kh">공지사항</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="p_menu2" href="myInfo.kh">개인정보</a></li>
							<li class="ly">
								<dl>
									<dt>개인정보</dt>
									<dd><a href="myInfo.kh">기본사항조회 및 수정</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="p_menu3">강의정보</a></li>
							<li class="ly">
								<dl>
									<dt>강의정보</dt>
									<dd><a href="#">강의 확인</a></dd>
									<dd><a href="#">강의 개설</a></dd>
									<dd><a href="#">출석 등록</a></dd>
									<dd><a href="#">성적 등록</a></dd>
									<dd><a href="#">개설신청 확인</a></dd>
									<dd><a href="#">개인 시간표 조회</a></dd>
								</dl>
							</li>
							<li class="btn"><a href="libraryMain.kh" class="p_menu4">도서관</a></li>							<li class="ly">
								<dl>
									<dt>도서관</dt>
									<dd><a href="bookList.kh">도서검색</a></dd>
									<dd><a href="#">책 대여 신청</a></dd>
									<dd><a href="#">책 대여 리스트</a></dd>
									<dd><a href="#">책 예약 취소</a></dd>
									<ad><c:if test="${type == '교직원' }"><a href="libraryAdmin.kh">관리자페이지</a></c:if></ad>
								</dl>
							</li>
							<li class="btn"><a class="p_menu5" href="vacationForm.kh">휴가신청</a></li>
							<li class="ly">
								<dl>
									<dt>휴가신청</dt>
									<dd><a href="vacationForm.kh">휴가신청</a></dd>
									<dd><a href="vacationResult.kh">휴가신청 확인</a></dd>
								</dl>
							</li>
						</ul>
					</div>
				</c:if>
		   	</div>
		</div>