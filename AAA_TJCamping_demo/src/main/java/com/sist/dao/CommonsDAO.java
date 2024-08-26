package com.sist.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class CommonsDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static List<CampVO> commonsTodayCampsite()
	{
		List<CampVO> list=new ArrayList<CampVO>();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			 list=session.selectList("commonsTodayCampsite");
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	public static List<FoodVO> commonsTodayFood()
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("commonsTodayFood");
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	public static List<RecipeVO> commonsTodayRecipe()
	{
		List<RecipeVO> list=new ArrayList<RecipeVO>();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("commonsTodayRecipe");
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
}
