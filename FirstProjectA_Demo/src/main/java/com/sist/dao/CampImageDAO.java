package com.sist.dao;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CampImageDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static CampImageVO campDetailImageData(int no)
	{
		
		CampImageVO vo=new CampImageVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			vo=session.selectOne("campDetailImageData", no);
		}catch(Exception ex)
		{
			System.out.println("CampImageDAO 오류 1");
			ex.printStackTrace();
		}
		finally
		{
			// connection 반환 (DBCP) => 재사용(반환 시 가능)
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
}
