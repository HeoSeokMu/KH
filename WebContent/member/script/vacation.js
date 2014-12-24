var start = null;
	var end = null;
	
	function auto_default(type, major){
		if(type == "교수"){
			document.user_input.type.value = '교수';
		}else if(type == "교직원"){
			document.user_input.type.value = '교직원';
		}
		
	}
	
	function dateSum(){
		var form = document.user_input;
		
		form.vacation_start.value = form.vacStart_yy.value +"년"+ form.vacStart_mm.value +"월"+ form.vacStart_dd.value + "일";
		form.vacation_end.value = form.vacEnd_yy.value +"년"+ form.vacEnd_mm.value +"월"+ form.vacEnd_dd.value + "일";
		
		var en = form.vacation_end.value;
		
		if(~en.indexOf('0년')){
			document.getElementById("dateError").style.display = '';
			document.getElementById("dateOk").style.display = 'none';
		}else if(~en.indexOf('0월')){
			document.getElementById("dateError").style.display = '';
			document.getElementById("dateOk").style.display = 'none';
		}else if(~en.indexOf('0일')){
			document.getElementById("dateError").style.display = '';
			document.getElementById("dateOk").style.display = 'none';
		}else{
			document.getElementById("dateError").style.display = 'none';
			document.getElementById("dateOk").style.display = '';	
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
					}
				}else if ( i == 'm'){
					if(Number(s_year+s_month) > Number(e_year+e_month)){
						user_input.vacEnd_mm.value = 0;
					}
				}else{
					if(start > end){
						user_input.vacEnd_dd.value = 0;
					}
				}
	
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
	
	function viewSet(type, major){
		if(type == "교수"){
			document.user_input.type.value = '교수';
		}else if(type == "교직원"){
			document.user_input.type.value = '교직원';
		}
	}
	
	function ChangeDate(){
		
		var original = document.getElementById("original");
		var newDate = document.getElementById("newDate");
		
		if(document.getElementById("changeCheck").checked == true){
			newDate.style.display = '';
			original.style.display = 'none';
		}else{
			newDate.style.display = 'none';
			original.style.display = '';
		}
		
		
	}