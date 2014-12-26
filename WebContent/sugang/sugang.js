	function body(){
		
		var hide = document.getElementById("typeB"); // ���� �� ����(default)
		hide.style.display = 'none';
		
	/* 	var c = document.getElementById("101");
		c.style.backgroundColor="blue"; */
		
		var hakjum_sum = document.getElementsByName("get_hakjum_sum")[0].value; // �� ����
		if(hakjum_sum > 0){
			document.getElementsByName("hakjum_sum")[0].value = hakjum_sum;
		}
		
		for(var i=0; i<=9; i++){
			var type = document.getElementsByName("q_type")[i].value;
			var code = document.getElementsByName("q_code")[i].value;
			var table = document.getElementsByName("q_table")[i].value;
			var name = document.getElementsByName("q_name")[i].value;
			var hakjum = document.getElementsByName("q_hakjum")[i].value;
			var professor = document.getElementsByName("q_professor")[i].value;
			
			var day = document.getElementsByName("q_day")[i].value;
			var sch = document.getElementsByName("q_sch")[i].value;
			var time = document.getElementsByName("q_time")[i].value;
			
			var num = document.getElementsByName("num")[i].value;
			
			document.getElementsByName(i)[0].value = name; /*���� �̸�*/
			document.getElementsByName("code"+i)[0].value = code;
			document.getElementsByName("table"+i)[0].value = table;
			
			document.getElementsByName("set_sch"+i)[0].value = num;
			
			if(type == "e"){
				type="�� ��";
			}else{
				type="�� ��";
			}
			
			document.getElementsByName("subject"+i)[0].value = type; /*����, ����*/
			document.getElementsByName("hakjum"+i)[0].value = hakjum;
			document.getElementsByName("professor"+i)[0].value = professor;	
			
			var j = (Math.round(Math.random()*6));
			
			for(var k=0; k<time; k++){   			// �ð�ǥ�� �� ǥ��
				var i_sch = Number(day)+Number(sch)+Number(k);
				var c = document.getElementById(i_sch);
				var color = ["#FF5E00","FFBB00","FFE400","#ABF200","#1DDB16","#0054FF","#0100FF"];
				c.style.backgroundColor=color[j]; 
				
				document.getElementsByName("sch_"+i_sch)[0].value = name;
			}
		}
	}
	
	function hakjum_check(num, sch){
		
		var sugang = document.getElementsByName("sugang"); //  �迭�� ��� .length 1���� �����ϱ⶧���� -1
		var size = sugang.length -1;

		var hakjum_sum = 0;   				// ���� ����
		for(var i=0; i<=size; i++){
			var hakjumName = "hakjum"+i;
			var hakjum = Number(document.getElementsByName(hakjumName)[0].value);
			 hakjum_sum += hakjum;	
		}
	
		if(hakjum_sum == 0){
			 hakjum_sum = "";
		}
	
		lowlimit_hakjum = Number(document.getElementsByName("lowlimit_hakjum")[0].value); // ���� �䱸 ����
		highlimit_hakjum = Number(document.getElementsByName("highlimit_hakjum")[0].value); // �ְ� �䱸 ����
		if(hakjum_sum > highlimit_hakjum){ // �䱸 ���� Ȯ�� �� ����
			alert("�ִ� �ʿ� ������ �ʰ��߽��ϴ�.");
			no(num);	 			// ������ �ʰ� ������ ��û ��Ͽ��� �ڵ� ����	
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
	
	function ok(num){     // ���� �ð��뿡 ������û�� �Ǿ��ִ��� Ȯ��
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
			alert("���� �ð�ǥ�� Ȯ���ϼ��� !!");
		}
	}
	
	function add(num){
		var text = document.getElementsByName("suganglist")[num-1].value; // ����
		var subject = document.getElementsByName("subjectlist")[num-1].value; // ����
		var professor = document.getElementsByName("professorlist")[num-1].value; // ��� ����
		var hakjum = document.getElementsByName("hakjumlist")[num-1].value; // ����
		var code =  document.getElementsByName("l_code")[num-1].value; //�����ڵ�
		var table =  document.getElementsByName("tablename")[num-1].value; //���̺� �̸�
		
		var sugang = document.getElementsByName("sugang"); //  �迭�� ��� .length 1���� �����ϱ⶧���� -1
		
		for(var i=0; i<=sugang.length; i++){	
			var value = document.getElementsByName(i)[0].value;
			
			if(value == ""){
				document.getElementsByName(i)[0].value = text; // ���� insert
				
				var subjectName = "subject"+i;
				document.getElementsByName(subjectName)[0].value = subject; // ���� insert
				
				var professorName = "professor"+i;
				document.getElementsByName(professorName)[0].value = professor; // ��� ����  insert
				
				var hakjumName = "hakjum"+i;
				document.getElementsByName(hakjumName)[0].value = hakjum; // ���� insert
				
				var codeName = "code"+i;
				document.getElementsByName(codeName)[0].value = code; // ���� �ڵ� insert
				
				var tableName = "table"+i;
				document.getElementsByName(tableName)[0].value = table; // ���� �ڵ� insert
				
				var check = document.getElementById(num);
				check.style.display = 'none';
				
				
				var subject_sum = document.getElementsByName("subject_sum")[0].value; // �����  ����
				if(subject_sum == ""){
					document.getElementsByName("subject_sum")[0].value = 1;
				}else{
					var sum = Number(document.getElementsByName("subject_sum")[0].value);
					sum = sum+1;
					document.getElementsByName("subject_sum")[0].value = sum;	
				}
				hakjum_check(i, num);  	// ���� �ʰ��� �Էµ� ����Ʈ�� �ڸ��� num �� ���� ��� ��Ų��
				var k = Number(i);	
				document.getElementsByName("set_sch"+k)[0].value = num;
				break;
			}
		}
	}
	
	function no(name, sch){
			
		var text = document.getElementsByName(name)[0].value;

		if(text != ""){
			var sum = Number(document.getElementsByName("subject_sum")[0].value); // ����� ����
			sum = sum-1;	
			if(sum <= 0){
				document.getElementsByName("subject_sum")[0].value = "";
			}else{
				document.getElementsByName("subject_sum")[0].value = sum;
			}
		}
		
		var suganglist = document.getElementsByName("suganglist"); //  �迭�� ��� .length 1���� �����ϱ⶧���� -1
		var size = suganglist.length -1;

		for(var i=0; i<=size; i++){
			var check = document.getElementsByName("suganglist")[i].value;

			if(check == text ){
				var f = document.getElementsByName("checklist")[i].value;
				
				var show = document.getElementById(f);
				show.style.display = 'block';
						
/*				var sum = Number(document.getElementsByName("subject_sum")[0].value); // ����� ����
				sum = sum-1;	
				if(sum <= 0){
					document.getElementsByName("subject_sum")[0].value = "";
				}else{
					document.getElementsByName("subject_sum")[0].value = sum;
				}*/
			}
		}
	
		document.getElementsByName(name)[0].value = "";	// ���� �ʱ�ȭ
		document.getElementsByName("subject"+name)[0].value = "";	// ���� �ʱ�ȭ
		document.getElementsByName("professor"+name)[0].value = ""; // ��米�� �ʱ�ȭ
		document.getElementsByName("hakjum"+name)[0].value = ""; // ���� �ʱ�ȭ
		document.getElementsByName("code"+name)[0].value = ""; //���� �ڵ� �ʱ�ȭ
		
		hakjum_check(name);
		var k = Number(name);
		var sch = document.getElementsByName("set_sch"+k)[0].value;
		schedule_default(sch);
	
	}
	
	function schedule(num){
		var name = "sch_time"+num;
		var subject = "sugangsubject"+num;
		var value = document.getElementsByName(name);
		var j = (Math.round(Math.random()*6));
		
		for(var i=0; i<value.length; i++){   			// �ð�ǥ�� �� ǥ��
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
		
		if(value.length == 0){
			name = "q_sch_time"+num;
			value = document.getElementsByName(name);
		}
		
		for(var i=0; i<value.length; i++){   			//�ð�ǥ�� ��  �ʱ�ȭ
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
	
	setInterval("hideSubject()", 500); // �� ���� �ڵ� ����
	setInterval("hideButton()", 500); // �� ���� �ڵ� ����
	
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
		var lowlimit_hakjum = Number(document.getElementsByName("lowlimit_hakjum")[0].value); // ���� �䱸 ����
		var hakjum = Number(document.getElementsByName("hakjum_sum")[0].value); //��û�� ����
		
		if(hakjum < lowlimit_hakjum){
			alert("��û ������ ���ڶ��ϴ�.");
			return false;
		}else{
			return true;
		}
	}
	
	window.history.forward(); // �ڷΰ��� ����