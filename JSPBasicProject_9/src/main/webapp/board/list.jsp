<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
	// 실행 => 데이터를 가지고 오기 (자바)
	// 읽어온 데이터를 HTML을 통하여 출력
	//     ===== 사용자가 요청
	EmpDAO dao=EmpDAO.newInstance();
	List<EmpVO> list=dao.empListData();
	
	// 자바 = 오라클 = 자바 = JSP
	// ===============  ====
	//      Model       View
	// Model + View => Controller
%>
<%--
	A a=new A();
	Connection c=new Connection();
		=> c : DBCP
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 600px;
}
h3{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h3>사원 목록</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-center">사번</th>
					<th class="text-center">이름</th>
					<th class="text-center">직위</th>
					<th class="text-center">입사일</th>
					<th class="text-center">성과급</th>
				</tr>
				<%
					for(EmpVO vo:list)
					{
				%>
						<tr>
							<td class="text-center"><%=vo.getEmpno() %></td>
					<td class="text-center"><a href="detail.jsp?empno=<%=vo.getEmpno() %>"><%=vo.getEname() %></a></td>
							<td class="text-center"><%=vo.getJob() %></td>
							<td class="text-center"><%=vo.getHiredate().toString() %></td>
							<td class="text-center"><%=vo.getComm() %></td>
						</tr>
				<%		
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>