<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/assets/css/main.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<meta name="viewport" content="width=device-width" , initial-scale="1.0">
  		<link rel='stylesheet' href='${pageContext.request.contextPath}/assets/css/default.css'>

</head>

<body>
    <div id="wrap">
        <div class="header">
            <div id="logo">
                <img src="${pageContext.request.contextPath}/assets/image/modang2.png" width="250">
            </div>
            <div id="login">
                <ul>
                    <li><button type="button" class="btn btn-primary">로그인</button></li>
                    <li><button type="button" class="btn btn-primary">모두의 당구장</button></li>
                </ul>
            </div>

            <div id="nav">
                <div id="menu">테이블 현황</div>
                <div id="menu">테이블 매출</div>
                <div id="menu">일별 매출</div>
                <div id="menu">요금 테이블</div>
                <div id="menu">관리자 설정</div>
            </div>
        </div>
        <div class="content">
            <div class="row">
                <div class="border">
                    <p>시간제 요금 설정 - 10분당 기본요금과 최소 게임비(30분)을 설정하세요</p>
          	  		<div class="col-1">
          	  			<form>
							  <div class="form-group">
							    <label for="exampleInputEmail1">대대 요금</label>
							    <input type="text" class="form-control" id="exampleInputEmail1">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputPassword1">대대 최소 게임비</label>
							    <input type="text" class="form-control" id="exampleInputPassword1">
							  </div>
						 </form>
          	  		</div>
          	  		<div class="col-1">
          	  		    <form>
							  <div class="form-group">
							    <label for="exampleInputEmail1">중대 요금</label>
							    <input type="text" class="form-control" id="exampleInputEmail1" >
							  </div>
							  <div class="form-group">
							    <label for="exampleInputPassword1">중대 최소 게임비</label>
							    <input type="text" class="form-control" id="exampleInputPassword1">
							  </div>
						 </form>
          	  		</div>
          	  		<div class="col-1">
          	  		     <form>
							  <div class="form-group">
							    <label for="exampleInputEmail1">포켓 요금</label>
							    <input type="text" class="form-control" id="exampleInputEmail1">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputPassword1">포켓 최소 게임비</label>
							    <input type="text" class="form-control" id="exampleInputPassword1">
							  </div>
						 </form>
          	  		</div>
          	  		<div class="col-2">
          	  			<button type="button" class="btn btn-primary btn-lg">저 장</button>
          	  		</div>
				</div>
			</div>
        </div>
    </div>

</body>

</html>