$("button.cancel").on("click",function(){
    if(confirm("글쓰기를 취소하시겠습니까?")){
        location.href="/qnaList.do?reqPage=1";
   }
});
//글쓰기 작성시, 제목과 내용이 입력이 안되면  SUBMIT을 보내지X
function wirtFrm(form){
    if(form.qnaTitle.value==""){
        alert("제목을 입력하세요");
        form.qnaTitle.focus();
        return false;
    }
    if(form.qnaContent.value == ""){
        alert("내용을 입력하세요");
        form.qnaContent.focus();
        return false;
    }
}

//썸머노트
$("#qnaboarwriteinput").summernote({
        height: 400,
        lang: "ko-KR",
            callbacks :{
                onImageUpload : function(files){
                   uploadImage(files[0],this); //this는 에디더
                }
             }

     });
     
     function uploadImage(file,editor){
   	  //ajax통해서 서버에 이미지를 업로드
   	  //업로드된 이미지의 경로를 받아오는 역할
   	  //<form>태그와 동일한 효과를 발생시킬 수 있는 객체 
      const form = new FormData();
        form.append("file",file);
        $.ajax({
           url : "/uploadImage.do",
           type : "post",
           data : form,
           processData : false,// -> 문자열을 false로 파일형태야~라고 해주는거 
           contentType : false,
           success : function(data){
           	$(editor).summernote("insertImage",data);

           }
        });

   	  //processData : 전송하는 데이터를 문자열로 전송하게 기본값이 설정되어있음
   	  // 			-> 파일 전송을 위해 기본값 제거하는 작업
   	  //contentType : enctype ="application/x-www-urlencoded; charsset=UTF-8"
     	// 				-> 설정되어 있는 기본 enctype을 제거 
     }
     
