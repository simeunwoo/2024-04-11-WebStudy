package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.commons.CommonsModel;
import com.sist.controller.RequestMapping;

public class ChatModel {
	  @RequestMapping("chat/chat.do")
	  public String chat_main(HttpServletRequest request,HttpServletResponse response)
	  {
		  CommonsModel.footerPrint(request);
		  
		  request.setAttribute("main_jsp", "../chat/chat.jsp");
		  return "../main/main.jsp";
	  }
	}
