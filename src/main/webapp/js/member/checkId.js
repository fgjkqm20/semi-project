let inputId;
let checkIdPass = false;

function checkId(){
	inputId = $("#id").val();
	
	if(inputId == ""){
		alert("아이디을 입력해주세요.");
		return;
	}
	
	$.ajax({
		url : "/checkId.do",
		data : { inputId:inputId },
		type : "post",
		success : function(result){
			if(result == "true"){
				checkIdPass = true;
				alert("아이디가 확인되었습니다.");
			}else{
				alert("존재하지 않는 아이디입니다.");
			}
		}
	});
}