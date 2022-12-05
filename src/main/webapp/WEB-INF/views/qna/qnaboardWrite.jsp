
<%@page import="nbd.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 작성</title>

    <link rel="stylesheet" href="https:/fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet"  href="/css/qnaboardWrite.css">
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
    <div class="page-content" id="qnaboardWrite">
        <div class="page-title writetitle">QnA 작성</div> <!--첨부파일이 있을수도 있고 없을수도 있을때 꼭 필요 -->
		<form action="/qnaWrite.do" method="post" enctype="multipart/form-data" onsubmit="return wirtFrm(this);"> <!--파일형식을 form태그로 보낼때는  method="post" enctype="multipart/form-data" 2가지 필수!!!!-->
			<table class="tbl qnaboardwritetbl" id="qnaboardWritee">
				<tr class="tr-1">
					<th class="td-3">제목</th> 
					<td colspan="3"> <!--colspan=4 로 해서 input만 써도 됨 -->
						<input type="text" name="qnaTitle" class="input-form" id="qnatitleinput">
					</td>
				</tr>
				<tr class="tr-1">
					<th class="td-3">작성자</th>
					<td>
					<%=m.getMemberId()%>
					<input type="hidden" name="qnaWriter" value="<%=m.getMemberId()%>"><!--사용자한테는 안보여주지만 값은 넘겨주고 싶을때 사용하는게 hidden --><!--파일은 한번더 포장되어있음 : lib폴더에 cos라는 라이브러리를 사용함 -->
					</td>
				<th class="td-3">첨부파일</th>
				<td><input type="file" name="upfile"></td> <!--파일 name중요 -->
				</tr>
				<tr class="tr-1"> 
					<td colspan="4" style="text-align:left;">
					<textarea name="qnaContent" class="input-form" id="qnaboarwriteinput"></textarea>
					</td>
				</tr>
				<tr class="tr-1">
					<td colspan="4">
					<button type="submit" class="btn bc1 bs4" id="writeBtn">작성</button>
					<button type="button" class="btn bc1 bs4 cancel" id="writeBtn">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script src="/js/qnaboardWrite.js"></script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>