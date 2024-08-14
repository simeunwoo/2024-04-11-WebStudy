package com.sist.model;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.commons.CommonsModel;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class MemberModel {

	@RequestMapping("member/login.do")
	public void member_login(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		// data:{"id":id,"pwd":pwd}
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		MemberVO vo=MemberDAO.isLogin(id, pwd);
		
		if(vo.getMsg().equals("OK"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("admin", vo.getAdmin());
		}
		
		// Ajax로 전송 시작
		try
		{
			PrintWriter out=response.getWriter();
			out.write(vo.getMsg());
		}catch(Exception ex) {}
	}
	
	@RequestMapping("member/logout.do")
	public void member_logout(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		HttpSession session=request.getSession();
		session.invalidate();
		
		// Ajax로 전송 시작
		try
		{
			PrintWriter out=response.getWriter();
			out.write("OK");
		}catch(Exception ex) {}
	}
	
	@RequestMapping("member/join.do")
	public String member_join(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		request.setAttribute("main_jsp", "../member/join.jsp");
		// 아이디 중복 체크
		// 우편 번호 검색 => daum 라이브러리 활용
		return "../main/main.jsp";
	}
}
