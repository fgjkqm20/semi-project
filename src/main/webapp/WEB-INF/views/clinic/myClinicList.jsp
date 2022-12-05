<%@page import="nbd.clinic.model.vo.MyClinic"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MyClinic> rlist = (ArrayList<MyClinic>)request.getAttribute("rlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet"  href="/css/clinicSelectDoctor.css">
    <link rel="stylesheet"  href="/css/common/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="clinic-title2"><h1>비대면 진료실</h1></div>
	        
		<%for(MyClinic mc : rlist) {%>
	    <div class="cliniclist-1 hvr-glow">
            <a href="#" onclick="location.href='/prescriptionO.do?bookNo=<%=mc.getBookNo() %>';">
                <div class="clinicpc-1"><img src="/img/기본프로필_녹색.jpg"></div>
                <div class="clinicdoctorinfo"><%=mc.getDoctorName() %>
                    <span><%=mc.getBookDate() %></span>
                    <span><%=mc.getDoctorMajor() %></span>
                </div>
                <div class="doctor-star">★
                </div>
            </a>
        </div>
        <%} %>
    </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>