<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	for-each
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	// for-each => 배열
	// 배열 = 같은 데이터형을 모아서 한개의 이름으로 제어 => index 번호를 이용하여 처리 => 0번부터 시작
	// 자바 : {}, 자바스크립트 : []
	const names=["홍길동","심청이","박문수","이순신","춘향이"]
	const sexs=["남자","여자","남자","남자","여자"]
	document.write(names[0]+"<br>")
	document.write(names[1]+"<br>")
	document.write(names[2]+"<br>")
	document.write(names[3]+"<br>")
	document.write(names[4]+"<br>")
	
	// 배열의 장점이 순차적 => 인덱스를 배정 => for
	document.write("<h1>for-each(for of => 배열 한개만 사용 가능)</h1>")
	// 배열에 저장된 실제 데이터 읽기 => for(변수 of 배열명)
	for(let name of names) // for(변수 of 배열명)
	{
		document.write(name+"<br>")
	}
	
	// 배열에 저장된 인덱스 번호를 읽기 => for in
	document.write("<h1>for-each(for in => 배열 두개 이상 사용 가능)</h1>")
	for(let i in names)
	{
		document.write(names[i]+"("+sexs[i]+")"+"<br>")	
	}
	
	// 자바스크립트에서 지원하는 for-each 함수 : forEach / map => Ajax, VueJS, ReactJS에서 주로 사용
	document.write("<h1>for-each 함수 1</h1>")
	// 배열명.forEach(function(name){}) => 람다식(함수 포인터 : 화살표 함수(=>))
	names.forEach(function(name){
		document.write(name+"<br>")
	})
	
	document.write("<h1>for-each 함수 2</h1>")
	// 배열명.map((name)=>{}) => 람다식(함수 포인터 : 화살표 함수(=>))
	names.forEach(function(name){
		document.write(name+"<br>")
	})
}
</script>
</head>
<body>

</body>
</html>