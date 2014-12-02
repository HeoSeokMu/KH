<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

	function body(){
		
		var hide = document.getElementById("typeB");
		hide.style.display = 'none';
	}
	
	function ok(num){

		var text = document.getElementsByName("suganglist")[num-1].value;
		var sugang = document.getElementById("sugang").value;

		for(var i=0; i<=sugang.length; i++){	
			var value = document.getElementsByName(i)[0].value;
			
			if(value == ""){
				document.getElementsByName(i)[0].value = text;
				
				var check = document.getElementById(num);
				check.style.display = 'none';
				
				break;
			}
		}
	}
	
	function no(name){
		
		var text = document.getElementsByName(name)[0].value;
		var suganglist = document.getElementById("suganglist").value;
		
		for(var i=0; i<=suganglist.length; i++){
			var check = document.getElementsByName("suganglist")[i].value;
			
			if(check == text){
				var f = document.getElementsByName("checklist")[i].value;
				
				var show = document.getElementById(f);
				show.style.display = 'block';
			}
		}
		document.getElementsByName(name)[0].value = "";			
	}

	function thisA(){
		var A = document.getElementById("typeA");
		var B = document.getElementById("typeB");
		
		A.style.display = 'block';
		B.style.display = 'none';
	}
	function thisB(){
		var A = document.getElementById("typeA");
		var B = document.getElementById("typeB");
		
		B.style.display = 'block';
		A.style.display = 'none';
	}
</script>


<body onload="body()">
	
	<table width="500" border="1" bordercolor="gray" cellspacing="0" cellpadding="3">
		<tr height="30" bgcolor="#b1b1b1">
			<td align="center"><font size="2"><b>학 번</b></font></td>
			<td align="center"><font size="2"><b>학 과</b></font></td>
			<td align="center" width="50"><font size="2"><b>학 년</b></font></td>
			<td align="center"><font size="2"><b>이 름</b></font></td>
		</tr>
		<tr height="30">
			<td align="center"><font size="2">2014</font></td>
			<td align="center"><font size="2">A 과</font></td>
			<td align="center"><font size="2">1</font></td>
			<td align="center"><font size="2">홍 길동</font></td>
		</tr>
	</table>
	
<br/>

<form>
	<table width="500" border="1" bordercolor="gray" cellspacing="0" cellpadding="3">
		<tr>
			<td width="60"><font size="2"><b>전 공</b></font><input type="radio" id="A" name="A" value="" onclick="thisA()" checked /></td>
			<td width="60"><font size="2"><b>교 양</b></font><input type="radio" id="B" name="A" value="" onclick="thisB()"/></td>
			<td align="center" >
				<select name="">
					<option value="">검색 조건</option>
					<option value=""></option>
					<option value=""></option>
					<option value=""></option>	
				</select>
				<input type="search" name="search" />
				<input type="button" value="검 색"/>
			</td>
		</tr>
	</table>
<br/>	
	<table width="500" border="1" bordercolor="gray" cellspacing="0" cellpadding="3" id="typeA">
		<tr >
			<td width="150">
				<select name="">
					<option value="">과 선택 </option>
					<option value=""></option>
					<option value=""></option>
					<option value=""></option>
				</select>
				<font size="2"><b>학과 선택</b></font>
			</td>
			<td width="150">
				<select name="">
					<option value="">1 학년</option>
					<option value="">2 학년</option>
					<option value="">3 학년</option>
					<option value="">4 학년</option>
				</select>
				<font size="2"><b>학년 선택</b></font>
			</td>
			<td>
				<input type="button" value="확 인"/>
			</td>
		</tr>
	</table>
	
	<table width="500" border="1" bordercolor="gray" cellspacing="0" cellpadding="3" id="typeB">
		<tr>
			<td width="150">
				<select name="">
					<option value="">선 택</option>
					<option value=""></option>
					<option value=""></option>
					<option value=""></option>
				</select>
				<font size="2"><b>구분 선택</b></font>
			</td>
			<td width="150">
				<select name="">
					<option value="">선 택</option>
					<option value=""></option>
					<option value=""></option>
					<option value=""></option>
				</select>
				<font size="2"><b>계열 선택</b></font>
			</td>
			<td>
				<input type="button" value="확 인"/>
			</td>
		</tr>
	</table>
</form>

	<form name="list">
		<table width="500" border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
			<tr>
				<td rowspan="2" width="50"></td>
				<td align="center" width="100" bgcolor="#b1b1b1"><font size="2"><b>구 분</b></font></td>
				<td align="center" width="130" bgcolor="#b1b1b1"><font size="2"><b>과 목</b></font></td>
				<td align="center" bgcolor="#b1b1b1"><font size="2"><b>담당 교수</b></font></td>
				<td align="center" width="50" bgcolor="#b1b1b1"><font size="2"><b>학 점</b></font></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#b1b1b1"><font size="2"><b>인 원 (현재/총)</b></font></td>
				<td align="center" bgcolor="#b1b1b1"><font size="2"><b>강의실</b></font></td>
				<td align="center" colspan="2" bgcolor="#b1b1b1"><font size="2"><b>요일 / 시간</b></font></td>
				
			</tr>
		</table>
<br/>
				
	<c:forEach var="i" begin="1" end="5" step="1">
		<table width="500" border="1" bordercolor="gray" cellpadding="3" cellspacing="0"  id="${i}">
			<tr>
				<td align="center" rowspan="2" width="50" bgcolor="#b1b1b1">
					<input type="button" value="신청 " onclick="ok('${i}')"/>
					
				</td>
				<td align="center" width="100"><font size="2">전 필</font></td>
				<td align="center" width="120"><font size="2">
					<input type="hidden" id="suganglist" name="suganglist" value="${i}_과목"/>
					<input type="hidden" id="checklist" name="checklist" value="${i}"/>${i}_과목
					</font>
				</td>
				<td align="center"><font size="2">노 현태</font></td>
				<td align="center" width="50"><font size="2">3</font></td>
			</tr>
			<tr>
				<td align="center"><font size="2">16 / 30</font></td>
				<td align="center"><font size="2"> E_강의실 </font></td>
				<td align="center" colspan="2"><font size="2">요일  / 시간</font></td>
				
			</tr>
		</table>
	</c:forEach>
</form>
	
	<form name='test'>
		<table  border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
			<tr>
				<td  bgcolor="#b1b1b1"><font size="2"><b>신청 과목 수</b></font></td>
				<td><input type="text" readonly="readonly" style="width:40" name=""></td>
				<td  bgcolor="#b1b1b1"><font size="2"><b>신청 학점(최저/학점/최고)</b></font></td>
				<td>16/<input type="text" readonly="readonly" style="width:40" name="">/23</td>
			</tr>
		</table>
		<table border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
			<tr>
				<td align="center" width="50"><font size="2"><b>구 분</b></font></td>
				<td align="center" width="120"><font size="2"><b>과 목</b></font></td>
				<td align="center" width="50"><font size="2"><b>학 점</b></font></td>
				<td align="center" width="80"><font size="2"><b>담당 교수</b></font></td>
				<td align="center" width="50"><font size="2"><b>비 고</b></font></td>
				<td align="center" width="50"></td>
			</tr>
		</table>
	<c:forEach var="i" begin="0" end="5" step="1">
		<table>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<input type="button" value="취소" onclick="no(0)"/>
					<input type="text" id="sugang" name="0" />
				</td>
			</tr>
		</table>
	</c:forEach>
<!-- 			<tr>
				<td>
					<input type="button" value="취소" onclick="no(1)"/>
					<input type="text" id="sugang" name="1" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="취소" onclick="no(2)"/>
					<input type="text" id="sugang" name="2" />
				</td>
			</tr>
		</table> -->
	</form>
	
</body>