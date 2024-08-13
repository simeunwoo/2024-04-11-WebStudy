package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class SeoulDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	/*
	<select id="seoulLocationListData" resultType="SeoulLocationVO" parameterType="hashmap">
	<!-- synonym(동의어)를 활용하여 테이블명을 줄일 수 있다 -->
		SELECT no,title,poster,num
		FROM (SELECT no,title,poster,rownum as num
		FROM (SELECT no,title,poster
		FROM location
		ORDER BY no ASC))
		WHERE num BETWEEN #{start} AND #{end}
	</select>
	<select id="seoulLocationTotalPage" resultType="int">
		SELECT CEIL(COUNT(*)/20.0)
		from location
	</select>
	 */
	public static List<SeoulLocationVO> seoulLocationListData(Map map)
	{
		List<SeoulLocationVO> list=new ArrayList<SeoulLocationVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("seoulLocationListData",map);
		}catch(Exception ex)
		{
			System.out.println("SeoulDAO 오류 1");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int seoulLocationTotalPage()
	{
		int total=0;
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			total=session.selectOne("seoulLocationTotalPage");
		}catch(Exception ex)
		{
			System.out.println("SeoulDAO 오류 2");
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
