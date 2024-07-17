<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CartVO> list=(List<CartVO>)session.getAttribute("cart");
	List<CartVO> mList=new ArrayList<CartVO>();
	String id=(String)session.getAttribute("id");
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
	width: 800px;
}
h3{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h3></h3>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th class="text-center"></th>
						<th class="text-center">상품명</th>
						<th class="text-center">가격</th>
						<th class="text-center">수량</th>
						<th class="text-center">취소</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
</html>