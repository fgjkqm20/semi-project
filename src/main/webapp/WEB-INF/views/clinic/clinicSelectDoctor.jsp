<%@page import="nbd.member.model.vo.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	ArrayList<Doctor> list = (ArrayList<Doctor>)request.getAttribute("list"); 	
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet"  href="/css/clinicSelectDoctor.css">
    <link rel="stylesheet"  href="/css/common/default.css">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
		    <div class="page-content">
        <div class="clinic-title2"><h1>비대면 진료실</h1></div>
        
        <%for(Doctor doc : list){ %>
        
        <div class="cliniclist-1 hvr-glow" data-aos="fade-down" aos-offset="300" aos-easing="ease-in-sine" data-aos-duration="1000">
            <a href="/reservationDetail.do?doctorNo=<%=doc.getDoctorNo()%>">
                <div class="clinicpc-1">
                	<img src="/img/clinicImg/프로필.jpg">
                </div>
                
                <div class="clinicdoctorinfo"><%=doc.getDoctorName() %> 의사
                    <span><%=doc.getHospitalName() %></span>
                    <span><%=doc.getDoctorMajor() %></span>
                </div>
                <div class="doctor-star">★
                    <span><%=doc.getDoctorAvgStar() %></span>
                </div>
            </a>
        </div>
        <%} %>
        
        </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
        AOS.init();
    </script>
</body>
</html>



















