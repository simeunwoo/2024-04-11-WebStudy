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