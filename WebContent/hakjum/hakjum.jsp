<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:forEach var="list" items="${list}">
	db_seq : ${list.num } <br/>
	구분 : ${list.type } <br/>
	과목 코드 : ${list.code } <br/>
	과목 : ${list.name } <br/>
	교수  : ${list.professor } <br/>
	교수 코드 : ${list.p_code } <br/>
	학년 : ${list.s_grade } <br/>
	수강생 : ${list.s_name } <br/>
	수강생 학번 : ${list.s_code } <br/>
	학점 : ${list.f_grade } <br/>
	결과 A : ${list.resultA } <br/>
	결과 B : ${list.resultB }<br/>
	수강 이수 여부 : ${list.chk } <br/>
	
---------------------------------------------------- <br/>
	
</c:forEach> --%>

<%-- 

<c:forEach var="list" items="${list}">

<table border="1" cellspacing="0" cellpadding="3" bordercolor="gray" >
	<tr>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>구 분</b></font></td>
		<td align="center" width="80">${list.type }</td>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>과 목</b></font></td>
		<td align="center" width="130"> ${list.name }</td>
		<td bgcolor="#b1b1b1" align="center"  width="130"><font size="2"><b>담당 교수</b></font></td>
		<td align="center"  width="100">${list.professor }</td>
	</tr>
</table>

<table border="1" cellspacing="0" cellpadding="3" bordercolor="gray" >

	<tr>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>학 번</b></font></td>
		<td align="center" width="150">${list.s_code }</td>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>학 년</b></font></td>
		<td align="center" width="50">${list.s_grade }</td>
		<td bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>이 름</b></font></td>
		<td align="center" width="100">${list.s_name }</td>
		<td bgcolor="#b1b1b1" align="center"><font size="2"><b>A</b></font></td>
		<td><input type="text" style="width:80; text-align: center; font-size: large;" name="resultA"></td>
		<td><input type="checkbox" name="chk" value="${list.num }"></td>
		<td bgcolor="#b1b1b1" align="center"><font size="2"><b>B</b></font></td>
		<td><input type="text" style="width:80; text-align: center; font-size: large;" name="resultB"></td>
	</tr>

</table>

<br/>

</c:forEach> 

				--%>

<script>
function select(code) {
	
	var param = "code="+code;
	
	var xmlhttp;
	
	if (window.XMLHttpRequest) {  
		xmlhttp = new XMLHttpRequest(); //  IE7+, Firefox, Chrome, Opera, Safari
	} else {    
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");  // IE6, IE5 
	}
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("selected").innerHTML = xmlhttp.responseText;	
		}
	};
	
	xmlhttp.open("GET", "hakjumPro.kh?"+param, true);			
		
	xmlhttp.send();
}

function result(num){
		
		var nameA = "A"+num;
		var nameB = "B"+num;
		var number = document.getElementsByName(nameA)[0].value;
		
		if(number >= 90){
			document.getElementsByName(nameB)[0].value = "A";		
		}else if(number >= 80){
			document.getElementsByName(nameB)[0].value = "B";	
		}else if(number >= 70){
			document.getElementsByName(nameB)[0].value = "C";
		}else if(number <= 60){
			document.getElementsByName(nameB)[0].value = "D";
		}
}


</script>

<table border="1" cellspacing="0" cellpadding="3" bordercolor="gray" >
	<tr>
		<td bgcolor="#b1b1b1" align="center"  width="130"><font size="2"><b>담당 교수</b></font></td>
		<td align="center"  width="100">${memdto.name}</td>
	</tr>
</table>

<br/>

<table border="1" cellspacing="0" cellpadding="3" bordercolor="gray" >

	<tr >
		<td colspan="10" bgcolor="#b1b1b1" align="center" width="80"><font size="2"><b>강의 과목</b></font></td>
	</tr>
	
	<tr >
		<c:forEach var="list" items="${list}">
			
				<td align="center" width="150">
					<a onclick="select('${list.code}')">${list.name}</a>	
				</td>
			
		</c:forEach> 
	</tr>
	
</table>

<br/>


		<div id="selected">
		
		</div>








