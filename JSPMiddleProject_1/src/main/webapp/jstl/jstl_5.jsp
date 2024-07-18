<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	<c:forTokens>
	
	List, 배열이 2개인 경우 처리 방법
	
	<fmt:formatDate value="regdate" pattern="yyyy-MM-dd"/>
		=> SimpleDateFormat
	<fmt:formatNumber value="price" pattern="##,###,###"/>
		=> DecimalFormat
	<c:forTokens>
		=> StringTokenizer
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바 : String Tokenizer</h1>
	<ul>
		<%
			String color="red,blue,yellow,black,green,pink,magenta";
			StringTokenizer st=new StringTokenizer(color,",");
			while(st.hasMoreTokens())
			{
		%>
				<li><%=st.nextToken() %></li>
		<%		
			}
		%>	
	</ul>
	<h1>JSTL : &lt;c:forTokens&gt;</h1>
	<ul>
		<c:forTokens var="a" items="red,blue,yellow,black,green,pink,magenta"
		delims=",">
			<li>${a }</li>
		</c:forTokens>
	</ul>
</body>
</html>