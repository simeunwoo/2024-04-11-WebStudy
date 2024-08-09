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
	
	/*
	<select id="databoardGetPassword" resultType="string" parameterType="int">
		SELECT pwd
		FROM databoard
		WHERE no=#{no}
	</select>
	<select id="databoardFileInfoData" resultType="DataBoardVO" parameterType="int">
		SELECT filename,filesize
		FROM databoard
		WHERE no=#{no}
	</select>
	<delete id="databoardDelete" parameterType="int">
		DELETE FROM databoard
		WHERE no=#{no}
	</delete>
	 */
	public static DataBoardVO databoardFileInfoData(int no)
	{
		// 폴더에서 파일 삭제
		DataBoardVO vo=new DataBoardVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			vo=session.selectOne("databoardFileInfoData",no);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 5");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	// 실제 삭제
	public static String databoardDelete(int no,String pwd)
	{
		String result="no";
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			String db_pwd=session.selectOne("databoardGetPassword", no);
			if(db_pwd.equals(pwd))
			{
				result="yes";
				session.delete("databoardReplyDelete",no);
				session.delete("databoardDelete",no);
				session.commit();
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 6");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return result;
	}
	
	public static DataBoardVO databoardUpdateData(int no)
	{
		DataBoardVO vo=new DataBoardVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			vo=session.selectOne("databoardDetailData",no);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 7");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return vo;
	}
	
	public static String databoardGetPassword(int no)
	{
		String pwd="";
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			pwd=session.selectOne("databoardGetPassword",no);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 8");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return pwd;
	}
	
	/*
	<update id="databoardUpdate" parameterType="DataBoardVO">
		UPDATE project_databoard SET
		name=#{name},subject=#{subject},content=#{content},
			filename=#{filename},filesize=#{filesize}
		WHERE no=#{no}
	</update>
	 */
	public static void databoardUpdate(DataBoardVO vo)
	{
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true);
			session.update("databoardUpdate",vo);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 9");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	/*
	<select id="databoardFindData" resultType="DataBoardVO" parameterType="hashmap">
		SELECT no,name,subject,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit
		FROM project_databoard
		WHERE ${fs} LIKE '%'||#{ss}||'%'
	</select>
	 */
	public static List<DataBoardVO> databoardFindData(Map map)
	{
		List<DataBoardVO> list=new ArrayList<DataBoardVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession(true);
			list=session.selectList("databoardFindData",map);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("BoardDAO 오류 10");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
}
