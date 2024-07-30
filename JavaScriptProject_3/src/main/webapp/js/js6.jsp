<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	textContent : 문자만 설정
		document.body.textContent="<h1>Hello JavaScript</h1>"
		=> <h1>Hello JavaScript</h1>로 출력
		
	innerHTML : 태그를 포함하여 전송 가능
		document.body.innerHTML="<h1>Hello JavaScript</h1>"
		=> Hello JavaScript로 출력
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	document.body.innerHTML="<h1>Hello JavaScript</h1>"
	// $('body').html(), $('body').text()
}
</script>
</head>
<body>

</body>
</html>