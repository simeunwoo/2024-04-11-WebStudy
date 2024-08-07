package com.sist.model;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.manager.WordManager;
import com.sist.vo.*;
/*
 * 	1. mapper.xml
 * 	2. DAO
 * 	3. Model
 * 	4. JSP
 */
public class BoardModel {

	@RequestMapping("board/insert.do")
	public String board_insert(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../board/insert.jsp");
		// 입력 창만 보여준다
		return "../main/main.jsp";
	}
	
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		BoardDAO.boardInsert(vo);
		
		return "redirect:../board/list.do";
		/*
		 * 	insert_ok => 처리 => list.jsp => redirect
		 * 	update_ok => 처리 => detail.jsp
		 * 	delete_ok => 처리 => list.jsp
		 * 
		 * 	=> main.jsp
		 * 
		 * 	MVC JSP
		 * 	=> 데이터를 받아서 출력
		 *     ========== Model => Controller : .do
		 *
		 *	JSP =======> Controller =======> Model =======> Controller =======> JSP
		 *      request(.do)        request                            request
		 */
	}
	
	@RequestMapping("board/list.do")
	public String board_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		map.put("start", (curpage*10)-9);
		map.put("end", curpage*10);
		
		List<BoardVO> list=BoardDAO.boardListData(map);
		int count=BoardDAO.boardRowCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((curpage*10)-10);
		
		// 전송
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		request.setAttribute("main_jsp", "../board/list.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("board/detail.do")
	public String board_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		
		// 데이터베이스에서 값을 가지고 온다
		BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		
		WordManager wm=new WordManager();
		List<WordVO> list=wm.wordCountData(vo.getContent());
		
		request.setAttribute("vo", vo);
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../board/detail.jsp");
		return "../main/main.jsp";
	}
}
