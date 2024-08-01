package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.Locked.Read;

import java.io.*;
// 아이디 중복 체크
// 우편 번호 검색
// => 윈도우 => window.open()
/*
 * 	브라우저 내장 객체 / 내장 객체
 * 
 * 	브라우저 내장 객체
 * 	= window => open() / reload()
 * 		= document
 * 			= write()
 * 			= getElementById()
 * 			= querySelector()
 * 			= querySelectorAll()
 * 		= location
 * 			= href
 * 		= history
 * 			= back()
 * 			= go
 * 			= forward()
 * 		= Date / String / Math / Array => 라이브러리 : jQuery / Vue / React / Next
 * 		                                  => 변수 / 상수 / 제어문 / 연산자 / 배열 ... 은 미리 알고 있어야 한다
 * 		                                  => 객체(JSON)
 * 
 *  이벤트 처리
 *  = onclick
 *  = onchange
 *  = onmouseover : hover() 관련
 *  = onmouseout : hover() 관련
 *  = onkeyup
 *  = onkeydown
 */
public class MemberDAO {

	private static SqlSessionFactory ssf; // xml을 읽어서 저장
	static
	{
		try
		{
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// 기능 설정
	// => 표준화
	public static List<ZipcodeVO> postFind(String dong)
	{
		List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		SqlSession session=null;
		try
		{
			session=ssf.openSession(); // getConnection이 된 상태 / session : 커넥션 
			list=session.selectList("postFind", dong);
		}catch(Exception ex)
		{
			System.out.println("오류 1");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close(); // 반환
		}
		return list;
	}
	
	public static int postFindCount(String dong)
	{
		int count=0;
		SqlSession session=null;
		try
		{
			session=ssf.openSession(); // getConnection이 된 상태 / session : 커넥션 
			count=session.selectOne("postFindCount", dong);
		}catch(Exception ex)
		{
			System.out.println("오류 2");
			ex.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close(); // 반환
		}
		return count;
	}
	
	/*
	<select id="idcheck" resultType="int" parameterType="string">
		SELECT COUNT(*)
		FROM member
		WHERE id=#{id}
	</select>
	 */
	public static int idcheck(String id)
	{
		int count=0;
		SqlSession session=null; // connection
		try
		{
			session=ssf.openSession();
			count=session.selectOne("idcheck", id);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류 3");
			e.printStackTrace();
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		return count;
	}
}
