<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자가 전송한 값을 받는다 => 한글
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	//                <input type="" name=name>
	String sex=request.getParameter("sex");
	String phone1=request.getParameter("phone1");
	String phone2=request.getParameter("phone2");
	String content=request.getParameter("content");
	String[] hobby=request.getParameterValues("hobby");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>