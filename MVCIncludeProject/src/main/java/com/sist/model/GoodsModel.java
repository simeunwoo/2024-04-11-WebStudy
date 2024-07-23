package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import java.util.*;

public class GoodsModel {
//	<!-- ----------------------- 미 완 성 ----------------------------------------- -->
	@RequestMapping("goods/list.do")
	public String goods_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		
		GoodsDAO dao=GoodsDAO.newInstance();
		List<GoodsVO> list=dao.goodsListData(curpage);
		
		int totalpage=dao.goodsTotalPage();
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		request.setAttribute("main_jsp", "../goods/list.jsp"); // include
		return "../main/main.jsp";
	}

	@RequestMapping("goods/detail.do")
	public String goods_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		GoodsDAO dao=GoodsDAO.newInstance();
		GoodsVO vo=dao.goodsDetailData(Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		
		request.setAttribute("main_jsp", "../goods/detail.jsp"); // include
		return "../main/main.jsp";
	}
}
