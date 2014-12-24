	function body(){
		alert("body");
		
		var hide = document.getElementById("typeB"); // 교양 탭 숨김(default)
		hide.style.display = 'none';
		
	/* 	var c = document.getElementById("101");
		c.style.backgroundColor="blue"; */
		for(var i=0; i<=9; i++){
			var type = document.getElementsByName("q_type")[i].value;
			var code = document.getElementsByName("q_code")[i].value;
			var table = document.getElementsByName("q_table")[i].value;
			var name = document.getElementsByName("q_name")[i].value;
			var hakjum = document.getElementsByName("q_hakjum")[i].value;
			var professor = document.getElementsByName("q_professor")[i].value;
			
			document.getElementsByName("set_sch"+i)[0].value = type;
			document.getElementsByName(i)[0].value = name; /*과목 이름*/
			document.getElementsByName("code"+i)[0].value = code;
			document.getElementsByName("table"+i)[0].value = table;
			
			if(type == "e"){
				type="전 필";
			}else{
				type="전 선";
			}
			
			document.getElementsByName("subject"+i)[0].value = type; /*전선, 전필*/
			document.getElementsByName("hakjum"+i)[0].value = hakjum;
			document.getElementsByName("professor"+i)[0].value = professor;	
		}
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
	
	function ok(num){     // 같은 시간대에 수강신청이 되어있는지 확인
		var name = "sch_time"+num;
		var subject = "sugangsubject"+num;
		var value = document.getElementsByName(name);
		var check = 0;
		
		for(var i=0; i<value.length; i++){   			
			var sch = document.getElementsByName(name)[i].value;
			var c = document.getElementById(sch);
			var chk = document.getElementsByName("sch_"+sch)[0].value;
			if(chk != ""){
				check = check+1;
			}	
		}
		if(check == 0){
			add(num);
		}else{
			alert("수강 시간표를 확인하세요 !!");
		}
	}
	
	function add(num){
		var text = document.getElementsByName("suganglist")[num-1].value; // 과목
		var subject = document.getElementsByName("subjectlist")[num-1].value; // 구분
		var professor = document.getElementsByName("professorlist")[num-1].value; // 담당 교수
		var hakjum = document.getElementsByName("hakjumlist")[num-1].value; // 학점
		var code =  document.getElementsByName("l_code")[num-1].value; //과목코드
		var table =  document.getElementsByName("tablename")[num-1].value; //테이블 이름
		
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
				
				var codeName = "code"+i;
				document.getElementsByName(codeName)[0].value = code; // 과목 코드 insert
				
				var tableName = "table"+i;
				document.getElementsByName(tableName)[0].value = table; // 과목 코드 insert
				
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
				hakjum_check(i, num);  	// 학점 초과시 입력된 리스트의 자리수 num 를 보내 취소 시킨다
				var k = Number(i)+1;
				document.getElementsByName("set_sch"+k).value = num;
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
		document.getElementsByName("code"+name)[0].value = ""; //과목 코드 초기화
		
		hakjum_check(name);
		var k = Number(name)+1;
		var sch = document.getElementsByName("set_sch"+k).value;
		schedule_default(sch);
	
	}
	
	function schedule(num){
		var name = "sch_time"+num;
		var subject = "sugangsubject"+num;
		var value = document.getElementsByName(name);
		var j = (Math.round(Math.random()*6));
		
		for(var i=0; i<value.length; i++){   			// 시간표에 색 표시
			var sch = document.getElementsByName(name)[i].value;
			var c = document.getElementById(sch);
			var color = ["#FF5E00","FFBB00","FFE400","#ABF200","#1DDB16","#0054FF","#0100FF"];
			c.style.backgroundColor=color[j]; 
			
			document.getElementsByName("sch_"+sch)[0].value = document.getElementsByName(subject)[0].value;
		}
	}
	
	function schedule_default(num){	
		var name = "sch_time"+num;
		var value = document.getElementsByName(name);
		
		for(var i=0; i<value.length; i++){   			//시간표에 색  초기화
			var sch = document.getElementsByName(name)[i].value;
			var c = document.getElementById(sch); 
			c.style.backgroundColor="white"; 
			
			document.getElementsByName("sch_"+sch)[0].value = "";
		}
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
	
	setInterval("hideSubject()", 500); // 초 마다 자동 실행
	setInterval("hideButton()", 500); // 초 마다 자동 실행
	
	function selectRadio(select, m_code, y_grade, stu_num, stu_grade) {
		
		
		var param = "m_code="+m_code+"&y_grade="+y_grade+"&stu_num="+stu_num+"&stu_grade="+stu_grade;
		
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
		
		if (select == "major") {		
			xmlhttp.open("GET", "selectMajor.kh?"+param, true);			
		}
		if (select == "liberal") {
			xmlhttp.open("GET", "selectLiberal.kh", true);	
		}
		
		xmlhttp.send();
	}
	
	function hideButton(){
 		var list = document.getElementsByName("hakjumlist");
		for(var i=1; i<=list.length; i++){

				var Aname = "Abutton"+i;
				var Bname = "Bbutton"+i;
			
				var A = document.getElementById(Aname);
				var B = document.getElementById(Bname);
				
				B.style.display = 'none';
				A.style.display = 'block'; 
				
				var sum = Number(document.getElementsByName("hakjum_sum")[0].value) + Number(document.getElementsByName("hakjumlist")[i-1].value);
							
				if(sum > document.getElementsByName("highlimit_hakjum")[0].value ){  
					
					var Aname = "Abutton"+i;
					var Bname = "Bbutton"+i;
				
					var A = document.getElementById(Aname);
					var B = document.getElementById(Bname);
					
					B.style.display = 'block';
					A.style.display = 'none'; 
				
			} 
	
		} 
	}

	function hideSubject(){
	
		for(var i=0; i<=9; i++){
			var k = document.getElementsByName("code"+i)[0].value;
			var suganglist = document.getElementsByName("suganglist");
			
			if(k != ""){
				var chk_subject = document.getElementsByName("code"+i)[0].value;
			
				for(var k=1; k<=suganglist.length; k++){
				var num = Number(k-1); 
				var subject = document.getElementsByName("l_code")[num].value;
					if(chk_subject == subject){
						var hiddenNum = Number(num+1);
						var check = document.getElementById(hiddenNum);
						check.style.display = 'none';
					}  				
				 } 
			}	
		}  
	} 
	
	function chk_it(){
		var lowlimit_hakjum = Number(document.getElementsByName("lowlimit_hakjum")[0].value); // 최저 요구 학점
		var hakjum = Number(document.getElementsByName("hakjum_sum")[0].value); //신청한 학점
		
		if(hakjum < lowlimit_hakjum){
			alert("신청 학점이 모자랍니다.");
			return false;
		}else{
			return true;
		}
	}
	
	window.history.forward(); // 뒤로가기 방지