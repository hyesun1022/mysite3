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
							<h1><a href="index.html" id="logo"><img src="${pageContext.request.contextPath}/assets/image/modang.png" width=200 /></a></h1>

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
						<div class="col-6">
							<section>
								<header>
									<h2>사업자 정보</h2>
								</header>
								<div class="col-4">
									<form>
										<div class="form-group">
											<label for="exampleInputEmail1">아이디</label>
											<input type="text" class="form-control" id="exampleInputEmail1">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">패스워드</label>
											<input type="password" class="form-control" id="exampleInputPassword1">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">대표자명</label>
											<input type="text" class="form-control" id="exampleInputPassword1">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">상호명</label>
											<input type="text" class="form-control" id="exampleInputPassword1">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">사업자번호</label>
											<input type="text" class="form-control" id="exampleInputPassword1">
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1">매장전화번호</label>
											<input type="text" class="form-control" id="exampleInputPassword1">
										</div>
									</form>
								</div>
							</section>

						</div>
						<div class="col-6">
							<section>
								<header>
									<h2>매장 정보</h2>
								</header>
								<div class="col-4">
									<form>
										<div class="form-group">
											<label for="exampleInputEmail1">아이디</label>
											<button type="button" class="btn btn-primary">사진추가</button>
											<button type="button" class="btn btn-primary">사진삭제</button>
										</div>
										<div class="form-group">
											<img src="${pageContext.request.contextPath}/assets/image/modang.png" alt="" class="img-thumbnail" width=170>
											<img src="${pageContext.request.contextPath}/assets/image/modang.png" alt="" class="img-thumbnail" width=170>
											<img src="${pageContext.request.contextPath}/assets/image/modang.png" alt="" class="img-thumbnail" width=170>										
										</div>
										<div class="form-group">
										    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
										    <div class="col-sm-10">
										      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
										      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
										    </div>
										 </div>

									</form>
								</div>
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