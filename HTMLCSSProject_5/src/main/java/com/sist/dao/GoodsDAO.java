package com.sist.dao;
import java.util.*;
import java.sql.*;

public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static GoodsDAO dao;
	
	// 드라이버 등록 => 한번만 등록할 것이므로 생성자로 등록
	public GoodsDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 오라클 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	// 오라클 해제
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
	// 싱글턴
	public static GoodsDAO newInstance()
	{
		if(dao==null)
			dao=new GoodsDAO();
		return dao;
	}
	/*
	 NO                                        NOT NULL NUMBER(38)
	 GOODS_NAME                                         VARCHAR2(4000)
	 GOODS_SUB                                          VARCHAR2(4000)
	 GOODS_PRICE                                        VARCHAR2(26)
	 GOODS_DISCOUNT                                     NUMBER(38)
	 GOODS_FIRST_PRICE                                  VARCHAR2(26)
	 GOODS_DELIVERY                                     VARCHAR2(26)
	 GOODS_POSTER                                       VARCHAR2(4000)
	 HIT                                                NUMBER(38)
	 */
	// 목록 (50개)
	public List<GoodsVO> goodsListData()
	{
		List<GoodsVO> list=new ArrayList<GoodsVO>();
		try
		{
			// 연결
			getConnection();
			// 오라클에 전송할 SQL 문장 제작
			String sql="SELECT no,goods_poster,goods_name,goods_price,rownum "
					+"FROM goods_all "
					+"WHERE rownum<=50";
			// 오라클 전송
			ps=conn.prepareStatement(sql);
			// 결과값 받기
			ResultSet rs=ps.executeQuery();
			// rs에 저장된 결과값을 list에 담기
			while(rs.next())
			{
				GoodsVO vo=new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setPrice(rs.getString(4));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			// 오류 확인
			ex.printStackTrace();
		}
		finally
		{
			// 해제
			disConnection();
		}		
		return list;
	}
	// 상세 보기 => CSS를 적용 =======> ?no=1,2,3...
	public GoodsVO goodsDetailData(int no)
	{
		GoodsVO vo=new GoodsVO();
		try
		{
			getConnection();
			String sql="SELECT no,goods_poster,goods_name,goods_price,"
					+"goods_sub,goods_delivery,goods_discount "
					+"FROM goods_all "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setPoster(rs.getString(2));
			vo.setName(rs.getString(3));
			
			String price=rs.getString(4);
			
			vo.setPrice(price);
			vo.setSub(rs.getString(5));
			vo.setDelivery(rs.getString(6));
			vo.setDiscount(rs.getInt(7));
			
			String rp=price.replaceAll("[^0-9]", ""); // 숫자 빼고 나머지는 다 공백 처리
			
			vo.setRprice(Integer.parseInt(rp));
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}
}
