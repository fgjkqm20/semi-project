<%@page import="nbd.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% Member member = (Member)session.getAttribute("m"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="/css/member/mypage.css">
    <link rel="stylesheet" href="/css/common/default.css">
<title></title>
<style>
	#my-q, #my-r, #my-w{
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
                			<img src="/img/기본프로필_녹색.jpg" width="177px" height="190px">
                	<%}else { %>
                			<img src="/upload/profil/<%= member.getMemberPhoto() %>" width="177px" height="190px">
                	<%} %>
                	</div>
               	</div>
               	<div id="name-box"><%= member.getMemberId() %></div>
            	<div id="update-box">
                	<button class="bc3" id="pp-btn">사진 등록</button><button class="bc3" onclick="location.href='/mypageUpdate.do?memberGrade=3';">내 정보 수정</button>
            	</div>
           </div>

        
        
        <div class="my-info">
            <ul id="info-box">
                <li>
                    <div>나의 전체 예약 > </div>
                    <div id="my-r"></div>
                </li>
                <li>
                    <div>나의 전체 질문 > </div>
                    <div id="my-q"></div>
                </li>
                <li>
                    <div>나의 경고 누적 > </div>
                    <div id="my-w" style="font-size: 30px;"><%=member.getMemberWarning()%></div>
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
                			<img src="/img/기본프로필_녹색.jpg" width="177px" height="190px">
                	<%}else { %>
                			<img src="/upload/profil/<%= member.getMemberPhoto() %>" width="177px" height="190px">
                	<%} %>
        		</td>
        	</tr>
        	<tr>
        		<td>
        			<input type="hidden" name="memberNo" id="memberNo" value=<%= member.getMemberNo() %>>
        			<input type="hidden" name="memberGrade" id="memberGrade" value=<%= member.getMemberGrade() %>>
        			<%if(member.getMemberPhoto() != null) {%>
							<input type="file" name="profilPhoto" id="profilPhoto" class="input-form2" style="width:200px;" accept=".jpg,.png.,.jpeg">
							<input type="hidden" name="oldFilepath" value="<%= member.getMemberPhoto() %>">
						<%}else { %>
							<input type="file" name="profilPhoto" id="profilPhoto" class="input-form2" style="width:300px;" accept=".jpg,.png.,.jpeg">
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
let startIndexQ = 1;	// 인덱스 초기값
let searchStepQ = 3;	// 3개씩 로딩
let startIndexB = 1;	// 인덱스 초기값
let searchStepB = 3;	// 3개씩 로딩하겠다

$(document).ready(function(){
	getMyTotal();
	const bookDiv = $("#my-r");
	const questionDiv = $("#my-q");

	function getMyTotal(){
		$.ajax({
			url: "/getMyTotalInfo.do",
			type: "post",
			dataType: "json",
			success: function (data) {
				bookDiv.text(data.totalBook);
				questionDiv.text(data.totalQuestion);
				console.log(data);
			},
			error : function() {
			}
			}).then(function(){
				getMyQuestion(startIndexQ);
				getMyReserve(startIndexB);

		}); 
	}
	// 로딩 시 첫 실행
	// my Q 더보기 실행함수
});
</script>
</body>
</html>