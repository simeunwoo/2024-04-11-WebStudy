<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	let h1=$('h1').text() // <h1>~<h6>, <button>, <td>, <th> ... getter
	$('h2').text(h1) // setter
	$('h3').html('<font color="blue">Hello jQuery</font>')
	/*
		text() : 문자 읽기, text(값) : 데이터 첨부 => 문자만 가능
		html() : 문자 => html을 읽어 온다, html(값)
		
		html() => ajax
		text()
	*/
})
</script>
</head>
<body>
	<h1>Hello jQuery</h1>
	<h2></h2>
</body>
</html>