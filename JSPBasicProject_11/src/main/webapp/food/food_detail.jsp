<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
	String fno=request.getParameter("fno");
	FoodDAO dao=FoodDAO.newInstance();
	FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
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
</style>
</head>
<body>
	<div class=container>
		<h3 class="text-center"><%=vo.getName() %></h3>
		<div class=row>
			<table class=table>
				<tbody>
					<tr>
						<td class="text-center">
							<img src="<%=vo.getPoster()%>" style="width:600px;height:400px">
						</td>
					</tr>
					<tr>
						<td><%=vo.getContent() %></td>
					</tr>
					<tr>
						<td><address><%=vo.getAddress() %></address></td>
					</tr>
					<tr>
						<td class="text-right">
							<a href="food_list.jsp" class="btn btn-xs btn-primary">목록</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>