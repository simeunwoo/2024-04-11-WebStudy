<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	사용자 == 데이터 전송
	       ========
	       ?변수=값 => GET
	       <form> => submit => POST
	       ========================= request에 값을 모아서 전송
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="save_1.jsp">
		ID:<input type=text name=id size=15><br>
		PWD:<input type=password name=pwd size=15><br>
		<input type=submit value="전송">
	</form>
</body>
</html>