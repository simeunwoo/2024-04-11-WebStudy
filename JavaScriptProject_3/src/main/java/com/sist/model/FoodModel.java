package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
/*
 * 	자바스크립트 =======> JSON을 받아서 HTML에 출력 => 동적
 * 	|	=> JSON
 * 	자바
 * 	|	=> SQL
 * 	오라클
 * 	===================================================
 * 	1. 자바 : 데이터 관리 (변수, 제어문, 연산자, 메소드, 데이터베이스 연동)
 * 	2. 오라클 : SQL
 * 	3. HTML / CSS : 브라우저에 출력
 * 	4. 자바스크립트 : HTML/CSS 제어 => 동적으로 HTML 생성
 * 	===================================================
 * 	=> 통합
 * 	Spring Framework : 라이브러리
 * 	1. 데이터 연결 : MyBatis
 * 	2. 자바스크립트 연동 : Jackson(JSON)
 *     ======== Vue, React
 */
public class FoodModel {

	private FoodDAO dao=FoodDAO.newInstance();
	
	// 1. 예약하기, 좋아요, 찜, 아이디 중복 체크, 우편 번호, 채팅 => 화면 이동이 아니라 그 자리에서 업데이트해야 된다
	// 2. 탭, 모달
	@RequestMapping("js/food_find.do")
	public String food_find(HttpServletRequest request,HttpServletResponse response)
	{
		return "food_find.jsp";
	}

	@RequestMapping("js/food_find_js.do") // _js : javascript에서 데이터를 읽어 간다 => JSON 제작
	public void food_find_js(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		String addr=request.getParameter("addr");
		if(addr==null)
			addr="마포";
		
		int curpage=Integer.parseInt(page);
	}
	
	@RequestMapping("js/food_detail_js.do")
	public void food_detail_js(HttpServletRequest request,HttpServletResponse response)
	{
		
	}
}
