function sendAddr(zipcode){
	var code = "addrSum"+zipcode;
	var addrSum = document.getElementsByName(code)[0].value;

	var addr = addrSum.split(",");
	var zipcode = addr[0].split("-");
	
	opener.user_input.addr1.value = addr[1];
	opener.user_input.zipcode1.value = zipcode[0];
	opener.user_input.zipcode2.value = zipcode[1];
	
	opener.user_input.post.value = zipcode[0] + "-" + zipcode[1];
	
	window.close();

}