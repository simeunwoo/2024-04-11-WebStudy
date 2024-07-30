<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	배열 : [], 객체 : {}
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
let sawons=[
	{sabun:1,name:"홍길동",dept:"개발부",job:"대리",pay:3600,loc:"부산"},
	{sabun:2,name:"노홍철",dept:"임원",job:"회장",pay:15000,loc:"서울"},
	{sabun:3,name:"춘향이",dept:"개발부",job:"차장",pay:6000,loc:"부산"},
	{sabun:4,name:"심청이",dept:"임원",job:"CEO",pay:15000,loc:"서울"},
	{sabun:5,name:"정형돈",dept:"총무부",job:"부장",pay:7500,loc:"대전"},
	{sabun:6,name:"강감찬",dept:"자재부",job:"사원",pay:3000,loc:"광주"},
	{sabun:7,name:"유재석",dept:"기획부",job:"인턴",pay:1000,loc:"인천"},
	{sabun:8,name:"정준하",dept:"재정부",job:"이사",pay:8800,loc:"울산"},
	{sabun:9,name:"호날두",dept:"총무부",job:"사원",pay:3000,loc:"대전"},
	{sabun:10,name:"메시",dept:"기획부",job:"사원",pay:3000,loc:"인천"}
]
// 데이터 출력
const sawonList=()=>{
	console.log(sawons)
}
const sawonInsert=()=>{
	sawons.push({sabun:11,name:"정몽규",dept:"자재부",job:"인턴",pay:0,loc:"광주"})
}
const sawonDetail=(sabun)=>{
	let sawon=sawons.find(sa=>sa.sabun==sabun)
	console.log(sawon)
}
window.onload=()=>{
//	sawonList()
//	sawonInsert()
//	sawonList()
	sawonDetail(3)
	/*
		push => 데이터 추가
		pop => 마지막 데이터 삭제
		length => 개수
		find() => 검색
		slice() => 원하는 위치부터 복제
		=> [] => Array
	*/
}
</script>
</head>
<body>

</body>
</html>