<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<%
	EmpModel model=new EmpModel();
	model.empListData(request); // Controller : HTML과 Java를 연결해준다
	// => HTML과 Java를 분리 => HTML(View), Java(Model) => MV 구조
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