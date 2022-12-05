$("#review-btn").on("click", function(){
   $(".rmodal-wrap").css("display", "flex");
})

$(".modal-btn-box>button:first-child").on("click",function(){
    reviewModal.css("display", "none");
    starBox.css("visibility", "hidden");
    stars.css("color", "lightgrey");
})

const starBox = $(".comment-box>div:first-child");
const stars = $(".star-box>span"); // star아이콘모음
stars.on("mouseover", function(){
    const idx = stars.index(this);
    stars.each(function(index, item){
        if(idx>=index){ //마우스가 올라간 인덱스보다 작거나 같으면
            $(item).css("color", "rgb(255, 197, 0)");
        }else{
            $(item).css("color", "lightgrey");
        }
    })
});

stars.on("mouseleave", function(){
    const realScore = Number($(".real-score").text());
    stars.each(function(index, item){
        if(realScore>index){
            $(item).css("color", "rgb(255, 197, 0)");
        }else{
            $(item).css("color", "lightgrey");
        }
    })
})

stars.on("click", function(){
    const idx = stars.index(this);
    $(".real-score").text(idx+1);
    starBox.css("visibility", "visible");
    const commentSpan = $(".comment-box>div:last-child>span");
    if(idx>1){
        commentSpan.text("어떤 점이 좋았나요?");
    }else{
        commentSpan.text("어떤 점이 아쉬웠나요?");
    }
})

