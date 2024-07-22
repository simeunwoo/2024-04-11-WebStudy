<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h3>답변형 게시판</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<a href="insert.do" class="btn btn-sm btn-warning">새글</a>
					</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<th width="10%" class="text-center">번호</th>
					<th width="45%" class="text-center">제목</th>
					<th width="15%" class="text-center">이름</th>
					<th width="20%" class="text-center">작성일</th>
					<th width="10%" class="text-center">조회수</th>
				</tr>
				<c:set var="count" value="${count }"/>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td width="10%" class="text-center">${count }</td>
						<td width="45%">
							<c:if test="${vo.group_tab>0 }">
								<c:forEach var="i" begin="1" end="${vo.group_tab }">
									&nbsp;&nbsp;
								</c:forEach>
								<img src="re.icon.png">
							</c:if>
							${vo.subject }
							&nbsp;
							<c:if test="${vo.dbday==today }">
								<sup><img src="new.gif"></sup>
							</c:if>
						</td>
						<td width="15%" class="text-center">${vo.name }</td>
						<td width="20%" class="text-center">${vo.dbday }</td>
						<td width="10%" class="text-center">${vo.hit }</td>
					</tr>
				<c:set var="count" value="${count-1 }"/><%-- count-- --%>
				</c:forEach>
			</table>
			<table class="table">
				<tr class="text-center">
					<td>
						<a href="#" class="btn btn-sm btn-success">이전</a>
							${curpage } page / ${totalpage } pages
						<a href="#" class="btn btn-sm btn-success">다음</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>