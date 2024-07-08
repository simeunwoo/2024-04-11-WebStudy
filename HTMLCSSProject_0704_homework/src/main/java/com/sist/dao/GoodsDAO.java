package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.database.*;

public class GoodsDAO {
	private Connection conn; // 연결 담당
	private PreparedStatement ps; // SQL 문장 송수신 => SQL 문장 전송 / 결과값을 받는다
	private static GoodsDAO dao; // 싱글턴
	private DataBaseConnection dbConn=new DataBaseConnection();
	private String[] mode={"","goods_all","goods_best","goods_new","goods_special"};
	
	public static GoodsDAO newInstance()
	{
		if(dao==null)
			dao=new GoodsDAO();
		return dao;
	}
	
	  public List<GoodsVO> goodsFindData(String name,int page)
	   {
		   List<GoodsVO> list=new ArrayList<GoodsVO>();
		   try
		   {
			   conn=dbConn.getConnection();
			   String sql="SELECT no,goods_name,goods_poster,num "
					     +"FROM (SELECT no,goods_name,goods_poster,rownum as num "
					     +"FROM (SELECT no,goods_name,goods_poster "
					     +"FROM goods_all WHERE goods_name LIKE '%'||?||'%')) "
					     +"WHERE num BETWEEN ? AND ?";
			   ps=conn.prepareStatement(sql);
			   int rowSize=12;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   // IN OUT 
			   ps.setString(1, name);
			   ps.setInt(2, start);
			   ps.setInt(3, end);
			   // 결과값 받기 
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   GoodsVO vo=new GoodsVO();
				   vo.setNo(rs.getInt(1));
				   vo.setGoods_name(rs.getString(2));
				   vo.setGoods_poster(rs.getString(3).replace("https", "http"));
				   list.add(vo);
			   }
			   rs.close();
			   
		   }catch(Exception ex)
		   {
			   System.out.println("===== goodsFindData() 오류 발생 =====");
			   ex.printStackTrace();
		   }
		   finally
		   {
			   dbConn.disConnection(conn, ps);
		   }
		   return list;
	   }
	   public int goodsFindTotalPage(String name)
	   {
		   int total=0;
		   try
		   {
			   conn=dbConn.getConnection();
			   String sql="SELECT CEIL(COUNT(*)/12.0) "
					     +"FROM goods_all "
					     +"WHERE goods_name LIKE '%'||?||'%'";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, name);
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
			   System.out.println("===== goodsFindTotalPage() 오류 발생 =====");
			   dbConn.disConnection(conn, ps);
		   }
		   return total;
	   }
	
	
	  public List<GoodsVO> goodsListData(int type,int page)
	   {
		   List<GoodsVO> list=new ArrayList<GoodsVO>();
		   
		   try
		   {
			   conn=dbConn.getConnection();
			   String sql="SELECT no,goods_name,goods_poster,num "
					     +"FROM (SELECT no,goods_name,goods_poster,rownum as num "
					     +"FROM (SELECT no,goods_name,goods_poster "
					     +"FROM "+mode[type]+")) "
					     +"WHERE num BETWEEN ? AND ?";
			   // rownum은 Top-N => 처음부터 , 중간은 자르지 못한다 => 인라인뷰 
			   ps=conn.prepareStatement(sql);
			   int rowSize=12;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   
			   // ?에 값을 채운다 => 실행
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   // => 전체 / 베스트 / 특가 / 신상품 => 각각 테이블이 만들어져 있다 
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   GoodsVO vo=new GoodsVO();
				   vo.setNo(rs.getInt(1));
				   vo.setGoods_name(rs.getString(2));
				   vo.setGoods_poster(rs.getString(3).replace("https", "http"));
				   list.add(vo);
			   }
			   rs.close();
			   
		   }catch(Exception ex)
		   {
			   System.out.println("===== goodsListData() 오류 발생 =====");
			   ex.printStackTrace();
		   }
		   finally
		   {
			   dbConn.disConnection(conn, ps);
		   }
		   return list;
	   }
	   public int goodsListTotalPage(int type)
	   {
		   int total=0;
		   try
		   {
			   conn=dbConn.getConnection();
			   String sql="SELECT CEIL(COUNT(*)/12.0) "
					     +"FROM "+mode[type];
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   total=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   System.out.println("===== goodsListTotalPage() 오류 발생 =====");
			   ex.printStackTrace();
		   }
		   finally
		   {
			   dbConn.disConnection(conn, ps);
		   }
		   return total;
	   }
	   
		public GoodsVO goodsDetailData(int no, int type)
		{
			GoodsVO vo=new GoodsVO();
			try
			{
				conn=dbConn.getConnection();
				String sql="UPDATE "+mode[type]
						+ " SET hit=hit+1 "
						+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, no);
				ps.executeUpdate(); 
				////////////////////// 조회수 증가 설정 완료
				sql="SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster "
						+ "FROM "+mode[type]
						+" WHERE no=?";
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