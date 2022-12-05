<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<header>
    <div class="header-wrap">
        <div class="header-logo">
            <a href="/">
                <img src="/img/로고.png"
                width="150px" height="50px">
            </a>
        </div>
        <nav>
            <ul class="header-navi">
                <li><a href="/reservation.do?clickIndex=0">비대면진료</a></li>
				<li><a href="/healthCounselList.do?clickIndex=1">건강상담</a></li>
				<li><a href="/searchPharm.do?clickIndex=2">약국찾기</a></li>
				<li><a href="/qnaList.do?reqPage=1">QnA</a></li>
            </ul>
        </nav>
        <div class="header-link">
            <a href="#">
                <span class="material-symbols-outlined">login</span>
            </a>
            <a href="#">
                <span class="material-symbols-outlined">account_circle</span>
            </a>
        </div>
    </div>
</header>
<body>
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

                    <span class="material-icons">
                        double_arrow
                    </span>

                    <li class="tab-border">
                        <div>진료<br>완료</div>
                    </li>

                    <span class="material-icons">
                        double_arrow
                    </span>
                    
                    <li class="tab-border">
                        <div>처방<br>대기</div>
                    </li>

                    <span class="material-icons">
                        double_arrow
                    </span>
                    
                    <li class="tab-border">
                        <div>처방<br>완료</div>
                    </li>

                    <span class="material-icons">
                        double_arrow
                    </span>

                    <li class="tab-border">
                        <div>진료<br>완료</div>
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
                                kh 당산의원 - 안형관의사(선택한 의사)<br>
                                11시 30분(선택한 시간) 비대면 진료접수가 완료되었습니다.
                            </p>
                        </div>
                    </li>
                    <li class="order">
                        <div>
                            <h4 class="orderStep">진료완료</h4>                            
                            <p>
                                <table class="successMedical">
                                    <tr>
                                        <td>병원</td>
                                        <td>kh당산의원(의사의 소속 병원)</td>
                                    </tr>
                                    <tr>
                                        <td>담당의사</td>
                                        <td>안형관의사(선택한 의사)</td>
                                    </tr>
                                    <tr>
                                        <td>증상/요청</td>
                                        <td>탈모/무좀(선택한 증상)</td>
                                    </tr>
                                    <tr>
                                        <td>접수일시</td>
                                        <td>2022.09.13(화) (예약한 시간)</td>
                                    </tr>
                                    <tr>
                                        <td>진료완료시간</td>
                                        <td>2022.09.13(화) (예약한 시간)</td>
                                    </tr>
                                </table>
                            </p>
                        </div>
                    </li>
                    <li class="order">
                        <div>
                            <h4 class="orderStep">처방대기</h4>                            
                            <p>
                                <br>
                                처방전을 준비하고 있습니다.
                            </p>
                            <br>
                        </div>
                    </li>
                    <li class="order">
                        <div>
                            <h4 class="orderStep">처방완료</h4>                            
                            <p>
                                <br>
                                발급된 처방전이 없습니다.
                            </p>
                            <br>
                            <button type="button" class="btn_big bc1" id="finishPrescription">진료 완료</button>
                        </div>
                    </li>
                    <li class="order">
                        <div>
                            <h4 class="orderStep">진료완료</h4>                            
                            <p>
                                <br>
                                이용해주셔서 감사합니다<br>
                                진료내역은 마이페이지에서 확인 가능합니다.
                            </p>
                            <br>
                            <button class="btn_big bc1">메인으로 돌아가기</button>
                        </div>
                    </li>
                </ul>
                <div class="slide-navi prev">
                    <span class="material-icons">arrow_back_ios_new</span>
                </div>
                <div class="slide-navi next">
                    <span class="material-icons">arrow_forward_ios</span>
                </div>
            </div>
        </div>
    </div>
</body>
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
    <script src="js/PracticePattern.js"></script>
    <script src="js/common/header.js"></script>
	<script src="/js/common/footer.js"></script>
</footer>
</html>