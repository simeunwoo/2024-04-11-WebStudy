package com.sist.dao;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*; // 이름으로 Connection 주소 찾기
/*
 * 	Pool : 연결된 Connection을 저장하는 공간
 * 	=> DBCP
 * 		Database Connection Pool
 * 		=> 연결만
 */
public class EmpDAO {
	private Connection conn;
	// AWS => 프로젝트 => 실행 => 어떤 위치든 상관 없이 실행이 가능
	private PreparedStatement ps;
	private static EmpDAO dao;
	
	// 싱글턴
	public static EmpDAO newInstance()
	{
		if(dao==null)
			dao=new EmpDAO();
		return dao;
	}
	
	public void getConnection()
	{
		// 미리 오라클에 연결하여 저장된 Connection의 주소를 얻어 온다
	}
	
	public void disConnection()
	{
		// 닫기 => 반환 (사용 후에 반환)
		try
		{
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		}catch(Exception ex) {}
	}
	
	// 기능 => 목록
	public List<EmpVO> empListData()
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		try
		{
			getConnection();
			String sql="SELECT empno,ename,job,hiredate,comm "
					+ "FROM emp "
					+ "ORDER BY empno ASC";
			// /*+ INDEX_ASC()*/ ps.setInt() => ?
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setComm(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			System.out.println("=== empListData() 오류 발생 ===");
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
}
