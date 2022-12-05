function modifyComment(commentNo, counselNo){
	$(".commentContent").hide();
	$(".commentContentModify").show();
	
	$(".commentUpdate").text("수정 완료");
	$(".commentUpdate").attr("onclick", 
		"modifyComplete(" + commentNo + ", " + counselNo + ")");
		
	$(".commentDelete").text("수정 취소");
	$(".commentDelete").attr("onclick", 
		"modifyCancel(" + commentNo + "," + counselNo + ")");
}

function modifyComplete(commentNo, counselNo){
	// form 태그를 생성해서 전송
	// 1. form 태그 생성
	const form = $("<form action='/commentModify.do' method='post'></form>");
	// 2. input 태그 생성(commentNo)
	const commentInput = $("<input type='text' name='commentNo'>");
	commentInput.val(commentNo);
	// form 태그에 추가
	form.append(commentInput);
	// 3. input 태그 생성(counselNo)
	const counselInput = $("<input type=='text' name='counselNo'>");
	counselInput.val(counselNo);
	form.append(counselInput);
	// 4. textarea
	const commentContent = $(".commentContentModify");
	form.append(commentContent);
	$("body").append(form);
	form.submit();
}

function modifyCancel(commentNo, counselNo){
	$(".commentContent").show();
	$(".commentContentModify").hide();
	
	$(".commentUpdate").text("수정");
	$(".commentUpdate").attr("onclick", 
		"modifyComment(" + commentNo + ", " + counselNo + ")");
		
	$(".commentDelete").text("삭제");
	$(".commentDelete").attr("onclick", 
		"deleteComment(" + commentNo + "," + counselNo + ")");
}

function deleteComment(commentNo, counselNo){
	if(confirm("댓글을 삭제하시겠습니까?")){
		location.href="/deleteComment.do?" +
				"commentNo=" + commentNo + "&counselNo=" + counselNo;
	}
}