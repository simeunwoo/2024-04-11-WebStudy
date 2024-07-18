<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	prefix : 접두사 기능

	prefix="c"
		=> <c:
	prefix="core"
		=> <core:
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
	(598page)
	
	JSTL (JSP Standard Tab Library)
		=> 태그로 제어문, String, 날짜, 숫자 변환 ... 화면 이동 => jstl-1.2.jar
		=> 자바 문법을 태그로 제작
		=> EL / JSTL => JSP 화면 출력
		
		1. core : 제어문, 변수 선언, 화면 이동
			제어문
				=> 반복문
					<c:forEach>
						=> 속성 : begin(시작), end(끝), step(증가) => 감소는 없다
						
						for(int i=1;i<=10;i++)
						=> <c:forEach var="i" begin="1" end="10" step="1">
						=> step="1"일 경우 생략 가능
						=> end="10"은 10을 포함한다는 뜻 (10까지 포함)
						
						for(FoodVO vo:list)
						=> <c:forEach var="vo" items="list">
						=> StringTokenizer st=new StringTokenizer()
							=> <c:forTokens var="s" value="red,blue,green" delimit=",">
								=> delimit : 구분자
				=> 조건문
					<c:if> : 단점은 else가 없다
				=> 선택문
					<c:choose>
					  <c:when></c:when>
					  <c:when></c:when>
					  <c:otherwise></c:otherwise> => default
					</c:choose>
					
		2. fmt : 날짜 변환, 숫자 변환
		
		3. fn : String 메소드를 처리
		
		========
		4. xml
		
		5. sql
		======== 노출 => 순수 자바 (DAO)
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>일반 자바 for문</h3>
	<%
		for(int i=1;i<=10;i++)
		{
	%>
			<%=i %>&nbsp;
	<%
		}
	%>
	<h3>JSTL forEach문</h3>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i }&nbsp;
	</c:forEach>
</body>
</html>