<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.box{
	width:200px;
	height:200px;
	border:1px solid black;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
// window.onload=function(){} : (과거)
$(function(){ // : (현재)
	$('.box').on('mousedown',function(){ // 1 => 1과 2는 동일식
		$(this).css("background","pink")
	})
	$('.box').mouseup(function(){ // 2 => 1과 2는 동일식
		$(this).css("background","cyan")
	})
})
</script>
</head>
<body>
	<div class="box"></div>
	<div class="box"></div>
	<div class="box"></div>
	<div class="box"></div>
	<div class="box"></div>
	<div class="box"></div>
	<div class="box"></div>
	<div class="box"></div>
	<div class="box"></div>
	<div class="box"></div>
	<div class="box"></div>
</body>
</html>