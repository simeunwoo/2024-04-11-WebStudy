package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

import java.util.*;
import java.text.*;

public class ReserveModel {

	@RequestMapping("reserve/reserve_main.do") // RequestMapping : if문과 동일한 역할 수행
	public String reserve_main(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../reserve/reserve_main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("reserve/date_info.do") // RequestMapping : if문과 동일한 역할 수행
	public String reserve_date_info(HttpServletRequest request,HttpServletResponse response)
	{
		String strYear=request.getParameter("year");
		String strMonth=request.getParameter("month");
		String strDay="";
		String strFno=request.getParameter("fno");
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
		String today=sdf.format(date);
		StringTokenizer st=new StringTokenizer(today,"-");
		
		String sy=st.nextToken();
		String sm=st.nextToken();
		strDay=st.nextToken();
		/////////////////////////// 오늘 날짜만 저장
		String tday=strDay;
		String tyear=sy;
		String tmonth=sm;
		///////////////////////////
		
		if(strYear==null)
		{
			strYear=sy;
			
		}
		if(strMonth==null)
		{
			strMonth=sm;
		}
		
		int year=Integer.parseInt(strYear);
		int month=Integer.parseInt(strMonth);
		int day=Integer.parseInt(strDay);
		
		// 요일 / 마지막 날 구하기
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		int week=cal.get(Calendar.DAY_OF_WEEK);
		week=week-1;
		int lastday=cal.getActualMaximum(Calendar.DATE);
		
		String[] weeks={"일","월","화","수","목","금","토"};
		
		// 예약 가능한 날
		if(strFno!=null)
		{
			String rdays=FoodDAO.foodReserveDayData(Integer.parseInt(strFno));
			int[] reserveDays=new int[32];
			
			if(month==Integer.parseInt(tmonth) && year==Integer.parseInt(tyear))
			{
				st=new StringTokenizer(rdays,",");
				while(st.hasMoreTokens())
				{
					int d=Integer.parseInt(st.nextToken());
					if(d>=day)
					{
						reserveDays[d]=1;
					}
				}
			}
			else
			{
				st=new StringTokenizer(rdays,",");
				
				while(st.hasMoreTokens())
				{
					int d=Integer.parseInt(st.nextToken());
					reserveDays[d]=1;
				}
			}
			request.setAttribute("rday", reserveDays);
		}
		
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		request.setAttribute("week", week);
		request.setAttribute("weeks", weeks);
		request.setAttribute("lastday", lastday);
		request.setAttribute("fno", strFno);
		
		return "../reserve/date_info.jsp";
	}
	
	@RequestMapping("reserve/food_info.do")
	public String reserve_food_info(HttpServletRequest request,HttpServletResponse response)
	{
		String type=request.getParameter("type");
		
		if(type==null)
			type="한식";
		
		List<FoodVO> list=FoodDAO.foodTypeAllData(type);
		
		request.setAttribute("fList", list);
		
		return "../reserve/food_info.jsp";
	}
	
	@RequestMapping("reserve/time_info.do")
	public String reserve_time_info(HttpServletRequest request,HttpServletResponse response)
	{
		String day=request.getParameter("day");
		
		// 데이터베이스 연동
		String times=FoodDAO.foodReserveDayData(Integer.parseInt(day));
		List<String> tList=new ArrayList<String>();
		StringTokenizer st=new StringTokenizer(times,",");
		while(st.hasMoreTokens())
		{
			String time=FoodDAO.foodTimeSelectData(Integer.parseInt(st.nextToken()));
			tList.add(time);
		}
		
		request.setAttribute("tList", tList);
		
		return "../reserve/time_info.jsp";
	}
	
	@RequestMapping("reserve/inwon_info.do")
	public String reserve_inwon_info(HttpServletRequest request,HttpServletResponse response)
	{
		return "../reserve/inwon_info.jsp";
	}
	
	@RequestMapping("mypage/mypage_reserve.do")
	public String mypage_reserve(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		List<ReserveVO> list=FoodDAO.reserveMyPageData(id);
		
		request.setAttribute("recvList", list);
		
		request.setAttribute("mypage_jsp", "../mypage/mypage_reserve.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("reserve/reserve_ok.do")
	public String reserve_ok(HttpServletRequest request,HttpServletResponse response)
	{
		// 예약 정보 출력
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		
		String fno=request.getParameter("fno");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String inwon=request.getParameter("inwon");
		
		System.out.println("맛집 번호 : "+fno);
		System.out.println("예약일 : "+date);
		System.out.println("예약 시간 : "+time);
		System.out.println("예약 인원 : "+inwon);
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		ReserveVO vo=new ReserveVO();
		vo.setFno(Integer.parseInt(fno));
		vo.setDay(date);
		vo.setTime(time);
		vo.setInwon(inwon);
		vo.setId(id);
		
		FoodDAO.reserveInsert(vo);
		
		return "redirect:../mypage/mypage_reserve.do";
	}
}
