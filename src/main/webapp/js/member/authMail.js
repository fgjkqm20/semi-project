let authCode = null;
let authMailPass = false;
let emailId;
let emailEnrollDate;
let sendAble = true;

function sendAuthMail(){
	const email = $("#email").val();
	if(email == ""){
		alert("이메일을 입력해주세요.");
		return;
	}
	
	if(sendAble){
		sendAble = false;
		$.ajax({
			url : "/sendAuthMail.do",
			data : { email:email },
			type : "post",
			dataType : "json",
			success : function(data){
				sendAble = true;
				if(data.notMember != null){
					alert(data.notMember);
				}else if(data.failSend != null){
					alert(data.failSend);
				}else{
					emailId = data.memberId;
					emailEnrollDate = data.enrollDate;
					authCode = data.authCode;
					alert("인증번호를 발송하였습니다.");
				}
			},
			error : function(){
				sendAble = true;
				alert("인증을 진행할 수 없습니다.");
			}
		});
	}
}

function auth(){
	if(authMailPass){
		alert("이미 인증이 완료되었습니다.");
		return;
	}
	
	const inputAuthCode = $("#authCode").val();
	if(authCode != null){
		if(inputAuthCode == ""){
			alert("인증번호를 입력해주세요.");
		}else if(authCode == inputAuthCode){
			authMailPass = true;
			alert("인증이 완료되었습니다.");
		}else{
			alert("인증번호를 잘못 입력하셨습니다.");
		}
	}else{
		alert("인증번호 발송 버튼을 눌러 인증번호를 받아주세요.");
	}
}