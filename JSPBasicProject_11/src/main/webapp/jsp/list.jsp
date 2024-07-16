<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%--
	데이터 관리 => 지속적으로 상태 관리
	                  ====== 데이터가 변경되는 상태 => JavaScript
	                                           ==========
	                                           1. Jquery
	                                           2. VueJs
	                                           3. ReactJs
	                                           ========== 상태 관리 (클라이언트에서 데이터 관리)
	
	자바 (서버)
	
	Cookie
		사용 클래스 : Cookie
			request.getCookies()
		저장되는 값 : 문자열
		저장 장소 : 클라이언트 브라우저
		사용처 : 보안이 취약
			최신 방문
			자동 로그인 (Spring => remember-me)
	
	Session
		사용 클래스 : HttpSession => 생성 시에는 request
			request.getSession()
		저장되는 값 : 자바에서 사용하는 모든 클래스 (Object)
		저장 장소 : sessionId 외에는 실제 데이터는 서버에 저장
		        ========== 브라우저 구분자 (사용자의 IP나 PORT)
		        sessionId를 이용하여 실시간 채팅
		사용처 : 보안이 뛰어나다
			로그인 처리 시 => 사용자 정보
			장바구니를 임시로 저장 => Ajax / Vue / React / next
	
	(301page)
	
	Cookie의 주요 메소드
		*** 1. 생성 방법
			Cookie cookie=new Cookie(String key,String value)
				=> Map 방식 => 키가 중복되면 덮어 쓴다
		*** 2. 저장 방법
			response.addCookie(cookie) => 브라우저로 전송하는 과정
			======== 한개의 JSP에서 한개의 내용만 전송 가능
			                    =======
			                    HTML / Cookie => 동시에 전송이 불가능 => JSP를 두개 사용한다
		3. 저장 기간
			cookie.setMaxAge(초 단위로 등록) => 60*60*24
		*** 4. 저장 위치 확인
			cookie.setPath("/") => 루트에 저장 => 권장
		*** 5. 키 읽기
			cookie.getName()
		6. 값 읽기
			cookie.getValue()
		7. 삭제 방법
			cookie.setMaxAge(0) => addCookie를 이용하여 브라우저로 전송
		8. 전체 쿠키를 읽을 경우
			Cookie[] cookies=request.getCookies()
			=> 저장 순서가 순차적으로 되어 있다
			=> 최신 등록
				cookies.length-1
	
	Session의 주요 메소드 => 서버에 저장 (구분 => getId(), 저장 공간 클라이언트 당 한개만 배정)
		*** 1. 생성 방법
			HttpSession session=request.getSession()
			=> JSP에서는 사용 X => JSP에서는 내장 객체를 이용한다
			=> 자바에서 세션 사용 시에 MVC, Servlet, Spring
		*** 2. 저장 방법
			session.setAttribute(String key,Object obj)
			                     ========== 구분자
		*** 3. 저장된 값 읽기
			Object session.getAttribute(String key) => 데이터를 받을 때 형변환을 사용
		4. 저장된 데이터의 일부 삭제
			removeAttribute()
		*** 5. 전체 삭제
			invalidate() : 로그아웃에 주로 사용
		6. 클라이언트마다 식별자
			getId()
		7. 서버에 저장하는 기간 => 디폴트 : 30분(1800초)
			setMaxInactiveInterval()
		8. 저장이 처음인지 여부
			isNew()
--%>
<%
	String strPage=request.getParameter("page");
	if(strPage==null)
		strPage="1";
	
	int curpage=Integer.parseInt(strPage);
	
	// DB 연동
	SeoulDAO dao=SeoulDAO.newInstance();
	List<LocationVO> list=dao.seoulLocationListData(curpage);
	int totalpage=dao.seoulLocationTotalPage();
	
	final int BLOCK=10;
	int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	
	if(endPage>totalpage)
		endPage=totalpage;
	
	// 쿠키 출력
	Cookie[] cookies=request.getCookies();
	List<LocationVO> cList=new ArrayList<LocationVO>();
	if(cookies!=null)
	{
		// 가장 최근에 등록된 쿠키 데이터 읽기
		for(int i=cookies.length-1;i>=0;i--)
		{
			if(cookies[i].getName().startsWith("seoul_no"))
			{
				String no=cookies[i].getValue();
				LocationVO vo=dao.seoulDetailData(Integer.parseInt(no));
				cList.add(vo);
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 960px;
}
.a{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<%
				for(LocationVO vo:list)
				{
					/*
						response
							응답 : HTML / Cookie
							화면 변경 : sendRedirect()
						request
							요청 : 데이터를 전송
								쿠키 읽기 / 세션 읽기
								사용자가 보내주는 모든 데이터는 request에 저장
								?값, <form>
						Spring : 사용이 쉽게 만들어준 라이브러리
						         ============= 형식이 1개 (표준화)
						         => 출력 시에는 JSP를 이용한다 / 처리 시에는 자바를 이용한다
						         
						구구단(2차 for문) / 페이지(1차 for문)
					*/
			%>
					<div class="col-sm-3">
						<div class="thumbnail">
							<a href="detail_before.jsp?no=<%=vo.getNo()%>">
						<img src="<%=vo.getPoster() %>" style="width:240px;height:200px" onerror="this.src='no_img.png'">
								<p class="a"><%=vo.getTitle() %></p>
							</a>
						</div>
					</div>
			<%
				}
			%>
		</div>
	</div>
	<div class="row">
		<div class="text-center">
			<ul class="pagination">
				<%
					if(startPage>1) // 1 11 21 ...
					{
				%>
						<li><a href="list.jsp?page=<%=startPage-1%>">&lt;</a></li>
				<%
					}
					for(int i=startPage;i<=endPage;i++)
					{
				%>
						<li class="<%=i==curpage?"active":""%>"><a href="list.jsp?page=<%=i%>"><%=i %></a></li>
				<%
					}
					if(endPage<totalpage) // 10 20 30 ...
					{
				%>
						<li><a href="list.jsp?page=<%=endPage+1%>">&gt;</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<div style="height:20px"></div>
		<div class="row">
			<h3>최근 방문 서울 여행</h3>
			<hr>
			<a href="all_delete.jsp" class="btn btn-sm btn-success">전체 삭제</a>
			<a href="all_view.jsp" class="btn btn-sm btn-info">전체 보기</a>
			<hr>
			<%
				int i=0;
				for(LocationVO vo:cList)
				{
					if(i>8)
						break;
			%>
					<figure style="float:left;margin-left:5px">
						<img src="<%=vo.getPoster()%>" style="width:100px;height:100px" class="img-rounded">
						<figcaption style="margin:5px 30px">
							<a href="delete.jsp?no=<%=vo.getNo() %>" class="btn btn-xs btn-danger">삭제</a>
						</figcaption>
					</figure>
			<%
					i++;
				}
			%>
		</div>
	</div>
</body>
</html>