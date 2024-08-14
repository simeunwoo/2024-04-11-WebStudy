package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class AdminModel {

	@RequestMapping("adminpage/adminpage_main.do")
	public String adminpage_main(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("admin_jsp", "../adminpage/adminpage_home.jsp"); // 이중 include
		request.setAttribute("main_jsp", "../adminpage/adminpage_main.jsp"); // 이중 include
		return "../main/main.jsp";
	}
	
	@RequestMapping("adminpage/member_list.do")
	public String member_list(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("admin_jsp", "../adminpage/member_list.jsp"); // 이중 include
		request.setAttribute("main_jsp", "../adminpage/adminpage_main.jsp"); // 이중 include
		return "../main/main.jsp";
	}
	
	@RequestMapping("adminpage/notice_list.do")
	public String notice_list(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("admin_jsp", "../adminpage/notice_list.jsp"); // 이중 include
		request.setAttribute("main_jsp", "../adminpage/adminpage_main.jsp"); // 이중 include
		return "../main/main.jsp";
	}
	
	@RequestMapping("adminpage/reply_list.do")
	public String reply_list(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("admin_jsp", "../adminpage/reply_list.jsp"); // 이중 include
		request.setAttribute("main_jsp", "../adminpage/adminpage_main.jsp"); // 이중 include
		return "../main/main.jsp";
	}
}
