package com.sist.model;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.commons.CommonsModel;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.manager.MailManager;
import com.sist.vo.*;
public class MemberModel {
  @RequestMapping("member/login.do")
  //                       MemberVO vo
  public void member_login(HttpServletRequest request,HttpServletResponse response)
  {
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
		  session.setAttribute("phone", vo.getPhone());
		  session.setAttribute("address", vo.getAddr1());
		  session.setAttribute("email", vo.getEmail());
		  session.setAttribute("post", vo.getPost());
	  }
	  // ajax로 전송 
	  try
	  {
		  PrintWriter out=response.getWriter();
		  out.write(vo.getMsg());
	  }catch(Exception ex) {}
  }
  @RequestMapping("member/logout.do")
  public void member_logout(HttpServletRequest request,HttpServletResponse response)
  {
	  HttpSession session=request.getSession();
	  session.invalidate();
	  try
	  {
		  PrintWriter out=response.getWriter();
		  out.write("OK");
	  }catch(Exception ex) {}
  }
  @RequestMapping("member/join.do")
  public String member_join(HttpServletRequest request,HttpServletResponse response)
  {
	  request.setAttribute("main_jsp", "../member/join.jsp");
	  // 아이디 중복 체크 , 우편번호 검색 => daum라이브러리 
	  CommonsModel.footerPrint(request);
	  return "../main/main.jsp";
  }
  @RequestMapping("member/idcheck.do")
  public String member_idcheck(HttpServletRequest request,HttpServletResponse response)
  {
	  return "../member/idcheck.jsp";
  }
  @RequestMapping("member/idcheck_ok.do")
  public void member_idcheck_ok(HttpServletRequest request,HttpServletResponse response)
  {
	  /*
	   *    url:'../member/idcheck_ok.do',
			data:{"id":id}
	   */
	  String id=request.getParameter("id");
	  // DB연동 
	  int count=MemberDAO.memberIdCheck(id);
	  // Ajax로 값을 전송 => 0,1
	  try
	  {
		  PrintWriter out=response.getWriter();
		  out.write(String.valueOf(count));// 문자열 전송 
	  }catch(Exception ex) {}
  }
  /*
   *   ID                                        NOT NULL VARCHAR2(20)
	 PWD                                       NOT NULL VARCHAR2(10)
	 NAME                                      NOT NULL VARCHAR2(51)
	 SEX                                                CHAR(6)
	 BIRTHDAY                                           VARCHAR2(10)
	 POST                                      NOT NULL VARCHAR2(7)
	 ADDR1                                     NOT NULL VARCHAR2(150)
	 ADDR2                                              VARCHAR2(150)
	 PHONE                                              VARCHAR2(13)
	 EMAIL                                              VARCHAR2(100)
	 CONTENT                                            CLOB
   */
  @RequestMapping("member/join_ok.do")
  public String member_join_ok(HttpServletRequest request,HttpServletResponse response)
  {
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  String id=request.getParameter("id");
	  String pwd=request.getParameter("pwd");
	  String name=request.getParameter("name");
	  String sex=request.getParameter("sex");
	  String birthday=request.getParameter("birthday");
	  String post=request.getParameter("post");
	  String addr1=request.getParameter("addr1");
	  String addr2=request.getParameter("addr2");
	  String email=request.getParameter("email");
	  String content=request.getParameter("content");
	  String phone1=request.getParameter("phone1");
	  String phone2=request.getParameter("phone2");
	  
	  MemberVO vo=new MemberVO();
	  vo.setId(id);
	  vo.setPwd(pwd);
	  vo.setName(name);
	  vo.setSex(sex);
	  vo.setEmail(email);
	  vo.setBirthday(birthday);
	  vo.setPost(post);
	  vo.setAddr1(addr1);
	  vo.setAddr2(addr2);
	  vo.setContent(content);
	  vo.setPhone(phone1+")"+phone2);
	  MemberDAO.memberInsert(vo);
	  return "redirect:../main/main.do";
  }
  
  @RequestMapping("member/idfind.do")
  public String member_idfind(HttpServletRequest request,HttpServletResponse response)
  {
	  request.setAttribute("main_jsp", "../member/idfind.jsp");
	  return "../main/main.jsp";
  }
  
  @RequestMapping("member/idcheck_ok2.do")
  public void member_idcheck_ok2(HttpServletRequest request,HttpServletResponse response)
  {
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  
	  String name=request.getParameter("name");
	  String email=request.getParameter("email");
	  
	  MemberVO vo=new MemberVO();
	  vo.setName(name);
	  vo.setEmail(email);
	  
	  // 데이터베이스 연동
	  String result=MemberDAO.memberIdFindData(vo);
	  
	  // Ajax로 값 전송
	  try
	  {
		  PrintWriter out=response.getWriter();
		  out.write(result);
	  }catch(Exception ex) {}
  }
  
  @RequestMapping("member/idcheck_ok3.do")
  public void member_idcheck_ok3(HttpServletRequest request,HttpServletResponse response)
  {
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  
	  String name=request.getParameter("name");
	  String phone=request.getParameter("phone");
	  
	  MemberVO vo=new MemberVO();
	  vo.setName(name);
	  vo.setPhone(phone);
	  
	  // 데이터베이스 연동
	  String result=MemberDAO.memberIdFindData2(vo);
	  
	  // Ajax로 값 전송
	  try
	  {
		  PrintWriter out=response.getWriter();
		  out.write(result);
	  }catch(Exception ex) {}
  }
  
  @RequestMapping("member/pwdfind.do")
  public String member_pwdfind(HttpServletRequest request,HttpServletResponse response)
  {
	  request.setAttribute("main_jsp", "../member/pwdfind.jsp");
	  return "../main/main.jsp";
  }
  
  @RequestMapping("member/pwdfind_ok.do")
  public void member_pwdfind_ok(HttpServletRequest request,HttpServletResponse response)
  {
	  String id=request.getParameter("id");
	  
	  String result=MemberDAO.memberPwdFindData(id);
	  if(!result.equals("no"))
	  {
		  MailManager m=new MailManager();
		  m.mailSender(result);
	  }
	  
	  try
	  {
		  PrintWriter out=response.getWriter();
		  out.write(result);
	  }catch(Exception ex) {}
  }
}