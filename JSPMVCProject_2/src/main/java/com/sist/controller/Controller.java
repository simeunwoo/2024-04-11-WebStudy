package com.sist.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
// XML 파서, 크롤링
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map clsMap=new HashMap();
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		/*
		clsMap.put("list.do", new ListModel());
		clsMap.put("insert.do", new InsertModel());
		clsMap.put("update.do", new UpdateModel());
		clsMap.put("delete.do", new DeleteModel());
		clsMap.put("find.do", new FindModel());
		*/
		try
		{
			// 싱글턴
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			
			// 파서기 => 파서 (XML, HTML, JSON) => 데이터를 추출
			DocumentBuilder db=dbf.newDocumentBuilder();
			
			Document doc=db.parse(new File("C:\\Users\\sist115_1\\git\\web-study\\JSPMVCProject_2\\src\\main\\webapp\\WEB-INF\\application.xml"));
			
			// 루트 읽기 => beans
			Element root=doc.getDocumentElement();
			System.out.println("root:"+root.getTagName()); // root:beans
			
			// 같은 태그를 묶어서 제어 => bean
			NodeList list=root.getElementsByTagName("bean");
			
			for(int i=0;i<list.getLength();i++)
			{
				Element bean=(Element)list.item(i);
				String id=bean.getAttribute("id");
				String cls=bean.getAttribute("class");
				System.out.println(id+":"+cls);
				/*
				list.do:com.sist.model.ListModel
				insert.do:com.sist.model.InsertModel
				update.do:com.sist.model.UpdateModel
				delete.do:com.sist.model.DeleteModel
				find.do:com.sist.model.FindModel
				 */
				// 메모리 할당
				Class clsName=Class.forName(cls);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				clsMap.put(id, obj);
			}
		}catch(Exception ex) {}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd=request.getRequestURI();
		// URL : http://localhost:8080/JSPMVCProject_2/*.do
		// URI : /JSPMVCProject_2/*.do
		cmd=cmd.substring(request.getContextPath().length()+1); // *.do
		
		Model model=(Model)clsMap.get(cmd);
		String jsp=model.execute(request);
		
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}
