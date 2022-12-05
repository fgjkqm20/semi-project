<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nearbyDoctor 아이디 찾기</title>
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
				<div class="searchIdFrm-content">
					<div class="member-input-box">
						<label for="email">이메일</label>
						<div class="member-input-btn">
							<input type="text" 
							name="email" id="email"
							class="input-form2" 
							style="width:235px;
							display:block;">
							<button class="btn bc1"
							type="button"
							onclick="sendAuthMail();"
							style="width:155px;
							display:block;">
							인증번호 발송</button>
						</div>
						
						<label for="authCode">인증번호</label>
						<div class="member-input-btn">
							<input type="text" 
							name="authCode" id="authCode"
							class="input-form2" 
							style="width:235px;
							display:block;">
							<button class="btn bc1"
							type="button"
							onclick="auth();"
							style="width:155px;
							display:block;">
							인증 하기</button>
						</div>
					</div>
					<div class="member-btn-box">
						<button type="button"
						onclick="searchId();"
						class="btn bc1 searchId-btn"
						style="width:400px;">
						아이디 찾기</button>
					</div>
					<div class="member-link">
						<a href="/searchPwFrm.do">
							비밀번호 찾기
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
	<script src="/js/member/authMail.js"></script>
	<script src="/js/member/searchId.js"></script>
</body>
</html>