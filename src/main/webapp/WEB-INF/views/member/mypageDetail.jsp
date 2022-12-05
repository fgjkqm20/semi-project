<%@page import="nbd.member.model.vo.Member"%>
<%@page import="nbd.clinic.model.vo.MyClinic"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	MyClinic mc = (MyClinic)request.getAttribute("mc");
    	int reviewResult = (Integer)request.getAttribute("reviewResult");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="/css/common/default.css">
    <link rel="stylesheet" href="/css/member/mypage-detail.css">
<title>진료 상세 정보</title>
<style>
	.detail-info>div:last-child{
		display:none;
	}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
        <div class="page-title">진료상세정보</div>
        <div class="detail-info">
            <div><span>진료일자</span><span><%= mc.getBookDate() %></span></div>
            <div><span>진료과목</span><span><%= mc.getDoctorMajor() %></span></div>
            <div><span>진료번호</span><span><%= mc.getBookNo() %></span></div>
        </div>
        <div class="info-box">
            <div>진료정보</div>
            <table class="tbl" id="mediinfo-tbl" style="width: 850px;">
                <tr>
                    <th>병원정보</th>
                    <th>진료정보</th>
                    <th>결제금액</th>
                    <th>진행상태</th>
                </tr>
                <tr>
                    <td><span><%=mc.getHospitalName() %></span><span> (<%=mc.getDoctorName() %>) </span></td>
                    <td><%=mc.getBookHistory() %></td>
                    <td><%=mc.getBookPrice() %></td>
                    <%if(reviewResult>0){ %>
                    	<td>작성완료</td>
                    <%}else {%>
                    	<td><button id="review-btn" class="bc1">리뷰작성</button></td>
                    <%} %>
                </tr>
            </table>
        </div>
        <div class="info-box">
            <div>처방정보</div>
            <table class="tbl" id="drug-tbl" style="width: 850px;">
                <tr>
                    <th>약국이름</th>
                    <th>약국 전화번호</th>
                    <th>약국주소</th>
                </tr>
                <tr>
                   	<% if(mc.getPharmTitle() == null) {%><td>-</td><%} else{%><td><%=mc.getPharmTitle() %></td><%} %>
                  		<% if(mc.getPharmPhone() == null) {%><td>-</td><%} else{%><td><%=mc.getPharmPhone() %></td><%} %>
                    <% if(mc.getPharmAddr() == null) {%><td>-</td><%} else{%><td><%=mc.getPharmAddr() %></td><%} %>
               	</tr>
            </table>
        </div>
    </div>
<div class="rmodal-wrap">
    <div class="modal-review">
        <div class="modal-top">
            <h1>리뷰쓰기</h1>
        </div>
        <div class="modal-content">
            <div id="star-box">
                <span class="material-icons">star</span>
                <span class="material-icons">star</span>
                <span class="material-icons">star</span>
                <span class="material-icons">star</span>
                <span class="material-icons">star</span>
            </div>
            <div class="comment-box">
                <div><span class="real-score"></span>점 주셨네요</div>
                <div>오늘 진료는 <span>어땠나요?</span></div>
            </div>
            <form action="/insertDoctorReview.do" method="post" autocomplete="off" id="review-form">
                <input type="hidden" name="star" id="star">
                <input type="hidden" name="doctorId" value="<%=mc.getDoctorId() %>">
                <input type="hidden" name="bookNo" value="<%=mc.getBookNo() %>">
                <input type="hidden" name="memberNo" value="<%= m.getMemberNo() %>">
                <textarea name="review" id="review-textarea"></textarea>
                <div id="modal-btn-box">
                    <button type="button" id="review-cancel" class="btn bc5">취소</button>
                    <button type="submit" id="review-submit" class="btn bc5">등록</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>

	$("#review-btn").on("click", function(){
	   	$(".rmodal-wrap").css("display", "flex");
	})
	
	$("#modal-btn-box>button:first-child").on("click",function(){
	    $(".rmodal-wrap").css("display", "none");
	    $("#star-box").css("visibility", "hidden");
	    $("#star-box").children().css("color", "lightgrey");
	})
	
	const starBox = $(".comment-box>div:first-child");
	const stars = $("#star-box>span"); // star아이콘모음
	stars.on("mouseover", function(){
	    const idx = stars.index(this);
	    stars.each(function(index, item){
	        if(idx>=index){ //마우스가 올라간 인덱스보다 작거나 같으면
	            $(item).css("color", "rgb(255, 197, 0)");
	        }else{
	            $(item).css("color", "lightgrey");
	        }
	    })
	});
	
	stars.on("mouseleave", function(){
	    const realScore = Number($(".real-score").text());
	    const starInput = $("#star");
	    starInput.val(realScore);
	    stars.each(function(index, item){
	        if(realScore>index){
	            $(item).css("color", "rgb(255, 197, 0)");
	        }else{
	            $(item).css("color", "lightgrey");
	        }
	    })
	})
	
	stars.on("click", function(){
	    const idx = stars.index(this);
	    $(".real-score").text(idx+1);
	    starBox.css("visibility", "visible");
	    const commentSpan = $(".comment-box>div:last-child>span");
	    if(idx>1){
	        commentSpan.text("어떤 점이 좋았나요?");
	    }else{
	        commentSpan.text("어떤 점이 아쉬웠나요?");
	    }
	})


    
</script>
</body>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</html>