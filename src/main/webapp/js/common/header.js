headerMenu.on("mouseenter", function(){
	const index = headerMenu.index(this);
	
	headerMenu.eq(index).css("color", "#10cb9c");
});

headerMenu.on("mouseleave", function(){
	const index = headerMenu.index(this);
	
	if(index != clickIndex){
		headerMenu.eq(index).css("color", "white");
	}
});

$(".header-navi>li").hover(function() {
	$(this).children("ul").toggle();
});