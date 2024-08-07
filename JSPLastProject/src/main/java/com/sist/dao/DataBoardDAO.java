package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class DataBoardDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static void databoardInsert(DataBoardVO vo)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true);
			session.insert("databoardInsert",vo);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 1");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public static List<DataBoardVO> databoardListData(Map map)
	{
		List<DataBoardVO> list=new ArrayList<DataBoardVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("databoardListData",map);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 2");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	public static int databoardRowCount()
	{
		int count=0;
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			count=session.selectOne("databoardRowCount");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 3");
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
