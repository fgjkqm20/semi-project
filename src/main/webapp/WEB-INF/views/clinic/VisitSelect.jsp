<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
    <link rel="stylesheet" href="css/common/default.css">
    <link rel="stylesheet" href="css/VisitSelect.css">
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
    <div class="page-content">
        <div class="VStop">
            <span>───────────────────────────────────────────────────────────────────────────</span>
            <br>
            <span class="VStoptitle">방문수령</span>
            <br>
            <span>───────────────────────────────────────────────────────────────────────────</span>
        </div>
        <div class="VScenter">
            <div class="showVisit">
                방문 수령을 선택하셨습니다.<br>
                ㅇㅇ약국으로 오셔서<br>
                성함과 수령하실 약을 말해주세요.                
            </div>
            <button type="button" class="btn bc1 showVisitBtn">메인으로 돌아가기</button>
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
	<script src="js/common/header.js"></script>
	<script src="/js/common/footer.js"></script>
</footer>
</html>