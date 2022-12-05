<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- ↓ signinServlet 에서 4개를 넘겨줬기때문에 꺼내는 작업 ↓ 
    	4개 전부다 String타입으로 넣어놨기때문에 String 타입으로 형변환 
    --%>
    <%
    	String title = (String)request.getAttribute("title");
    	String msg = (String)request.getAttribute("msg");
    	String icon = (String)request.getAttribute("icon");
    	String loc = (String)request.getAttribute("loc");
    %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="/js/sweetalert.min.js"></script>
</head>
<body>
	<div style="display:none;"> <%-- 안보이게 만듦 --%>
		<div id="title"><%=title %></div>
		<div id="msg"><%=msg %></div>
		<div id="icon"><%=icon %></div>
		<div id="loc"><%=loc %></div>
	</div>
	<script>
		const title = document.querySelector("#title").innerText;
		const msg = document.querySelector("#msg").innerText;
		const icon = document.querySelector("#icon").innerText;
		const loc = document.querySelector("#loc").innerText;
		swal({ //sweetalert 사용하는법 
			title: title,
			text : msg,
			icon : icon
		}).then(function(){ //alret에서 확인 버튼 누르고 나면 여기로 이동해라~
			location.href = loc; // loc에 '/'를 넣어놔서 메인으로 갈수 밖에 없음 
		});
	</script>	
</body>
</html>