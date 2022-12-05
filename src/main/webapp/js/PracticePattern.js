let n = 0;
const ulul = $(".guideSlide-wrap>ul");
const cnt = ulul.children().length;
const wid = 1200;
const tabs=$(".guide-tabs>li");
const nexticon = $("#nexticon");

ulul.css("width",(cnt*wid)+"px");

$(".prev").on("click",function(){
    if(n != 0){
        n--;
        const move = -n*wid;
        ulul.css("transform","translateX("+move+"px)").css("transition-duration","1s");
    }
    tabs.eq(n).removeClass("liColor");
    tabs.eq(n).css("color","#dddddd");
});

$(".next").on("click",function(){
    if(n != cnt-1){
        n++;
        const move = -n*wid;
        ulul.css("transform","translateX("+move+"px)").css("transition-duration","1s");
    }
    tabs.eq(n).addClass("liColor");
    nexticon.eq(n).addClass("nexticon");
});


tabs.eq(0).addClass("liColor");
tabs.eq(0).css("background-color","#10CB9C");

$("#finishPrescription").on("click",function(){
    $(".next").click();
});



const loginModal = $(".modal-request");

$("#nowreceive").on("click", function(){
    loginModal.css("display", "flex");
})

$(".closebtn").on("click",function(){
    loginModal.css("display", "none");
})
