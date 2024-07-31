package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.Locked.Read;

import java.io.*;
/*
 * 	개발자 : 제작자 => 솔루션, 스타트업 => 주로 4년차 이상
 * 	디벨로퍼 : 조립자 => SI/SM => 주로 2~3년차
 * 	코더 => 주로 1년차
 */
public class BoardDAO {

	// XML을 읽어서 저장 => Map("id", SQL) => 파싱
	private static SqlSessionFactory ssf;
	static
	{
		try
		{
			Reader reader=Resources.getResourceAsReader("Config.xml"); // 파일명 => 대소문자 구분
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/*
	 * <select id="boardListData" resultType="BoardVO" parameterType="hashmap">
		SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num
		FROM (SELECT no,subject,name,regdate,hit,rownum as num
		FROM (SELECT + INDEX_DESC(board board_no_pk) no,subject,name,regdate,hit
		FROM board))
		WHERE num BETWEEN #{start} AND #{end}
		</select>
		
		resultType="BoardVO" => 결과값 : ResultSet
		parameterType="hashmap" => ?
	 */
	public static List<BoardVO> boardListData(Map map)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			list=session.selectList("boardListData", map); // selectList : 여러 행
			//           ---------- => SQL 문장 / VO
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close(); // connection 반환
		}
		
		return list;
	}
}
