<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 라이브러리 읽기 -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){ // 시작점 : window.onload=function(){}, Vue : mounted(), React : componentDidMount() => useEffect()
	// 태그를 제어 => 선택자
	/*
		선택자 : CSS의 선택자를 사용
		$(선택자) => document.querySelector(선택자)
		  ====
			1) 태그 => $('태그명')
			2) ID => $('#ID명')
			3) class => $('.클래스명')
			4) 자손 => $('태그명(id,class) > 태그명(id,class)')
			5) 후손 => $('태그명(id,class) 태그명(id,class)')
			6) 속성 선택자
				$('태그명[속성=값]') => equals
				$('태그명[속성*=값]') => contains
				$('태그명[속성$=값]') => endsWith
				$('태그명[속성^=값]') => startsWith
			7) 가상 선택자
				$('태그명:nth-child(수열)')
				$('태그명:nth-child(odd)') => 홀수번째
				$('태그명:nth-child(even)') => 짝수번째
				$('태그명:eq(0)') => 1번째
					eq() : 태그가 많은 경우 => 해당 태그를 찾는 경우
					=> eq는 0번부터 시작
		
		태그값 읽기 / 쓰기
			1) val() / val(값)
			2) text() / text(값)
			3) html() / html(값)
			4) attr(속성명) / attr(속성명,값) => 속성값
			5) append() => 여러개의 태그 생성
			6) createClass() => class 적용
			7) removeClass() => class 제거
	*/	
	// 이벤트 처리
	/*
		1. $(선택자).click(function(){})
		===> $(선택자).on('click',function(){})
		===> $(선택자).on('click',()=>{})
			click => button, 메뉴, a, tr/td, img
		
		2. $(선택자).change(function(){}) : select 
		
		3. $(선택자).hover(function(){ // img, div
			mouseover
		},function(){
			mouseout
		})
		
		4. $(선택자).keyup(function(){}) : text, textarea
		
		5. $(선택자).keydown(function(){})
	*/
	// 자바스크립트로 처리
	/*
		function : 기능 처리
		변수 설정 : let / const
		조건문 : if, if ~ else
		반복문 : for, map, forEach
		JSON => Array : [] / Object : {}
			자바 => 전송 : 문자열 => JSON : JSON.parse() / 문자열로 변경 : JSON.stringfiy()
		string : trim(), substring(), split(), indexOf()
		연산자 처리
	*/
	// 효과 : fadeIn, fadeOut, animate() => jquery ui
	// *** Ajax : 화면 변경이 없는 상태 => 서버 요청 => 서버 응답
	/*
		jQuery : 라이브러리가 커졌다 = 속도가 느려졌다
			=> 브라우저에서 속도 처리가 빠른 라이브러리 선호
			=> Vue3 / React-Query
			=> NextJS
		
		JavaScript => TypeScript(문법 어려움)
		
		STS3(사라지는 중) => SpringFramework(사라지는 중) : Spring-Boot
	*/
	$('table > thead > tr').css('backgroundColor','#ccccff')
	$('table > tbody > tr:nth-child(even)').css('backgroundColor','rgb(255,255,200)')
	$('table > tbody > tr:eq(1)').css('color','cyan')
	// 가장 많이 등장하는 가상 선택자 => id, class
})
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top:50px;
}
.row{
	margin:0px auto;
	width:800px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">회원 목록</h1>
		<div class="row">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th class="text-center">이름</th>
						<th class="text-center">성별</th>
						<th class="text-center">주소</th>
						<th class="text-center">전화</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
					<tr>
						<td class="text-center">1</td>
						<td class="text-center">심은우</td>
						<td class="text-center">남자</td>
						<td class="text-center">서울</td>
						<td class="text-center">010-1111-1111</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>