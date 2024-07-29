<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	자바스크립트 : 브라우저 자체에서 처리 (서버 처리가 아니다)
		브라우저에서 동적 페이지 작성 => 이벤트 (HTML/CSS => 정적 페이지)
	= 역할(웹 사이트)
	============
	1) HTML / CSS => 화면 UI => 퍼블리셔
	=======================
	2) 자바스크립트 => 화면에 대한 동적 처리 => 오라클 연결이 가능 (서버 측 사이드 => NodeJS)
		=> HTML/CSS를 제어 => 유효성 검사 (사용자 입력), 움직이는 화면
		1. 사용법
			= 내부 스크립트 : 한개의 파일에서만 작업
				<script type="">
				</script>
			= 외부 스크립트 : 여러개 파일에 적용 => .js
				=> 파일로 제작
				<script type="" src="파일명 지정"> => import
				</script>
			= 인라인 스크립트 : 태그 한개를 제어
				<input type="button" onclick="javascript:history.back()">
		2. 버전
			= ES5
				var : 변수 => 자동 지정 변수 => 데이터형을 사용하지 않는다
				=> 단점 : Scope가 명확하지 않다, 메모리 누수 현상 => 요즘에는 var을 거의 안쓴다
					Scope : 사용 범위
			= ES6
				let : 변수 => 자동 지정 변수 => 데이터형을 사용하지 않는다
				=> var의 단점을 보완 => 사용 범위가 명확하다 : {} 활용
					{
						=> 여기 안에서만 사용 가능 => 메모리 해제
					}
				const : 상수형 변수 => 값을 변경할 수 없다
				람다식 : 화살표 함수 : => 활용
				=> ex)
					function func_name(매개 변수)
					{
					}
					let func_name=function(){}
					let func_name=()=>{}
					               === function/return을 생략할 때 주로 사용 (권장)
				같다 (== ==> ===) 경고 (VueJS/ReactJS => 반드시 === 사용)
				=> 문장이 종료될 때 => 예전에는 ; 사용, 최근에는 ;을 사용하지 않는다 => 줄여쓰기에 유의
					;을 사용하지 않는 언어 : 코틀린, 파이썬, 스칼라
	============================= Front-End
	3) 자바 => 데이터 관리
	4) 오라클 => 데이터를 저장하는 공간
	========================== Back-End
	
	자바스크립트 => 자바의 라이브러리가 어느 정도 유사
		trim(), substring(), indexof ... String/Number/Date
	=> 로직은 거의 없다
	   =========== cookie / session / thread/ sqlite
	               ==================================
	               => 자바에서 주로 사용
	               => cookie : VueJS / ReactJS => 서버와 다르게 설정
	               		port : 서버(80), 3000
	=> 대소문자를 구분
	=> 어시스트(Ctrl+스페이스 바)가 없다 (단점) => 암기 후에 사용
		이클립스 => Back-End => 에러 출력도 Back-End 위주로만...
	=> 절차적 언어 => 에러가 출력이 안됨
	
	1. 변수 설정
	
	데이터형을 사용하지 않는다 / 자동 지정 변수 사용
		<script type="">
		변수 선언 => 전역 변수
		function aaa()
		{
			변수 선언 => 지역 변수
		}
		</script>
		
	변수 설정은 초기값에 따라 자동으로 데이터형 지정
	                    ===============
		number : 실수, 정수
		string : 문자, 문자열 => '', ""
		object : 배열, 객체
		boolean : true/false => 숫자도 가능 => 0, 0.0이 아닌 모든 수는 true
		function : 함수도 데이터형으로 취급
		undefined : 변수에 값이 없는 경우
		NaN : 연산이 안되는 경우
		null : 배열, 객체에 값이 없는 경우
	
		ex)
		let i=10
			=> i:number => int
		let i=10.5
			=> i:number => double
		let i='A'	
			=> i:string
		let i="A"
			=> i:string
		let i=["a","b","c"...]
			=> i:object => [] 배열
		let i=[1,2,"aaa",true] => 모든 데이터형을 배열로 설정 => 자바 : Object[]
		let i={"name":"홍길동","age":20...} => 객체(object)
			=> name, age : 멤버 변수(키)
			=> i.name, i.age : JSON(자바스크립트 객체 표현법)
		let i=true
			=> i:boolean
		let i=function(){}
			=> i:function : 매개 변수로 사용 가능 (Callback)
				=> Callback 함수는 jQuery에서 자주 사용
	
	브라우저에 출력
		document.write() => System.out.print()
			=> \n : <br>
		innerHTML : 태그 안에 데이터를 첨부
		alert() : 모달 창을 띄우는 경우
	
	도스 창에 출력
		console.log()
	
	자바 => main()
		window.onload=function(){
			// 브라우저에 HTML이 출력된 상태
		}
		
		jQuery : $(function(){})
		VueJS : mounted()
		React : useEffect()
		
	2. 연산자
	
	3. 제어문
	
	4. 함수
	
	5. 라이브러리(내장 함수)
	
	6. 객체 지향 => DOM
	=================
	자바스크립트 라이브러리
	===============
	1) jQuery(Ajax)
	2) VueJS
	3) ReactJS
	4) NextJS / NodeJS
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 내부 스크립트
/*
 * 	주석
 */
window.onload=function(){
	// 변수 설정 = 데이터형 확인
	let a=10
	let b=10.5
	let c="ABC"
	let d='DEF'
	let e=true
	let f=[1,2,3,4,5]
	let g={"name":"홍길동","age":25}
	
	// typeof
	document.write(a+":"+typeof a+"<br>") // number 
	document.write(b+":"+typeof b+"<br>") // number
	document.write(c+":"+typeof c+"<br>") // string
	document.write(d+":"+typeof d+"<br>") // string
	document.write(e+":"+typeof e+"<br>") // string
	document.write(f+":"+typeof f+"<br>") // object
	document.write(g+":"+typeof g+"<br>") // object
	
	// 데이터형 변경
	a="abcdefg";
	document.write(a+":"+typeof a+"<br>") // string
}
</script>
</head>
<body>

</body>
</html>