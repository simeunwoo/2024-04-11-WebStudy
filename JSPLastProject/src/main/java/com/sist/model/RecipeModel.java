package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class RecipeModel {
	// 리턴형 => String : 데이터 전송 및 화면 변경 / void(Ajax) : 데이터만 전송
	// _ok.do => redirect
	@RequestMapping("recipe/recipe_list.do")
	public String recipe_list(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../recipe/recipe_list.jsp");
		return "../main/main.jsp";
	}
}
