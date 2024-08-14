package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class NoticeDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	// 목록
	public static List<NoticeVO> noticeListData(Map map)
	{
		List<NoticeVO> list=new ArrayList<NoticeVO>();
		SqlSession session=null;// Connection => Sqlsession
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("noticeListData",map);
		}catch(Exception ex)
		{
			System.out.println("NoticeDAO 오류 1");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	// 공지 추가
	public static void noticeInsert(NoticeVO vo)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true);
			session.insert("noticeInser",vo);
		}catch(Exception ex)
		{
			System.out.println("NoticeDAO 오류 2");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	// 공지 사항 총 개수 읽기 => 일렬로 번호 출력
	public static int noticeRowCount()
	{
		int count=0;
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			count=session.selectOne("noticeRowCount");
		}catch(Exception ex)
		{
			System.out.println("NoticeDAO 오류 3");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return count;
	}
	
	/*
	<select id="noticeTop5Data" resultType="NoticeVO">
		SELECT no,type,subject,rownum
		FROM (SELECT no,type,subject
		FROM notice
		ORDER BY hit DESC)
		WHERE rownum&lt;=5
	</select>
	 */
	public static List<NoticeVO> noticeTop5Data()
	{
		List<NoticeVO> list=new ArrayList<NoticeVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("noticeTop5Data");
		}catch(Exception ex)
		{
			System.out.println("NoticeDAO 오류 4");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
				
		return list;
	}
}
