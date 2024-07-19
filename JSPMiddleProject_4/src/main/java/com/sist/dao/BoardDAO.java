package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
/*
 * 	1. 톰캣이 => Connection 생성 => 지정된 개수 (maxIdle=10) => POOL 안에 저장
 * 	2. 사용자 요청 시마다 Connection의 주소를 얻어온다 : getConnection()
 *     ===================================
 * 	3. Connection을 사용
 * 	4. 사용 후에 반환 : disConnection()
 *     =========================== 모든 기능에 공통 사용 => 메소드화 (공통 모듈 : Spring에서 AOP)
 */
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static BoardDAO dao;
	
	public static BoardDAO newInstance()
	{
		if(dao==null)
			dao=new BoardDAO();
		return dao;
	}
	// Connection 주소 얻기
	public void getConnection()
	{
		try
		{
			// 탐색기 => POOL 구조가 탐색 시 형식 => JNDI
			// 1. 탐색 시 열기
			Context init=new InitialContext();
			// 2. C드라이버에 접근
			Context c=(Context)init.lookup("java://comp/env");
			// 3. 원하는 폴더 선택
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			// 4. Connection의 주소를 얻어 온다
			conn=ds.getConnection();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 사용 후에 반환 => 반복 (메소드화)
	// 메소드 => 1. 한개의 기능에 해당되는 명령문을 모으기
	// 2. 반복적인 명령문이 있는 경우
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
	// 사용자 요청 기능
	// 1. 목록 => 게시물 여러개 출력
	// 게시물 한개 (VO), 게시물 여러개 (List)
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		try
		{
			getConnection(); // Connection 주소 얻기
			// SQL 문장 제작
			String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,num "
					+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					+ "FROM (SELECT /*+ INDEX_DESC(board board_no_pk)*/no,subject,name,regdate,hit "
					+ "FROM board)) "
					+ "WHERE num BETWEEN ? AND ?";
			// SQL 문장을 오라클에 전송
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			// 실행 결과를 가지고 온다
			ResultSet rs=ps.executeQuery();
			// List에 첨부
			while(rs.next())
			{
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== boardListData(int page) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection(); // 반환
		}
		return list;
	}
	// 1-1. 총 페이지
	public int boardTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/10.0) FROM board";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== boardTotalPage() 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return total;
	}
	// 2. 상세 보기
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		try
		{
			getConnection();
			String sql="UPDATE board SET "
					+ "hit=hit+1 "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			// 실제 데이터 읽기
			sql="SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD'),hit "
					+ "FROM board "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setDbday(rs.getString(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== boardDetailData(int no) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}
	// 3. 추가
	public void boardInsert(BoardVO vo)
	{
		try
		{
			getConnection();
			String sql="INSERT INTO board VALUES("
					+ "board_no_seq.nextval,?,?,?,?,SYSDATE,0)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.executeUpdate(); // commit()이 포함됨
		}catch(Exception ex)
		{
			System.out.println("=== boardInsert(BoardVO vo) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	// 4. 수정
	public BoardVO boardUpdateData(int no)
	{
		BoardVO vo=new BoardVO();
		try
		{
			getConnection();
			String sql="SELECT no,name,subject,content "
					+ "FROM board "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== boardUpdateData(int no) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}
	
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		try
		{
			getConnection();
			// 비밀 번호 확인
			String sql="SELECT pwd FROM board "
					+ "WHERE no="+vo.getNo();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(vo.getPwd()))
			{
				bCheck=true;
				// 수정
				sql="UPDATE board SET "
						+ "name=?,subject=?,content=? "
						+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				ps.executeUpdate();
			}
			else
			{
				bCheck=false;
			}
		}catch(Exception ex)
		{
			System.out.println("=== boardUpdate(BoardVO vo) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return bCheck;
	}
	// 5. 삭제
	public boolean boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		try
		{
			getConnection();
			// 비밀 번호 확인
			String sql="SELECT pwd FROM board WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(pwd))
			{
				bCheck=true;
				sql="DELETE FROM board WHERE no="+no;
				ps=conn.prepareStatement(sql);
				ps.executeUpdate();
			}
		}catch(Exception ex)
		{
			System.out.println("=== boardDelete(int no,String pwd) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return bCheck;
	}
	// 6. => 답변
}
