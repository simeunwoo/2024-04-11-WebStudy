package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			st=new StringTokenizer(rdays,",");
			int[] reserveDays=new int[32];
			while(st.hasMoreTokens())
			{
				int d=Integer.parseInt(st.nextToken());
				if(d>=day)
				{
					reserveDays[d]=1;
				}
			}
			request.setAttribute("rday", reserveDays);
		}
		
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		request.setAttribute("week", week);
		request.setAttribute("lastday", lastday);
		request.setAttribute("weeks", weeks);
		
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
}
