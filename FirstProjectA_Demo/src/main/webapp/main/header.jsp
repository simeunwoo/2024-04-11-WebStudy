<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script> 
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
			url:'../member/logout.do',
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
<style type="text/css">
.col-lg-4{
	display: inline;
}
</style>
</head>
<body>
 <div class="container-fluid" style="background-color: rgb(37, 103, 75); padding: 0 20px; display: none; display: block;">

            <div class="row gx-0">
                 <div class="col-lg-4 text-center text-lg-start mb-2 mb-lg-0">
                    <div class="d-inline-flex align-items-center" style="height: 45px;">
                        <!--<a class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2" href=""><i class="fab fa-twitter fw-normal"></i></a>
                        <a class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2" href=""><i class="fab fa-facebook-f fw-normal"></i></a>
                        <a class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2" href=""><i class="fab fa-linkedin-in fw-normal"></i></a>
                        <a class="btn btn-sm btn-outline-light btn-sm-square rounded-circle me-2" href=""><i class="fab fa-instagram fw-normal"></i></a>
                        <a class="btn btn-sm btn-outline-light btn-sm-square rounded-circle" href=""><i class="fab fa-youtube fw-normal"></i></a>-->
                    </div>
                </div>
                <div class="col-lg-8 text-center text-lg-end">
                    <div class="d-inline-flex align-items-center" style="height: 45px;">
                 <!--  <c:if test="${sessionScope.id==null }">-->
				      <ul class="inline">
				        <li style="display: inline-block;"><input style="margin-top:17px" type="text" id="id" class="input-sm" placeholder="아이디"></li>
				        <li style="display: inline-block;"><input type="password" id="pwd" class="input-sm" placeholder="비밀 번호"></li>
				        <li style="display: inline-block;"><input type="button" id="logBtn" class="btn-sm btn-danger" value="로그인">&nbsp;&nbsp;</li>
				      </ul>
			  <!-- 	</c:if> -->
			  <!-- 	<c:if test="${sessionScope.id!=null }">
				      <ul class="inline">
				      	<li style="display: inline-block;">${sessionScope.name }(${sessionScope.admin=='y'?"관리자":"일반 사용자" })님 로그인되었습니다</li>
				        <li style="display: inline-block;"><input type="button" id="logoutBtn" class="btn-sm btn-success" value="로그아웃">&nbsp;&nbsp;</li>
				      </ul>
			    	</c:if> -->
                <!-- <a href="../login/login.do"><small class="me-3 text-light"><i class="fa fa-sign-in-alt me-2"></i>로그인</small></a> -->
                        <a href="../login/join.do"><small class="me-3 text-light"><i class="fa fa-user me-2"></i>회원가입</small></a>
                        <a href="#"><small class="me-3 text-light"><i class="fa fa-user me-2"></i>고객센터</small></a>
                        <a href="#"><small class="me-3 text-light"><i class="fa fa-user me-2"></i>마이페이지</small></a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->

        <!-- Navbar & Hero Start -->
        <div class="container-fluid position-relative p-0">
            <nav class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0">
                <a href="../main/main.do" class="navbar-brand p-0">
                    <h1 class="m-0"><i class="fa fa-map-marker-alt me-3"></i>&nbsp;&nbsp;TJ Camping</h1>
                    <!-- <img src="img/logo.png" alt="Logo"> -->
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="fa fa-bars"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto py-0">
                        <a href="../main/main.do" class="nav-item nav-link active">&nbsp;&nbsp;&nbsp;홈&nbsp;&nbsp;&nbsp;</a>
                        
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            &nbsp;&nbsp;&nbsp;캠핑장&nbsp;&nbsp;&nbsp;</a>
                            <div class="dropdown-menu m-0">
                                <a href="../camp/list.do" class="dropdown-item">캠핑장 목록</a>
                                <a href="#" class="dropdown-item">지역별 캠핑장</a>
                                <a href="#" class="dropdown-item">With Pet 캠핑장</a>
                                <a href="#" class="dropdown-item">근처 맛집</a>
                            </div>
                        </div>
                        
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            &nbsp;&nbsp;&nbsp;캠핑용품&nbsp;&nbsp;&nbsp;</a>
                            <div class="dropdown-menu m-0">
                                <a href="#" class="dropdown-item">캠핑용품 목록</a>
                                <a href="#" class="dropdown-item">브랜드별 캠핑용품</a>
                                <a href="#" class="dropdown-item">베스트 상품 캠핑용품</a>
                                <a href="#" class="dropdown-item">신상품 캠핑용품</a>
                                <a href="#" class="dropdown-item">세일 상품 캠핑용품</a>
                            </div>
                        </div>
                        
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            &nbsp;&nbsp;&nbsp;레시피&맛집&nbsp;&nbsp;&nbsp;</a>
                            <div class="dropdown-menu m-0">
                                <a href="#" class="dropdown-item">레시피 목록</a>
                                <a href="#" class="dropdown-item">맛집 목록</a>
                            </div>
                        </div>
                        
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            &nbsp;&nbsp;&nbsp;커뮤니티&nbsp;&nbsp;&nbsp;</a>
                            <div class="dropdown-menu m-0">
                                <a href="#" class="dropdown-item">캠핑장 후기</a>
                                <a href="#" class="dropdown-item">캠핑용품 후기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
</body>
</html>