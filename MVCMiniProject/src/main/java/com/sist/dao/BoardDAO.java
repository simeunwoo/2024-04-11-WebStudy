package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dao.DbcpConnection;
import com.sist.vo.BoardVO;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static BoardDAO dao;
	private DbcpConnection dbConn=new DbcpConnection();
	
	public static BoardDAO newInstance()
	{
		if(dao==null)
			dao=new BoardDAO();
		return dao;
	}
	
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		// list에 값을 채워서 브라우저로 전송
		// Model에서 처리 => Controller => JSP => 브라우저
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,num "
					+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					+ "FROM (SELECT no,subject,name,regdate,hit "
					+ "FROM board ORDER BY no DESC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
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
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setRownum(rs.getInt(6));
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
	
	public int boardRowCount() // TotalPage vs RowCount 유의
	{
		int total=0;
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT COUNT(*) FROM board"; // CEIL vs COUNT 유의
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
	// 글 쓰기
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
			ps.executeUpdate(); // commit() : INSERT / UPDATE / DELETE
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
	// 상세 보기
	/*
	 * 	화면(JSP)
	 * 	= 오라클에 저장된 데이터 => 80%
	 * 		=> 공유된 데이터
	 * 	= 크롤링 / 공공 데이터 포털 / SNS => API
	 * 
	 * 	1. 1차 => 데이터베이스 사용, MVC 이해 (구조/동작), 자바스크립트
	 * 		*** AWS
	 * 	2. 2차 => Spring 이해 / 기능(보안, 스케쥴러 ...), MyBatis, 최신 Front => Vue
	 * 		*** AWS
	 * 	3. 3차 => 신기술 : Spring-Boot, MySQL, JPA
	 * 		=> Redux, React-Query
	 */
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		try
		{
			conn=dbConn.getConnection();
			String sql="UPDATE board SET "
					+ "hit=hit+1"
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			sql="SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD') "
					+ "FROM board "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setHit(rs.getInt(5));
			vo.setDbday(rs.getString(6));
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
}
