<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.sist.dao.*"%>
<%
	GoodsDAO dao=GoodsDAO.newInstance();
	String no=request.getParameter("no");
	GoodsVO vo=dao.goodsDetailData(Integer.parseInt(no));
	//     == vo에 저장된 데이터를 출력 => 상세 보기
%>
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
   width:960px;
}
.a{
	font-size: 15pt;
	font-family: "휴먼모음T";
}
.b{
	font-size: 15pt;
	font-family: "휴먼모음T";
}
.red{
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table table-striped">
				<tr>
					<td width="30%" class="text-center" rowspan="6">
						<img src="<%=vo.getGoods_poster()%>" style="width: 100%" class="img-rounded">
					</td>
					<td colspan="2"><h3><%=vo.getGoods_name()%></h3></td>
				</tr>
				<tr>
					<th class="b">가격</th>
					<td class="a"><%=vo.getGoods_price()%></td>
				</tr>
				<tr>
					<th class="b">할인</th>
					<td class="a red"><%=vo.getGoods_discount()%>%</td>
				</tr>
				<tr>
					<th class="b">첫구매할인가</th>
					<td class="a red"><%=vo.getGoods_first_price()%></td>
				</tr>
				<tr>
					<th class="b">배송가격</th>
					<td class="a"><%=vo.getGoods_delivery()%></td>
				</tr>
				<tr>
					<td colspan="2" class="text-right">
						<input type="button" value="찜하기" class="btn-xs btn-primary">
						<input type="button" value="좋아요" class="btn-xs btn-success">
						<input type="button" value="예약" class="btn-xs btn-info">
						<input type="button" value="목록" class="btn-xs btn-warning"
						onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td>
						<pre style="white-space: pre-wrap;border: none;background-color: white;
						font-size: 16pt;font-family: 휴먼모음T;text-align: center;">
						<%=vo.getGoods_sub()%></pre>
					</td>
				</tr>
			</table>
		</div>
	</div>	
</body>
</html>