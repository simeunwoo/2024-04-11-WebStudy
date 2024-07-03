package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.database.*;

public class GoodsDAO {
	private Connection conn; // 연결 담당
	private PreparedStatement ps; // SQL 문장 송수신 => SQL 문장 전송 / 결과값을 받는다
	private static GoodsDAO dao; // 싱글턴
	private DataBaseConnection dbConn=new DataBaseConnection();
	
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
					+ "FROM (SELECT /*+ INDEX_ASC(goods_all fh_no_pk) */ no,goods_poster,goods_name "
					+ "FROM goods_all)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1); // rownum은 1부터 시작
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				GoodsVO vo=new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setGoods_poster(rs.getString(2));
				vo.setGoods_name(rs.getString(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
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
			// 전송
			ps=conn.prepareStatement(sql);
			// 결과값 받기
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn, ps);
		}
		return total;
	}
	// 상세 보기
	public GoodsVO goodsDetailData(int no)
	{
		GoodsVO vo=new GoodsVO();
		try
		{
			conn=dbConn.getConnection();
			String sql="UPDATE food_house SET "
					+ "hit=hit+1 "
					+ "WHERE fno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			////////////////////// 조회수 증가 설정 완료
			sql="SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster "
					+ "FROM goods_all "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다
			ps.setInt(1, no);
			// 실행 요청 => 결과값 받기
			ResultSet rs=ps.executeQuery();
			// 커서를 데이터가 출력된 위치로 이동
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setGoods_name(rs.getString(2));
			vo.setGoods_sub(rs.getString(3));
			vo.setGoods_price(rs.getString(4));
			vo.setGoods_discount(rs.getString(5));
			vo.setGoods_first_price(rs.getString(6));
			vo.setGoods_delivery(rs.getString(7).replace("https", "http"));
			vo.setGoods_poster(rs.getString(8));
			// 메모리 닫기
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("======= goodsDetailData() 오류 =======");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn, ps);
		}
		return vo;
	}
}