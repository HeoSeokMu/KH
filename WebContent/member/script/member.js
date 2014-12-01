
$(document).ready(function() {
	$('#upload').change(function(evt) {
	     var files = evt.target.files; 

	     var reader = new FileReader();
	     reader.onload = (function(theFile) {
	    	 return function(e) {
	    		 $('#preView').attr('src',e.target.result);
	    	 }; 
	     })(files[0]);

	     reader.readAsDataURL(files[0]);
	});
});
    
    function enter() {
        var Input = eval("document.user_input");
        
        if(!Input.name.value) {
            alert("이름을 입력하세요");
            return false;
        }
        
        if(!Input.s_num.value) {
            alert("아이디를 입력하세요");
            return false;
        }
        if(!Input.password.value) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(Input.password.value != Input.password_re.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        } 
        if(Input.b_year.value == "" || Input.b_month.value == "" || Input.b_day.value == "") {
            alert("생년월일을 입력해주세요");
            return false;
        } 
           	
        if(Input.phone1.value == "" || Input.phone2.value == "" || Input.phone3.value == ""){
            alert("연락처를 입력하세요");
            return false;
        }
        if(Input.addr1.value == "" || Input.addr2.value == "" || Input.addr1.value == "동까지의 주소" || Input.addr2.value == "나머지의 상세 주소"){
            alert("주소를 입력하세요");
            return false;
        }
        if(Input.email.value == "" || Input.email.value == "example@mail.com"){
            alert("메일주소를 입력하세요");
            return false;
        }
        if(location.href == "http://localhost:8000/DCMY/joinForm.action"){
        	alert("번호 중복확인은 필수입니다.");
        	window.onFocus = document.user_input.overlapCheck;
        	return false;
        }else if('${CheckedId}' == "no"){
        	alert("중복된 번호로는 가입할 수 없습니다.");
        	document.user_input.num.value = "";
        }
       	
        document.user_input.action = '';
    	document.user_input.submit();
    }
    function openConfirmid(user_input) {
        if (user_input.num.value == "") {
            alert("번호를 입력하세요");
            return false;
        }

        document.user_input.action = 'idOverlapCheck.action?overlapCheck=' + '${CheckedId}';
        document.user_input.submit();
        }
            
    function delpic(){
    	document.user_input.upload.outerHTML = document.user_input.upload.outerHTML;
    }
    
window.onload = function(){
	if('${CheckedId}' == "ok"){
		alert("사용가능한 아이디 입니다.");
	}else if('${CheckedId}' == "no"){
		alert("사용하실 수 없는 아이디 입니다.");
	}
}

	function e_mail_EVENT(e_mail) {
		if(e_mail.mail_sel.options[0].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[0].value;
		} else if(e_mail.mail_sel.options[1].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[1].value;
		} else if(e_mail.mail_sel.options[2].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[2].value;
		} else if(e_mail.mail_sel.options[3].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[3].value;
		} else if(e_mail.mail_sel.options[4].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[4].value;
		} else if(e_mail.mail_sel.options[5].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[5].value;
		} else if(e_mail.mail_sel.options[6].selected) {
			e_mail.mail_address.value = e_mail.mail_sel.options[6].value;
		}
	}
	
	function Address_CHECK(addr) {
		addr.address.value = addr.addr1.value + addr.addr2.value;
	}
	
	function email_CHECK(email) {
		email.e_mail.value = email.mail.value + email.mail_address.value;
	}
	
	function phone_CHECK(phone) {
		phone.phonenumber.value = phone.phone_number_sel.value + phone.phone_num1.value + phone.phone_num2.value;
	}

	function hideDefaultPic(){
		var i = document.getElementById("def_img");
		i.style.display = 'none';
		document.getElementById("pre_div").style.display = '';
	}

function coverPic(){
	var i = document.getElementById("def_img");
	i.style.display = 'block';
	document.getElementById("pre_div").style.display = 'none';
}
