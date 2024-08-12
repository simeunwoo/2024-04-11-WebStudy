package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class FoodDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	/*
	<select id="foodHitTopData">
		SELECT fno,name,poster,rownum
		FROM (SELECT fno,name,poster
		FROM project_food_house ORDER BY hit DESC)
		WHERE rownum&lt;=12
	</select>
	<select id="foodLikeTopData">
		SELECT fno,name,poster,rownum
		FROM (SELECT fno,name,poster
		FROM project_food_house ORDER BY likecount DESC)
		WHERE rownum&lt;=12
	</select>
	<select id="foodJjimTopData">
		SELECT fno,name,poster,rownum
		FROM (SELECT fno,name,poster
		FROM project_food_house ORDER BY jjimcount DESC)
		WHERE rownum&lt;=12
	</select>
	 */
	// hit가 많은 맛집
	public static List<FoodVO> foodHitTopData()
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		SqlSession session=null;

		try
		{
			session=ssf.openSession();
			list=session.selectList("foodHitTopData");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("FoodDAO 오류 1");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	// like가 많은 맛집
	public static List<FoodVO> foodLikeTopData()
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		SqlSession session=null;

		try
		{
			session=ssf.openSession();
			list=session.selectList("foodLikeTopData");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("FoodDAO 오류 2");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	// jjim이 많은 맛집
	public static List<FoodVO> foodJjimTopData()
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		SqlSession session=null;

		try
		{
			session=ssf.openSession();
			list=session.selectList("foodJjimTopData");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("FoodDAO 오류 3");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int foodListCount()
	{
		int count=0;
		SqlSession session=null;

		try
		{
			session=ssf.openSession();
			count=session.selectOne("foodListCount");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("FoodDAO 오류 4");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return count;
	}
}
