<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<% 
	// 사용자가 보내준 값을 받는다 => 페이지 => request.getParameter()
	String strPage=request.getParameter("page");
	// 보내준 값을 이용하여 => 오라클 연결
	BoardDAO dao=BoardDAO.newInstance();
	// 오라클로부터 사용자가 요청한 데이터를 받는다
	if(strPage==null)
		strPage="1";
	int curpage=Integer.parseInt(strPage); // 현재 보여주는 페이지 번호
	// 가지고 온 데이터를 화면에 출력
	List<BoardVO> list=dao.boardListData(curpage);
	// 총 페이지
	int count=dao.boardTotalPage();
	int totalpage=(int)(Math.ceil(count/10.0));
	
	count=count-((curpage*10)-10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 30px;
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
		<h3>자유 게시판</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<a href="board_insert.jsp" class="btn btn-xs btn-danger">새 글</a>
					</td>
				</tr>
			</table>
			<table class="table table-striped">
				<tr>
					<th width="10%" class="text-center">번호</th>
					<th width="45%" class="text-center">제목</th>
					<th width="15%" class="text-center">이름</th>
					<th width="20%" class="text-center">작성일</th>
					<th width="10%" class="text-center">조회수</th>
				</tr>
				<%
					for(BoardVO vo:list)
					{
				%>
						<tr>
							<td width="10%" class="text-center"><%=count-- %></td>
							<td width="45%">
								<a href="board _detail.jsp?no=<%=vo.getNo()%>"><%=vo.getSubject() %></a>
								<%
									String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
									if(today.equals(vo.getDb_day()))
									{
								%>
										&nbsp;<sup style="color:red">new</sup>
								<%		
									}
								%>
							</td>
							<td width="15%" class="text-center"><%=vo.getName() %></td>
							<td width="20%" class="text-center"><%=vo.getDb_day() %></td>
							<td width="10%" class="text-center"><%=vo.getHit() %></td>
						</tr>
				<%		
					}
				%>
			</table>
			<table class="table">
				<tr>
					<td class="text-left">
						<select class="input-sm">
							<option>이름</option>
							<option>제목</option>
							<option>내용</option>
						</select>
						<input type=text size=15 class="input-sm">
						<input type=submit value="검색" class="btn-sm btn-success">
					</td>
					<td class="text-right">
						<a href="#" class="btn btn-sm btn-primary">이전</a>
						<%=curpage %> page / <%=totalpage %> pages
						<a href="#" class="btn btn-sm btn-primary">다음</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>