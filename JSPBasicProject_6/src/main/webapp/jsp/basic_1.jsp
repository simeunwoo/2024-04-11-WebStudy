<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. JSP 동작 구조
        사용자 (클라이언트) : 브라우저 => 서버로 요청 (URL 주소 이용) => 파일 요청
                                         =========== 마지막에 파일 첨부
                       http://localhost/JSPBasicProject_6/jsp/basic_1.jsp
                                                              ===========
                                                              => 확장자 변경이 가능
		서버 : 톰캣 => 요청을 받아서 (자바로 받음) => 요청 처리 => HTML을 브라우저로 전송
		브라우저 : URL 전송 ===========> DNS
			http://localhost =====> IP 변환 127.0.0.1
			http://www.daum.net =====> 121.53.105.193 : Socket을 이용하여 서버에 연결
            IP 변환 => 서버 연결
                     =======
                     = HTML / XML / JSON => 서버에서 단독 처리
                     = JSP / SERVLET
                       =============
                             |
                           Tomcat (WAS) => Web Application Server
                             |
                            자바 번역 => HTML 변환
                                     =========
                                     메모리를 브라우저에서 읽어서 출력할 수 있게 보내주는 역할
		자바 번역
		======
		JSP => 클래스화
		a.jsp =====> class a_jsp extends HttpJspBase
		=====        {
		 소스				<%! 메소드, 멤버 변수 %> 선언식
		=====			public void _jspInit(){}
						public void _jspDestroy(){}
						public void _jspService(){}
							jsp에서 작성한 소스
							<% %>
							<%= %>
							HTML은 out.write("<html>")
		             }
		1) 클래스 만들기 => 한번만 만든다 => 변경 => 만들어진 클래스를 수정
		2) 컴파일 => .class
		3) .class을 한줄씩 읽어서 => out.write() => 메모리에 저장
		                                      =========
		                                      buffer : 임시 저장 장소
		                                      ====== 사용자 한명당 1개만 생성
		4) 메모리에 출력된 내용을 브라우저에서 읽어서 출력
			=> tomcat / regin / 웹로직 / 웹스페어 / 제우스 : WAS 종류
			   ======                         ====
			      |                             |
			      ===============================
			             가장 많이 사용하는 WAS
			             
	2. 실행 순서
		1) JSP 제작
		2) 사용자 요청 => JSP 파일 요청
		3) 톰캣 => 클래스화
		4) 클래스 => 컴파일 .class
		5) .class를 읽기 시작
		   = _jspInit() => 환경 설정, 멤버 변수 초기화
		                   =================== web.xml
		   = _jspService() => 요청 처리 => 브라우저 실행
		   = _jspDestroy() => 새로고침, 화면 이동 => 자동으로 jsp는 메모리에서 해제
		   = 서버
		   	서버 연결 => 통신을 할 수 있게 쓰레드를 생성
		   	====== 클라이언트가 한개씩 연결
		   	서버 == 클라이언트 1
		   	서버 == 클라이언트 2
		   	서버 == 클라이언트 3
		   	...
		   	=> _jspService() 쓰레드 메소드 (run())
		   		=> 서버에 데이터 전송
		   		   ============ .getBytes() => 서버 => 1byte씩 전송 => Encoding => ASC (아스키 코드 : 1byte)
		   		   ============ InputStreamReader() => 2byte씩 전송 => Decoding
		   		                ===================
		   		                request.setCharacterEncoding("UTF-8")
		   		                                             =======
		   		                                             = Unicode Transfor Format
		   		                                             => Unicode : 2byte
		   		                                             
	3. HTML과 자바 구분
		<% %> : 일반 자바 소스 => 지역 변수 선언, 연산자, 제어문, 메소드 호출
				문법 사항이 자바와 동일
				문장 종료 => ; 사용
				주석
				=> // : 한줄 주석
				=> /* */ : 여러줄 주석
		<%= %> : out.print(출력물) => 변수를 출력할 때 사용
		                     |
		                   <%= %> => ${} => ;을 사용하면 안된다, /* */ 사용 가능
		<%! %> : 메소드 제작, 멤버 변수 선언
		
	4. 지시자 (5장)
		= page : JSP 파일에 대한 정보
			1) contentType => 브라우저에 어떤 형식인지 알려준다
				HTML / XML / JSON
				=> HTML => text/html;charset=UTF-8
				=> XML => text/xml;charset=UTF-8
				=> JSON => text/plain;charset=UTF-8
				   ====> List, VO
				   ====> JsonResponse() => 파이썬
			2) import => 라이브러리 / 사용자 정의 클래스
				=> 다른 속성은 1번만 사용 가능
				=> import는 여러번 사용 가능
					<%@ page import="java.util.*,java.io.*" %>
					<%@ page import="java.util.*" %>
					<%@ page import="java.io.*" %>
			3) errorPage : error 시에 error 파일을 만들어서 보여주는 역할
				404 : 파일이 없는 경우
				500 : 컴파일 시 에러 => 자바에서 오류 발생
				405 : GET/POST가 틀린 경우
				412 : bad request : 데이터를 잘못 보낸 경우
					ex) int => boolean (보내는 것과 받는 것이 매칭이 안됨)
					JSP에서는 없다 / 주로 스프링에서 있다
						<input type=text name=name>
						<input type=text name=addr>
						<input type=text name=tel>
						
						# JSP
						String name=request.getParameter("name")
						String addr=request.getParameter("addr")
						String tel=request.getParameter("tel")
						
						# Spring
						public String join(String name,String addr,int tel)
						=> public String join(MemberVO vo)
				403 : 접근 거부 (스프링) => 권한 부여 관련
				200 : 정상 수행
			4) buffer : 디폴트 (8kb) => buffer="16kb" => HTML을 저장하는 메모리 공간
		= include : 정적 => 소스를 통합한 후에 컴파일
			=> 메뉴 / Footer
			<%@ include file="" %>
			JSP 안에 특정 부분에 다른 JSP를 포함 => 조립식 느낌
		= taglib => (20장)
			*** <%@ 지시자 속성="값" %> => ""를 반드시 사용한다
	
	5. 액션 태그 (6장)
		(151page)
		1) <jsp:>
			*** <jsp:include> : 스프링에서도 사용 => tiles (사라졌다)
				=> JSP 안에 다른 JSP를 연결 => 동적
					=> 파일을 컴파일한 후에 => 결과 (HTML) => HTML을 묶어주는 역할0
			==================
			<jsp:useBean> : 객체 메모리 할당
				BoardDAO dao=new BoardDAO()				=> A
				<jsp:useBean id="dao" class="BoardDAO"> => B => A와 B는 동일한 코딩
					id="dao" : 객체명
			<jsp:forward> : 화면 이동
				sendRedirect() : 새로운 화면 => new
					request에 존재하는 데이터가 사라진다 => 초기화
				forward() : 기존의 화면에 데이터만 변경
					request에 존재하는 데이터를 사용할 수 있다
			<jsp:setProperty> : 사용자가 보내준 데이터를 받는 경우
			<jsp:getProperty> : 사용자가 보내준 데이터를 출력
			================== JSP에서만 사용
	6. 내장 객체 (7장)
	
		6-1. 데이터베이스 연결
		
	7. Cookie
	
	8. 에러 처리
	
	================= Basic
	
	9. EL / JSTL
	
	10. ***** MVC (Model View Controller) (실무)
		Java : DAO, Model, VO, Manager, Service
		JSP : HTML, CSS, JavaScript => View
		========================================= Servlet : 연결 프로그램 => Controller
		
	================= Middle
	
	11. Spring
	
	12. Spring-Boot
	
	================= High (고급)
	
	=> Front (JavaScript)
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