
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
            alert("�̸��� �Է��ϼ���");
            return false;
        }
        
        if(!Input.s_num.value) {
            alert("���̵� �Է��ϼ���");
            return false;
        }
        if(!Input.password.value) {
            alert("��й�ȣ�� �Է��ϼ���");
            return false;
        }
        if(Input.password.value != Input.password_re.value)
        {
            alert("��й�ȣ�� �����ϰ� �Է��ϼ���");
            return false;
        } 
        if(Input.b_year.value == "" || Input.b_month.value == "" || Input.b_day.value == "") {
            alert("��������� �Է����ּ���");
            return false;
        } 
           	
        if(Input.phone1.value == "" || Input.phone2.value == "" || Input.phone3.value == ""){
            alert("����ó�� �Է��ϼ���");
            return false;
        }
        if(Input.addr1.value == "" || Input.addr2.value == "" || Input.addr1.value == "�������� �ּ�" || Input.addr2.value == "�������� �� �ּ�"){
            alert("�ּҸ� �Է��ϼ���");
            return false;
        }
        if(Input.email.value == "" || Input.email.value == "example@mail.com"){
            alert("�����ּҸ� �Է��ϼ���");
            return false;
        }
        if(location.href == "http://localhost:8000/DCMY/joinForm.action"){
        	alert("��ȣ �ߺ�Ȯ���� �ʼ��Դϴ�.");
        	window.onFocus = document.user_input.overlapCheck;
        	return false;
        }else if('${CheckedId}' == "no"){
        	alert("�ߺ��� ��ȣ�δ� ������ �� �����ϴ�.");
        	document.user_input.num.value = "";
        }
       	
        document.user_input.action = '';
    	document.user_input.submit();
    }
    function openConfirmid(user_input) {
        if (user_input.num.value == "") {
            alert("��ȣ�� �Է��ϼ���");
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
		alert("��밡���� ���̵� �Դϴ�.");
	}else if('${CheckedId}' == "no"){
		alert("����Ͻ� �� ���� ���̵� �Դϴ�.");
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
