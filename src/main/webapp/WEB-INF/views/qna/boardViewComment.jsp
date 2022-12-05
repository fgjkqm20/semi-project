<%@page import="nbd.qna.model.vo.QnaComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="nbd.qna.model.vo.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% //servlet에서 보내준거 받기 
    	Qna q = (Qna) request.getAttribute("q");
    	ArrayList<QnaComment> commentList = (ArrayList<QnaComment>)request.getAttribute("commentList"); //댓글
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA 게시판</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet"  href="/css/boardViewComment.css">
    <link rel="stylesheet"  href="/css/common/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
		 <div class="main-img">QnA 게시판
        	<div>제휴문의, 입점신청 등 무엇이든지 물어보세요</div>
    	</div>
    <div class="page-content" id="commentpage">
        <table class="tbl boardView" id="boardlistwarp">
            <div class="content-list">
                <a href="/qnaList.do?reqPage=1" class="btn bc2" id="qna-list">목록</a> <!-- 이전으로 돌아가기 -->
            </div>
            <tr class="tr-3">
                <th colspan="6"><%=q.getInfoTitle() %></th>
            </tr>
            <tr class="tr-1">
                <th class="td-3">작성자</th>
                <th><%=q.getMemberId() %></th>
                <th class="td-3">조회수</th>
                <th><%=q.getInfoCount() %></th>
                <th class="td-3">작성일</th>
                <th><%=q.getInfoDate() %></th>
            </tr>
            <tr class="tr-1">
                <th class="td-3">첨부파일</th>
                <td colspan="5">
                <%if(q.getFileName() != null){ %>
                    <img src="/img/file.png" width="16px">
                    <a href="/qnaFileDown.do?InfoNo=<%=q.getInfoNo()%>"><%=q.getFileName() %></a>
                    <%} %>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    <div id="boardContent">
                    	<%=q.getQnaContentBr() %><%--텍스내용 엔터 --%> 
                    </div>
                </td>
            </tr>
            <% if(m!=null && q.getMemberId().equals(m.getMemberId())) {%><!--게시글 수정 : 로그인이 되어있으면서, 작성자랑 세션에 로그인된 아이디가 같을때   -->
            <tr class="tr-1">
                <th colspan="6">
                    <a class="btn bc2 updateBtn" href="/qnaUpdateFrm.do?InfoNo=<%=q.getInfoNo()%>">수정</a>
                    <a class="btn bc2 updateBtn" onclick="qnaDelete(<%=q.getInfoNo()%>)">삭제</a>
                </th>
            </tr>
            <%} %>
        </table>
        <%if(m!=null && m.getMemberGrade()==1){ %><!--  로그인이 되어있을때 댓글  -->
        <div class="inputCommentBox">
            <form action="/insertCommentq.do" method="post">
            	<ul>
                	<li>
                    	<span class="material-symbols-outlined">face_6</span>
                	</li>
                	<li>
                    	<input type="hidden" name="memberId" value="<%=m.getMemberId()%>"> <!-- 로그인된 아이디가 들어워야하는거지? -->
                    	<input type="hidden" name="infoNo" value="<%=q.getInfoNo()%>"><%--어떤공지사항의 댓글인지 --%>
                    	<input type="hidden" name="commentNo" value="0">
                    	<textarea class="input-form" name="commentContent"></textarea>
                	</li>
                	<li>
                		<button type="submit" class="btn bc2" id="comment-button">등록</button>
                	</li>
            	</ul>
            </form>
        </div>
        <%} %>
        <div class="commentBox"> <!-- 댓글달면 밑에 달았던 댓글 보여주기 -->
        	<%for(QnaComment qc : commentList) {%>
            <ul class="posting-comment">
                <li>
                    <span class="material-symbols-outlined">face_6</span><!-- 아이콘 -->
                </li>
                <li>
                    <p class="comment-info">
                        <span><%=qc.getMemberId() %></span> <!-- 코멘트작성자 -->
                        <span><%=qc.getCommentDate() %></span>
                    </p>								<!--br처리해줘야함 -->
                    <p class="comment-content"><%=qc.getQnaCommentContentBr()%></p>																
                    <textarea name="qcContent" class="input-form" id="updateCommentText" style="min-height:96px;display:none;"><%=qc.getCommentContent() %></textarea> <!-- br처리가 되어있어서 X -->
                    <p class="comment-link">
					<%if(m!=null){%><!-- 내가 쓴 댓글에만 수정 삭제가 나올 수 있게 -->
						<%if(m.getMemberId().equals(qc.getMemberId()) || m.getMemberGrade()==1) {%>
                            <a href="javascript:void(0)" onclick="modifyComment(this,<%=qc.getCommentNo()%>,<%=q.getInfoNo()%>);">수정</a>
                            <a href="javascript:void(0)" onclick="deleteComment(this,<%=qc.getCommentNo()%>,<%=q.getInfoNo()%>);">삭제</a>               
            		<%} %>
				<%} %>
                    </p>
                </li>
            </ul>
            <%} %>
         </div>
    </div>
    <script src="/js/boardViewComment.js"></script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>