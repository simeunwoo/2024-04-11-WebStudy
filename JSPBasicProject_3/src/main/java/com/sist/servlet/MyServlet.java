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
 *  1. URL을 입력하고 => 웹 서버에 요청
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
 *		서블릿 (Servlet)
 *			=> Server + let => 서버에서 실행되는 가벼운(경량=>스프링) 프로그램
 *			=> Server + Applet(Application+let)
 *				Applet => 자바가 발전하게 함
 *				=> 웹 => 정보 공유 목적 (1995 이전 => 문자로만 출력)
 */

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
