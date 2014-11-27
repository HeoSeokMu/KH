<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<script type="text/javascript">
<!--
	function e_mail_EVENT(e_mail) {
		if(e_mail.mail_sel.options[0].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[0].value;
		} else if(e_mail.mail_sel.options[1].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[1].value;
		} else if(e_mail.mail_sel.options[2].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[2].value;
		} else if(e_mail.mail_sel.options[3].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[3].value;
		} else if(e_mail.mail_sel.options[4].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[4].value;
		} else if(e_mail.mail_sel.options[5].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[5].value;
		} else if(e_mail.mail_sel.options[6].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[6].value;
		}
	}
	
	function Address_CHECK(addr) {
		addr.address.value = addr.address1.value + addr.address2.value;
	}
	
	function email_CHECK(email) {
		email.e_mail.value = email.mail.value + email.mail_address.value;
	}
	
	function phone_CHECK(phone) {
		phone.phonenumber.value = phone.phone_number_sel.value + phone.phone_num1.value + phone.phone_num2.value;
	}
	
	function checkIt() {
        var user_input = eval("document.user_input");
        if(!user_input.id.value) {
            alert("ID를 입력하세요");
            return false;
        }
        
        if(!user_input.passwd.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(user_input.passwd.value != user_input.passwd2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
       
        if(!user_input.username.value) {
            alert("사용자 이름을 입력하세요");
            return false;
        }
        if(!user_input.jumin1.value  || !user_input.jumin2.value )
        {
            alert("주민등록번호를 입력하세요");
            return false;
        }
    }

    // 아이디 중복 여부를 판단
    function openConfirmid(user_input) {
        // 아이디를 입력했는지 검사
        if (user_input.id.value == "") {
            alert("아이디를 입력하세요");
            return;
        }
        
        // url과 사용자 입력 id를 조합합니다.
        // url을 사용하여 ConfirmId.jsp 에 접근 후 중복체크를 한다.
        url = "ConfirmId.jsp?id=" + user_input.id.value ;
        
        // 새로운 윈도우를 엽니다.
        open(url, "confirm", 
        "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300, height=200");
    }
	
//-->
</script>
    
<form action="insert.jsp" method="post" name="user_input">
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
				<th width=130 align=center>강의번호</th>
				<td width=360>
					&nbsp;&nbsp;
					<input type="text" name="id">
					<input type="button" name="id_check" value="중복검사" OnClick="openConfirmid(this.form)">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width=130 align=center>강의명</th>
				<td width=360>
					&nbsp;&nbsp;
					<input type="text" name="id">
					<input type="button" name="id_check" value="중복검사" OnClick="openConfirmid(this.form)">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>교 수</th>
				<td>
					&nbsp;&nbsp;
					<input type="password" name="password" maxlength=20>
					<sub>(20자 내)</sub>
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>학 기</th>
				<td>
					&nbsp;&nbsp;
					<input type="password" name="password_re" maxlength=20>
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>이수 학점</th>
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
					<input type="radio" name="sex" value="Women">여
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>주  소</th>
				<td>
					&nbsp;&nbsp;
					<input type="text" name="adress_num1" size=5>
					<input type="text" name="adress_num2" size=5>
					<input type="button" name="post_find" value="우편번호 검색"><br>
					&nbsp;&nbsp;
					<input type="text" name="address1" size=30 value=""><br>
					&nbsp;&nbsp;
					<input type="text" name="address2" size=30 value="" onchange="Address_CHECK(this.form)">
					<sub>(나머지 주소)</sub>
					<input type="hidden" name="address">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>E-Mail</th>
				<td>
					&nbsp;&nbsp;
					<input type="text" name="mail" size=15 value="">
					<select name="mail_sel" onchange="e_mail_EVENT(this.form)">
						<option selected value="" >직접입력</option>
						<option value="@naver.com">네이버</option>
						<option value="@daum.net">다음</option>
						<option value="@nate.com">네이트</option>
						<option value="@hanmail.net">한메일</option>
						<option value="@paran.com">파란</option>
						<option value="@empas.com">엠파스</option>
					</select>
					<input type="text" size=14 name="mail_address" onchange="email_CHECK(this.form)">
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
					<input type="text" name="phone_num1" size=7 value="">
					-
					<input type="text" name="phone_num2" size=7 value="" onchange="phone_CHECK(this.form)">
					<input type="hidden" name="phonenumber">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>관심분야</th>
				<td>
					&nbsp;&nbsp;
					<input type="checkbox" name="game" value="yes" checked>게임
					&nbsp;
					<input type="checkbox" name="shopping" value="yes">쇼핑
					&nbsp;
					<input type="checkbox" name="movie" value="yes">영화
					&nbsp;
					<input type="checkbox" name="read" value="yes">독서
					&nbsp;
					<input type="checkbox" name="soso" value="yes">기타
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=170>
				<th width = 130 align=center>자기소개<br>/<br>인사말</th>
				<td>
					&nbsp;&nbsp;
					<textarea name="appeal" rows="10" cols="46">
					</textarea>
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>프로필 사진</th>
				<td>
					&nbsp;&nbsp;
					<input type="file" name="file" value="file" size=32>
				</td>
			</tr>
			<tr bgcolor="77CC55" height=40>
				<td width = 500 colspan=2 align=center>
					<input type="submit" name="join" value="회원가입">
					<!--  <button name="join">회원가입</button>  -->
					<input type="reset" name="cancle" value="가입취소">
				</td>
			</tr>
		</table>
	</form>