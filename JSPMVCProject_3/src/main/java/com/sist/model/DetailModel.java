package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;

public class DetailModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String no=request.getParameter("no");
		
		// DAO 연동
		BoardDAO dao=BoardDAO.newInstance();
		// 데이터를 가지고 온다
		BoardVO vo=dao.boardDetailData(Integer.parseInt(no));
		// 모든 화면 => Controller
		
		request.setAttribute("vo", vo);
		
		return "detail.jsp";
	}

}
