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

</script>
</head>
<body>
<div class="container-fluid ExploreTour py-5">
            <div class="container py-5">
                <div class="mx-auto text-center mb-5" style="max-width: 900px;">
                    <h5 class="section-title px-3">Explore Tour</h5>
                    <h1 class="mb-4">The World</h1>
                    <p class="mb-0">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum tempore nam, architecto doloremque velit explicabo? Voluptate sunt eveniet fuga eligendi! Expedita laudantium fugiat corrupti eum cum repellat a laborum quasi.
                    </p>
                </div>
                <div class="tab-class text-center">
                    <ul class="nav nav-pills d-inline-flex justify-content-center mb-5">
                        <li class="nav-item">
                            <a class="d-flex mx-3 py-2 border border-primary bg-light rounded-pill active" data-bs-toggle="pill" href="#NationalTab-1">
                                <span class="text-dark" style="width: 250px;">National Tour Category</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="d-flex py-2 mx-3 border border-primary bg-light rounded-pill" data-bs-toggle="pill" href="#InternationalTab-2">
                                <span class="text-dark" style="width: 250px;">International tour Category</span>
                            </a>
                        </li>
                    </ul>
  					<div class="tab-content">
                        <div id="NationalTab-1" class="tab-pane fade show p-0 active">
                            <div class="row g-4">
                                <div class="col-md-6 col-lg-4">
                                    <div class="national-item">
                                        <img src="img/explore-tour-1.jpg" class="img-fluid w-100 rounded" alt="Image">
                                        <div class="national-content">
                                            <div class="national-info">
                                                <h5 class="text-white text-uppercase mb-2">Weekend Tour</h5>
                                                <a href="#" class="btn-hover text-white">View All Place <i class="fa fa-arrow-right ms-2"></i></a>
                                            </div>
                                        </div>
                                        <div class="national-plus-icon">
                                            <a href="#" class="my-auto"><i class="fas fa-link fa-2x text-white"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <div class="national-item">
                                        <img src="img/explore-tour-2.jpg" class="img-fluid w-100 rounded" alt="Image">
                                        <div class="national-content">
                                            <div class="national-info">
                                                <h5 class="text-white text-uppercase mb-2">Holiday Tour</h5>
                                                <a href="#" class="btn-hover text-white">View All Place <i class="fa fa-arrow-right ms-2"></i></a>
                                            </div>
                                        </div>
                                        <div class="national-plus-icon">
                                            <a href="#" class="my-auto"><i class="fas fa-link fa-2x text-white"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <div class="national-item">
                                        <img src="img/explore-tour-3.jpg" class="img-fluid w-100 rounded" alt="Image">
                                        <div class="national-content">
                                            <div class="national-info">
                                                <h5 class="text-white text-uppercase mb-2">Road Trip</h5>
                                                <a href="#" class="btn-hover text-white">View All Place <i class="fa fa-arrow-right ms-2"></i></a>
                                            </div>
                                        </div>
                                        <div class="tour-offer bg-info">15% Off</div>
                                        <div class="national-plus-icon">
                                            <a href="#" class="my-auto"><i class="fas fa-link fa-2x text-white"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <div class="national-item">
                                        <img src="img/explore-tour-4.jpg" class="img-fluid w-100 rounded" alt="Image">
                                        <div class="national-content">
                                            <div class="national-info">
                                                <h5 class="text-white text-uppercase mb-2">Historical Trip</h5>
                                                <a href="#" class="btn-hover text-white">View All Place <i class="fa fa-arrow-right ms-2"></i></a>
                                            </div>
                                        </div>
                                        <div class="national-plus-icon">
                                            <a href="#" class="my-auto"><i class="fas fa-link fa-2x text-white"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <div class="national-item">
                                        <img src="img/explore-tour-5.jpg" class="img-fluid w-100 rounded" alt="Image">
                                        <div class="national-content">
                                            <div class="national-info">
                                                <h5 class="text-white text-uppercase mb-2">Family Tour</h5>
                                                <a href="#" class="btn-hover text-white">View All Place <i class="fa fa-arrow-right ms-2"></i></a>
                                            </div>
                                        </div>
                                        <div class="tour-offer bg-warning">50% Off</div>
                                        <div class="national-plus-icon">
                                            <a href="#" class="my-auto"><i class="fas fa-link fa-2x text-white"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-4">
                                    <div class="national-item">
                                        <img src="img/explore-tour-6.jpg" class="img-fluid w-100 rounded" alt="Image">
                                        <div class="national-content">
                                            <div class="national-info">
                                                <h5 class="text-white text-uppercase mb-2">Beach Tour</h5>
                                                <a href="#" class="btn-hover text-white">View All Place <i class="fa fa-arrow-right ms-2"></i></a>
                                            </div>
                                        </div>
                                        <div class="national-plus-icon">
                                            <a href="#" class="my-auto"><i class="fas fa-link fa-2x text-white"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
<!--
  <main class="container clear"> 
    <div class="content"> 
      <div id="gallery">
        <figure>
          <header class="heading">캠핑장 목록</header>
          <ul class="nospace clear">
          <c:forEach var="vo" items="${list }" varStatus="s">
			<li class="one_quarter ${s.index%4==0?'first':'' }">
				<a href="../camp/detail.do?camp_no=${vo.camp_no }">
					<img src="${vo.camp_poster }" title="${vo.camp_name }">
				</a>
			</li>
          </c:forEach>
          </ul>
        </figure>
      </div>
      <nav class="pagination">
        <ul>
        <c:if test="${startPage>1 }">
          <li><a href="../camp/list.do?page=${startPage-1 }">&laquo; Previous</a></li>
        </c:if>
        <c:forEach var="i" begin="${startPage }" end="${endPage }">
          <li ${curpage==i?"class=current":"" }><a href="../camp/list.do?page=${i }">${i }</a></li>
        </c:forEach>
        <c:if test="${endPage<totalpage }">
          <li><a href="../camp/list.do?page=${endPage+1 }">Next &raquo;</a></li>
        </c:if>
        </ul>
      </nav>
    </div>
    <div class="clear"></div>
  </main>  -->
  </div>
  </div>
  </div>
</div>
</body>
</html>