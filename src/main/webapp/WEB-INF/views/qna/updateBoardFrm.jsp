<%@page import="nbd.qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Qna q = (Qna)request.getAttribute("q");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA 게시판</title>
    <link rel="stylesheet" href="https:/fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet"  href="/css/updateBoardFrm.css">
    <link rel="stylesheet"  href="/css/common/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<script src="/summernote/summernote-lite.js"></script>
    	<script src="/summernote/lang/summernote-ko-KR.js"></script>
    	<link rel="stylesheet" href="/summernote/summernote-lite.css">
		 <div class="main-img">QnA 게시판
		 	<div>제휴문의, 입점신청 등 무엇이든지 물어보세요</div>
		 </div>
      <div class="page-content" id="boardlistwarp">
        <div class="page-title updatetitle">QnA 수정</div> <!--수정도 첨부파일있으니까   -->
        <form action="/qnaUpdate.do" method="post" enctype="multipart/form-data">
            <table class="tbl boardwritetbl" id="noticeUpdateFrm">
                <tr class="tr-1">
                    <th class="td-3">제목</th>
                    <td>
                    <input type="hidden" name="qnaNo" value="<%=q.getInfoNo()%>">
                    <!--기존파일 지웠는지 체크하는용도 -->
                    <input type="hidden" name="status" value="stay"> <!--기존파일 지워야해 ! 하는 신호를 주기위해 만들어둠 -->
                    <input type="text" name ="qnaTitle" class="input-form" id="boardwriteinput" value="<%=q.getInfoTitle()%>">
                    </td>
                </tr>
                    <tr class="tr-1">
                        <th class="td-3">첨부파일</th>
                        <td>
                            <%if(q.getFilePath() != null){%><!-- 파일이 있는경우 -->
                            <img src="/img/file.png" width="16px" class="delFile">
                            <span class="delFile"><%=q.getFileName() %></span>
                            <button type="button" class="btn bc1 delFile">삭제</button> <!--삭제하면 -->
                            <input type="file" name ="upfile" style="display:none;"><!--삭제하면 파일선택 나타나게 해줄꺼임-->
                            <input type="hidden" name="oldFilename" value="<%=q.getFileName()%>">
                            <input type="hidden" name="oldFilepath" value="<%=q.getFilePath()%>">
                           <%}else{ %> <!--파일이 없는경우 -->
                                <input type="file" name ="upfile">
                           <%} %>
                        </td>
                    </tr>
                  <tr class="tr-1">
                         <td class="td-3" colspan="4" id="qna-textupdate" style="text-align:left;">
                        <textarea class="input-form" id="boardwriteinput" name="qnaContent"><%=q.getInfoContent() %></textarea>
                        </td>
                    </tr>
                    <tr class="tr-1">
                        <th colspan="2">
                        <button type="submit" class="btn bc6 bs4" style="height:45px;">수정</button>
                        <button type="button" class="btn bc6 bs4 cancel" style="height:45px;">취소</button>
                        </th>
                    </tr>
            </table>
        </form>
    </div>
  <script>
  
  //첨부파일 
 	$("button.delFile").on("click",function(){
 		$(".delFile").hide();
 		$(this).next().show();
 		$("[name=status]").val("delete"); <%--status의 값이 delete로 넘어감--%>
 	});
 	//게시글 수정시 취소 버튼을 눌렀을때 
 	$("button.cancel").on("click",function(){
 		if(confirm("수정을 취소하시겠습니까?")){
 			history.back(); //그전에 보고있던 게시물로(뒤로가기)
 			//location.href="/qnaView.do?InfoNo="+InfoNo;
		}
 	});
 	//썸머노트
 	$("[name=qnaContent]").summernote({
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
 	
 </script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>