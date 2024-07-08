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
					2) 500 : 
			include
			taglib
			
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