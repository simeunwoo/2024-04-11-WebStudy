<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	Back : 기본 : Java / Python / C/C++
	       ===========================
	       Web : JSP
	       MVC : Spring(자바 기반) / Django(파이썬 기반)
	       DB : Oracle / MySQL / MariaDB
	       Mapper : MyBatis / JPA
	       
	Front : 기본 : JavaScript / TypeScript
	        =============================
	        Web : 라이브러리 사용
	        	=> jQuery(기본)(Ajax)
	        	=> VueJS / ReactJS
	        JSP / Spring / MyBatis / jQuery
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#aaa span').css("color","red")
	$('#bbb span').css("color","blue")
	$('#ccc span').css("color","green")
})
</script>
</head>
<body>
	<div id="aaa">
		<span>Hello</span>
	</div>
	<div id="bbb">
		<span>Hello</span>
	</div>
	<div id="ccc">
		<span>Hello</span>
	</div>
</body>
</html>