<%@page import="nbd.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="/template/lumino/css/bootstrap.min.css" rel="stylesheet">
	<link href="/template/lumino/css/font-awesome.min.css" rel="stylesheet">
	<link href="/template/lumino/css/datepicker3.css" rel="stylesheet">
	<link href="/template/lumino/css/styles.css" rel="stylesheet">
	<link rel="stylesheet" href="/css/member/adminChangeMember.css">
<title>memberManager</title>
</head>
<style>
	.table{
		text-align: center;
	}
	
</style>
<body>
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation" style="background-color:#10CB9C;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
				<a href="/">
				<img src="/img/common/로고2.png"
				width="180px" height="60px">
				</a>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
	
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
				<img src="/img/기본프로필_보라.jpg" class="img-responsive" alt="">
			</div>
			<div class="profile-usertitle">
				<div class="profile-usertitle-name">관리자</div>
			</div>
			<div class="clear"></div>
		</div>
		
		<div class="divider"></div>
		<ul class="nav menu">
			<li><a href="/mypage.do?memberGrade=1"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
			<li class="active"><a href="/updateMemberPage.do"><em class="fa fa-navicon">&nbsp;</em> 회원관리</a></li>
		</ul>
	</div><!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">회원 관리</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">회원 관리</h1>
			</div>
		</div><!--/.row-->
		
		<div class="fixed-table-container">
			<table class="searchBar table">
	            <tr>
	                <td style="width: 200px;">
	                <select class="searchType">
	                	<option disabled selected>SEARCH</option>
	                	<option value="1">아이디으로 검색</option>
	                	<option value="2">등급으로 검색</option>
	                </select>
	                </td>
	                <td>
	                <input type="text" class="form-control searchIn" placeholder="직접입력">
	                </td>
	                <td style="width: 300px;">
	                <button type="button" class="btn btn-lg btn-info searchM" style="margin-left: 8px; ">검색</button>
	                <button type="button" class="btn btn-lg btn-info changeLev">수정</button>
	                </td>
	            </tr>
	        </table>
	        <table class="memberAdmin table">
	        	<thead>
	            <tr class="MAinfo">
	                <td class="MAcheckbox">선택</td>
	                <td class="MAmemberNo">회원번호</td>
	                <td class="MAmemberid">아이디</td>
	                <td class="MAmemberName">이름</td>
	                <td class="MAmemberage">나이</td>
	                <td class="MAmemberphone">전화번호</td>
	                <td class="MAmemberemail">이메일</td>
	                <td class="MAenrolldate">가입일</td>
	                <td class="MAmembergrade">등급변경</td>
	                <td class="MAmemberwarning">신고누적</td>
	                <td class="DocfilePath">의사등록증</td>
	            </tr>
	            </thead>
	            <tbody>
		            <% for(Member m : list ) { %>
		            	<tr class="memberss">
		                	<td><input type="checkbox" class="chk"></td>
			                <td class="memberNo"><%= m.getMemberNo() %></td>
			                <td><%= m.getMemberId() %></td>
			                <td><%= m.getMemberName() %></td>
			                <td><%= m.getMemberBirth() %></td>
			                <td><%= m.getMemberPhone() %></td>
			                <td><%= m.getMemberEmail() %></td>
			                <td><%= m.getEnrollDate() %></td>
			                <td class="selectBox">
			                    <%if(m.getMemberGrade()==1){ %>
			                    <select class="gradeSelect form-controll">
			                        <option selected class="MAoption" value="1">관리자</option>
			                        <option class="MAoption" value="2">의사</option>
			                        <option class="MAoption" value="3">회원</option>
			                    </select>
			                    <%}else if(m.getMemberGrade()==2) {%>
			                    <select class="gradeSelect form-controll">
			                    	<option class="MAoption" value="1">관리자</option>
			                        <option selected class="MAoption" value="2">의사</option>
			                        <option class="MAoption" value="3">회원</option>
			                    </select>
			                    <%}else if(m.getMemberGrade()==3) {%>
			                    <select class="gradeSelect form-controll">
			                    	<option class="MAoption" value="1">관리자</option>
			                        <option class="MAoption" value="2">의사</option>
			                        <option selected class="MAoption" value="3">회원</option>
			                    </select>
			                    <%} %>
			                </td>
			                <td><%= m.getMemberWarning() %></td>
			                <td><%=m.getDoctorFilePath() %></td>
		            	</tr>
		            <%} %>
	            </tbody>
	        </table>
	        <div class="update-member-Btn">
	            <!--<button class="btn btn-lg btn-success" style="margin: 0 auto; width: 300px;">변경하기</button>  -->
	        </div>
		</div>
	</div>	<!--/.main-->
	<script src="/template/lumino/js/jquery-1.11.1.min.js"></script>
	<script src="/template/lumino/js/bootstrap.min.js"></script>
	<script src="/template/lumino/js/chart.min.js"></script>
	<script src="/template/lumino/js/chart-data.js"></script>
	<script src="/template/lumino/js/easypiechart.js"></script>
	<script src="/template/lumino/js/easypiechart-data.js"></script>
	<script src="/template/lumino/js/bootstrap-datepicker.js"></script>
	<script src="/template/lumino/js/custom.js"></script>
	
	<script>
		window.onload = function () {
			var chart1 = document.getElementById("line-chart").getContext("2d");
			window.myLine = new Chart(chart1).Line(lineChartData, {
			responsive: true,
			scaleLineColor: "rgba(0,0,0,.2)",
			scaleGridLineColor: "rgba(0,0,0,.05)",
			scaleFontColor: "#c5c7cc"
			});
	};
	
	const changeLevel = $(".changeLev");
	changeLevel.on("click",function(){
		const check = $(".chk:checked");
		if(check.length==0){
			alert("값을 선택후 변경할 회원을 체크해주세요");
			return;
		}
		const num = new Array();
		const level = new Array();
		check.each(function(index,item){
			const memberNo = $(item).parent().next().text();
			num.push(memberNo);
			const memberLevel = $(item).parent().parent().find("select").val();
			level.push(memberLevel);
		});
		location.href="/checkedChangedLevel.do?num="+num.join("/")+"&level="+level.join("/");
	});
	
	
	//검색
	const searchMember = $(".searchM");
	searchMember.on("click",function(){
		const searchValue = $(".searchIn").val();
		const searchType = $(".searchType").val();
		if(searchType==1){
			//아이디으로 검색
			location.href="/AsearchMember.do?memberId="+searchValue;
		}else if(searchType==2){
			console.log(searchValue);
			
			if(searchValue =="관리자"){
				location.href="/BsearchMember.do?memberGrade=1";
			}else if(searchValue=="의사"){
				location.href="/BsearchMember.do?memberGrade=2";
			}else if(searchValue=="회원"){
				location.href="/BsearchMember.do?memberGrade=3";
			}else{
				alert("등급(관리자/회원/의사)을 정확히 입력해주세요");
			}
		}
	});
	
	</script>
</body>
</html>