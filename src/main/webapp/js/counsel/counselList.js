const subjectsSarch = $(".subject-search");

subjectsSarch.on("mouseenter", function(){
	const index = subjectsSarch.index(this);
	
	category.eq(index).css("background-image", "linear-gradient(#ffffff 96%, #10cb9c 4%)");
	text.eq(index).css("color", "#10cb9c");
});

subjectsSarch.on("mouseleave", function(){
	const index = subjectsSarch.index(this);
	
	if(index != categoryIndex){
		category.eq(index).css("background", "#ffffff");
		text.eq(index).css("color", "black");
	}
});