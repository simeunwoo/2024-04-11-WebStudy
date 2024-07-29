<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	이항 연산자
	= 산술 연산자 : +, -, *, /, %
		+ : 산술, 문자열 결합
		/ : 0으로 나눌 수 없다, 정수/정수=실수
		% : 왼쪽 부호를 따라 간다
			+ % + => +
			- % + => -
			+ % - => +
			- % - => -
	= 비교 연산자
	= 논리 연산자
	= 대입 연산자
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	let a=5
	let b=2
	console.log("a+b="+(a+b)) // a+b=7
	console.log("a-b="+(a-b)) // a-b=3
	console.log("a*b="+(a*b)) // a*b=10
	console.log("a/b="+(a/b)) // a/b=2.5
	console.log("a%b="+(a%b)) // a%b=1
	
	// 연산이 안되는 경우 => NaN (장바구니, 예매 => 총 금액)
}
</script>
</head>
<body>

</body>
</html>