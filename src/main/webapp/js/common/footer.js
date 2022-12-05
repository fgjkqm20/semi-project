$(window).scroll(function(){
	if($(this).scrollTop() > 200){
		$(".btn-top").show();
	}else{
		$(".btn-top").hide();
	}
});

$(".btn-top").on("click", function(){
	$('html, body').animate({
		scrollTop : 0
	}, 500); 
	return false;
});