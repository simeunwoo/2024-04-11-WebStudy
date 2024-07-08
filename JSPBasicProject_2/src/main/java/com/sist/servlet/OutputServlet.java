package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OutputServlet")
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("OutputServlet:init(ServletConfig config) Call ...");
	}


	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("OutputServlet:destroy() Call ...");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("OutputServlet:doGet() Call...");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("OutputServlet:doPost() Call ...");
		// HTTP 상태 405 - 허용되지 않는 메소드
		// GET => doGet() / POST => doPost()
		// GET => doPost() (오류) / <a> => GET 방식
	}

}
