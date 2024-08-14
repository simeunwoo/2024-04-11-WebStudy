package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.CampDAO;
import com.sist.dao.CampImageDAO;
import com.sist.vo.CampImageVO;
import com.sist.vo.CampVO;

public class CampImageModel {

	@RequestMapping("camp/detail.do")
	public String camp_detail_image(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
			
		CampImageVO ivo=CampImageDAO.campDetailImageData(Integer.parseInt(no));
				
		request.setAttribute("ivo", ivo);
				
		request.setAttribute("main_jsp", "../camp/detail.jsp");
		return "../main/main.jsp";
	}
}
