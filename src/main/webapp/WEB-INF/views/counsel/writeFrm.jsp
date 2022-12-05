<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nearbyDoctor 건강상담 등록</title>
	<link rel="stylesheet" href="/css/counsel/writeFrm.css">
	<link rel="stylesheet" href="/summernote/summernote-lite.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<script src="/summernote/summernote-lite.js"></script>
	<script src="/summernote/lang/summernote-ko-KR.js"></script>
	
	<div class="page-content">
		<form action="/write.do" method="post" enctype="multipart/form-data">
			<table class="board-tbl">
				<tr>
					<td class="board-colored">제목</td>
					<td colspan="3"><input type="text" name="title" class="input-form2" 
					style="width:100%;"
					placeholder="제목을 입력하세요"></td>
				</tr>
				<tr>
					<td class="board-colored" style="width:25%;">작성자</td>
					<td style="width:15%;">
						<%=m.getMemberId() %>
						<input type="hidden"
						name="writer"
						value="<%=m.getMemberId() %>">
					</td>
					<td class="board-colored" style="width:15%;">과목선택</td>
					<td style="width:45%;">
						<select name="subject" style="width:100%">
	                        <option disabled selected>과목선택</option>
	                        <option value="내과">내과</option>
	                        <option value="외과">외과</option>
	                        <option value="비뇨기과">비뇨기과</option>
	                        <option value="산부인과">산부인과</option>
	                        <option value="신경외과">신경외과</option>
	                        <option value="안과">안과</option>
	                        <option value="이비인후과">이비인후과</option>
	                        <option value="정신건강의학과">정신건강의학과</option>
	                        <option value="정형외과">정형외과</option>
	                        <option value="치과">치과</option>
	                        <option value="피부과">피부과</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="board-colored">첨부파일</td>
					<td colspan="3">
						<input type="file" accept=".jpg, .png" 
							class="file-upload" name="upfile">
						<p>( 첨부파일 최대 10MB까지. jpg, png만 업로드 가능 )</p>
					</td>
				</tr>
			</table>
			<div class="board-editor">
				<textarea id="board-content" name="content" class="input-form2"></textarea>
			</div>
			<div class="border-write">
				<button class="btn bc1"
				type="submit"
				style="float:right;">
	        	작성완료</button>
			</div>
		</form>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script src="/js/counsel/writeFrm.js"></script>
</body>
</html>