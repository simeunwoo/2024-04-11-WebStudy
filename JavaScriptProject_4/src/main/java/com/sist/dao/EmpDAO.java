package com.sist.dao;
import java.util.*;
import java.io.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.*;
public class EmpDAO {

	// XML을 파싱
	private static SqlSessionFactory ssf;
	static
	{
		try
		{
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	// <select id="empListData" resultType="EmpVO">
	public static List<EmpVO> empListData()
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			list=session.selectList("empListData");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close(); // connection 반환
		}
		
		return ssf.openSession().selectList("empListData"); // selectList : 여러 행
	}
	
	// <select id="empDetailData" resultType="EmpVO" parameterType="int">
	public static EmpVO empDetailData(int empno)
	{
		return ssf.openSession().selectOne("empDetailData", empno); // selectOne : 단일 행
	}
}
