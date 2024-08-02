<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	자바스크립트 : jQuery는 자바스크립트 기반
	          --------------------
	          MVC/JSP/Spring => 자바 기반
	          MyBatis/JPA/DBCP => 오라클 기반
	          => 라이브러리 : 사용 형식
	          
	자바스크립트의 핵심
		= 변수 선언 / 연산자 / 제어문 동일
		= 함수 / 객체 모델 : 태그를 읽어서 이벤트 처리
		  ---  ------------      -------- 라이브러리 : jQuery / VueJS / ReactJS
		  ex)
		  window.onload=function(){처리}
		  	=> jQuery : $(function(){처리})
		  	=> VueJS : mounted(){}
		  	=> ReactJS : componentDidMounted(){}
		= 데이터를 관리 프로그램 : 자바에서 출력 데이터를 전송 => 받아서 처리
		  -------------- 단일 데이터 : 문자열 / 여러개 데이터 : [], {} : JSON
		  Restful => 자바 <=> 자바스크립트의 통신
		                  |
		                 JSON
		                자바 : List, VO
		                       |    |
		            자바스크립트 : [],  {}
		  자바는 오라클에 있는 데이터를 읽어와서 자바스크립트로 전송
		  --------------------------------------
		  자바스크립트 데이터를 받아서 동적으로 화면 처리 => 데이터 변경 (태그 생성, 속성, CSS 제어, 이벤트 처리)
		  HTML / CSS => 기본 화면
		= 객체 모델 : 태그를 가지고 온다
			document.querySelector("CSS 선택자") => $("선택자")
			----------------------
				=> $로 변경된다
			document.getElementById("아이디명")
			VueJS => <a href="" ref="" v-model=""> : 양방향
			React => e.target.value
				target : 태그
			*** 매칭
			JAVA : System.out.println / import
			C / C++ : print / include
			C# : Console.write() / using
			===> 다 같은 의미
	
	사용자가 요청 => 클릭 / 마우스 / 키보드 => 이벤트
	--------- 마우스 / 키보드
	처리 => 함수 제작 (자바 => 메소드)
	      ------- 변수/연산자/제어문의 묶음
	=> 함수 생성 방법
	   ----------
	   1) 익명의 함수 : 함수명이 없는 상태
	   	function(){}
	   	window.onload=function(){}
	   	.then(function(){}) => callback : 시스템에 의하여 자동 호출
	   	$().click(function(){})
	   	public String aaa(){} => 자바
	   	fun aaa()):String => 코틀린
	   	def aaa() => 파이썬
	   2) 선언적 함수 : 함수명이 있는 상태
	   	function 함수명(){} => 요청 처리
	   	======================
	   	let func=function(){}
	   	let func=()=>{}
	   	====================== => 이벤트 처리
	   3) 유형
	   	= 리턴형 O, 매개 변수 O
	   		function func_name(id,pwd) => 매개 변수명만 설정
	   		{
	   			return 값; // 리턴형을 사용하지 않는다
	   		}	   		   	
	   	= 리턴형 O, 매개 변수 X
	   		function func_name()
	   		{
	   			retunr 값;
	   		}
	   	= 리턴형 X, 매개 변수 O
	  	 	function func_name(id,pwd)
	   		{
	   			
	   		}
	   	= 리턴형 X, 매개 변수 X
	   		function func_name()
	   		{
	   			
	   		}
	   	======================================
	   	= ES6 권장 사항
	   		변수 => var 대신 let/const
	   		함수 => let func_name=()=>{} // 화살표 함수 이용
	   				let func_name=function(){}
	   		
	   		class A
	   		{
	   			constructer()
	   			{
	   				let a=10
	   				생성자
	   				axios.get().then(function(){
	   					console.log(this.a) => 오류
	   					            ---- axios
	   				})
	   				axios.get().then(()=>{
	   					console.log(this.a) => 오류
	   					            ---- A
	   				})
	   			}
	   		}
	   		
	호출 방법 => 함수(사용자 정의 제작) => 자동 호출은 없다 => 직접 호출해서 사용해야 한다

		function func_name(){} => func_name()
		let func_name=()=>{} => func_name()
		let func_name=function(){} => func_name()
	
		function func_name(name){} => func_name("A")
		let func_name=(name)=>{} => func_name("B")
		let func_name=function(name){} => func_name("C") => 데이터형은 매개 변수 값에 따라 설정
		                                  func_name(10)
		                               => 문자열 사용 시 => '', "" 사용

	*** 내장 객체
	*** 태그 선택 방법
	= 자바스크립트 : 태그 읽기 / 태그 생성 / 속성 읽기
		태그 읽기
			=> document.querySelector("CSS 선택자") => 태그 한개 읽기
				CSS 선택자
				--------
				1. 태그 : ("태그명")
				2. 아이디 : ("#아이디명")
				3. 클래스 : (".클래스명")
				4. 속성 선택자
					("태그명[속성=값]")
					("태그명[속성=*값]")
					("태그명[속성=^값]")
					("태그명[속성=$값]")
				5. 자손 : ("태그명 > 태그명")
				6. 후손 : ("태그명 태그명")
				7. 가상 선택자
					("태그명:nth-child(2n)")
			=> document.querySelectorAll("CSS 선택자") => []
			   ------------------------------------------- $()
			=> document.getElementById() => id
			=> document.getElementByClassName() => class
			=> document.getElementByTagName()
			=> document.getElementByName() => name ($()는 사용 불가)
			   ------------------------------------------------- 태그는 한개만 읽는 경우
		태그 생성
			=> createElement("태그명") => <태그명></태그명>
				=> $().html("태그명")
			=> createTextNode("값") => <태그>값</태그>
				=> $().text("값")
			=>
			<태그>
				<태그></태그>
				---------- 태그 첨부 : appendChild() => $().append()
			</태그>
		속성값 읽기
			=> getAttribute(속성명) => $().attr(속성명)
		속성값 추가
			=> setAttribute(속성명,값) => $().attr(속성명,값)
		태그 사이의 값
			=> textContent => text()
			=> innerHTML => html()
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태그 생성</title>
<script type="text/javascript">
window.onload=function(){
	// 자바스크립트에서 화면 제어
	let h3=document.createElement("h3") // <h3></h3>
	let text=document.createTextNode("Hello JavaScript")
	h3.appendChild(text)
	document.body.appendChild(h3)
}
</script>
</head>
<body>

</body>
</html>