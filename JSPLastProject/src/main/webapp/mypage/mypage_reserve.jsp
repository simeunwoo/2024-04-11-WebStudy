<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.resRow{
  width: 800px
}
</style>
</head>
<body>
<div class="wrapper row3">
 	<main class="container clear">
		<div class="row resRow">
			<table class="table">
				<tr>
					<th class="text-center">번호</th>
					<th class="text-center"></th>
					<th class="text-center">업체명</th>
					<th class="text-center">예약일</th>
					<th class="text-center">시간</th>
					<th class="text-center">인원</th>
					<th class="text-center">상태</th>
				</tr>
				<c:forEach var="vo" items="${recvList }">
					<tr>
						<td class="text-center">${vo.rno }</td>
						<td class="text-center">
							<img src="http://www.menupan.com${vo.fvo.poster }" style="width:20px;height:20px">
						</td>
						<td>${vo.fvo.name }</td>
						<td class="text-center">${vo.day }</td>
						<td class="text-center">${vo.time }</td>
						<td class="text-center">${vo.inwon }</td>
						<td class="text-center inline">
							<c:if test="${vo.isok=='y' }">
								<span class="btn btn-success btn-xs">예약완료</span>
							</c:if>
							<c:if test="${vo.isok=='n' }">
								<span class="btn btn-default btn-xs">예약대기</span>
							</c:if>
							<a href="../mypage/mypage_reserve_cancel.do?rno=${vo.rno }" class="btn-xs btn-danger">취소</a>
						</td>	
					</tr>
				</c:forEach>
			</table>
		</div>
	</main>
</div>
</body>
</html>