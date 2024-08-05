package com.sist.model;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sist.vo.*;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;

public class CampModel {

	@RequestMapping("camp/list.do")
	public String camp_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<CampVO> list=CampDAO.campListData(map);
		
		int count=CampDAO.campRowCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((rowSize*curpage)-rowSize);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		return "list.jsp";
	}
	
	@RequestMapping("camp/detail.do")
	public String camp_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		CampVO vo=CampDAO.campDetailData(Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		return "detail.jsp";
	}
}
