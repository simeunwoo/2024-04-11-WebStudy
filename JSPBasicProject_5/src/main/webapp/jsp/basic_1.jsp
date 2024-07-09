<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP (Java Server Page)
		1) HTML / Java => 구분 <% %> <%= %> <%! %>
		2) 지시자 : (139page)
			page : JSP의 기본 정보를 저장하고 있다
				지시자 : <%@ 지시자명 속성="값" 속성="값" ... %>
					ex) <%@ page contentType="text/html" %>
					ex) <%@ include file="파일명" %>
					========================================> JSP는 조립식 프로그램
					<%@ taglib prefix="c" ... %>
					<c:forEach> => <core:forEach>
				속성
					*** info : 작성자, 작성일, 무슨 프로그램인지
					language : java (디폴트)
					*** contentType : response.setContentType()
						=> 브라우저에 어떤 형식인지 알려준다
							=> text/html;charset=ISO8859_1 (디폴트)
								=> ISO8859_1 : ASC => 알파벳
							=> contentType="text/html;charset=UTF-8" (한국어 출력을 위하여 필요한 코드)
							=> contentType="text/xml;charset=UTF-8"
							=> contentType="text/plain;charset=UTF-8" => JSON
					extends
					*** import
					session
					buffer
					autoFlush
					isThreadSafe
					trimDirective
					WhiteSpace
					*** errorPage
					*** isErrorPage
					*** pageEncoding
			taglib
			include
		3) 내장 객체
			request
			response
			session
			out
			application
			config
			exception
			page
			pageContext
		4) cookie
		5) JSP 액션 태그 <jsp:include> <jsp:useBean> <jsp:forward> ...
		============================================================= Basic (기본 과정)
		6) 데이터베이스 연동 / 자바빈즈
		7) EL / JSTL
		8) MVC
		============================================================= Middle (중급 과정)
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