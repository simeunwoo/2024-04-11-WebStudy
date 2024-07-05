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
						1 page / 1 pages
						<a href="#" class="btn btn-sm btn-primary">다음</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>