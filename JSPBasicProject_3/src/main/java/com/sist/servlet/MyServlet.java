package com.sist.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	http://localhost/JSPBasicProject_3/MyServlet
 *                                     ==========
 *                                     서블릿은 URL => 파일명 변경
 *  URL을 입력하고 => 웹 서버에 요청
 *                   ==========
 *                   HTML / XML / JSON => 바로 처리 (브라우저로 전송)
 *                   Java (Servlet), JSP => WAS (Web Application Server)
 *                         =======               ====================== Tomcat
 *                         .java => 컴파일 .class         a.jsp
 *                         한줄씩 번역 => 인터프리터
 *                         =======
 *                         out.write("") => 메모리에 출력
 *                                          =========
 *                                          요청한 브라우저에서 읽어서 화면 출력
 *      파일 한개에 데이터 변경이 가능 => 동적 페이지
 *      예) 페이지가 100페이지
 *         =============
 *         서블릿 / JSP는 한개의 파일로 제작 => 데이터만 변경
 *         HTML => 파일을 100개를 만든다 => 정적 페이지 (데이터 변경이 안된다)
 *         
 *		인터프리터
 *			1. 서블릿 파일 로딩
 *			2. init()
 *			3. service() => doGet() / doPost()
 *			4. 서블릿이 종료 (새로 고침, 화면 이동) => destroy() 호출
 *
 *		a.jsp
 *			1. 클래스로 변경 => class a_jsp => a_jsp.java
 *			2. 컴파일 => a_jsp,class => 서블릿
 *
 *		서블릿 (Servlet) => (72page)
 *			=> Server + let => 서버에서 실행되는 가벼운(경량=>스프링) 프로그램
 *			=> Server + Applet(Application+let)
 *				Applet => 자바가 발전하게 함
 *				=> 웹 => 정보 공유 목적 (1995 이전 => 문자로만 출력)
 *			=> 웹 서비스 기능을 해주는 자바 클래스
 *				=> 자바 안에 HTML 코드를 첨부 (JSP => HTML 안에 Java를 첨부)
 *					out.write("<html>") => <% %> <html>
 *				=> 단점
 *					1. HTML을 사용하기 어렵다 (복잡) => CSS / JavaScript => 화면 UI는 하지 않는다
 *						out.write("<html>")
 *						out.write("<head>")
 *						out.write("<script type=\"text/javascript\">")
 *						out.write("<function aaa(){>")
 *						out.write("alert(\"\");")
 *						out.write("}")
 *						out.write("</script>")
 *						out.write("</head>")
 *						out.write("</html>")
 *					2. HTML / CSS / JavaScript에 대한 에러 처리가 어렵다
 *					3. 확장자가 java => 변경 시마다 컴파일을 다시 해야 한다
 *						=> 톰캣 연결
 *						=> 톰캣 프로젝트 => 변경 : 컴파일 => 톰캣에 올려준다
 *						=> AWS => 수정 시마다 컴파일 => war 파일을 변경해야 된다
 *						   ========================================
 *                          운영 (SE) => SI / SM
 *                          =================== 통합 DevOps => CI / CD
 *						=> 버튼 색상 변경
 *						=> 개발자 => 수정 시에 바로 확인 => JSP
 *				=> 장점
 *					Java => 배포 시에 .class 파일만 전송 => 보안이 뛰어나다
 *                          =====================
 *                          전체 소스를 볼 수 없다
 *                          다른 사람이 변경이 불가능
 *                  주로 사용처 : HTML/Java 분리가 된 경우 => 연결 역할 => Controller
 *                            =============================     | 스프링은 이미 제작 (서블릿)
 *				=> 단점 보완
 *					=> 수정과 동시에 확인이 가능하게 만들어 준다 : JSP
 *					=> HTML/CSS/JavaScript => 사용이 쉽게
 *						out.write("<html>") => html (간편화, 나머지는 톰캣에 의해 자동으로 생성됨)
 *					=> HTML 기반 => 필요한 자바 <% %> <%= %>
 *					=> 실행은 톰캣에 의하여 실행된다
 *					=> 실행과 동시에 저장
 *					=> 보안이 취약하다 (소스 전체를 전송) => 서블릿을 병행
 *						서블릿 => 웹과 관련된 라이브러리는 서블릿으로 되어 있다
 *
 *       Java => SUN => package => javax => tomcat 9
 *               ===
 *               오라클 => package => jakarta => tomcat 10 이상
 *               STS 3.9 => jdk 11 => 실무 : 1.8 (호환성이 굿)
 *               STS 4.x => jdk 17
 *               => 전자 정부 프레임워크 (공기업) / ANY 프레임워크 (대기업 => STS 3.x)
 *               => 서버 분산 (MSA) => Spring Cloud
 *
 *		서블릿의 실행 과정
 *		============
 *		URL 주소를 이용하여 전송 => 톰캣
 *		=> 톰캣에 의하여 실행
 *			init() : 자바에서 main()
 *			doGet() / doPost() : 클라이언트마다 따로 동작 => 쓰레드
 *          ================== run()
 *			destroy()
 */

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// _jspInit() : 초기화 (생성자 역할) => 멤버 변수 초기화, 시작과 동시에 처리
		// 환경 설정 (web.xml) => 등록된 내용을 읽어 올 때
		// web.xml => 스프링은 라이브러리 => 환경 설정 => 등록
		// => 서블릿 등록, 보안 설정, 에러 설정, 한글 처리
		System.out.println("MyServlet:init(ServletConfig config) Call ...");
	}


	public void destroy() {
		// TODO Auto-generated method stub
		// 종료가 된 상태 => 자동으로 메모리 해제
		System.out.println("MyServlet:destroy() Call ...");
	}
	/*
	 * 	흐름 : 화면 이동
	 *       =======
	 *       사용자 요청 => 요청 시에 어떤 값을 전송
	 *       	GET / POST
	 *       	=> GET : <a>, 대부분 / URL 뒤에 데이터 첨부 => ?키=값, ?키=값&키=값
	 *       		단순한 데이터 => 노출
	 *       		=> page 요청, 상세 보기 요청, 단순 검색 ...
	 *       	=> POST : <form>, Ajax
	 *       		데이터가 많거나 보안 요구 => 노출이 안된다
	 *       		=> 회원 가입, 글쓰기, 댓글 올리기
	 *       
	 *       서버 응답
	 *       	=> 요청값을 받아서 오라클에 연결
	 *       		request : 요청값 / response : 응답할 경우 : sendRedirect(), addCookie()
	 *       		getParameter()
	 *       		getParameterValues()
	 *       		=> 한글 = 인코딩 => 디코딩으로 변경
	 *       			setCharacterEncoding()
	 *       	=> 데이터 출력
	 *       
	 *       // 사용자가 데이터 전송 GET => doGet() 호출
	 *       // 사용자가 데이터 전송 POST => doPost() 호출
	 *       // 통합 : service()
	 *       
	 *       // => JSON / XML => Ajax / JavaScript and XML
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
