<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
$(function(){	
	$.ajax({
		type:'post',
		url:'../camp/reserve_camp.do',
		success:function(result)
		{
			$('#camp_list').html(result)
		},
		error:function(request,status,error)
		{
			console.log(error)
		}
	})
})
</script>
</head>
<body>

<!-- Header Start -->
        <div class="container-fluid bg-breadcrumb">
            <div class="container text-center py-5" style="max-width: 900px;">
                <h3 class="text-white display-3 mb-4">캠핑장 예약</h3>
                <ol class="breadcrumb justify-content-center mb-0">
                </ol>    
            </div>
        </div>
        <!-- Header End -->
        
        
        <div class="container-fluid destination py-5">
		<div class="container py-5">

        <!-- Explore Tour Start -->



<div class="wrapper row3">
  <main class="container clear">
   <table class="table">
    <tr>
      <td width=30% class="danger" height="400">
       <table class="table">
        <caption><h4 class="text-center">캠핑장 정보</h4></caption>
        <tr>
        	<td>
        		<div id="camp_list" style="height:400px;overflow-y:scroll"></div>
        	</td>
        </tr>
       </table>
      </td>
      <td width=30% class="info" height="400">
       <table class="table">
        <caption><h4 class="text-center">예약일 정보</h4></caption>
        <tbody>
         <tr>
          <td id="rdate"></td>
         </tr>
        </tbody>
       </table>
      </td>
      <td width=20% rowspan="2" class="success" height="500">
       <table class="table">
        <caption><h4 class="text-center">예약 정보</h4></caption>
        <tr>
        	<td class="text-center" colspan="2">
        		<img src="#"
        		  style="width:250px;height:180px" id="camp_image">
        	</td>
        </tr>
        <tr>
        	<td width="30%" class="text-right">업체명</td>
        	<td width="70%" id="camp_name"></td>
        </tr>
        <tr>
        	<td width="30%" class="text-right">☎</td>
        	<td width="70%" id="camp_phone"></td>
        </tr>
        <tr>
        	<td width="30%" class="text-right">예악일</td>
        	<td width="70%" id="camp_day"></td>
        </tr>
        <tr>
        	<td width="30%" class="text-right">시간</td>
        	<td width="70%" id="camp_time_data"></td>
        </tr>
        <tr>
        	<td width="30%" class="text-right">인원</td>
        	<td width="70%" id="camp_inwon_data"></td>
        </tr>
        <tr id="reserveBtn" style="display:none">
        	<td colspan="2" class="text-center">
        		<form action="../camp/reserve_ok.do" method="post">
        			<input type="hidden" name="camp_no" value="" id="r_camp_no">
        			<input type="hidden" name="date" value="" id="r_date">
        			<input type="hidden" name="time" value="" id="r_time">
        			<input type="hidden" name="inwon" value="" id="r_inwon">
        			<button class="btn-lg btn-primary">예약하기</button>
        		</form>
        	</td>
        </tr>
       </table>
      </td>
    </tr>
    <tr>
      <td width=30% class="default" height=100>
        <table class="table">
        <caption><h4 class="text-center">시간 정보</h4></caption>
        <tr>
        	<td class="text-center" id="camp_time"></td>
        </tr>
       </table>
      </td>
      <td width=30% height=100>
       <table class="table">
        <caption><h4 class="text-center">인원 정보</h4></caption>
        <tr>
        	<td class="text-center" id="camp_inwon"></td>
        </tr>
       </table>
      </td>
    </tr>
   </table>
  </main>
</div>

</div></div>



<!-- Copyright Start -->
        <div class="container-fluid copyright text-body py-4">
            <div class="container">
                <div class="row g-4 align-items-center">
                    <div class="col-md-6 text-center text-md-end mb-md-0">
                        <i class="fas fa-copyright me-2"></i><a class="text-white" href="#">Your Site Name</a>, All right reserved.
                    </div>
                    <div class="col-md-6 text-center text-md-start">
                        <!--/*** This template is free as long as you keep the below author’s credit link/attribution link/backlink. ***/-->
                        <!--/*** If you'd like to use the template without the below author’s credit link/attribution link/backlink, ***/-->
                        <!--/*** you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". ***/-->
                        Designed By <a class="text-white" href="https://htmlcodex.com">HTML Codex</a> Distributed By <a href="https://themewagon.com">ThemeWagon</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Copyright End -->

        <!-- Back to Top -->
        <a href="#" class="btn btn-primary btn-primary-outline-0 btn-md-square back-to-top"><i class="fa fa-arrow-up"></i></a>   

        
        <!-- JavaScript Libraries -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/lightbox/js/lightbox.min.js"></script>
        

        <!-- Template Javascript -->
        <script src="js/main.js"></script>






</body>
</html>