
﻿//이미지 미리보기 구현부﻿
﻿
﻿function imgPreview(){﻿
﻿	$(document).ready(function() {﻿
﻿
﻿		$('#upload').change(function(evt) {﻿
﻿
﻿		     var files = evt.target.files; ﻿
﻿
﻿
﻿		     var reader = new FileReader();﻿
﻿
﻿		     reader.onload = (function(theFile) {﻿
﻿
﻿		    	 return function(e) {﻿
﻿
﻿		    		 $('#preView').attr('src',e.target.result);﻿
﻿
﻿		    	 }; ﻿
﻿
﻿		     })(files[0]);﻿
﻿
﻿
﻿		     reader.readAsDataURL(files[0]);﻿
﻿
﻿		});﻿
﻿
﻿	});﻿
﻿}﻿
﻿
﻿function delpic(){﻿
﻿	document.user_input.upload.outerHTML = document.user_input.upload.outerHTML;﻿
﻿}﻿
﻿
﻿function hideDefaultPic(){﻿
﻿
﻿	var i = document.getElementById("def_img");﻿
﻿
﻿	i.style.display = 'none';﻿
﻿
﻿	document.getElementById("pre_div").style.display = '';﻿
﻿
﻿}﻿
﻿
﻿
﻿function coverPic(){﻿
﻿var i = document.getElementById("def_img");﻿
﻿i.style.display = 'block';﻿
﻿document.getElementById("pre_div").style.display = 'none';﻿
﻿}﻿
﻿
﻿
﻿// 폼 유효성 검사 후 submit.    ﻿
﻿    function enter() {﻿
﻿    	﻿
﻿        var Input = document.user_input;﻿
﻿        ﻿
﻿        if(Input.password.value == "") {﻿
﻿            alert("비밀번호를 입력하세요");﻿
﻿            Input.password.focus();﻿
﻿            return false;﻿
﻿        }else{﻿
﻿        	var engnum_check = /^[a-zA-Z0-9]+$/;﻿
﻿        	if(engnum_check.test(Input.password.value)){﻿
﻿        		if(Input.password.value.length < 6 || Input.password.value.length >20){﻿
﻿        			alert("비밀번호는 6~19글자만 입력할 수 있습니다.");﻿
﻿        			Input.password.value = "";﻿
﻿        			Input.password.focus();﻿
﻿        			return false;﻿
﻿        		}﻿
﻿        	}else{﻿
﻿        		alert("영어나 숫자만 입력할 수 있습니다");﻿
﻿        		Input.password.value = "";﻿
﻿    			Input.password.focus();﻿
﻿    			return false;﻿
﻿        	}﻿
﻿        }﻿
﻿        if(Input.password.value != Input.password_re.value)﻿
﻿        {﻿
﻿            alert("비밀번호를 동일하게 입력하세요");﻿
﻿            Input.password.focus();﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.name.value == "") {﻿
﻿            alert("이름을 입력하세요");﻿
﻿            Input.name.focus();﻿
﻿            return false;﻿
﻿        }else{﻿
﻿        	var koreng_check = /^[가-힣a-zA-Z]+$/;﻿
﻿        	if(koreng_check.test(Input.name.value)){﻿
﻿        		if(Input.name.value.length < 2 || Input.name.value.length >20){﻿
﻿        			alert("이름은 2~19글자만 입력할 수 있습니다.");﻿
﻿        			Input.name.value = "";﻿
﻿        			Input.name.focus();﻿
﻿        			return false;﻿
﻿        		}﻿
﻿        	}else{﻿
﻿        		alert("한글이나 영어만 입력할 수 있습니다");﻿
﻿        		Input.name.value = "";﻿
﻿    			Input.name.focus();﻿
﻿    			return false;﻿
﻿        	}﻿
﻿        }﻿
﻿        if(Input.birth_yy.value == "연도" || Input.birth_mm.value == "월" || Input.birth_dd.value == "일") {﻿
﻿            alert("생년월일을 입력해주세요");﻿
﻿            Input.birth_yy.focus();﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.before_school.value == "") {﻿
﻿            alert("출신학교를 입력하세요");﻿
﻿            Input.before_school.focus();﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.addr2.value == "") {﻿
﻿            alert("상세주소를 입력하세요");﻿
﻿            Input.addr2.focus();﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.addr1.value == "") {﻿
﻿            alert("주소를 입력하세요");﻿
﻿            Input.address.focus();﻿
﻿            return false;﻿
﻿        }﻿
﻿        if(Input.e_mail.value == "" || Input.mail.value == ""){﻿
﻿            alert("메일주소를 입력하세요");﻿
﻿            Input.mail.focus();﻿
﻿            return false;﻿
﻿            ﻿
﻿        }else{﻿
﻿        	var engnum_check = /^[a-zA-Z0-9._]+$/;﻿
﻿        	if(engnum_check.test(Input.mail.value)){﻿
﻿        	}else{﻿
﻿        		alert("메일주소는 영어나 숫자, 마침표 및, 밑줄 기호(_)만 입력할 수 있습니다");﻿
﻿        		Input.mail.value = "";﻿
﻿    			Input.mail.focus();﻿
﻿    			return false;﻿
﻿        	}﻿
﻿        }﻿
﻿        if(Input.phone1.value == "" || Input.phone2.value == ""){﻿
﻿            alert("연락처를 입력하세요");﻿
﻿            Input.phone1.focus();﻿
﻿            return false;﻿
﻿        }else{﻿
﻿        	var num_check =  /^[0-9]+$/;﻿
﻿        	if(num_check.test(Input.phone1.value)){﻿
﻿        		if(Input.phone1.value.length < 3 || Input.phone1.value.length >4){﻿
﻿        			alert("휴대전화 중간번호 자리수를 확인해 주세요.");﻿
﻿        			Input.phone1.value = "";﻿
﻿        			Input.phone1.focus();﻿
﻿        			return false;﻿
﻿        		}﻿
﻿        	}else{﻿
﻿        		alert("숫자만 입력할 수 있습니다");﻿
﻿        		Input.phone1.value = "";﻿
﻿    			Input.phone1.focus();﻿
﻿    			return false;﻿
﻿        	}﻿
﻿        }﻿
﻿        if(num_check.test(Input.phone2.value)){﻿
﻿    		if(Input.phone2.value.length < 3 || Input.phone2.value.length >4){﻿
﻿    			alert("휴대전화 마지막 번호 자리수를 확인해 주세요.");﻿
﻿    			Input.phone2.value = "";﻿
﻿    			Input.phone2.focus();﻿
﻿    			return false;﻿
﻿    		}﻿
﻿    	}else{﻿
﻿    		alert("숫자만 입력할 수 있습니다");﻿
﻿    		Input.phone2.value = "";﻿
﻿			Input.phone2.focus();﻿
﻿			return false;﻿
﻿    	}﻿
﻿    ﻿
﻿        if(Input.p_phone1.value == "" || Input.p_phone2.value == ""){﻿
﻿            alert("보호자 연락처를 입력하세요");﻿
﻿            Input.p_phone1.focus();﻿
﻿            return false;﻿
﻿        }else{﻿
﻿        	if(num_check.test(Input.p_phone1.value)){﻿
﻿        		if(Input.p_phone1.value.length < 3 || Input.p_phone1.value.length >4){﻿
﻿        			alert("보호자 연락처 중간번호 자리수를 확인해 주세요.");﻿
﻿        			Input.p_phone1.value = "";﻿
﻿        			Input.p_phone1.focus();﻿
﻿        			return false;﻿
﻿        		}﻿
﻿        	}else{﻿
﻿        		alert("숫자만 입력할 수 있습니다");﻿
﻿        		Input.p_phone1.value = "";﻿
﻿    			Input.p_phone1.focus();﻿
﻿    			return false;﻿
﻿        	}﻿
﻿        }﻿
﻿        if(num_check.test(Input.p_phone2.value)){﻿
﻿    		if(Input.p_phone2.value.length < 3 || Input.p_phone2.value.length >4){﻿
﻿    			alert("보호자 연락처 마지막 번호 자리수를 확인해 주세요.");﻿
﻿    			Input.p_phone2.value = "";﻿
﻿    			Input.p_phone2.focus();﻿
﻿    			return false;﻿
﻿    		}﻿
﻿    	}else{﻿
﻿    		alert("숫자만 입력할 수 있습니다");﻿
﻿    		Input.p_phone2.value = "";﻿
﻿			Input.p_phone2.focus();﻿
﻿			return false;﻿
﻿    	}﻿
﻿
﻿        document.user_input.action = 'joinFormPro.kh';﻿
﻿        document.user_input.submit();﻿
﻿        ﻿
﻿    }﻿
﻿    //비밀번호, 비밀번호 확인 실시간 일치여부 체크.﻿
﻿    function pwEvent(){﻿
﻿    	if(document.user_input.password.value != document.user_input.password_re.value)﻿
﻿        {﻿
﻿    		document.getElementById("wrongPw").style.display = 'block';﻿
﻿    		document.getElementById("rightPw").style.display = 'none';﻿
﻿    	    }﻿
﻿    	else{﻿
﻿    		document.getElementById("wrongPw").style.display = 'none';﻿
﻿    		document.getElementById("rightPw").style.display = 'block';﻿
﻿    	}﻿
﻿    }﻿
﻿   ﻿
﻿//이메일 도메인 선택 스크립트.﻿
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
﻿	 //이메일, 우편번호, 주소, 연락처, 보호자 연락처 조합해서 히든으로 값을 넘김.﻿
﻿	function Post_CHECK(post){﻿
﻿		post.post.value = post.zipcode1.value + post.zipcode2.value;﻿
﻿	}﻿
﻿	﻿
﻿	function Address_CHECK(addr) {﻿
﻿		addr.address.value = addr.addr1.value + ", " +  addr.addr2.value;﻿
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
﻿//폼에서 회원유형 학생으로 선택시 보여질 메뉴와 사라질 메뉴. 사라지는 부분의 selectbox는 disabled된다.﻿
﻿function student(){﻿
﻿	document.getElementById("emp").style.display = 'none';﻿
﻿	document.getElementById("stu").style.display = 'block';﻿
﻿	﻿
﻿	document.getElementById("work").style.display = 'none';﻿
﻿	document.getElementById("pmaj").style.display = 'none';﻿
﻿	document.getElementById("maj").style.display = 'block';﻿
﻿	﻿
﻿	document.getElementById("maj1").disabled = '';﻿
﻿	document.getElementById("pmaj1").disabled = 'disabled';﻿
﻿	document.getElementById("work1").disabled = 'disabled';﻿
﻿	﻿
﻿	document.getElementById("way").style.display = 'block';﻿
﻿	document.getElementById("proflevel").style.display = 'none';﻿
﻿	document.getElementById("emplevel").style.display = 'none';﻿
﻿	document.getElementById("studway").style.display = 'block';﻿
﻿	document.getElementById("profwho").style.display = 'none';﻿
﻿	document.getElementById("empwho").style.display = 'none';﻿
﻿	﻿
﻿	document.getElementById("studway1").disabled = '';﻿
﻿	document.getElementById("profwho1").disabled = 'disabled';﻿
﻿	document.getElementById("empwho1").disabled = 'disabled';﻿
﻿	﻿
﻿	document.getElementById("hschool").style.display = '';﻿
﻿	document.getElementById("bohoja").style.display = '';﻿
﻿	﻿
﻿}﻿
﻿//폼에서 회원유형 교직원으로 선택시 보여질 메뉴와 사라질 메뉴. 사라지는 부분의 selectbox는 disabled된다.﻿
﻿//교직원은 출신 고등학교와 보호자 연락처를 "Null"로 처리한다.﻿
﻿function emplo(){﻿
﻿	document.getElementById("emp").style.display = 'block';﻿
﻿	document.getElementById("stu").style.display = 'none';﻿
﻿	﻿
﻿	document.getElementById("work").style.display = 'block';﻿
﻿	document.getElementById("pmaj").style.display = 'none';﻿
﻿	document.getElementById("maj").style.display = 'none';﻿
﻿	﻿
﻿	document.getElementById("maj1").disabled = 'disabled';﻿
﻿	document.getElementById("pmaj1").disabled = 'disabled';﻿
﻿	document.getElementById("work1").disabled = '';﻿
﻿
﻿	document.getElementById("way").style.display = 'none';﻿
﻿	document.getElementById("proflevel").style.display = 'none';﻿
﻿	document.getElementById("emplevel").style.display = 'block';﻿
﻿	document.getElementById("studway").style.display = 'none';﻿
﻿	document.getElementById("profwho").style.display = 'none';﻿
﻿	document.getElementById("empwho").style.display = 'block';﻿
﻿	﻿
﻿	document.getElementById("studway1").disabled = 'disabled';﻿
﻿	document.getElementById("profwho1").disabled = 'disabled';﻿
﻿	document.getElementById("empwho1").disabled = '';﻿
﻿	﻿
﻿	document.getElementById("hschool").style.display = 'none';﻿
﻿	document.getElementById("bohoja").style.display = 'none';﻿
﻿	﻿
﻿	document.user_input.before_school.value = "null";﻿
﻿	document.user_input.p_phone1.value = "0000";﻿
﻿	document.user_input.p_phone2.value = "0000";﻿
﻿}﻿
﻿//폼에서 회원유형 교수로 선택시 보여질 메뉴와 사라질 메뉴. 사라지는 부분의 selectbox는 disabled된다.﻿
﻿//교수는 출신 고등학교와 보호자 연락처를 "Null"로 처리한다.﻿
﻿function prof(){﻿
﻿	document.getElementById("emp").style.display = 'none';﻿
﻿	document.getElementById("stu").style.display = 'block';﻿
﻿	﻿
﻿	document.getElementById("work").style.display = 'none';﻿
﻿	document.getElementById("pmaj").style.display = 'block';﻿
﻿	document.getElementById("maj").style.display = 'none';﻿
﻿	﻿
﻿	document.getElementById("maj1").disabled = 'disabled';﻿
﻿	document.getElementById("pmaj1").disabled = '';﻿
﻿	document.getElementById("work1").disabled = 'disabled';﻿
﻿	﻿
﻿	document.getElementById("way").style.display = 'none';﻿
﻿	document.getElementById("proflevel").style.display = 'block';﻿
﻿	document.getElementById("emplevel").style.display = 'none';﻿
﻿	document.getElementById("studway").style.display = 'none';﻿
﻿	document.getElementById("profwho").style.display = 'block';﻿
﻿	document.getElementById("empwho").style.display = 'none';﻿
﻿	﻿
﻿	document.getElementById("studway1").disabled = 'disabled';﻿
﻿	document.getElementById("profwho1").disabled = '';﻿
﻿	document.getElementById("empwho1").disabled = 'disabled';﻿
﻿	﻿
﻿	document.getElementById("hschool").style.display = 'none';﻿
﻿	document.getElementById("bohoja").style.display = 'none';﻿
﻿	﻿
﻿	document.user_input.before_school.value = "null";﻿
﻿	document.user_input.p_phone1.value = "0000";﻿
﻿	document.user_input.p_phone2.value = "0000";﻿
﻿}﻿
﻿//주소검색 이벤트 발생﻿
﻿function goPost(){﻿
﻿	window.open('searchAddr.kh', 'win_page', 'toolbar=no, location=no, status=no,' ﻿
﻿			+'menubar=no, scrollbars=yes, resizable=no, left=300, top=100, width=600, height=400');﻿
﻿}﻿
