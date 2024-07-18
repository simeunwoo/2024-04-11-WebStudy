<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.vo.*"%>
<%
	SawonVO vo=new SawonVO();
	vo.setSabun(17);
	vo.setName("홍길동");
	vo.setDept("개발부");
	vo.setJob("사원");
	vo.setPay(3000);
	
	request.setAttribute("vo1", vo);
	// ${} => request나 session에 있는 값만 출력
	// "vo" => 객체명이 아니라 키명
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL => 객체 출력 방법</h1>
	<%=((SawonVO)request.getAttribute("vo1")).getSabun() %><br>
	사번 : ${vo1.sabun },${vo1.getSabun() }<br>
	이름 : ${vo1.name },${vo1.getName() }<br>
	부서 : ${vo1.dept },${vo1.getDept() }<br>
	직위 : ${vo1.job },${vo1.getJob() }<br>
	연봉 : ${vo1.pay },${vo1.getPay() }
	<%--
	(결과값)
	17
	사번 : 17,17
	이름 : 홍길동,홍길동
	부서 : 개발부,개발부
	직위 : 사원,사원
	연봉 : 3000,3000
	--%>
</body>
</html>