<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	자바스크립트 : 태그를 제어, 이벤트 처리, 사용자 입력 제어, 동적 페이지, 애니메이션
	======== 브라우저에서 제어 (클라이언트)
	
	자바스크립트 사용 방법
	
	1) 내부 스크립트 : 한개의 파일에서만 제어
		<head>
			<script type="text/javascript">
				함수
				window.onload=function()
				{
				}
			</script>
		</head>
	
	2) 외부 스크립트 => <body> : 전체 파일에 적용 => 라이브러리 => cdn
		<head>
			<script type="" src="파일 경로/URL">
		</head>
	
	3) 인라인 스크립트 : 태그만 제어
		<a href="javascript:함수 호출">
		
		=> jquery / vue / react / next => 자바스크립트 라이브러리 (자바스크립트로 처리)
		=> mybatis / jpa / spring => 자바 라이브러리 => 자바 적용
	
	=> 자바스크립트의 변수 선언
		let, var, const => 값 적용에 따라 => 데이터형을 자동으로 설정
			= let : scope를 명확하게 만들어 준다 => ES6
				scope : 사용 범위가 명확하다
			= var : scope가 명확하지 않다 => ES5 => 메모리에 남아 있다 (메모리 누수 현상)
			= const : 상수형 변수 => 자바에서 데이터 전송 (JSON)
	
	=> 자바스크립트에서 사용하는 데이터형
		number : 숫자형 => int, double
		string : 문자형 => char, string => '', ""
		boolean : true/false => 숫자도 가능 => 0과 0.0을 제외한 모든 숫자는 true
		array : 배열 => [] => object 단위 => 데이터를 섞어서 사용 가능
		object : {} => {키:값,키:값...} => JSON
		undefined : 변수에 값이 없는 경우 (초기화가 없는 상태)
		function : 함수 => 매개 변수로 사용 가능 => Callback : 시스템에 의하여 자동 호출
			map(function(){})
			forEach(function())
			$().click(function(){})
		================================ 확인 시에는 typeof 변수명
	
	=> 연산자
		산술 연산자 : +, -, *, /, %
			+ : 문자열 결합 가능
			/ : 정수/정수=실수
		단항 연산자 : ++, --
		==================================
		비교 연산자 : ===, !==, <, >, <=, >=
		논리 연산자 : &&, ||, !
		================================== 숫자, 문자, 날짜 비교 가능
		대입 연산자 : =, +=, -=
		형변환 연산자 => HTML에서 읽어오는 모든 데이터는 문자열이다
			숫자 변환 : Number("10"), parseInt("")
			문자 변환 : String(10)
			논리 변환 : Boolean("true"), Boolean(1)=true
	
	=> 제어문
		조건문 : if, if ~ else
		반복문 : for, for of
			일반 for는 사용
			for of => map(), forEach()
		반복 제어 : break
	
	=> 배열 : [], 객체 : {}
	
	=> RestFul => 다른 프로그램과 연동
		자바 <=> 자바스크립트 연동
		~VO <=> {}
		List <=> [] ~~~~~~~> JSON/JSONP/클로저/호이스팅
	                         ===================== 면접 100%

	=> 가장 많이 등장
		함수
		function 함수명(매개 변수...){}
		let 함수명=function(){}
		let 함수명=()=>{}
		=============== vue / react
		
		useEffect(){ // React
			이벤트를 설정
			function 함수명(매개 변수...){} (X)
			let 함수명=()=>{} (O)
		}
	
	자바스크립트에서 지원하는 기본 객체
	= String : 문자열
		substring(시작 index,끝 index) : 문자열을 자르는 경우
			끝 index = -1 (자바와 똑같이 끝 index는 실제 범위에는 포함되지 않는다)
			인덱스 번호는 0번부터 시작
		indexOf() : 찾기
		length()
		split() : 분리 => []
		trim() : 공백 제거
	= Number : 숫자
		=> 형변환할 때 주로 사용
		NaN : 연산 처리가 안된 경우
	= Array : 배열
		map() : for 관련
		push() : 배열에 하나씩 추가
		pop() : 배열의 맨 마지막부터 제거
		slice(start,end) : 새로운 배열 생성
		... 연산자 => 그대로 복사
			[1,2,3,4,5]
			[...6,7,8]
	= Math : 수학
		ceil()
		round()
		random()
	= Date : 날짜
		getFullYear()
		getMonth()
		getDate()
		getDay() : 요일 읽기
		
	브라우저 객체
	=========
	window : 브라우저 제어 => open(), close(), scrollbar
	|
	==================================
	|          |          |          |
	location   document   history    event
	: 화면 이동   : 화면 제어   : 기록 정보   : 이벤트 처리
	
	= location : 화면 이동
		href
	= document : 화면 제어
		write
		querySelector()
	= history : 기록 정보
		back()
		go()
	= event : 이벤트 처리
		function aaa(event)
		
	라이브러리
	= jQuery : 단순하게 만든 라이브러리 => 사용 빈도가 많다보니 욕심이 생겨서 => 라이브러리가 비대해졌다 => 속도의 저하
		대부분이 브라우저에서만 사용 가능 (호환성이 좋다)
		HTML(DOM = 트리 형태)을 쉽게 조작 가능
		간단하게 CSS 적용 가능
		
		예)
		let a=document.querySelector("a")
		a.style.background='red'
		
		$('a').css('background','red')
		======
		document.querySelector("a")
	
		오픈 소스 : 사용이 자유롭다
		속도가 늦다 => 가상 돔(가상 메모리)
	
	문법 형식)
	= JavaScript
		main : window.onload=function()
	= jQuery
		main : $(function(){}), $(document).ready(function(){})
	= Vue3
		main : new Vue({
					mounted:function(){}
				})
	= React : class Main extends Component
			{
				componentDidMount(){}
			}
			=> HOOKS
			function main()
			{
				useEffect(()=>{
				
				})
			}
	= React-Query : ******* 서버 연결
	
	=====================================================
	
	jQuery : 태그를 제어하는 프로그램 (태그를 가지고 오는 방법)
		값, 속성, CSS, 이벤트 제어
		$('태그명').처리
		$('아이디명').처리
		... 선택자
	1) 값을 읽기 (태그)
		val() / val(값) : input, select, textarea
		text() / text(값) : 모든 태그 => <태그>값</태그> : 문자열만 취급
		html() / html() : HTML 적용 => 단일(한번만 사용)
		append() / append() : 여러개를 동시에 사용
	2) 제어 (이벤트)
		click
		change
		hover
		keyup
		keydown
	3) Ajax
		브라우저 : HttpXMLRequest가 존재
			HttpXMLRequest : 서버 연결 => 서버 응답
		=> if(httpRequest.readyState==4)
			{
				if(httpRequest.status==200)
				{
				}
			}
			=> success:function()
				{
				}
		=> $.ajax({
			type: // => get/post
			url: // => 실행할 JSP를 지정
			data: // => ? => {키:값}
			success:function()
			{
				// 정상 수행
			}
			error:function(e)
			{
				// 서버에서 오류 발생
			}
		})
		=> axios.get('url'{ // => Vue, React
			params:{
				키:값
			}
		}).then(res=>{
			결과값 받기
		})
		=> axios.post()
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>