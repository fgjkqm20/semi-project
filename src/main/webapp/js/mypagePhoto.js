// 프로필 사진 모달


const photoModal = $(".pmodal-wrap");
$("#pp-btn").on("click", function(){
	photoModal.css("display", "flex");
})

$(".pmodal-btn-box>button:first-child").on("click",function(){
	photoModal.css("display", "none");
	$("#profilPhoto").val("");
})



// 모달에서 사진 보여주기

//this = input태그 자체를 의미
function loadImg(f){
	console.log(f.files);//input에서 file을 선택하면 해당 파일이 들어있는 배열로 리턴
	if(f.files.length != 0 && f.files[0] != 0){ // 배열의 길이가 0이 아니면서, 파일의 데이터가 0이 아닐 때
		const reader = new FileReader(); //파일 정보를 읽어올 수 있는 객체
		reader.readAsDataURL(f.files[0]); //배열에서 선택한 파일 정보 읽어옴 (비동기)
		reader.onload = function(e){	//파일 리더가 파일을 다 읽어오면 동작한 함수
			$("#img-view").attr("src", e.target.result);
		}
	}else {
		$("#img-view").attr("src", "");
	}
}
//  onchange="loadImg(this);" 사용법


$("#profilPhoto").on("change", function(){
	loadImg(f);
})

$("button.delFile").on("click", function(){
	$(".delFile").hide();
	$(this).next().show();
	$("[name=status]").val("delete");
	$(".profil-tbl").find(img).attr("src", "/img/기본프로필_녹색.jpg");
})



