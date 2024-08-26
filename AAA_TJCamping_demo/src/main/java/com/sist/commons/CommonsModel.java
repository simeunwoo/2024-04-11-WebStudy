package com.sist.commons;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class CommonsModel {

	public static void footerPrint(HttpServletRequest request)
	{
		List<CampVO> footAList=CommonsDAO.commonsTodayCampsite();
		List<FoodVO> footBList=CommonsDAO.commonsTodayFood();
		List<RecipeVO> footCList=CommonsDAO.commonsTodayRecipe();
		
	//	int a=(int)(Math.random()*100)+1;
	//	int b=(int)(Math.random()*100)+1;
	//	int c=(int)(Math.random()*100)+1;
		
		request.setAttribute("footAList", footAList);
		request.setAttribute("footBList", footBList);
		request.setAttribute("footCList", footCList);
	}
}
