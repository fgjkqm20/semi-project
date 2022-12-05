<%@page import="nbd.counsel.model.vo.CounselComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="nbd.counsel.model.vo.Counsel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Counsel c = (Counsel)request.getAttribute("c");
		CounselComment comment
				= (CounselComment)request.getAttribute("comment");
		
		String commentWriteFail = 
				(String)request.getAttribute("commentFail");
		String counselModifyFail = 
				(String)request.getAttribute("counselModifyFail");
		String counselDeleteFail = 
				(String)request.getAttribute("counselDeleteFail");
		
		String commentModifyFail = 
				(String)request.getAttribute("commentModifyFail");
		String commentDeleteFail = 
				(String)request.getAttribute("commentDeleteFail");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nearbyDoctor 건강상담 글 보기</title>

<link rel="stylesheet" href="/css/counsel/counselView.css">

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<%
		boolean writerCheck = false;
		boolean managerCheck = false;
		boolean doctorCheck = false;
		boolean subjectCheck = false;
		boolean commentWriterCheck = false;
		
		if(m != null) {
			managerCheck = m.getMemberGrade() == 1;
			doctorCheck = m.getMemberGrade() == 2;

			if(c != null){
				writerCheck = m.getMemberId().equals(c.getMemberId());
				if(m.getMemberGrade() == 2){
					subjectCheck = m.getMajor().equals(c.getCounselSubject());
				}
			}
			
			if(comment != null){
				commentWriterCheck = m.getMemberNo() == comment.getCommentWriterNo();
			}
		}
	%>
	<div class="page-content">
		<table class="board-tbl">
			<tr>
				<td class="board-colored">제목</td>
				<td class="board-info" colspan="5">
				<%=c.getCounselTitle() %></td>
			</tr>
			<tr>
				<td class="board-colored" style="width:20%;">작성자</td>
				<td class="board-info" style="width:16%;">
					<%=c.getMemberId() %>
				</td>
				<td class="board-colored" style="width:16%;">과목</td>
				<td class="board-info" style="width:16%;">
					<%=c.getCounselSubject() %>
				</td>
				<td class="board-colored" style="width:16%;">첨부파일</td>
				<td class="board-info" style="width:16%;">
					<%if(c.getFileName() != null) {%>
						<%String down = "/fileDown.do?" +
								"counselNo=" + c.getCounselNo(); %>
						<a href=<%=down %>><%=c.getFileName() %></a>
					<%} %>
				</td>
			</tr>
		</table>
		<div class="board-content">	
			<%=c.getCounselContent() %>
		</div>
		<%if(m != null) {%>
			<div class="board-change-btn-box-wrap">
				<div class="board-change-btn-box">
					<%if(writerCheck || managerCheck) {%>
						<%if(writerCheck && comment == null) {%>
							<%String updateUrl = "location.href=" + 
								"'/counselModifyFrm.do?clickIndex=1&" + 
								"counselNo=" + c.getCounselNo() + "'"; %>
						
							<button class="btn bc1"
							onclick=<%=updateUrl %>
							style="display:block;">
							수정</button>
						<%} else{%>
							<button class="btn"
								style="display:block;
								visibility:hidden;"></button>
						<%} %>
						<button class="btn bc1"
						onclick="deleteCounsel()"
						style="display:block;">
						삭제</button>
					<%} %>
				</div>
			</div>
		<%} %>
		<%if(m != null && doctorCheck && subjectCheck && comment == null) {%>
			<div class="inputCommentBox-wrap">
				<div class="inputCommentBox">
					<form action="/insertComment.do" method="post">
						<ul>
							<li style="width:79%; height:75px;">
								<input type="hidden" name="commentWriterNo" 
								value=<%=m.getMemberNo() %>>
								<input type="hidden" name="commentWriterName" 
									value=<%=m.getMemberName() %>>
								<input type="hidden" name="counselNo" 
									value=<%=c.getCounselNo() %>>
								<textarea class="input-form2" 
								name="commentContent"
								style="width:100%;
								height:100%;"></textarea>
							</li>
							<li style="width:1%;background:#f2f5f9;"></li>
							<li style="width:20%;">
								<button type="submit" 
								class="btn bc1"
								style="width:100%;
								height:100%;">등록</button>
							</li>
						</ul>
					</form>
				</div>
			</div>		
		<%} %>
		<%if(comment != null) {%>
			<div class="commentBox-wrap">
				<div class="commentBox">
					<div class="commentInfo">
						<p class="commentWriter">
						<%=comment.getCommentWriterName() %> 
						<span>의사</span></p>
						<p class="commentDate">
						<%=comment.getCommentDate() %></p>
						<div class="commentChange">
							<%if(commentWriterCheck || managerCheck) {%>
								<%if(commentWriterCheck) {%>
									<a class="commentUpdate"
									href="javascript:void(0)"
									onclick="modifyComment
									(<%=comment.getCommentNo() %>,
									<%=c.getCounselNo() %>);">수정</a>
								<%} %>
								<a class="commentDelete" 
								href="javascript:void(0)"
								onclick="deleteComment
								(<%=comment.getCommentNo() %>,
								<%=c.getCounselNo() %>);">삭제</a>
							<%} %>
						</div>
					</div>
					<p class="commentContent">
						<%=comment.getCommentContent() %></p>	
					<textarea class="input-form2 commentContentModify" 
						name="commentContent"
						style="width:100%; height:100%; display:none;"
						><%=comment.getCommentContent() %></textarea>
				</div>
			</div>
		<%} %>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		const commentWriteFail = "<%=commentWriteFail %>";
		if(commentWriteFail != "null"){
			alert(commentWriteFail);
		}
		
		const counselModifyFail = "<%=counselModifyFail %>";
		if(counselModifyFail != "null"){
			alert(counselModifyFail);
		}
		
		const counselDeleteFail = "<%=counselDeleteFail %>";
		if(counselDeleteFail != "null"){
			alert(counselDeleteFail);
		}
		
		const commentModifyFail = "<%=commentModifyFail %>";
		if(commentModifyFail != "null"){
			alert(commentModifyFail);
		}
		
		const commentDeleteFail = "<%=commentDeleteFail %>";
		if(commentDeleteFail != "null"){
			alert(commentDeleteFail);
		}
		
		function deleteCounsel(){
			if(confirm("글을 삭제하시겠습니까?")){
				const counselNo = "<%=c.getCounselNo() %>";
				location.href="/counselDelete.do?clickIndex=1&" + 
				"counselNo=" + counselNo;
			}
		}
	</script>
	<script src="/js/counsel/comment.js"></script>
</body>
</html>