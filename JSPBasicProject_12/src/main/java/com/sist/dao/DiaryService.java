package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
/*
 * 	table => VO, DAO
 * 	===== table 여러개 혼합 => Service
 *                         ======= board / reply
 *                         ======= food / jjim / like
 *	
 *	C/S => 네트워크 통신
 *
 *            request(JSP)
 *	브라우저 =====================> 서버
 *	      <=====================
 *            response(HTML)
 *  
 *                SQL 문장 PreparedStatement
 *  클라이언트 =====================> 오라클
 *         <=====================
 *              실제 저장된 데이터 PreparedStatement => OutputStream, BufferedReader
 */
public class DiaryService {
	private Connection conn;
	private PreparedStatement ps;
	private static DiaryService dao;
	
	public static DiaryService newInstance()
	{
		if(dao==null)
			dao=new DiaryService();
		return dao;
	}
	// 미리 톰캣에 의하여 생성된 Connection 주소를 얻어 온다
	/*
	 * 	=> JNDI
	 * 	=================== java://comp/env ===========
	 * 	     ====================
	 * 		new Connection() false(true) jdbc/oracle
	 * 	     ====================
	 * 		new Connection() false jdbc/oracle
	 * 	     ====================
	 * 	===============================================
	 */
	public void getConnection()
	{
		try
		{
			Context init=new InitialContext();
			Context c=(Context)init.lookup("java://comp/env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 다시 Connection 관리 영역(POOL)으로 반환 => 연결에 소모되는 시간을 절약하기 위하여
	// Connection을 일정하게 관리할 수 있다
	public void disConnection()
	{
		try
		{
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		}catch(Exception ex) {}
	}
	// 1. 로그인 => 세션 사용 => 사용자 정보 저장
	// JSP => 변경이 많다 (일반 HTML => AJAX => VUE => REACT => REDUX => REDUX-QUERY)
	// 자바> 변경이 없다 (스프링)
	public MemberVO isLogin(String id,String pwd) // ajax
	{
		MemberVO vo=new MemberVO();
		try
		{
			getConnection();
			// 1) 아이디 존재 여부 확인
			String sql="SELECT COUNT(*) FROM member "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next(); // 데이터 출력 위치로 커서 이동
			int count=rs.getInt(1);
			rs.close();
			
			if(count==0) // 아이디가 없는 경우
			{
				vo.setMsg("NOID");
			}
			else // 아이디가 있는 경우
			{
				// 2) 비밀 번호 확인
				sql="SELECT pwd,name,sex FROM member "
						+ "WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				String sex=rs.getString(3);
				rs.close();
				
				if(db_pwd.equals(pwd)) // 로그인이 된 경우 (비밀번호가 맞는 경우)
				{
					vo.setId(id);
					vo.setName(name);
					vo.setSex(sex);
					vo.setMsg("OK");
				}
				else // 비밀번호가 틀린 경우
				{
					vo.setMsg("NOPWD");
				}
			}
		}catch(Exception ex)
		{
			System.out.println("=== isLogin(String id,String pwd) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}
	/*
	 * 	로그인
	 * 	=> 매개 변수 => id, pwd => 사용자가 입력하거나 클릭
	 * 	=> 리턴형 => 결과값
		   ==== 경우의 수
		   	=> 경우의 수 1 => List/VO/int
		   	=> 경우의 수 2 => boolean
		   	=> 경우의 수 여러개 => String
	 */
	// 2. 일정 관리 => 아이디 별로
	// 2-1. 일정 등록
	public void diaryInsert(DiaryVO vo)
	{
		try
		{
			getConnection();
			String sql="INSERT INTO diary VALUES("
					+ "diary_no_seq.nextval,?,?,?,?,?,?,SYSDATE)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getMsg());
			ps.setInt(4, vo.getYear());
			ps.setInt(5, vo.getMonth());
			ps.setInt(6, vo.getDay());
			ps.executeUpdate();
		}catch(Exception ex)
		{
			System.out.println("=== diaryInsert(DiaryVO vo) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	// 2-2. 일정 출력
	// 2-3. 달력에 일정 표시
	public int diaryCheck(String id,int year,int month,int day)
	{
		int bCheck=0;
		try
		{
			getConnection();
			String sql="SELECT COUNT(*) FROM diary "
					+ "WHERE id=? AND year=? AND month=? AND day=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, year);
			ps.setInt(3, month);
			ps.setInt(4, day);
			ResultSet rs=ps.executeQuery();
			rs.next();
			bCheck=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== diaryCheck(String id,int year,int month,int day) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return bCheck;
	}
	// 2-4. 일정 수정
	// 2-5. 일정 취소
	// 3. 장바구니 => 세션 => 제공하는 메소드 정리
	// 3-1. 상품 출력
	// 3-2. 장바구니 등록 => 세션 처리
	// 3-3. 장바구니 상품 취소 => 세션 처리
	// 3-4. 구매 => 데이터베이스에 저장
	
	public void a()
	{
		try
		{
			getConnection();
		}catch(Exception ex)
		{
			System.out.println("=== diaryInsert(DiaryVO vo) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
}
