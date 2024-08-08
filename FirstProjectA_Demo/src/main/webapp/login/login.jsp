<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h3>로그인 화면</h3>
	<div class="row">
    	<c:if test="${sessionScope.id==null }">
	      <ul class="inline">
	        <li><input type="text" id="id" class="input-sm" placeholder="아이디"></li>
	        <li><input type="password" id="pwd" class="input-sm" placeholder="비밀 번호"></li>
	        <li><input type="button" id="logBtn" class="btn-sm btn-danger" value="로그인"></li>
	      </ul>
    	</c:if>
    	<c:if test="${sessionScope.id!=null }">
	      <ul class="inline">
	      	<li>${sessionScope.name }(${sessionScope.admin=='y'?"관리자":"일반 사용자" })님 로그인되었습니다</li>
	        <li><input type="button" id="logoutBtn" class="btn-sm btn-success" value="로그아웃"></li>
	      </ul>
    	</c:if>
	</div>
</div>
</body>
</html>