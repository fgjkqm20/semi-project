<%@page import="java.util.ArrayList"%>
<%@page import="nbd.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
        <%@include file="/WEB-INF/views/member/mypageHeaderPatient.jsp" %>
        	<div class="mypage-content">
            <div class="mytbl-wrap">
                <div class="my-title">나의 질문</div>
                <table class="q-tbl tbl" id="myquestion-tbl" style="width: 960px;">
                	<thead>
                    <tr>
                        <th style="width: 400px;">제목</th>
                        <th>디렉토리</th>
                        <th>작성일</th>
                        <th>답변완료여부</th>
                    </tr>
                    </thead>
                    <tbody id="qbody">
                    </tbody>
                </table>
                <div><button class="load-more-btn" id="moreQ">더보기</button></div>
            </div>
            <div class="mytbl-wrap">
                <div class="my-title">진료 예약 현황</div>
                <table class="tbl my-tbl" id="myreserve-tbl" style="width: 960px;">
                	<thead>
                    <tr>
                        <th>병원명</th>
                        <th>진료과</th>
                        <th>진료 일자</th>
                        <th>예약 현황</th>
                    </tr>
                    </thead>
                    <tbody id="bbody">
                    </tbody>
                </table>
                <div>
                	<button class="load-more-btn" id="moreB">더보기</button>
                	<input type="hidden" value="<%= m.getMemberNo()%>">
                	<input type="hidden" value="<%= m.getMemberId()%>">
                </div>
            </div>
        	</div>
    </div>

    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>

<script>
function getMyQuestion(index){
	const inputVal = $("#moreB").next().next().val();
	//const totalQuestionDiv = $("#my-q").text();
	//const totalQuestion = Number(totalQuestionDiv);
	//console.log("함수시작"+totalQuestion);
	let endIndex = index+searchStepQ-1;	// endIndex설정
	
	$.ajax({
		url: "/getMyQuestion.do",
		type: "post",
		dataType: "json",
		data: {	startIndex: index,
				endIndex: endIndex,
				memberId: inputVal
		},
		success: function (data) {
			let NodeList = "";
			console.log(data);
			for(i = 0; i < data.length; i++){
				let newNode = "<tr>";
				newNode += "<td>"+"<a href='/counselView.do?clickIndex=1&counselNo="+data[i].counselNo +"'><span>Q</span>"+ data[i].counselTitle + "</a></td>";
				newNode += "<td>"+ data[i].counselSubject + "</td>";
				newNode += "<td class='qtd'>"+ data[i].counselDate + "</td>";
					if(data[i].counselAnswer == 0){
						newNode += "<td style='color:rgb(255, 197, 0, 1); font-family:ns-bold;'>N</td>";
					}else if(data[i].counselAnswer == 1){
						newNode += "<td style='color:#77bbd7; font-family:ns-bold;'>Y</td>";
					}
				newNode += "</tr>";
				NodeList += newNode;
			}
			$(NodeList).appendTo($("#qbody")).slideDown();
			// 더보기 버튼 삭제
			//const currQ = $(".qtd").length;
			const totalQuestionDiv = $("#my-q").text();
			const totalQuestion = Number(totalQuestionDiv);
			
			if(endIndex >= totalQuestion){	//13 // 13
				$("#moreQ").remove();
			}				
		}
	});
}

function getMyReserve(index){
	const inputVal = $("#moreB").next().val();
	let endIndex = index+searchStepB-1;	// endIndex설정
	$.ajax({
		url: "/getMyBook.do",
		type: "post",
		dataType: "json",
		data: {	
				memberNo : inputVal,
				startIndex: index,
				endIndex: endIndex
			  },
		success: function (data) {
		let NodeList = "";
		for(i = 0; i < data.length; i++){
			let newNode = "<tr>";
			newNode += "<td><a href='/prescriptionGo.do?bookNo="+data[i].bookNo +"'>"+data[i].hospitalName+"</td>";
			newNode += "<td>"+ data[i].doctorMajor + "</td>";
			newNode += "<td>"+ data[i].bookDate + "</td>";
			
			if(data[i].memberState == 5){
				newNode += "<td><button class='btn_small bc6 my-Detail' onclick='func1("+data[i].bookNo+");' >진료종료</button></td>";
			}else if(data[i].memberState == 4){
				newNode += "<td><button class='btn_small bc5 my-Detail' onclick='func1("+data[i].bookNo+");' >처방종료</button></td>";
			}else if(data[i].memberState == 3){
				newNode += "<td><button class='btn_small bc5 my-Detail' onclick='func1("+data[i].bookNo+");' >진료완료</button></td>";
			}else if(data[i].memberState == 2){
				newNode += "<td><button class='btn_small bc2 my-Detail'>진료중</button></td>";
			}else if(data[i].memberState == 1){
				newNode += "<td><button class='btn_small bc4 my-Detail'>진료대기</button></td>";
			}
			newNode += "</tr>";
			NodeList += newNode;
		}
			$(NodeList).appendTo($("#bbody")).slideDown();
			
			const totalBookDiv = $("#my-r").text();
			const totalBook = Number(totalBookDiv);
				// 더보기 버튼 삭제
			if(endIndex >= totalBook){
				$("#moreB").remove();
			}				
		}
	});
}


$(document).ready(function(){

	// my Q 더보기 클릭시
	$("#moreQ").click(function(){
		startIndexQ += searchStepQ;
		getMyQuestion(startIndexQ);
	});

	// my B 더보기 클릭시
	$("#moreB").click(function(){
		startIndexB += searchStepB;
		getMyReserve(startIndexB);
	});
	
});

function func1(data) {
	console.log(data);
	location.href="/getMyBookDetail.do?bookNo="+data;
};
	
</script>
</html>