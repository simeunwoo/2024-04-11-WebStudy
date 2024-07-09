<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 생명 주기
		=> _jspInit() : web.xml에 환경 설정 : 생성자와 동일한 역할
		=> _jspService() : doGet()/doPost() => 통합 (조건문)
		  ============== JSP에서 코딩한 소스가 메소드 안에 첨부
		                 =========================== _jspService()를 제작
		=> _jspDestroy() : 메모리 해제

	public void _jspService(HttpServletRequest request, HttpServletResponse response)
	{
	    PageContext pageContext;
	    HttpSession session = null;
	    ServletContext application;
	    ServletConfig config;
	    JspWriter out = null;
	    Object page = this;	
	}
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>