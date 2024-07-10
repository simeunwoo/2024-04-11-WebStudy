<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String mode=request.getParameter("mode");
	String jsp="";
	if(mode==null)
		mode="0";
	int index=Integer.parseInt(mode);
	switch(index)
	{
	case 0:
		jsp="home.jsp";
		break;
	case 1:
		jsp="join.jsp";
		break;
	case 2:
		jsp="idfind.jsp";
		break;
	case 3:
		jsp="passwordfind.jsp";
		break;
	case 4:
		jsp="send.jsp";
		break;
	case 5:
		jsp="mypage.jsp";
		break;
	case 6:
		jsp="recv.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <style type="text/css">
 .row{
 	margin: 0px auto;
 	width: 960px;
 }
 </style>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
	<jsp:include page="<%=jsp %>"></jsp:include>
	</div>
</body>
</html>