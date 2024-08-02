package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;

public class MainModel {
	@RequestMapping("main/main.do")
	public String main(HttpServletRequest request, HttpServletResponse response) {
		return "../main/main.jsp";
	}
}
