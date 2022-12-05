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
    <link rel="stylesheet" href="css/common/default.css">
    <link rel="stylesheet" href="css/PharmacySelect.css">
    <link rel="stylesheet" href="css/common/header.css">
    <link rel="stylesheet" href="css/common/footer.css">
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="PSbottom">
        <div class="PSbot">
            <span>───────────────────────────────────────────────────────────────────────────</span>
            <br>
            <span class="PStoptitle">수령 방법 선택</span>
            <br>
            <span>───────────────────────────────────────────────────────────────────────────</span>
        </div>
        <div class="selectQuick">
            <a href="/pharmacySelect.do" class="quickreceive">
                <span class="material-symbols-outlined quick" style="font-size:160px;">local_shipping</span><br>
                <div class="sqfd">퀵배송</div><br>
                <div class="sqsd">지정한 일부 지역에 한하여 퀵서비스 기사님을 통해 상품을 빠르게 배송받을 수 있습니다</div>
            </a>
            <br><br><br><br><br>
           <div class="visitreceive">
                <span class="material-symbols-outlined visit" style="font-size:160px;">approval_delegation</span><br>
                <div class="sqfd">방문수령</div><br>
                <div class="sqsd">선택한 수령지에 고객이 직접 방문하여 상품을 픽업합니다</div>
           </div>
        </div>
    </div>
</body>

<div class="modal-request">
    <div class="modal-login">
        <div class="closebtn">
        <span class="material-symbols-outlined closemodal">close</span>
        </div>
            <br>
        <div class="modal-content">
            <div class="modalComment">방문수령을 하시겠습니까?</div>
            <br>
            <button type="button" class="btn_small bc33"><div id="yesSelect"><a href="/visitSelect.do">네</a></div></button>
            <button type="button" class="btn_small bc33"><div class="closeSelect closebtn">아니오</div></button>
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
   <script src="js/SendSelect.js"></script>
    <script src="js/common/header.js"></script>
   <script src="/js/common/footer.js"></script>
</footer>
</html>