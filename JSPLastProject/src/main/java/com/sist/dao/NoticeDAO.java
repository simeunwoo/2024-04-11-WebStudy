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
			session.insert("noticeInsert",vo);
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
	
	// 수정
	public static NoticeVO noticeUpdateData(int no)
	{
		NoticeVO vo=new NoticeVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			vo=session.selectOne("noticeUpdateData",no);
		}catch(Exception ex)
		{
			System.out.println("NoticeDAO 오류 5");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	// 수정
	/*
	<update id="noticeUpdate" parameterType="NoticeVO">
		UPDATE notice SET
		type=#{type},subject=#{subject},content=#{content}
		WHERE no=#{no}
	</update>
	 */
	public static void noticeUpdate(NoticeVO vo)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true);
			session.update("noticeUpdate",vo);
		}catch(Exception ex)
		{
			System.out.println("NoticeDAO 오류 6");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	// 삭제
	/*
	<delete id="noticeDelete" parameterType="int">
		DELETE FROM notice
		WHERE no=#{no}
	</delete>
	 */
	public static void noticeDelete(int no)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true);
			session.delete("noticeDelete",no);
		}catch(Exception ex)
		{
			System.out.println("NoticeDAO 오류 7");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	/*
	<update id="noticeHitIncrement" parameterMap="int">
		UPDATE notice SET
		hit=hit+1
		WHERE no={#no}
	</update>
	 */
	public static NoticeVO noticeDetailData(int no)
	{
		NoticeVO vo=new NoticeVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true);
			session.update("noticeHitImcrement",no);
			vo=session.selectOne("noticeUpdateData",no);
		}catch(Exception ex)
		{
			System.out.println("NoticeDAO 오류 8");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
}
