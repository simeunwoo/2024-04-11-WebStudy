<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600&family=Roboto&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
<style>
.inline li {
            display: inline-flex; /* 수평으로 나열 */
            align-items: center; /* 수직 중앙 정렬 */
            margin-right: 15px; /* 항목 사이 간격 추가 */
        }
.navbar-nav .nav-link {
        font-size: 30px; /* 원하는 글씨 크기 설정 */
        line-height: 75px;
        text-align:center;
    }
</style>
        
</head>
<body>
<div class="container-fluid bg-primary px-5 d-none d-lg-block">
	<header id="header" class="clear">
		<div class="row gx-0">
					<div class="col-lg-6 text-right text-lg-end">
					</div>
			<div class="col-lg-4 text-right text-lg-end">
			<!-- <c:if test="${sessionScope.id==null }"> -->
					<ul class="inline">
						<li><i class="fa fa-user"></i><input type="text" class="input-sm" placeholder="아이디"></li>
				        <li><i class="fa fa-unlock-alt"></i><input type="password" class="input-sm" placeholder="비밀번호"></li>
				        <li><input type="image" src="../main/login.png" style="width:100px;height:35px"></li>
				        
					</ul>
		<!-- 	</c:if> -->
		<!--	<c:if test="${sessionScope.id!=null }">
					<ul class="inline">
				       	<li>${sessionScope.name }님 로그인되었습니다</li>
				       	<li><input type="image" src="../main/login.png" style="width:100px;height:25px"></li>
				   	</ul>
				</c:if> -->
            </div>
            <div class="col-lg-2 text-right text-lg-end">
				<div class="d-inline-flex align-items-center" style="height: 45px;">
                	<a href="#"><small class="me-4 text-light" style="color:white">로그인&nbsp;&nbsp;</small></a>
                    <a href="#"><small class="me-4 text-light" style="color:white">회원가입&nbsp;&nbsp;</small></a>
                    <a href="#"><small class="me-4 text-light" style="color:white">마이페이지&nbsp;&nbsp;</small></a>
                    <a href="#"><small class="me-4 text-light" style="color:white">고객센터</small></a>                        
                </div>
            </div>
        </div>
    </header>
</div>
        
<!-- Topbar End -->

<!-- Navbar & Hero Start -->
<div class="container-fluid position-relative p-0">
	<nav class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0">
		<a href="" class="navbar-brand p-0">
			<h1 class="m-0"><i class="fa fa-map-marker-alt me-3"></i>&nbsp;TJ Camping</h1>
                    <!-- <img src="img/logo.png" alt="Logo"> -->
		</a>
     <!--   <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        	<span class="fa fa-bars"></span>
        </button> -->
        <div class="collapse navbar-collapse" id="navbarCollapse">
           	<ul class="navbar-nav ms-auto py-0 text-center">
           	

                        
				<li class="nav-item dropdown" style="margin-right: 20px;size:50">
					<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" size="30">캠핑장&nbsp;</a>
                    <div class="dropdown-menu m-0">
                       	<a href="destination.html" class="dropdown-item">캠핑장 목록</a>
                        <a href="tour.html" class="dropdown-item">근처 맛집 목록</a>
                        <a href="booking.html" class="dropdown-item">캠핑장 예약</a>
                        <a href="gallery.html" class="dropdown-item">캠핑장 결제</a>
                    </div>
                </li>
                        
                <li class="nav-item dropdown" style="margin-right: 20px;">
                	<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">캠핑용품&nbsp;</a>
                    <div class="dropdown-menu m-0">
						<a href="destination.html" class="dropdown-item">캠핑용품 목록</a>
						<a href="tour.html" class="dropdown-item">캠핑용품 예약</a>
						<a href="booking.html" class="dropdown-item">캠핑용품 결제</a>
					</div>
				</li>
                        
				<li class="nav-item dropdown" style="margin-right: 20px;">
					<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">레시피&맛집&nbsp;</a>
					<div class="dropdown-menu m-0">
						<a href="destination.html" class="dropdown-item">레시피 목록</a>
						<a href="tour.html" class="dropdown-item">맛집 목록</a>
					</div>
				</li>
                        
				<li class="nav-item dropdown" style="margin-right: 20px;">
					<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">커뮤니티</a>
					<div class="dropdown-menu m-0">
						<a href="destination.html" class="dropdown-item">캠핑장 후기</a>
						<a href="tour.html" class="dropdown-item">캠핑용품 후기</a>
					</div>
				</li>
                        
			</ul>
		</div>
	</nav>
</div>
</body>
</html>