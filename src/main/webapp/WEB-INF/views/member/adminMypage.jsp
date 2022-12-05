<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
    <link rel="stylesheet" href="css/adminMypage.css">
    <link rel="stylesheet" href="css/common/header.css">
    <link rel="stylesheet" href="css/common/footer.css">
</head>

<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div class="page-content">
        <div class="management">회원관리</div>
        <table class="searchBar">
            <tr>
                <td><span class="material-symbols-outlined">search</span></td>
                <td><input type="text" class="input-form" placeholder="직접입력"></td>
                <td><button type="button" class="btn bc1 qitbtn">수정</button></td>
            </tr>
        </table>
        <table class="memberAdmin">
            <tr class="MAinfo">
                <td class="MAcheckbox">선택</td>
                <td class="MAmemberNo">회원번호</td>
                <td class="MAmemberName">이름</td>
                <td class="MAmemberage">나이</td>
                <td class="MAmemberid">아이디</td>
                <td class="MAmemberphone">전화번호</td>
                <td class="MAmemberemail">이메일</td>
                <td class="MAenrolldate">가입일</td>
                <td class="MAmembergrade">등급변경</td>
                <td class="MAmemberwarning">신고누적</td>
                <td class="MAmemberetc">비고</td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>1</td>
                <td>이은비</td>
                <td>20</td>
                <td>abcdefg</td>
                <td>010-0000-1111</td>
                <td>email@naver.com</td>
                <td>22-09-16</td>
                <td class="selectBox">
                    <select class="gradeSelect">
                        <option disabled selected>등급선택</option>
                        <option class="MAoption" value="1">관리자</option>
                        <option class="MAoption" value="2">의사</option>
                        <option class="MAoption" value="3">약사</option>
                        <option class="MAoption" value="4">정회원</option>
                    </select>
                </td>
                <td>0</td>
                <td></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
                <td>5</td>
                <td>6</td>
                <td>7</td>
                <td>8</td>
                <td class="selectBox">
                    <select class="gradeSelect">
                        <option disabled selected>등급선택</option>
                        <option class="MAoption" value="1">관리자</option>
                        <option class="MAoption" value="2">의사</option>
                        <option class="MAoption" value="3">약사</option>
                        <option class="MAoption" value="4">정회원</option>
                    </select>
                </td>
                <td>10</td>
                <td>11</td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>b</td>
                <td>c</td>
                <td>d</td>
                <td>e</td>
                <td>f</td>
                <td>g</td>
                <td>h</td>
                <td class="selectBox">
                    <select class="gradeSelect">
                        <option disabled selected>등급선택</option>
                        <option class="MAoption" value="1">관리자</option>
                        <option class="MAoption" value="2">의사</option>
                        <option class="MAoption" value="3">약사</option>
                        <option class="MAoption" value="4">정회원</option>
                    </select>
                </td>
                <td>j</td>
                <td>k</td>
            </tr>
        </table>
        <div class="botBtn">
            <button class="bc1 btn bottomBtn">변경하기</button>
        </div>
    </div>

    <div class="modal-request">
        <div class="modal-login">
            <div class="closebtn">
            <span class="material-symbols-outlined closemodal">close</span>
            </div>
                <br>
            <div class="modal-content">
                <div class="modalComment">회원 등급을 변경하시겠습니까?</div>
                <a href="http://127.0.0.1:5500/adminMypage.html#"><span class="material-symbols-outlined checkIcons">check</span></a> 
                <a href="#"><span class="material-symbols-outlined XIcons">close</span></a>
                <br><br>
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
    <script src="js/adminMypage.js"></script>
	<script src="js/common/header.js"></script>
	<script src="js/common/footer.js"></script>
</footer>
</html>