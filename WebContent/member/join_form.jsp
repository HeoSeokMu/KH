<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="/KH_School/member/script/member.js"></script>

<body onload="imgPreview();">
<form action="#" method="post" name="user_input" enctype="multipart/form-data">
		<table border=1 align="center">
			<tr bgcolor="77CC55" height=50>
				<td colspan=4 align=center><font size=6 face="휴먼엽서체"><b>회원가입 양식</b></font>
				</td>
			</tr>
			<!--
			<tr>
				<td colspan=2 height=40></td>
				<td colspan=2 height=40></td>
				<td colspan=2 height=40></td>
				<td colspan=2 height=40></td>
			</tr>
			-->
			
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>등록 유형</th>
				<td>
					&nbsp;&nbsp;
					<input type="radio" name="type" value="학생" onClick="student();" checked>학생
					&nbsp;<input type="radio" name="type" value="교수" onClick="prof();">교수
					&nbsp;<input type="radio" name="type" id="employee" value="교직원" onClick="emplo();">교직원
				</td>
			</tr>
			
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>
				<div id="stu">전공</div>
				<div id="emp" style="display:none;">업무부처</div>
				</th>
				<td>
					
				<div id="maj">
					&nbsp;&nbsp;&nbsp;<select name="num2" id="maj1">
						<option value="001,영어영문학과" selected>영어영문학과</option>
						<option value="002,국어국문학과">국어국문학과</option>
						<option value="003,경제경영학과">경제경영학과</option>
						<option value="004,컴퓨터공학과">컴퓨터공학과</option>
						<option value="005,정보보안학과">정보보안학과</option>
					</select>
				</div>
				
				<div id="pmaj" style="display:none;">
					&nbsp;&nbsp;&nbsp;<select name="num2" id="pmaj1" disabled="disabled">
						<option value="401,영어영문학과">영어영문학과</option>
						<option value="402,국어국문학과">국어국문학과</option>
						<option value="403,경제경영학과">경제경영학과</option>
						<option value="404,컴퓨터공학과">컴퓨터공학과</option>
						<option value="405,정보보안학과">정보보안학과</option>
					</select>
				</div>
				
				<div id="work" style="display:none;">
					&nbsp;&nbsp;&nbsp;<select name="num2" id="work1" disabled="disabled">
						
						<option value="801,재정과">재정과</option>
						<option value="802,총무과">총무과</option>
						<option value="803,인사과">인사과</option>
						
					</select>
				</div>
				</td>
			</tr>
			
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>비밀번호</th>
				<td>
					&nbsp;&nbsp;
					<input type="password" name="password" maxlength=20 onKeyup="pwEvent()">
					<sub>(6~19자 내)</sub>
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>비밀번호 확인</th>
				<td>
					&nbsp;&nbsp;
					<input type="password" name="password_re" maxlength=20 onKeyup="pwEvent()">
					<div id="wrongPw" style="display:none;">&nbsp;&nbsp;&nbsp;
					<font color="red" size="2"># 비밀번호를 동일하게 입력해주세요.</font></div>
					<div id="rightPw" style="display:none;">&nbsp;&nbsp;&nbsp;
					<font color="blue" size="2"># 비밀번호가 일치합니다.</font></div>
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>이  름</th>
				<td>
					&nbsp;&nbsp;
					<input type="text" name="name">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>성  별</th>
				<td>
					&nbsp;&nbsp;
					<input type="radio" name="sex" value="Man" checked>남&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="Woman">여
				</td>
			</tr>
			
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>생년월일</th>
			<td>
			&nbsp;&nbsp;
			<select name="birth_yy">
				<option>연도</option>
				
					<c:forEach var="y" begin="1930" end="2014">
						<option value="${y}">${y}</option>
					</c:forEach>
				</select>
					<select name="birth_mm">
				<option>월</option>
				
					<c:forEach var="m" begin="1" end="12">
						<option value="${m}">${m}</option>
					</c:forEach>
				</select>
				
					<select name="birth_dd">
				<option>일</option>
				
				<c:forEach var="d" begin="1" end="31">
				
					<option value="${d}">${d}</option>
				</c:forEach>
					</select>
			</td>
		</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>
				<div id="way">입학유형</div>
				<div id="proflevel" style="display:none;">교수 구분</div>
				<div id="emplevel" style="display:none;">직원 구분</div>
				</th>
				<td>
					<div id="studway">
					&nbsp;&nbsp;
					<select name="enter_way" id="studway1">
						<option value="정시">정시입학</option>
						<option value="수시">수시입학</option>
						<option value="편입">편입학</option>
					</select>
					</div>
					
					<div id="profwho" style="display:none;">
					&nbsp;&nbsp;
					<select name="enter_way" id="profwho1" disabled="disabled">
						<option value="정교수">정교수</option>
						<option value="시간 강사">시간제 강사</option>
					</select>
					</div>
					
					<div id="empwho" style="display:none;">
					&nbsp;&nbsp;
					<select name="enter_way" id="empwho1" disabled="disabled">
						<option value="정직원">정직원</option>
						<option value="계약직">계약직 직원</option>
					</select>
					</div>
				</td>
			</tr>

			<tr bgcolor="BBEE99" height=40 id="hschool">
				<th width = 130 align=center>고등학교</th>
				<td>
					&nbsp;&nbsp;
					<input type="text" name="before_school">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>주  소</th>
				<td>
					&nbsp;&nbsp;
					<input type="text" name="zipcode1" size=5 readOnly onClick="goPost();">
					<input type="text" name="zipcode2" size=5 readOnly onClick="goPost();">
					<input type="button" name="post_find" value="우편번호 검색" 
					onClick="window.open('searchAddr.kh', 'win_page', 'toolbar=no, location=no, status=no,' 
							+'menubar=no, scrollbars=yes, resizable=no, left=300, top=100, width=600, height=400');"><br>
					&nbsp;&nbsp;
					<input type="text" name="addr1" size=30  readOnly onClick="goPost();"><br>
					&nbsp;&nbsp;
					<input type="text" name="addr2" size=30 onKeyUp="Address_CHECK(this.form)">
					<sub>(나머지 주소)</sub>
					<input type="hidden" name="address">
					<input type="hidden" name="post">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>E-Mail</th>
				<td>
					&nbsp;&nbsp;
					<input type="text" name="mail" size=15>
					<select name="mail_sel" onchange="e_mail_EVENT(this.form); email_sum();">
						<option selected value="" >직접입력</option>
						<option value="@naver.com">네이버</option>
						<option value="@daum.net">다음</option>
						<option value="@nate.com">네이트</option>
						<option value="@hanmail.net">한메일</option>
						<option value="@paran.com">파란</option>
						<option value="@empas.com">엠파스</option>
					</select>
					<input type="text" size=14 name="mail_address" onchange="email_sum();" onblur="email_sum();">
					
					<input type="hidden" name="e_mail">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>휴대전화</th>
				<td>
					&nbsp;&nbsp;
					<select name="tel_sel">
						<option value="KT" checked>KT</option>
						<option value="SKT">SKT</option>
						<option value="LGT">LGT</option>
					</select>
					<select name="phone_number_sel">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
					</select>
					<input type="text" name="phone1" size=7 value="">
					-
					<input type="text" name="phone2" size=7 value="" onkeyup="phone_CHECK(this.form)">
					<input type="hidden" name="s_phone">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40 id="bohoja">
				<th width = 130 align=center>보호자 연락처</th>
				<td>
					&nbsp;&nbsp;
					<select name="p_tel_sel">
						<option value="KT" checked>KT</option>
						<option value="SKT">SKT</option>
						<option value="LGT">LGT</option>
					</select>
					<select name="p_phone_number_sel">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
					</select>
					<input type="text" name="p_phone1" size=7 value="">
					-
					<input type="text" name="p_phone2" size=7 value="" onkeyup="p_phone_CHECK(this.form)">
					<input type="hidden" name="p_phone">
				</td>
			</tr>
			


<!--  이미지 숨김         -->		
			<tr bgcolor="BBEE99" height=170>
				<th width = 130 align=center>미리보기
				<td>
					<div id="def_img" align="center">
						<img src="/KH_School/upload/mem_img/pro2.jpg" style="width:130; height:150;">
					</div>
					<div id="pre_div" align="center" style="display:none;">
						<img id="preView" class="preView" style="width:130; height:150;">
					</div>
				</td>
			</tr>
			
			
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>프로필 사진</th>
				<td>
					&nbsp;&nbsp;
					<input type="file" name="upload" id="upload" accept="image/*" onChange="hideDefaultPic()">
					<br />
					&nbsp;&nbsp;
					<input type="button" name="delPic" value="사진 삭제" onClick="delpic(); coverPic(); imgPreview();">
				</td>
			</tr>
			<tr bgcolor="77CC55" height=40>
				<td width = 500 colspan=2 align=center>
					<input type="button" name="join" value="회원가입" onClick="enter();">
					<!--  <button name="join">회원가입</button>  -->
					<input type="reset" name="cancel" value="가입취소">
				</td>
			</tr>
		</table>
	</form>
</body>