package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 * 	MVC
 *            HTTP 요청 (URL)      웹 컨테이너 (톰캣)
 * 	웹 브라우저 ================   =====================================
 *     |                         Controller
 *     |                         -----------
 *     |                          1. 요청을 받는다 : getRequestURI()
 *     |                          2. URI를 이용하여 요청 내용 확인 => list.do, insert.do
 *     |                          3. 요청에 대한 처리 => Model이 가지고 있는 메소드 호출
 *     |                          4. Model에서 넘겨주는 request/session을 가지고 온다
 *     |                                           ======= request.setAttribute()
 *     |                          5. JSP로 값을 전송 (forward=request 전송, sendRedirect() 이용 화면 이동)
 *     |                                          Model               DAO           오라클
 *     |                         -----------  ------------------  ------------  ------------
 *     |                                       요청 처리              오라클 연동      사이트에 필요한 공유하는 데이터를 모아서 관리
 *                                             request/session에    필요한 데이터를
 *                                             값을 담아준다            가지고 온다
 *     |                         -----------  ------------------  ------------  ------------
 *     |
 *     |                       =====================================
 *     |                          JSP
 *     |                       ---------
 *     |---------------------
 *                             ---------
 *                             
 *	1. 브라우저 => URL을 이용하여 서버 연동 (주소창)
 *	2. URL을 이용하여 서버 연결이 되면 => Controller (URL을 읽을 수 있는 프로그램 : JSP / Servlet)
 *		=> 요청을 받아서 => 처리 => JSP로 결과값 전송
 *		================================== 화면 출력 없이 연결 (서블릿)
 *		JSP : Front-End (결과값을 받아서 출력)
 *	3. MVC의 단점은 Controller에 너무 집중적이다
 *	   ================================ 대체 : MVVM, MVP ... => 하지만 아직은 MVC가 대세
 *	4. Controller : 역할(고정) => 소스 수정이 거의 없다
 *		=> 필요한 데이터는 파일을 만들어서 전송
 *		   ========================
 *			| XML, properties
 *		=> 요청 받기
 *      => Model 클래스 / Model 안의 메소드 호출
 *                     ================== 구분자(Annotation)
 *                                        => 최종 : Spring
 */
public class BoardModel {
	/*
	 * 	Spring
	 * 	@Autowired => 자동 메모리 주소 주입 => 싱글턴 (new를 사용하지 않는다)
	 * 	private BoardDAO dao;
	 */
	private BoardDAO dao=BoardDAO.newInstance();

	@RequestMapping("board/list.do")
	public String board_list(HttpServletRequest request,HttpServletResponse response)
	{
		// page => 받기
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		/*
		 * 	URL
		 * 	===
		 * 	list.do ==============> null => if(page==null)
		 * 	list.do?page= ========> ""   => if(page.equals(""))
		 * 	list.do?page=1 =======> "1"
		 * 	list.do? page = 1 ====> 오류 발생 (String input "")
		 */
		// 정수형 변환 => 처리 가능
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData(curpage);
		// 총 게시물 개수
		int count=dao.boardRowCount();
		// 총 페이지
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((curpage*10)-10);
		// list.jsp로 출력 데이터 전송
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("count", count);
		
		// main.jsp에 include되는 파일 지정
		request.setAttribute("main_jsp", "../board/list.jsp");
		return "../main/main.jsp";
	}
}
