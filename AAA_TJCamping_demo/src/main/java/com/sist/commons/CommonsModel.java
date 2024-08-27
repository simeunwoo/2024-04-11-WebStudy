package com.sist.commons;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class CommonsModel {

	public static void footerPrint(HttpServletRequest request)
	{
		CampVO cvo=CommonsDAO.commonsTodayCampsite();
		FoodVO fvo=CommonsDAO.commonsTodayFood();
		RecipeVO rvo=CommonsDAO.commonsTodayRecipe();
		
		request.setAttribute("cvo", cvo);
		request.setAttribute("fvo", fvo);
		request.setAttribute("rvo", rvo);
	}
}
