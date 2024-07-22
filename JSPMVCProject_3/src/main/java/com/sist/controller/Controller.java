package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String[] strCls= {
		"com.sist.model.ListModel",
		"com.sist.model.InsertModel"
	};
	
	private String[] strCmd= {
		"list.do",
		"insert.do"
	};
	
	private Map clsMap=new HashMap();
	
	// 관련된 클래스를 모아서 관리 => Factory Pattern => Spring(Container) : 클래스 관리자
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try
		{
			for(int i=0;i<strCls.length;i++)
			{
				// 메모리 할당
				Class clsName=Class.forName(strCls[i]);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				clsMap.put(strCmd[i], obj);
			}
		}catch(Exception ex) {}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 사용자의 요청 정보를 읽어 온다 (URI)
		String cmd=request.getRequestURI();
	//	System.out.println("cmd="+cmd);
		cmd=cmd.substring(cmd.lastIndexOf("/")+1);
	//	System.out.println("cmd2="+cmd);
		
		// 2. 해당 Model을 찾는다
		Model model=(Model)clsMap.get(cmd);
		// => 요청 처리
		String jsp=model.execute(request);
		
		// 3. JSP를 찾는다
		// => JSP에 request를 전송
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}
