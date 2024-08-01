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
</head>
<body>
<div class="container-fluid bg-primary px-5 d-none d-lg-block">
            <div class="row gx-0">
            	<div class="col-lg-2 text-right text-lg-end">
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
                <div class="col-lg-4 text-right text-lg-end">
                    <div class="d-inline-flex align-items-center" style="height: 45px;">
                        <a href="#"><small class="me-3 text-light"><i class="fa fa-user me-2"></i>로그인</small></a>
                        <a href="#"><small class="me-3 text-light"><i class="fa fa-sign-in-alt me-2"></i>회원가입</small></a>
                        <a href="#"><small class="me-3 text-light"><i class="fa fa-sign-in-alt me-2"></i>마이페이지</small></a>
                        <a href="#"><small class="me-3 text-light"><i class="fa fa-sign-in-alt me-2"></i>고객센터</small></a>                        
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->

        <!-- Navbar & Hero Start -->
        <div class="container-fluid position-relative p-0">
            <nav class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0">
                <a href="" class="navbar-brand p-0">
                    <h1 class="m-0"><i class="fa fa-map-marker-alt me-3"></i>TJ Camping</h1>
                    <!-- <img src="img/logo.png" alt="Logo"> -->
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="fa fa-bars"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto py-0">
                        
                        
                        
                        
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">캠핑장</a>
                            <div class="dropdown-menu m-0">
                                <a href="destination.html" class="dropdown-item">캠핑장 목록</a>
                                <a href="tour.html" class="dropdown-item">근처 맛집 목록</a>
                                <a href="booking.html" class="dropdown-item">캠핑장 예약</a>
                                <a href="gallery.html" class="dropdown-item">캠핑장 결제</a>
                            </div>
                        </div>
                        
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">캠핑용품</a>
                            <div class="dropdown-menu m-0">
                                <a href="destination.html" class="dropdown-item">캠핑용품 목록</a>
                                <a href="tour.html" class="dropdown-item">캠핑용품 예약</a>
                                <a href="booking.html" class="dropdown-item">캠핑용품 결제</a>
                            </div>
                        </div>
                        
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">레시피&맛집</a>
                            <div class="dropdown-menu m-0">
                                <a href="destination.html" class="dropdown-item">레시피 목록</a>
                                <a href="tour.html" class="dropdown-item">맛집 목록</a>
                            </div>
                        </div>
                        
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">커뮤니티</a>
                            <div class="dropdown-menu m-0">
                                <a href="destination.html" class="dropdown-item">캠핑장 후기</a>
                                <a href="tour.html" class="dropdown-item">캠핑용품 후기</a>
                            </div>
                        </div>
                        
                        
                        
                        
                        
                    </div>
                    
                </div>
            </nav>
</body>
</html>