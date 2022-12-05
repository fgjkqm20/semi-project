<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nearbyDoctor 로그인</title>
	<link rel="stylesheet" href="/css/member/member.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="member-wrap">
		<div class="member-border">
			<div class="member-border-inner">
				<div class="member-header">
					<img src="/img/common/로고.png"
					width="210px" height="70px">
				</div>
				<div class="login-content">
					<form action="/login.do" method="post" id="login-frm">
						<div class="member-input-box">
							<label for="memberId">아이디</label>
							<input type="text" 
							name="memberId" id="memberId" required 
							class="input-form2" 
							style="width:400px;">
							<label for="memberPw">비밀번호</label>
							<input type="password" 
							name="memberPw" id="memberPw" required
							class="input-form2" 
							style="width:400px;">
						</div>
						<div class="member-btn-box">
							<button type="submit" 
							class="btn bc1"
							style="width:400px;">
							로그인</button>
						</div>
					</form>
					<div class="member-link">
						<a href="/searchIdFrm.do">
							아이디 찾기
						</a>
						&nbsp;|&nbsp;
						<a href="/searchPwFrm.do">
							비밀번호 찾기
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>