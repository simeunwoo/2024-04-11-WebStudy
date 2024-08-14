package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.commons.CommonsModel;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;
// Model => 사용자 요청 정보를 받아서 요청 처리 => 결과값을 브라우저로 전송
public class SeoulModel {

	@RequestMapping("seoul/location.do")
	// _ok => redirect / ajax => void (화면 변경이 없다)
	public String seoul_location(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		// 1) 사용자 요청 받기 => getParameter(), getParameterValues()
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		// 2) 요청 처리 => 데이터베이스 연동 => 메소드 호출
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		List<SeoulLocationVO> lList=SeoulDAO.seoulLocationListData(map);
		int totalpage=SeoulDAO.seoulLocationTotalPage();
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1 11 21 31 41 ...
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK; // 10 20 30 40 50 ...
		if(endPage>totalpage)
			endPage=totalpage;
		
		// 3) 결과값을 브라우저로 전송 => setAttribute()
		request.setAttribute("lList", lList);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 4) 어떤 화면을 출력할 지 설정
		request.setAttribute("main_jsp", "../seoul/location.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("seoul/nature.do")
	// _ok => redirect / ajax => void (화면 변경이 없다)
	public String seoul_nature(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		// 1) 사용자 요청 받기 => getParameter(), getParameterValues()
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		// 2) 요청 처리 => 데이터베이스 연동 => 메소드 호출
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		List<SeoulNatureVO> nList=SeoulDAO.seoulNatureListData(map);
		int totalpage=SeoulDAO.seoulNatureTotalPage();
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1 11 21 31 41 ...
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK; // 10 20 30 40 50 ...
		if(endPage>totalpage)
			endPage=totalpage;
		
		// 3) 결과값을 브라우저로 전송 => setAttribute()
		request.setAttribute("nList", nList);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 4) 어떤 화면을 출력할 지 설정
		request.setAttribute("main_jsp", "../seoul/nature.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("seoul/shop.do")
	// _ok => redirect / ajax => void (화면 변경이 없다)
	public String seoul_shop(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		// 1) 사용자 요청 받기 => getParameter(), getParameterValues()
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		// 2) 요청 처리 => 데이터베이스 연동 => 메소드 호출
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", curpage*20);
		List<SeoulShopVO> sList=SeoulDAO.seoulShopListData(map);
		int totalpage=SeoulDAO.seoulShopTotalPage();
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1 11 21 31 41 ...
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK; // 10 20 30 40 50 ...
		if(endPage>totalpage)
			endPage=totalpage;
		
		// 3) 결과값을 브라우저로 전송 => setAttribute()
		request.setAttribute("sList", sList);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 4) 어떤 화면을 출력할 지 설정
		request.setAttribute("main_jsp", "../seoul/shop.jsp");
		return "../main/main.jsp";
	}
}
