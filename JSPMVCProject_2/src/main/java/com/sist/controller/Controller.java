package com.sist.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;
import java.util.*;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map clsMap=new HashMap();
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		clsMap.put("list.do", new ListModel());
		clsMap.put("insert.do", new InsertModel());
		clsMap.put("update.do", new UpdateModel());
		clsMap.put("delete.do", new DeleteModel());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd=request.getRequestURI();
		// URL : http://localhost:8080/JSPMVCProject_2/*.do
		// URI : /JSPMVCProject_2/*.do
		cmd=cmd.substring(request.getContextPath().length()+1); // *.do
		
		Model model=(Model)clsMap.get(cmd);
		String jsp=model.execute(request);
		
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}
