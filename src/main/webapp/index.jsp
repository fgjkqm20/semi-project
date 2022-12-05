<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="css/common/header.css">
<link rel="stylesheet" href="css/common/footer.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/common/default.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0"/>
<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="stylesheet" href="https://unpkg.com/aos@2.3.1/dist/aos.css"> 
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script> 


<style>
.accordion>div>p {
font-size: 12px;
}
.accordion-btn{
font-weight : 500;
font-family = ns-bold;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
        <div id="page-logo" data-aos="fade-right" data-aos-duration="1500" data-aos-offset="300" data-aos-delay="100">
            <img src="img/mainmain.jpg">
        </div>
        <div class="image-slide">
            <div class="textCircle">
                <div>━━</div>
				<div data-aos="fade-up" data-aos-duration="1500" data-aos-offset="100" data-aos-delay="100">짧은시간도 소중한 당신을 위해</div>
                <div class="tc" data-aos="fade-up" data-aos-duration="2000" data-aos-offset="100" data-aos-delay="100">병원과 약국이 내손에</div>
                <div class="tc"data-aos="fade-up" data-aos-duration="2500" data-aos-offset="100" data-aos-delay="100">비대면진료</div>
            </div>
            <span class="material-symbols-outlined">
                arrow_back
            </span>
            <div class="topimg">
                <ul>
                    <li><img = src="img/sick01.jpg"></li>
                    <li><img = src="img/sick02.jpg"></li>
                    <li><img = src="img/sick03.jpg"></li>
                    <li><img = src="img/sick04.jpg"></li>
                    <li><img = src="img/sick01.jpg"></li>
                    <li><img = src="img/sick02.jpg"></li>
                    <li><img = src="img/sick03.jpg"></li>
                    <li><img = src="img/sick04.jpg"></li>
                </ul>
            </div>
        </div>
        <div class="image-slide2 mmid" style="display: block;">
            <p data-aos="fade-up" data-aos-duration="1500" data-aos-offset="500" data-aos-delay="100">언제 어디서나 쉽고 편한</p>
            <h2 data-aos="fade-up" data-aos-duration="2000" data-aos-offset="500" data-aos-delay="100">니어바이 닥터 비대면 진료 이용안내</h2>
            <div class="inner" data-aos="fade-up" data-aos-duration="3000" data-aos-offset="300" data-aos-delay="500">
                <div><button style="background-color: #11cb9c; color: #f8f8f8;">step 01</button></div>
                <div><button>step 02</button></div>
                <div><button>step 03</button></div>
                <div><button>step 04</button></div>
                <div id="inner-buttom">
                    <div>회원가입</div>
                    <div>니어바이닥터 가입후 정보 입력</div>
                    <div>(본인인증 배송지 등)</div>
                    <img src="img/mid1.png">
                </div>
                <div id="textCircle2">
                </div>
            </div>
        </div>
        <div class="image-slide2 mmid">
            <p>언제 어디서나 쉽고 편한</p>
            <h2>니어바이 닥터 비대면 진료 이용안내</h2>
            <div class="inner">
                <div><button>step 01</button></div>
                <div><button style="background-color: #11cb9c; color: #f8f8f8;">step 02</button></div>
                <div><button>step 03</button></div>
                <div><button>step 04</button></div>

                <div id="inner-buttom">
                    <div>진료접수</div>
                    <div>의사선택후 진료 요청서 작성</div>
                    <img src="img/mid2.png" style="width: 200px; height: 270px; right: 200px;">
                </div>
                <div id="textCircle2">
                </div>
            </div>
        </div>
        <div class="image-slide2 mmid">
            <p>언제 어디서나 쉽고 편한</p>
            <h2>니어바이 닥터 비대면 진료 이용안내</h2>
            <div class="inner">
                <div><button>step 01</button></div>
                <div><button>step 02</button></div>
                <div><button style="background-color: #11cb9c; color: #f8f8f8;">step 03</button></div>
                <div><button>step 04</button></div>
                <div id="inner-buttom">
                    <div>원격진료</div>
                    <div>진료 완료 후 처방전 확인</div>
                    <img src="img/mid3.png">
                </div>
                <div id="textCircle2">
                </div>
            </div>
        </div>
        <div class="image-slide2 mmid">
            <p>언제 어디서나 쉽고 편한</p>
            <h2>니어바이 닥터 비대면 진료 이용안내</h2>
            <div class="inner">
                <div><button>step 01</button></div>
                <div><button>step 02</button></div>
                <div><button>step 03</button></div>
                <div><button style="background-color: #11cb9c; color: #f8f8f8;">step 04</button></div>
                <div id="inner-buttom">
                    <div>처방약 배송</div>
                    <div>퀵 배송, 택배,</div>
                    <div>약국 방문 수령중 선택 </div>
                    <img src="img/mid4.png">
                </div>
                <div id="textCircle2">
                </div>
            </div>
        </div>
    </div>
    <div class="bigPic">
        <img src="img/middle1.jpg"">
        <div class="onimg">
        </div>
        <div class="img-content">
            <div>━━</div>
            <div>의사, 약사선생님!</div>
            <div class="tc">빠르게 변화하는 의료서비스</div>
            <div class="tc">nearbyDocter와 함께 만들어가요!</div>
            <a href="/join.do"><button>회원가입</button></a>
            <a href="/qnaList.do?reqPage=1"><button>질문게시판</button></a>
        </div>
    </div>
    <div class="faq">
        <div class="accordion" data-aos="fade-up" data-aos-duration="2000" data-aos-offset="200" data-aos-delay="100">
            <h2>니어바이닥터 FAQ</h2>
            <button class="accordion-btn">
                비대면 진료 없이 약만 구매할 수 있나요?
                <span class="material-symbols-outlined h1 dd">expand_more</span>
                <!-- <span class="material-symbols-outlined h2">expand_less</span> -->
            </button>
            <div class="accordion-content"> 
                <p>비대면 진료 후 발행된 처방전 기반으로 약 조제 및 배송 서비스를 이용하실 수 있습니다.</p>
                <p>비대면 진료 없이 약만 수령하실 수 없는 점 양해 부탁드립니다.</p>
            </div>
            <button class="accordion-btn">
                카드만 등록했는데 100원이 결제됐어요.
                <span class="material-symbols-outlined h1 dd">expand_more</span>
            </button>
            <div class="accordion-content"> 
                <p>등록된 카드가 실제로 결제가 가능한 카드인지 확인하기 위해 100원이 결제되고 즉시 취소됩니다.</p>
                <p>*체크카드의 경우 잔액이 100원이상 있어야 가능합니다.</p>
            </div>
            <button class="accordion-btn">
                의료비 공제 가능한가요?
                <span class="material-symbols-outlined h1 dd">expand_more</span>

            </button>
            <div class="accordion-content"> 
                <p>결제된 진료비/조제비는 연말정산 시 의료비 공제 가능합니다.</p>
            </div>
            <button class="accordion-btn">
                약국에 연결되어 결제했는데 계속 조제 중이라고 떠요.
                <span class="material-symbols-outlined h1 dd">expand_more</span>
            </button>
            <div class="accordion-content"> 
                <p>약국 운영 상황에 따라 약 조제 단계에서 시간이 다소 소요될 수 있습니다.</p>
                <p>약국 운영상황에 따른 부분이라 양해 부탁드립니다.</p>
            </div>
            <button class="accordion-btn">
                이런 프로그램은 도대체 누가 기획한거죠? 너무 좋은거 같습니다.
                <span class="material-symbols-outlined h1 dd">expand_more</span>
            </button>
            <div class="accordion-content"> 
                <p>저희 프로그램은 윤수손은약속이라는 팀에서 기획한 프로그램입니다</p>
                <p>오류 및 이상 사항은 010-0000-0000으로 연락 주세요 ^^7</p>
            </div>
        </div>
    </div>
    
</body>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
<script src="js/main1.js"></script>
<!-- AOS 스크립트 초기화 -->
<script> 
AOS.init(); 
</script>
<!-- //AOS 스크립트 초기화 -->
<div aos="fade-up" data-aos-offset="200" data-aos-easing="ease-out-cubic" data-aos-duration="500">
<!-- 애니메이션 객체 요소 -->
<!-- //애니메이션 객체 요소 -->

</html>










































