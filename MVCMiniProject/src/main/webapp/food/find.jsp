<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../food/food.css">
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div id="a">
    	<img src="../food/map/1111.png" id="seoul_1">
    	<c:forEach var="i" begin="1" end="25">
    		<a href="../food/find.do?gu=${i }">
	    		<img id="gu${i }" src="../food/map/gu_${i }_off.png"
	    		onmouseover="this.src='../food/map/gu_${i }_on.png'"
	    		onmouseout="this.src='../food/map/gu_${i }_off.png'">
    		</a>
    	</c:forEach>
    </div>
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">
          	<form method="post" action="../food/find.do" class="inline">
				<input type="text" name="fd" size="20" class="input-sm">
				<input type="submit" value="검색" class="btn-sm btn-primary">
			</form>
		  </header>
          <ul class="nospace clear">
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter first"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
            <li class="one_quarter"><a href="#"><img src="../images/demo/gallery/gallery.gif" alt=""></a></li>
          </ul>
          <figcaption>Gallery Description Goes Here</figcaption>
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
          <li><a href="#">&laquo; Previous</a></li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><strong>&hellip;</strong></li>
          <li><a href="#">6</a></li>
          <li class="current"><strong>7</strong></li>
          <li><a href="#">8</a></li>
          <li><a href="#">9</a></li>
          <li><strong>&hellip;</strong></li>
          <li><a href="#">14</a></li>
          <li><a href="#">15</a></li>
          <li><a href="#">Next &raquo;</a></li>
        </ul>
      </nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>