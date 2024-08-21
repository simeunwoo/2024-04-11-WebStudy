package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class RecipeModel {
	// 리턴형 => String : 데이터 전송 및 화면 변경 / void(Ajax) : 데이터만 전송
	// _ok.do => redirect
	@RequestMapping("recipe/recipe_list.do")
	public String recipe_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		
		List<RecipeVO> list=RecipeDAO.recipeListData(map);
		int count=RecipeDAO.recipeTotalCount();
		int totalpage=(int)(Math.ceil(count/20.0));
		
		// 블록별 처리
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("recipeList", list);
		request.setAttribute("count", count);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		request.setAttribute("main_jsp", "../recipe/recipe_list.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("recipe/recipe_detail.do")
	public String recipe_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		
		RecipeDetailVO vo=RecipeDAO.recipeDetailData(Integer.parseInt(no));
		
		List<String> sList=new ArrayList<String>();
		List<String> iList=new ArrayList<String>();
		
		String[] temp=vo.getFoodmake().split("\n");
		for(String fm:temp)
		{
			StringTokenizer st=new StringTokenizer(fm,"^");
			sList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		
		String s=vo.getData();
		// s=s.replace("구매", "");
		// vo.setData(s.trim());
		
		request.setAttribute("vo", vo);
		request.setAttribute("foodsList", sList);
		request.setAttribute("imgList", iList);
		
		request.setAttribute("main_jsp", "../recipe/recipe_detail.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("recipe/chef_list.do")
	public String chef_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=50;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<ChefVO> list=RecipeDAO.recipeChefListData(map);
		int totalpage=RecipeDAO.recipeChefTotalPage();
		
		request.setAttribute("chefList", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		request.setAttribute("main_jsp", "../recipe/chef_list.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("recipe/chef_make.do")
	public String chef_make(HttpServletRequest request,HttpServletResponse response)
	{
		String chef=request.getParameter("chef");
		String page=request.getParameter("page");
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("chef", chef);
		map.put("start", start);
		map.put("end", end);
		
		List<RecipeVO> list=RecipeDAO.recipeChefMakeData(map);
		int totalpage=RecipeDAO.recipeChefMakeTotalPage(chef);
		
		request.setAttribute("chef", chef);
		request.setAttribute("chefList", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		request.setAttribute("main_jsp", "../recipe/chef_make.jsp");
		return "../main/main.jsp";
	}
}
