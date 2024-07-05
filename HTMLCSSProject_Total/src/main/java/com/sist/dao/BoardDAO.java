package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.database.*;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static BoardDAO dao;
	private DataBaseConnection dbConn=new DataBaseConnection();
	
	public BoardDAO()
	{
		try
		{
			
		}catch(Exception ex) {}
	}
	// 싱글턴
	// 기능
	// 1. 목록 => SELECT (페이지 나누기) => 인라인뷰 => <table>, <a>
	// 2. 상세 보기 => SELECT (WHERE) => <table>
	// 3, 글쓰기 => input
	// 4. 수정하기 => input
	// 5. 삭제하기 => input
	// 6. 검색 => <select>
}
