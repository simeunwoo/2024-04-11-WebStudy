package com.sist.model;
import java.awt.Robot;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
public class RecipeModel {
   @RequestMapping("recipe/list.do")
   public String recipe_list(HttpServletRequest request,HttpServletResponse response)
   {
	   // 사용자 요청값 받기 
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=20;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   map.put("start", start);
	   map.put("end", end);
	   List<RecipeVO> reList=RecipeDAO.recipeListData(map);
	   int totalpage=RecipeDAO.recipeTotalPage();
	   
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   request.setAttribute("reList", reList);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   request.setAttribute("startPage", startPage);
	   request.setAttribute("endPage", endPage);
	   // DB연동 => 출력할 데이터 전송 
	   int count=RecipeDAO.recipeListCount();
	   request.setAttribute("count", count);
	   
	   
	   request.setAttribute("main_jsp", "../recipe/list.jsp");
	   return "../main/main.jsp";
   }
   @RequestMapping("recipe/detail_before.do")
   public String recipe_detail_before(HttpServletRequest request,HttpServletResponse response)
   {
	   String no=request.getParameter("no");
	   String type=request.getParameter("type");
	   // 쿠키 
	   Cookie cookie=new Cookie("recipe_"+no, no);
	   cookie.setMaxAge(60*60*24);
	   cookie.setPath("/");
	   // 브라우저로 전송 
	   response.addCookie(cookie);
	   return "redirect:../recipe/detail.do?no="+no+"&type="+type;
   }

   @RequestMapping("recipe/detail.do")
   public String recipe_detail(HttpServletRequest request,HttpServletResponse response)
   {
	   //사용자가 보내준 데이터를 받는다 => fno,type(좋아요,찜,댓글)
	   String no=request.getParameter("no");
	   String type=request.getParameter("type");
	   // 서울 종로구 명륜2가 21-14
	   // 데이터베이스 연동 
	   RecipeVO revo=RecipeDAO.recipeDetailData(Integer.parseInt(no));
	   String info3=revo.getInfo3();
	   
	   
       List<RecipeVO> reList=RecipeDAO.sameRecipeData(info3);
       request.setAttribute("reList", reList);
	   request.setAttribute("revo", revo);
	   request.setAttribute("type", type);
	 
	   /*   맛집(1) / 레시피(2) / 서울 여행(3) / 상품(4)  
	    */   
	   
	   
	   boolean bCheck=false;
	   HttpSession session=request.getSession();
	   String id=(String)session.getAttribute("id");
	   if(id!=null)
	   {
		   Map map=new HashMap();
		   map.put("cno", no);
		   map.put("type", type);
		   map.put("id", id);
		   int count=AllJjimDAO.allJjimCheck(map);
		   if(count==1)
			   bCheck=true;
		   else
			   bCheck=false;
		   
		   request.setAttribute("check", bCheck);
	   }
	   request.setAttribute("main_jsp", "../recipe/detail.jsp");
	   return "../main/main.jsp";
   }
   // 검색 
   // _ok.do => redirect (이전에 존재하는 화면 이동)
   // ajax => void : 자체 파일에서 처리 
   // 일반 => main.jsp 
   @RequestMapping("recipe/find.do")
   public String recipe_find(HttpServletRequest request,HttpServletResponse response)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex) {}
	   String ress=request.getParameter("ress");
	   if(ress==null)
		   ress="제시";
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=20;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=(rowSize*curpage);
	   
	   Map map=new HashMap();
	   map.put("start",start);
	   map.put("end", end);
	   map.put("ress", ress);
	   // 데이터 읽기
	   List<RecipeVO> reList=RecipeDAO.recipeFindListData(map);
	   int totalpage=RecipeDAO.recipeFindTotalPage(ress);
	   // 총페이지 읽기 
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   request.setAttribute("startPage", startPage);
	   request.setAttribute("endPage", endPage);
	   request.setAttribute("reList", reList);
	   request.setAttribute("ress", ress);
	   // BLOCK별 처리 
	   request.setAttribute("main_jsp", "../recipe/find.jsp");
	   return "../main/main.jsp";
   }
}