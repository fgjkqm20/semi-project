<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String memberId = request.getParameter("memberId");
    	String enrollDate = request.getParameter("enrollDate");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nearbyDoctor 아이디 찾기 결과</title>
	<link rel="stylesheet" href="/css/member/showId.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content" style="width:670px;">
		<div class="page-header">
			<div class="page-title">
				<p>아이디 찾기 결과</p>
			</div>
			<p>고객님의 정보와 일치하는 아이디입니다.</p>
		</div>
		<div class="id-addr-box">
			<p style="color:#10CB9C;"><%=memberId %></p>
			<p>가입 : <%=enrollDate %></p>
		</div>
		<div class="page-btn-box-wrap">
			<div class="page-btn-box">
				<button class="btn bc1"
				style="display:block;"
				onclick="location.href='/loginFrm.do'">
				로그인 하기</button>
				<button class="btn bc1"
				style="display:block;"
				onclick="location.href='/searchPwFrm.do'">
				비밀번호 찾기</button>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>