<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<%
	// 출력할 데이터를 가지고 온다
	FoodDAO dao=FoodDAO.newInstance();
	List<FoodVO> list=dao.foodListData();
	// JSP = Java / .net = #C / 장고 = ***** python
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