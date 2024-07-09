<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		<%
			주석 : //, /* */ => <c:for> : 태그형
		%>
		<%!
			자바 문법을 적용
			주석 : //, /* */
			문장이 종료 => ; 사용
		%>
		out.print(); => $()
			=> 괄호 안에 <%= %>이 들어간다
			ex) out.print("Hello"); => <%="Hello" %>
			=> ;을 사용하지 않는다
 --%>
<%!
	// 선언문 => 노출이 된다 => 거의 사용하지 않고 => 클래스를 직접 만들어서 사용
	public int add(int a,int b)
	{
		return a+b;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int res=add(10,20);
		out.print(res); // 서블릿 => 복잡한 자바 코딩이 있는 경우
	%>
	<%=res%> <%-- JSP --%>
	<%--
		<% <% => 중복 사용 불가
		
		ex)
			<%
			if()
			{
			%>
			<%
			}
			else if()
			{
			%>
			<%
			}
			else if()
			{
			%>
			<%
			}
			else
			{
			%>
			<%
			}
			%>
			
			=========> 요거보다는 out.println() 쓰는 게 훨씬 편리할 것
	 --%>
</body>
</html>