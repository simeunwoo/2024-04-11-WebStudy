<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
	브라우저 내장 객체 => 계층형 구조 (트리 형태)
	============
	window : 브라우저
	= document : 화면 출력 담당
		= form
			= input
			= select
			= textarea
			===> 계층(window 생략) => document.form.input ...
		= img
		= a
	= history : 이동 기록
	= location : 화면 이동
	= frame : 화면 구성
	
	window
	~~~~~~~~~~~~~~~~
	= close() : 닫기
	= open() : 열기
	~~~~~~~~~~~~~~~~ setTimeout(), setInterval()
		= setTimeout()
			실행 후 종료 => 한번만 실행
			회원 가입 = 이미지(회원 가입 축하) => main.jsp로 이동
		= setInterval()
			계속 수행 => 날씨, 실시간 인기 순위 ...
	= scrollbar
	...
	브라우저 관련
	
	document : <body> 안에 있는 태그를 제어
	= createElement()
	= write()
	= querySelector()
	= appendChild()
	
	history : 브라우저 기록 정보
	= back()
	= forward()
	= go() : go(-1)일 경우 이전으로
	
	location : 주소 정보 => GET
	= href : 이동할 위치 지정 => sendRedirect()
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=()=>{
	let btn=document.querySelector("button")
	btn.addEventListener('click',()=>{
		window.open('js_7.jsp','winname','width=500,height=700,scrollbars=yes')
	})
}
</script>
</head>
<body>
	<button>클릭</button>
</body>
</html>