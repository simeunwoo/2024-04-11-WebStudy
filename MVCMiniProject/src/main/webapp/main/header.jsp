<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	MVC
	=> HTML / Java : 분리해서 사용
	=> 소스가 적어진다 (X), 파일 수가 적어진다 (X)
		HTML => jsp
		Java => java
		===> 파일이 2배로 늘어난다 => 여러명의 개발자가 동시에 개발을 위하여 (프론트 + 백)
	=> JSP의 단점
		= 보안이 취약 (자바 => .class => JSP는 소스를 통으로 전송해야 한다)
		= 재사용이 어렵다, 확장성이 낮다
	=> HTML(View) / Java(Model) => 연결하는 파일(Controller)
	=> MVC 구조의 동작
		사용자 요청 (<form>, <a>, JavaScript)
			=> Controller => Servlet / JSP => URL 주소를 이용하여 데이터를 전송
			                                  =======================
			                                  일반 자바는 request가 없기 때문에 받을 수 없다
			                                  서블릿 / JSP => 연결 (JSP를 사용하고 보통 서블릿으로 만들어져 있다)
	Controller의 역할
	
	1) 사용자 요청 받기
	
	2) Model을 찾는다
	   =====
	   자바(클래스) => 연관된 기능만 가지고 있다
	   = 클래스 / 메소드 => 어노테이션(찾기)

	3) 요청 결과값을 가지고 온다 (request / session)
		request : 한개의 JSP에서만 사용할 경우
		session : 모든 JSP에 데이터를 공유할 경우

	4) 요청한 JSP로 request를 전송
		forward / sendRedirect
		
	JSP => Controller => Model => DAO => Model => Controller => JSP
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear">
  	<%--
  		EL
  		         request.setAttribute("id",값);
  		${id} => request.getAttribute("id");
  		${requestScope.id}
  		  ============ 생략 가능
  		         session.setAttribute("id",값);
  		${id} => session.getAttribute("id");
  		${sessionScope.id}
  		  ============ 생략 가능
  		  => 그러나 가급적이면 사용하는 것이 좋다
  		  => 같은 키명에 request/session 모두 생략할 경우 => 충돌 가능성 있음 => request 우선 생략
  	--%>
    <div id="logo" class="fl_left">
      <h1><a href="../main/main.do">맛집 AND 서울 여행</a></h1>
    </div>
    <div class="fl_right">
     <c:if test="${sessionScope.id==null }">
      <ul class="inline">
        <li><i class="fa fa-user"></i><input type="text" class="input-sm" placeholder="아이디"></li>
        <li><i class="fa fa-unlock-alt"></i><input type="password" class="input-sm" placeholder="비밀번호"></li>
        <li><input type="image" src="../main/login.png" style="width:100px;height:25px"></li>
      </ul>
     </c:if>
     <c:if test="${sessionScope.id!=null }">
      <ul class="inline">
        <li>${sessionScope.name }님 로그인되었습니다</li>
        <li><input type="image" src="../main/login.png" style="width:100px;height:25px"></li>
      </ul>
     </c:if>
    </div>
  </header>
</div>
<div class="wrapper row2">
  <nav id="mainav" class="clear">
    <ul class="clear">
      <li class="active"><a href="../main/main.do">홈</a></li>
      <li><a class="drop" href="#">회원</a>
        <ul>
          <li><a href="pages/gallery.html">회원 가입</a></li>
          <li><a href="pages/full-width.html">아이디 찾기</a></li>
          <li><a href="pages/sidebar-left.html">비밀 번호 찾기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="../food/list.do">맛집 목록</a></li>
          <%-- Controller를 찾을 때 URL 패턴 => .do --%>
          <c:if test="${sessionScope.id!=null }">
	          <li><a href="pages/full-width.html">맛집 예약</a></li>
          </c:if>
          <li><a href="../food/find.do">지역별 맛집 찾기</a></li>
          <li><a href="pages/sidebar-left.html">맛집 뉴스</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">서울 여행</a>
        <ul>
          <li><a href="../seoul/list.do">명소</a></li>
          <li><a href="pages/full-width.html">자연 & 관광</a></li>
          <li><a href="pages/sidebar-left.html">쇼핑</a></li>
          <li><a href="pages/sidebar-left.html">호텔</a></li>
          <li><a href="pages/sidebar-left.html">서울 날씨</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="../board/list.do">자유 게시판</a></li>
          <li><a href="pages/full-width.html">공지 사항</a></li>
          <c:if test="${sessionScope.id!=null }">
	          <li><a href="pages/sidebar-left.html">묻고 답하기</a></li>
	          <li><a href="pages/sidebar-left.html">실시간 채팅</a></li>
          </c:if>
        </ul>
      </li>
      <li><a href="#">스토어</a></li>
      <c:if test="${sessionScope.id!=null }">
      	<c:if test="${sessionScope.admin=='n' }">
	      <li><a href="#">마이페이지</a></li>
	    </c:if>
      	<c:if test="${sessionScope.admin=='y' }">
	      <li><a href="#">관리자페이지</a></li>
	    </c:if>
      </c:if>
    </ul>
  </nav>
</div>
</body>
</html>