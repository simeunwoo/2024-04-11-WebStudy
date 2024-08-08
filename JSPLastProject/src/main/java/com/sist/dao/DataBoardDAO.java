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
	
	/*
	<update id="databoardHitIncrement" parameterType="int">
		UPDATE project_databoard SET
		hit=hit+1
		WHERE no=#{no}
	</update>
	<select id="databoardDetailData" resultType="DataBoardVO" parameterType="int">
		SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,
			hit,filename,filesize
		FROM project_databoard
		WHERE no=#{no}
	</select>
	 */
	public static DataBoardVO databoardDetailData(int no)
	{
		DataBoardVO vo=new DataBoardVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			session.update("databoardHitIncrement",no);
			session.commit();
			/*
			 * 	insert, update, delete 시에
			 * 		(1) openSession(true)으로 커밋
			 * 		or
			 * 		(2) session.commit()으로 커밋
			 */
			vo=session.selectOne("databoardDetailData",no);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 4");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
}
