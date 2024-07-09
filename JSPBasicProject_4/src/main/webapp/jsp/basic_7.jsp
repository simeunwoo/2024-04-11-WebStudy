<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	자바 문법 사용
	제어문
		if / if ~ else / if ~ else if ~ else
		while / for / break
		
	if
		=> 관리자 / 일반 사용자 구분
			if(admin==1) => 관리자 페이지
			else => 마이 페이지
	if ~ else if ~ else
		=> 별점 출력
	while
		=> 무한 스크롤
	for
		=> 목록, 페이지
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1 ~ 100 => 짝수합 / 홀수합 / 전체합
		int sum=0,even=0,odd=0;
		for(int i=1;i<=100;i++)
		{
			sum+=i;
			if(i%2==0)
				even+=i;
			else
				odd+=i;
		}
	%>
	<%= "1~100 사이의 총합:"+sum %><br>
	<%= "1~100 사이의 짝수합:"+even %><br>
	<%= "1~100 사이의 홀수합:"+odd %><br>
</body>
</html>