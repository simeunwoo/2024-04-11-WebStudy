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
	let c="10"
	let f=20;
	console.log("c+f="+(c+f)) // c+f=1020 / 문자열 결합
	console.log("c+f="+(parseInt(c)+f)) // c+f=30
	
	// 'A' => 65(X) => String
	// + 외의 다른 산술 연산 => NaN
	let m='A' // 'A' : 문자(X) => 문자열(O)
	let n=1
	console.log("m+n="+(m+n)) // m+n=A1 / 문자열 결합
	console.log("m*n="+(m*n)) // m*n=NaN
	
	/*
		산술 연산자 - 주의점
		1. 숫자가 아닌 경우 => + 외의 다른 산술 연산은 연산 처리가 불가능 => NaN
		2. 정수/정수=실수
		3. '' => 문자가 아니고 문자열 => "", ''
			'ABCD' => 여러개의 문자를 사용할 수 있다
		4. HTML을 통하여 입력된 값은 문자열 : 숫자로 변환
			<input type=text...>
	*/
}
function calc()
{
	let f=document.querySelector("#first").value
	// $('#first').val() => jQuery
	console.log("f="+f+","+typeof f)
	let s=document.querySelector("#second").value
	console.log("s="+s+","+typeof s)
	
	document.querySelector("#result").value=Number(f)+parseInt(s)
	// HTML에서 전송하는 값 : string => 형변환 후에 처리
	// 자바에서 문자열 => String n=request.getParameter()
}
</script>
</head>
<body>
첫번째 정수 : <input type="text" id="first" size="10"><br>
두번째 정수 : <input type="text" id="second" size="10"><br>
<input type="button" value="계산" onclick="calc()"><br>
결과 : <input type="text" id="result" size="10" readonly><br>
</body>
</html>