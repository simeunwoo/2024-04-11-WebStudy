package com.sist.dao;
import java.util.*;

import com.sist.database.DataBaseConnection;

import java.sql.*;
/*
 * 	클래스의 종류 (역할) => 클래스는 한개의 기능을 수행 => 컴포넌트
 * 
 * 	VO => 데이터를 모아서 한번에 브라우저 / 모바일로 전송
 * 	DAO => 데이터베이스 연동
 * 	Manager => 관리 => 데이터 수집 / Open API
 * 	Service => 사용자 요청에 대한 처리
 * 	Model(Controller) => 사용자 요청을 받아서 => 결과를 전송
 * 	================= MVC (Spring MVC)
 */
/*             JSP 프로젝트   Spring 프로젝트  Spring-Boot => 개인 프로젝트
 * 	JDBC =====> DBCP =====> ORM =====> DataSet - 자동 SQL 문장을 만들어 준다 (JPA)
 * 	  |           |          |
 * 	 기본        연결 속도      라이브러리 (데이터베이스만 연결)
 *           Connection 관리   MyBatis
 *  
 *  자격 요건 : Spring 가능자, JQuery | Vue | React, MySQL, Spring-Boot, AWS
 *           ===========
 *           Java + JSP + Oracle => Full Stack
 *           우대 : 리눅스, 정보 처리, DevOps
 *                              ====== 개발+운영 => Docker / 쿠바네티스 / 젠킨스
 *                              => 실시간 배포 (CI / CD)
 *	
 *	프로그램 => 데이터 관리
 *           =======
 *           1. 변수 => 배열 / 클래스 / 파일 / RDBMS
 *           2. 연산자
 *           3. 제어문
 */
public class FoodDAO {
	private Connection conn; // 오라클 연결 담당
	private PreparedStatement ps; // SQL 문장 전송 => 실행 결과를 가지고 온다
	//      미리 SQL 문장을 전송하고 필요한 데이터는 나중에 전송을 한다
	//                        ================== 값을 채울 때 '?' 활용 가능
	private static FoodDAO dao;
	// 싱글턴 => 메모리 공간을 1개만 사용 => 메모리 누수 현상을 방지, Connection을 남발하지 않는다
	// => 서버의 부하를 줄일 목적
	private DataBaseConnection dbConn=new DataBaseConnection();
	// 연결 / 해제 => 50명 => 모든 데이터베이스에서 공통 사용 기능 => 라이브러리화
	
	// 싱글턴
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	// 기능 수행
	public List<FoodVO> foodListData()
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		/*
		 * 	예외 처리
		 *  ======
		 *  java.sql, java.io, java.net => 컴파일 예외 (반드시 예외 처리를 한다)
		 */
		try
		{
			// 연결
			conn=dbConn.getConnection();
			// SQL 문장 제작
			String sql="SELECT fno,name,poster,rownum "
					+ "FROM food_house "
					+ "WHERE rownum<=20";
			// SQL 문장 전송
			ps=conn.prepareStatement(sql);
			// 필요한 데이터가 있는지 확인 => '?' 참고
			// 오라클에서 실행된 결과값을 받는다
			ResultSet rs=ps.executeQuery();
			// List에 첨부 후에 전송 준비
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3).replace("https", "http"));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== foodListData() 오류 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn, ps);
		}
		return list;
	}
}
