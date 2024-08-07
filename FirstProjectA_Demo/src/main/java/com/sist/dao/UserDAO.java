package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import com.sist.vo.*;
import lombok.Locked.Read;

public class UserDAO {

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
	
	public String userLogin(String id,String pwd)
	{
		String result="";
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			result=session.selectOne("userLogin",id);
		}catch(Exception ex)
		{
			System.out.println("UserDAO 오류 1");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return result;
	}
}
