package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	서블릿 => URL로 요청하면 => 톰캣에 의해 실행된다
 * 		순수하게 자바로만 만들어져 있다
 * 	    http://localhost/JSPBasicProject_2/FirstServlet
 *                                         ============ 대소문자 구분
 *                                         
 *  init() : 초기화 => 생성자와 비슷한 역할
 *    |
 *  doGet() / doPost() => 사용자에게 요청 처리에 대한 결과를 보여준다 (HTML)
 *  ================== 사용자 요청 시 한개만 실행 => GET / POST
 *    |		====================> 통합 : service()
 *    		GET : 화면에 출력 (default) => GET/POST를 지정하지 않으면 => GET을 인식
 *    		POST : 사용자 요청값을 받아서 처리
 *  destroy() => 메모리 해제
 *  ========= 1. 새로 고침 / 2. 파일 이동
 *            => 호출 시마다 new / delete
 *  
 *  => 사용자가 요청 데이터 전송 시
 *          ======== 톰캣에 의하여 한군데 모아서 전송 => request : 사용자 브라우저 정보를 가지고 있다 => IP / PORT
 *          ======== 브라우저에 전송 => response (응답) => HTML을 브라우저로 보내준다
 *          
 *  => 코딩 방식
 *  	1) 변환 코드 지정
 *  		HTML / XML / JSON
 *  		response.setContentType("text/html")
 *  		response.estContentType("text/xml")
 *  		response.estContentType("text/plain")
 *  	2) 클라이언트 브라우저에서 읽어갈 수 있게 메모리에 저장
 *  		PrintWriter out=response.getWriter()
 *                          ==================== 사용자 브라우저
 *          out.write("<html>")
 *      3) 데이터베이스 연결
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

    private String msg;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		msg="wow";
		// web.xml을 통하여 필요한 데이터 전송
		// web.xml을 읽어오는 라이브러리 : ServletConfig config
		System.out.println("Init(ServletConfig config) 메소드 호출 ...");
	}


	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy() : 서블릿 메모리 해제");
	}
	/*
	 * 	브라우저 : localhost 요청
	 * 	DNS : localhost => 127.0.0.1 (IP로 변환)
	 * 	변환된 IP를 이용하여 서버에 접속
	 * 		=> new Socket(ip명,80)
	 * 	파일 찾아서 => 실행된 결과를 메모리에 저장
	 * 		out.write("<html>")
	 * 	브라우저에서 HTML을 한줄씩 읽어서 변역
	 */


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// default => 화면 출력
		// 1. 전송 방식
		response.setContentType("text/html;charset=UTF-8");
		// 2. HTML을 요청한 브라우저로 전송
		PrintWriter out=response.getWriter(); // 브라우저 확인 (response 안에 사용자의 IP를 가지고 있다)
		// out 영역에 HTML을 작성하면 브라우저에서 읽어간다 => 화면에 출력된다
		out.write("<html>");
		out.write("<body>");
		out.write("<center>");
//		out.write("<h1>"+msg+"<h1>");
		out.write("<h3>IP:"+request.getRemoteAddr()+"</h3>"); // IP:0:0:0:0:0:0:0:1
		out.write("<h3>요청 내용:"+request.getRequestURL()+"</h3>"); // 요청 내용:http://localhost/JSPBasicProject_2/FirstServlet
		out.write("<h3>실제 요청 내용:"+request.getRequestURI()+"</h3>"); // 실제 요청 내용:/JSPBasicProject_2/FirstServlet
		out.write("</center>");
		out.write("</body>");
		out.write("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
