package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class SeoulDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static SeoulDAO dao;
	
	public static SeoulDAO newInstance()
	{
		if(dao==null)
			dao=new SeoulDAO();
		return dao;
	}
	// 미리 생성된 Connection의 주소를 읽어서 사용
	// ====== TomCat에 의하여 생성된다
	// POOL => 10 (maxIdle) (내가 임의로 설정해 놓았다)
	public void getConnection()
	{
		try
		{
			Context init=new InitialContext(); // 탐색기 열기
			Context c=(Context)init.lookup("java://comp//env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
			// 보안 (server.xml은 서버 관리자만 볼 수 있다)
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 반환 => POOL (Connection 객체 관리 영역)
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
	
	public List<LocationVO> seoulLocationListData(int page)
	{
		List<LocationVO> list=new ArrayList<LocationVO>();
		try
		{
			
		}catch(Exception ex)
		{
			
		}
		finally
		{
			
		}
		return list;
	}
}
