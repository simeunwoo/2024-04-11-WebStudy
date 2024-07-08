package com.sist.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("InputServlet:init(ServletConfig config) Call ...");
		// 생성자와 같은 역할 => 멤버 변수의 초기화, 드라이버 등록, 쿠키 읽기 ...
		// 자동 로그인, 크롤링 (실시간 갱신)
	}


	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("InputServlet:destroy() Call ...");
		// 새로 고침, 화면 이동 => 메모리 회수
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("사용자가 요청한 데이터를 받아서 처리 결과를 보내주는 역할");
		// default => 처음 실행, <a>, sendRedirect() => GET/POST를 지정하지 않은 경우 => 
	}

}
