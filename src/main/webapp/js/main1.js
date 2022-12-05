const next =$(".material-symbols-outlined");
const ul = $(".topimg>ul");
const li = $(".topimg>ul>li");
const lifisrt  = ul.find("li").first();
const imgCount = ul.children().length;
const width = 260;
ul.css("width",(width*imgCount)+"px");
let imgNo = 0;      
// ul.css("transform","translateX("+(imgNo*-1200)+"px)");
let intervalId;

next.on("click",function(){
    ul.css("transform","translateX(-"+260+"px)").css("transition-duration","1s");
    setTimeout(function(){
        const li2 = $(".topimg>ul>li");    
        ul.append(li2.eq(0));
        ul.css("transform","translateX("+0+"px)").css("transition-duration","0s");
        imgNo=0;
    },1000);
    
});


const acordBtn = $(".accordion-btn");
const acordCont = $(".accordion-content");
acordCont.css("display","none");
const upBtn = $(".dd");

acordBtn.on("click",function(){
    const index = acordBtn.index(this);
    if(upBtn.eq(index).hasClass("h1")){
        upBtn.eq(index).removeClass("h1").addClass("h2");
        upBtn.eq(index).text("expand_less");
        acordCont.eq(index).slideDown(250);
    }else{
        upBtn.eq(index).removeClass("h2").addClass("h1");
        upBtn.eq(index).text("expand_more");
        acordCont.eq(index).slideUp(250);
    }
});


const slide2 = $(".mmid");
const slide2Btn = $(".inner button");
const slideInner = $(".inner-buttom");
let timeOut = 0;

slide2Btn.on("click",function(){
    const index = slide2Btn.index(this);
    const idx = index%4;
    slide2.hide();
    slide2.eq(idx).show();
});
function again(){
    if(timeOut==0){
        setInterval(function(){
            slide2Btn.eq(timeOut*5).click();
            timeOut++;
            if(timeOut==4){
                timeOut=0;
            }
        },2000)   
    }
};
again();

