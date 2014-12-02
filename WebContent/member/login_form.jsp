<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
<title>�α���</title>

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

<script language="javascript">
	function focusIt() {
		if("${cooId}"==""){
			document.inform.loginCheck.checked = false;
		}else{
			document.inform.loginCheck.checked = true;
			
		}
		if("${check}"==1){
			alert("���̵� �Ǵ� �н����尡 Ʋ�Ƚ��ϴ�.");
		}else if("${check}"=="delete"){
			alert("ȸ��Ż�� �Ǽ̽��ϴ�.");
		}else{
			document.inform.id.focus();
		}
	}

	function checkIt() {
		inputForm = eval("document.inform");
		if (!inputForm.id.value) {
			alert("���̵� �Է��ϼ���..");
			inputForm.id.focus();
			return false;
		}
		if (!inputForm.passwd.value) {
			alert("�н����带 �Է��ϼ���..");
			inputForm.passwd.focus();
			return false;
		}
		return ture;
	}
	function bbusic_main() {
        document.bbu.action = "bbusic.action";
        document.bbu.submit();
     }

</script>
</head>
<body onLoad="focusIt();">
	<c:if test="${session.memId == null}">
		<form name="inform" method="post" action="loginPro.action"	onSubmit="return checkIt();">
			<table class="tablepadding" align="center" cellspacing="10">
				<tr>
					<td>
						<input type="text" name="id" value="${cooId}" class="input" placeholder="���̵�" maxlength="10"/>
					</td>
					<td rowspan="2">
						<input type="submit" class="login" name="Submit" value="�α���"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" name="passwd" placeholder="�н�����" class="input" maxlength="10"/>
					</td>
				</tr>
				<tr>
						<td colspan="2" class="lineX">
						<font style="font-size: 8pt">
						<input type="checkbox" name="loginCheck" value="check"/>���̵�����
						&nbsp;<a href="findIdForm.action" title="���̵�/��й�ȣ ã��" style="color: gray;">���̵�/��й�ȣ ã��</a>
						&nbsp;<a href="agreement.action" title="ȸ������" style="color: gray;"><strong>ȸ������</strong></a>
						</font>
					</td>
				</tr>
			</table>
		</form>
	</c:if>

	<c:if test="${session.memId != null}">
		<table class="tablepadding" cellspacing="10" style="height: 135px;" align="center">
			<tr>
				<td>
					<strong><a href="javascript:window.location='modify.action'" style="color: black;"><c:out value="${session.memId}"/></a>��</strong>
				</td>
				<td>
					<a href="javascript:window.location='modify.action'" style="color: gray;">������</a>
					<a href="javascript:window.location='logout.action'" style="color: gray;">�α׾ƿ�</a>
					<br/>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
	 								<c:if test="${myinfo_DTO.delete_payname == null}">������ ��ǰ�� �����ϴ�.</c:if>
					   				<c:if test="${myinfo_DTO.delete_payname != null}">${myinfo_DTO.delete_payname}</c:if>
					<a href="#"><img value="��ǰ����" name="payment" /></a><br/>
				</td>
			</tr>
			<tr>
				<td>
				ĳ�� 
	 					<c:if test="${myinfo_DTO.delete_cash == null}">0</c:if>
					   	<c:if test="${myinfo_DTO.delete_cash != null}">${myinfo_DTO.delete_cash}</c:if>
				</td>
				<c:if test="${session.memId == 'admin1'}">
					<td align="right">
						<a href="javascript:window.location='admin.action'">������ ������</a>
					</td>
				</c:if>
			</tr>
		</table>
	</c:if>
</body>
</html>