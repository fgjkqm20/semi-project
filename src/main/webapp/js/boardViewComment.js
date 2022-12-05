  //게시글 삭제 버튼 눌렀을때
  function qnaDelete(InfoNo){
    if(confirm("게시글을 삭제하시겠습니까?"))
        location.href="/qnaDelete.do?InfoNo="+InfoNo;{ /* 삭제 하겠습니까? 라고 하면  delete로 이동 */	
    }
}
//게시글 댓글등록 클릭시 
function deleteComment(obj,CommentNo,InfoNo){
if(confirm("댓글을 삭제하시겠습니까?")){
    location.href="/qnaDeleteComment.do?CommentNo="+CommentNo+"&InfoNo="+InfoNo;
}
}
//댓글수정
function modifyComment(obj,CommentNo,InfoNo){
$(obj).parent().prev().show();//textarea 화면에 보영줌
    $(obj).parent().prev().prev().hide();//내용을 보여주던 p태그
    //수정-> 수정완료
    $(obj).text("수정완료");
    $(obj).attr("onclick","modifyComplete(this,"+CommentNo+","+InfoNo+")");
    //삭제-> 수정취소
    $(obj).next().text("수정취소");
    $(obj).next().attr("onclick","modifyCancel(this,"+CommentNo+","+InfoNo+")");
    
    //답글달기버튼 숨김
    $(obj).next().next().hide();
    
};
//댓글취소 
    function modifyCancel(obj,CommentNo,InfoNo){
    $(obj).parent().prev().hide();//textarea숨김
    $(obj).parent().prev().prev().show();//기존댓글 보여줌
    //수정완료-> 수정
    $(obj).prev().text("수정");
    $(obj).prev().attr("onclick","modifyComment(this,"+CommentNo+","+InfoNo+")");
    //수정취소-> 삭제 
    $(obj).text("삭제");
    $(obj).attr("onclick","deleteComment(this,"+CommentNo+","+InfoNo+")");
};
//댓글완료
function modifyComplete(obj,commentNo,InfoNo){
    //수정완료되었을때 
    //form태그를 생성해서 전송
    //1.form태그생성
    const form= $("<form action='/qnaUpdateComment.do' method='post'></form>");
    //2.input태그 생성(CommentNo)
    const qcInput = $("<input type='text' name='commentNo'>");
    //CommentNo값 세팅
    qcInput.val(commentNo);
    //form태그에 추가
    form.append(qcInput);
    //3.input 태그 생성(InfoNo)
    const qnaCommentInput=$("<input type='text' name='InfoNo'>");
    qnaCommentInput.val(InfoNo);
    form.append(qnaCommentInput);
    //4.textarea
    const qcContent = $(obj).parent().prev();
    form.append(qcContent);
    //body 태그에 생성한 form태그를 추가
    $("body").append(form);
    //form 태그 전송
    form.submit();
}
