<%@page import="java.util.List"%>
<%@page import="com.sist.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 보내준 값 받기
	String no=request.getParameter("no");
	String pwd=request.getParameter("pwd");
	
	// 데이터베이스 연동
	BoardDAO dao=BoardDAO.newInstance();
	boolean bCheck=false;
	// 이동
	if(bCheck==false)
	{
		out.println("<script>");
		out.println("alert(\"비밀 번호가 틀립니다\");");
		out.println("history.back()");
		out.println("</script>");
	}
	else
	{
		response.sendRedirect("board_list.jsp");
	}
%>