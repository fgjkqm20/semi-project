const showOut = $(".CloseCancel");
const aboutPatient = $(".patientClose");
const showMe = $(".reservate>.status>button:last-child");
showMe.on("click",function(){
    aboutPatient.css("display","block");
});
showOut.on("click",function(){
    aboutPatient.css("display","none");
}); 
//지금은 한데이터만 불러오기 때문에 데이터를 넣었을때는 eq(i) , this()를써야함

const reserCont = 0;
const reserBtn = $(".reservate>.status>button:first-child");

const patientBtn = $(".patientstat");
let BtnCount = 0;


patientBtn.on("click",function(){
    if(BtnCount == 0){
        const index = patientBtn.index(this);
        const patientBtnText = patientBtn.eq(index);
        patientBtn.eq(index).css("background-color", "lightgrey");
        patientBtn.eq(index).css("border", "dimgrey");
        patientBtnText.text("진료완료");
        BtnCount++;
        console.log(BtnCount);
    }else if(BtnCount ==1){
        const index = patientBtn.index(this);
        const patientBtnText = patientBtn.eq(index);
        patientBtn.eq(index).css("background-color", "#449f8d");
        patientBtn.eq(index).css("border", "#449f8d");
        patientBtnText.text("예약중");
        BtnCount--;
        console.log(BtnCount);
    }
    
});
