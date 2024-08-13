package com.sist.dao;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AllReplyDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	/*
	<insert id="allReplyInsert" parameterType="AllReplyVO">
		INSERT INTO all_reply VALUES(
		(SELECT NVL(MAX(rno)+1,1) FROM all_reply),
		#{cno},#{type},#{id},#{name},#{msg},SYSDATE)
	</insert>
	<select id="allReplyListData" resultType="AllReplyVO" parameterType="hashmap">
		SELECT rno,cno,type,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday
		FROM all_reply
		WHERE cno=#{cno} AND type=#{type}
		ORDER BY rno DESC
	</select>
	 */
	public static void allReplyInsert(AllReplyVO vo)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true);
			// openSession에 true를 하는 경우 => insert/update/delete를 단독으로 하는 경우
			session.insert("allReplyInsert",vo);
			/*
			 * 	insert / update / delete => autoCommit()
			 * 	select + update => commit()
			 * 	insert + update => commit() => transaction
			 */
		}catch(Exception ex)
		{
			System.out.println("AllReplyDAO 오류 1");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public static List<AllReplyVO> allReplyListData(Map map)
	{
		List<AllReplyVO> list=new ArrayList<AllReplyVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("allReplyListData",map);
		}catch(Exception ex)
		{
			System.out.println("AllReplyDAO 오류 2");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	
	// 삭제
	/*
	<delete id="allReplyDelete" parameterType="int">
		DELETE FROM all_reply
		WHERE rno=#{rno}
	</delete>
	 */
	public static void allReplyDelete(int rno)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true);
			session.delete("allReplyDelete",rno);
		}catch(Exception ex)
		{
			System.out.println("AllReplyDAO 오류 3");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
}
