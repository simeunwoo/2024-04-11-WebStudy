package com.sist.temp;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;

public class DayDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
	
	// ssf=new SqlsessionBuilder().build("Config.xml");
	public DayDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	// session=ssf.openSession();
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr2","happy");
		}catch(Exception ex) {}
	}
	
	// session.close();
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
	
	// selectList => UPDATE food SET rdays=값 WHERE fno=1
	public List<Integer> foodGetFno()
	{
		List<Integer> list=new ArrayList<Integer>();
		
		try
		{
			getConnection();
			String sql="SELECT fno FROM project_food_house "
					+ "ORDER BY fno ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				list.add(rs.getInt(1));
			}
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		
		return list;
	}
	
	public void foodRdaysUpdate(int camp_no,String rdays)
	{
		try
		{
			getConnection();
			String sql="UPDATE camp SET "
					+ "rdays=? "
					+ "WHERE camp_no=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, rdays);
			ps.setInt(2, camp_no);
			ps.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
	public void timeInsert(int dno,String time)
	{
		try
		{
			getConnection();
			String sql="INSERT INTO reserve_date VALUES(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, dno);
			ps.setString(2, time);
			ps.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
}
