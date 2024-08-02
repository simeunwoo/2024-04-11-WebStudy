<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	내장 객체
	String : 자바와 유사
		*** 1) substring()
		*** 2) trim()
		3) replace()
		*** 4) split()
		5) indexOf()
		6) slice()
	Math
		1) random
		2) round
	Array
		1) push()
		2) pop()
		3) sort()
		4) slice
	Date
		get
		
	Date => 날짜, 시간을 관리하는 내장 객체
	let today=new Date()
	today.getFullYear() : 연도 읽기
	today.getmonth()+1 : 월
	today.getDate()
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=()=>{
	let today=new Date() // 클래스형
	/*
		class Sawon{
			init:function()
		}
		class => function
		react => class => function(hooks)
	*/
	let year=today.getFullYear()
	let month=today.getMonth()+1
	let day=today.getDate()
	let week=today.getDay()
	let strWeek=["일","월","화","수","목","금","토"]
	
	document.write(year+"년 "+month+"월 "+day+"일 "+strWeek[week]+"요일")
}
</script>
</head>
<body>

</body>
</html>