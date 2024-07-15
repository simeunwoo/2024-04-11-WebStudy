<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
	String strPage=request.getParameter("page");
	if(strPage==null)
		strPage="1";
	
	int curpage=Integer.parseInt(strPage);
	
	// DB 연동
	SeoulDAO dao=SeoulDAO.newInstance();
	List<LocationVO> list=dao.seoulLocationListData(curpage);
	int totalpage=dao.seoulLocationTotalPage();
	
	final int BLOCK=10;
	int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	
	if(endPage>totalpage)
		endPage=totalpage;
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
	width: 960px;
}
.a{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<%
				for(LocationVO vo:list)
				{
			%>
					<div class="col-sm-3">
						<div class="thumbnail">
							<a href="">
								<img src="<%=vo.getPoster() %>" style="width:240px;height:200px">
								<p class="a"><%=vo.getTitle() %></p>
							</a>
						</div>
					</div>
			<%
				}
			%>
		</div>
	</div>
	<div class="row">
		<div class="text-center">
			<ul class="pagination">
				<%
					if(startPage>1) // 1 11 21 ...
					{
				%>
						<li><a href="list.jsp?page=<%=startPage-1%>">&lt;</a></li>
				<%
					}
					for(int i=startPage;i<=endPage;i++)
					{
				%>
						<li class="<%=i==curpage?"active":""%>"><a href="list.jsp?page=<%=i%>"><%=i %></a></li>
				<%
					}
					if(endPage<totalpage) // 10 20 30 ...
					{
				%>
						<li><a href="list.jsp?page=<%=endPage+1%>">&gt;</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<div style="height:20px"></div>
		<div class="row">
			<h3>최근 방문 서울 여행</h3>
			<hr>
		</div>
	</div>
</body>
</html>