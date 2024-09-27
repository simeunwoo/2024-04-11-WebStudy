<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Travela - Tourism Website Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
   href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600&family=Roboto&display=swap"
   rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link rel="stylesheet"
   href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
   rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
   rel="stylesheet">
<link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">


<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="../lib/easing/easing.min.js"></script>
<script src="../lib/waypoints/waypoints.min.js"></script>
<script src="../lib/owlcarousel/owl.carousel.min.js"></script>
<script src="../lib/lightbox/js/lightbox.min.js"></script>
<script type="text/javascript"></script>
<style>

.owl-nav{
   display:flex;
}
main {
   margin-top: 70px;
}

/* 포스터와 내용 구역을 왼쪽과 오른쪽으로 나누기 */
.container-content {
 display: flex;
    justify-content: center; /* 중앙 정렬 */
    gap: 20px; /* 포스터와 이미지 영역 사이의 간격 */
  
}

.poster {
   flex: 1; /* 왼쪽 절반을 차지하도록 설정 */
    max-width: 50%; /* 최대 너비를 절반으로 제한 */
    display: flex;
    justify-content: center; /* 포스터 중앙 정렬 */
}

.poster img {
   width: 100%; /* 포스터가 영역을 가득 차지하도록 설정 */
   height: auto;
   object-fit: cover; /* 이미지 크기 조절 시 비율 유지 */
   max-height: 100%; /* 포스터가 영역을 벗어나지 않도록 설정 */
}

.details {
    flex: 1; /* 오른쪽 절반을 차지하도록 설정 */
    max-width: 50%; /* 최대 너비를 절반으로 제한 */
    display: flex;
    flex-direction: column;
    justify-content: flex-start; /* 위쪽 정렬 */
}

.tags {
   margin-bottom: 20px;
}

.images {
   display: grid;
   grid-template-columns: repeat(2, 1fr); /* 두 개씩 한 줄로 나열 */
   gap: 10px;
}

.images img {
 width: 100%; /* 그리드 셀의 폭에 맞게 조절 */
    height: auto;
    border-radius: 10px;
    object-fit: cover; /* 이미지가 셀에 맞게 조절되도록 설정 */
}

.images figure {
   margin: 0; /* 기본 여백 제거 */
}

.images img {
   width: 100%; /* 그리드 셀의 폭에 맞게 조절 */
   height: auto;
   border-radius: 10px;
   object-fit: cover; /* 이미지가 셀에 맞게 조절되도록 설정 */
}

.packages-item {
   margin-bottom: 30px;
   max-width: 100%;
   overflow: hidden;
}

.packages-img {
   width: 100%;
   height: 300px;
   overflow: hidden;
}

.packages-img img {
   width: 100%;
   height: 100%;
   display: block;
   margin: 0 auto;
}

.packages-content h5 {
   white-space: nowrap;
   overflow: hidden;
   text-overflow: ellipsis;
   text-align: center;
}






</style>
<link href="https://cdn.jsdelivr.net/npm/lightbox2@2.11.3/dist/css/lightbox.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/lightbox2@2.11.3/dist/js/lightbox-plus-jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(function(){
   // detail.do?fno=2&type=1
   replyList(${param.fno})
   $('#writeBtn').on('click',function(){
      let msg=$('#msg').val()
      if(msg.trim()==="")
      {
         $('#msg').focus()
         return
      }
      let cno=$(this).attr("data-cno")
      
      $.ajax({
         type:'post',
         url:'../all_reply/insert.do',
         data:{"cno":cno,"type":1,"msg":msg},
         success:function(result)
         {
            if(result==='OK')
            {
               replyList(cno)
            }
            else
            {
               alert(result)
            }
         },
         error:function(request,status,error)
         {
            console.log(error)
         }
      })
   })
   
   /*  let bCheck=false;*/
       $('#jjimBtn').on('click',function(){
      let cno = $(this).attr("data-cno")
      // ajax이용 type=1

      $.ajax({
         type:'post',
         url:'../all_jjim/fbinsert.do' ,
         data:{"cno":cno,"type":1} ,
         success:function(result){
            if(result==="OK"){
               $(this).attr("data-count",1);
               $(this).attr("class",'btn-xs btn-default')
               location.href="../food/detail.do?fno="+cno+"&type=1"
            } else{
               alert(result)
            }
         } ,
         error:function(request,status,error)
         {
            console.log(error)
         }
      })
      
   }) 
})







// 삭제
function replyDelete(rno,cno)
{
   $.ajax({
      type:'post',
      url:'../all_reply/delete.do',
      data:{"rno":rno},
      success:function(result)
      {
         if(result==="OK")
         {
            replyList(cno)
         }
         else
         {
            alert(result)
         }
      },
      error:function(request,status,error)
      {
         console.log(error)
      }
   })
}
function replyUpdate(rno)
{
   $('.updates').hide()
   $('#m'+rno).show()
}
function replyUpdateData(rno,cno)
{
   let msg=$('#msg'+rno).val()
   if(msg.trim()==="")
   {
      $('#msg'+rno).focus()
      return
   }
   $.ajax({
      type:'post',
      url:'../all_reply/update.do',
      data:{"rno":rno,"msg":msg},
      success:function(result)
      {
         if(result==='OK')
         {
            replyList(cno)
            
         }
         else
         {
            alert(result)
         }
         $('#m'+rno).hide()
      },
      error:function(request,status,error)
      {
         console.log(error)
      }
   })
}
function replyList(cno)
 {
    $.ajax({
       type:'post',
       url:'../all_reply/list.do',
       data:{"cno":cno,"type":1},
       success:function(json)
       {
          json=JSON.parse(json)
          let html=''
          
          json.map(function(reply){
             //for(let reply of json){
                 html+='<table class="table">'
                html+='<tr>'
                html+='<td class="text-left">◑'+reply.name+'('+reply.dbday+')</td>'
                html+='<td class="text-right">'
                  if(reply.id===reply.sessionId)
                  {
                     html+='<span class="btn btn-xs btn-success ups" onclick="replyUpdate('+reply.rno+')">수정</span>&nbsp;' 
                     html+='<input type=button class="btn btn-xs btn-warning" value="삭제" onclick="replyDelete('+reply.rno+','+reply.cno+')">' 
                  }
                html+='</td>'
                html+='</tr>'
                html+='<tr>'
                html+='<td colspan="2">'
                html+='<pre style="white-space:pre-wrap;border:none;background:white">'+reply.msg+'</pre>'
                html+='</td>'
                html+='</tr>'
                 html+='<tr class="updates" id="m'+reply.rno+'" style="display:none">'
                 html+='<td>'
                 html+='<textarea rows="4" cols="70" id="msg'+reply.rno+'" style="float: left">'+reply.msg+'</textarea>'
                 html+='<input type=button value="댓글수정" onclick="replyUpdateData('+reply.rno+','+reply.cno+')" style="width: 100px;height: 85px;background-color: green;color:black">'
                 html+='</td>'
                 html+='</tr>'
                html+='</table>'
             //}
          })
          console.log(html)
          $('#reply').html(html)
          $('#msg').val("")
       },
       error:function(request,status,error)
       {
          console.log(error)
       }
    })
 }
</script>
</head>
<body>
	<!-- Header Start -->
	<div class="container-fluid whitezzz" style="height:100px;"></div>
<div class="mx-auto text-center mb-5" style="max-width: 900px;">
			<h5 class="section-title text-black display-6 mb-4 text-center " style="margin-top:20px" >&nbsp;상세정보&nbsp;</h5>
	<h1 class="mb-0 display-3">${vo.name }</h1>
	</div>
	<!-- <div class="container-fluid bg-breadcrumb">
		<div class="container text-center py-5" style="max-width: 900px;">
			<ol class="breadcrumb justify-content-center mb-0">
			</ol>
		</div>
	</div> -->
	<!-- Header End -->
 <div class="wrapper row3">
   <main class="container clear">
      <!-- 상세보기 / 댓글 -->
<!-- 포스터와 내용 구역을 왼쪽과 오른쪽으로 나누기 -->
<div class="container-content">
   <!-- 포스터 -->
    <div class="poster">
        <img src="https://www.bluer.co.kr${vo.poster}" alt="Poster">
    </div>

   <!-- 오른쪽 내용 영역 -->
   <div class="details">
      

      <!-- 이미지들 -->
        <div class="images">
            <c:set var="cleanImages" value="${fn:replace(vo.images, ' ', '')}" />
            <c:forTokens items="${cleanImages}" delims="," var="image">
                <figure>
                    <a href="https://www.bluer.co.kr/${image}" data-lightbox="image-gallery" data-title="Image description">
                        <img src="https://www.bluer.co.kr/${image}" alt="Image">
                    </a>
                </figure>
            </c:forTokens>
        </div>
    </div>

<!-- 태그 -->
            <div class="tags">
            <h3>
                <span style="color: green;">
                    <c:forTokens items="${vo.tag}" delims=" " var="tag">
                        #${fn:trim(tag)}<br>
                    </c:forTokens>
                </span>
            </h3>
        </div>
        
        
        </div>
      <!-- 나머지 정보 유지 -->
      <table class="table">
         <tr>
            <td class="text-right" style="color: gray" width="5%">${vo.name} 정보</td>
            <td></td>
         </tr>
         <tr>
            <td class="text-right" style="color: gray" width="5%">한줄평</td>
            <td>${vo.review}</td>
         </tr>
         <tr>
            <td class="text-right" style="color: gray" width="5%">업종</td>
            <td width="65%">${vo.theme}</td>
         </tr>
         <tr>
            <td class="text-right" style="color: gray" width="5%">시간</td>
            <td width="65%">${vo.time}</td>
         </tr>
         <tr>
            <td class="text-right" style="color: gray" width="15%">주메뉴</td>
            <td width="65%">${vo.menu}</td>
         </tr>
         <tr>
            <td class="text-right" style="color: gray" width="5%">전화</td>
            <td width="65%">${vo.phone}</td>
         </tr>
         <tr>
            <td class="text-right" style="color: gray" width="5%">주소</td>
            <td width="65%">${vo.address}</td>
         </tr>
         <tr>
            <td class="text-right" style="color: gray" width="5%">테마</td>
            <td width="65%">${vo.theme}</td>
         </tr>
         <tr>
            <td class="text-right" style="color: gray" width="15%">주차</td>
            <td width="65%">${vo.parking}</td>
         </tr>
      </table>
         <table class="table" style="width: 100%; text-align: right;">
            <tr>
               <td colspan="3" class="text-right">
               <c:if test="${sessionScope.id!=null }">
                     <a href="#" class="btn btn-xs btn-success">좋아요</a>
                     
                     <c:if test="${check==false }">
                        <input type=button class="btn btn-xs btn-success" value="찜하기"
                           id="jjimBtn" data-cno="${vo.fno }">
                     </c:if>
                     <c:if test="${check==true }">
                        <span class="btn btn-xs btn-default">찜하기</span>
                     </c:if>
                     <a href="../food/reserve_main.do?fno=${vo.fno }&type=1" class="btn btn-xs btn-success">예약하기
</a>
                  </c:if>
                  <input type="button" class="btn btn-xs btn-success" value="목록"onclick="javascript:history.back()">
                  </td>
               
            </tr>
            </table>
            
             
	
         <div style="height: 10px"></div>
         <div id="map" style="width: 100%; height: 350px;"></div>

         <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9965c727d3306713c47391be682e4be9&libraries=services"></script>
         <script>
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
          mapOption = {
              center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
              level: 3 // 지도의 확대 레벨
          };  
       
      // 지도를 생성합니다    
      var map = new kakao.maps.Map(mapContainer, mapOption); 
      
      // 주소-좌표 변환 객체를 생성합니다
      var geocoder = new kakao.maps.services.Geocoder();
      
      // 주소로 좌표를 검색합니다
      geocoder.addressSearch('${vo.address}', function(result, status) {
      
          // 정상적으로 검색이 완료됐으면 
           if (status === kakao.maps.services.Status.OK) {
      
              var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
      
              // 결과값으로 받은 위치를 마커로 표시합니다
              var marker = new kakao.maps.Marker({
                  map: map,
                  position: coords
              });
      
              // 인포윈도우로 장소에 대한 설명을 표시합니다
              var infowindow = new kakao.maps.InfoWindow({
                  content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.name}</div>'
              });
              infowindow.open(map, marker);
      
              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
              map.setCenter(coords);
          } 
      });    
      </script>
         <h2 class="sectiontitle" style="margin-top:50px;">댓글</h2>
         <table class="table" id="reply_table">
            <tbody>
               <tr>
                  <td id="reply"></td>
               </tr>
            </tbody>
         </table>
         <c:if test="${sessionScope.id!=null }">
            <table class="table">
               <tr>
                  <td><textarea rows="4" cols="100" id="msg"
                        style="float: left"></textarea> <input type=button value="댓글쓰기"
                     style="width: 100px; height: 85px; background-color: green; color: black"
                     id="writeBtn" data-fno="${vo.fno }"></td>
               </tr>
            </table>
         </c:if>
         <div style="height: 20px"></div>
         
         
         
         
         
      
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         <div class="container-fluid packages py-5">
         <div class="container py-5 ">
         
                <div class="mx-auto text-center mb-5" style="max-width: 900px;">
                    <h5 class="section-title px-3">Near FoodHouse</h5>
                    <h1 class="mb-0">인근 맛집</h1>
                </div>
      
            
         <div class="packages-carousel owl-carousel">
         
                        <c:forEach var="rvo" items="${rList }" varStatus="s">
                              <div class="packages-item">
                                 <div class="packages-img">
                                 
                                    <img src="https://www.bluer.co.kr${rvo.poster}"
                                       class="img-fluid w-10  rounded-top" alt="${rvo.name}" title="${rvo.address}">
                                       
                                    <div
                                       class="packages-info d-flex border border-start-0 border-end-0 position-absolute"
                                       style="width: 100%; bottom: 0; left: 0; z-index: 5;"><!-- 밑에 얇은줄 -->
                                       
                                    </div>
                                    <div class="text-center packages-price py-2 px-4">★${rvo.hit }</div> <!-- 매퍼에서 연결해야함~ -->
                                 </div>
                                 <div class="packages-content bg-light">
                                    <div class="p-4 pb-1"><!-- 회색박스 -->
                                    <a href="../food/detail_before.do?fno=${rvo.fno}&type=1">
                                       <h5 class="mb-0 text-center">${rvo.name}</h5>
                                       </a>
                                       <p class="mb-4"></p>
                                    </div>
                              </div>
                           </div>
                        </c:forEach>
                     </div>
                     </div>
                     </div>
         
         
         
         
      </main>
   </div>
</body>
</html>