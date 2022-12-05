<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비대면 진료실</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet"  href="/css/Clinic12.css">
    <link rel="stylesheet"  href="/css/common/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
        <div class="clinic-title">
            <h1>비대면 진료실</h1>
        </div>
        <table class="clinictbl-1">
            <tr class="clinictr-1">
                    <td class="clinictdtd-1 clinictdtd2" id="clinictd">
                        <a href="/clinicSelectDoctor.do?doctorMajor=이비인후과">
                            <div><img src="/img/clinicImg/이비인후과.png"></div>
                                <div class="clinicspsp-1">
                                이비인후과
                                <span>비염,이명,편도염 등</span>
                            </div>
                        </a> 
                    </td>
                    <td class="clinictdtd-1">
                        <a href="/clinicSelectDoctor.do?doctorMajor=내과">
                            <div>
                                <img src="/img/clinicImg/내과.png">
                            </div>
                            <div class="clinicspsp-1">
                                내과
                                <span>감기,소화기,호흡기 등</span>
                            </div> 
                        </a>
                    </td>
            </tr>
            <tr class="clinictr-1">
                <td class="clinictdtd-1 clinictdtd2">
                    <a href="/clinicSelectDoctor.do?doctorMajor=산부인과">
                        <div><img src="/img/clinicImg/산부인과.png"></div>
                        <div class="clinicspsp-1">산부인과<span>피임상담,여성질환 등</span></div> 
                    </a>    
                </td>
                <td class="clinictdtd-1">
                    <a href="/clinicSelectDoctor.do?doctorMajor=정신건강의학과">
                        <div><img src="/img/clinicImg/정신건강의학과.png"></div>
                        <div class="clinicspsp-1">정신건강의학과<span>마음챙김, 공황장애 등</span></div> 
                    </a>
                </td>
            </tr>
            <tr class="clinictr-1">
                <td class="clinictdtd-1 clinictdtd2">
                    <a href="/clinicSelectDoctor.do?doctorMajor=정형외과">
                        <div><img src="/img/clinicImg/정형외과.png"></div>
                        <div class="clinicspsp-1">정형외과<span>관절염,골절,척추측만증 등</span></div> 
                    </a> 
                </td>
                <td class="clinictdtd-1">
                    <a href="/clinicSelectDoctor.do?doctorMajor=소아과">
                        <div><img src="/img/clinicImg/소아과.png"></div>
                        <div class="clinicspsp-1">소아과<span>소아소화기,알레르기 등</span></div> 
                    </a>    
                </td>
            </tr>
            <tr class="clinictr-1">
                <td class="clinictdtd-1 clinictdtd2">
                    <a href="/clinicSelectDoctor.do?doctorMajor=신경외과">
                        <div><img src="/img/clinicImg/신경외과.png"></div>
                        <div class="clinicspsp-1">신경외과<span>요통,디스크,신경계질환 등</span></div> 
                    </a>
                </td>
                <td class="clinictdtd-1">
                    <a href="/clinicSelectDoctor.do?doctorMajor=치의학과">
                        <div><img src="/img/clinicImg/치의과.png"></div>
                        <div class="clinicspsp-1">치의학과<span>치아잇몸질환,턱관절 등</span></div> 
                    </a>
                </td>
            </tr>
            <tr class="clinictr-1">
                <td class="clinictdtd-1 clinictdtd2">
                    <a href="/clinicSelectDoctor.do?doctorMajor=피부과">
                        <div><img src="/img/clinicImg/피부과.png"></div>
                        <div class="clinicspsp-1">피부과<span>두드러기,가려움증,탈모 등</span></div> 
                    </a>
                </td>
                <td class="clinictdtd-1">
                    <a href="/clinicSelectDoctor.do?doctorMajor=외과">
                        <div><img src="/img/clinicImg/외과.png"></div>
                        <div class="clinicspsp-1">외과<span>갑상선,하지정맥 등</span></div> 
                    </a>
                </td>
            </tr>
            <tr class="clinictr-1">
                <td class="clinictdtd-1 clinictdtd2">
                    <a href="/clinicSelectDoctor.do?doctorMajor=비뇨기과">
                        <div><img src="/img/clinicImg/비뇨기과.png"></div>
                        <div class="clinicspsp-1">비뇨기과<span>소변시 통증, 남성질환 등</span></div> 
                    </a>
                </td>
                <td class="clinictdtd-1">
                    <a href="#">
                        <div><img src="/img/clinicImg/응급의학과대체.png"></div>
                        <div class="clinicspsp-1">NearbyDoctor</div> 
                    </a>
                </td>
            </tr>
        </table>
    </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>