package com.sist.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DataInputServlet")
public class DataInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public DataInputServlet() {
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("DataInputServlet:init() Call ...");
		// 자동 로그인 / 쿠키 읽기
	}


	public void destroy() {
		// TODO Auto-generated method stub
		// 해제 => 메모리 => 새로운 화면 (new => 생성)
		System.out.println("DataInputServlet:destroy() Call ...");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 브라우저에 알려준다 (메모리를 읽어 간다 => HTML / XML / JSON)
		
	}

}
