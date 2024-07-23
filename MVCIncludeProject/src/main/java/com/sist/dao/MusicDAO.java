package com.sist.dao;
import java.sql.*;
import java.util.*;
import com.sist.dao.*;

public class MusicDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static MusicDAO dao;
	private DbcpConnection dbConn=new DbcpConnection();
	
	public static MusicDAO newInstance()
	{
		if(dao==null)
			dao=new MusicDAO();
		return dao;
	}
	
	public List<MusicVO> musicListData(int page)
	{
		List<MusicVO> list=new ArrayList<MusicVO>();
		
		try
		{
			conn=dbConn.getConnection();
		}catch(Exception ex)
		{
			System.out.println("=== musicListData(int page) ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn, ps);
		}
		
		return list;
	}
}
