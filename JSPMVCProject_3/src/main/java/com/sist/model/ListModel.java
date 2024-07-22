package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import com.sist.dao.*;
/*
 * 	<%@ page ... %>
 * 	<%
 * 		String strPage=request.getParameter("page");
 * 		if(strPage==null)
 * 			strPage="1"; => 메소드로 이동
 * 		====================> 요 3줄을 자바로 뺀다 (MVC 구조 관련)
 * 	%>
 */
public class ListModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String page=request.getParameter("page");
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		BoardDAO dao=BoardDAO.newInstance();
		List<BoardVO> list=dao.boardListData(curpage);
		
		return "board/list.jsp";
	}

}
