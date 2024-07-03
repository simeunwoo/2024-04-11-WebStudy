package com.sist.dao;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;
import com.sist.database.*;

public class FoodDAO {
	private Connection conn; // 연결 담당
	private PreparedStatement ps; // SQL 문장 송수신 => SQL 문장 전송 / 결과값을 받는다
	private static FoodDAO dao; // 싱글턴
	private DataBaseConnection dbConn=new DataBaseConnection();
	
	// 라이브러리 형식 (.jar) => 보안
	// 싱글턴
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	// 기능
	// => 결과값 (브라우저) => 사용자 요청
	// => 사용자가 페이지를 선택하면 오라클에 저장된 데이터 중에 페이지에 해당되는 데이터를 보낸다
	// => List, FoodVO, int (총 페이지, 몇 개인지 확인), String, void
	// 화면 목록 출력 => List
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT fno,poster,name,num "
					+ "FROM (SELECT fno,poster,name,rownum as num "
					+ "FROM (SELECT /*+ INDEX_ASC(food_house fh_fno_pk) */ fno,poster,name "
					+ "FROM food_house)) "
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
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setName(rs.getString(3));
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
	
	public int foodTotalPage()
	{
		int total=0;
		try
		{
			conn=dbConn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM food_house";
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
			String sql="UPDATE food_house SET "
					+ "hit=hit+1 "
					+ "WHERE fno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, fno);
			ps.executeUpdate();
			////////////////////// 조회수 증가 설정 완료
			sql="SELECT fno,name,type,phone,address,theme,poster,content,score "
					+ "FROM food_house "
					+ "WHERE fno=?";
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다
			ps.setInt(1, fno);
			// 실행 요청 => 결과값 받기
			ResultSet rs=ps.executeQuery();
			// 커서를 데이터가 출력된 위치로 이동
			rs.next();
			vo.setFno(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setType(rs.getString(3));
			vo.setPhone(rs.getString(4));
			vo.setAddress(rs.getString(5));
			vo.setTheme(rs.getString(6));
			vo.setPoster(rs.getString(7).replace("https", "http"));
			vo.setContent(rs.getString(8));
			vo.setScore(rs.getDouble(9));
			// 메모리 닫기
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("======= foodDetailData() 오류 =======");
			ex.printStackTrace();
		}
		finally
		{
			dbConn.disConnection(conn, ps);
		}
		return vo;
	}
}
