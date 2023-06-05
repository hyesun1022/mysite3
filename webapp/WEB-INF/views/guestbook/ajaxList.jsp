<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
	
</head>

<body>
	<div id="wrap">
        <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->

		<div id="nav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/guestbook/addList">방명록</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="${pageContext.request.contextPath}/board/list">게시판</a></li>
				<li><a href="">입사지원서</a></li>
			</ul>
			<div class="clear"></div>
		</div>
		<!-- //nav -->

		<div id="aside">
			<h2>방명록</h2>
			<ul>
				<li>일반방명록</li>
				<li><a href="${pageContext.request.contextPath}/api/guestbook/addList">ajax방명록</a></li>
			</ul>
		</div>
		<!-- //aside -->

		<div id="content">
			
			<div id="content-head">
            	<h3>일반방명록</h3>
            	<div id="location">
            		<ul>
            			<li>홈</li>
            			<li>방명록</li>
            			<li class="last">일반방명록</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
            <!-- //content-head -->

			<div id="guestbook">
				<%-- <form action="${pageContext.request.contextPath}/api/guestbook/add" method="get"> --%>
					<table id="guestAdd">
						<colgroup>
							<col style="width: 70px;">
							<col>
							<col style="width: 70px;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label class="form-text" for="input-uname">이름</label></td>
								<td><input id="input-uname" type="text" name="name"></td>
								<th><label class="form-text" for="input-pass">패스워드</label></td>
								<td><input id="input-pass" type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
							</tr>
							<tr class="button-area">
								<td colspan="4"><button id="btnSubmit" type="submit">등록</button></td>
							</tr>
						</tbody>
						
					</table>
					<!-- //guestWrite -->
					<input type="hidden" name="action" value="add">
					
				<!-- </form>	 -->
				<div id="guestbookListArea">
					<c:forEach items="${guestList}" var="guestbookVo">
						<table class="guestRead">
							<colgroup>
								<col style="width: 10%;">
								<col style="width: 40%;">
								<col style="width: 40%;">
								<col style="width: 10%;">
							</colgroup>
							<tr>
								<td>${guestbookVo.no}</td>
								<td>${guestbookVo.name}</td>
								<td>${guestbookVo.regDate}</td>
								<td><a href="${pageContext.request.contextPath}/guestbook/deleteForm?no=${guestbookVo.no}">[삭제]</a></td>
							</tr>
							<tr>
								<td colspan=4 class="text-left">${guestbookVo.content}</td>
							</tr>
						</table>
					</c:forEach>
				</div>	
				<!-- //guestRead -->
				
			</div>
			<!-- //guestbook -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>
		
        <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

<script type="text/javascript">

//방명록 저장 버튼 클릭할때
$("#btnSubmit").on("click", function(){
	console.log("버튼클릭");
	
	//데이타 수집
	var name = $("[name='name']").val();
	var password = $("[name='password']").val();
	var content = $("[name='content']").val();
	
	var guestbookVo ={
	    name: name,
	    password: password,
	    content: content
	};
	
	//ajax통신 ->요청은 같은 기술 응답이 데이터만 온다
	$.ajax({
		
		url : "${pageContext.request.contextPath }/api/guestbook/add",		
		type : "post",
		//contentType : "application/json",
		data : guestbookVo,

		dataType : "json",
		success : function(jsonResult){
			/*성공시 처리해야될 코드 작성*/
			console.log(jsonResult);
			
			if(jsonResult.result == "success"){
				//정상처리
				console.log(jsonResult.data);
				console.log(jsonResult.data.name); //데이타 꺼내기
				
				var str ="";
				str += '<table class="guestRead">';
				str += '  <colgroup>';
				str += '	  <col style="width: 10%;">';
				str += '	  <col style="width: 40%;">';
				str += '	  <col style="width: 40%;">';
				str += '	  <col style="width: 10%;">';
				str += '  </colgroup>';
				
				str += '  <tr>';
				str += '      <td>' + jsonResult.data.no +'</td>';
				str += '      <td>' + jsonResult.data.name + '</td>';
				str += '      <td>' + jsonResult.data.regDate + '</td>';
				str += '      <td><a href="${pageContext.request.contextPath}/guestbook/deleteForm?no=${jsonResult.data.no}">[삭제]</a></td>';
				str += '  </tr>';

				str += '  <tr>';
				str += '      <td colspan=4 class="text-left">' + jsonResult.data.content + '</td>';
				str += '  </tr>';
				str += '</table>';
				
				$("#guestbookListArea").prepend(str);
				
			}else{
				//오류처리
			}

		},
		error : function(XHR, status, error) { 
			console.error(status + " : " + error);
		}
    });
});

</script>
</html>