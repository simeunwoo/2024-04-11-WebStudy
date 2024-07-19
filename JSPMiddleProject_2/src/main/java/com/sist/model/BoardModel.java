package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
import java.text.*;
// 요청 처리 후에 결과값을 JSP로 전송 : Model
// 오라클 연결 / 데이터를 모은다 / 전송
//   DAO         VO      Model => Model(Back-End)
/*
 * 	1. GIT
 * 	2. 데이터베이스 설계 => 정규화
 * 	3. ERD
 * 	4. 유스케이스 다이어그램
 * 	5. UI => 화면
 * 	6. 구현
 * 	7. 테스팅
 * 	8. 배포 => AWS
 */
/*
 * 	JSP 파일
 * 	<%@ page ~ %>
 * 	<%
 * 		데이터 읽기 => 자바 파일로 제작
 * 	%>
 */
/*
 * 	JSP =====> Java : URL 주소로 Java 호출이 불가능
 * 		request 객체를 전송
 * 	JSP =====> JSP : URL 주소로 값 전송이 가능
 * 	JSP =====> Servlet : URL 주소로 값 전송이 가능
 */
public class BoardModel {

	// request에 값을 담아주는 역할 => 요청 처리하는 부분
	public void boardListData(HttpServletRequest request)
	{
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		
		BoardDAO dao=BoardDAO.newInstance();
		List<BoardVO>list=dao.boardListData(curpage);
		
		int totalpage=dao.boardTotalPage();
		
		// list.jsp로 출력에 필요한 데이터 전송
		request.setAttribute("list", list);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		// 오늘 날짜 전송
		request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}
}
