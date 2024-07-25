package com.sist.model;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.commons.CommonsModel;
import com.sist.controller.*;
import com.sist.dao.*;
import com.sist.vo.*;

public class MainModel {

	@RequestMapping("main/main.do")
	public String main_page(HttpServletRequest request,HttpServletResponse response)
	{
		FoodDAO fDao=FoodDAO.newInstance();
		List<FoodVO> fList=fDao.foodTop12();
		
		SeoulDAO sDao=SeoulDAO.newInstance();
		List<LocationVO> sList=sDao.seoulTop12();
		
		GoodsDAO gDao=GoodsDAO.newInstance();
		List<GoodsVO> gList=gDao.goodsTop12();
		
		// Cookie
		Cookie[] cookies=request.getCookies(); // 브라우저 쿠키를 읽을 때 사용
		List<FoodVO> cList=new ArrayList<FoodVO>();
		
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("food_"))
				{
					String fno=cookies[i].getValue();
					FoodVO vo=fDao.foodDetailData(Integer.parseInt(fno));
					cList.add(vo);
				}
			}
		}
		
		List<FoodVO> foodList=fDao.foodFooterData();
		
		request.setAttribute("fList", fList);
		request.setAttribute("sList", sList);
		request.setAttribute("gList", gList);
		request.setAttribute("cList", cList);
		request.setAttribute("foodList", foodList);
		
		request.setAttribute("main_jsp","../main/home.jsp");
		CommonsModel.commonsData(request);
		return "../main/main.jsp";
	}
}
