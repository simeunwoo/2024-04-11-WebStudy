<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<jsp:useBean id="model" class="com.sist.model.BoardModel"/>
<%
	model.boardDetailData(request);
	// EL : 출력 / JSTL : 제어
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 600px;
}
h3{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h3>내용 보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width="20%" class="text-center"></th>
					<td width="30%" class="text-center"></td>
					<th width="20%" class="text-center"></th>
					<td width="30%" class="text-center"></td>
				</tr>
				<tr>
					<th width="20%" class="text-center"></th>
					<td width="30%" class="text-center"></td>
					<th width="20%" class="text-center"></th>
					<td width="30%" class="text-center"></td>
				</tr>
				<tr>
					<th width="20%" class="text-center"></th>
					<td width="30%" class="text-center"></td>
					<th width="20%" class="text-center"></th>
					<td width="30%" class="text-center"></td>
				</tr>
				<tr>
					<th width="20%" class="text-center"></th>
					<td colspan="3"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>