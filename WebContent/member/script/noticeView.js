
		function focusIt() {
			alert("${check}");
			if("${check}"== 2){
				alert("아이디 또는 패스워드가 틀렸습니다.");
			}else if("${check}" == 3){
				alert("입력하신 아이디는 존재하지 않습니다.");
			}
		}
		
		function checkIt() {
			inputForm = eval("document.inform");
			if (!inputForm.id.value) {
				alert("아이디를 입력하세요..");
				inputForm.id.focus();
				return false;
			}
			if (!inputForm.passwd.value) {
				alert("패스워드를 입력하세요..");
				inputForm.passwd.focus();
				return false;
			}
			return ture;
		}
		
		function login_check(check) {
			if(check == -1) {
				alert("입력하신 아이디는 존재하지 않습니다.");
			} else if(check == 0) {
				alert("아이디 or 비밀번호를 틀리셨습니다.");
			}
		}
		
		function modify(){
			document.chartForm.action = "modifyNotice_board.kh";
			document.chartForm.submit();
		}
		
		function modifyGo(){
			if(confirm("해당 게시글을 정말 수정하시겠습니까?")){
			document.chartForm.action = "modifyNotice_boardPro.kh";
			document.chartForm.submit();
			}
		}
		
		function del(){
			if(confirm("해당 게시글을 정말 삭제하시겠습니까?")){
			document.chartForm.action = "deleteNotice_board.kh";
			document.chartForm.submit();
			}
		}
		
		function writePro(){
			if(document.chartForm.title.value == ""){
				alert("공지사항의 제목은 공란일 수 없습니다.");
				return false;
			}else if(document.chartForm.content.value == ""){
				alert("내용을 작성해주세요.");
				return false;
			}else{
			
			document.chartForm.action = "writeNotice_boardPro.kh";
			document.chartForm.submit();
			}
		}


			 
/* 		function where(select){
				  
				 var xmlhttp;
				  
				  if (window.XMLHttpRequest) {  
				   xmlhttp = new XMLHttpRequest(); //  IE7+, Firefox, Chrome, Opera, Safari
				  } else {    
				   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");  // IE6, IE5 
				  }
				  
				  xmlhttp.onreadystatechange = function() {
				   if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				    document.getElementById("").innerHTML = xmlhttp.responseText;
				    
				   }
				  };
				  
				  if (select == "") {
					   xmlhttp.open("GET", ".kh", true);
					  }
				  if (select == "") {
					   xmlhttp.open("GET", ".kh", true);
					  }
					  
					  xmlhttp.send();
		
			 }  */
			 