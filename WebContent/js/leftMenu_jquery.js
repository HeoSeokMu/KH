$(function(){
	$("#tab_menu .btn").hover(function(){
		var ly = $(this).next();		
		$(".ly").not(ly).slideUp("fast");
		ly.slideDown("fast");
		$("#tab_menu .btn").removeClass("on");
		$(this).addClass("on");
	});
});

function status_chk(status) {
	if(status == "휴학신청중") {
		alert("휴학신청을 이미 신청하셨습니다.");
		return false;
	} else if(status == "복학신청중") {
		alert("복학신청을 이미 신청하셨습니다.");
		return false;
	} 
	return true;
}

function link_chk(status, id) {
	if(status == "재학") {
		window.location = "restSchool.kh?id="+id;
	} else if (status == "휴학") {
		window.location =  "returnSchool.kh?id="+id;
	}
	
	if(status == "휴학신청중") {
		alert("휴학신청을 이미 신청하셨습니다.");
		return false;
	} else if(status == "복학신청중") {
		alert("복학신청을 이미 신청하셨습니다.");
		return false;
	}
}

function vacationCount_chk(rest_count) {
	if(rest_count > 12) {
		alert("휴가 신청을 더이상 하실 수 없습니다.");
		return false;
	}
} 