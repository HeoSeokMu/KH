$(function(){
	$('#tab_menu .btn').click(function(){
		var ly = $(this).next();		
		$('.ly').not(ly).slideUp();
		ly.slideDown();
		$('#tab_menu .btn').removeClass("on");
		$(this).addClass("on");
	});
});