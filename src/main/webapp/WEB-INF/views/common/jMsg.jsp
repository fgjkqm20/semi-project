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

</head>
<body>
   <div style="display:none">
      <div id="title"><%=title %></div>
      <div id="loc"><%=loc %></div>
   </div>
   <script>
      const title = document.querySelector("#title").innerText;
      const loc = document.querySelector("#loc").innerText;
      Swal.fire({
          title:title,
             showClass: {
            popup: 'animate__animated animate__fadeInDown'
             },
             hideClass: {
            popup: 'animate__animated animate__fadeOutUp'
             }
           }).then(function(){
         location.href=loc;
      })
   </script>
</body>
</html>