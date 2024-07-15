<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. HTML/자바 분리 => MVC, Spring에서는 나오지 않는다
		<% %> : 자바 코딩 위치 => <c:~>
		<%= %> : 브라우저 출력 => ${}
	
	2. 지시자
		page
			import, contentType, errorPage => web.xml (등록)
		taglib => prefix, uri => (20장) => JSP에서 자바 대체
	
	*** 3. 내장 객체 : MVC / Spring
		request
			= getParameter()
			= getParameterValues()
			= setCharacterEncoding()
			= getSession() / getCookie()
			= setAttribute() / getAttribute()
			= getContextPath() / getRequestURI()
		response
			= setHeader()
			= sendRedirect()
			= addCookie()
		session
			= setAttribute()
			= getAttribute()
			= invalidate()
			= removeAttribute()
		application
			= getRealPath()
		cookie (내장 객체가 아니다) => 문자열만 저장 가능
			= setPath()
			= setMaxAge() : 저장 기간 => 0이면 삭제
			= getName() : 키를 읽어 올 때
			= getValue() : 값을 읽을 때
			생성 : new Cookie(키, 값) => 최근 방문 : 보안 취약
		
	액션 태그
		<jsp:include> : 계속 사용 (tils가 사라짐)
			조립식 프로그램에 많이 사용
	
	데이터베이스 : DBCP, JDBC => 자바와 오라클을 연결
	
	MVC를 위한 준비 : EL / JSTL
		MVC를 제작
	
	라이브러리 => cos.jar, commons-dbcp.jar, commons-pool.jar
	                   =================================== tomcat
		cos.jar : 업로드 라이브러리
		
	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	Cookie : 브라우저에 저장
		보안이 취약
		아마존에서 주로 사용 (로그인)
		최근 방문 / 자동 로그인
	=> 저장 : 생성자 이용
		Cookie cookie=new Cookie(String key,String value)
		                        ===========
		                        중복없는 데이터
	=> 저장 기간 설정 : setMaxAge(1800) => 초 단위 => ex) 60*60*24
	=> 저장 위치 설정 : setPath("/")
	=> 브라우저로 전송 : response.addCookie()
	=> 키 얻기 : getName()
	=> 값 얻기 : getValue()
	=> 쿠키 전체 읽기 : request.getCookies()
	
	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	Session : 서버에 저장 (사용자의 일부 정보 저장) => ex) 로그인 시 처리
		상품 정보 (장바구니)
	=> 저장 : setAttribute()
	=> 저장값 읽기 : getAttribute()
	=> 저장된 데이터를 1개씩 삭제 : removeAttribute()
	=> 저장된 데이터 전체 삭제 : invalidate()
	=> 저장 기간을 설정 : 디폴트 : 30분
		setMaxInactiveInterval(초 단위)
	=> getId() : 구분자 (사용자마다 세션은 서버에 1개만 생성하는데 이 때 쓰인다)
		채팅 (JSP)
	=> isNew() : 새로 생성된 세션 여부 확인
	=> 데이터를 지속적으로 관리하는 클래스
	   =======================
	=> (301page)
	
	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	Session vs Cookie (기술 면접 96%)
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