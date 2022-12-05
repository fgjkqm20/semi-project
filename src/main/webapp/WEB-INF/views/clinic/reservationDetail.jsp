<%@page import="nbd.member.model.vo.Member"%>
<%@page import="nbd.member.model.vo.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Doctor doctor = (Doctor)request.getAttribute("doctor");
    %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/common/header.css">
    <link rel="stylesheet" href="/css/common/footer.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="/css/reservation.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="/js/common/jquery-3.6.0.js"></script>
    
    <style type="text/css">
    	.reserve-btn>#reserveBtn{
		    width: 800px;
		    height: 80px;
		    border-style: none;
		    border-radius: 20px;
		    background-color: white;
		    color: rgb(16, 203, 156);
		    border: 2px solid rgb(16, 203, 156);
		    font-size: 25px;
		    margin-left: 60px;
		    line-height: 80px;
		    text-decoration: none;
		    margin: 0 auto;
		}
		
		.reserve-btn>#reserveBtn:hover{
			cursor: pointer;
		}
		
		.selectDayBtn{
			line-height: 0px;
		}
		
		#today+label{
			display : inline-block;
			width: 90px;
		    height: 45px;
		    line-height: 45px;
		    background-color: rgb(150, 217, 167);
		    margin-top: 20px;
		    border-radius: 5px;
		    color: white;
		    font-size: 20px;
		}
		
		#tommorw+label{
			display : inline-block;
			width: 90px;
		    height: 45px;
		    line-height: 45px;
		    background-color: rgb(150, 217, 167);
		    margin-top: 20px;
		    border-radius: 5px;
		    color: white;
		    font-size: 20px;
		}
		
		.selectDayBtn>div{
			height: 0px;
			margin-top: 0px;
		}
    </style>
</head>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<body>
    <div class="reserve-wrap">
        <div class="reserve-title">
            <h3>비대면진료실</h3>
        </div>
		<form action="/prescriptionO.do" method="post">
		<%if(m != null){ %>
			<input type="hidden" name="memberNo" value="<%=m.getMemberNo()%>">
		<%}else{ %>
			<input type="hidden" name="memberNo" value="0">
		<%} %>
		<input type="hidden" name="doctorid" value="<%=doctor.getDoctorId()%>">
		<input type="hidden" name="hospitalAddr" value="<%=doctor.getHospitalAddr()%>">
		<input type="hidden" name="hospitalName" value="<%=doctor.getHospitalName()%>">
		<input type="hidden" name="docMajor" value="<%=doctor.getDoctorMajor()%>">
		<div class="doctor-wrap" style="display: flex;">
            <div class="doctor-img" style="margin-right: 50px;">
                <div class="doctor-pic" style="width: 150px; height: 150px;">
                    <img src="/upload/profil/<%=doctor.getDoctorPhoto() %>" id="doctor-info" style="width: 150px; height: 150px; border-style: none;">
                </div>

                <div class="star-score">
                    <span class="material-icons" style="color: gold;">star</span>
                    <div>
                        <span class="score"><%=doctor.getDoctorAvgStar() %></span>
                        <span class="review-count">리뷰(+100)</span>
                    </div>    
                </div>
            </div>
		
            <div class="doctor-info">
                <div class="doctor-intro">
                    <span class="major" style="background-color: rgb(16, 203, 156);"><%=doctor.getDoctorMajor() %> 전문의</span><br>
                    <span class="doctor-name" style="font-size: 25px;"><%=doctor.getDoctorName() %>의사</span><br>
                    <span class="hospital"><%=doctor.getHospitalName() %></span>
                </div>

                <div class="career">
                    <p class="career-content"><%=doctor.getHospitalAddr() %></p>
                    
                </div>
            </div>
        </div>
        
        <div class="reserve-day">
            <div class="reserve-selectday">
                <div>
                    <span class="material-icons" style="font-size: 55px;">
                        date_range
                        </span>
                    <div>
                        <span class="selectDate" style="font-size: 35px;">날짜선택</span>
                    </div>
                </div> 
            </div>

            <p class="account" style="margin-top: 30px;">
                평일과 주말 상관없이 당일과 다음날 예약이 가능합니다.
            </p>

            <div class="selectDayBtn">
                <div>
                    <input type="radio" id="today" name="selectDay">
                    <label for="today">오늘</label>
                </div>

                <div class="space" style="background-color: white; width: 70px;">

                </div>

                <div>
                    <input type="radio" id="tommorw" name="selectDay">
                    <label for="tommorw">내일</label>
                </div>
            </div>
        </div>

        <div class="reserve-time" style="margin-top: 20px;">
            <div class="reserve-selectday">
                <div>
                    <span class="material-icons" style="font-size: 55px;">
                        schedule
                        </span>
                    <div>
                        <span class="selectDate" style="font-size: 35px;">시간선택</span>
                    </div>
                </div> 
            </div>

            <div class="morning">
                <div class="morning-title">
                    <h2 style="margin-left: 50px;">오전</h2>
                </div>

                <div class="morning-btn">
                    <input type="radio" name="select-time" class="morningBtn" id="nine" value="9:00">
                    <label for="nine">9:00</label>
                    <input type="radio" name="select-time" class="morningBtn" id="nine-half" value="9:30">
                    <label for="nine-half">9:30</label>
                    <input type="radio" name="select-time" class="morningBtn" id="ten" value="10:00">
                    <label for="ten">10:00</label>
                    <input type="radio" name="select-time" class="morningBtn" id="ten-half" value="10:30">
                    <label for="ten-half">10:30</label>
                    <input type="radio" name="select-time" class="morningBtn" id="eleven" value="11:00">
                    <label for="eleven">11:00</label>
                    <input type="radio" name="select-time" class="morningBtn" id="eleven-half" value="11:30">
                    <label for="eleven-half">11:30</label>
                    <input type="radio" name="select-time" class="morningBtn" id="twelve" value="12:00">
                    <label for="twelve">12:00</label>

                    <div class="evening-title">
                        <h2 style="margin-left: 0px;">오후</h2>
                    </div>

                    <input type="radio" name="select-time" class="eveningBtn" id="thirteen" value="13:00">
                    <label for="thirteen">13:00</label>
                    <input type="radio" name="select-time" class="eveningBtn" id="fourteen" value="14:00">
                    <label for="fourteen">14:00</label>
                    <input type="radio" name="select-time" class="eveningBtn" id="fifteen" value="15:00">
                    <label for="fifteen">15:00</label>
                    <input type="radio" name="select-time" class="eveningBtn" id="sixteen" value="16:00">
                    <label for="sixteen">16:00</label>
                    <input type="radio" name="select-time" class="eveningBtn" id="seventeen" value="17:00">
                    <label for="seventeen">17:00</label>
                    <input type="radio" name="select-time" class="eveningBtn" id="eighteen" value="18:00">
                    <label for="eighteen">18:00</label>
                    <input type="radio" name="select-time" class="eveningBtn" id="nineteen" value="19:00">
                    <label for="nineteen">19:00</label>
                    <input type="radio" name="select-time" class="eveningBtn" id="twenty" value="20:00">
                    <label for="twenty">20:00</label>
                </div>
            </div>
        </div>

        <div class="symptom">
            <div class="symptom-title">
                <div>
                    <span class="material-icons" style="font-size: 55px; width: 50px;line-height: 80px;">
                        person_filled
                        </span>
                    <div>
                        <span class="selectDate" style="font-size: 35px;">증상 설명</span>
                    </div>
                </div> 
            </div>

            <div class="symptom-content">
                <textarea name="symptom-data" id="symptom-data" placeholder="증상을 입력하세요." style="resize: none; padding-left: 15px; border-radius: 10px;"></textarea>
            </div>
        </div>

        <div class="reserve-btn">
        	<%if(m != null){ %>
            <button type="submit" id="reserveBtn">예약하기</button>
            <%}else{ %>
            <div>로그인 후에 사용할 수 있습니다.</div>
            <div><a href="/loginFrm.do">로그인하러가기</a></div>
            <%} %>
        </div>
		</form>
        
        
    </div>
    <script>
    
    	
    	$("#today+label").on("click", function(){
    		$(this).css("background-color", "rgb(16, 203, 156)");
            $("#tommorw+label").css("background-color", "rgb(150, 217, 167)");
    		const date = new Date();
    		
    		let yy = date.getFullYear();
    		let mm = date.getMonth()+1;
    		let dd = date.getDate();
    		console.log(yy + "년" + mm + "월" + dd + "일");
    		$("#today").val(yy + "년" + mm + "월" + dd + "일");
    	})
    	
    	$("#tommorw+label").on("click", function(){
    		$(this).css("background-color", "rgb(16, 203, 156)");
            $("#today+label").css("background-color", "rgb(150, 217, 167)");
    		const date = new Date();
    		
    		let yy = date.getFullYear();
    		let mm = date.getMonth()+1;
    		let dd = date.getDate() + 1;
    		console.log(yy + "년" + mm + "월" + dd + "일");
    		$("#tommorw").val(yy + "년" + mm + "월" + dd + "일");
    	})
    
        /*$(".selectDayBtn>div:first-child").on("click", function(){
            $(this).css("background-color", "rgb(16, 203, 156)");
            $(".selectDayBtn>div:last-child").css("background-color", "rgb(150, 217, 167)");
			const date = new Date();
    		
    		let yy = date.getFullYear();
    		let mm = date.getMonth()+1;
    		let dd = date.getDate();
    		console.log(yy + "년" + mm + "월" + dd + "일");
    		if($("#today").prop("check")){
    			$("#today").val(yy + "년" + mm + "월" + dd + "일");	
    		}
    		
        });

        $(".selectDayBtn>div:last-child").on("click", function(){
            $(this).css("background-color", "rgb(16, 203, 156)");
            $(".selectDayBtn>div:first-child").css("background-color", "rgb(150, 217, 167)");
			const date = new Date();
    		
    		let yy = date.getFullYear();
    		let mm = date.getMonth()+1;
    		let dd = date.getDate() + 1;
    		console.log(yy + "년" + mm + "월" + dd + "일");
    		if($("#tommorw").prop("checked")){
    			$("#tommorw").val(yy + "년" + mm + "월" + dd + "일");
    		}
    		
        });*/

        $("input[name=select-time]+label").on("click", function(){
            const index = $("input[name=select-time]+label").index(this);
            console.log($("input[name=select-time]").eq(index).val());
            if($("input[name=select-time]").attr("checked", true)){
                $(this).css("background-color", "rgb(16, 203, 156)");
                $("input[name=select-time]+label").eq(index).prevAll().css("background-color", "rgb(150, 217, 167)");
                $("input[name=select-time]+label").eq(index).nextAll().css("background-color", "rgb(150, 217, 167)");
            }
            $(".evening-title>h2").css("background-color", "white");
        })
/*        
        const date = new Date();
        
        	$.ajax({
        	
        	})
        bookCheck(날짜);
        	
        function bookCheck(selectDate){
        	//의사정보 
        	
        	의사정보,날짜
        }
        
        
        $.ajax({
               url : "/ajaxCheckId.do",
               type : "get",
               data : {memberId : memberId},
               success : function(data){
                  if(data == "1"){
                     $("#ajaxCheckId").text("이미 사용중인 아이디입니다.");
                     $("#ajaxCheckId").css("color", "red");
                  } else if(data == "0"){
                     $("#ajaxCheckId").text("사용가능한 아이디입니다.");
                     $("#ajaxCheckId").css("color", "blue");
                  }
               }
            })
*/        
$("#reserveBtn").on("click", function(){
    
    console.log($("input:radio[name=selectDay]:checked").length);
    console.log($("input:radio[name=select-time]:checked").length);
    
    if($("input:radio[name=selectDay]:checked").length == 0){
       alert("날짜를 입력하세요");
       $("#reserveBtn").attr("type", "button");
       console.log("제발 되라1");
    }else if($("input:radio[name=select-time]:checked").length == 0){
       alert("시간을 선택하세요");
       $("#reserveBtn").attr("type", "button");
       console.log("제발 되라2");
    }else if($("#symptom-data").val()==""){
       alert("증상을 입력하세요");
       $("#reserveBtn").attr("type", "button");
       console.log("제발 되라3");
    }else{
       $("#reserveBtn").attr("type", "submit");
    }
 })
    </script>
</body>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</html>