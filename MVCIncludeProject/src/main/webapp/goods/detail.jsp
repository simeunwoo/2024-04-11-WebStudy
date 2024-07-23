<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ----------------------- 미 완 성 ----------------------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
    <div class="col-sm-8">
      <table class="table">
       <tr>
         <td width="30%" class="text-center" rowspan="3">
          <img src="${vo.poster }" style="width: 100%">
         </td>
         <td colspan="2"><h3>${vo.name }</h3>
         <input type="hidden" name="no" value="${vo.no }">
          <sub style="color:gray">${vo.sub }</sub>
         </td>
       </tr>
       <tr>
         <th class="text-center" width="15%">가격</th>
         <td width="55%">${vo.price }</td>
       </tr>
      </table>
      <table class="table">
        <tr>
          <td class="text-right">
            <a href="#" class="btn btn-xs btn-info">찜하기</a>
            <a href="#" class="btn btn-xs btn-success">좋아요</a>
            <a href="#" class="btn btn-xs btn-warning">예약</a>
            <a href="list.do" class="btn btn-xs btn-primary">목록</a>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>