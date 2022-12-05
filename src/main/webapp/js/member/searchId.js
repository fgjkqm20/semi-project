function searchId(){
	if(!authMailPass){
		alert("이메일 인증을 완료해주세요.");
	}else{
		$(location).attr("href", "/showId.do?memberId=" + emailId + "&enrollDate=" + emailEnrollDate);
	}
};