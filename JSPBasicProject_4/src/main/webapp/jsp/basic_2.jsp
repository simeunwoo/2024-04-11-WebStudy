<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 생명 주기
		=> _jspInit() : web.xml에 환경 설정 : 생성자와 동일한 역할
		=> _jspService() : doGet()/doPost() => 통합 (조건문)
		  ============== JSP에서 코딩한 소스가 메소드 안에 첨부
		                 =========================== _jspService()를 제작
		=> _jspDestroy() : 메모리 해제

	public void _jspService(HttpServletRequest request, HttpServletResponse response)
	{
	    PageContext pageContext;
	    HttpSession session = null;
	    ServletContext application;
	    ServletConfig config;
	    JspWriter out = null;
	    Object page = this; // 내장 객체
	    
	    ====================================
	    여기가 JSP 코딩 위치
	    JSP는 클래스 영역이 아니라 => _jspService() 영역에서 코딩
	    ====================================
	}
	
	(113page => JSP 기초)
	
	JSP 스크립트에 대한 이해
	
	1) JSP는 자바 + HTML(+ CSS/JavaScript)이 혼합
		=> 언어별 구분을 할 줄 알아야 한다
		<% %> : 스크립트릿 (지역 변수)
			=> 일반 자바 코딩 (변수 선언, 메소드 호출, 클래스 메모리 할당, 제어문, 연산자 ...)
			=> 메소드 영역에 설정
		<%= %> : 표현식 (지역 변수)
			=> 브라우저에 출력 (out.println())
			=> 메소드 영역에 설정
		<%! %> : 선언식 (멤버 변수)
			=> 사용 빈도는 거의 없다
			=> 메소드를 JSP에서 만드는 경우, 멤버 변수 선언
			=> class 영역에 설정
			
	class basic_005f2_jsp extends HttpJspBase
	{
		=================================
		멤버 변수
		<%! %>
		=================================
		생성자
		=================================
		메소드
			public void_jspInit(){}
			public void_jspDestroy(){}
			public void_jspService(){}
			{
				<% %>
				<%= %>
			}
		=================================
	}
	
 --%>
 <%--
 	public void _jspService(HttpServletRequest request, HttpServletResponse response)
	{
  --%>
 <%!
 	String name;
 	public void display(){} // 클래스 영역
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int age=10; // _jspService() 영역
	%>
	<%=age %> <!-- out.print(age) -->
</body>
</html>
 <%--
 	}
  --%>