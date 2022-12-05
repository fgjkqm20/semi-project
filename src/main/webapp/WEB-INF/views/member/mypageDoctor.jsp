<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>	
#insert-history{
	width: 740px;
	display: none;
    justify-content: space-between;
    margin: 0 auto;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
        <%@include file="/WEB-INF/views/member/mypageHeaderDoctor.jsp" %>
        <div class="mypage-content">
            <div class="mytbl-wrap">
            	<div class="my-title">나의 경력</div>
          		<table class="tbl my-tbl" id="myHistory-tbl" style="width: 960px;">
          			<thead>
                	<tr>
                   		<th>기간</th>
                    	<th>경력 및 연수</th>
                	</tr>
                	</thead>
                	<tbody id="hbody">
                	</tbody>
                	<tfoot>         
                	</tfoot>
           		</table>
           		<div>
           			<form action="/insertMyHistory.do" id="insert-history">
           				<input type="text" name="year1" class="input-form2" style="width: 150px;" placeholder="시작년도 YYYY" required="required">
           				<input type="text" name="year2" class="input-form2" style="width: 150px;" placeholder="종료년도 YYYY" required="required">
           				<input type="text" name="doctorWork" class="input-form2" style="width: 300px;" placeholder="근무지 또는 연수" required="required">
           				<input type="hidden" name="doctorId" value=<%=m.getMemberId() %>>
           				<button class="btn bc6" style="width: 80px;">등록</button>           				
           			</form>
           		</div>
           		<div><button class="load-more-btn" id="newHistory">경력추가</button></div>
       		</div>
       		
       		<div class="mytbl-wrap">
           		<div class="my-title">나의 답변</div>
           		<table class="tbl my-tbl q-tbl" id="myAnswer-tbl" style="width: 960px;">
           			<thead>
	               	<tr>
	                   	<th style="width: 400px;">제목</th>
	                   	<th>디렉토리</th>
	                   	<th>작성일</th>
	               	</tr>
	               	</thead>
	               	<tbody id="abody">
	               </tbody>
	           </table>
	           <div><button class="load-more-btn" id="moreA">더보기</button></div>
        	</div>
        	<div class="mytbl-wrap">
            <div class="my-title">나의 후기 (<span>n</span>)</div>
            <table class="tbl my-tbl" id="myReview-tbl" style="width: 960px;">
	            <thead>
	                <tr>
	                    <th>진료일자</th>
	                    <th>환자정보</th>
	                    <th>평가점수</th>
	                </tr>
	            </thead>
	            <tbody id="rbody">

                </tbody>
            </table>
            <div><button class="load-more-btn" id="moreR">더보기</button></div>
        </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
    
<script>
$("#newHistory").on("click", function() {
	$("#insert-history").css("display", "flex");
})


function getMyHistory(){
	$.ajax({
		url: "/getMyHistory.do",
		type: "post",
		dataType: "json",
		data: {	
				memberId : '<%= m.getMemberId() %>'
		},
		success: function (data) {
			let NodeList = "";
			for(i = 0; i < data.length; i++){
				let newNode = "<tr>";
				newNode += "<td>"+ data[i].historyStartYear + "-" + data[i].historyEndYear + "</td>";
				newNode += "<td>"+ data[i].doctorWork + "</td>";
				newNode += "</tr>";
				NodeList += newNode;
			}
			
			$(NodeList).appendTo($("#hbody"));
			}				
		})
	};
	
	function getMyAnswer(index){
		let endIndex = index+searchStepA-1;	// endIndex설정
		$.ajax({
			url: "/getMyAnswer.do",
			type: "post",
			dataType: "json",
			data: {	
					memberNo : '<%= m.getMemberNo() %>',
					startIndex: index,
					endIndex: endIndex
			},
			success: function (data) {
				//console.log(data);
				let NodeList = "";
				for(i = 0; i < data.length; i++){
					let newNode = "<tr>";
					newNode += "<td>"+"<a href='/counselView.do?clickIndex=1&counselNo="+data[i].counselNo +"'><span>Q</span>"+ data[i].counselTitle + "</a></td>";
					newNode += "<td>"+ data[i].counselSubject + "</td>";
					newNode += "<td>"+ data[i].counselDate + "</td>";
					newNode += "</tr>";
					NodeList += newNode;
				}
				$(NodeList).appendTo($("#abody")).slideDown();

				const totalAnswerDiv = $("#totalAnswer").text();
				const totalAnswer = Number(totalAnswerDiv);
				console.log(totalAnswer);
				// 더보기 버튼 삭제
				if(endIndex >= totalAnswer){
					$("#moreA").remove();
				}				
			}
		});
	};
	
	function getMyReview(index){
		let endIndex = index+searchStepR-1;	// endIndex설정
		$.ajax({
			url: "/getMyReview.do",
			type: "post",
			dataType: "json",
			data: {	
					memberId : '<%= m.getMemberId() %>',
					startIndex: index,
					endIndex: endIndex
			},
			success: function (data) {
				let NodeList = "";
				console.log(data.length);
				for(i = 0; i < data.length; i++){
					let newNode = "<tr>";
					newNode += "<td>"+ data[i].bookDate + "</td>";
					newNode += "<td>"+ data[i].memberId + "</td>";
					newNode += "<td>"+ data[i].starMark + "</td>";
					newNode += "</tr>";
					NodeList += newNode;
				}
				$(NodeList).appendTo($("#rbody")).slideDown();
				
				const totalReviewDiv = $("#totalReview").text();
				const totalReview = Number(totalReviewDiv);
				console.log(totalReview);
				// 더보기 버튼 삭제
				if(endIndex >= totalReview){
					$("#moreR").remove();
				}				
			}
		});
	};
		
		
$(document).ready(function(){

	$("#moreA").click(function(){
		startIndexA += searchStepA;
		getMyAnswer(startIndexA);
	});
	

	$("#moreR").click(function(){
		startIndexR += searchStepR;
		getMyReview(startIndexR);
	});
	
	// myReview 더보기 실행함수
	
});

</script>
</html>