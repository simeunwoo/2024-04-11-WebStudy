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

      

</head>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(function(){
	function loadCalendar(){
		let year=$('#year').val()
		let month=$('#month').val()
		let cno=${strCno}
		
		$.ajax({
			type:'post',
			url:'../camp/reserve.do',
			data:{"year":year,"month":month,"cno":cno},
			success:function(result)
			{
				
			},
			error:function(request,status,error)
			{
				console.log(error)
			}
			})
		}
	
	loadCalendar()
	
	$('#year,#month').change(function(){
		loadCalendar()
	})
	
	
	
})
$(function(){
	$('.times').click(function(){
		let time=$(this).text()
		
		$.ajax({
			type:'post',
			url:'../camp/reserve.do',
			success:function(result)
			{
				$('#camp_time_data').text(time)
				
				$('#r_time').val(time)
			},
			error:function(request,status,error)
			{
				console.log(error)
			}
		})
	})
})
$(function(){
	$('.inwons').click(function(){
		let inwon=$(this).text()
		$('#camp_inwon_data').text(inwon)
		$('#reserveBtn').show()
		
		$('#r_inwon').val(inwon)
	})
})
</script>
<style type="text/css">
.rday_can:hover{
	cursor: pointer;
}
</style>
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
        <h4 class="text-center">캠핑장 정보</h4>
        <tr>
        	<td colspan="2" class="text-center">
        		<img src="${vo.image1 }" style="width:200px;height:200px">
        	</td>
        </tr>
        <tr>
        	<th width="20%">업체명</th>
        	<td width="80%">${vo.camp_name }</td>
        </tr>
        <tr>
        	<th width="20%">주소</th>
        	<td width="80%">${vo.camp_addr }</td>
        </tr>
        <tr>
        	<th width="20%">☎</th>
        	<td width="80%">${vo.camp_phone }</td>
        </tr>
        <tr>
        	<th width="20%">가격</th>
        	<td width="80%">${vo.camp_price }원</td>
        </tr>
        <tr>
        	<th width="20%">예약일</th>
        	<td width="80%" id="camp_day"></td>
        </tr>
        <tr>
        	<th width="20%">시간</th>
        	<td width="80%" id="camp_time_data"></td>
        </tr>
        <tr>
        	<th width="20%">인원</th>
        	<td width="80%" id="camp_inwon_data"></td>
        </tr>
        
        <form action="../reserve/reserve_ok.do" method="post">
        	<input type="hidden" name="strCno" value="" id="r_cno">
        	<input type="hidden" name="date" value="" id="r_date">
        	<input type="hidden" name="time" value="" id="r_time">
        	<input type="hidden" name="inwon" value="" id="r_inwon">
        	<button class="btn-lg btn-primary">예약하기</button>
        </form>
        
       </table>
      </td>
      <td width=30% class="info" height="400">
       <table class="table">
        <caption><h4 class="text-center">예약일 정보</h4></caption>
        <tbody>
         <tr>
          <td>
          	  <table class="table">
			   <tr>
			     <td class="text-center">${year }년 ${month }월</td>
			   </tr>
			   <tr>
			     <td class="inline">
			      <select name="year" id="year" class="input-sm">
			       <c:forEach var="i" begin="2024" end="2028">
			        <option ${i==year?"selected":""}>${i }</option>
			       </c:forEach>
			      </select>년&nbsp;
			      <select name="month" id="month" class="input-sm">
			       <c:forEach var="i" begin="1" end="12">
			        <option ${i==month?"selected":""}>${i }</option>
			       </c:forEach>
			      </select>월
			     </td>
			   </tr>
			  </table>
			  <div style="height: 10px"></div>
			  <table class="table">
			    <tr>
			     <c:forEach var="i" items="${weeks }" varStatus="s">
			       <c:choose>
			        <c:when test="${s.index==0 }">
			         <c:set var="color" value="red"/>
			        </c:when>
			        <c:when test="${s.index==6 }">
			         <c:set var="color" value="blue"/>
			        </c:when>
			        <c:otherwise>
			          <c:set var="color" value="black"/>
			        </c:otherwise>
			       </c:choose>
			       <th class="text-center"><span style="color:${color}">${i }</span></th>
			     </c:forEach>
			    </tr>
			    <c:set var="week" value="${week}"/>
			    <c:forEach var="i" begin="1" end="${lastday }">
			      <c:if test="${i==1 }">
			       <tr>
			        <c:forEach var="j" begin="1" end="${week }">
			          <td class="text-center" height="35">&nbsp;</td>
			        </c:forEach>
			      </c:if>
			      <c:if test="${rday[i]==1 }">
				      <td class="text-center success ${day1==i?'danger':'' }" height="35">
				      	
				      </td>
			      </c:if>
			      <c:if test="${rday[i]==0 }">
				      <td class="text-center ${day1==i?'danger':'' }" height="35">
				      	<span style="color:gray">${i }</span>
				      </td>
			      </c:if>
			      <c:set var="week" value="${week+1 }"/>
			      <c:if test="${week>6 }">
			       <c:set var="week" value="0"/>
			       <tr/>
			       <tr>
			      </c:if>
			    </c:forEach>
			    </tr>
			  </table>
          </td>
         </tr>
        </tbody>
       </table>
      </td>
    </tr>
    
    <tr>
      <td width=30% class="default" height=100>
        <table class="table">
        <caption><h4 class="text-center">시간 정보</h4></caption>
        <tr>
        	<td class="text-center" id="camp_time">
        		<c:forEach var="t" items="${tList }">
					<span class="btn btn-xs btn-primary times" style="margin-top:5px;margin-left:5px">${t }</span>
				</c:forEach>
        	</td>
        </tr>
       </table>
      </td>
      <td width=30% height=100>
       <table class="table">
        <caption><h4 class="text-center">인원 정보</h4></caption>
        <tr>
        	<td class="text-center" id="camp_inwon">
        		<c:forEach var="i" begin="1" end="5">
					<span class="btn btn-xs btn-danger inwons">${i }명</span>
				</c:forEach>
					<span class="btn btn-xs btn-danger inwons">단체</span>
        	</td>
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