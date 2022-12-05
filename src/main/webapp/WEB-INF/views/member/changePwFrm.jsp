<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String memberId = request.getParameter("memberId");
    	String fail = (String)request.getAttribute("fail");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nearbyDoctor 비밀번호 재설정</title>
	<link rel="stylesheet" href="/css/member/changePwFrm.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content" style="width:670px;">
		<div class="page-header">
			<div class="page-title">
				<p>비밀번호 재설정</p>
			</div>
			<p>비밀번호를 변경해 주세요.</p>
		</div>
		<form action="/changePw.do" method="post" id="change-pw-frm">
			<div class="pw-change-box-wrap">
				<p id="id-text">nearbyDoctor 아이디 : 
				<span style="color:#10CB9C;">
				<%=memberId %></span></p>
				<input type="hidden" value=<%=memberId %> name="id" id="id">
				
				<div class="pw-change-box">
					<input type="password" 
					name="pw" id="pw" required
					class="input-form2" 
					placeholder="새 비밀번호"
					style="width:300px;">
					<span id="pwComment"></span>
				</div>

				<div class="pw-change-box">
					<input type="password" 
					name="pwChk" id="pwChk" required
					class="input-form2" 
					placeholder="새 비밀번호 확인"
					style="width:300px;">
					<span id="pwChkComment"></span>
				</div>
				
				<p id="note">※8~20자 영문 대문자 또는 소문자, 숫자, 특수문자를 조합한 비밀번호를 입력해주세요.</p>
			</div>
			<button type="submit"
			class="btn bc1 check-btn"
			style="display:block;">
			확인</button>
		</form>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		const fail = "<%=fail %>";
		if(fail != "null"){
			alert(fail);
		}
	</script>
	<script src="/js/member/pwValidation.js"></script>
</body>
</html>