package com.sist.dao;
import java.sql.*;
import java.util.*;
import com.sist.database.*;

public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static GoodsDAO dao;
	private DataBaseConnection dbConn=new DataBaseConnection();
	
	// 싱글턴
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
			String sql="SELECT no,goods_poster,goods_name,num "
					+ "FROM (SELECT no,goods_poster,goods_name,rownum as num "
					+ "FROM (SELECT no,goods_poster,goods_name "
					+ "FROM goods_all ORDER BY no ASC)) "
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
				vo.setGoods_poster(rs.getString(2).replace("https", "http"));
				vo.setGoods_name(rs.getString(3));
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
			dbConn.disConnection(conn, ps);
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
			dbConn.disConnection(conn, ps);
		}
		return total;
	}
	
	public GoodsVO goodsDetailData(int no)
	   {
		   GoodsVO vo=new GoodsVO();
		   try
		   {
			   conn=dbConn.getConnection();
			   String sql="SELECT goods_name,goods_sub,goods_price,goods_first_price,goods_poster,goods_delivery,no "
					     +"FROM goods_all "
					     +"WHERE no="+no;
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setGoods_name(rs.getString(1));
			   vo.setGoods_sub(rs.getString(2));
			   vo.setGoods_price(rs.getString(3));
			   vo.setGoods_first_price(rs.getString(4));
			   vo.setGoods_poster(rs.getString(5).replace("https", "http"));
			   vo.setGoods_delivery(rs.getString(6));
			   vo.setNo(rs.getInt(7));
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   dbConn.disConnection(conn, ps);
		   }
		   return vo;
	   }

}