<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	반복문
	
	do~while
		초기값 (1)
		do
		{
			반복 수행 문장 (2)
			증가식 (3)
		}while(조건식) (4) => 나중에 조건 처리 => 무조건 1번은 수행
		===> (4)에서 false면 종료
	
	while
		초기값 (1)
		while(조건식)
		{
			반복 수행 문장 (3)
			증가식 (4)
		}
		===> (2)에서 false면 종료
	
	for     (1)  (2)  (4)
		for(초기값;조건식;증가식)
		{    |(3)
			반복 수행 문장
		}
		===> (2)에서 false면 종료
		
	while : 반복 횟수가 지정이 안된 경우
	for : 반복 횟수가 지정이 된 경우 => 배열, 객체
	
	=> 주로 자바에서 이용 => 배열 형식으로 주로 전송
		=> forEach
		1. for - of : 실제 데이터를 1개씩 읽기
		2. for - in : 배열 인덱스 번호 읽기
		3. forEach => 함수형 : 실제 데이터를 1개씩 읽기
		4. map => 함수형 : 실제 데이터를 1개씩 읽기
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	document.write("<h1>do~while</h1>")
	let i=1;
	do
	{
		document.write(i+"&nbsp;")
		i++
	}while(i<=10)
		
	document.write("<h1>while</h1>")
	i=1;
	while(i<=10)
	{
		document.write(i+"&nbsp;")
		i++
	}
	
	document.write("<h1>for</h1>")
	for(let j=1;j<=10;j++)
	{
		document.write(j+"&nbsp;")
	}
}
</script>
</head>
<body>

</body>
</html>