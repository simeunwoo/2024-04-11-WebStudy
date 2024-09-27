package com.sist.model;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.commons.CommonsModel;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;

public class Board_Model {
	//캠핑장 게시판 리스트
	@RequestMapping("boardcamp/list.do")
	public String board_CampList(HttpServletRequest request, HttpServletResponse response) {
		String page=request.getParameter("page");
		if(page==null) {page="1";}	//초기 페이지 설정
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage*10)-9);
		map.put("end", (curpage*10));
		
		List<BoardVO> list=BoardDAO.board_CampList(map);
		int count=BoardDAO.board_campRowCount();
		int totalpage=(int)(Math.ceil(count	/10.0));
		count=count-((curpage*10)-10);
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("count", count);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String today=sdf.format(date);
		
		CommonsModel.footerPrint(request);
		
		request.setAttribute("today", today);
		request.setAttribute("main_jsp", "../board/boardcamp_list.jsp");
		return "../main/main.jsp";
	}
	
	//캠핑용품 게시판 리스트
		@RequestMapping("boardgoods/list.do")
		public String board_GoodsList(HttpServletRequest request, HttpServletResponse response) {
			String page=request.getParameter("page");
			if(page==null) {page="1";}	//초기 페이지 설정
			int curpage=Integer.parseInt(page);
			Map map=new HashMap();
			map.put("start", (curpage*10)-9);
			map.put("end", (curpage*10));
			
			List<BoardVO> list=BoardDAO.board_GoodsList(map);
			int count=BoardDAO.board_GoodsRowCount();
			int totalpage=(int)(Math.ceil(count	/10.0));
			count=count-((curpage*10)-10);
			
			request.setAttribute("list", list);
			request.setAttribute("curpage", curpage);
			request.setAttribute("totalpage", totalpage);
			request.setAttribute("count", count);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String today=sdf.format(date);
			
			CommonsModel.footerPrint(request);
			
			request.setAttribute("today", today);
			request.setAttribute("main_jsp", "../board/boardgoods_list.jsp");
			return "../main/main.jsp";
		}
	
	//캠핑장 후기글 작성
	@RequestMapping("boardcamp/insert.do") 
	public String board_CampInsert(HttpServletRequest request, HttpServletResponse response) {
		CommonsModel.footerPrint(request);
		
		request.setAttribute("main_jsp"	, "../board/boardcamp_insert.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("boardcamp/insert_ok.do")
	public String board_CampInsert_ok(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			String path="c:\\project_upload";	//파일 업로드 위치
			String enctype="UTF-8";		//한글파일명 인코딩
			int max_size=1024*1024*100;		//이미지파일 크기
			MultipartRequest mr=new MultipartRequest(request, path,max_size,enctype, new DefaultFileRenamePolicy());		//중복파일명 자동변경
			String name=mr.getParameter("name");
			String subject=mr.getParameter("subject");
			String content=mr.getParameter("content");
			String pwd=mr.getParameter("pwd");
			String imgname=mr.getFilesystemName("upload");
			BoardVO vo=new BoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			
			if(imgname==null) {
				vo.setImgname("");
				vo.setImgsize(0);
			}
			else {
				File img=new File(path+"\\"+imgname);
				vo.setImgname(imgname);
				vo.setImgsize((int)img.length());
			}
			
			BoardDAO.board_CampInsert(vo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "redirect:../boardcamp/list.do";
	}
	
	//캠핑용품 후기글 작성
	@RequestMapping("boardgoods/insert.do") 
	public String board_GoodsInsert(HttpServletRequest request, HttpServletResponse response) {
		CommonsModel.footerPrint(request);
		
		request.setAttribute("main_jsp"	, "../boardgoods/insert.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("boardgoods/insert_ok.do")
	public String board_goodsInsert_ok(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			/*
			URL url=this.getClass().getClassLoader().getResource(".");	//현재경로명 읽기(운영체제 상관없이)
			File file=new File(url.toURI());
			System.out.println(file.getPath());
			String path=file.getPath();
			path=path.replace("\\", File.separator);	//os에 따라 /,\ 자동변경
			path=path.substring(0,path.lastIndexOf(File.separator));
			path=path+File.separator+"application.xml";
			 */
			
			String path="c:\\project_upload";	//파일 업로드 위치
			String enctype="UTF-8";		//한글파일명 인코딩
			int max_size=1024*1024*100;		//이미지파일 크기
			MultipartRequest mr=new MultipartRequest(request, path,max_size,enctype, new DefaultFileRenamePolicy());		//중복파일명 자동변경
			String name=mr.getParameter("name");
			String subject=mr.getParameter("subject");
			String content=mr.getParameter("content");
			String pwd=mr.getParameter("pwd");
			String imgname=mr.getFilesystemName("upload");
			BoardVO vo=new BoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			
			if(imgname==null) {
				vo.setImgname("");
				vo.setImgsize(0);
			}
			else {
				File img=new File(path+"\\"+imgname);
				vo.setImgname(imgname);
				vo.setImgsize((int)img.length());
			}
			
			BoardDAO.board_GoodsInsert(vo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "redirect:../boardgoods/list.do";
	}
	
	//게시글 상세보기
		  @RequestMapping("board/detail.do")
		  public String board_detail(HttpServletRequest request,HttpServletResponse response){
			  String no=request.getParameter("no");
			  BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
			  
			  CommonsModel.footerPrint(request);
			  
			  request.setAttribute("vo", vo);
			  request.setAttribute("main_jsp", "../board/board_detail.jsp");
			  return "../main/main.jsp";
		  }
	  
	  @RequestMapping("boardcamp/download.do")
	  public void board_download(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  String fn=request.getParameter("fn");
			  File file=new File("c:\\project_upload\\"+fn);
			  // header => 전송 : 파일명 , 파일 크기 
			  response.setHeader("Content-Disposition", "attachment;filename="
					  +URLEncoder.encode(fn, "UTF-8"));
			  response.setContentLength((int)file.length());
			  
			  BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			  // 서버에서 파일 읽기 
			  BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			  // 다운로드를 요청한 클라이언트
			  byte[] buffer=new byte[1024];// 파일 저장 공간 
			  int i=0;// 읽은 바이트수 
			  while((i=bis.read(buffer, 0, 1024))!=-1)
			  {
				  bos.write(buffer, 0, i);
			  }
			  bis.close();
			  bos.close();
			  
		  }catch(Exception ex){}
	  }

	  //게시글 삭제
	  @RequestMapping("board/delete.do") // => if문 동일 
	  public void board_delete(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");
		  String pwd=request.getParameter("pwd");
		  System.out.println("no="+no+",pwd="+pwd);
		  // 데이터베이스 연동 
		  BoardVO vo=BoardDAO.boardImgInfoData(Integer.parseInt(no));
		  String result=BoardDAO.boardDelete(Integer.parseInt(no), pwd);
		  // 파일 삭제 
		  try
		  {
			  if(vo.getImgsize()>0)
			  {
				  File file=new File("c:\\project_upload\\"+vo.getImgname());
				  file.delete();
			  }
		  }catch(Exception ex) {}
		  // 결과값을 받아서 Ajax로 전송 
		  try
		  {
			  PrintWriter out=response.getWriter();
			  out.write(result);
		  }catch(Exception ex) {}
	  }
	  
	  //비밀번호 체크
	  @RequestMapping("board/password_check.do")
	  public void board_pwd_check(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");
		  String pwd=request.getParameter("pwd");
		  String db_pwd=BoardDAO.boardGetPassword(Integer.parseInt(no));
		  String result="no";
		  if(db_pwd.equals(pwd))
		  {
			  result="yes";
		  }
		  try
		  {
			  PrintWriter out=response.getWriter();
			  out.write(result);
		  }catch(Exception ex) {}
	  }
	  
	  @RequestMapping("board/update.do")
	  public String board_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  String no=request.getParameter("no");
		  System.out.println("no="+no);
		  BoardVO vo=BoardDAO.boardUpdateData(Integer.parseInt(no));
		  
		  CommonsModel.footerPrint(request);
		  
		  // 데이터를 request에 추가해서 jsp로 전송 
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../board/board_update.jsp");
		  return "../main/main.jsp";
	  }
	  
	  @RequestMapping("board/update_ok.do")
	  public String board_update_ok(HttpServletRequest request,HttpServletResponse response){
		  try{ 
			  
			  request.setCharacterEncoding("UTF-8");
			  String path="c:\\project_upload";
			  String enctype="UTF-8";// 한글 파일명 
			  int max_size=1024*1024*100;
			  MultipartRequest mr=new MultipartRequest(request, path,max_size,enctype, new DefaultFileRenamePolicy());
			  // 자동 변경 => a.jpg , a1.jpg
			  String name=mr.getParameter("name");
			  String subject=mr.getParameter("subject");
			  String content=mr.getParameter("content");
			  String pwd=mr.getParameter("pwd");
			  String imgname=mr.getFilesystemName("upload");
			  String no=mr.getParameter("no");
			  
			  BoardVO dvo=BoardDAO.boardImgInfoData(Integer.parseInt(no));
			  if(dvo.getImgsize()>0){
				  File img=new File("c:\\project_upload\\"+dvo.getImgname());
				  img.delete();
			  }
			  // a.jpg
			  // a.jpg => a1.jpg
			  BoardVO vo=new BoardVO();
			  vo.setName(name);
			  vo.setSubject(subject);
			  vo.setContent(content);
			  vo.setPwd(pwd);
			  vo.setNo(Integer.parseInt(no));
			  
			  if(imgname==null) // 업로드가 없는 상태 
			  {
				  vo.setImgname("");
				  vo.setImgsize(0);
			  }
			  else // 업로드가 된 상태 
			  {
				  File img=new File(path+"\\"+imgname);
				  vo.setImgname(imgname);
				  vo.setImgsize((int)img.length()); // int => 2byte
			  }
			  
			  BoardDAO.board_CampUpdate(vo);
		  }catch(Exception ex){}
		  return "redirect:../boardcamp/list.do";
	  }	  
	  
	  
	  @RequestMapping("boardcamp/find.do")
	  public String boardcamp_find(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  
		  String[] fsArr=request.getParameterValues("fs");
		  String ss=request.getParameter("ss");
		  Map map=new HashMap();
		  map.put("fsArr", fsArr);
		  map.put("ss", ss);
		  // 데이터베이스 연동 
		  List<BoardVO> list=BoardDAO.boardCampFindData(map);
		  
		  CommonsModel.footerPrint(request);
		  
		  // 결과값 전송 
		  request.setAttribute("list", list);
		  request.setAttribute("main_jsp", "../board/boardcamp_find.jsp");
		  return "../main/main.jsp";
	  }
	  
	  @RequestMapping("boardgoods/find.do")
	  public String boardgoods_find(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  
		  String[] fsArr=request.getParameterValues("fs");
		  String ss=request.getParameter("ss");
		  Map map=new HashMap();
		  map.put("fsArr", fsArr);
		  map.put("ss", ss);
		  // 데이터베이스 연동 
		  List<BoardVO> list=BoardDAO.boardGoodsFindData(map);
		  
		  CommonsModel.footerPrint(request);
		  
		  // 결과값 전송 
		  request.setAttribute("list", list);
		  request.setAttribute("main_jsp", "../board/boardgoods_find.jsp");
		  return "../main/main.jsp";
	  }
	  
	  //추천하기
	 // @RequestMapping("board/gaechu.do")
	  
}