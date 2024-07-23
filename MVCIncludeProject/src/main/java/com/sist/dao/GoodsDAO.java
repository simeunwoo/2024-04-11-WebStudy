package com.sist.dao;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;

public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static GoodsDAO dao;
	private DbcpConnection dbConn=new DbcpConnection();
	
	public static GoodsDAO newInstance()
	{
		if(dao==null)
			dao=new GoodsDAO();
		return dao;
	}	

	public List<GoodsVO> goodsListData(int page)
	{
		List<GoodsVO> list=new ArrayList<GoodsVO>();
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT no,goods_name,goods_poster,goods_price,num "
					+ "FROM (SELECT no,goods_name,goods_poster,goods_price,rownum as num "
					+ "FROM (SELECT /*+ INDEX_ASC(goods_all goods_no_pk)*/no,goods_name,goods_poster,goods_price "
					+ "FROM goods_all)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				GoodsVO vo=new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3));
				vo.setPrice(rs.getString(4));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== goodsListData(int page) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn,ps);
		}
		return list;
	}
	
	public int goodsTotalPage()
	{
		int total=0;
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM goods_all";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== goodsTotalPage() 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn,ps);
		}
		return total;
	}
/*
	private int no,discount,hit;
	private String name,sub,price,first_price,poster,delivery;
 */
	public GoodsVO goodsDetailData(int no)
	{
		GoodsVO vo=new GoodsVO();
		
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT no,name,sub,poster,price "
					+ "FROM goods_all "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSub(rs.getString(3));
			vo.setPoster(rs.getString(4));
			vo.setPrice(rs.getString(5));
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== goodsDetailData(int no) 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn, ps);
		}
		
		return vo;
	} 
	
}
