<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.forward("output.jsp"); // request를 전송
	/*
		forward는 다른 파일에 request를 유지 => URL이 동일 => MVC
		sendRedirect는 request를 초기화한 후에 파일 이동 => URL이 변경
	*/
%>