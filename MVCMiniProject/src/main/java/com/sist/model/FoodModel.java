package com.sist.model;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.*;
import com.sist.dao.*;
import com.sist.vo.*;
// 맛집 관련된 모든 기능을 처리하는 클래스
public class FoodModel {

	// 1. 목록 출력
	@RequestMapping("food/list.do") // 어노테이션 : 밑에 있는 클래스, 변수, 메소드를 찾아주는 역할
	public String food_list(HttpServletRequest request,HttpServletResponse response)
	{
		// 요청을 받는 경우 : request
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		// 현재 페이지 지정
		int curpage=Integer.parseInt(page);
		FoodDAO dao=FoodDAO.newInstance();
		List<FoodVO> list=dao.foodListData(curpage);
		int totalpage=dao.foodTotalPage();
		// 응답을 하는 경우 : response
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1 11 21 ...
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK; // 10 20 30 ...
		/*
		 * 	startPage = 1
		 * 	=> curpage = 1~10
		 * 	endPage = 10
		 * 	=> curpage = 1~10
		 */
		if(endPage>totalpage)
			endPage=totalpage;
		// JSP에서 출력에 필요한 데이터 전송
		request.setAttribute("list", list); // List<FoodVO> list로부터
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		// include되는 파일 전송
		request.setAttribute("main_jsp", "../food/list.jsp");
		return "../main/main.jsp"; // jsp 파일 지정 => include가 된 경우 : main.jsp로 이동
	}
	
	@RequestMapping("food/before_detail.do")
	public String food_before_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String fno=request.getParameter("fno");
		// 1) Cookie 생성
		Cookie cookie=new Cookie("food_"+fno,fno);
		/*
		 *	키가 중복되면 덮어 쓴다 => Map 방식
		 *	쿠키의 단점 => 보얀 취약, 문자열만 저장 가능
		 */
		// 2) Cookie의 저장 기간
		cookie.setMaxAge(60*60*24);
		// 3) Cookie의 저장 위치
		cookie.setPath("/");
		// 4) response를 이용하여 브라우저로 전송
		response.addCookie(cookie);
		
		return "redirect:../food/detail.do?fno="+fno;
	}
	// 2. 맛집 상세 보기
	@RequestMapping("food/detail.do")
	public String food_detail(HttpServletRequest request,HttpServletResponse response)
	{
		// food/detail.do?fno=1
		// 사용자가 보내준 요청값을 받는다
		String fno=request.getParameter("fno");
		FoodDAO dao=FoodDAO.newInstance(); // Spring은 자체가 싱글턴
		FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
		
		request.setAttribute("vo", vo); // FoodVO vo로부터
		
		// 명소 전송 => ex) 서울 용산구 이태원동 124-6 2층
		String addr=vo.getAddress();
		addr=addr.substring(addr.indexOf(" "));
		System.out.println(addr);
		String addr2=addr.trim();
		addr2=addr2.substring(0,addr2.indexOf(" "));
		System.out.println(addr2);
		
		List<LocationVO> sList=dao.foodLocationData(addr2);
		
		request.setAttribute("sList", sList);
		
		request.setAttribute("main_jsp", "../food/detail.jsp");
		return "../main/main.jsp";
	}
	// 3. 맛집 검색
	// 4. 맛집 예약
	// 5. 맛집 추천
}
