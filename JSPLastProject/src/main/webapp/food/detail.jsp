<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="wrapper row3">
	<main class="container clear">
		<h2 class="sectiontitle">내용 보기</h2>
		<div class="flexslider carousel basiccarousel btmspace-80">
	      <ul class="slides">
	        <li>
		        <c:forEach var="vo" items="${jjimList }">
		          <figure>
		          	<img class="radius-10 btmspace-10" src="http://menupan.com${vo.poster }" style="width:320px;height:185px">
		            <figcaption><a href="#">${vo.name }</a></figcaption>
		          </figure>
	          </c:forEach>
	        </li>
	      </ul>
	    </div>
	</main>
</div>
</body>
</html>