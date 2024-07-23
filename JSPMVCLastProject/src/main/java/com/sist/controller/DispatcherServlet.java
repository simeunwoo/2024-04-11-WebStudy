package com.sist.controller;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.net.*;
// DispatcherServlet => 스프링에서 제공하는 컨트롤러 이름
/*
 * 	JSP       DispatcherServlet      Model(여러개)
 *      ===== ==================     ===========
 *       주문          서빙                 주방
 *                    | Controller
 *                      ==========
 *                      주문(request)을 받는다
 *                      주문 => 주방에 전달
 *                      음식(request) => JSP로 전송
 *
 *	MVC
 *	= M(Model) : 요청을 처리해주는 모든 클래스의 집합
 *		~VO, ~DAO, ~Manager, ~Service
 *		사용자로부터 요청(request)을 받는다 => 요청 처리 => 결과값을 request에 담아주는 역할
 *		일반 자바 형태
 *	= V(View) : JSP => 전송 받은 request를 출력하는 역할
 *		JSP : 요청 전송, 데이터 출력
 *			=> 요청 전송 : <a>, <form>, JavaScript
 *	= C(Controller) : 사용자 요청 => Model에 전송 => 처리 결과(결과값)를 가지고 온다 => JSP로 전송
 *		프레임워크 : 기본 틀이 만들어져 있다 => Spring, 마이플랫폼 (이미 라이브러리로 제작)
 *		포털 사이트 : Controller를 직접 제작
 *
 * 	*** 1. Controller
 *         ========== 서빙 역할 (메뉴를 다 알고 있어야 한다)
 *                            ==
 *                            Model
 *                            누가 요청했는지 여부 => View
 *                            
 *	*** 2. 클래스가 많으면 관리하기 어렵다 (검색 시간이 오래 걸린다)
 *         =============
 *         클래스를 최대한 줄여서 사용 => 관련된 내용을 메소드화 => 응집성
 *         
 *	*** 3. 메소드를 호출하려먼
 *         ========
 *         Controller가 알고 있어야 한다
 *         => 메소드명을 먼저 설정
 *            =============
 *            => 어떤 메소드명을 사용해도 자동 처리
 *                  =====
 *                  구분자(어노테이션)
 *
 *	*** 스프링 구조 : 라이브러리 (자바 파일)
 *		=> 설정 파일 : XML, 구분자 : 어노테이션을 사용
 *			XML : Spring-Boot : 어노테이션으로 변경
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<String> clsList=new ArrayList<String>();
	// application.xml => 클래스 등록

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try
		{
			URL url=this.getClass().getClassLoader().getResource(".");
			// 경로명 읽기 => AWS => 리눅스 / 맥
			File file=new File(url.toURI());
			System.out.println(file.getPath());
			String path=file.getPath();
			path=path.replace("\\", File.separator);
			// 리눅스, 맥 => /, 윈도우 \\ => 운영체제에 따라 자동 변경
		}catch(Exception ex) {}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
