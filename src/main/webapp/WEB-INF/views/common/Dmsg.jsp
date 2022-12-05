<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
#body .swal2-title{
   font-size: 25px;
}

#body .swal2-styled.swal2-confirm{
   background-color: #449f8d;
   font-size : 20px;
   width : 150px;
   height : 40px;
   line-height:13px;
}
.

.swal2-actions{
	width: 250px;
}
.swal2-actions>button{
	width: 100%;
	background-color: #449f8d;
}

body{
	  font-family: "Open Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial, sans-serif;
}
</style>
</head>
<body>
	<div style ="display:none;">
		<div id="title"><%=title%></div>
		<div id="msg"><%=msg%></div>
		<div id="icon"><%=icon%></div>
		<div id="loc"><%=loc%></div>
	</div>
	<script>
		const title = document.querySelector("#title").innerText;
		const msg = document.querySelector("#msg").innerText;
		const icon = document.querySelector("#icon").innerText;
		const loc = document.querySelector("#loc").innerText;
		
		Swal.fire({
			title:title,
			text:msg,
			icon:icon,
		}).then(function(){
			location.href = loc;
		});
	</script>
</body>
</html>

