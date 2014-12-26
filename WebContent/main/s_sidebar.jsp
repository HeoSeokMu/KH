<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
							<li class="btn"><a class="s_menu3" onclick="link_chk('${status}', '${memId}')">휴학/복학</a></li>
							<li class="ly">
								<dl>
									<dt>휴학/복학</dt>
									<c:if test="${status == '재학' || status == '휴학신청중'}">
										<dd><a href="restSchool.kh?id=${memId}" onclick="return status_chk('${status}')">휴학신청</a></dd>
									</c:if>
									<c:if test="${status == '휴학' || status == '복학신청중'}">
										<dd><a href="returnSchool.kh?id=${memId}" onclick="return status_chk('${status}')">복학신청</a></dd>
									</c:if>
								</dl>
							</li>
							<li class="btn"><a class="s_menu4" href="sugangchk.kh">교과/수강</a></li>
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
							<li class="btn"><a class="s_menu5" href="CurrentSemester_gradeView.kh">수업/성적</a></li>
							<li class="ly">
								<dl>
									<dt>수업/성적</dt>
									<dd><a href="CourseEvaluation.kh">강의평가</a></dd>
									<dd><a href="CurrentSemester_gradeView.kh">금학기 성적조회</a></dd>
									<dd><a href="FullSemester_gradeView.kh">전체 성적조회</a></dd>
									<dd><a href="AttendanceView.kh">출석조회</a></dd>
								</dl>
							</li>
							<li class="btn"><a class="s_menu6" href="bookList.kh">도서관</a></li>
							<li class="ly">
								<dl>
									<dt><a>도서관</a></dt>
									<dd><a href="bookList.kh">도서검색</a></dd>
									<dd><a href="bookRequest.kh">책 대여 신청</a></dd>
									<dd><a href="myBookRequestList.kh">책 대여 신청내역 확인</a></dd>
									<dd><a href="#">책 예약 취소</a></dd>
									
								</dl>
							</li>
						</ul>
					</div>
				</c:if>
		   	</div>
		</div>
