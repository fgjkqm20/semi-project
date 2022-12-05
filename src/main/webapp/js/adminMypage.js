
const startModal = $(".modal-request");

$(".bottomBtn").on("click", function(){
    startModal.css("display", "flex");
})

$(".checkIcons").on("click",function(){
    startModal.css("display", "none");
})

$(".XIcons").on("click",function(){
    startModal.css("display", "none");
})
