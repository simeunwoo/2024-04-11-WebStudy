package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.BoardVO;

public class BoardDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	/*
	<insert id="boardInsert" parameterType="BoardVO">
		<selectKey keyProperty="no" resultType="int" order="BEFORE">
			SELECT NVL(MAX(no)+1,1) as no
			FROM project_board
		</selectKey>
		INSERT INTO project_board(no,name,subject,content,pwd)
		VALUES(#{no},#{name},#{subject},#{content},#{pwd})
	</insert>
	 */
	public static void boardInsert(BoardVO vo)
	{
		SqlSession session=null;
		
		try
		{
			// 연결 => Connection 주소 얻기 => DBCP : 미리 Connection 객체를 여러개 생성
			// Connection => 오라클 연결 시간이 오래 걸린다
			// 장점 : 미리 만들면 연결에 소모되는 시간을 줄일 수 있다, Connection 객체를 조절할 수 있다
			// openSession() => autoCommit(false) : 자동 커밋 X => 저장이 안됨
			// => openSession(true) => autoCommit(true) : 자동 커밋 => 저장이 됨
			session=ssf.openSession(true);
			session.insert("boardInsert",vo);
		}catch(Exception ex)
		{
			System.out.println("BoardDAO 오류 1");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close(); // 반환 (DBCP 사용)
		}
	}
	
	/*
	<select id="boardListData" resultType="BoardVO" parameterType="hashmap">
		SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num
		FROM (SELECT no,subject,name,regdate,hit,rownum as num
		FROM (SELECT no,subject,name,regdate,hit
		FROM project_board))
		WHERE num BETWEEN #{start} AND #{end}
	</select>
	 */
	public static List<BoardVO> boardListData(Map map)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			list=session.selectList("boardListData",map);
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
	
	/*
	<select id="boardRowCount" resultType="int">
		SELECT COUNT(*)
		FROM project_board	
	</select>
	 */
	public static int boardRowCount()
	{
		int count=0;
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			count=session.selectOne("boardRowCount");
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
	<update id="hitIncrement" parameterType="int">
		UPDATE project_board SET
		hit=hit+1
		WHERE no=#{no}
	</update>
	<select id="boardDetailData" resultType="BoardVO" parameterType="int">
		SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,hit
		FROM project_board
		WHERE no=#{no}
	</select>
	 */
	public static BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			session.update("hitIncrement",no);
			session.commit(); // autoCommit()이 안되었으므로 직접 설정
			vo=session.selectOne("boardDetailData",no);
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
	
	public static BoardVO boardUpdateData(int no)
	{
		BoardVO vo=new BoardVO();
		SqlSession session=null;
		
		try
		{
			session=ssf.openSession();
			vo=session.selectOne("boardDetailData",no); // boardDetailData로 사용해야 한다
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
}
