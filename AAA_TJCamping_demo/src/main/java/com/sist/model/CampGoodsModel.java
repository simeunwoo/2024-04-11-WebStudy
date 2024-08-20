package com.sist.model;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;
public class CampGoodsModel {
	private String[] tables={"","CAMP_GOODS_ALL","CAMP_GOODS_BRAND","CAMP_GOODS_BEST","CAMP_GOODS_NEW","CAMP_GOODS_SPECIAL"};
	private String[] titles= {"","전체 상품","브랜드별 상품","베스트 상품","신상품","세일 상품"};
	@RequestMapping("campgoods/list.do")
	public String campgoods_list(HttpServletRequest request, HttpServletResponse response) {
		String gno=request.getParameter("gno");
		if(gno==null)
			gno="1"; // 참조 NO => tables
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("table_name", tables[Integer.parseInt(gno)]);
		map.put("start", start);
		map.put("end", end);
		List<CampGoodsVO> gList=CampGoodsDAO.campGoodsListData(map);
		int totalpage=CampGoodsDAO.campGoodsTotalPage(map);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("gList", gList);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("gno", gno);
		request.setAttribute("title", titles[Integer.parseInt(gno)]);
		
		request.setAttribute("main_jsp", "../campgoods/list.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("campgoods/detail_before.do")
	   public String food_detail_before(HttpServletRequest request,HttpServletResponse response)
	   {
		   String cno=request.getParameter("cno");
		   String gno=request.getParameter("gno");
		   String type=request.getParameter("type");
		   // 쿠키
		   Cookie cookie=new Cookie("campgoods_"+cno, cno);
		   cookie.setMaxAge(60*60*24);
		   cookie.setPath("/");
		   // 브라우저로 전송
		   response.addCookie(cookie);
		   return "redirect:../campgoods/detail.do?cno="+cno+"&gno="+gno+"&type="+type;
	   }
	@RequestMapping("campgoods/detail.do")
	public String campgoods_detail(HttpServletRequest request, HttpServletResponse response) {
		String cno1=request.getParameter("cno");
		String gno=request.getParameter("gno");
		String type=request.getParameter("type");
		Map map=new HashMap();
		map.put("cno", cno1);
		map.put("table_name", tables[Integer.parseInt(gno)]);
		CampGoodsVO vo=CampGoodsDAO.campGoodsDetailData(map);
		String price2=vo.getPrice();
		price2=price2.replaceAll("[^0-9]", "");
		vo.setPrice2(Integer.parseInt(price2));
		
		boolean bCheck=false;
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		request.setAttribute("type",type);
		if(id!=null) {
			Map map2 = new HashMap();
			map2.put("cno", cno1);
			map2.put("type",type);
			map2.put("id", id);
			int count=AllJjimDAO.allJjimCheck(map2);
	        System.out.println(cno1+" "+type+" "+id+" "+count);
			if(count==1) {
				bCheck=true;
		        System.out.println(cno1+" "+type+" "+id);
			}
			else
				bCheck=false;
			
			request.setAttribute("check", bCheck);
			
		}
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../campgoods/detail.jsp");
		return "../main/main.jsp";
	}
	
	
}