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
.row1{
	margin: 0px auto;
	width: 960px;
}
</style>
</head>
<body>
	<div class="wrapper row3">
		<main class="container clear">
			<h2 class="sectiontitle">자료실</h2>
			<div class="row row1">
				<table class="table">
					<tr>
						<td>
							<a href="../databoard/insert.do" class="btn btn-sm btn-primary">새 글</a>
						</td>
					</tr>
				</table>
				<table class="table">
					<tr>
						<th width="10%" class="text-center">번호</th>
						<th width="55%" class="text-center">제목</th>
						<th width="10%" class="text-center">이름</th>
						<th width="15%" class="text-center">작성일</th>
						<th width="10%" class="text-center">조회수</th>
					</tr>
					<c:set var="count" value="${count }"/>
					<c:forEach var="vo" items="${list }">
						<tr>
							<td width="10%" class="text-center">${count }</td>
							<td width="55%">
								<a href="../databoard/detail.do?no=${vo.no }">
									${vo.subject }
								</a>
								&nbsp;
								<c:if test="${today==vo.dbday }">
									<sup><img src="../databoard/new.gif"></sup>
								</c:if>
							</td>
							<td width="10%" class="text-center">${vo.name }</td>
							<td width="15%" class="text-center">${vo.dbday }</td>
							<td width="10%" class="text-center">${vo.hit }</td>
						</tr>
						<c:set var="count" value="${count-1 }"/>
					</c:forEach>
				</table>
				<table class="table">
					<tr>
						<td class="text-left inline">
							<form method="post" action="../databoard/find.do">
						 		<input type="checkbox" value="N" name="fs">&nbsp;이름&nbsp;
								<input type="checkbox" value="S" name="fs">&nbsp;제목&nbsp;
								<input type="checkbox" value="C" name="fs">&nbsp;내용&nbsp;
						<!--	Search : <select name="fs">
									<option value="name">이름</option>
									<option value="subject">제목</option>
									<option value="content">내용</option>
								</select> -->
								<input type="text" name="ss" size="15" class="input-sm">
								<input type="submit" value="검색" class="btn btn-sm btn-success">
							</form>
						</td>
						<td class="text-right">
							<a href="#" class="btn btn-sm btn-success">이전</a>
							${curpage } page / ${totalpage } pages
							<a href="#" class="btn btn-sm btn-info">다음</a>
						</td>
					</tr>
				</table>
			</div>
		</main>
	</div>
</body>
</html>