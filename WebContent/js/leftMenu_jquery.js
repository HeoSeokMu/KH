$(function(){
	$("#tab_menu .btn").hover(function(){
		var ly = $(this).next();		
		$(".ly").not(ly).slideUp("fast");
		ly.slideDown("fast");
		$("#tab_menu .btn").removeClass("on");
		$(this).addClass("on");
	});
});