<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
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
<body>
<div class="wrapper row3">
  <main class="container clear">
   <h2 class="sectiontitle">캠핑장 예약</h2>
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
</body>
</html>