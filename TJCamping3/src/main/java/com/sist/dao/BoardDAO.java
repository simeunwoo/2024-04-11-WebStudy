package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.BoardVO;



public class BoardDAO {
	private static SqlSessionFactory ssf;
	static{
		ssf=CreateSqlSessionFactory.getSsf();	//
	}
	
	//캠핑장후기 목록 리스트
	public static List<BoardVO> board_CampList(Map map){
		List<BoardVO> list=new ArrayList<BoardVO>();
		SqlSession session=null;
		try {
			session=ssf.openSession(); 
			list=session.selectList("board_CampList",map);
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return list;
	}
	public static int board_campRowCount() {
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			count=session.selectOne("board_campRowCount");
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return count;
	}
	//새 글 작성(캠핑장)
	public static void board_CampInsert(BoardVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.insert("board_CampInsert",vo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
	}
	
	//캠핑용품후기 목록 리스트
	public static List<BoardVO> board_GoodsList(Map map){
		List<BoardVO> list=new ArrayList<BoardVO>();
		SqlSession session=null;
		try {
			session=ssf.openSession(); 
			list=session.selectList("board_GoodsList",map);
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return list;
	}
	
	public static int board_GoodsRowCount() {
		int count=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			count=session.selectOne("board_GoodsRowCount");
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return count;
	}
	//새 글 작성(캠핑장)
	public static void board_GoodsInsert(BoardVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.insert("board_GoodsInsert",vo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
	}	
	
	//자세히보기
	public static BoardVO boardDetailData(int no)
	  {
		  BoardVO vo=new BoardVO();
		  SqlSession session=null;
		  try
		  {
			  session=ssf.openSession(); 
			  session.update("boardhitIncrement",no);
			  session.commit();
			  vo=session.selectOne("boardDetailData",no);
			  
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  if(session!=null)
				  session.close(); // 반환 (DBCP사용)
		  }
		  return vo;
	  }
	
	
	public static BoardVO boardImgInfoData(int no){
		   // 폴더에서 파일 삭제 
		BoardVO vo=new BoardVO();
		SqlSession session=null;
		try{
			session=ssf.openSession(); 
			vo=session.selectOne("boardImgInfoData",no);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(session!=null) session.close(); // 반환 (DBCP사용)
		}
		return vo;
		}
	
	//수정하기
   public static void board_CampUpdate(BoardVO vo)
   {
	      SqlSession session=null;
		  try
		  {
			  session=ssf.openSession(true); 
			  session.update("board_CampUpdate",vo);
			  
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  if(session!=null)
				  session.close(); // 반환 (DBCP사용)
		  }
   }
	public static BoardVO boardUpdateData(int no)
	   {
		BoardVO vo=new BoardVO();
		   SqlSession session=null;
			  try
			  {
				  session=ssf.openSession(); 
				  vo=session.selectOne("boardDetailData",no);
				  
			  }catch(Exception ex)
			  {
				  ex.printStackTrace();
			  }
			  finally
			  {
				  if(session!=null)
					  session.close(); // 반환 (DBCP사용)
			  }
		   return vo;
	   }
	   public static String boardGetPassword(int no)
	   {
		   String pwd="";
		   SqlSession session=null;
			  try
			  {
				  session=ssf.openSession(); 
				  pwd=session.selectOne("boardGetPassword",no);
				  
			  }catch(Exception ex)
			  {
				  ex.printStackTrace();
			  }
			  finally
			  {
				  if(session!=null)
					  session.close(); // 반환 (DBCP사용)
			  }
		   return pwd;
	   }
	
	//삭제하기
	public static String boardDelete(int no,String pwd)
	   {
		   String result="no";
		   SqlSession session=null;
			  try
			  {
				  session=ssf.openSession(); 
				  String db_pwd=session.selectOne("boardGetPassword",no);
				  if(db_pwd.equals(pwd))
				  {
					  result="yes";
					  session.delete("boardReplyDelete",no);
					  session.delete("boardDelete",no);
					  session.commit();
				  }
			  }catch(Exception ex)
			  {
				  ex.printStackTrace();
			  }
			  finally
			  {
				  if(session!=null)
					  session.close(); // 반환 (DBCP사용)
			  }
		   return result;
	   }
	
	//캠핑장 후기 검색
	public static List<BoardVO> boardCampFindData(Map map)
	   {
		   List<BoardVO> list=new ArrayList<BoardVO>();
		   SqlSession session=null;
			  try
			  {
				  session=ssf.openSession(true); 
				  list=session.selectList("boardCampFindData",map);
				  
			  }catch(Exception ex)
			  {
				  ex.printStackTrace();
			  }
			  finally
			  {
				  if(session!=null)
					  session.close(); // 반환 (DBCP사용)
			  }
		   return list;
	   }

	//캠핑용품 후기 검색
	public static List<BoardVO> boardGoodsFindData(Map map)
	   {
		   List<BoardVO> list=new ArrayList<BoardVO>();
		   SqlSession session=null;
			  try
			  {
				  session=ssf.openSession(true); 
				  list=session.selectList("boardGoodsFindData",map);
				  
			  }catch(Exception ex)
			  {
				  ex.printStackTrace();
			  }
			  finally
			  {
				  if(session!=null)
					  session.close(); // 반환 (DBCP사용)
			  }
		   return list;
	   }
	
	/*
	   public static String boardGaechuCount(int no) {
		   String gaechu="";
		   SqlSession session=null;
		   try {
			   session=ssf.openSession();
			   gaechu=session.selectOne("boardGaechuCount", no);
		   }catch (Exception ex) {
			   ex.printStackTrace();
		}finally {
			if(session!= null) session.close();
		}
		return gaechu;
	   }
	   */
	
	/*
	public static int board_replyCount() {
		int replycount=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			replycount=session.selectOne("boardReplyCount");
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return replycount;
	}
	  */ 
}
