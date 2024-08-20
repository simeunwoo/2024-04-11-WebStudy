package com.sist.dao;

import java.sql.ResultSet;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
public class CampGoodsDAO {
	private static SqlSessionFactory ssf;
	static
	{
		try
		{
		ssf=CreateSqlSessionFactory.getSsf();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 캠핑용품 목록
	public static List<CampGoodsVO> campGoodsListData(Map map)
	{
		List<CampGoodsVO> list=new ArrayList<CampGoodsVO>();
		SqlSession session=null;
		try
		{
			session=ssf.openSession();
			list=session.selectList("campGoodsListData",map);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			if(session!=null)
				session.close();
		}
		return list;
	}
	public static int campGoodsTotalPage(Map map)
	{
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("campGoodsTotalPage",map);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			if(session!=null)
				session.close();
		}
		return total;
	}
	
	// 캠핑용품 상세페이지
	public static CampGoodsVO campGoodsDetailData(Map map)
	{
		CampGoodsVO vo=new CampGoodsVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session.update("campGoodsHitIncrement",map); // 조회수
			session.commit();
			vo=session.selectOne("campGoodsDetailData",map);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			if(session!=null)
				session.close();
		}
		return vo;
	}
	
	// 메인페이지 캠핑용품 출력
	public static List<CampGoodsVO> campGoodsJjimTopData(){
		List<CampGoodsVO> list = new ArrayList<CampGoodsVO>();
		SqlSession session=null;
		try
		{
			session = ssf.openSession();
			list=session.selectList("campGoodsJjimTopData");
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			if(session!=null) session.close();
		}
		return list;
	}
	
}