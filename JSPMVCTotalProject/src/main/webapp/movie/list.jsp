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
	width:800px;
}
h3{
	text-align:center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="text-center">
				<a href="list.do?type=1" class="btn btn-lg btn-success">일별 박스오피스</a>
				<a href="list.do?type=2" class="btn btn-lg btn-info">실시간 예매율</a>
				<a href="list.do?type=3" class="btn btn-lg btn-warning">좌석 점유율</a>
			</div>
			<h3>${title }</h3>
		</div>
	</div>
</body>
</html>