
﻿$(document).ready(function() {﻿
﻿
﻿	$('#upload').change(function(evt) {﻿
﻿
﻿	     var files = evt.target.files; ﻿
﻿
﻿
﻿	     var reader = new FileReader();﻿
﻿
﻿	     reader.onload = (function(theFile) {﻿
﻿
﻿	    	 return function(e) {﻿
﻿
﻿	    		 $('#preView').attr('src',e.target.result);﻿
﻿
﻿	    	 }; ﻿
﻿
﻿	     })(files[0]);﻿
﻿
﻿
﻿	     reader.readAsDataURL(files[0]);﻿
﻿
﻿	});﻿
﻿
﻿});﻿
﻿
﻿    ﻿
﻿    function enter() {﻿
﻿    	﻿
﻿        var Input = document.user_input;﻿
﻿        ﻿
﻿        if(Input.num.value == "") {﻿
﻿            alert("번호를 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.password.value == "") {﻿
﻿            alert("비밀번호를 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.password.value != Input.password_re.value)﻿
﻿        {﻿
﻿            alert("비밀번호를 동일하게 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.name.value == "") {﻿
﻿            alert("이름을 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.sex.value == "") {﻿
﻿            alert("성별을 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.birth_yy.value == "" || Input.birth_mm.value == "" || Input.birth_dd.value == "") {﻿
﻿            alert("생년월일을 입력해주세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.major.value == "") {﻿
﻿            alert("전공을 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.before_school.value == "") {﻿
﻿            alert("출신학교를 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.address.value == "") {﻿
﻿            alert("주소를 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿           	﻿
﻿        if(Input.phone1.value == "" || Input.phone2.value == ""){﻿
﻿            alert("연락처를 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.addr1.value == "" || Input.addr2.value == ""){﻿
﻿            alert("주소를 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.e_mail.value == ""){﻿
﻿            alert("메일주소를 입력하세요");﻿
﻿            return false;﻿
﻿        }﻿
﻿
﻿        document.user_input.action = 'joinFormPro.kh';﻿
﻿        document.user_input.submit();﻿
﻿        ﻿
﻿    }﻿
﻿   ﻿
﻿            ﻿
﻿    function delpic(){﻿
﻿    	document.user_input.upload.outerHTML = document.user_input.upload.outerHTML;﻿
﻿    }﻿
﻿    ﻿
﻿
﻿
﻿	function e_mail_EVENT(e_mail) {﻿
﻿		if(e_mail.mail_sel.options[0].selected) {﻿
﻿			e_mail.mail_address.value = e_mail.mail_sel.options[0].value;﻿
﻿		} else if(e_mail.mail_sel.options[1].selected) {﻿
﻿			e_mail.mail_address.value = e_mail.mail_sel.options[1].value;﻿
﻿		} else if(e_mail.mail_sel.options[2].selected) {﻿
﻿			e_mail.mail_address.value = e_mail.mail_sel.options[2].value;﻿
﻿		} else if(e_mail.mail_sel.options[3].selected) {﻿
﻿			e_mail.mail_address.value = e_mail.mail_sel.options[3].value;﻿
﻿		} else if(e_mail.mail_sel.options[4].selected) {﻿
﻿			e_mail.mail_address.value = e_mail.mail_sel.options[4].value;﻿
﻿		} else if(e_mail.mail_sel.options[5].selected) {﻿
﻿			e_mail.mail_address.value = e_mail.mail_sel.options[5].value;﻿
﻿		} else if(e_mail.mail_sel.options[6].selected) {﻿
﻿			e_mail.mail_address.value = e_mail.mail_sel.options[6].value;﻿
﻿		}﻿
﻿	}﻿
﻿	﻿
﻿	function Post_CHECK(post){﻿
﻿		post.post.value = post.zipcode1.value + post.zipcode2.value;﻿
﻿	}﻿
﻿	﻿
﻿	function Address_CHECK(addr) {﻿
﻿		addr.address.value = addr.addr1.value + addr.addr2.value;﻿
﻿	}﻿
﻿	﻿
﻿	function email_sum() {﻿
﻿		﻿
﻿		var obj1 = document.user_input.e_mail;﻿
﻿		var obj2 = document.user_input.mail;﻿
﻿		var obj3 = document.user_input.mail_address;﻿
﻿		﻿
﻿		obj1.value = obj2.value + obj3.value;﻿
﻿	}﻿
﻿	﻿
﻿	function phone_CHECK(phone) {﻿
﻿		phone.s_phone.value = "["+phone.tel_sel.value+"]"+phone.phone_number_sel.value +"-"+ phone.phone1.value +"-"+ phone.phone2.value;﻿
﻿	}﻿
﻿	﻿
﻿	function p_phone_CHECK(p_phone) {﻿
﻿		p_phone.p_phone.value = "["+p_phone.p_tel_sel.value+"]"+p_phone.p_phone_number_sel.value +"-"+ p_phone.p_phone1.value +"-"+ p_phone.p_phone2.value;﻿
﻿	}﻿
﻿
﻿	function hideDefaultPic(){﻿
﻿
﻿		var i = document.getElementById("def_img");﻿
﻿
﻿		i.style.display = 'none';﻿
﻿
﻿		document.getElementById("pre_div").style.display = '';﻿
﻿
﻿	}﻿
﻿
﻿
﻿function coverPic(){﻿
﻿	var i = document.getElementById("def_img");﻿
﻿	i.style.display = 'block';﻿
﻿	document.getElementById("pre_div").style.display = 'none';﻿
﻿}﻿
﻿
﻿function student(){﻿
﻿	document.getElementById("emp").style.display = 'none';﻿
﻿	document.getElementById("stu").style.display = 'block';﻿
﻿	﻿
﻿	document.getElementById("work").style.display = 'none';﻿
﻿	document.getElementById("maj").style.display = 'block';﻿
﻿}﻿
﻿
﻿function emplo(){﻿
﻿	document.getElementById("emp").style.display = 'block';﻿
﻿	document.getElementById("stu").style.display = 'none';﻿
﻿	﻿
﻿	document.getElementById("work").style.display = 'block';﻿
﻿	document.getElementById("maj").style.display = 'none';﻿
﻿}