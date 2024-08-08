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
			<h2 class="sectiontitle">내용 보기</h2>
			<div class="row row1">
				<table class="table">
					<tr>
						<th width="20%" class="text-center">번호</th>
						<td width="30%" class="text-center del_no">${vo.no }</td>
						<th width="20%" class="text-center">작성일</th>
						<td width="30%" class="text-center">${vo.dbday }</td>
					</tr>
					<tr>
						<th width="20%" class="text-center">이름</th>
						<td width="30%" class="text-center">${vo.name }</td>
						<th width="20%" class="text-center">조회수</th>
						<td width="30%" class="text-center">${vo.hit }</td>
					</tr>
					<tr>
						<th width="20%" class="text-center">제목</th>
						<td colspan="3">${vo.subject }</td>
					</tr>
					<c:if test="${vo.filesize>0 }">
						<tr>
							<th width="20%" class="text-center">첨부 파일</th>
							<td colspan="3">${vo.filename }(${vo.filesize }Bytes)</td>
						</tr>
					</c:if>
					<%--
						데이터베이스 : Update, Delete
						업로드된 파일
					--%>
					<tr>
						<td colspan="4" class="text-left" valign="top" height="200">
							<pre style="white-space: pre-wrap;background-color: white;border: none">${vo.content }</pre>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="text-right">
							<a href="../databoard/update.do?no=${vo.no }" class="btn btn-xs btn-success">수정</a>
							<a href="../databoard/list.do" class="btn btn-xs btn-warning">목록</a>
							<span class="btn btn-xs btn-danger" id="delBtn">삭제</span>
						</td>
					</tr>
					<tr id="delTr" style="display: none">
						<td colspan="4" class="text-right inline">
							비밀 번호 : <input type="password" id="del_pwd" class="input-sm" size="10">
							<input type="button" value="삭제" class="btn-warning btn-sm" id="deleteBtn">
						</td>
					</tr>
				</table>
			</div>
		</main>
	</div>
</body>
</html>