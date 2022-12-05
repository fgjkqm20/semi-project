<%@page import="nbd.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% Member member = (Member)session.getAttribute("m"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="/css/common/default.css">
    <link rel="stylesheet" href="/css/member/mypage.css">
<title></title>
<style>
	#clinic-count span, #my-mark span, #my-clinic-room span{
		  font-size: 30px;
	}
</style>
</head>
<body>
<div class="page-title">마이페이지</div>
        <div class="profil-wrap">
            <div class="img-info">
                <div class="img-box">
                	<%if(member.getMemberPhoto() == null) {%>
                			<img src="/img/기본프로필_차콜.jpg" width="177px" height="190px">
                	<%}else { %>
                			<img src="/upload/profil/<%= member.getMemberPhoto() %>" width="177px" height="190px">
                	<%} %>
                </div>
            </div>
            <div id="name-box"><%= member.getMemberName() %></div>
            <div id="id-box" style="display:none;"><%= member.getMemberId() %></div>
            <div id="memberNo-box" style="display:none;"><%= member.getMemberNo() %></div>
            <div id="totalReview" style="display:none;"></div>
            <div id="totalAnswer" style="display:none;"></div>
            <div id="hospotal-box">당산병원</div>
            <div id="update-box">
                <button class="bc5" id="pp-btn">사진 등록</button><button class="bc5" onclick="location.href='/mypageUpdate.do?memberGrade=2';">내 정보 수정</button>
            </div>
        </div>
        
        <div class="my-info">
            <ul id="info-box">
                <li>
                    <div>
                        <span>회원등급 > </span><span>의사</span>
                    </div>
                    <div id="my-clinic-room">
                        <a href="/treatmentRoom3.do?memberId=<%=member.getMemberId() %>"><span id="my-clinic">나의 진료실</span></a>
                    </div>
                </li>
                <li>
                    <div>나의 진료 횟수 > </div>
                    <div id="clinic-count"></div>
                </li>
                <li>
                    <div>나의 진료 평점 > </div>
                    <div id="my-mark"></div>
                </li>
            </ul>
        </div>

<div class="pmodal-wrap">
    <div class="modal-profil">
        <div class="modal-top">
            <h1>프로필사진 등록</h1>
        </div>
        <form action="/profilPhotoUpdate.do" method="post" enctype="multipart/form-data">
        <table class="profil-tbl">
        	<tr>
        	    <td>등록할 사진을 선택해 주세요</td>
        		<td rowspan="3" style="width:177px; height:190px;">
        			<%if(member.getMemberPhoto() == null) {%>
                			<img src="/img/기본프로필_차콜.jpg" width="177px" height="190px">
                	<%}else { %>
                			<img src="/upload/profil/<%= member.getMemberPhoto() %>" width="177px" height="190px">
                	<%} %>
        	</tr>
        	<tr>
        		<td>
        			<input type="hidden" name="memberGrade" id="memberGrade" value=<%= member.getMemberGrade() %>>
        			<input type="hidden" name="memberNo" id="memberNo" value=<%= member.getMemberNo() %>>
        			<%if(member.getMemberPhoto() != null) {%>
							<input type="file" name="profilPhoto" id="profilPhoto" class="input-form2" style="width:300px;" accept=".jpg,.png.,.jpeg" onchange="loadImg(this);" >
							<input type="hidden" name="oldFilepath" value="<%= member.getMemberPhoto() %>">
						<%}else { %>
							<input type="file" name="profilPhoto" id="profilPhoto" class="input-form2" style="width:300px;" accept=".jpg,.png.,.jpeg" onchange="loadImg(this);">
						<%} %>
        			
        		</td>
        	</tr>
        	<tr>
	        	<td class="pmodal-btn-box" style="width: 260px;">
        			<button type="button" class="btn bc11">취소</button>
                    <button type="submit" class="btn bc6">등록</button>
        		</td>
        	</tr>
        </table>
        </form>
    </div>
</div>
<script src="/js/mypagePhoto.js"></script>
<script>
let startIndexA = 1;	// 인덱스 초기값
let searchStepA = 3;
let startIndexR = 1;	// 인덱스 초기값
let searchStepR = 3;
	$(document).ready(function() {
		console.log('마이페이지 헤더');
		const totalBook = $("#clinic-count");
		const doctorStar = $("#my-mark");
		const totalReview = $("#totalReview");
		const totalAnswer = $("#totalAnswer");
		const memberId = $("#id-box").text();
		const memberNo = $("#memberNo-box").text();
		getMyInfo();
		
		function getMyInfo() {
			$.ajax({
				url: "/getDoctorInfo.do",
				type: "post",
				dataType: "json",
				data: {	memberId : memberId,
						memberNo : memberNo
					  },
				success: function (data) {
					if(data == null){
						result.append("회원 정보를 조회할 수 없습니다");
					}else{
						totalReview.text(data.totalReview);
						totalAnswer.text(data.totalAnswer);
						totalBook.append("<span>"+data.clinicCount+"</span>");
						doctorStar.append("<span>"+data.doctorStar+"</span><span>/5</span>");
						console.log('값 호출');
					}
				},
				error : function() {
				}
			}).then(function(){
				getMyHistory();
					// 3개씩 로딩하겠다

				// 로딩 시 첫 실행
				getMyAnswer(startIndexA);
					// 3개씩 로딩하겠다

				// 로딩 시 첫 실행
				getMyReview(startIndexR);
				
			});
		}
	});
	
</script>
</body>
</html>