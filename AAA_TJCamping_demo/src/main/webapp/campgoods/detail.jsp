<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Product Detail - Travela</title>
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
<script type="text/javascript">
$(function(){
$('#jjimBtn').on('click', function() {
    let cno = $(this).attr("data-cno")
    $.ajax({
        type: 'post',
        url: '../all_jjim/cinsert.do',
        data: { "cno": cno, "type": 2 },
        success: function(result) {
            if (result === 'OK') {
                $(this).attr("data-count",1);
                $(this).attr("class",'btn-xs btn-default')
                location.href = "../campgoods/detail.do?cno=" + cno + "&gno="+gno+"&type=2";
            } else {
                alert(result);
            }
        },
        error: function(request, status, error) {
            console.log(error);
        }
    })
})
})
</script>
<style>
.bg-breadcrumb {
    position: relative;
    background-image: url('white.jpg');
    background-size: cover;
    background-position: center;
}
.bg-breadcrumb::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 49%;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 1;
}
.btn-custom {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 25px;
    padding: 10px 20px;
    font-size: 16px;
    transition: background-color 0.3s, transform 0.3s;
}
.btn-custom:hover {
    background-color: #0056b3;
    transform: scale(1.05);
}
.btn-custom:active {
    background-color: #004080;
    transform: scale(1);
}
.btn-group {
    margin-right: 10px;
}
.section-image-container {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}
.section-image-container img {
    max-width: 80%;
    height: auto;
    margin-top: 70px;
    margin-bottom: 70px;
}
.product-image-container {
    text-align: center;
    margin-bottom: 20px;
}
.poster-img {
    border: 2px solid #d3d3d3;
    border-radius: 8px;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
    max-width: 100%;
    height: auto;
}
.product-info-container {
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
.product-name {
    font-size: 24px;
    margin-bottom: 20px;
}
.product-info {
    font-size: 16px;
    color: #333;
}
.table th {
    font-weight: bold;
}
.table td {
    padding: 8px 0;
}
.btn-custom {
    padding: 10px 20px;
    font-size: 16px;
    border-radius: 25px;
    transition: background-color 0.3s, transform 0.3s;
}
.btn-cart {
    background-color: rgb(37, 103, 75);
    color: #fff;
}
.btn-cart:hover {
    background-color: rgb(30, 83, 60);
}
.btn-wishlist {
    background-color: rgb(37, 103, 75);
    color: #fff;
}
.btn-wishlist:hover {
    background-color: rgb(30, 83, 60);
}
.btn-buy {
    background-color: rgb(37, 103, 75);
    color: #fff;
}
.btn-buy:hover {
    background-color: rgb(30, 83, 60);
}
.btn-back {
    background-color: rgb(37, 103, 75);
    color: #fff;
}
.btn-back:hover {
    background-color: rgb(30, 83, 60);
}
</style>
</head>
<body>
<!-- Header Start -->
<div class="container-fluid bg-breadcrumb">
    <div class="container text-center" style="max-width: 900px;">
        <ol class="breadcrumb justify-content-center mb-0"></ol>
    </div>
</div>
<!-- Header End -->
<!-- Product Details Start -->
<div class="container product-details mt-5">
    <main class="row">
        <!-- Main Product Image and Details -->
        <div class="col-md-6">
            <div class="product-image-container">
                <img src="${vo.poster}" alt="${vo.name}" class="img-fluid poster-img">
            </div>
        </div>
        <div class="col-md-6">
            <div class="product-info-container">
                <h3 class="product-name">${vo.name}</h3>
                <table class="table table-borderless product-info">
                    <tbody>
                        <tr>
                            <th class="text-right">제조사</th>
                            <td>${vo.brand}</td>
                        </tr>
                        <tr>
                            <th class="text-right">제조국</th>
                            <td>${vo.origin}</td>
                        </tr>
                        <tr>
                            <th class="text-right">소비자가</th>
                            <td class="text-decoration-line-through">${vo.saleprice}</td>
                        </tr>
                        <tr>
                            <th class="text-right">판매가</th>
                            <td class="text-primary fw-bold">${vo.price}</td>
                        </tr>
                        <tr>
                            <th class="text-right">배송비</th>
                            <td>${vo.delivery}</td>
                        </tr>
                    </tbody>
                </table>
                <div class="d-flex flex-wrap justify-content-start mt-3">
                    <c:if test="${sessionScope.id != null}">
                        <a href="#" class="btn btn-cart btn-custom mx-2 mb-2">장바구니</a>
                        <c:if test="${check == false}">
                            <input type="button" class="btn btn-wishlist btn-custom mx-2 mb-2" value="찜하기" id="jjimBtn" data-cno="${vo.cno}">
                        </c:if>
                        <c:if test="${check == true}">
                            <span class="btn btn-wishlist btn-custom mx-2 mb-2">찜하기</span>
                        </c:if>
                        <a href="#" class="btn btn-buy btn-custom mx-2 mb-2">구매하기</a>
                    </c:if>
                    <input type="button" class="btn btn-back btn-custom mx-2 mb-2" value="목록" onclick="javascript:history.back()">
                </div>
            </div>
        </div>
    </main>
</div>
<!-- Additional Product Images -->
<section class="mt-4">
    <h5></h5>
    <div class="section-image-container">
        <img src="${vo.detail_poster}" alt="Detailed View" class="img-fluid">
    </div>
</section>
<!-- Product Details End -->
</body>
</html>
