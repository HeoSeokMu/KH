var start = null;
	var end = null;
	
	function auto_default(type, major){
		if(type == "교수"){
			document.user_input.type.value = '교수';
		}else if(type == "교직원"){
			document.user_input.type.value = '교직원';
		}
		
	}
	
	var s_year = null;
	var s_month = null;

	var e_year = null;
	var e_month = null;
	
	function chk_dd(yy,mm,dd, chk, i){
		
		if(chk == "start"){
			if(mm < 10) {
				mm = 0+mm;
			}
			if(dd < 10) {
				dd = 0+dd;
			}
			s_year = yy;
			s_month = mm;
			start = Number(yy+mm+dd);
		}else{
			if(mm < 10) {
				mm = 0+mm;
			}
			if(dd < 10) {
				dd = 0+dd;
			}
			e_year = yy;
			e_month = mm;
			end = Number(yy+mm+dd);
		}
			
		if(start != null && end != null){	
			if(start >= end){
				
				if(i == 'y'){
					if(Number(s_year) > Number(e_year)){
						user_input.vacEnd_yy.value = 0;
						document.getElementById("dateError").style.display = '';
						document.getElementById("dateOk").style.display = 'none';
					}
				}else if ( i == 'm'){
					if(Number(s_year+s_month) > Number(e_year+e_month)){
						user_input.vacEnd_mm.value = 0;
						document.getElementById("dateError").style.display = '';
						document.getElementById("dateOk").style.display = 'none';
					}
				}else{
					if(start > end){
						user_input.vacEnd_dd.value = 0;
						document.getElementById("dateError").style.display = '';
						document.getElementById("dateOk").style.display = 'none';
					}
				}
			}else if(start <= end){
				document.getElementById("dateError").style.display = 'none';
				document.getElementById("dateOk").style.display = '';
			}

		}
			
	}
	
	function hugaGo(){
		
		if(document.getElementById("dateOk").style.display == 'none'
				&& document.getElementById("dateError").style.display == ''){
			alert("희망일자를 확인해주세요.");
			return false;
		}else{
			if(confirm("휴가신청을 하시겠습니까?")){
				document.user_input.action = 'vacationFormPro.kh';
				document.user_input.submit();
			}
		}
	}
	
	function viewSet(type, result){
		if(type == "교수"){
			document.user_input.type.value = '교수';
		}else if(type == "교직원"){
			document.user_input.type.value = '교직원';
		}
		
		if(result == "미처리"){
			document.user_input.result.value = '미처리';
		}else if(result == "승인"){
			document.user_input.result.value = '승인';
		}else if(result == "거절"){
			document.user_input.result.value = '거절';
		}
	}
	
	function ChangeDate(){
		
		var original = document.getElementById("original");
		var newDate = document.getElementById("newDate");
		
		if(document.getElementById("changeCheck").checked == true){
			newDate.style.display = '';
			original.style.display = 'none';
			document.user_input.vacStart_yy.disabled = '';
			document.user_input.vacStart_mm.disabled = '';
			document.user_input.vacStart_dd.disabled = '';
			
			document.user_input.vacEnd_yy.disabled = '';
			document.user_input.vacEnd_mm.disabled = '';
			document.user_input.vacEnd_dd.disabled = '';
		}else{
			newDate.style.display = 'none';
			original.style.display = '';
			document.user_input.vacStart_yy.disabled = 'disabled';
			document.user_input.vacStart_mm.disabled = 'disabled';
			document.user_input.vacStart_dd.disabled = 'disabled';
			
			document.user_input.vacEnd_yy.disabled = 'disabled';
			document.user_input.vacEnd_mm.disabled = 'disabled';
			document.user_input.vacEnd_dd.disabled = 'disabled';
		}
		
		
	}
	
	function hugaModify(){
		document.user_input.action = 'vacationModify.kh';
		document.user_input.submit();
	}
	
	function goModify(){
		if(document.getElementById("changeCheck").checked == true){
			if(document.user_input.vacStart_yy.value == '연도'){
				alert("희망일정을 선택해주세요.");
				return false;
			}else if(document.user_input.vacStart_mm.value == '월'){
				alert("희망일정을 선택해주세요.");
				return false;
			}else if(document.user_input.vacStart_dd.value == '일'){
				alert("희망일정을 선택해주세요.");
				return false;
			}else if(document.user_input.vacEnd_yy.value == '0'){
				alert("희망일정을 선택해주세요.");
				return false;
			}else if(document.user_input.vacEnd_mm.value == '0'){
				alert("희망일정을 선택해주세요.");
				return false;
			}else if(document.user_input.vacEnd_dd.value == '0'){
				alert("희망일정을 선택해주세요.");
				return false;
			}else{
				if(confirm("휴가신청을 수정 하시겠습니까?")){
					document.user_input.action = 'vacationModifyPro.kh';
					document.user_input.submit();
				}
			}
		}else{
			if(confirm("휴가신청을 수정 하시겠습니까?")){
				document.user_input.action = 'vacationModifyPro.kh';
				document.user_input.submit();
			}
		}
	}
	
	function delHuga(){
		if(confirm("휴가신청을 삭제 하시겠습니까?")){
			document.user_input.action = 'vacationDelete.kh';
			document.user_input.submit();
		}
	}
	
	function acceptHuga(){
		if(confirm("휴가신청을 승인 하시겠습니까?")){
			document.user_input.action = 'vacationAccept.kh';
			document.user_input.submit();
		}
	}
	function denyHuga(){
		if(confirm("휴가신청을 거절 하시겠습니까?")){
			document.user_input.action = 'vacationDeny.kh';
			document.user_input.submit();
		}
	}