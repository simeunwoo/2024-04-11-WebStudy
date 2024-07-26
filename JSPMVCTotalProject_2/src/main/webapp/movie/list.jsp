<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	JSP / Servlet
	
	JSP
	
	지시자
	
		= page : contentType="" => 브라우저에 알려주는 방식
            메모리에 저장된 데이터가 어떤 형식인지 알려준다 => response
                      ============
                      HTML / XML / JSON
                      = HTML : text/html
                      = XML : text/xml
                      = JSON : text/plain
                      
		= taglib : 태그형으로 자바의 제어문을 지원
			prefix="" : <c:
				prefix 지정은 개인에 따라 다를 수 있다 (자율적)
				c / fmt / sql / xml / fn
				제어문 / 화면 이동
					=> <c:if test="조건문"></c:if>
					=> <c:forEach var="받는 변수" items="배열/컬렉션" varStatus="인덱스 번호"></c:forEach>
					=> <c:forEach var="변수명" begin="" end=""></c:forEach> => 일반 for문 형식
					=> <c:choose>
						<c:when test=""></c:when>
						<c:when test=""></c:when>
						<c:when test=""></c:when>
						<c:otherwise></c:otherwise>
					   </c:choose>
					=> <c:set var="" value=""></c:set> => request.setAttribute(var값, value값)
					=> <c:redirect url="이동 주소"></c:redirect>
				EL : 데이터 출력
					${requestScope.키} => request.setAttribute()
					${sessionScope.키} => session.setAttribute()
					${+=} : 문자열 결합
					<% %>, <%= %> => JSTL, EL
			uri="" : import
			
	Servlet : 자바로만 소스 코딩 => JSP
	=======
	실행 순서
		1) init() : 메모리 초기화 (자동 호출)
		2) service() : 사용자 요청 처리 => GET / POST
			= doGet() : GET
			= doPost() : POST
		3) destroy() : 메모리 해제 (자동 호출) => 화면 이동, 새로 고침 (자동으로 메모리 해제)
		
	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
	MVC
	===
	HTML / Java 분리
	===============> 기존의 JSP만 가지고 만든 파일보다 2배 많다
	JSP
	=== Java + HTML
	
	MVC의 장점
	= 분업화가 좋다 (여러명의 개발자가 동시 개발이 가능)
		=> Front / Back
		=> 개발 속도가 빠르다 (재사용성, 확장성)
	
	HTML : 화면 출력 ===== View
	                  | => Servlet (Controller)
	Java : 데이터 관리 ==== Model
	
	1. Model : 요청 처리
		오라클에서 데이터 읽기 / 쓰기 / 수정 / 삭제
			=> DAO, VO, Manager
		사이트에서 데이터 읽기
			=> 웹 크롤링
		OPEN API
			=> api 키를 이용하여 처리 (증권)
		*** 데이터 관리 (입출력)
		
	2. View : 브라우저 출력용
		jsp / html(thymeleaf)
			jsp
				=> JSTL/EL
			html
				=> <tr th:each=""></tr>
				=> <tr v-for=""></tr>
	
	3. Controller : JSP / Servlet
		Servlet : 보안 유지 굿 (.class) : 스프링, 스트럿츠 => 제공
		JSP <===(request/response)===> 자바 : JSP와 자바의 연결
		
	=> 클래스 단위
	=> 메소드 단위 (*******) => 어노테이션(찾기 기능)
	
	=> 내장 객체
		=> request / response / session
		=> cookie
		=> 외부 라이브러리 ex) cos.jar, jsoup.jar ...
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