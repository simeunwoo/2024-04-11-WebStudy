package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;

public class BoardModel {

	@RequestMapping("board/list.do")
	public String board_list(HttpServletRequest request,HttpServletResponse response)
	{
		// 사용자 요청 => 페이지
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=BoardDAO.boardListData(map);
		
		// 총 페이지
		int count=BoardDAO.boardRowCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((rowSize*curpage)-rowSize);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		// Controller에서 JSP로 전송 => request
		return "list.jsp";
	}
	
	/*
	 * 	public void display(int a,int b){}
	 * 	
	 * 	=> display() => 호출 불가
	 * 	=> display(10, 10) => 호출 가능
	 */
	// 메소드 호출 하는 곳 => Controller => 모든 메소드에 매개 변수 => request, response
	@RequestMapping("board/insert.do")
	public String board_insert(HttpServletRequest request,HttpServletResponse response)
	{
		return "insert.jsp";
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
		
		// DAO 연동
		BoardDAO.boardInsert(vo);
		
		return "redirect:list.do"; // sendRedirect : request 초기화
	}
	
	@RequestMapping("board/detail.do") // => if를 추가 => 찾기만 가능, 기능은 없다
	// 어노테이션 => 메소드, 클래스, 멤버 변수, 매개 변수, 생성자 => 모든 명칭을 자유롭게 사용 가능
	public String board_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		return "detail.jsp"; // forward : request 초기화 X
	}
}
