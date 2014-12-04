<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>

	function body(){
		var hide = document.getElementById("typeB"); // 교양 탭 숨김(default)
		hide.style.display = 'none';
		
	/* 	var c = document.getElementById("101");
		c.style.backgroundColor="blue"; */
	}
	
	function hakjum_check(num, sch){
		var sugang = document.getElementsByName("sugang"); //  배열로 담아 .length 1부터 시작하기때무에 -1
		var size = sugang.length -1;

		var hakjum_sum = 0;   				// 학점 덧셈
		for(var i=0; i<=size; i++){
			var hakjumName = "hakjum"+i;
			var hakjum = Number(document.getElementsByName(hakjumName)[0].value);
			 hakjum_sum += hakjum;	
		}
	
		if(hakjum_sum == 0){
			 hakjum_sum = "";
		}
	
		lowlimit_hakjum = Number(document.getElementsByName("lowlimit_hakjum")[0].value); // 최저 요구 학점
		highlimit_hakjum = Number(document.getElementsByName("highlimit_hakjum")[0].value); // 최고 요구 학점
		if(hakjum_sum > highlimit_hakjum){ // 요구 학점 확인 및 덧셈
			alert("최대 필요 학점이 초과했습니다.");
			no(num);	 			// 학점이 초과 했을때 신청 목록에서 자동 삭제	
		}else if(hakjum_sum < lowlimit_hakjum){
			alert("최소 필요 학점이 모자랍니다.");
			document.getElementsByName("hakjum_sum")[0].value = hakjum_sum;
			
			if( sch != null){
				schedule(sch);
			}
			
		}else{
			document.getElementsByName("hakjum_sum")[0].value = hakjum_sum;
			
			if( sch != null){
				schedule(sch);
			}
		}
		return;
	}
	
	function ok(num, sch){
		var text = document.getElementsByName("suganglist")[num-1].value; // 과목
		var subject = document.getElementsByName("subjectlist")[num-1].value; // 구분
		var professor = document.getElementsByName("professorlist")[num-1].value; // 담당 교수
		var hakjum = document.getElementsByName("hakjumlist")[num-1].value; // 학점
		
		var sugang = document.getElementsByName("sugang"); //  배열로 담아 .length 1부터 시작하기때무에 -1
		
		for(var i=0; i<=sugang.length; i++){	
			var value = document.getElementsByName(i)[0].value;
			
			if(value == ""){
				document.getElementsByName(i)[0].value = text; // 과목 insert
				
				var subjectName = "subject"+i;
				document.getElementsByName(subjectName)[0].value = subject; // 구분 insert
				
				var professorName = "professor"+i;
				document.getElementsByName(professorName)[0].value = professor; // 담당 교수  insert
				
				var hakjumName = "hakjum"+i;
				document.getElementsByName(hakjumName)[0].value = hakjum; // 학점 insert
				
				var check = document.getElementById(num);
				check.style.display = 'none';
				
				var subject_sum = document.getElementsByName("subject_sum")[0].value; // 과목수  덧셈
				if(subject_sum == ""){
					document.getElementsByName("subject_sum")[0].value = 1;
				}else{
					var sum = Number(document.getElementsByName("subject_sum")[0].value);
					sum = sum+1;
					document.getElementsByName("subject_sum")[0].value = sum;	
				}
				hakjum_check(i,sch);  	// 하점 초과시 입력된 리스트의 자리수 num 를 보내 취소 시킨다
				var k = Number(i)+1;
				document.getElementsByName("set_sch"+k).value = sch;
				break;
			}
		}
	}
	
	function no(name, sch){
		
		var text = document.getElementsByName(name)[0].value;
		var suganglist = document.getElementsByName("suganglist"); //  배열로 담아 .length 1부터 시작하기때무에 -1
		var size = suganglist.length -1;

		for(var i=0; i<=size; i++){
			var check = document.getElementsByName("suganglist")[i].value;

			if(check == text){
				var f = document.getElementsByName("checklist")[i].value;
				
				var show = document.getElementById(f);
				show.style.display = 'block';
						
				var sum = Number(document.getElementsByName("subject_sum")[0].value); // 과목수 뺄셈
				sum = sum-1;	
				if(sum <= 0){
					document.getElementsByName("subject_sum")[0].value = "";
				}else{
					document.getElementsByName("subject_sum")[0].value = sum;
				}
			}
		}
	
		document.getElementsByName(name)[0].value = "";	// 과목 초기화
		document.getElementsByName("subject"+name)[0].value = "";	// 구분 초기화
		document.getElementsByName("professor"+name)[0].value = ""; // 담당교수 초기화
		document.getElementsByName("hakjum"+name)[0].value = ""; // 학점 초기화
		
		hakjum_check(name);
		var k = Number(name)+1;
		var sch = document.getElementsByName("set_sch"+k).value;
		schedule_default(sch);
	
	}
	
	function schedule(sch){										
		var c = document.getElementById(sch); // 시간표에 색 표시
		c.style.backgroundColor="blue"; 
	}
	
	function schedule_default(sch){		
		var c = document.getElementById(sch);// 시간표에 색  초기화
		c.style.backgroundColor="white"; 	
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


		<!--        전체 테이블                     -->
<table border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
<tr><td rowspan="2">
	<form name="list">                              								 <!--     수강 할 과목  리스트               -->
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
				
	<c:forEach var="i" begin="1" end="10" step="1">                                 	 <!--     수강 할 과목  리스트               -->
		<table width="500" border="1" bordercolor="gray" cellpadding="3" cellspacing="0"  id="${i}">
			<tr>
				<td align="center" rowspan="2" width="50" bgcolor="#b1b1b1">
					<input type="button" value="신청 " onclick="ok('${i}',sch_time${i}.value)"/>
					
				</td>
				<td align="center" width="100"><font size="2">전 필</font>
					<input type="hidden" name="subjectlist" value="전 필"/>
				</td>
				<td align="center" width="120"><font size="2">
					<input type="hidden" id="suganglist" name="suganglist" value="${i}_과목"/>
					<input type="hidden" id="checklist" name="checklist" value="${i}"/>${i}_과목
					</font>
				</td>
				<td align="center"><font size="2">노 현태</font>
					<input type="hidden" name="professorlist" value="노 현태"/>
				</td>
				<td align="center" width="50"><font size="2">3</font>
					<input type="hidden" name="hakjumlist" value="3"/>
				</td>
			</tr>
			<tr>
				<td align="center"><font size="2">16 / 30</font></td>
				<td align="center"><font size="2"> E_강의실 </font></td>
				<td align="center" colspan="2"><font size="2">요일  / 시간</font>
					<input type="hidden" name="sch_time${i}" value="${100+i}"/>     <!--     요일  + 시간 = 시간표위치 값을 히든값으로 가져옴       -->
				</td>
				
			</tr>
		</table>
	</c:forEach>
</form>

</td>
<td height="400">	
	<form name='test'> 													       <!--     수강신청 한 리스트               -->
		<table  border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
			<tr>
				<td align="center" bgcolor="#b1b1b1"><font size="2"><b>신청과목 수</b></font></td>
				<td align="center"><input type="text" readonly="readonly" style="width:40; font-size: large; text-align: center;" name="subject_sum" ></td>
				<td align="center" bgcolor="#b1b1b1"><font size="2"><b>신청학점 (최저/학점/최고)</b></font></td>
				<td align="center">16/<input type="text" readonly="readonly" style="width:40; font-size: large; text-align: center;" name="hakjum_sum">/23
					<input type="hidden" name="lowlimit_hakjum" value="16"/>  <!--  최저 요구 학점     -->
					<input type="hidden" name="highlimit_hakjum" value="23"/>  <!--  최고 요구 학점     -->
				</td>
			</tr>
		</table>
		<table border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
			<tr>
				<td align="center" width="50"><font size="2"><b>구 분</b></font></td>
				<td align="center" width="120"><font size="2"><b>과 목</b></font></td>
				<td align="center" width="50"><font size="2"><b>학 점</b></font></td>
				<td align="center" width="80"><font size="2"><b>담당 교수</b></font></td>
				<td align="center" width="100"><font size="2"><b>비 고</b></font></td>
				<td align="center" width="50"></td>
			</tr>
		</table>
	<c:forEach var="i" begin="0" end="9" step="1">  	                  <!--     수강신청 한 리스트               -->
		<table border="1" bordercolor="gray" cellpadding="3" cellspacing="0" >
			<tr>
				<td align="center" width="50">
					<input type="hidden" name="sugang"/>
					<input type="hidden" name="set_sch${i}" />
					<input type="text" style="width:50; text-align: center;" readonly="readonly" name="subject${i}" /></td>
				<td align="center" width="120"><input type="text" style="width:120; text-align: center;" readonly="readonly" name="${i}" /></td>
				<td align="center" width="50"><input type="text" style="width:50; text-align: center;" readonly="readonly" name="hakjum${i}" /></td>
				<td align="center" width="80"><input type="text" style="width:80; text-align: center;" readonly="readonly" name="professor${i}" /></td>
				<td align="center" width="100"></td>
				<td align="center" width="50" bgcolor="#b1b1b1">
					<input type="button" value="취소" onclick="no('${i}',set_sch${i}.value)"/>
				</td>
			</tr>
		</table>
	</c:forEach>
</form>
</td></tr>
<tr>                 <!--    시간표             -->
	<td>
		<table align="center" border="1" bordercolor="gray" cellpadding="3" cellspacing="0">
		
			<tr>
				<td width="50"></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>월</b></font></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>화</b></font></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>수</b></font></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>목</b></font></td>
				<td width="70" bgcolor="#b1b1b1" align="center"><font size="2"><b>금</b></font></td>
			</tr>
			<c:forEach var="i" begin="1" end="12"  step="1">
				<tr>
					<td bgcolor="#b1b1b1" align="center"><font size="2"><b>${i}교시</b></font></td>
					<td id="${100+i}"><input type="text" readonly="readonly" style="width:70; text-align:center;" name="sch_${100+i}" /></td>
					<td id="${100+i}"><input type="text" readonly="readonly" style="width:70; text-align:center;" name="sch_${200+i}" /></td>
					<td id="${100+i}"><input type="text" readonly="readonly" style="width:70; text-align:center;" name="sch_${300+i}" /></td>
					<td id="${100+i}"><input type="text" readonly="readonly" style="width:70; text-align:center;" name="sch_${400+i}" /></td>
					<td id="${100+i}"><input type="text" readonly="readonly" style="width:70; text-align:center;" name="sch_${500+i}" /></td>
				</tr>
			</c:forEach>
				
		</table>
		
	</td>
</tr>
</table> <!--     전체 테이블             -->
	
</body>