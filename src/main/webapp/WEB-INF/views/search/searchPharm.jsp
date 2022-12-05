<%@page import="nbd.member.model.vo.Member"%>
<%@page import="nbd.search.model.vo.Search"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%
	ArrayList<Search> list = (ArrayList<Search>)request.getAttribute("list");
	%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>약국지정</title>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=lq3i94vo17"></script>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=b00v5gh0y0&submodules=geocoder"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="css/common/default.css">
    <link rel="stylesheet" href="/css/PharmacySelect.css">
    <link rel="stylesheet" href="css/common/header.css">
    <link rel="stylesheet" href="css/common/footer.css">
</head>

<style>
	
</style>
<body>

<%@include file="/WEB-INF/views/common/header.jsp" %>

    <div class="page-content">
        <div class="PStop">
            <span>───────────────────────────────────────────────────────────────────────────</span>
            <br>
            <span class="PStoptitle">약국지정</span>
            <br>
            <span>───────────────────────────────────────────────────────────────────────────</span>
        </div>
        
        <div class="PSmap">
        	<div id="map" style="width:600px;height:450px; margin:50px"></div>
        </div>
        
        <div class="PSoption">
        	<input type="text" id="inpAddr" placeholder=" 주소입력 ex)ㅇㅇ로 / ㅇㅇ동 / ㅇㅇ구" style="width:400px;" >
       		<button type="button" class="btn bc1" id="searchPharmBtn" style="width:200px; margin:0; height:55px;">입력한 주소로 약국찾기</button>
    	</div>
    	<div class="PSoption">
       		<span class="input-form PSmidsearchResult"></span> 
            <button onclick="showPharm();" class="btn bc1 movMap">검색한 약국 위치 보기</button>
        </div> 
        
        <div class="PSmiddle">
            
        </div>
        
        <div class="inpTbl tbl" id="newTbl"></div>


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
    <script>
    
    const map = new naver.maps.Map("map",{
        center : new naver.maps.LatLng(37.533837,126.896836),      //처음위치를 찍어준다(위도/경도)
        zoom :17,
        zoomControl : true,
        zoomControlOptions :{
           position : naver.maps.Position.TOP_RIGHT,
           style :naver.maps.ZoomControlStyle.SMALL
        }
     });

    const marker = new naver.maps.Marker({
        position : new naver.maps.LatLng(37.533837,126.896836),
        map : map
     });

    
    let infoWindow = new naver.maps.InfoWindow();
    //마커에 클릭이벤트 추가
    naver.maps.Event.addListener(marker,"click",function(e){
       infoWindow = new naver.maps.InfoWindow({
          content : contentString
       });
       //생성된 infoWindow를 map의 marker위치에 생성
       infoWindow.open(map,marker);
    });

    
    
    //지도에 클릭이벤트 추가
    naver.maps.Event.addListener(map,"click", function(e){
       marker.setPosition(e.coord);   //해당위치로 마커이동
       if(infoWindow.getMap()){   //정보창이 지도위에 올라가있으면
          infoWindow.close();
       }
       //위경도를 통해서 해당위치의 주소를 받아낸다.
       naver.maps.Service.reverseGeocode({
          location:new naver.maps.LatLng(e.coord.lat(),e.coord.lng())
       },function(status,response){
             if(status!=naver.maps.Service.Status.OK){
                return alert("주소를 찾을 수 없습니다.")
             }
             console.log(response);
             const address = response.result.items[1].address;
             console.log(address);
             contentString = [
                "<div class='iw_inner'>",
                "   <p>"+address+"</p>",
                "</div>"
             ].join("");
          });
       });

    function searchAddr(){
        new daum.Postcode({
               oncomplete: function(data) {
                   // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
                   // 예제를 참고하여 다양한 활용법을 확인해 보세요.
                   console.log(data);
                   $("#address").val(data.roadAddress);		// 주소입력되는부분
                   $("#detailAddress").focus();
               }
           }).open();
    }
    
    function showMap(){
        const addr = $("#address").val();
        naver.maps.Service.geocode({address:addr}, function(status,response){
           if(status === naver.maps.Service.Status.ERROR){
              return alert("조회에러");
           }
           console.log(response);
           const lng = response.result.items[1].point.x;   //경도
           const lat = response.result.items[1].point.y;   //위도
           
           console.log(lng);
           console.log(lat);
           //지도에서 사용할 위경도 위치 객체
           const latlng = new naver.maps.LatLng(lat,lng);      
           map.setCenter(latlng);   //지도 중심 이동
           marker.setPosition(latlng);   //마커위치이동
           
        });
     }
    
    function showPharm(){
        const addr = $(".PSmidsearchResult").text();
        
        naver.maps.Service.geocode({address:addr}, function(status,response){
           if(status === naver.maps.Service.Status.ERROR){
              return alert("조회에러");
           }
           console.log(response);
           const lng = response.result.items[1].point.x;   //경도
           const lat = response.result.items[1].point.y;   //위도
           
           console.log(lng);
           console.log(lat);
           //지도에서 사용할 위경도 위치 객체
           const latlng = new naver.maps.LatLng(lat,lng);      
           map.setCenter(latlng);   //지도 중심 이동
           marker.setPosition(latlng);   //마커위치이동
           
        });

     }

	</script>
	<script src="js/PharmacySelect.js"></script>
	<script src="js/common/header.js"></script>
	<script src="/js/common/footer.js"></script>
</footer>
</html>