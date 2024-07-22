package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class ReplyOkModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		String pno=request.getParameter("pno");
		
		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		// 여기서 pno는 설정 안해도 됨
		
		// BoardDAO로 전송 => 오라클 연결
		BoardDAO dao=BoardDAO.newInstance();
		// 답변 올리기
		
		
		return "redirect:list.do";
	}

}
