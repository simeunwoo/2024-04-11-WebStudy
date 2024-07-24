package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dao.DbcpConnection;
import com.sist.vo.*;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	private DbcpConnection dbConn=new DbcpConnection();
	
	private final int ROWSIZE=20;
	
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	public List<FoodVO> foodTop12()
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT fno,name,poster,rownum "
					+ "FROM (SELECT fno,name,poster "
					+ "FROM food_house ORDER BY hit DESC) "
					+ "WHERE rownum<=12";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn,ps);
		}
		
		return list;
	}
	// 목록 출력
	/*
	 * 	Controller는 이미 제작 완료 (스프링)
	 * 	=> 웹
	 * 	1. 요청 => 어떤 값을 보낼지
	 * 		<a> => ?key=value => request.getParameter()
	 * 	2. 어떤 JSP에 결과를 보내줄지
	 * 		request.setAttribute()
	 * 	3. 데이터베이스(SQL 문장)
	 */
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT fno,name,poster,num "
					+ "FROM (SELECT fno,name,poster,rownum as num "
					+ "FROM (SELECT fno,name,poster "
					+ "FROM food_house ORDER BY fno ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int start=(ROWSIZE*page)-(ROWSIZE-1);
			int end=ROWSIZE*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			// selectList()(MyBatis)
			ResultSet rs=ps.executeQuery();
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
			System.out.println("=== foodListData(int page) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn,ps);
		}
		return list;
	}
	// 총 페이지 구하기
	public int foodTotalPage()
	{
		int total=0;
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/"+ROWSIZE+") FROM food_house";
			ps=conn.prepareStatement(sql);
			// selectOne()(MyBatis)
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== foodTotalPage() 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn,ps);
		}
		return total;
	}
	// 상세 보기
	/*
	private int fno;
	private String name,type,phone,address,theme,poster,content;
	private double score;
	 */
	public FoodVO foodDetailData(int fno)
	{
		FoodVO vo=new FoodVO();
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT fno,name,type,phone,address,theme,poster,content,score "
					+ "FROM food_house "
					+ "WHERE fno="+fno;
			ps=conn.prepareStatement(sql); // 오라클로 전송
			ResultSet rs=ps.executeQuery(); // 실행 후에 결과값을 메모리에 저장
			rs.next(); // 데이터가 있는 메모리 위치에 커서 이동
			vo.setFno(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setType(rs.getString(3));
			vo.setPhone(rs.getString(4));
			vo.setAddress(rs.getString(5));
			vo.setTheme(rs.getString(6));
			vo.setPoster(rs.getString(7).replace("https", "http"));
			vo.setContent(rs.getString(8));
			vo.setScore(rs.getDouble(9));
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== foodDetailData(int fno) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn,ps);
		}
		return vo;
	}
	// seoul => 명소 => 6개
	public List<LocationVO> foodLocationData(String addr)
	{
		List<LocationVO> list=new ArrayList<LocationVO>();
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT no,title,poster "
					+ "FROM seoul_location "
					+ "WHERE rownum<=6 AND "
					+ "address LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, addr);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				LocationVO vo=new LocationVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== foodLocationData(String addr) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn,ps);
		}
		return list;
	}
}
