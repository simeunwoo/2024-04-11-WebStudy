package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class DataBoardDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	// 기능
	
}
