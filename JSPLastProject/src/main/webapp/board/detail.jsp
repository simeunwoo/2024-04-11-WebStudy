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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['사용 단어', '단어 횟수'],
          <c:forEach var="vo" items="${list}">
          	[<c:out value="${vo.word}"/>,<c:out value="${vo.count}"/>],
          </c:forEach>
        ]);

        var options = {
          title: '사용자 데이터 분석'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div class="wrapper row3">
		<main class="container clear">
			<h2 class="sectiontitle">내용 보기</h2>
			<div class="row row1">
				<table class="table">
					<tr>
						<th width="20%" class="text-center">번호</th>
						<td width="30%" class="text-center">${vo.no }</td>
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
					<tr>
						<td colspan="4" class="text-left" valign="top" height="200">
							<pre style="white-space: pre-wrap;background-color: white;border: none">${vo.content }</pre>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="text-right">
							<a href="#" class="btn btn-xs btn-success">수정</a>
							<a href="../board/list.do" class="btn btn-xs btn-warning">목록</a>
							<a href="#" class="btn btn-xs btn-danger">삭제</a>
						</td>
					</tr>
				</table>
			</div>
			<div style="height: 30px"></div>
			<div id="piechart" style="width: 900px; height: 500px;"></div>
		</main>
	</div>
</head>
<body>

</body>
</html>