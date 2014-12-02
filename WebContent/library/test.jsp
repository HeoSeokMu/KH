<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<form action="inputNumForm.kh" name="userinput" method="post">
	책번호<input type="text" name="b_num" /><br/>
	책제목<input type="text" name="b_name" /><br/>
	<input type="submit" value="책번호 입력"/>
</form>

<form action="reserveForm.kh" method="post">
	책번호<input type="text" name="b_num" /><br/>
	책제목<input type="text" name="b_name" /><br/>
	<input type="submit" value="책번호 입력"/>
</form>

