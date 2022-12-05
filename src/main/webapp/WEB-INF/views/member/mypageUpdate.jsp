<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="/css/common/default.css">
    <link rel="stylesheet" href="/css/member/mypage-update.css">
<title>Insert title here</title>
<style>
#delete-box{
	margin-top: 16px;
	width: 890px;
	display: flex;
	justify-content: flex-end;
}
#delete-box>a:hover {
	text-decoration: underline;
}
.old-pw-box>span:first-child{
	display: none;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
        <%@include file="/WEB-INF/views/member/mypageHeaderPatient.jsp" %>
        <div class="mypage-content update-info">
        <div class="update-title">로그인 정보</div>
    <div class="info-box">
        <div>아이디</div>
        <div><%= m.getMemberId() %></div>
    </div>
    <div class="info-box">
	        <div>비밀번호</div>
	        <div class="old-pw-box">
	        	<span><%= m.getMemberPw() %></span>
	        	<span>●●●●●●●●●●</span>
	        	<span><button id="change-pw-btn" class="bc-save">변경</button></span>
	        </div>
	        <form action="/updatePw.do" method="get">
	            <div class="new-pw-box">
	             	<div><input type="password" name="oldPw" id="oldPw" class="input-form" placeholder="현재 비밀번호를 입력하세요"><div></div></div>
	             	<div><input type="password" name="newPw" id="newPw" class="input-form" placeholder="새 비밀번호를 입력하세요"><div></div></div>
	         		<div><input type="password" name="newPw2" id="newPw2" class="input-form" placeholder="새 비밀번호를 한 번 더 확인하세요"><div></div></div>
	         		<div><input type="hidden" name="memberNo" value="<%= m.getMemberNo() %>"></div>
	         		<div><input type="hidden" name="memberGrade" value="<%= m.getMemberGrade() %>"></div>
	            	<div class="with-btn">
	                	<button type="button" id="update-cancel" class="btn_big bc11" style="width: 49%;">변경취소</button><button id="update-pw-btn" type="submit" class="btn_big bc6" onclick="javascript:return checkValue();" style="width: 49%;">확인</button>
	            	</div>
	       		</div>
	        </form>
	    </div>
    <div class="update-title">회원 정보</div>
    	<form action="/updateMember.do" method="get">
        <div class="info-box">
            <div>전화번호</div>
            <div><input type="text" class="input-form" name="memberPhone" placeholder="010-0000-0000 형식으로 입력하세요" value="<%= m.getMemberPhone() %>"></div>
        </div>
        <div class="info-box">
            <div>주소</div>
            <div class="with-btn"><input type="text" name="memberAddr" class="input-form" value="<%= m.getMemberAddr() %>"></div>
            <div class="with-btn"><input type="hidden" name="memberNo" class="input-form" value="<%= m.getMemberNo() %>"></div>
        </div>
        <div>
            <button class="btn_big bc-save" id="save-btn" type="submit">저장하기</button>
        </div>
    </form>
    <div id="delete-box"><a href="/deleteMember.do?memberNo=<%= m.getMemberNo() %>">회원탈퇴</a></div>
    </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>

</body>
    <script>
    	$("#change-pw-btn").on("click", function(){
        	$(".old-pw-box").css("display", "none");
        	$(".new-pw-box").css("display", "block");
    	})
    	$("#update-cancel").on("click", function(){
        	$(".old-pw-box").css("display", "block");
        	$(".new-pw-box").css("display", "none");
    	})
    </script>
    
	<script>
		function checkValue() {
			const currPw = $(".old-pw-box>span:first-child").text();
			const newPwVal = $("#newPw").val();
			const newPw2Val = $("#newPw2").val();
			const oldPwVal = $("#oldPw").val();
			$("#update-pw-btn").attr("type", "submit");
			if(newPwVal != newPw2Val){ // 새 비번 두 개가 다르며능
					return false; // 제출되지 않음 
			}
			if(oldPwVal==null || oldPwVal!=currPw) {  // 전 비번이 비었거나, 전 비번이랑 다르면
				$("#update-pw-btn").attr("type", "button");
				return false;
			}
		};
		
		
		const pwReg = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{8,16}$/;
		$("#newPw").on("change", function(){
			const newPwVal = $(this).val();
			const newPwDiv = $(this).next();
			if(pwReg.test(newPwVal)){
				newPwDiv.css("display", "none");
			}else{
				newPwDiv.css("display", "div");
				newPwDiv.text("영문자, 숫자, 특수문자 조합으로 8-16자 입력하세요");
				newPwDiv.css("color", "red");
			}
		});
		
		$("#newPw2").on("change", function(){
			const newPwVal = $("#newPw").val();
			const newPw2Val = $(this).val();
			const newPw2Div = $(this).next();
			if(newPwVal==newPw2Val){
				newPw2Div.css("display", "div");
				newPw2Div.css("color", "green");
				newPw2Div.text("비밀번호가 일치합니다");
			}else{
				newPw2Div.css("display", "div");
				newPw2Div.css("color", "red");
				newPw2Div.text("새 비밀번호가 일치하지 않습니다");
			}
		});
	
		$(document).on("click", "#update-cancel", function(){
			const newBox = $(".new-pw-box");
			const inputs = newBox.find("input");
			const msgDiv = inputs.next();
			inputs.val("");
			msgDiv.text("");
		})
	
	</script>
</html>