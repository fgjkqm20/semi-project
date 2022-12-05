<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/nearDocJoin.css">
    <link rel="stylesheet" href="css/welcome.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="stylesheet" href="css/default.css">
<script
  src="https://code.jquery.com/jquery-3.6.1.js"
  integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
  crossorigin="anonymous"></script>
  <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<style>
    .welcome-content{
    width: 800px;
    margin: 0 auto;
    margin-top: 100px;
    margin-bottom: 100px;
    border: 2px solid lightgray;
    border-radius: 20px;
}

#mainGo{
    background-color: lightgray;
}
</style>
</head>
<body>

    <div class="welcome-content">
        <div class="join-title">
            <h1>nearByDoc<span>비대면진료</span></h1>
        </div>
        <div class="welcome">
            <div class="welcome-title">
                <h1>환영합니다!</h1>
            </div>

            <div class="welcome-img">
                <img src="img/welcome.png" alt="">
            </div>

            <div class="log-go">
                <button type="button" id="mainGo" onclick="goMain()">메인페이지</button>
                <button type="button" id="loginGo" onclick="goLogin()">로그인하기</button>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    	function goMain() {
			location.href = "/";
		}
    	
    	function goLogin(){
    		location.href = "/loginFrm.do";
    	}
    </script>
    
</body>
</html>

















