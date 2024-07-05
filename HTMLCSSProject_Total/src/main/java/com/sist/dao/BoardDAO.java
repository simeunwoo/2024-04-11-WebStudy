package com.sist.dao;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;
import com.sist.database.*;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static BoardDAO dao;
	private DataBaseConnection dbConn=new DataBaseConnection();
	
	public static BoardDAO newInstance()
	{
		if(dao==null)
			dao=new BoardDAO();
		return dao;
	}
	// 싱글턴
	// 1. 기능
	// 1-1. 목록 => SELECT (페이지 나누기) => 인라인뷰 => <table>, <a>
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,num "
					+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					+ "FROM (SELECT /*+INDEX_DESC(board board_no_pk)*/ no,subject,name,regdate,hit "
					+ "FROM board)) "
					+ "WHERE num BETWEEN ? AND ?";
					// ORDER BY보다는 INDEX_ASC(테이블명 PK) => index는 pk, uk는 자동 생성
			ps=conn.prepareStatement(sql);
			// 실행 전에 ?의 값부터 채운다
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1); // rownum은 1번부터 시작
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDb_day(rs.getString(4));
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
			dbConn.disConnection(conn, ps);
		}
		return list;
	}
	// 1-2. 총 페이지
	public int boardTotalPage()
	{
		int total=0;
		try 
		{
			conn=dbConn.getConnection();
			String sql="SELECT COUNT(*) FROM board";
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
			dbConn.disConnection(conn, ps);
		}
		return total;
	}
	// 2. 상세 보기 => SELECT (WHERE) => <table>
	public BoardVO boardDetailData(int no)
	{
		// 상세 보기 => 반드시 Primary Key 값을 넘겨준다 (중복이 없는 데이터)
		BoardVO vo=new BoardVO();
		try
		{
			conn=dbConn.getConnection();
			String sql="UPDATE board SET "
					+ "hit=hit+1 "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate(); // 조회수 증가 완료 => commit() 수행까지 완료
			
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
			vo.setDb_day(rs.getString(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== boardDetailData(int no) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn, ps);
		}
		return vo;
	}
	// 3, 글쓰기 => input
	public void boardInsert(BoardVO vo)
	{
		try
		{
			conn=dbConn.getConnection();
			String sql="INSERT INTO board VALUES("
					+ "board_no_seq.nextval,?,?,?,?,SYSDATE,0)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.executeUpdate();
		}catch(Exception ex)
		{
			System.out.println("=== boardInsert(BoardVO vo) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn, ps);
		}
	}
	// 4. 수정하기 => input
	// 5. 삭제하기 => input
	// 6. 검색 => <select>
}
