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
<script type="text/javascript">
// window.onload=function(){}와 같은 식 (밑에 것이 요즘 트렌드 (주로 사용))
window.onload=()=>{
	const sawon={"sabun":1,"name":"홍길동","sex":"남자","dept":"개발부","loc":"서울"}
	// 위 형식 => JSON => 자바스크립트의 객체 표현법
	// SawonVO / 객체 지향 프로그램
	document.write("<h1>자바스크립트 객체 출력</h1>")
	document.write("사번 : "+sawon.sabun+"<br>")
	document.write("이름 : "+sawon.name+"<br>")
	document.write("성별 : "+sawon.sex+"<br>")
	document.write("부서 : "+sawon.dept+"<br>")
	document.write("위치 : "+sawon.loc+"<br>")
}
</script>
</head>
<body>

</body>
</html>