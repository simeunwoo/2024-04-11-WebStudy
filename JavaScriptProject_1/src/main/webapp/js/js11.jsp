<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	[] : 배열 => 객체 단위 {}
--%>
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
	width:800px;
}
</style>
<script type="text/javascript">
// window.onload=function(){}와 같은 식 (밑에 것이 요즘 트렌드 (주로 사용))
window.onload=()=>{
//	const sawon={"sabun":1,"name":"홍길동","sex":"남자","dept":"개발부","loc":"서울"}
	// 위 형식 => JSON => 자바스크립트의 객체 표현법
	// SawonVO / 객체 지향 프로그램
/*	document.write("<h1>자바스크립트 객체 출력</h1>")
	document.write("사번 : "+sawon.sabun+"<br>")
	document.write("이름 : "+sawon.name+"<br>")
	document.write("성별 : "+sawon.sex+"<br>")
	document.write("부서 : "+sawon.dept+"<br>")
	document.write("위치 : "+sawon.loc+"<br>") */
	
	const sawon=[
		{"sabun":1,"name":"홍길동","sex":"남자","dept":"개발부","loc":"서울"},
		{"sabun":2,"name":"홍길자","sex":"여자","dept":"영업부","loc":"부산"},
		{"sabun":3,"name":"홍길순","sex":"여자","dept":"자재부","loc":"제주"},
		{"sabun":4,"name":"홍길형","sex":"남자","dept":"총무부","loc":"경주"},
		{"sabun":5,"name":"홍길석","sex":"남자","dept":"영업부","loc":"부산"}
	]
	document.write("<h1>배열 데이터를 for-each를 이용한 출력</h1>")
	document.write("<div class=container>")
	document.write("<div class=row>")
	document.write("<table class=table>")
	document.write("<thead>")
	document.write("<tr>")
	document.write("<th>사번</th>")
	document.write("<th>이름</th>")
	document.write("<th>성별</th>")
	document.write("<th>부서</th>")
	document.write("<th>위치</th>")
	document.write("</tr>")
	document.write("</thead>")
	document.write("<tbody>")
	// for(SawonVO vo:sawon)
	sawon.forEach((vo)=>{
		document.write("<tr>")
		document.write("<th>"+vo.sabun+"</th>")
		document.write("<th>"+vo.name+"</th>")
		document.write("<th>"+vo.sex+"</th>")
		document.write("<th>"+vo.dept+"</th>")
		document.write("<th>"+vo.loc+"</th>")
		document.write("</tr>")
	})
	document.write("</tbody>")
	document.write("</thead>")	
	document.write("</table>")
	document.write("</div>")
	document.write("</div>")
	
	
}
</script>
</head>
<body>

</body>
</html>