<%@page import="nbd.counsel.model.vo.Counsel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String categoryIndex = null;
    	if(request.getParameter("categoryIndex") != null){
    		categoryIndex = request.getParameter("categoryIndex");
    	}
    	
    	ArrayList<Counsel> list = (ArrayList<Counsel>)request.getAttribute("list");
    	String pageNavi = (String)request.getAttribute("pageNavi");
    	
    	String viewFail = (String)request.getAttribute("viewFail");
    	String writeFail = (String)request.getAttribute("writeFail");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nearbyDoctor 건강상담</title>

<link rel="stylesheet" href="/css/counsel/counselList.css">
<link rel="stylesheet" href="/css/counsel/pageNavi.css">

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content" style="width:960px;">
		<div class="page-title">
			<p>건강 상담</p>
			<p>온 가족건강은 니어바이닥터에게 무엇이든 물어보세요</p>
		</div>
		<div class="counsel-category">
			<%String subject[] = { "전체", "내과", "비뇨기과", 
					"산부인과", "신경외과", "안과", "외과", "이비인후과", 
					"정신건강의학과", "정형외과", "치과", "피부과" }; %>
			<%for(int i=0; i<12; i++) {%>
				<%String href = "/counselSubjectList.do?" +
						"clickIndex=1&categoryIndex=" + i + 
						"&counselSubject=" + subject[i] + 
						"&reqPage=1"; %>
				<a class="subject-search" href=<%=href %>>
					<div class="subject-content">
						<div class="subject-inner">
							<%String src="/img/counsel/" + i + ".png"; %>
							<img class="subject-image" src=<%=src %>
							width="50px" height="50px">
							<p class="subject-text"><%=subject[i] %></p>
						</div>
					</div>
				</a>
			<%} %>
		</div>
		<div class="counsel-write" align="right">
			<%if(m != null && m.getMemberGrade() == 3) {%>
				<%String url = "location.href=" + 
					"'/writeFrm.do?" + 
					"clickIndex=1'"; %>
				
				<button class="btn bc1"
				onclick=<%=url %>>
				건강 상담 등록</button>
			<%}else {%>
				<button class="btn bc1"
				style="visibility:hidden;"></button>
			<%} %>
		</div>
		<form action="/titleSearch.do?clickIndex=1&reqPage=1" method="post" id="login-frm">
			<div class="counsel-search" align="right">
				<input type="text" name="searchInput" 
				id="searchInput" class="input-form2" 
				placeholder="검색어를 입력해주세요."
				style="width:250px;
				display:block;">
				
				<button type="submit"
				class="btn bc1"
				style="display:block;">
				검색</button>
			</div>
		</form>
		<table class="tbl counsel-board" style="width:960px; table-layout: fixed;">
			<tr class="tr-1" id="counsel-board-top">
				<td style="width:7%;">번호</td>
				<td style="width:16%;">진료과</td>
				<td style="width:40%;">제목</td>
				<td style="width:15%;">작성일</td>
				<td style="width:13%;">작성자</td>
				<td style="width:9%;">답변여부</td>
			</tr>
			<%for(Counsel c : list) {%>
				<tr class="tr-1">
					<td><%=c.getCounselNo() %></td>
					<td><%=c.getCounselSubject() %></td>
					<td class="title" style="width:40%; 
					white-space: nowrap;">
						<a href="/counselView.do?clickIndex=1&
						counselNo=<%=c.getCounselNo() %>">
						<%=c.getCounselTitle() %></a>
					</td>
					<td><%=c.getCounselDate() %></td>
					<td><%=c.getMemberId() %></td>
					<td>
						<%if(c.getCounselAnswer() == 0){ %>
							답변대기
						<%}else{ %>
							답변완료
						<%} %>
					</td>
				</tr>
			<%} %>
		</table>
		<div class="pagenumber-warp">
			<div class="pagenumber-list"><%=pageNavi %></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		const category = $(".subject-content");
		const text = $(".subject-text");
	
		const categoryIndex = <%=categoryIndex %>;
		if(categoryIndex != null){
			category.css("background", "#ffffff");
			category.eq(categoryIndex).css("background-image", "linear-gradient(#ffffff 96%, #10cb9c 4%)");
			
			text.css("color", "black");
			text.eq(categoryIndex).css("color", "#10cb9c");
		}
		
		const viewFail = "<%=viewFail %>";
		if(viewFail != "null"){
			alert(viewFail);
		}
		
		const writeFail = "<%=writeFail %>";
		if(writeFail != "null"){
			alert(writeFail);
		}
	</script>
	<script src="/js/counsel/counselList.js"></script>
</body>
</html>