<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	jQuery : 자바스크립트 라이브러리
	
	1. 라이브러리 다운로드 / 원격
		원격
		<script type="text/javascript" src="http://code.jquery.com/jquery.js">
		*** jquery => 충돌이 되면 안된다
		*** 라이브러리는 반드시 main.jsp => CSS
	
	2. jQuery의 시작
		자바스크립트의 시작 : window.onload=function(){}
		=> $(function(){소스 코딩})
		=> $(document).ready(function(){소스 코딩})
		     =============== 생략이 가능

	3. jQuery의 함수 => $
	                 == document.querySelector()
	                 => document.querySelector("h1")
	                 	$('h1') : tag명
	                 => document.querySelector("#id")
	                 	$('#id') : id명
	                 => document.querySelector(".id")
	                 	$('.id') : class명
	                 => 기타 : 속성 선택자, 자손, 후손, 가상 선택자 ... (CSS 선택자와 동일)

	4. jQuery => 내장 객체 => window, document, location, history
		$(window), $(document), $(location), $(history)
	
	5. 이벤트 처리 / 유효성 검사 / 다른 파일의 데이터 읽기(Ajax)
		이벤트
			=> Listener
				$().on('이벤트명',function(){})
					click, keyup, hover, keydown ...
				$().on('이벤트명',()=>{})
			=> 일반 이벤트
				$().click(function(){})
				$().keyup(function(){})
			    ===
			    태그 읽기

	6. jQuery에서 지원하는 함수
		getter / setter
			getter : 태그의 값을 읽을 때 사용
			setter : 태그의 값을 설정할 때 사용
			= <input type=text...>, <textarea>, <select> : 입력하는 창
			=> $().val() => value 값
			   ========= getter
			=> $().val(값)
			   ========== setter
			=> <td>|||||</td>
				$('td').text() => getter => 값을 읽기
				$('td').text("Hello") => setter
			=> <a href="">
				$('a').attr("href") => getter
				$('a').attr("href","값") => setter
			=> html(), html(값) => innerHTML => 1개만 생성
			=> append() => createElement() => 여러개 생성
		jQuery UI => 효과
		Ajax
	
	7. CSS 적용 => css("속성","값")
					css({"속성":값,"속성":값...})
					      === CSS가 가지고 있는 속성
					      	- : 자신은 없애고, 바로 뒤 문자를 대문자로 활용
					      	ex) margin-top => marginTop
					      	ex) background-color => backgroundColor
	
	jQuery는 DOMScript
	        ---------- 태그를 제어하는 프로그램
	=> *** 라이브러리가 무겁다 = 서버 속도가 늦어진다
	=> 코로나 때부터 주춤 => 이 때부터 Vue, React가 유행하기 시작
	=> jQuery의 반격 => 4, 5버전 동시 출시 (beta 버전)
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 라이브러리 추가 -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	// window.onload=function(){}
	// setter => val("값") => <input>, <select>, <textarea>
	$('#name').val("홍길동") // 값 추가 => 수정, 자동 로그인
	// 이벤트 처리
	$('button').on('click',function(){
		let addr=$('#addr').val() // 입력값 읽기 => 로그인
		alert(addr)
	})
})
</script>
</head>
<body>
	<input type="text" id="name" size="15"><br>
	<input type="text" id="addr" size="15">
	<button>클릭</button>	
</body>
</html>