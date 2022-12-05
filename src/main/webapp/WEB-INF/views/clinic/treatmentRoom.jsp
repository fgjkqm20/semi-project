<%@page import="nbd.clinic.model.vo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list");
    %>
    <%
    String memberId =(String)request.getAttribute("memberId");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="css/TR.css">
    <link rel="stylesheet" href="css/common/default.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body id="body">
<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="BBack">
        <div class="page-content" style="width:900px;">
            <div class="page-title" style="font-size:25px">
                나의 진료차트
            </div>
            <div class="contentTop">
                <div>진료중</div>
                <div>진료완료</div>
            </div>
            <div class="reservate">
            <%for(Book book : list) {%>
            <%if(book.getBookDoctor().equals(memberId)){ %>
            <%if(book.getMemberState()==1){ %>
           		<div class="patient">
                    <div class="patientName"><%=book.getMemberName()%> 님</div>
                    <div class="patientDate"><span>진료일 : </span><%=book.getBookDate() %> - <%=book.getBookTime()%></div>
                    <div class="patientDoc">
                        <span>담당 의료진 : </span>
                        <span><%=book.getBookDoctor()%></span>
                    </div>
                </div>
                <div class="status">
                    <button class="patientstat" style="border: rgb(255, 197, 0); background-color: rgb(255, 197, 0);">
                    진료대기</button>
                    <button>환자정보</button>
                </div>
            <%} %>
                       
            <%if(book.getMemberState()==2){ %>
            	<div class="patient">
                    <div class="patientName"><%=book.getMemberName()%> 님</div>
                    <div class="patientDate"><span>진료일 : </span><%=book.getBookDate() %> - <%=book.getBookTime()%></div>
                    <div class="patientDoc">
                        <span>담당의 : </span>
                        <span><%=book.getBookDoctor()%></span>
                    </div>
                </div>
                <div class="status">
                	<button class="patientstat">진료중</button>
                    <button>환자정보</button>
                </div>
            <%} %>
            <%} %>
            <%} %>
            </div>
            
            <div class="treatOff">
            <%for(Book book : list) {%>
            <%if(book.getBookDoctor().equals(memberId)){ %>
            <%if(book.getMemberState()==3){ %>
            	<div class="patient">
                    <div class="patientName"><%=book.getMemberName()%> 님</div>
                    <div class="patientDate"><span>진료일 : </span><%=book.getBookDate() %> - <%=book.getBookTime()%></div>
                    <div class="patientDoc">
                        <span>담당의 : </span>
                        <span><%=book.getBookDoctor()%></span>
                    </div>
                </div>
                <div class="status">
                    <button stlye="background-color:" class="dWait" style="background-color: #449f8d;">처방대기</button>
                    <button>결제</button>
                </div>
            <%} %>
            <%if(book.getMemberState()==4){ %>
            	<div class="patient">
                    <div class="patientName"><%=book.getMemberName()%> 님</div>
                    <div class="patientDate"><span>진료일 : </span><%=book.getBookDate() %> - <%=book.getBookTime()%></div>
                    <div class="patientDoc">
                        <span>담당의 : </span>
                        <span><%=book.getBookDoctor()%></span>
                    </div>
                </div>
                <div class="status">
                    <button style="background-color:lightgray; border:1px solid darkgray;">처방완료</button>
                    <button>결제</button>
                </div>      
            <%} %>
            <%if(book.getMemberState()==5){ %>
            	<div class="patient" style="display:none;">
                    <div class="patientName"><%=book.getMemberName()%> 님</div>
                    <div class="patientDate"><span>진료일 : </span><%=book.getBookDate() %> - <%=book.getBookTime()%></div>
                    <div class="patientDoc">
                        <span>담당의 : </span>
                        <span><%=book.getBookDoctor()%></span>
                    </div>
                </div>
                <div class="status" style="display:none;">
                    <button>진료종료</button>
                    <button>결제완료</button>
                </div>      
            <%} %>
            <%} %>
            <%} %>           
            </div>                			           
        </div>
        <div class="outBtn">
        <a href="/mypage.do?memberGrade=2"><button>이전 페이지</button></a>
       	<a href="/"><button>메인 페이지</button></a>
    	</div>
    </div>
   
   
    <%for(Book book :list) {%>
    <%if(book.getBookDoctor().equals(memberId)){ %>
    <%if(book.getMemberState()==1 || book.getMemberState()==2){ %>
    <div class="patientClose">
        <div class="CloseCancel"><span class="material-symbols-outlined">
            close
            </span></div>
        <%if(book.getMemberPhoto()==null){ %>
        <div class="patientPic" style="font-size:13px;">등록된 사진이 없습니다.</div>
        <%}else{ %>
        <div class="patientPic"><img src="/upload/profil/<%=book.getMemberPhoto()%>"></div>
        <%} %>
        <div class="aboutPatient">
            <div id="patientName2">
                <span>이름 : </span>
                <span><%=book.getMemberName() %></span>
            </div>
            <div id="patientMuch">
                <span>태어난 연도 : </span>
                <span><%=book.getMemberAge() %></span>
                <span>년생</span>
            </div>
            <div id="howMany">
                <span>전화번호 : </span>
                <span style="font-size:12px;"><%=book.getMemberPhone()%></span>
            </div>
        </div>
        <div class="wherePain">
            <p> 증 상</p>
            <textarea><%=book.getBookHistory() %></textarea>
        </div>   
    </div>
    <%} %>
    <%} %>
    <%} %>
    

    <%for(Book book:list){ %>
	<%if(book.getBookDoctor().equals(memberId)){ %>
	<%if(book.getMemberState()==3 || book.getMemberState()==4){ %>
    <div class="prmodal-wrap">
        <div class="priceArea">
            <form action="/insertPrice.do" name="bookPrice" method="get">
                <div class="ptext"><span><%=book.getMemberName() %></span>님의 진료비을 입력해주세요 !!
                <p>주의 : 진료비 기입시 자동 진료종료 됩니다. 신중해주세요</p>
                </div>
                <div class="payM"style="padding:10px;">
                    <input type="text" name="price" class="price" placeholder="         진료비 입력하기">
                    <input type="hidden" name="memberNo" value="<%=book.getMemberNo()%>">
                    <button type="submit" class="priceBtn">제출</button>
                    <button type="button" class="pcancel">취소</button>
                </div>
            </form>
        </div>
    </div>
    <%} %>
	<%} %>
    <%} %>
    
    <%for(Book book:list){ %>
    <%if(book.getBookDoctor().equals(memberId)){ %>
    <%if(book.getMemberState()==3){%>
    <div class="prmodal-wrap2">
    	<div class="sendMat">
    		<form action="/sendDrug.do">
    			<div class="drugHead"><span><%=book.getMemberName()%></span>님께 처방전을 전송하시겠습니까?</div>
    			
    			<div class="filebox">
    			<input class="upload-name" value="처방전선택" disabled="disabled">
    			<label for="ex_filename">업로드</label>
    			<input type="file" id="ex_filename" class="upload-hidden">
    			</div>
    			
    			<input type="hidden" name="memberNo" value="<%=book.getMemberNo()%>">
    			<div class="drugBtn">
	    			<button type="submit" class="drugSend">전송</button>
	    			<button type="button" class="drugCancel">취소</button>    			
    			</div>
    		</form>
    	</div>
    </div>
    <%} %>
    <%} %>
    <%} %>
    
    
    <%for(Book book:list){ %>
    <%if(book.getBookDoctor().equals(memberId)){ %>
    <%if(book.getMemberState()==1 || book.getMemberState()==2){ %>
    <div class="prmodal-wrap1">
    	<div class="changeState">
    		<form action="/changeStatus.do" name="changeStatue" method="get">
    			<div class="pName" style="width: 200px;"><span><%=book.getMemberName()%></span>님 진료현황</div>
    			<%if(book.getMemberState()==1) {%>
    			<select class="input-form" name="pstatus"style="width: 300px;margin: 0 auto;">
    				<option value="1" selected>진료대기</option>
    				<option value="2">진료중</option>
    				<option value="3">처방대기</option>
    				<option value="4">처방완료</option>
    			</select>
    			<%}else if(book.getMemberState()==2){ %>
    			<select class="input-form"  name="pstatus" style="width: 300px; margin: 0 auto;">
    				<option value="1">진료대기</option>
    				<option value="2" selected>진료중</option>
    				<option value="3">처방대기</option>
    				<option value="4">처방완료</option>
    			</select>
    			<%} %>
    			<input type="hidden" name="bookNo" value="<%=book.getBookNo()%>">
    			<div class="button-wrap">
    				<button type="submit" class="changeBtn">변경</button>
    				<button type="button" class="cancelBtn">취소</button>
    			</div>
    		</form>
    	</div>
    </div>
    <%} %>
    <%} %>
    <%} %>
    
    
    <script>
    const showOut = $(".CloseCancel");
    const aboutPatient = $(".patientClose");
    const showMe = $(".reservate>.status>button:last-child");
    const Name = $("#patientName2>span:last-child").text();
    //환자상세정보보기
    showMe.on("click",function(){
    	const index = showMe.index(this);
        aboutPatient.eq(index).css("display","block");
    });
    //환자상세정보취소
    showOut.on("click",function(){
    	const index = showOut.index(this);
        aboutPatient.eq(index).css("display","none");
    });
    
    const payBtn = $(".treatOff>.status>button:last-child");
    const prmodal = $(".prmodal-wrap");
    //결제버튼 클릭했을때
    payBtn.on("click",function(){
    	const index = payBtn.index(this);
    	prmodal.eq(index).css("display","flex");
    });
    
    //결제취소버튼 클릭했을때
    const priceBtn = $(".priceBtn");
    const priceCancel = $(".pcancel");
    priceBtn.on("click",function(){
    	const index = priceBtn.index(this);
    	priceBtn.eq(index).css("display","none");
    });
    priceCancel.on("click", function(){
    	const index = priceCancel.index(this);
    	prmodal.eq(index).css("display", "none");
    });
    
    
   const reser = $(".reservate>.status button:first-child");
   const prmodal1 = $(".prmodal-wrap1");
   const cancel1 = $(".cancelBtn");
   reser.on("click",function(){
	  const index = reser.index(this);
	  prmodal1.eq(index).css("display","flex");
   });
   cancel1.on("click",function(){
	  const index = cancel1.index(this);
	  prmodal1.eq(index).css("display","none");
   });
   
   const drugCancel = $(".drugCancel");
   const prmodal2 = $(".prmodal-wrap2");
   drugCancel.on("click",function(){
	   const index = drugCancel.index(this);
	   prmodal2.eq(index).css("display", "none");
   });
   
   const dWait = $(".dWait");
   dWait.on("click",function(){
	  const index = dWait.index(this);
	  prmodal2.eq(index).css("display", "flex");
   });
    </script>
    
    
<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>
































