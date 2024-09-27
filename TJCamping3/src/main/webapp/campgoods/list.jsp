<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600&family=Roboto&display=swap" rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="../lib/easing/easing.min.js"></script>
<script src="../lib/waypoints/waypoints.min.js"></script>
<script src="../lib/owlcarousel/owl.carousel.min.js"></script>
<script src="../lib/lightbox/js/lightbox.min.js"></script>
<script type="text/javascript"></script>

<style>
.bg-breadcrumb {
   background-image: url('campgoods_list.jpg');
   background-size: cover;
   background-position: center;
   margin-bottom: -20px; 
}
.packages-item {
   margin-bottom: 30px;
   max-width: 100%;
   overflow: hidden;
   border-radius: 10px;
   border: 1px solid rgba(211,211,211,0.5);
}
.packages-img {
   width: 100%;
   height: 300px;
   overflow: hidden;
   border-top-left-radius: 10px;
   border-top-right-radius: 10px;
}
.packages-img img {
   width: 100%;
   height: 100%;
   object-fit: cover;
   display: block;
   margin: 0 auto;
}
.packages-content h5 {
   white-space: nowrap;
   overflow: hidden;
   text-overflow: ellipsis;
   text-align: center;
   font-size: 14px;
}
.packages-price {
   font-size: 16px;
   font-weight: bold;
}
.packages-content {
   padding: 5px;
   background-color: rgba(211,211,211,0.1) !important;
}
.pagination {
   display: flex;
   justify-content: center;
   padding: 20px 0;
}
.pagination ul {
   list-style: none;
   padding: 0;
   display: flex;
   margin-bottom: 20px;
}
.pagination li {
   margin: 0 5px;
}
.pagination a {
   text-decoration: none;
   padding: 7px 12px; 
   color: rgb(37, 103, 75);
   border: 1px solid rgb(37, 103, 75);
   border-radius: 5px;
   background-color: #f1f1f1;
   transition: background-color 0.3s, color 0.3s;
   font-size: 14px; 
}
.pagination a:hover {
   background-color: #ddd;
   color: rgb(37, 103, 75);
}
.pagination .current a {
   background-color: rgb(37, 103, 75);
   color: #ffffff;
}
.tab-content {
    margin-top: 20px;
}
.shadowed-text {
   color: white; /* 텍스트 색상 */
   text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7); /* 그림자 설정 */
   font-size: 50px !important;
}

</style>
</head>
<body>
<!-- Header Start -->
<div class="container-fluid bg-breadcrumb">
   <div class="container text-center py-5" style="max-width: 900px;">
      <h3 class="text-white display-3 mb-4 shadowed-text">${title}</h3>
      <ol class="breadcrumb justify-content-center mb-0"></ol>
   </div>
</div>
<!-- Header End -->

   <div class="container-fluid packages py-5">
      <div class="container py-5">
         <!--  <div class="mx-auto text-center mb-5" style="max-width: 900px;">
            <h3 class="section-title px-3" style="color: black;">${title }</h3>
         </div>-->

         <div class="tab-class text-center">
            <ul class="nav nav-pills d-inline-flex justify-content-center mb-5">
            <li class="nav-item">
                  <a class="d-flex mx-3 py-2 border border-primary bg-light rounded-pill active" data-bs-toggle="pill" href="#tab-1">
                     <span class="text-dark" style="width: 120px;">전체</span>
                  </a>
               </li>
               <li class="nav-item">
                  <a class="d-flex mx-3 py-2 border border-primary bg-light rounded-pill" data-bs-toggle="pill" href="#tab-2">
                     <span class="text-dark" style="width: 120px;">에어매트</span>
                  </a>
               </li>
               <li class="nav-item">
                  <a class="d-flex mx-3 py-2 border border-primary bg-light rounded-pill" data-bs-toggle="pill" href="#tab-3">
                     <span class="text-dark" style="width: 120px;">텐트</span>
                  </a>
               </li>
               <li class="nav-item">
                  <a class="d-flex mx-3 py-2 border border-primary bg-light rounded-pill" data-bs-toggle="pill" href="#tab-4">
                     <span class="text-dark" style="width: 120px;">등산용품</span>
                  </a>
               </li>
               <li class="nav-item">
                  <a class="d-flex mx-3 py-2 border border-primary bg-light rounded-pill" data-bs-toggle="pill" href="#tab-5">
                     <span class="text-dark" style="width: 120px;">의자</span>
                  </a>
               </li>
               <li class="nav-item">
                  <a class="d-flex mx-3 py-2 border border-primary bg-light rounded-pill" data-bs-toggle="pill" href="#tab-6">
                     <span class="text-dark" style="width: 120px;">바베큐</span>
                  </a>
               </li>
               <li class="nav-item">
                  <a class="d-flex mx-3 py-2 border border-primary bg-light rounded-pill" data-bs-toggle="pill" href="#tab-7">
                     <span class="text-dark" style="width: 120px;">랜턴</span>
                  </a>
               </li>
            </ul>
          </div>
         
       <div class="tab-content">
         <div id="tab-1" class="tab-pane fade show p-0 active">
	         <div class="row">
	            <c:forEach var="vo" items="${gList }" varStatus="s">
	               <div class="col-lg-3 col-md-6 col-sm-12">
	                  <div class="packages-item">
	                     <a href="../campgoods/detail_before.do?cno=${vo.cno}&gno=${gno}&type=2" class="text-decoration-none">
	                        <div class="packages-img">
	                           <img src="${vo.poster}" class="img-fluid w-100 rounded-top" title="${vo.name}">
	                        </div>
	                     </a>
	                     <div class="packages-content bg-light">
	                        <div class="p-4 pb-0">
	                           <h5 class="mb-0 text-center small-title">${vo.name}</h5>
	                           <div class="text-center packages-price py-2 px-4">
	                              <span>${vo.price}</span>
	                           </div>
	                        </div>
	                     </div>
	                  </div>
	               </div>
	            </c:forEach>
	         </div>
         </div>
         <div id="tab-2" class="tab-pane fade p-0">
           <div class="row">
            <c:forEach var="vo" items="${amList }" varStatus="s">
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="packages-item">
                     <a href="../campgoods/detail_before.do?cno=${vo.cno}&gno=${gno}&type=2" class="text-decoration-none">
                        <div class="packages-img">
                           <img src="${vo.poster}" class="img-fluid w-100 rounded-top" title="${vo.name}">
                        </div>
                     </a>
                     <div class="packages-content bg-light">
                        <div class="p-4 pb-0">
                           <h5 class="mb-0 text-center small-title">${vo.name}</h5>
                           <div class="text-center packages-price py-2 px-4">
                              <span>${vo.price}</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </c:forEach>
           </div>
           </div>
           <div id="tab-3" class="tab-pane fade p-0">
           <div class="row">
            <c:forEach var="vo" items="${ttList }" varStatus="s">
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="packages-item">
                     <a href="../campgoods/detail_before.do?cno=${vo.cno}&gno=${gno}&type=2" class="text-decoration-none">
                        <div class="packages-img">
                           <img src="${vo.poster}" class="img-fluid w-100 rounded-top" title="${vo.name}">
                        </div>
                     </a>
                     <div class="packages-content bg-light">
                        <div class="p-4 pb-0">
                           <h5 class="mb-0 text-center small-title">${vo.name}</h5>
                           <div class="text-center packages-price py-2 px-4">
                              <span>${vo.price}</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </c:forEach>
           </div>
           </div>
           <div id="tab-4" class="tab-pane fade p-0">
           <div class="row">
            <c:forEach var="vo" items="${cgList }" varStatus="s">
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="packages-item">
                     <a href="../campgoods/detail_before.do?cno=${vo.cno}&gno=${gno}&type=2" class="text-decoration-none">
                        <div class="packages-img">
                           <img src="${vo.poster}" class="img-fluid w-100 rounded-top" title="${vo.name}">
                        </div>
                     </a>
                     <div class="packages-content bg-light">
                        <div class="p-4 pb-0">
                           <h5 class="mb-0 text-center small-title">${vo.name}</h5>
                           <div class="text-center packages-price py-2 px-4">
                              <span>${vo.price}</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </c:forEach>
           </div>
           </div>
           <div id="tab-5" class="tab-pane fade show p-0">
           <div class="row">
            <c:forEach var="vo" items="${crList }" varStatus="s">
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="packages-item">
                     <a href="../campgoods/detail_before.do?cno=${vo.cno}&gno=${gno}&type=2" class="text-decoration-none">
                        <div class="packages-img">
                           <img src="${vo.poster}" class="img-fluid w-100 rounded-top" title="${vo.name}">
                        </div>
                     </a>
                     <div class="packages-content bg-light">
                        <div class="p-4 pb-0">
                           <h5 class="mb-0 text-center small-title">${vo.name}</h5>
                           <div class="text-center packages-price py-2 px-4">
                              <span>${vo.price}</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </c:forEach>
           </div>
           </div>
           <div id="tab-6" class="tab-pane fade p-0">
            <div class="row">
            <c:forEach var="vo" items="${bbList }" varStatus="s">
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="packages-item">
                     <a href="../campgoods/detail_before.do?cno=${vo.cno}&gno=${gno}&type=2" class="text-decoration-none">
                        <div class="packages-img">
                           <img src="${vo.poster}" class="img-fluid w-100 rounded-top" title="${vo.name}">
                        </div>
                     </a>
                     <div class="packages-content bg-light">
                        <div class="p-4 pb-0">
                           <h5 class="mb-0 text-center small-title">${vo.name}</h5>
                           <div class="text-center packages-price py-2 px-4">
                              <span>${vo.price}</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </c:forEach>
           </div>
           </div>
           <div id="tab-7" class="tab-pane fade p-0">
           <div class="row">
            <c:forEach var="vo" items="${ltList }" varStatus="s">
               <div class="col-lg-3 col-md-6 col-sm-12">
                  <div class="packages-item">
                     <a href="../campgoods/detail_before.do?cno=${vo.cno}&gno=${gno}&type=2" class="text-decoration-none">
                        <div class="packages-img">
                           <img src="${vo.poster}" class="img-fluid w-100 rounded-top" title="${vo.name}">
                        </div>
                     </a>
                     <div class="packages-content bg-light">
                        <div class="p-4 pb-0">
                           <h5 class="mb-0 text-center small-title">${vo.name}</h5>
                           <div class="text-center packages-price py-2 px-4">
                              <span>${vo.price}</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
              </c:forEach>
            </div>
            </div>
          </div>
        </div>
		
<%-- 		<p>amList Size: ${fn:length(amList)}</p>
        <p>ttList Size: ${fn:length(ttList)}</p>
        <p>cgList Size: ${fn:length(cgList)}</p>
        <p>crList Size: ${fn:length(crList)}</p>
        <p>bbList Size: ${fn:length(bbList)}</p>
        <p>ltList Size: ${fn:length(ltList)}</p> --%>
	
      <nav class="pagination">
         <ul>
            <c:if test="${startPage>1 }">
               <li><a href="../campgoods/list.do?page=${startPage-1 }&gno=${gno}">&laquo;</a></li>
            </c:if>
            <c:forEach var="i" begin="${startPage }" end="${endPage }">
               <li ${i==curpage?"class=current":"" }><a href="../campgoods/list.do?page=${i }&gno=${gno}">${i }</a></li>
            </c:forEach>
            <c:if test="${endPage<totalpage }">
               <li><a href="../campgoods/list.do?page=${endPage+1 }&gno=${gno}">&raquo;</a></li>
            </c:if>
         </ul>
      </nav>
   </div>
</body>
</html>