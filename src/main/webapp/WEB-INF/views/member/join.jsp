<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/nearDocJoin.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- CSS only -->
<!--  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">-->
<link rel="stylesheet" href="/css/common/default.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/js/common/jquery-3.6.0.js"></script>
<script src="sweetalert2.min.js"></script>
<link rel="stylesheet" href="sweetalert2.min.css">
<style type="text/css">
	.authEmail>.inputEmail{
	position: relative;
	}

	.emailText{
		width : 190px;
		height : 40px;
		margin-left: 220px;
		padding-bottom: 20px;
		position: absolute;
		top : 28px;
	}
	
	#post{
		width: 180px;
	}
	
	.nextBtn>.btn{
		border-color: transparent;
	}
	
	#nextBtn:hover{
		cursor: pointer;
	}
	
	#next:hover, .fileValue>#upfile:hover{
		cursor: pointer;
	}
	
	label[for=upfile]{
		cursor: pointer;
	}
	
	.idValue>select{
		border-radius: 10px;
		border-color: #ccc;
	}
</style>
</head>
<body>

    <div class="join-wrap">
        <div class="go-login">
            <span>이미 가입된계정이 있으신가요?</span>
            <a href="/loginFrm.do">로그인하러 가기</a>
        </div>

        <div class="join-content">
            <div class="join-title">
                <h1><a href="/"><span><img src="/img/common/로고.png" style="width: 400px;"></span><span>비대면진료</span></a></h1>
            </div>

            <div class="join-real-content">
                <ul>
                    <li class="agree-title">가입약관 동의</li>
                    <li class="allAgree" style="border: 1px solid darkgrey; margin-top: 10px;">
                        <input type="checkbox" name="allAgree" id="allAgree">
                        <label for="allAgree"><span class="material-icons">
                            task_alt
                            </span></label>
                        <span style="font-size: 25px; padding-left: 10px;">모든 약관에 동의합니다.</span>
                    </li>

                    <li class="joinAgree">
                        <div class="joinAgree-title">
                            <input type="checkbox" name="joinAgree-title" id="joinAgree-title">
                            <label for="joinAgree-title"><span class="material-icons">
                                task_alt
                            </span></label>
                            <span style="padding-left: 5px;">회원가입 이용약관 동의</span>
                            
                            
                            <button type="button" id="joinDetailBtn" style="width: 85px; font-size: 14px;"class="detailBtn">자세히보기</button>
                        </div>

                        <div class="joinDetail">
                            1. “개인정보”란 살아 있는 개인에 관한 정보로서 다음 각 목의 어느 하나에 해당하는 정보를 말한다.<br>

                            가. 성명, 주민등록번호 및 영상 등을 통하여 개인을 알아볼 수 있는 정보<br>

                            나. 해당 정보만으로는 특정 개인을 알아볼 수 없더라도 다른 정보와 쉽게 결합하여 알아볼 수 있는 정보. 이 경우 쉽게 결합할 수 있는지 여부는 다른 정보의 입수 가능성 등 개인을 알아보는 데 소요되는 시간, 비용, 기술 등을 합리적으로 고려하여야 한다.<br>

                            다. 가목 또는 나목을 제1호의2에 따라 가명처리함으로써 원래의 상태로 복원하기 위한 추가 정보의 사용ㆍ결합 없이는 특정 개인을 알아볼 수 없는 정보(이하 “가명정보”라 한다)<br>
                        </div>
                    </li>
                    <li class="personalAgree">
                        <div class="personalProtect">
                            <input type="checkbox" name="personalAgree" id="personalAgree">
                            <label for="personalAgree"><span class="material-icons">
                                task_alt
                            </span></label>
                            <span style="padding-left: 5px;">개인정보 이용약관 동의</span>
                            
                            
                            <button type="button" id="personalDetail" class="detailBtn" style="width: 85px; font-size: 14px;">자세히보기</button>
                        </div>

                        <div class="personalDetail">
                            1. “개인정보”란 살아 있는 개인에 관한 정보로서 다음 각 목의 어느 하나에 해당하는 정보를 말한다.<br>

                            가. 성명, 주민등록번호 및 영상 등을 통하여 개인을 알아볼 수 있는 정보<br>

                            나. 해당 정보만으로는 특정 개인을 알아볼 수 없더라도 다른 정보와 쉽게 결합하여 알아볼 수 있는 정보. 이 경우 쉽게 결합할 수 있는지 여부는 다른 정보의 입수 가능성 등 개인을 알아보는 데 소요되는 시간, 비용, 기술 등을 합리적으로 고려하여야 한다.<br>

                            다. 가목 또는 나목을 제1호의2에 따라 가명처리함으로써 원래의 상태로 복원하기 위한 추가 정보의 사용ㆍ결합 없이는 특정 개인을 알아볼 수 없는 정보(이하 “가명정보”라 한다)<br>
                        </div>
                    </li>

                    <li class="HandlinAgree">
                        <div class="personalHandling">
                            <input type="checkbox" name="personalHandling" id="personalHandling">
                            <label for="personalHandling"><span class="material-icons">
                                task_alt
                            </span></label>
                            <span style="padding-left: 5px;">회원가입 처리약관 동의</span>
                            
                            
                            <button type="button" id="HandlingBtn" class="detailBtn" style="width: 85px; font-size: 14px;">자세히보기</button>
                        </div>

                        <div class="handlingDetail">
                            1. “개인정보”란 살아 있는 개인에 관한 정보로서 다음 각 목의 어느 하나에 해당하는 정보를 말한다.<br>

                            가. 성명, 주민등록번호 및 영상 등을 통하여 개인을 알아볼 수 있는 정보<br>

                            나. 해당 정보만으로는 특정 개인을 알아볼 수 없더라도 다른 정보와 쉽게 결합하여 알아볼 수 있는 정보. 이 경우 쉽게 결합할 수 있는지 여부는 다른 정보의 입수 가능성 등 개인을 알아보는 데 소요되는 시간, 비용, 기술 등을 합리적으로 고려하여야 한다.<br>

                            다. 가목 또는 나목을 제1호의2에 따라 가명처리함으로써 원래의 상태로 복원하기 위한 추가 정보의 사용ㆍ결합 없이는 특정 개인을 알아볼 수 없는 정보(이하 “가명정보”라 한다)<br>
                        </div>
                    </li>

                    <li class="next">
                        <button type="button" id="cancleBtn" class="statusBtn" onclick="cancleBtn()">취소</button>
                        <button type="button" id="nextBtn" class="statusBtn">다음</button>
                    </li>
                </ul>
            </div>

            <div class="class-info" style="display: none;">
                <div class="info-info">
                    <span>회원 상세 정보입력</span>
                    <span>* 필수입력</span>
                </div>
                
                <form action="/checkIdGo.do" name="checkIdFrm">
                	<input type="hidden" name="checkId">
                </form>

                <form action="/joingo.do" method="post" enctype="multipart/form-data">
                    <div class="img-ab">
                        <ul class="id-ul">
                            <li class="id">
                                    <div class="id-wrap">
                                        
                                        <div class="idTitle"><label for="id">아이디<span>*</span></label></div>
                                        <div class="idValue">
                                            <div class="possibleId"></div>
                                            <input class="w3-input w3-border w3-round-large" type="text" name="id" id="id">
                                        </div>

                                        <div class="idcheck">
                                            <button type="button" class="btn_radius bc22" onclick="idCheck();">중복체크</button>
                                        </div>
                                    </div>
                            </li>

                            <li class="purpose">
                                <div class="id-wrap">
                                    <div class="idTitle"><label>가입목적<span>*</span></label></div>
                                    <div class="idValue">
                                        <select class="form-select" aria-label="Default select example" id="member-level" name="memberLevel">
                                            <option value="0">선택</option>
                                            <option value="3">일반사용자</option>
                                            <option value="2">의사</option>
                                        </select>
                                    </div>

                                    <label for="upfile">사진등록</label>
                                    <input type="file" accept=".jpg, .png, .jpeg" name="upfilePhoto" id="upfile" accept="" style="display: none;" onchange="imgLoad(this);">
                                </div>
                            </li>

                            <li class="purpose1" style="display: none;">
                                <div class="id-wrap">
                                    <div class="idTitle"><label>가입분류<span>*</span></label></div>
                                    <div class="idValue">
                                        <select class="form-select" aria-label="Default select example" id="doc-major" name="docMajor">
                                            <option value="선택">선택</option>
                                            <option value="내과">내과</option>
                                            <option value="외과">외과</option>
                                            <option value="비뇨기과">비뇨기과</option>
                                            <option value="산부인과">산부인과</option>
                                            <option value="신경외과">신경외과</option>
                                            <option value="안과">안과</option>
                                            <option value="이비인후과">이비인후과</option>
                                            <option value="정신건강의학과">정신건강의학과</option>
                                            <option value="정형외과">정형외과</option>
                                            <option value="치의학">치의학</option>
                                            <option value="비뇨기과">비뇨기과</option>
                                            <option value="피부과">피부과</option>
                                        </select>
                                    </div>
                                </div>
                            </li>

                            <li class="passwordSector">

                                <div class="passwordFlex">
                                    <div class="password-wrap">
                                        <div class="idTitle"><label>비밀번호<span>*</span></label></div>

                                        <div class="passwordValue">
                                            <div class="passwordReg"></div>
                                            <input class="w3-input w3-border w3-round-large" type="password" name="pw" id="pw">
                                        </div>
                                    </div>

                                    <div class="passwordcheck-wrap">
                                        <div class="idTitle"><label>비밀번호 확인<span>*</span></label></div>
                                    
                                        <div class="passwordValue">
                                            <div class="passwordChkReg"></div>
                                            <input class="w3-input w3-border w3-round-large" type="password" name="pwre" id="pwre">
                                        </div>
                                    </div>
                                </div>
                            </li>

                            <li class="namePart">
                                <div class="name-wrap">
                                    <div class="idTitle"><label>이름<span>*</span></label></div>
                                    
                                    <div class="nameValue">
                                        <div class="nameReg"></div>
                                        <input class="w3-input w3-border w3-round-large" type="text" name="name" id="name">
                                    </div>
                                </div>
                            </li>

                            <li class="postPart">
                                <div class="post-wrap">
                                    <div class="idTitle"><label>생년월일<span>*</span></label></div>

                                    <div class="postValue">
                                        <div class="inputPost">
                                            <input class="w3-input w3-border w3-round-large" type="text" name="post" id="post" placeholder="yymmdd">
                                            
                                            <span id="postReg" style="margin-left: 30px; margin-top: 27px;"></span>

                                        </div>
                                    </div>
                                </div>
                            </li>

                            <li class="emailPart">
                                <div class="email-wrap">
                                    <div class="emailTitle"><label>이메일<span>*</span></label></div>

                                    <div class="email-content">
                                        <div class="authEmail">
                                            <div class="inputEmail">
                                                <div class="emailReg"></div>
                                                <input class="w3-input w3-border w3-round-large" type="text" name="email" id="email">
                                            </div>

                                            <div class="authBtn1">
                                                <button type="button" class="btn_radius bc22" onclick="sendMail()">인증번호 받기</button>
                                            </div>
                                        </div>

                                        <div class="authEmail" id="getEmail">
                                            <div class="inputEmail">
                                                
                                                <input class="w3-input w3-border w3-round-large" type="text" name="emailAu" id="emailAu" style="width: 200px;">
                                                <div class="emailText">
                                                	<span id="timeZone"></span>
         											<span id="authMsg"></span>
                                            	</div>
                                            </div>

                                            <div class="authBtn1">
                                                <button type="button" class="btn_radius bc22" id="authGo">인증하기</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>

                            <li class="phonePart">
                                <div class="phone-wrap">
                                    <div class="idTitle"><label>전화번호<span>*</span></label></div>
                                
                                    <div class="phoneValue">
                                        <div class="phoneReg"></div>
                                        <input class="w3-input w3-border w3-round-large" type="text" name="phone" id="phone" placeholder="'-'없이 작성해주세요">
                                    </div>
                                </div>
                            </li>

                            

                            <li class="addrDetailPart">
                                <div class="addr-wrap">
                                    <div class="idTitle"><label>주소</label><span style="color:red;">*</span></div>

                                    <div class="addrValue">
                                        <input class="w3-input w3-border w3-round-large" type="text" name="addr" id="addr" placeholder="주소를 입력하세요.">
                                    </div>
                                </div>
                            </li>

                            <li class="filePart" style="display: none;">
                                <div class="file-wrap">
                                    <div class="idTitle"><label>의사 등록증</label></div>

                                    <div class="fileValue">
                                        
                                        <input type="file" name="upfile" id="upfile">
                                        
                                    </div>
                                </div>
                            </li>
                            
                            <li class="hospitalNamePart" style="display: none;">
                                <div class="addr-wrap">
                                    <div class="idTitle"><label>병원이름</label><span style="color: red;">*</span></div>

                                    <div class="addrValue">
                                        <input class="w3-input w3-border w3-round-large" type="text" name="hospitalName" id="addr" placeholder="병원이름을 입력하세요.">
                                    </div>
                                </div>
                            </li>
                            
                            <li class="hospitalAddrPart" style="display: none;">
                                <div class="addr-wrap">
                                    <div class="idTitle"><label>병원주소</label><span style="color: red;">*</span></div>

                                    <div class="addrValue">
                                        <input class="w3-input w3-border w3-round-large" type="text" name="hospitalAddr" id="addr" placeholder="병원주소를 입력하세요.">
                                    </div>
                                </div>
                            </li>

                            <li class="nextBtn">
                                <div class="btn">
                                    <button type="submit" id="next">회원가입 신청</button>
                                </div>
                            </li>
                        </ul>
                        <div class="img-viewer">
                            <div class="img-view">
                                <img id="img-view" style="width: 140px; height: 165px; background-color: white;">
                            </div>
                            
                        </div>
                    </div>
                    
                </form>
            </div>

            <div class="welcome" style="display: none;">
                <div class="welcome-title">
                    <h1>환영합니다!</h1>
                </div>

                <div class="welcome-img">
                    <img src="img/welcome.png" alt="">
                </div>

                <div class="log-go">
                    <button type="button" id="loginGo">로그인하기</button>
                </div>
            </div>
        </div>
    </div>

    <script>
    
    	let mailCode;
    	let auMail;
    	function sendMail(){
    		
    		const email = $("#email").val();
    		if(email != ""){
    			$.ajax({
        			url : "/sendmail.do",
        			type : "post",
        			data : {email : email},
        			success : function(data){
        				mailCode = data;
        				console.log(mailCode);
        				authTime();
        			}
        		});
    		}else{
    			alert("이메일을 입력하세요!");
    		}
    		
    		
    	}
    	
    	let intervalId;
    	function authTime(){
    		$("#timeZone").html("<span id='min'>3</span> : <span id='sec'>00</span>")
    		intervalId = window.setInterval(function(){
    			timeCount();
    		}, 1000);
    	}
    	
    	function timeCount(){
    		const min = Number($("#min").text());
    		const sec = $("#sec").text();
    		
    		if(sec == "00"){
    			if(min == 0){
    				mailCode = null;
    				clearInterval(intervalId);
    			}else{
    				$("#min").text(min-1);
    				$("#sec").text(59);
    			}
    		}else{
    			const newSec = Number(sec)-1
    			if(newSec < 10){
    				$("#sec").text("0" + newSec);
    			}else{
    				$("#sec").text(newSec);
    			}
    		}
    	}
    	
    	$("#authGo").on("click", function(){
    		const emailAu = $("#emailAu").val();
    		
    		if(mailCode != null){
    			if(emailAu == mailCode){
        			$("#timeZone").css("display", "none");
        			$("#authMsg").text("인증완료");
        			$("#authMsg").css("color", "blue");
        			clearInterval(intervalId);
        			auMail = true;
        		}else{
        			$("#authMsg").text("인증실패");
        			$("#authMsg").css("color", "red");
        			auMail = false;
        		}
    		}else{
    			$("#authMsg").text("인증시간 만료");
    			$("#authMsg").css("color", "red");
    		}
    	})
    	
    
    	function imgLoad(f){
    		console.log(f.files);
    		if(f.files.length != 0 && f.files[0] != 0){
    			const reader = new FileReader();
    			reader.readAsDataURL(f.files[0]);
    			
    			reader.onload = function(e){
    				$("#img-view").attr("src", e.target.result);
    			}
    		}else{
    			$("#img-view").attr("src", "");
    		}
    	}
    
    	function cancleBtn(){
    		location.href="/";
    	}

        $("#member-level").on("change", function(){
            if($(this).val() == 2){
                console.log("test");
                $(".filePart").slideDown();
                $(".purpose1").slideDown();
                $(".hospitalNamePart").slideDown();
                $(".hospitalAddrPart").slideDown();
            }else{
                $(".filePart").slideUp();
                $(".purpose1").slideUp();
                $(".hospitalNamePart").slideUp();
                $(".hospitalAddrPart").slideUp();
            }
        })

        let idStatus;
        let pwStatus;
        let pwchkStatus;
        let nameStatus;
        let phoneStatus;
        let emailStatus;
        let postStatus;
        
        
        const postReg = $("#postReg");
        $("#post").on("keyup", function(){
        	const postReg1 = /^[0-9]{6}$/;
        	
        	const postVal1 = $("#post").val();
        	
        	if(postReg1.test(postVal1)){
        		postReg.text("알맞은 생년월일입니다.");
        		postReg.css("color", "blue");
        		postStatus = true;
        	}else{
        		postReg.text("알맞지 않은 생년월일입니다.");
        		postReg.css("color", "red");
        		postStatus = false;
        	}
        })

        const emailReg = $(".emailReg");
        $("#email").on("keyup", function(){
            const emailChkReg = /^[a-zA-Z0-9]{8,12}@/;
            const emailVal = $("#email").val();

            if(emailChkReg.test(emailVal)){
                emailReg.text("");
                emailStatus = true;
            }else{
                emailReg.text("알맞지 않은 이메일형식입니다.");
                emailReg.css("color", "red");
                emailStatus = false;
            }
        })

        const phoneReg = $(".phoneReg");
        $("#phone").on("keyup", function(){
            const phoneRegChk = /^[0-9]{10,11}$/;
            const phoneVal = $("#phone").val();

            if(phoneRegChk.test(phoneVal)){
                phoneReg.text("")
                phoneStatus = true;
            }else{
                phoneReg.text("알맞지 않은 전화번호입니다.");
                phoneReg.css("color", "red");
                phoneStatus = false;
            }
        })

        const nameReg = $(".nameReg");
        $("#name").on("keyup", function(){
            const nameRegChk = /^[가-힣]{2,5}$/;
            const nameVal = $("#name").val();

            if(!nameRegChk.test(nameVal)){
                nameReg.text("알맞지 않은 이름입니다.");
                nameReg.css("color", "red");
                nameStatus = false;
            } else{
                nameReg.text("");
                nameStatus = true;
            }
        })

        const pwreChk = $(".passwordChkReg");
        $("#pwre").on("keyup", function(){
            const pwreVal = $("#pwre").val();
            const pwVal = $("#pw").val();

            if(pwreVal == pwVal){
                pwreChk.text("비밀번호가 일치합니다.");
                pwreChk.css("color", "blue");
                pwchkStatus = true;
            }else{
                pwreChk.text("비밀번호가 일치하지않습니다.");
                pwreChk.css("color", "red");
                pwchkStatus = false;
            }
        })

        const pwChk = $(".passwordReg");
        $("#pw").on("keyup", function(){
            const pwReg = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{8,20}$/;
            const pwVal = $("#pw").val();
            const pwreVal = $("#pwre").val();

            if(pwReg.test(pwVal)){
                pwChk.text("알맞은 비밀번호입니다.");
                pwChk.css("color", "blue");
                pwStatus = true;
            }else{
                pwChk.text("알맞지 않은 비밀번호입니다.");
                pwChk.css("color", "red");
                pwStatus = false;
            }
            
            if(pwreVal == pwVal){
                pwreChk.text("비밀번호가 일치합니다.");
                pwreChk.css("color", "blue");
                
            }else{
                pwreChk.text("비밀번호가 일치하지않습니다.");
                pwreChk.css("color", "red");
                
            }
        })

        const possibleId = $(".possibleId");
        $("#id").on("keyup", function(){
            const idReg = /^(?=.*[a-zA-Z])(?=.*[0-9]).{5,10}$/;
            const idVal = $("#id").val();

            if(idReg.test(idVal)){
                possibleId.text("알맞은 아이디입니다.");
                possibleId.css("color", "blue");
                idStatus = true;
                
            }else{
                possibleId.text("영어 대/소문자와 숫자를 포함하십시오.");
                possibleId.css("color", "red");
                idStatus = false;
            }
        });
        
        
        function idCheck(){
            const id = $("#id").val();
            	
            if(id == ""){
            	alert("아이디를 입력하세요");
            	return;
            }
            
            if(idStatus){
            	$("input[name=checkId]").val(id); // hidden으로 숨겨놓음
                const popup = window.open("", "checkId", "left=700px, top=300px, width=500px, height=400px,menubar=no,scrollbars=yes");
                	
                $("[name=checkIdFrm]").attr("target", "checkId");
                $("[name=checkIdFrm]").submit();
            }
            
         }
        

        $("#next").on("click", function(){
        	const emailAu = $("#emailAu").val();
        	
            if($("#member-level").val() == 0){
            	alert("가입목적을 확인하세요")
            	$("#next").attr("type", "button");
            }else if($("#member-level").val() == 1){
            	if(!idStatus || !pwStatus || !pwchkStatus || !nameStatus || !phoneStatus || !emailStatus || !postStatus){
            		alert("입력값을 확인하세요!")
            		$("#next").attr("type", "button");
            	}else if(emailAu != mailCode){
            		alert("인증번호가 맞지 않습니다.");
            		$("#next").attr("type", "button");
            	}else if($("input[name=upfilePhoto]").val() == ""){
            		alert("프로필사진을 확인해주세요!");
            		$("#next").attr("type", "button");
            	}else{
            		$("#next").attr("type", "submit");
            	}
            }else if($("#member-level").val() == 2){
            	if(!idStatus || !pwStatus || !pwchkStatus || !nameStatus || !phoneStatus || !emailStatus || !postStatus){
            		alert("입력값을 확인하세요!")
            		$("#next").attr("type", "button");
            	}else if(emailAu != mailCode){
            		alert("인증번호가 맞지 않습니다.");
            		$("#next").attr("type", "button");
            	}else if($("input[name=upfilePhoto]").val() == ""){
            		alert("프로필사진을 확인해주세요!");
            		$("#next").attr("type", "button");
            	}else if($("#doc-major").val() == "선택"){
            		alert("진료과목을 선택해주세요");
            		$("#next").attr("type", "button");
            	}else if($("input[name=upfile]").val() == ""){
            		alert("의사등록증을 확인해주세요!");
            		$("#next").attr("type", "button");
            	}else{
            		$("#next").attr("type", "submit");
            	}
            }

        })

        const nextBtn = $("#nextBtn");
        nextBtn.on("click", function(){
            const allCheck = $(".allAgree>input[name=allAgree]");
            const allCheckValue = allCheck.prop("checked");
            const joinAgree = $("#joinAgree-title").prop("checked");
            const personalAgree = $("#personalAgree").prop("checked");
            const personalHandling = $("#personalHandling").prop("checked");

            if(joinAgree && personalAgree && personalHandling){
                $(".join-real-content").css("display", "none");
                $(".class-info").css("display", "block");
            }else{
                alert("모든 약관에 동의해주세요")
            }

        });

        const check1 = $(".allAgree>label>span");
        check1.on("click", function(){
            const inputCheck = $(".allAgree>input[name=allAgree]");
            const inputVal = inputCheck.prop("checked");
            console.log(inputVal);
            if(!inputVal){
                $(this).css("color", "rgb(16, 203, 156)");
                $("#joinAgree-title").prop("checked", true);
                $(".joinAgree-title>label>span").css("color", "rgb(16, 203, 156)");
                $("#personalAgree").prop("checked", true);
                $(".personalProtect>label>span").css("color", "rgb(16, 203, 156)");
                $("#personalHandling").prop("checked", true);
                $(".personalHandling>label>span").css("color", "rgb(16, 203, 156)");
            }else{
                $(this).css("color", "black");
                $("#joinAgree-title").prop("checked", false);
                $(".joinAgree-title>label>span").css("color", "black");
                $("#personalAgree").prop("checked", false);
                $(".personalProtect>label>span").css("color", "black");
                $("#personalHandling").prop("checked", false);
                $(".personalHandling>label>span").css("color", "black");
            }
        });

        const check2 = $(".joinAgree-title>label>span");
        check2.on("click", function(){
            const inputCheck = $(".joinAgree-title>input[name=joinAgree-title");
            const inputVal = inputCheck.prop("checked");
            console.log(inputVal);
            if(!inputVal){
                $(this).css("color", "rgb(16, 203, 156)");
            }else{
                $(this).css("color", "black");
            }
        });

        const joinDetailBtn = $("#joinDetailBtn");
        joinDetailBtn.on("click", function(){
            $(".joinDetail").toggle();
        });

        const check3 = $(".personalProtect>label>span");
        check3.on("click", function(){
            const inputCheck = $(".personalProtect>input[name=personalAgree]");
            const inputVal = inputCheck.prop("checked");
            console.log(inputVal);
            if(!inputVal){
                $(this).css("color", "rgb(16, 203, 156)");
            }else{
                $(this).css("color", "black");
            }
        });

        const personalDetailBtn = $("#personalDetail");
        personalDetailBtn.on("click", function(){
            $(".personalDetail").toggle();
        });

        const check4 = $(".personalHandling>label>span");
        check4.on("click", function(){
            const inputCheck = $(".personalHandling>input[name=personalHandling]");
            const inputVal = inputCheck.prop("checked");
            console.log(inputVal);
            if(!inputVal){
                $(this).css("color", "rgb(16, 203, 156)");
            }else{
                $(this).css("color", "black");
            }
        });

        const HandlingBtn = $("#HandlingBtn");
        HandlingBtn.on("click", function(){
            $(".handlingDetail").toggle();
        });

    </script>
</body>
</html>