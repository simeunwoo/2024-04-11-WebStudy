package com.sist.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	1. JSP / Servlet => Model 1 방식
 * 		= 장점
 * 			1) 서블릿 => 자바 코드만으로 HTML 코드 작성 => 오류 발생 확률이 낮다
 * 			2) JSP => 자바 코드만으로 HTML 코드 작성 => 오류 발생 확률이 낮다
 * 			3) 단순하다 => 자바/HTML만 구분하면 된다
 * 				<% %>, <%= %> => 제어문 : for / if
 * 		= 단점
 * 			1) 가독성이 떨어진다 => Java + HTML
 * 			2) 자바의 로직이나 데이터베이스 => 노출이 된다 (JSP는 배포 시에 모든 소스를 전달)
 * 				=> 노출 시 => 다른 개발자가 유지보수할 수 있다
 * 			3) 파일이 1개라서 분업하기 어렵다 => 혼자서 해야 된다 => 만능 (Java/HTML/CSS/JavaScript/Oracle)
 * 		= 사용처
 * 			개인 기업 사이트
 * 			유지보수가 거의 없는 사이트
 * 				=> JSP/Servlet : 확장성/재사용성이 많이 떨어진다
 * 			개인 홈페이지 (유치원, 개인 쇼핑몰, 개인 학원)
 * 			간단한 사이트 제작
 * 
 * 	2. MVC => Model 2 방식
 * 		=> JSP/Servlet => 보완
 * 			1) 확장성/재사용성 증가
 * 			2) 보안이 필요한 경우 처리 (HTML/Java 완전 분리)
 * 			3) 분업화 => Front-End / Back-End
 * 			4) Controller로 집중적 => 서버에 부하가 많을 수 있다
 * 			========================================
 * 				보안)
 * 				1] Front-End의 MVC => Redux / Flux / Vuex
 * 				2] 서버를 나눠서 동시 구동 => 부하를 줄인다 => MSA (애자일 기법)
 * 		= 비용이 많이 들어간다 (인력 2배)
 * 		= 목적은 유지 보수 목적 => 쉽게 수정 / 쉽게 추가
 * 		= 모든 편집기 => 어시스트
 * 		= 공기업 / 금융권 / 대기업 => MVC 구조(스프링)로 만들어져 있다
 * 
 * 	라이브러리 vs 프레임워크
 * 		라이브러리 => 완제품
 * 		프레임워크 => 레고(자바 소스를 제공) => 전자정부 프레임워크, 애니 프레임워크
 * 
 * 	기능 처리
 * 	1. 클래스화 => 관리가 어렵다
 * 		게시판 => 기능 => 12개
 * 	2. 메소드화 => 1개의 클래스에 메소드 12개
 * 		=> 구분자(어노테이션) => 스프링
 * 
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
