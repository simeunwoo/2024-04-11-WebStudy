package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;

public class MusicModel {

	@RequestMapping("main/main.do")
	public String music_list(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../music/list.jsp");
		return "../main/main.jsp";
	}
}
