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
	
	private String[] aList=
	{"전체","의정부","안양","평택","동두천","안산","고양","남양주","오산","용인","파주","안성","김포","화성",
	"광주","양주","포천","여주","연천","가평","양평","청주","충주","제천","보은","옥천","영동","진천","음성",
	"괴산","단양","증평","천안","아산","서산","당진","공주","보령","논산","홍성","예산","부여","서천","청양",
	"태안","금산"};

	@RequestMapping("camp/list.do")
	public String camp_list(HttpServletRequest request,HttpServletResponse response)
	{		
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<CampVO> list=CampDAO.campListData(map);
		int totalpage=CampDAO.campTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp", "../camp/list.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("camp/detail.do")
	public String camp_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String camp_no=request.getParameter("camp_no");
			
		CampVO vo=CampDAO.campDetailData(Integer.parseInt(camp_no));
		
		String addr=vo.getCamp_addr(); // 충남 서천군 서면 춘장대길8번길 7-7
		String addr1=addr.substring(0,addr.indexOf(" "));
		
		List<CampVO> nList=CampDAO.campNearListData(addr1);
				
		request.setAttribute("vo", vo);
		request.setAttribute("nList", nList);
				
		request.setAttribute("main_jsp", "../camp/detail.jsp");
		return "../main/main.jsp";
	}
	
/*	@RequestMapping("camp/map.do")
	public String camp_map(HttpServletRequest request,HttpServletResponse response)
	{
		String a=request.getParameter("a");
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		map.put("page", curpage);
		map.put("camp_addr", aList[Integer.parseInt(a)]);
		
		List<CampVO> list=CampDAO.campFindData(map);
		int totalpage=CampDAO.campFindTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		int count=CampDAO.campFindCount(aList[Integer.parseInt(a)]);
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("a", a);
		request.setAttribute("abc", aList[Integer.parseInt(a)]);
		
		request.setAttribute("count", count);
		
		request.setAttribute("main_jsp", "../camp/map.jsp");
		return "../main/main.jsp";
	} */
	
	@RequestMapping("camp/map.do")
	public String camp_map(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<CampVO> list=CampDAO.campListData(map);
		int totalpage=CampDAO.campTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp", "../camp/map.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("camp/pet.do")
	public String camp_pet(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<CampVO> list=CampDAO.campPetData(map);
		int totalpage=CampDAO.campPetTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp", "../camp/pet.jsp");
		return "../main/main.jsp";
	}
}