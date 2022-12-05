<%@page import="nbd.member.model.vo.Member"%>
<%@page import="nbd.member.model.vo.AdminInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	AdminInfo ai = (AdminInfo)request.getAttribute("ai");
    	Member m = (Member)session.getAttribute("m");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="/template/lumino/css/bootstrap.min.css" rel="stylesheet">
	<link href="/template/lumino/css/font-awesome.min.css" rel="stylesheet">
	<link href="/template/lumino/css/datepicker3.css" rel="stylesheet">
	<link href="/template/lumino/css/styles.css" rel="stylesheet">
	<link rel="stylesheet" href="/css/common/default.css">
<title>admin</title>
</head>
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
				<div class="profile-usertitle-name"><%=m.getMemberName() %></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<ul class="nav menu">
			<li class="active"><a href="/mypage.do?memberGrade=1"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
			<li><a href="/updateMemberPage.do"><em class="fa fa-navicon">&nbsp;</em> 회원관리</a></li>
		</ul>
	</div><!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">admin page</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">admin page</h1>
			</div>
		</div><!--/.row-->
		
		
		<h5>today</h5>
		<div class="panel panel-container">
			<div class="row">
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-red panel-widget ">
						<div class="row no-padding"><em class="fa fa-xl fa-search color-red"></em>
							<div class="large"><%= ai.getTodayReservation() %></div>
							<div class="text-muted">Reservation</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-orange panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
							<div class="large"><%= ai.getTodayDoctor() %></div>
							<div class="text-muted">Doctor</div>
						</div>
					</div>
				</div>
								<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-orange panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-users color-blue"></em>
							<div class="large"><%= ai.getTodayMember() %></div>
							<div class="text-muted">Patient</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
					<div class="panel panel-blue panel-widget border-right">
						<div class="row no-padding"><em class="fa fa-xl fa-comments color-orange"></em>
							<div class="large"><%= ai.getTodayWrite() %></div>
							<div class="text-muted">article</div>
						</div>
					</div>
				</div>
			</div><!--/.row-->
		</div>
		
		<h5>today/total</h5>
		<div class="row">
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Reservation</h4>
						<div class="easypiechart" id="easypiechart-red" data-percent="<%= ai.getTotalReservation() %>" ><span class="percent"><%= ai.getTodayReservation()%> %</span></div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Doctor</h4>
						<div class="easypiechart" id="easypiechart-teal" data-percent="<%= ai.getTotalDoctor() %>" ><span class="percent"><%= ai.getTotalDoctor() %>%</span></div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Patient</h4>
						<div class="easypiechart" id="easypiechart-blue" data-percent="<%= ai.getTotalMember() %>" ><span class="percent"><%= ai.getTotalMember() %>%</span></div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>article</h4>
						<div class="easypiechart" id="easypiechart-orange" data-percent="<%= ai.getTotalWrite() %>" ><span class="percent"><%= ai.getTotalWrite() %>%</span></div>
					</div>
				</div>
			</div>
		</div><!--/.row-->
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
	
	$(function() {
        $('#easypiechart-red').easyPieChart({
            //your options goes here
        });
    });
	</script>
		
</body>
</html>