	function body(){
		
<<<<<<< HEAD
		var hide = document.getElementById("typeB"); // ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½(default)
=======
		var hide = document.getElementById("typeB"); // ±³¾ç ÅÇ ¼û±è(default)
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
		hide.style.display = 'none';
		
	/* 	var c = document.getElementById("101");
		c.style.backgroundColor="blue"; */
		
<<<<<<< HEAD
		var hakjum_sum = document.getElementsByName("get_hakjum_sum")[0].value; // ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
=======
		var hakjum_sum = document.getElementsByName("get_hakjum_sum")[0].value; // ÃÑ ÇÐÁ¡
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
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
			
<<<<<<< HEAD
			document.getElementsByName(i)[0].value = name; /*ï¿½ï¿½ï¿½ï¿½ ï¿½Ì¸ï¿½*/
=======
			document.getElementsByName(i)[0].value = name; /*°ú¸ñ ÀÌ¸§*/
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
			document.getElementsByName("code"+i)[0].value = code;
			document.getElementsByName("table"+i)[0].value = table;
			
			document.getElementsByName("set_sch"+i)[0].value = num;
			
			if(type == "e"){
<<<<<<< HEAD
				type="ï¿½ï¿½ ï¿½ï¿½";
=======
				type="Àü ÇÊ";
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
			}else{
<<<<<<< HEAD
				type="ï¿½ï¿½ ï¿½ï¿½";
=======
				type="Àü ¼±";
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
			}
			
<<<<<<< HEAD
			document.getElementsByName("subject"+i)[0].value = type; /*ï¿½ï¿½ï¿½ï¿½, ï¿½ï¿½ï¿½ï¿½*/
=======
			document.getElementsByName("subject"+i)[0].value = type; /*Àü¼±, ÀüÇÊ*/
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
			document.getElementsByName("hakjum"+i)[0].value = hakjum;
			document.getElementsByName("professor"+i)[0].value = professor;	
			
			var j = (Math.round(Math.random()*6));
			
<<<<<<< HEAD
			for(var k=0; k<time; k++){   			// ï¿½Ã°ï¿½Ç¥ï¿½ï¿½ ï¿½ï¿½ Ç¥ï¿½ï¿½
=======
			for(var k=0; k<time; k++){   			// ½Ã°£Ç¥¿¡ »ö Ç¥½Ã
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				var i_sch = Number(day)+Number(sch)+Number(k);
				var c = document.getElementById(i_sch);
				var color = ["#FF5E00","FFBB00","FFE400","#ABF200","#1DDB16","#0054FF","#0100FF"];
				c.style.backgroundColor=color[j]; 
				
				document.getElementsByName("sch_"+i_sch)[0].value = name;
			}
		}
	}
	
	function hakjum_check(num, sch){
		
<<<<<<< HEAD
		var sugang = document.getElementsByName("sugang"); //  ï¿½è¿­ï¿½ï¿½ ï¿½ï¿½ï¿½ .length 1ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï±â¶§ï¿½ï¿½ï¿½ï¿½ -1
=======
		var sugang = document.getElementsByName("sugang"); //  ¹è¿­·Î ´ã¾Æ .length 1ºÎÅÍ ½ÃÀÛÇÏ±â¶§¹«¿¡ -1
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
		var size = sugang.length -1;

<<<<<<< HEAD
		var hakjum_sum = 0;   				// ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
=======
		var hakjum_sum = 0;   				// ÇÐÁ¡ µ¡¼À
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
		for(var i=0; i<=size; i++){
			var hakjumName = "hakjum"+i;
			var hakjum = Number(document.getElementsByName(hakjumName)[0].value);
			 hakjum_sum += hakjum;	
		}
	
		if(hakjum_sum == 0){
			 hakjum_sum = "";
		}
	
<<<<<<< HEAD
		lowlimit_hakjum = Number(document.getElementsByName("lowlimit_hakjum")[0].value); // ï¿½ï¿½ï¿½ï¿½ ï¿½ä±¸ ï¿½ï¿½ï¿½ï¿½
		highlimit_hakjum = Number(document.getElementsByName("highlimit_hakjum")[0].value); // ï¿½Ö°ï¿½ ï¿½ä±¸ ï¿½ï¿½ï¿½ï¿½
		if(hakjum_sum > highlimit_hakjum){ // ï¿½ä±¸ ï¿½ï¿½ï¿½ï¿½ È®ï¿½ï¿½ ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
			alert("ï¿½Ö´ï¿½ ï¿½Ê¿ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ê°ï¿½ï¿½ß½ï¿½ï¿½Ï´ï¿½.");
			no(num);	 			// ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ê°ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½Ã» ï¿½ï¿½Ï¿ï¿½ï¿½ï¿½ ï¿½Úµï¿½ ï¿½ï¿½ï¿½ï¿½	
=======
		lowlimit_hakjum = Number(document.getElementsByName("lowlimit_hakjum")[0].value); // ÃÖÀú ¿ä±¸ ÇÐÁ¡
		highlimit_hakjum = Number(document.getElementsByName("highlimit_hakjum")[0].value); // ÃÖ°í ¿ä±¸ ÇÐÁ¡
		if(hakjum_sum > highlimit_hakjum){ // ¿ä±¸ ÇÐÁ¡ È®ÀÎ ¹× µ¡¼À
			alert("ÃÖ´ë ÇÊ¿ä ÇÐÁ¡ÀÌ ÃÊ°úÇß½À´Ï´Ù.");
			no(num);	 			// ÇÐÁ¡ÀÌ ÃÊ°ú ÇßÀ»¶§ ½ÅÃ» ¸ñ·Ï¿¡¼­ ÀÚµ¿ »èÁ¦	
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
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
	
<<<<<<< HEAD
	function ok(num){     // ï¿½ï¿½ï¿½ï¿½ ï¿½Ã°ï¿½ï¿½ë¿¡ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ã»ï¿½ï¿½ ï¿½Ç¾ï¿½ï¿½Ö´ï¿½ï¿½ï¿½ È®ï¿½ï¿½
=======
	function ok(num){     // °°Àº ½Ã°£´ë¿¡ ¼ö°­½ÅÃ»ÀÌ µÇ¾îÀÖ´ÂÁö È®ÀÎ
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
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
<<<<<<< HEAD
			alert("ï¿½ï¿½ï¿½ï¿½ ï¿½Ã°ï¿½Ç¥ï¿½ï¿½ È®ï¿½ï¿½ï¿½Ï¼ï¿½ï¿½ï¿½ !!");
=======
			alert("¼ö°­ ½Ã°£Ç¥¸¦ È®ÀÎÇÏ¼¼¿ä !!");
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
		}
	}
	
	function add(num){
<<<<<<< HEAD
		var text = document.getElementsByName("suganglist")[num-1].value; // ï¿½ï¿½ï¿½ï¿½
		var subject = document.getElementsByName("subjectlist")[num-1].value; // ï¿½ï¿½ï¿½ï¿½
		var professor = document.getElementsByName("professorlist")[num-1].value; // ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		var hakjum = document.getElementsByName("hakjumlist")[num-1].value; // ï¿½ï¿½ï¿½ï¿½
		var code =  document.getElementsByName("l_code")[num-1].value; //ï¿½ï¿½ï¿½ï¿½ï¿½Úµï¿½
		var table =  document.getElementsByName("tablename")[num-1].value; //ï¿½ï¿½ï¿½Ìºï¿½ ï¿½Ì¸ï¿½
=======
		var text = document.getElementsByName("suganglist")[num-1].value; // °ú¸ñ
		var subject = document.getElementsByName("subjectlist")[num-1].value; // ±¸ºÐ
		var professor = document.getElementsByName("professorlist")[num-1].value; // ´ã´ç ±³¼ö
		var hakjum = document.getElementsByName("hakjumlist")[num-1].value; // ÇÐÁ¡
		var code =  document.getElementsByName("l_code")[num-1].value; //°ú¸ñÄÚµå
		var table =  document.getElementsByName("tablename")[num-1].value; //Å×ÀÌºí ÀÌ¸§
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
		
<<<<<<< HEAD
		var sugang = document.getElementsByName("sugang"); //  ï¿½è¿­ï¿½ï¿½ ï¿½ï¿½ï¿½ .length 1ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï±â¶§ï¿½ï¿½ï¿½ï¿½ -1
=======
		var sugang = document.getElementsByName("sugang"); //  ¹è¿­·Î ´ã¾Æ .length 1ºÎÅÍ ½ÃÀÛÇÏ±â¶§¹«¿¡ -1
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
		
		for(var i=0; i<=sugang.length; i++){	
			var value = document.getElementsByName(i)[0].value;
			
			if(value == ""){
<<<<<<< HEAD
				document.getElementsByName(i)[0].value = text; // ï¿½ï¿½ï¿½ï¿½ insert
=======
				document.getElementsByName(i)[0].value = text; // °ú¸ñ insert
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				
				var subjectName = "subject"+i;
<<<<<<< HEAD
				document.getElementsByName(subjectName)[0].value = subject; // ï¿½ï¿½ï¿½ï¿½ insert
=======
				document.getElementsByName(subjectName)[0].value = subject; // ±¸ºÐ insert
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				
				var professorName = "professor"+i;
<<<<<<< HEAD
				document.getElementsByName(professorName)[0].value = professor; // ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½  insert
=======
				document.getElementsByName(professorName)[0].value = professor; // ´ã´ç ±³¼ö  insert
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				
				var hakjumName = "hakjum"+i;
<<<<<<< HEAD
				document.getElementsByName(hakjumName)[0].value = hakjum; // ï¿½ï¿½ï¿½ï¿½ insert
=======
				document.getElementsByName(hakjumName)[0].value = hakjum; // ÇÐÁ¡ insert
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				
				var codeName = "code"+i;
<<<<<<< HEAD
				document.getElementsByName(codeName)[0].value = code; // ï¿½ï¿½ï¿½ï¿½ ï¿½Úµï¿½ insert
=======
				document.getElementsByName(codeName)[0].value = code; // °ú¸ñ ÄÚµå insert
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				
				var tableName = "table"+i;
<<<<<<< HEAD
				document.getElementsByName(tableName)[0].value = table; // ï¿½ï¿½ï¿½ï¿½ ï¿½Úµï¿½ insert
=======
				document.getElementsByName(tableName)[0].value = table; // °ú¸ñ ÄÚµå insert
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				
				var check = document.getElementById(num);
				check.style.display = 'none';
				
				
<<<<<<< HEAD
				var subject_sum = document.getElementsByName("subject_sum")[0].value; // ï¿½ï¿½ï¿½ï¿½ï¿½  ï¿½ï¿½ï¿½ï¿½
=======
				var subject_sum = document.getElementsByName("subject_sum")[0].value; // °ú¸ñ¼ö  µ¡¼À
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				if(subject_sum == ""){
					document.getElementsByName("subject_sum")[0].value = 1;
				}else{
					var sum = Number(document.getElementsByName("subject_sum")[0].value);
					sum = sum+1;
					document.getElementsByName("subject_sum")[0].value = sum;	
				}
<<<<<<< HEAD
				hakjum_check(i, num);  	// ï¿½ï¿½ï¿½ï¿½ ï¿½Ê°ï¿½ï¿½ï¿½ ï¿½Ô·Âµï¿½ ï¿½ï¿½ï¿½ï¿½Æ®ï¿½ï¿½ ï¿½Ú¸ï¿½ï¿½ï¿½ num ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ ï¿½ï¿½Å²ï¿½ï¿½
=======
				hakjum_check(i, num);  	// ÇÐÁ¡ ÃÊ°ú½Ã ÀÔ·ÂµÈ ¸®½ºÆ®ÀÇ ÀÚ¸®¼ö num ¸¦ º¸³» Ãë¼Ò ½ÃÅ²´Ù
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				var k = Number(i);	
				document.getElementsByName("set_sch"+k)[0].value = num;
				break;
			}
		}
	}
	
	function no(name, sch){
			
		var text = document.getElementsByName(name)[0].value;

		if(text != ""){
<<<<<<< HEAD
			var sum = Number(document.getElementsByName("subject_sum")[0].value); // ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
=======
			var sum = Number(document.getElementsByName("subject_sum")[0].value); // °ú¸ñ¼ö »¬¼À
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
			sum = sum-1;	
			if(sum <= 0){
				document.getElementsByName("subject_sum")[0].value = "";
			}else{
				document.getElementsByName("subject_sum")[0].value = sum;
			}
		}
		
<<<<<<< HEAD
		var suganglist = document.getElementsByName("suganglist"); //  ï¿½è¿­ï¿½ï¿½ ï¿½ï¿½ï¿½ .length 1ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï±â¶§ï¿½ï¿½ï¿½ï¿½ -1
=======
		var suganglist = document.getElementsByName("suganglist"); //  ¹è¿­·Î ´ã¾Æ .length 1ºÎÅÍ ½ÃÀÛÇÏ±â¶§¹«¿¡ -1
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
		var size = suganglist.length -1;

		for(var i=0; i<=size; i++){
			var check = document.getElementsByName("suganglist")[i].value;

			if(check == text ){
				var f = document.getElementsByName("checklist")[i].value;
				
				var show = document.getElementById(f);
				show.style.display = 'block';
						
<<<<<<< HEAD
/*				var sum = Number(document.getElementsByName("subject_sum")[0].value); // ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
=======
/*				var sum = Number(document.getElementsByName("subject_sum")[0].value); // °ú¸ñ¼ö »¬¼À
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
				sum = sum-1;	
				if(sum <= 0){
					document.getElementsByName("subject_sum")[0].value = "";
				}else{
					document.getElementsByName("subject_sum")[0].value = sum;
				}*/
			}
		}
	
<<<<<<< HEAD
		document.getElementsByName(name)[0].value = "";	// ï¿½ï¿½ï¿½ï¿½ ï¿½Ê±ï¿½È­
		document.getElementsByName("subject"+name)[0].value = "";	// ï¿½ï¿½ï¿½ï¿½ ï¿½Ê±ï¿½È­
		document.getElementsByName("professor"+name)[0].value = ""; // ï¿½ï¿½ç±³ï¿½ï¿½ ï¿½Ê±ï¿½È­
		document.getElementsByName("hakjum"+name)[0].value = ""; // ï¿½ï¿½ï¿½ï¿½ ï¿½Ê±ï¿½È­
		document.getElementsByName("code"+name)[0].value = ""; //ï¿½ï¿½ï¿½ï¿½ ï¿½Úµï¿½ ï¿½Ê±ï¿½È­
=======
		document.getElementsByName(name)[0].value = "";	// °ú¸ñ ÃÊ±âÈ­
		document.getElementsByName("subject"+name)[0].value = "";	// ±¸ºÐ ÃÊ±âÈ­
		document.getElementsByName("professor"+name)[0].value = ""; // ´ã´ç±³¼ö ÃÊ±âÈ­
		document.getElementsByName("hakjum"+name)[0].value = ""; // ÇÐÁ¡ ÃÊ±âÈ­
		document.getElementsByName("code"+name)[0].value = ""; //°ú¸ñ ÄÚµå ÃÊ±âÈ­
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
		
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
		
<<<<<<< HEAD
		for(var i=0; i<value.length; i++){   			// ï¿½Ã°ï¿½Ç¥ï¿½ï¿½ ï¿½ï¿½ Ç¥ï¿½ï¿½
=======
		for(var i=0; i<value.length; i++){   			// ½Ã°£Ç¥¿¡ »ö Ç¥½Ã
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
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
		
<<<<<<< HEAD
		for(var i=0; i<value.length; i++){   			//ï¿½Ã°ï¿½Ç¥ï¿½ï¿½ ï¿½ï¿½  ï¿½Ê±ï¿½È­
=======
		for(var i=0; i<value.length; i++){   			//½Ã°£Ç¥¿¡ »ö  ÃÊ±âÈ­
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
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
	
<<<<<<< HEAD
	setInterval("hideSubject()", 500); // ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Úµï¿½ ï¿½ï¿½ï¿½ï¿½
	setInterval("hideButton()", 500); // ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Úµï¿½ ï¿½ï¿½ï¿½ï¿½
=======
	setInterval("hideSubject()", 500); // ÃÊ ¸¶´Ù ÀÚµ¿ ½ÇÇà
	setInterval("hideButton()", 500); // ÃÊ ¸¶´Ù ÀÚµ¿ ½ÇÇà
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
	
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
<<<<<<< HEAD
		var lowlimit_hakjum = Number(document.getElementsByName("lowlimit_hakjum")[0].value); // ï¿½ï¿½ï¿½ï¿½ ï¿½ä±¸ ï¿½ï¿½ï¿½ï¿½
		var hakjum = Number(document.getElementsByName("hakjum_sum")[0].value); //ï¿½ï¿½Ã»ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
=======
		var lowlimit_hakjum = Number(document.getElementsByName("lowlimit_hakjum")[0].value); // ÃÖÀú ¿ä±¸ ÇÐÁ¡
		var hakjum = Number(document.getElementsByName("hakjum_sum")[0].value); //½ÅÃ»ÇÑ ÇÐÁ¡
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
		
		if(hakjum < lowlimit_hakjum){
<<<<<<< HEAD
			alert("ï¿½ï¿½Ã» ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ú¶ï¿½ï¿½Ï´ï¿½.");
=======
			alert("½ÅÃ» ÇÐÁ¡ÀÌ ¸ðÀÚ¶ø´Ï´Ù.");
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
			return false;
		}else{
			return true;
		}
	}
	
<<<<<<< HEAD
	window.history.forward(); // ï¿½Ú·Î°ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
=======
	window.history.forward(); // µÚ·Î°¡±â ¹æÁö
>>>>>>> branch 'master' of https://github.com/HeoSeokMu/KH
