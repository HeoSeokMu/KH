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
            alert("ID�� �Է��ϼ���");
            return false;
        }
        
        if(!user_input.passwd.value ) {
            alert("��й�ȣ�� �Է��ϼ���");
            return false;
        }
        if(user_input.passwd.value != user_input.passwd2.value)
        {
            alert("��й�ȣ�� �����ϰ� �Է��ϼ���");
            return false;
        }
       
        if(!user_input.username.value) {
            alert("����� �̸��� �Է��ϼ���");
            return false;
        }
        if(!user_input.jumin1.value  || !user_input.jumin2.value )
        {
            alert("�ֹε�Ϲ�ȣ�� �Է��ϼ���");
            return false;
        }
    }

    // ���̵� �ߺ� ���θ� �Ǵ�
    function openConfirmid(user_input) {
        // ���̵� �Է��ߴ��� �˻�
        if (user_input.id.value == "") {
            alert("���̵� �Է��ϼ���");
            return;
        }
        
        // url�� ����� �Է� id�� �����մϴ�.
        // url�� ����Ͽ� ConfirmId.jsp �� ���� �� �ߺ�üũ�� �Ѵ�.
        url = "ConfirmId.jsp?id=" + user_input.id.value ;
        
        // ���ο� �����츦 ���ϴ�.
        open(url, "confirm", 
        "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=300, height=200");
    }
	
//-->
</script>
    
<form action="insert.jsp" method="post" name="user_input">
		<table border=1 align="center">
			<tr bgcolor="77CC55" height=50>
				<td colspan=4 align=center><font size=6 face="�޸տ���ü"><b>ȸ������ ���</b></font>
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
				<th width=130 align=center>���ǹ�ȣ</th>
				<td width=360>
					&nbsp;&nbsp;
					<input type="text" name="id">
					<input type="button" name="id_check" value="�ߺ��˻�" OnClick="openConfirmid(this.form)">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width=130 align=center>���Ǹ�</th>
				<td width=360>
					&nbsp;&nbsp;
					<input type="text" name="id">
					<input type="button" name="id_check" value="�ߺ��˻�" OnClick="openConfirmid(this.form)">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>�� ��</th>
				<td>
					&nbsp;&nbsp;
					<input type="password" name="password" maxlength=20>
					<sub>(20�� ��)</sub>
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>�� ��</th>
				<td>
					&nbsp;&nbsp;
					<input type="password" name="password_re" maxlength=20>
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>�̼� ����</th>
				<td>
					&nbsp;&nbsp;
					<input type="text" name="name">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>��  ��</th>
				<td>
					&nbsp;&nbsp;
					<input type="radio" name="sex" value="Man" checked>��&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="Women">��
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>��  ��</th>
				<td>
					&nbsp;&nbsp;
					<input type="text" name="adress_num1" size=5>
					<input type="text" name="adress_num2" size=5>
					<input type="button" name="post_find" value="�����ȣ �˻�"><br>
					&nbsp;&nbsp;
					<input type="text" name="address1" size=30 value=""><br>
					&nbsp;&nbsp;
					<input type="text" name="address2" size=30 value="" onchange="Address_CHECK(this.form)">
					<sub>(������ �ּ�)</sub>
					<input type="hidden" name="address">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>E-Mail</th>
				<td>
					&nbsp;&nbsp;
					<input type="text" name="mail" size=15 value="">
					<select name="mail_sel" onchange="e_mail_EVENT(this.form)">
						<option selected value="" >�����Է�</option>
						<option value="@naver.com">���̹�</option>
						<option value="@daum.net">����</option>
						<option value="@nate.com">����Ʈ</option>
						<option value="@hanmail.net">�Ѹ���</option>
						<option value="@paran.com">�Ķ�</option>
						<option value="@empas.com">���Ľ�</option>
					</select>
					<input type="text" size=14 name="mail_address" onchange="email_CHECK(this.form)">
					<input type="hidden" name="e_mail">
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>�޴���ȭ</th>
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
				<th width = 130 align=center>���ɺо�</th>
				<td>
					&nbsp;&nbsp;
					<input type="checkbox" name="game" value="yes" checked>����
					&nbsp;
					<input type="checkbox" name="shopping" value="yes">����
					&nbsp;
					<input type="checkbox" name="movie" value="yes">��ȭ
					&nbsp;
					<input type="checkbox" name="read" value="yes">����
					&nbsp;
					<input type="checkbox" name="soso" value="yes">��Ÿ
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=170>
				<th width = 130 align=center>�ڱ�Ұ�<br>/<br>�λ縻</th>
				<td>
					&nbsp;&nbsp;
					<textarea name="appeal" rows="10" cols="46">
					</textarea>
				</td>
			</tr>
			<tr bgcolor="BBEE99" height=40>
				<th width = 130 align=center>������ ����</th>
				<td>
					&nbsp;&nbsp;
					<input type="file" name="file" value="file" size=32>
				</td>
			</tr>
			<tr bgcolor="77CC55" height=40>
				<td width = 500 colspan=2 align=center>
					<input type="submit" name="join" value="ȸ������">
					<!--  <button name="join">ȸ������</button>  -->
					<input type="reset" name="cancle" value="�������">
				</td>
			</tr>
		</table>
	</form>