<%@page import="nbd.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member m = (Member)session.getAttribute("m");
    	String loginFail = (String)request.getAttribute("loginFail");
    
    	String clickIndex = null;
    	if(request.getParameter("clickIndex") != null){
    		clickIndex = request.getParameter("clickIndex");
    	}
    %>
    
    <link rel="stylesheet" href="/css/common/default.css">
    <link rel="stylesheet" href="/css/common/header.css">
    <script src="/js/common/jquery-3.6.0.js"></script>
    
<header>
	<div class="header-wrap">
		<div class="header-logo">
			<a href="/">
				<img src="/img/common/로고.png"
				width="150px" height="50px">
			</a>
		</div>
		<nav>
			<ul class="header-navi">
				<%if(m != null && m.getMemberGrade() == 2) {%>
					<%String roomlink = "/treatmentRoom3.do?memberId=" + m.getMemberId() + "&clickIndex=0"; %>
					<li><a href=<%=roomlink %>>나의진료실</a></li>
				<%}else {%>
					<li><a href="/reservation.do?clickIndex=0">비대면진료</a>

					</li>
				<%} %>
				<li><a href="/counselSubjectList.do?
				clickIndex=1&categoryIndex=0&
				counselSubject=전체&reqPage=1">
				건강상담</a></li>
				<li><a href="/searchPharm.do?clickIndex=2">약국찾기</a></li>
				<li><a href="/qnaList.do?reqPage=1">QnA</a></li>
			</ul>
		</nav>
		<div class="header-link">
			<%if(m == null) {%>
				<a href="/loginFrm.do" style="color:white;">
					로그인
				</a>
				<a href="/join.do" style="color:white;">
					회원가입
				</a>
			<%}else{ %>
				<a href="/logout.do" style="color:white;">
					로그아웃
				</a>
				<%if(m != null && m.getMemberGrade() == 1) {%>
					<a href="/mypage.do?memberNo=<%= m.getMemberNo() %>&memberGrade=<%=m.getMemberGrade() %>" style="color:white; width:90px;">관리자페이지</a>
				<%}else {%>
					<a href="/mypage.do?memberNo=<%= m.getMemberNo() %>&memberGrade=<%=m.getMemberGrade() %>" style="color:white; width:90px;">마이페이지</a>
				<%} %>
			<%} %>
		</div>
	</div>
</header>

<script>
	const loginFail = "<%=loginFail %>";
	if(loginFail != "null"){
		alert(loginFail);
	}

	const headerMenu = $(".header-navi>li>a");
	let clickIndex = <%=clickIndex %>;

	if(clickIndex != null){
		headerMenu.css("color", "white");
		headerMenu.eq(clickIndex).css("color", "#10cb9c");
		
		headerMenu.css("border-bottom", "none");
		headerMenu.eq(clickIndex).css("border-bottom", "4px solid #10cb9c");
	}
	

</script>
<script src="/js/common/header.js"></script>