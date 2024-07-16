<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies=request.getCookies();
	if(cookies!=null)
	{
		for(int i=0;i<cookies.length;i++)
		{
			cookies[i].setPath("/"); // 저장 위치 확인
			cookies[i].setMaxAge(0); // 삭제
			response.addCookie(cookies[i]);
			break;
		}
	}
	response.sendRedirect("list.jsp");
%>