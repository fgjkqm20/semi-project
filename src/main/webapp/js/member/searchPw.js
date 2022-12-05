function searchPw(){
	if(checkIdPass && authMailPass){
		if(inputId == emailId){
			$(location).attr("href", "/changePwFrm.do?memberId=" + inputId);
		}else{
			alert("입력한 아이디에 해당하는 이메일 또는 입력한 이메일에 해당하는 아이디를 입력해주세요.");
		}
	}else if(checkIdPass){
		alert("이메일 인증을 완료해주세요.");
	}else if(authMailPass){
		alert("아이디 확인을 완료해주세요.");
	}else{
		alert("아이디 확인 및 이메일 인증을 완료해주세요.");
	}
};