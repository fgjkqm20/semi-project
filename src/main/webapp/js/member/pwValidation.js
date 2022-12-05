let pwStatus = false;
let pwChkStatus = false;

$("#pw").on("keyup", function(){
	const pwReg = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{8,20}$/;
	const pwVal = $("#pw").val();
	
	const pwComment = $("#pwComment");
	if(pwVal == ""){
		pwComment.text("비밀번호를 입력해주세요.");
        pwComment.css("color", "red");
        pwStatus = false;
	}else if(pwReg.test(pwVal)){
	    pwComment.text("알맞은 비밀번호입니다.");
	    pwComment.css("color", "blue");
	    pwStatus = true;
    }else{
        pwComment.text("알맞지 않은 비밀번호입니다.");
        pwComment.css("color", "red");
        pwStatus = false;
    }
});

$("#pwChk").on("keyup", function(){
	const pwVal = $("#pw").val();
	const pwChkVal = $("#pwChk").val();
	
	const pwChkComment = $("#pwChkComment");
	if(pwVal == "" && pwChkVal == ""){
		pwChkComment.text("");
        pwChkStatus = false;
	}else if(pwVal == pwChkVal){
		pwChkComment.text("비밀번호가 일치합니다.");
		pwChkComment.css("color", "blue");
		pwChkStatus = true;
	}else{
		pwChkComment.text("비밀번호가 일치하지않습니다.");
		pwChkComment.css("color", "red");
		pwChkStatus = false;
	}
});

$(".check-btn").on("click", function(event){
	if(!pwStatus){
		alert("알맞지 않은 비밀번호입니다.");
		event.preventDefault();
	}else if(!pwChkStatus){
		alert("비밀번호가 일치하지않습니다.");
		event.preventDefault();
	}
});