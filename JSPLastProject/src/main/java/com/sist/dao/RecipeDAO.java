package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class RecipeDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	/*
	<select id="recipeListData" resultType="RecipeVO" parameterType="hashmap">
		SELECT no,title,poster,num
		FROM (SELECT no,title,poster,rownum as num
		FROM (SELECT *+ INDEX_ASC(recipe recipe_no_pk)*no,title,poster
		FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail)))
		WHERE num BETWEEN #{start} AND #{end}
	</select>
	<select id="recipeTotalCount" resultType="int">
		SELECT COUNT(*)
		FROM recipe
		WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail)
	</select>
	 */
	public static List<RecipeVO> recipeListData(Map map)
	{
		List<RecipeVO> list=new ArrayList<RecipeVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("recipeListData",map);
		}catch(Exception ex)
		{
			System.out.println("RecipeDAO 오류 1");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int recipeTotalCount()
	{
		int count=0;
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			count=session.selectOne("recipeTotalCount");
		}catch(Exception ex)
		{
			System.out.println("RecipeDAO 오류 2");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return count;
	}
	
	public static RecipeDetailVO recipeDetailData(int no)
	{
		RecipeDetailVO vo=new RecipeDetailVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			session.update("recipeHitIncrement",no);
			session.commit();
			vo=session.selectOne("recipeDetailData",no);
		}catch(Exception ex)
		{
			System.out.println("RecipeDAO 오류 3");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	/*
	<select id="recipeChefListData" resultType="ChefVO" parameterType="hashmap">
		SELECT chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2,num
		FROM (SELECT chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2,rownum as num
		FROM (SELECT chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2
		FROM chef))
		WHERE num BETWEEN #{start} AND #{end}
	</select>
	<select id="recipeChefTotalPage" resultType="int">
		SELECT CEIL(COUNT(*)/50.0)
		FROM chef
	</select>
	 */
	public static List<ChefVO> recipeChefListData(Map map)
	{
		List<ChefVO> list=new ArrayList<ChefVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("recipeChefListData",map);
		}catch(Exception ex)
		{
			System.out.println("RecipeDAO 오류 4");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int recipeChefTotalPage()
	{
		int total=0;
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			total=session.selectOne("recipeChefTotalPage");
		}catch(Exception ex)
		{
			System.out.println("RecipeDAO 오류 5");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return total;
	}
	
	/*
	<select id="recipeChefMakeData" resultType="RecipeVO" parameterType="hashmap">
		SELECT no,title,poster,num
		FROM (SELECT no,title,poster,rownum as num
		FROM (SELECT *+ INDEX_ASC(recipe recipe_no_pk)*no,title,poster
		FROM recipe WHERE chef=#{chef}))
		WHERE num BETWEEN #{start} AND #{end}
	</select>
	<select id="recipeChefMakeTotalPage" resultType="int" parameterType="string">
		SELECT CEIL(COUNT(*)/20.0)
		FROM recipe
		WHERE chef=#{chef}
	 */
	public static List<RecipeVO> recipeChefMakeData(Map map)
	{
		List<RecipeVO> list=new ArrayList<RecipeVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("recipeChefMakeData",map);
		}catch(Exception ex)
		{
			System.out.println("RecipeDAO 오류 6");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int recipeChefMakeTotalPage(String chef)
	{
		int total=0;
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			total=session.selectOne("recipeChefMakeTotalPage",chef);
		}catch(Exception ex)
		{
			System.out.println("RecipeDAO 오류 7");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return total;
	}
}
