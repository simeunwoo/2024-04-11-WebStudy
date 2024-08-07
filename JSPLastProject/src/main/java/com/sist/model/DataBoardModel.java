package com.sist.model;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;

public class DataBoardModel {

	@RequestMapping("databoard/insert.do")
	public String databoard_insert(HttpServletRequest request,HttpServletResponse response)
	{
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
}
