<%@page import="nbd.clinic.model.vo.Book"%>
<%@page import="nbd.member.model.vo.Doctor"%>
<%@page import="nbd.member.model.vo.Member"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%
       Doctor doctor = (Doctor)request.getAttribute("doctor");
       Book book = (Book)request.getAttribute("book");
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>퀵 배송 신청</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"> 
    <link rel="stylesheet" href="css/common/default.css">
    <link rel="stylesheet" href="css/QuickSelect.css">
    <link rel="stylesheet" href="css/common/header.css">
    <link rel="stylesheet" href="css/common/footer.css">
</head>

<body id="body">
<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="page-content">
        <div class="QStop">
            <span>───────────────────────────────────────────────────────────────────────────</span>
            <br>
            <span class="QStoptitle">퀵 배송 신청</span>
            <br>
            <span>───────────────────────────────────────────────────────────────────────────</span>
        </div>

        <table class="QuickInfo tbl">
            <tr>
                <td>수령인</td>
                <td><input type="text" class="input-form qii" id="reqjs1" style="display:inline-block; width:525px;" placeholder=<%=m.getMemberName()%> required readonly></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td>
                    <input type="text" class="input-form qii2" id="reqjs2" style="display:inline-block" value=<%=m.getMemberPhone() %> required>
                    <button type="button" class="btn bc1 qitbtn" id="reqjs2btn" onclick="clearBtn1()" style="height:50px;">수정</button>
                </td>
            </tr>
            <tr>
                <td>수령인주소</td>
                <td>
                    <input type="text" class="input-form qii2" id="reqjs3" style="display:inline-block" value=<%=m.getMemberAddr()%> required>
                    <button type="button" class="btn bc1 qitbtn" id="reqjs3btn" onclick="clearBtn2()" style="height:50px;">수정</button>
                </td>
            </tr>
            <tr>
                <td>상세주소</td>
                <td>
                    <input type="text" class="input-form qii2" id="reqjs4" style="display:inline-block" placeholder="직접입력" required>
                    <button type="button" class="btn bc1 qitbtn" id="reqjs4btn" onclick="clearBtn3()" style="height:50px;">수정</button>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit" onclick="gomain()" class="btn bc1 qibtn"style="height:50px;">배송신청</button>
                </td>
            </tr>
        </table>
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
   <img src="/img/top.png"   width="50px" height="50px" class="btn-top">
    <script src="/js/common/header.js"></script>
   <script src="/js/common/footer.js"></script>
</footer>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="/js/QuickSelect.js"></script>
<script>

   function clearBtn1(){
        const input1 = $("#reqjs2");
      $(input1).val("");
   }
   
   function clearBtn2(){
        const input2 = $("#reqjs3");
      $(input2).val("");
   }
   
   function clearBtn3(){
        const input3 = $("#reqjs4");
      $(input3).val("");
   }
   
</script>
</html>