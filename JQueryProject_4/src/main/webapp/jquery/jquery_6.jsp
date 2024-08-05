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
	$('input[type="button"]').click(function(){
		let msg='<h3>Hello jQuery</h3>'
		$('#print').append(msg) // innerHTML
		// text() => textContent => html 번역이 안됨 => 외부에서 데이터를 가지고 온다
	})
})
</script>
</head>
<body>
	<input type="button" value="클릭">
	<p>
		<span id="print"></span>
	</p>
</body>
</html>