<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String memberId = (String)request.getAttribute("memberId");
    	boolean result = (Boolean)request.getAttribute("result");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<script src="/js/common/jquery-3.6.0.js"></script>
<style type="text/css">
	.check-wrap{
		width:400px;
		margin: 0 auto;
		margin-top: 50px;
	}
	
	.check-title{
		text-align: center;
		font-size: 30px;
	}
	
	.check-content{
		margin-top: 30px;
		text-align: center;
	}
	
	#idInput{
		margin-top: 20px;
		text-align: center;
		margin-right: 0px;
	}
	
	#idMsg{
		text-align: center;
	}
	
	#checkId{
		width:200px;
		height: 30px;
		border-radius: 10px;
		padding-left: 10px;
	}
	#check{
		width: 80px;
		height: 37px;
		margin-top: 5px;
		background-color: rgb(16, 203, 156);
		color:white;
		border-style: none;
		border-radius: 10px;
	}
	
	#check:hover{
		cursor: pointer;
	}
	
	.closeBtn{
		margin-top: 20px;
	}
	
	.closeBtn>button{
		width: 80px;
		height: 37px;
		background-color: rgb(16, 203, 156);
		color:white;
		border-style: none;
		border-radius: 10px;
	}
	
	.closeBtn>button:hover{
		cursor: pointer;
	}
	
	.img-content{
		padding-left:100px;
		margin-top: 40px;
	}
</style>
</head>
<body>
	
	<div class="check-wrap">
		<div class="check-title">
			<span style="">아이디 중복체크</span>
		</div>
		
		<div class="check-content">
		<%if(result){ %>
				<span class="idMsg" style="color:blue;">[<%=memberId%>]는 사용가능한 아이디 입니다.</span>
				<div class="closeBtn">
					<button id="windowClose" type="button" onclick="close1('<%=memberId%>');">닫기</button>
				</div>
			<%} else{ %>
				<span class="idMsg" style="color:red;">[<%=memberId%>]는 이미 사용중인 아이디 입니다.</span>
				
				<form action="checkIdGo.do" method="get" id="idInput">
			
					<input type="text" name="checkId" id="checkId">
					
					<button type="submit" id="check">조회</button>
				</form>
			<%} %>
			</div>
			
			<div class="img-content">
				<img src="/img/common/로고.png"
				width="150px" height="50px">
			</div>

	</div>
	
	<script type="text/javascript">
		$("#check").on("click", function(){
			const idChk = $("#checkId").val();
			
			if(idChk == ""){
				const idMsg = $(".idMsg:last-child");
				idMsg.text("아이디를 입력해주세요.");
			}
		})
		
		function close1(memberId){
			const idVal = $("#id", opener.document);
			
			idVal.val(memberId);
			console.log("closetest");
			window.open('','_self').close();
			
		}
	</script>
	
</body>
</html>


















