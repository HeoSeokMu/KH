function sendAddr(zipcode){
	var code = "addrSum"+zipcode;
	var addrSum = document.getElementsByName(code)[0].value;

	var addr = addrSum.split(",");
	var zipcode = addr[0].split("-");
	
	if(location.href == 'http://localhost:8000/KH_School/searchAddrPro.kh?parent'){
		opener.user_input.p_addr1.value = addr[1];
		opener.user_input.p_zipcode1.value = zipcode[0];
		opener.user_input.p_zipcode2.value = zipcode[1];
		
		opener.user_input.p_post.value = zipcode[0] + "-" + zipcode[1];
		
		window.close();
	}else{
	
	opener.user_input.addr1.value = addr[1];
	opener.user_input.zipcode1.value = zipcode[0];
	opener.user_input.zipcode2.value = zipcode[1];
	
	opener.user_input.post.value = zipcode[0] + "-" + zipcode[1];
	
	window.close();
		}
}

function goSearch(){
	if(location.href == 'http://localhost:8000/KH_School/searchAddr.kh?parent'||
			location.href == 'http://localhost:8000/KH_School/searchAddrPro.kh?parent'){
	document.juso_input.action = 'searchAddrPro.kh?parent';
	document.juso_input.submit();
	}else{
	document.juso_input.action = 'searchAddrPro.kh';
	document.juso_input.submit();
	}
}