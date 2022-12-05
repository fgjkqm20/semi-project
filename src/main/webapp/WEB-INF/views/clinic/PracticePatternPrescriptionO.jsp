<%@page import="nbd.clinic.model.vo.Book"%>
<%@page import="nbd.member.model.vo.Member"%>
<%@page import="nbd.member.model.vo.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Doctor doctor = (Doctor)request.getAttribute("doctor");
    	Book book = (Book)request.getAttribute("book");
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=\, initial-scale=1.0">
    <title>진료현황</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
    <link rel="stylesheet" href="css/common/default.css">
    <link rel="stylesheet" href="css/PracticePattern.css">
    <link rel="stylesheet" href="css/common/header.css">
    <link rel="stylesheet" href="css/common/footer.css">
	
</head>
<body>

	<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="guide-content">
        <div class="guide-wrap">
            <div class="guide-backgroundColor">
            <div class="guide-subTitle">진료현황</div>
            </div>
        </div>

        <div class="guide-backgroundColor">
            <div class="guide-tab-wrap">
                <ul class="guide-tabs">

                    <li class="tab-border">
                        <div>병원<br>접수</div>
                    </li>

                    <span class="material-icons" id="nexticon">
                        double_arrow
                    </span>

                    <li class="tab-border">
                        <div>진료<br>중</div>
                    </li>

                    <span class="material-icons" id="nexticon">
                        double_arrow
                    </span>

                    <li class="tab-border">
                        <div>진료<br>완료</div>
                    </li>

                    <span class="material-icons" id="nexticon">
                        double_arrow
                    </span>

                    <li class="tab-border">
                        <div>처방<br>완료</div>
                    </li>

                    <span class="material-icons" id="nexticon">
                        double_arrow
                    </span>

                    <li class="tab-border">
                        <div>수령<br>완료</div>
                    </li>

                </ul>
            </div>

            <div class="guideSlide-wrap">
                <ul>
                    <li class="order">
                        <div>
                            <h4 class="orderStep">병원접수</h4>                            
                            <p>
                                <br>
                                <%-- 병원이름 - 의사이름 --%>
                                <%=book.getHospitalName() %> - <%=book.getBookDoctor() %>의사 
                                <%=book.getBookTime() %>(선택한 시간) 비대면 진료접수가 완료되었습니다.
                            </p>
                        </div>
                    </li>
                    <li class="order">
                        <div>
                            <h4 class="orderStep">진료예약현황</h4>                            
                            <p>
                                <table class="successMedical">
                                    <tr>
                                        <td>병원</td>
                                        <td><%=book.getHospitalName() %></td>
                                    </tr>
                                    <tr>
                                        <td>담당의사</td>
                                        <td><%=book.getBookDoctor() %></td>
                                    </tr>
                                    <tr>
                                        <td>진료과목</td>
                                        <td><%=book.getDoctorMajor() %></td>
                                    </tr>
                                    <tr>
                                        <td>접수일시</td>
                                        <td><%=book.getBookDate() %></td>
                                    </tr>
                                    <tr>
                                        <td>진료예약시간</td>
                                        <td><%=book.getBookTime() %></td>
                                    </tr>
                                </table>
                            </p>
                            <input type="hidden" id="clickStatus" value="<%=book.getMemberState()%>">
                        </div>
                    </li>
                    <li class="order">
                        <div>
                            <h4 class="orderStep">진료완료</h4>                            
                            <p>
                                <br>
                                진료가 완료되었습니다.
                            </p>
                            <br>
                            <button type="button" class="btn_big bc1" id="nowreceive">지금 바로 약 수령</button>
                        </div>
                    </li>
                    <li class="order">
                        <div>
                            <h4 class="orderStep">처방완료</h4>                            
                            <p>
                                <br>
                                kh 당산약국으로 처방되었습니다
                            </p>
                            <br>
                            <button class="btn_big bc1" onclick="goSendSelect()"><a href="/sendSelect.do">수령방법선택</a></button>
                        </div>
                    </li>
                    <li class="order">
                        <div>
                            <h4 class="orderStep">수령완료</h4>                            
                            <p>
                                <br>
                                이용해주셔서 감사합니다<br>
                                처방전은 마이페이지에서 확인 가능합니다.
                            </p>
                            <br>
                            <button class="btn_big bc1" onclick="goMain();">메인으로 돌아가기</button>
                        </div>
                    </li>
                </ul>
                <div class="slide-navi prev">
                    <span class="material-icons">arrow_back_ios_new</span>
                </div>
                <div class="slide-navi next">
                    <span class="material-icons" onclick="countArrow(<%=book.getMemberState()%>);">arrow_forward_ios</span>
                </div>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    
    	function goSendSelect(){
    		location.href = "/sendSelect.do";
    	}
    	
    	function goMain(){
    		location.href = "/";
    	}
    	
    	$(document).ready(function (){
    		const next = $(".next>span");
    		const status = $("#clickStatus").val();
    		
    		for(let i = 0; i < status-1; i++){
    			next.click();
    		}
    	})
	</script>
    
</body>

<div class="modal-request">
    <div class="modal-login">
        <div class="closebtn">
        <span class="material-symbols-outlined closemodal">close</span>
        </div>
            <br>
        <div class="modal-content">
            <div class="modalComment">지금 바로 약을 수령하시겠습니까?</div>
            <br>
            <a href="/sendSelect.do"><button type="button" class="btn_small bc33">받기</button></a>
            <button type="button" class="btn_small bc33 closebtn">나중에</button>
            <br><br>
        </div>
    </div>
</div>

<footer>
	<div class="footer-sns">
		<ul class="sns-content">
			<li>
				<a href="#" target="_blank">
					<img src="/img/카카오톡.png" 
					alt="nearbyDoctor 공식 카카오톡 채널" 
					width="24px" height="24px">
				</a>
			</li>
			<li>
				<a href="#" target="_blank">
					<img src="/img/블로그.png" 
					alt="nearbyDoctor 공식 블로그" 
					width="24px" height="24px">
				</a>
			</li>
			<li>
				<a href="#" target="_blank">
					<img src="/img/인스타그램.png" 
					alt="nearbyDoctor 공식 인스타그램" 
					width="24px" height="24px">
				</a>
			</li>
			<li>
				<a href="#" target="_blank">
					<img src="/img/유튜브.png" 
					alt="nearbyDoctor 공식 유튜브" 
					width="24px" height="24px">
				</a>
			</li>
		</ul>
	</div>
	
	<div class="footer-text">
		<div class="text-left">
			<p>주식회사 니어바이닥터 | 대표이사 : 이윤수 | 사업자등록번호 : 123-45-67890</p>
			<p>통신판매업신고번호 : 제 1111-서울영등포-11호 | 개인정보관리책임 : 이윤수</p>
			<p>주소 : 서울특별시 영등포구 선유동2로 57 이레빌딩 (구관) 19F, 20F</p>
		</div>
		<div class="text-right">
			<ul class="text-right-link">
				<li>
					<a href="#">
						고객센터
					</a>
					&nbsp;|&nbsp;
				</li>
				<li>
					<a href="#">
						이용약관
					</a>
					&nbsp;|&nbsp;
				</li>
				<li>
					<a href="#">
						<b>개인정보처리방침 </b>
					</a>
				</li>
				<li>
					<a href="#">
						cs@ondoctor.co.kr
					</a>
				</li>
			</ul>
			<p>Copyright © ondoctor. All rights reserved.</p>
		</div>
	</div>
	<img src="/img/top.png" 
	width="50px" height="50px"
	class="btn-top">
	<script src="/js/PracticePattern.js"></script>
    <script src="js/common/header.js"></script>
	<script src="/js/common/footer.js"></script>
</footer>
</html>



























