<%@page import="nbd.member.model.vo.Member"%>
<%@page import="nbd.qna.model.vo.Qna"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    <% 
    	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
    	String pageNavi = (String)request.getAttribute("pageNavi");

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA 게시판</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet"  href="/css/common/default.css">
    <link rel="stylesheet"  href="/css/QnAboardlist.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
		    <div class="main-img">QnA 게시판
		 		<div>제휴문의, 입점신청 등 무엇이든지 물어보세요</div>
		 	</div>
    <div class="page-content" id="boardlistwarp">
        <div class="page-title">
            <%if(m != null){%> <%--로그인이 되어있을때 헤더에 세션가져오고 -> 글쓰기 --%>
            <a class="btn bc2 writeBtn" href="/qnaWriteFrm.do">글쓰기</a>
            <%} %>
        </div>
        <table class="tbl tbl-hover notice-tbl">
            <tr class="tr-2">
                <th style="width:10%;">번호</th>
                <th style="width:45%;">제목</th>
                <th style="width:15%;">작성자</th>
                <th style="width:20%;">작성일</th>
                <th style="width:10%;">조회수</th>
            </tr>
    		<%for(Qna q : list) {%>
            <tr class="tr-1">
                <td><%=q.getInfoNo() %></td>
                <td>
                    <!--게시글 제목 클릭했을때 해당페이지로 이동할 수 있게  : 번호를 매개변수로 주는거임-->
                    <a href="/qnaView.do?InfoNo=<%=q.getInfoNo()%>"><%=q.getInfoTitle() %><span style='color:rgb(255, 197, 0);'>[<%=q.getCommentCnt() %>]</span></a>
                </td>
                <td><%=q.getMemberId() %></td>
                <td><%=q.getInfoDate() %></td>
                <td><%=q.getInfoCount() %></td>
            </tr>
            <%} %>
        </table>
        <div class="pagenumber-warp">
           <div class="pagenumber-list">
                <%=pageNavi %>
            </div>
        </div>
    </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>