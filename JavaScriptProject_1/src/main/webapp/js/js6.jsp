<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	제어문
	
	= 조건문
	
		단일 조건문
			if(조건문) => 조건문 : 논리 연산자, 비교 연산자, 부정 연산자 => true/false
			{
				조건문이 true일 때 수행하는 문장
			}
			
		선택 조건문
			if(조건문)
			{
				조건문이 true일 때 수행하는 문장
			}
			else
			{
				조건문이 false일 때 수행하는 문장
			}
			
		다중 조건문
			if(조건문)
			{
				조건문이 true일 때 수행하는 문장 => 종료
				false일 경우 밑에 있는 조건문으로 이동
			}
			else if(조건문)
			{
				조건문이 true일 때 수행하는 문장 => 종료
				false일 경우 밑에 있는 조건문으로 이동
			}
			else if(조건문)
			{
				조건문이 true일 때 수행하는 문장 => 종료
				false일 경우 밑에 있는 조건문으로 이동
			}
			...
			else
			{
				필요 시에만 사용 (생략 가능)
				조건에 해당되는 내용이 없을 경우 처리 => default 문장	
			}
			
	= 선택문
	
		switch~case
			switch(숫자, 문자)
			{
				case 값:
					처리 문장
					break;
				case 값:
					처리 문장
					break;
				case 값:
					처리 문장
					break;
				...
				default
					=> 필요 시에만 사용 (생략 가능)
					=> 조건에 해당되는 내용이 없을 경우 처리
			}
			
	= 반복문
	
		while : 반복 횟수가 없는 경우 => 무한 스크롤
			초기값 ============ 1
			while(조건문) ===== 2
			{
				반복 수행 문장 == 3
				증감식 ======== 4
			}
			1=2=3=4
			  2=3=4
			  2=3=4
			  ...
			========> false면 종료
			
		do~while
		
		for : 반복 횟수가 있는 경우
		
		= 일반 for
			     1    2    4
			for(초기값;조건식;증가식)
			{     | 3
				반복 수행 문장
			}
			1=2=3=4
			  2=3=4
			  2=3=4
			  ...
			========> false면 종료
		
		= for in(인덱스 번호)
			for(변수 in 배열)
				=> 배열의 인덱스 번호를 가지고 온다 => 0번부터 시작
		
		= for of(for~each)
			for(변수 of 배열)
				=> 변수는 배열에 저장값을 읽어 온다 => for(int a:arr)
		
		= 함수
		
			*** forEach()
				배열.forEach(function(변수){})
				=> 여기서 변수는 배열에서 값을 1개씩 자동으로 읽어 온다
			
			*** map()
				배열.map(function(변수){처리})
				=> 여기서 변수는 배열에서 값을 1개씩 자동으로 읽어 온다
				배열.map((변수)=>{처리}) : 최근 트렌드 형식 (function을 생략)
			
	= 반복 제어문
	
		break : 반복문을 중단할 때 사용
			=> if / for => 데이터를 자바에서 전송하기 때문 => 전송값을 제어 
		
		continue
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*
window.onload=function(){
	
}
*/
window.onload=()=>{
	let a=10
	if(a%2==0)
	{
		// document.write(a+"는(은) 짝수")
	}
	else
	{
		// document.write(a+"는(은) 홀수")
	}
}
function login()
{
	let id=document.getElementById("id").value
	if(id.trim()==="") // 입력이 안된 경우 (유효성 검사)
	{
		alert("아이디 써라")
	}
}
</script>
</head>
<body>
	ID : <input type="text" size="10" id="id">
	<input type="button" value="로그인" onclick="login()">
</body>
</html>