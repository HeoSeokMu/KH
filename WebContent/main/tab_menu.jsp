<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	
						<ul>
							<li class="btn"><a class="menu1">공지사항</a></li>
							<li class="ly" style="display:list-item;">
								<dl>
									<dt>공지사항</dt>
									<dd><a href="notice_board.kh">공지사항</a></dd>
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