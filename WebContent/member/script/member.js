
//이미지 미리보기 구현부

function imgPreview(){
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
}

function delpic(){
	document.user_input.upload.outerHTML = document.user_input.upload.outerHTML;
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


// 폼 유효성 검사 후 submit.    
    function enter() {
    	
        var Input = document.user_input;
        
        if(Input.password.value == "") {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(Input.password.value != Input.password_re.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
        if(Input.name.value == "") {
            alert("이름을 입력하세요");
            return false;
        }
        if(Input.birth_yy.value == "연도" || Input.birth_mm.value == "월" || Input.birth_dd.value == "일") {
            alert("생년월일을 입력해주세요");
            return false;
        }
        if(Input.addr2.value == "") {
            alert("상세주소를 입력하세요");
            return false;
        }
        if(Input.address.value == "") {
            alert("주소를 입력하세요");
            return false;
        }  	
        if(Input.phone1.value == "" || Input.phone2.value == ""){
            alert("연락처를 입력하세요");
            return false;
        }
        if(Input.e_mail.value == ""){
            alert("메일주소를 입력하세요");
            return false;
        }

        document.user_input.action = 'joinFormPro.kh';
        document.user_input.submit();
        
    }
    
   
//이메일 도메인 선택 스크립트.
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
	 //이메일, 우편번호, 주소, 연락처, 보호자 연락처 조합해서 히든으로 값을 넘김.
	function Post_CHECK(post){
		post.post.value = post.zipcode1.value + post.zipcode2.value;
	}
	
	function Address_CHECK(addr) {
		addr.address.value = addr.addr1.value + addr.addr2.value;
	}
	
	function email_sum() {
		
		var obj1 = document.user_input.e_mail;
		var obj2 = document.user_input.mail;
		var obj3 = document.user_input.mail_address;
		
		obj1.value = obj2.value + obj3.value;
	}
	
	function phone_CHECK(phone) {
		phone.s_phone.value = "["+phone.tel_sel.value+"]"+phone.phone_number_sel.value +"-"+ phone.phone1.value +"-"+ phone.phone2.value;
	}
	
	function p_phone_CHECK(p_phone) {
		p_phone.p_phone.value = "["+p_phone.p_tel_sel.value+"]"+p_phone.p_phone_number_sel.value +"-"+ p_phone.p_phone1.value +"-"+ p_phone.p_phone2.value;
	}

//폼에서 회원유형 학생으로 선택시 보여질 메뉴와 사라질 메뉴. 사라지는 부분의 selectbox는 disabled된다.
function student(){
	document.getElementById("emp").style.display = 'none';
	document.getElementById("stu").style.display = 'block';
	
	document.getElementById("work").style.display = 'none';
	document.getElementById("pmaj").style.display = 'none';
	document.getElementById("maj").style.display = 'block';
	
	document.getElementById("maj1").disabled = '';
	document.getElementById("pmaj1").disabled = 'disabled';
	document.getElementById("work1").disabled = 'disabled';
	
	document.getElementById("way").style.display = 'block';
	document.getElementById("proflevel").style.display = 'none';
	document.getElementById("emplevel").style.display = 'none';
	document.getElementById("studway").style.display = 'block';
	document.getElementById("profwho").style.display = 'none';
	document.getElementById("empwho").style.display = 'none';
	
	document.getElementById("studway1").disabled = '';
	document.getElementById("profwho1").disabled = 'disabled';
	document.getElementById("empwho1").disabled = 'disabled';
	
	document.getElementById("hschool").style.display = '';
	document.getElementById("bohoja").style.display = '';
	
}
//폼에서 회원유형 교직원으로 선택시 보여질 메뉴와 사라질 메뉴. 사라지는 부분의 selectbox는 disabled된다.
function emplo(){
	document.getElementById("emp").style.display = 'block';
	document.getElementById("stu").style.display = 'none';
	
	document.getElementById("work").style.display = 'block';
	document.getElementById("pmaj").style.display = 'none';
	document.getElementById("maj").style.display = 'none';
	
	document.getElementById("maj1").disabled = 'disabled';
	document.getElementById("pmaj1").disabled = 'disabled';
	document.getElementById("work1").disabled = '';

	document.getElementById("way").style.display = 'none';
	document.getElementById("proflevel").style.display = 'none';
	document.getElementById("emplevel").style.display = 'block';
	document.getElementById("studway").style.display = 'none';
	document.getElementById("profwho").style.display = 'none';
	document.getElementById("empwho").style.display = 'block';
	
	document.getElementById("studway1").disabled = 'disabled';
	document.getElementById("profwho1").disabled = 'disabled';
	document.getElementById("empwho1").disabled = '';
	
	document.getElementById("hschool").style.display = 'none';
	document.getElementById("bohoja").style.display = 'none';
	
}
//폼에서 회원유형 교수로 선택시 보여질 메뉴와 사라질 메뉴. 사라지는 부분의 selectbox는 disabled된다.
function prof(){
	document.getElementById("emp").style.display = 'none';
	document.getElementById("stu").style.display = 'block';
	
	document.getElementById("work").style.display = 'none';
	document.getElementById("pmaj").style.display = 'block';
	document.getElementById("maj").style.display = 'none';
	
	document.getElementById("maj1").disabled = 'disabled';
	document.getElementById("pmaj1").disabled = '';
	document.getElementById("work1").disabled = 'disabled';
	
	document.getElementById("way").style.display = 'none';
	document.getElementById("proflevel").style.display = 'block';
	document.getElementById("emplevel").style.display = 'none';
	document.getElementById("studway").style.display = 'none';
	document.getElementById("profwho").style.display = 'block';
	document.getElementById("empwho").style.display = 'none';
	
	document.getElementById("studway1").disabled = 'disabled';
	document.getElementById("profwho1").disabled = '';
	document.getElementById("empwho1").disabled = 'disabled';
	
	document.getElementById("hschool").style.display = 'none';
	document.getElementById("bohoja").style.display = 'none';
	
}

function goPost(){
	window.open('searchAddr.kh', 'win_page', 'toolbar=no, location=no, status=no,' 
			+'menubar=no, scrollbars=yes, resizable=no, left=300, top=100, width=600, height=400');
}