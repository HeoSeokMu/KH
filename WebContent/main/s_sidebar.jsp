<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
	
<body>
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
							<li class="btn"><a class="s_menu1" href="notice_board.kh">공지사항</a></li>
							<li class="ly" style="display:list-item;">
								<dl>
									<dt>공지사항</dt>
									<dd><a href="notice_board.kh">공지사항</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="s_menu2" href="myInfo.kh">학적</a></li>
							<li class="ly">
								<dl>
									<dt>학적</dt>
									<dd><a href="myInfo.kh">학적기본사항조회 및 수정</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="s_menu3">휴학/복학</a></li>
							<li class="ly">
								<dl>
									<dt>휴학/복학</dt>
									<c:if test="${status == '재학'}">
										<dd><a href="restSchool.kh?id=${memId}">휴학신청</a></dd>
									</c:if>
									<c:if test="${status == '휴학'}">
										<dd><a href="returnSchool.kh?id=${memId}">복학신청</a></dd>
									</c:if>
								</dl>
							</li>
							<li class="btn"><a class="s_menu4">교과/수강</a></li>
							<li class="ly">
								<dl>
									<dt>교과/수강</dt>
									<dd><a href="#">교과과정</a></dd>
									<dd><a href="sugang.kh">수강신청</a></dd>
									<dd><a href="#">개설과목 조회</a></dd>
									<dd><a href="sugangchk.kh">수강신청 내역조회</a></dd>
									<dd><a href="#">개인 시간표 조회</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="s_menu5">수업/성적</a></li>
							<li class="ly">
								<dl>
									<dt>수업/성적</dt>
									<dd><a href="CourseEvaluation.kh">강의평가</a></dd>
									<dd><a href="CurrentSemester_gradeView.kh">금학기 성적조회</a></dd>
									<dd><a href="FullSemester_gradeView.kh">전체 성적조회</a></dd>
									<dd><a href="AttendanceView.kh">출석조회</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="s_menu6">등록/장학</a></li>
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
							<li class="btn"><a class="s_menu7">도서관</a></li>
							<li class="ly">
								<dl>
									<dt><a href="libraryMain.kh">도서관</a></dt>
									<dd><a href="bookList.kh">도서검색</a></dd>
									<dd><a href="bookRequest.kh">책 대여 신청</a></dd>
									<dd><a href="myBookRequestList.kh">책 대여 신청내역 확인</a></dd>
									<dd><a href="#">책 예약 취소</a></dd>
									<ad><c:if test="${memId == 'liadmin' } }"><a href="libraryAdmin.kh">관리자페이지</a></c:if></ad>
								</dl>
							</li>
							<li class="btn"><a class="s_menu8">예비군</a></li>
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