<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>modang 관리자페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/index.css" />
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.js"></script>
	</head>
	<body>
		<div id="page-wrapper">

			<!-- Header -->
			<section id="header">
				<div class="container">
					<div class="row">
						<div class="col-12">

							<!-- Logo -->
							<h1><a href="index.html" id="logo"><img src="${pageContext.request.contextPath}/image/modang.png" /></a></h1>

							<!-- Nav -->
							<nav id="nav">
								<a href="index.html">테이블현황</a>
								<a href="tablesales.html">테이블 매출</a>
								<a href="daysales.html">일별 매출</a>
								<a href="pricePolicy.html">요금 테이블</a>
								<a href="settings.html">관리자 설정</a>
							</nav>
						</div>
					</div>
				</div>
			</section>

			<!-- Content -->
			<section id="content">
				<div class="container">
					<div class="row aln-center">

						<!-- Table -->
						<div class="col-12">
							<section>
								<header>
									<h2>시간제 요금 설정</h2>
								</header>
								<body>
								
									<div class="col-4">
									
									<form>
										  <div class="form-group">
										    <label for="exampleInputEmail1">대대 요금</label>
										    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="10분당 요금을 입력하세요">
										  </div>
										  <div class="form-group">
										    <label for="exampleInputPassword1">대대 최소 게임비</label>
										    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="30분 최소요금을 입력하세요">
										  </div>
									</form>
									</div>
									<div class="col-4">
									<form>
										  <div class="form-group">
										    <label for="exampleInputEmail1">중대 요금</label>
										    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="10분당 요금을 입력하세요">
										  </div>
										  <div class="form-group">
										    <label for="exampleInputPassword1">중대 최소 게임비</label>
										    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="30분 최소요금을 입력하세요">
										  </div>
									</form>
									</div>
									<div class="col-4">
									<form>
										  <div class="form-group">
										    <label for="exampleInputEmail1">포켓 요금</label>
										    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="10분당 요금을 입력하세요">
										  </div>
										  <div class="form-group">
										    <label for="exampleInputPassword1">포켓 최소 게임비</label>
										    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="30분 최소요금을 입력하세요">
										  </div>
									</form>
									</div>
									<button type="button" class="btn btn-primary">Primary</button>
								</body>
							</section>
						</div>
						
					</div>
				</div>
			</section>

			<!-- Copyright -->
			<div id="copyright">&copy; modang. All rights reserved.</div>

		</div>
	</body>
</html>