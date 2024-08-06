<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#logBtn').on('click',function(){
		let id=$('#id').val()
		if(id.trim()==="")
		{
			$('#id').focus
			return
		}
		let pwd=$('#pwd').val()
		if(pwd.trim()==="")
		{
			$('#pwd').focus
			return
		}
		
		$.ajax({
			type:'post',
			url:'../member/login.do',
			data:{"id":id,"pwd":pwd}, // ex) ?id=aaa&pwd=1234
			success:function(result)
			{
				// 정상 수행 => status : 200
				// NOID / NOPWD / OK
				if(result=='NOID')
				{
					alert("존재하지 않는 아이디입니다")
					$('#id').val("")
					$('#pwd').val("")
					$('#id').focus()
				}
				else if(result=='NOPWD')
				{
					alert("존재하지 않는 비밀 번호입니다")
					$('#pwd').val("")
					$('#pwd').focus()
				}
				else
				{
					location.href="../main/main.do"
				}
			},
			error:function(request,status,error)
			{
				// 오류 발생
				console.log("code : "+request.status)
				console.log("message : "+request.responseText)
				console.log("error : "+error) // 404, 500 ...
			}
		})
	})
	$('#logoutBtn').click(function(){
		$.ajax({
			type:'post',
			url:'../member.logOut.do',
			success:function(result)
			{
				location.href="../main/main.do"
			},
			error:function(request,status,error)
			{
				console.log("code : "+request.status)
				console.log("message : "+request.responseText)
				console.log("error : "+error)
			}
		})
	})
})
</script>
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
      
    <div id="logo" class="fl_left">
      <h1><a href="../main.main/do">Food & Recipe</a></h1>
    </div>
    <div class="fl_right">
    	<c:if test="${sessionScope.id==null }">
	      <ul class="inline">
	        <li><input type="text" id="id" class="input-sm" placeholder="아이디"></li>
	        <li><input type="password" id="pwd" class="input-sm" placeholder="비밀 번호"></li>
	        <li><input type="button" id="logBtn" class="btn-sm btn-danger" value="로그인"></li>
	      </ul>
    	</c:if>
    	<c:if test="${sessionScope.id!=null }">
	      <ul class="inline">
	      	<li>${sessionScope.name }(${sessionScope.admin=='y'?"관리자":"일반 사용자" })님 로그인되었습니다</li>
	        <li><input type="button" id="logoutBtn" class="btn-sm btn-success" value="로그아웃"></li>
	      </ul>
    	</c:if>
    </div>
       
  </header>
</div>
   
   
  
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
      
    <ul class="clear">
      <li class="active"><a href="../main/main.do">홈</a></li>
      <c:if test="${sessionScope.id==null }"><!-- 로그인이 안된 경우 -->
	      <li><a class="drop" href="#">회원</a>
	        <ul>
	          <li><a href="../member/join.do">회원 가입</a></li>
	          <li><a href="../member/idfind.do">아이디 찾기</a></li>
	          <li><a href="../member/pwdfind.do">비밀 번호 찾기</a></li>
	        </ul>
	      </li>
      </c:if>
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="pages/gallery.html">맛집 찾기</a></li>
          <c:if test="${sessionScope.id!=null }"><!-- 로그인이 된 경우 -->
          	<li><a href="pages/full-width.html">맛집 예약</a></li>
          </c:if>
          <li><a href="pages/sidebar-left.html">맛집 추천</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="pages/gallery.html">셰프</a></li>
          <li><a href="pages/full-width.html">레시피</a></li>
          <li><a href="pages/sidebar-left.html">레시피 만들기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">스토어</a>
        <ul>
          <li><a href="pages/gallery.html">전체 상품</a></li>
          <li><a href="pages/full-width.html">베스트 상품</a></li>
          <li><a href="pages/sidebar-left.html">특가 상품</a></li>
          <li><a href="pages/sidebar-left.html">가격 비교</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">여행</a>
        <ul>
          <li><a href="pages/gallery.html">명소</a></li>
          <li><a href="pages/full-width.html">자연 & 관광</a></li>
          <li><a href="pages/sidebar-left.html">호텔</a></li>
          <li><a href="pages/sidebar-left.html">쇼핑</a></li>
          <li><a href="pages/sidebar-left.html">날씨</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="pages/gallery.html">자유 게시판</a></li>
          <c:if test="${sessionScope.id!=null }"><!-- 로그인이 된 경우 -->
          	<li><a href="pages/full-width.html">묻고 답하기</a></li>
          </c:if>
          <li><a href="pages/sidebar-left.html">공지 사항</a></li>
          <c:if test="${sessionScope.id!=null }"><!-- 로그인이 된 경우 -->
          	<li><a href="pages/sidebar-left.html">실시간 채팅</a></li>
          </c:if>
        </ul>
      </li>
      <c:if test="${sessionScope.id!=null }"><!-- 로그인이 된 경우 -->
      	<c:if test="${sessionScope.admin=='n' }"><!-- 관리자가 아닌 경우 -->
	  	    <li><a href="#">마이페이지</a></li>
	  	 </c:if>
      	<c:if test="${sessionScope.admin=='y' }"><!-- 관리자인 경우 -->
	  	    <li><a href="#">관리자페이지</a></li>
	  	 </c:if>
	  </c:if>
    </ul>
       
  </nav>
</div>
</body>
</html>