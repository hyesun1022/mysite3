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
        	<div class="row-2"></div>
        		<div class="row-3">사업자 정보</div>
				<div class="row-3">매장 정보</div>
           		<div class="row-1">
           			<div class="col-4">text
           				<form class="form-inline">
						  <div class="form-group">
						    <label for="exampleInputName2">아 이 디</label>
						    <input class="form-control" id="disabledInput" type="text" disabled>
						  </div>
						  <p>
						  <div class="form-group">
						    <label for="exampleInputEmail2">패스워드</label>
						    <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
						  </div>
						  <p>
						  <button type="submit" class="btn btn-default">Send invitation</button>
						</form>
           			</div>
           			<div class="col-5">text</div>
				</div>
        </div>
    </div>

</body>

</html>