<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top:50px;
}
.row{
	margin:0px auto;
	width:350px;
}
</style>
</head>
<body>
	<div class="container">
		<h3>${vo.ename }</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td>사번</td>
					<td>${vo.empno }</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${vo.ename }</td>
				</tr>
				<tr>
					<td>직위</td>
					<td>${vo.job }</td>
				</tr>
				<tr>
					<td>사수</td>
					<td>${vo.mgr }</td>
				</tr>
				<tr>
					<td>입사일</td>
					<td>${vo.hiredate }</td>
				</tr>
				<tr>
					<td>급여</td>
					<td>${vo.sal }</td>
				</tr>
				<tr>
					<td>성과급</td>
					<td>${vo.comm }</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>