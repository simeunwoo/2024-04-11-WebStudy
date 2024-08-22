package com.sist.model;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;

public class ReserveModel {

	@RequestMapping("camp/reserve.do")
	public String camp_reserve(HttpServletRequest request,HttpServletResponse response)
	{
		String camp_no=request.getParameter("camp_no");
		
	//	String day=request.getParameter("day");
		
		String strYear=request.getParameter("year");
		String strMonth=request.getParameter("month");
		String strDay="";
		String strCno=request.getParameter("cno");
		
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
		int day1=Integer.parseInt(strDay);
		
		// 요일 / 마지막 날 구하기
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		int week=cal.get(Calendar.DAY_OF_WEEK);
		week=week-1;
		int lastday=cal.getActualMaximum(Calendar.DATE);
		
		String[] weeks={"일","월","화","수","목","금","토"};
		
		// 예약 가능한 날 ex) 1, 2, 5, 17, 24, 25, 27 ...
		if(strCno!=null)
		{
			String rdays=ReserveDAO.campReserveDayData(Integer.parseInt(strCno));
			int[] reserveDays=new int[32];
			
			if(month==Integer.parseInt(tmonth) && year==Integer.parseInt(tyear))
			{
				st=new StringTokenizer(rdays,",");
				while(st.hasMoreTokens())
				{
					int d=Integer.parseInt(st.nextToken());
					if(d>=day1)
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
		
		CampVO vo=CampDAO.campReserveData(Integer.parseInt(camp_no));
		
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day1", day1);
		request.setAttribute("week", week);
		request.setAttribute("weeks", weeks);
		request.setAttribute("lastday", lastday);
		request.setAttribute("strCno", strCno);
		
		request.setAttribute("vo", vo);
		

		
		// 데이터베이스 연동
/*		String times=ReserveDAO.campReserveTimeData(Integer.parseInt(day));
		List<String> tList=new ArrayList<String>();
		StringTokenizer st1=new StringTokenizer(times,",");
		while(st1.hasMoreTokens())
		{
			String time=ReserveDAO.campTimeSelectData(Integer.parseInt(st1.nextToken()));
			tList.add(time);
		}
		
		request.setAttribute("tList", tList);  */
		

		
		request.setAttribute("main_jsp", "../camp/reserve.jsp");
		return "../main/main.jsp";
	}
	
	
	@RequestMapping("camp_/reserve_ok.do")
	public String reserve_ok(HttpServletRequest request,HttpServletResponse response)
	{
		// 예약 정보 출력
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		
		String cno=request.getParameter("cno");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String inwon=request.getParameter("inwon");
		
		System.out.println("맛집 번호 : "+cno);
		System.out.println("예약일 : "+date);
		System.out.println("예약 시간 : "+time);
		System.out.println("예약 인원 : "+inwon);
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		ReserveVO vo=new ReserveVO();
		vo.setCno(Integer.parseInt(cno));
		vo.setDay(date);
		vo.setTime(time);
		vo.setInwon(inwon);
		vo.setId(id);
		
		ReserveDAO.campReserveInsert(vo);
		
		return "redirect:../mypage/mypage_reserve.do";
	}
}
