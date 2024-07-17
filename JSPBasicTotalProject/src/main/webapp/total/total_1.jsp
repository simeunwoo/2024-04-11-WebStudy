<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP의 실행 과정
	             실행 요청 (톰캣)      자바로 변경
	    a.jsp ================= a_jsp.java

	public class a_jsp extends HttpJspBase
	{
		<%! %>
		public void _jspInit(){}
		public void _jspDestroy(){}
		public void _jspService(HttpServletRequest request,HttpServletResponse response)
		{
			PageContext pageContext;
			HttpSession session=null;
			ServletConetxt application;
			ServletConfig config;
			JspWriter out=null;
			Object page=this;
			============================ JSP의 소스 코딩 (내장 객체 관련)
			<% %> => out.write(HTML)
			<%= %> => out.print()
		}
	}         컴파일
	===================> a_jsp.class
	                         | 한줄씩 읽어서 메모리에 저장
	                      out.write()에 있는 내용만 저장
	                      =========== HTML 태그
	                         | 저장된 HTML을 브라우저에서 읽어서 출력

	            jsp 파일 요청 => URL => request
	  브라우저 ========================> 톰캣	                         
	       <========================
	             요청 처리 후에 응답 HTML => response
	             ====== 자바 코딩

	지시자

		page : JSP에 대한 정보 저장
			1) 변환 => 브라우저에 알림
				contextType="text/html, text/xml, text/plain"
				             =========            ==========
					VO => {}
				    List => [{},{}...]
			2) 외부 라이브러리 => import
			   ========== java.lang, javax.http.servlet 외의 모든 패키지는 import를 사용해야 한다
			   => 사용자 정의도 포함
			3) errorPage : 에러가 있는 경우에 이동하는 파일 지정
			
		taglib : <% %>를 제거하기 위하여 제작된 태그
			=> for/if => 제어문을 태그로 제작
			=> 자바는 사용하지 말고 태그형 문법을 사용한다
	
	자바 표현법
	
	내장 객체
	
	JSP 액션 태그
	
	데이터베이스 연동  
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