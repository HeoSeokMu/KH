<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
<title>KH 통합정보시스템</title>
<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
<link rel="stylesheet" href="css/left_menu.css"></link>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/leftMenu_jquery.js"></script>
</head>

<body>
	<div id="box">
		<div id="header">
			<div id="header_1"></div>
			<div id="header_2">
				<center>
					<c:if test="${memId != null}">
                  ${memId} 님 어서오세요 ~~~ 
               
                  <form name="logout" method="post" action="LoginOut.kh">
							<input type="submit" name="logout" value="로그아웃" />
						</form>
					</c:if>
				</center>
			</div>
		</div>
	</div>

<<<<<<< HEAD
   <div id="box">
      <div id="box2">
          <div id="content">
             <c:if test="${memId != null}">
                <div id="tab_menu">               
                  <ul>
                     <li class="btn"><a class="e_menu1">공지사항</a></li>
                     <li class="ly" style="display:list-item;">
                        <dl>
                           <dt>공지사항</dt>
                           <dd><a href="notice_board.kh">공지사항</a></dd>
                        </dl>
                     </li>
                     <li class="btn"><a class="e_menu2">개인정보</a></li>
                     <li class="ly">
                        <dl>
                           <dt>개인정보</dt>
                           <dd><a href="myInfo.kh">기본사항조회 및 수정</a></dd>
                        </dl>
                     </li>
                     <li class="btn"><a class="e_menu3">개인정보 변경처리</a></li>
                     <li class="ly">
                        <dl>
                           <dt>개인정보 변경처리</dt>
                           <dd><a href="#">신청내역 확인</a></dd>
                           <dd><a href="#">처리내역 확인</a></dd>
                        </dl>
                     </li>
                     <li class="btn"><a class="e_menu4">강의개설 처리</a></li>
                     <li class="ly">
                        <dl>
                           <dt>강의개설 처리</dt>
                           <dd><a href="lectureReq.kh">신청내역 확인</a></dd>
                           <dd><a href="#">처리내역 확인</a></dd>
                        </dl>
                     </li>
                     <li class="btn"><a class="e_menu5">휴가신청 및 처리</a></li>
                     <li class="ly">
                        <dl>
                           <dt>휴가신청 및 처리</dt>
                           <dd><a href="#">휴가 신청</a></dd>
                           <dd><a href="#">휴가 신청내역 확인</a></dd>
                           <dd><a href="#">휴가 처리내역 확인</a></dd>
                        </dl>
                     </li>
                     <li class="btn"><a class="e_menu6">휴학 및 복학처리</a></li>
                     <li class="ly">
                        <dl>
                           <dt>휴학 및 복학처리</dt>
                           <dd><a href="RestReturnRequest_board.kh">휴학 신청내역 확인</a></dd>
                           <dd><a href="#">휴학 처리내역 확인</a></dd>
                           <dd><a href="#">복학 신청내역 확인</a></dd>
                           <dd><a href="#">복학 처리내역확인</a></dd>
                        </dl>
                     </li>
                     <li class="btn"><a class="e_menu7">장학 처리</a></li>
                     <li class="ly">
                        <dl>
                           <dt>장학 처리</dt>
                           <dd><a href="#">장학금 신청내역 확인</a></dd>
                           <dd><a href="#">장학금 처리내역 확인</a></dd>
                        </dl>
                     </li>
                     <li class="btn"><a class="e_menu8">도서관</a></li>
                     <li class="ly">
                        <dl>
                           <dt>도서관</dt>
                           <dd><a href="#">책 대여 신청내역 확인</a></dd>
                           <dd><a href="#">책 대여 리스트</a></dd>
                        </dl>
                     </li>
                     <li class="btn"><a class="e_menu9">예비군</a></li>
                     <li class="ly">
                        <dl>
                           <dt>예비군</dt>
                           <dd><a href="#">예비군 신청내역 확인</a></dd>
                           <dd><a href="#">훈련일자 처리</a></dd>
                           <dd><a href="#">훈련결과 처리</a></dd>
                        </dl>
                     </li>
=======
	<div id="box">
		<div id="box2">
			<div id="content">
				<c:if test="${memId != null}">
					<div id="tab_menu">
						<ul>
							<li class="btn"><a class="e_menu1">공지사항</a></li>
							<li class="ly" style="display: list-item;">
								<dl>
									<dt>공지사항</dt>
									<dd>
										<a href="notice_board.kh">공지사항</a>
									</dd>
								</dl>
							</li>
							<li class="btn"><a class="e_menu2">개인정보</a></li>
							<li class="ly">
								<dl>
									<dt>개인정보</dt>
									<dd>
										<a href="myInfo.kh">기본사항조회 및 수정</a>
									</dd>
								</dl>
							</li>
							<li class="btn"><a class="e_menu3">개인정보 변경처리</a></li>
							<li class="ly">
								<dl>
									<dt>개인정보 변경처리</dt>
									<dd>
										<a href="#">신청내역 확인</a>
									</dd>
									<dd>
										<a href="#">처리내역 확인</a>
									</dd>
								</dl>
							</li>
							<li class="btn"><a class="e_menu4">강의개설 처리</a></li>
							<li class="ly">
								<dl>
									<dt>강의개설 처리</dt>
									<dd>
										<a href="#">신청내역 확인</a>
									</dd>
									<dd>
										<a href="#">처리내역 확인</a>
									</dd>
								</dl>
							</li>
							<li class="btn"><a class="e_menu5">휴가신청 및 처리</a></li>
							<li class="ly">
								<dl>
									<dt>휴가신청 및 처리</dt>
									<dd>
										<a href="#">휴가 신청</a>
									</dd>
									<dd>
										<a href="#">휴가 신청내역 확인</a>
									</dd>
									<dd>
										<a href="#">휴가 처리내역 확인</a>
									</dd>
								</dl>
							</li>
							<li class="btn"><a class="e_menu6">휴학 및 복학처리</a></li>
							<li class="ly">
								<dl>
									<dt>휴학 및 복학처리</dt>
									<dd>
										<a href="RestReturn_Board.kh?rrrb_check=신청">휴학 신청내역 확인</a>
									</dd>
									<dd>
										<a href="RestReturn_Board.kh?rrrb_check=처리">휴학 처리내역 확인</a>
									</dd>
									<dd>
										<a href="#">복학 신청내역 확인</a>
									</dd>
									<dd>
										<a href="#">복학 처리내역확인</a>
									</dd>
								</dl>
							</li>
							<li class="btn"><a class="e_menu7">장학 처리</a></li>
							<li class="ly">
								<dl>
									<dt>장학 처리</dt>
									<dd>
										<a href="#">장학금 신청내역 확인</a>
									</dd>
									<dd>
										<a href="#">장학금 처리내역 확인</a>
									</dd>
								</dl>
							</li>
							<li class="btn"><a class="e_menu8">도서관</a></li>
							<li class="ly">
								<dl>
									<dt>도서관</dt>
									<dd>
										<a href="#">책 대여 신청내역 확인</a>
									</dd>
									<dd>
										<a href="#">책 대여 리스트</a>
									</dd>
								</dl>
							</li>
							<li class="btn"><a class="e_menu9">예비군</a></li>
							<li class="ly">
								<dl>
									<dt>예비군</dt>
									<dd>
										<a href="#">예비군 신청내역 확인</a>
									</dd>
									<dd>
										<a href="#">훈련일자 처리</a>
									</dd>
									<dd>
										<a href="#">훈련결과 처리</a>
									</dd>
								</dl>
							</li>
>>>>>>> b55012692e2b56cead5711b7c1b606b9e0207964
                     <li class="btn"><a class="e_menu10">교적부 등록</a></li>
                      <li class="ly">
                        <dl>
                           <dt>교적부</dt>
                           <dd><a href="joinForm.kh">교적부 등록</a></dd>
                           <dd><a href="#">교적부 명단</a></dd>
                        </dl>
                      </li>
						</ul>
					</div>
				</c:if>
			</div>
		</div>
