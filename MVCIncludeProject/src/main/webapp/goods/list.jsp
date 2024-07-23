<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.col-sm-3{
	white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="row">
		<h3>상품 목록</h3>
				<c:forEach var="vo" items="${list }" begin="0" end="11">
				<div class="col-sm-3">
				<tr>
		
					<a href="../goods/detail.do?no=${vo.no }">
						<div class="thumbnail">
							<img src="${vo.poster }" style="width: 240px;height: 200px" class="img-rounded">
							<p class="a">${vo.name }</p>
						</div>
					</a>
			
				</tr>
				</div>
				</c:forEach>
	</div>
	<div style="height: 20px"></div>
	<div class="row">
		<div class="text-center">
			<a href="../goods/list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
				${curpage } page / ${totalpage } pages
			<a href="../goods/list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
		</div>
	</div>
</body>
</html>