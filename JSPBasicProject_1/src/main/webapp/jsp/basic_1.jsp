<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP : Java Server Page => 서버에서 실행하는 자바 파일 => Back-End
	Back-End : Java, JSP, Servlet, Spring, Oracle
	Front-End : HTML, CSS, JavaScript
	                       ========== JQuery(Ajax), VueJS, ReactJS, NextJS
	JSP
	
		1. HTML + Java => 구분
			자바 => <% %> (스크리트릿), <%= %> (표현식), <%! %> (선언문)
			
		2. 동작 방식 => 정적 페이지 / 동적 페이지
			정적 페이지 => 한개의 파일에 한개만 사용 (HTML)
			동적 페이지 => 한개의 파일에 여러개의 데이터를 출력 (JSP, PHP, ASP, CGI)
			
		3. 지시자
			page : JSP 파일에 대한 정보를 저장
				= 변환 : contentType
					브라우저에서 실행 => HTML / XML / JSON
					=> HTML => text/html
					=> XML => text/xml
					=> JSON => text/plain : JavaScript Object Notation
						자바스크립트 객체 표현법 => VO
						=> Ajax, VueJS, ReactJS, Redux, Next ...
						VO = {}
						List = [{}, {} ...]
				= 라이브러리 추가 : import
				= 한글 변환 : pageEncoding => UTF-8 (호환성)
				= 에러 페이지 : errorPage="파일명"
					1) 404 : 파일이 없는 경우
						<a href="파일명">
					2) 500 : 자바 컴파일 에러
					=============================================
					3) 403 : 접근 거부 (Spring-Security)
					4) 412 : 한글 변환 코드 문제 (UTF-8 => UFT-8)
					5) 400 : bad request => 전송값가 받는 변수 데이터형이 틀리는 경우
				= JSP의 시작점
			include : <%@ include file="" %> => <iframe>
				JSP 안에 다른 JSP를 포함하여 사용
				====================================
					로고 / 메뉴 / 검색 => 변경 (X) => 모든 파일에 고정
				====================================
					|
					|
					|
				====================================
					개인 정보 방침 => 변경 (X) => 모든 파일에 고정
				====================================
			taglib : jsp의 단점을 보완 => JSTL : 자바와 HTML을 분리할 때 사용 (분리 과정 : MVC)
			                                ===================================
			                                Spring에서는 MVC만 사용
			                                1차 프로젝트 => MVC / ReactJS => Redux / VueJS => Vuex
				자바 => 태그형으로 변경
				<%
					if(조건문)
					{
				%>
						[HTML 구간]
				<%
					}
				%>
				
				====================> 변경
				
				<c:if test="">
					[HTML 구간]
				</c:if>
				
		4. 자바 코딩
			<% %> : 스크립트릿 : 일반 자바 (메소드 안에 코딩)
				지역 변수 선언, 제어문, 메소드 호출
				자바 문법을 그대로 사용
				=> 주석 : //, /* */
			<%= %> : 표현식 => 데이터를 화면에 출력 => out.write() (자바에서 out.println() 느낌)
			<%! %> : 선언식 => 메소드, 멤버 변수
		
		5. 지원하는 라이브러리 (내장 객체)
			*** request / *** response / out / *** session / *** application
			config / exception / page / *** pageContext (include/forward : 흐름)
		
		6. Cookie vs Session
			Cookie : 브라우저에 데이터 저장
			Session : 서버에 데이터 저장
			
		7. JSP 액션 태그 / 빈즈
			JSP 액션 태그
				=> <jsp:include>
				=> <jsp:useBean>
			빈즈
				=> VO (데이터를 모아서 한번에 전송할 목적)
		
		8. JSTL / EL => 제어문 / 메소드 호출 => 태그로 제작 => (교재)
		   ====================================== MVC
		
		9. MVC
		
		10. Spring
		
	JSP => 실행 => 톰캣 => 클래스화
	a.jsp      => class a_jsp extends HttpServlet
	              {
	                  <%! %>
	                  public void _jspInit()
	                  {
	                  }
	                  public void _jspDestroy()
	                  {
	                  }
	                  public void _jspService() // JSP에서 코딩하는 영역 => 메소드 안에 들어가는 내용
	                  {
	                      <% %>
	                      <%= %>
	                  }
	              }
	           => 컴파일 => a_jsp.class => 한줄씩 번역
	                                    ========
	                                    메모리에 HTML만 출력
	                                    ===============
	                                    브라우저가 읽어서 출력
			
				
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int a=10/2; %>
</body>
</html>