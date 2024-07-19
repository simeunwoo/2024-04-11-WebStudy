package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;

import com.sist.vo.FoodVO;

import javax.naming.*;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}

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
	
	// 목록
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try
		{
			getConnection(); // Connection 주소 얻기
			// SQL 문장 제작
			String sql="SELECT fno,name,poster,num "
					+ "FROM (SELECT fno,name,poster,rownum as num "
					+ "FROM (SELECT fno,name,poster "
					+ "FROM food_house ORDER BY fno ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			// SQL 문장을 오라클에 전송
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			// 실행 결과를 가지고 온다
			ResultSet rs=ps.executeQuery();
			// List에 첨부
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
		return list;
	}
	
	public int foodTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM food_house";
			ps=conn.prepareStatement(sql);
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
			disConnection();
		}
		return total;
	}
}