<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>공지사항</title>
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
	<script language="javascript">
		function focusIt() {
			alert("${check}");
			if("${check}"== 2){
				alert("아이디 또는 패스워드가 틀렸습니다.");
			}else if("${check}" == 3){
				alert("입력하신 아이디는 존재하지 않습니다.");
			}
		}
		
		function checkIt() {
			inputForm = eval("document.inform");
			if (!inputForm.id.value) {
				alert("아이디를 입력하세요..");
				inputForm.id.focus();
				return false;
			}
			if (!inputForm.passwd.value) {
				alert("패스워드를 입력하세요..");
				inputForm.passwd.focus();
				return false;
			}
			return ture;
		}
		
		function login_check(check) {
			if(check == -1) {
				alert("입력하신 아이디는 존재하지 않습니다.");
			} else if(check == 0) {
				alert("아이디 or 비밀번호를 틀리셨습니다.");
			}
		}
	</script>
</head>

<body onload="focusIt();">
	<div id="box">
		<div id="header">
			<div id="header_1">
				<ul class="menu">
					<li><a href="ChartBoard.action?category=chart"><img src="main/bbu_main_img/chart.png" name="chart" border="0" class="rollover"/></a></li>
					<li><a href="NewChartBoard.action?category=new"><img src="main/bbu_main_img/new.png"  name="new" border="0" class="rollover"/></a></li>
	
					<li><a href="GenreChartBoard.action?category=genre"><img src="main/bbu_main_img/genre.png" name="genre" border="0" class="rollover"/></a>
						<ul class="sub">
							<li><a href="GenreChartBoard.action?category=genre&type=dance"><img src="main/bbu_main_img/dance.png" name="dance" border="0" class="rollover"/></a></li>
							<li><a href="GenreChartBoard.action?category=genre&type=balad"><img src="main/bbu_main_img/balad.png" name="balad" border="0" class="rollover"/></a></li>
						</ul>
					</li>
					<li>
						<a href="#"><img src="main/bbu_main_img/payment.png" name="payment_buy" class="rollover" border="0"/></a>
						<ul class="sub">
							<li><a href="payBuyList.action?buy_id="><img src="main/bbu_main_img/bbu_payment.png" name="payment" border="0" class="rollover"/></a></li>
							<li><a href="cashCharge.action?my_id=" onclick="return idCheck();"><img src="main/bbu_main_img/cash.png" name="cash" border="0" class="rollover"/></a></li>
						</ul>
					</li>
				</ul>
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
					</div>
				</c:if>
		   	</div>
		</div>
		 
		<div id="box3">
			<center>
			<form method="post" name="chartForm">
				<hr width="880px" size="1" color="gray" align="center" />
				<table width="885px" align="center">
					<tr>
						<td align="left">
							<input type="button" name="h_selectall_btt" value="전체선택" 	width="50px" onClick="checkAll2(${blockCount})"/>
							<input type="button" name="h_listen_btt" value="듣기" onClick="list_add('s')"/>
							<input type="button" name="h_download_btt" value="다운" onClick="music_down('s')"/>
						</td>
					</tr>
				</table>
		
				<hr width="880px" size="1" align="center" />
				<table align="center">
					<tr align="center">
						<td width="30px" height="10px">
							<input type="checkbox" name="c_all" onclick="checkAll(this.checked, ${blockCount})">
						</td>
						<td width="25px"><g>NO</g></td>
						<td width="70px">제목</td>
						<td width="300px"><g>날짜</g></td>
						<td width="125px"><g>작성자</g></td>
					</tr>
				</table>
				<hr width="880px" size="3" color="#CC3D3D" align="center" />
		
				<c:if test="${totalCount < 1}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<table>
						<tr>
							<td align="left">게시물이 존재하지 않습니다.</td>
						</tr>
					</table>
				</c:if>
		
				<c:if test="${totalCount > 0}">
					<c:forEach var="list" items="${list}" varStatus="checkValue">
						<table align="center">
							<tr align="center" height="25px">
								<td width="30px" height="25px">
									<input type="checkbox" name="chkNo" value="${checkValue.index}">
								</td>
								<td width="25px">
									${(currentPage-1) * 10 + (checkValue.index + 1)}
								</td>
								<!--이미지-->
								<!--곡정보-->
								<td width="370px" align="left">
									<input type="image" name="m_play_btt" src="main/bbu_main_img/m_play_button.png" onclick="list_add(${checkValue.index });">
									<input type="image" name="m_add_btt" src="main/bbu_main_img/m_add_button.png"> &nbsp;
									<input type="image" name="m_page_btt" src="main/bbu_main_img/m_page_button.png">
									${list.title}
								</td>
								<td width="125px">
									<a href="SingerPage.action?category=singerPage&singer=${list.singer}">${list.singer}</a>
								</td>
								<td width="125px">
									<a href="AlbumPage.action?category=albumPage&album=${list.album}">${list.album}</a>
								</td>
								<!--좋아요-->
								<td width="105px">
									<input type="image" name="m_like_btt" src="main/bbu_main_img/m_like_button.png"> ${list.hit}
								</td>
								<!--다운로드-->
								<td td width="80px">
									<input type="image" name="m_download_img" src="main/bbu_main_img/m_download_button.png" onclick="musicConfirm2('s');">
								</td>
							</tr>
						</table>
						<hr width="880px" size="1" color="gray" align="center" />
					</c:forEach>
				</c:if>
				
				<!-- 전체선택 -->
				<table width="885px" align="center">
					<tr>
						<td align="left">
							<input type="button" name="h_selectall_btt" value="전체선택" 	width="50px" onClick="checkAll2(${blockCount})"/>
							<input type="button" name="h_listen_btt" value="듣기" onClick="list_add('s')"/>
							<input type="button" name="h_download_btt" value="다운" onClick="music_down('s')"/>
						</td>
					</tr>
				</table>
		
				<hr width="880px" size="1" align="center" />
				<br>
				<center>
					<s:property value="pagingHtml" escape="false" />
				</center>
			</form>
			</center>
		</div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>