package com.sist.model;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
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

public class DataBoardModel {

	@RequestMapping("databoard/insert.do")
	public String databoard_insert(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		request.setAttribute("main_jsp", "../databoard/insert.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			
			String path="c:\\project_upload";
			String enctype="UTF-8"; // 한글 파일명
			int max_size=1024*1024*100;
			MultipartRequest mr=
					new MultipartRequest(request, path, max_size, enctype, new DefaultFileRenamePolicy());
			// 파일명 자동 변경 => a.jpg, a1.jpg, a2.jpg ...
			
			String name=mr.getParameter("name");
			String subject=mr.getParameter("subject");
			String content=mr.getParameter("content");
			String pwd=mr.getParameter("pwd");
			String filename=mr.getFilesystemName("upload");
			
			DataBoardVO vo=new DataBoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);

			if(filename==null) // 업로드가 없는 상태
			{
				vo.setFilename("");
				vo.setFilesize(0);
			}
			else // 업로드가 된 상태
			{
				File file=new File(path+"\\"+filename);
				vo.setFilename(filename);
				vo.setFilesize((int)file.length());
			}
			
			DataBoardDAO.databoardInsert(vo);
		}catch(Exception ex) {}
		
		return "redirect:../databoard/list.do";
	}
	
	@RequestMapping("databoard/list.do")
	public String databoard_list(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		map.put("start", (curpage*10)-9);
		map.put("end", curpage*10);
		
		//////////////////////////////////////////////////////////////////////
		
		List<DataBoardVO> list=DataBoardDAO.databoardListData(map);
		int count=DataBoardDAO.databoardRowCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((curpage*10)-10);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String today=sdf.format(date);
		// <=> new SimpleDateFormat("yyyy-MM-dd").format(new Date()) ~~~> 서로 같은 식
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);		
		request.setAttribute("today", today);
		
		request.setAttribute("main_jsp", "../databoard/list.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("databoard/detail.do")
	public String databoard_detail(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		String no=request.getParameter("no");
		
		//////////////////////////////////////////////////////////////////////
		
		DataBoardVO vo=DataBoardDAO.databoardDetailData(Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		
		request.setAttribute("main_jsp", "../databoard/detail.jsp");
		return "../main/main.jsp";
		// Ajax(void), _ok => 리턴 시에 redirect 설정
	}
	
	@RequestMapping("databoard/download.do")
	public void databoard_download(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		try
		{
			String fn=request.getParameter("fn");
			
			File file=new File("c:\\project_upload");
			
			// header => 전송 : 파일명, 파일 크기
			response.setHeader("Content-Disposition", "attachment;filename="
					+URLEncoder.encode(fn,"UTF-8"));
			response.setContentLength((int)file.length());
			
			// 서버에서 파일 읽기
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			// 다운로드를 요청한 클라이언트
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			// 파일 저장 공간
			byte[] buffer=new byte[1024];
			// 읽은 바이트 수
			int i=0;
			while((i=bis.read(buffer,0,1024))!=-1)
			{
				bos.write(buffer,0,i);
			}
			bis.close();
			bos.close();
		}catch(Exception ex) {}
	}
	
	// Model => 사용자 요청 처리 => 결과값 / 화면 이동
	@RequestMapping("databoard/delete.do") // => if문과 동일
	public void databoard_delete(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		// data:{"no":no,"pwd":pwd} => delete.do?no=1&pwd=1234
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		
		//////////////////////////////////////////////////////////////////////
		
		// 데이터베이스 연동
		DataBoardVO vo=DataBoardDAO.databoardFileInfoData(Integer.parseInt(no));
		String result=DataBoardDAO.databoardDelete(Integer.parseInt(no), pwd);
		
		// 파일 삭제
		try
		{
			if(vo.getFilesize()>0)
			{
				File file=new File("c:\\project_upload\\"+vo.getFilename());
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
	
	/*
	 * 	요청값
	 *		<form>, <a> : 서버로 전송
	 *	응답값
	 *		request.setAttribute() : 서버에서 처리 결과
	 *
	 *	벤치 마킹
	 *	1) 서버로 전송되는 데이터 확인 : 주소란
	 *	2) 출력 화면 : 어떤 데이터가 필요한지 확인
	 *	   =========================== (웹 사이트의 70% 차지)
	 */
	@RequestMapping("databoard/update.do")
	public String databoard_update(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
		String no=request.getParameter("no");
		
		//////////////////////////////////////////////////////////////////////
		
		DataBoardVO vo=DataBoardDAO.databoardUpdateData(Integer.parseInt(no));
		
		//데이터를 request에 추가하여 jsp로 전송
		request.setAttribute("vo", vo);
		
		request.setAttribute("main_jsp", "../databoard/update.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("databoard/password_check.do")
	public void databoard_password_check(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		
		String db_pwd=DataBoardDAO.databoardGetPassword(Integer.parseInt(no));
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
	
	@RequestMapping("databoard/update_ok.do")
	public String databoard_update_ok(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			
			String path="c:\\project_upload";
			String enctype="UTF-8"; // 한글 파일명
			int max_size=1024*1024*100;
			MultipartRequest mr=
					new MultipartRequest(request, path, max_size, enctype, new DefaultFileRenamePolicy());
			// 파일명 자동 변경 => a.jpg, a1.jpg, a2.jpg ...
			
			String name=mr.getParameter("name");
			String subject=mr.getParameter("subject");
			String content=mr.getParameter("content");
			String pwd=mr.getParameter("pwd");
			String filename=mr.getFilesystemName("upload");
			String no=mr.getParameter("no");
			
			DataBoardVO vo=new DataBoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			vo.setNo(Integer.parseInt(no));
			
			DataBoardVO dvo=DataBoardDAO.databoardFileInfoData(Integer.parseInt(no));
			if(dvo.getFilesize()>0)
			{
				File file=new File("c:\\project_upload\\"+dvo.getFilename());
				file.delete();
			}

			if(filename==null) // 업로드가 없는 상태
			{
				vo.setFilename("");
				vo.setFilesize(0);
			}
			else // 업로드가 된 상태
			{
				File file=new File(path+"\\"+filename);
				vo.setFilename(filename);
				vo.setFilesize((int)file.length());
			}
			
			DataBoardDAO.databoardUpdate(vo);
		}catch(Exception ex) {}
		
		return "redirect:../databoard/list.do";
	}
	
/*	@RequestMapping("databoard/find.do")
	public String databoard_find(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		
		String fs=request.getParameter("fs");
		String ss=request.getParameter("ss");
		
		// 데이터베이스 연동
		Map map=new HashMap();
		map.put("fs", fs);
		map.put("ss", ss);
		// 데이터 전송 (결과값)
		List<DataBoardVO> list=DataBoardDAO.databoardFindData(map);
		
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../databoard/find.jsp");
		return "../main/main.jsp";
	} */
	
	/*
	 * 	사용자 요청값 전송
	 * 	============
	 * 	목록 => 페이지
	 * 	상세 보기 => 해당 게시물, 맛집에 대한 고유 번호
	 * 	검색 => 검색어
	 * 	로그인 => 아이디, 비밀 번호
	 * 	============
	 * 	목록 => List
	 * 	상세 보기 => VO
	 * 	검색 => List
	 * 	로그인 => String
	 */
	@RequestMapping("databoard/find.do")
	public String databoard_find(HttpServletRequest request,HttpServletResponse response)
	{
		CommonsModel.footerPrint(request);
		
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
		List<DataBoardVO> list=DataBoardDAO.databoardFindData(map);
		
		// 결과값 전송
		request.setAttribute("list", list);
		
		request.setAttribute("main_jsp", "../databoard/find.jsp");
		return "../main/main.jsp";
	}
}
