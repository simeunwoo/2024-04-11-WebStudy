<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top:50px;
}
.row{
	margin:0px auto;
	width:960px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('input[type="button"]').click(function(){
		// 보안 => html 읽기 / JSON 읽기
		// responseText(HTML), responseXML(JSON)
		// ajax
		// async : 비동기적, javascript and xml => web2.0
		// 서버 요청과 응답을 동시에 처리 => 여러개 동작을 동시에 처리 가능
		// Front-End : Ajax
		// => Vue web3.0 => Model => 데이터만 전송 => void
		$.ajax({
			type:'get',
			url:'sawon.jsp', // 실행된 결과를 읽어 온다 => HTML/JSON
			success:function(result) // 정상 수행
			{
				alert(result)
				$('#print').html(result) // 반드시 출력 위치를 설정
			}
		})
		// jsp가 변경되지 않는다 => ex) 로그인, 회원 가입, 댓글, 검색, 수정, 삭제
		// ajax => axios 변경 (ajax 포함) => 검색창 / 지도(크기)
		/*
			$.ajax({
				type, => 전송 방식 : GET/POST
				url, => 요청 파일 : .do
				data, => 요청 데이터 : {"키":값,"키":값...}
				success:function(결과값=Callback)
				{
					// 정상 수행 시에 처리되는 문장
					// 실행된 HTML
					// 전송된 JSON
				},
				error:function(e)
				{
					// exception
					// 오류 발생 시에 처리되는 문장
				}
			})
		*/
	})
})
</script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">사원 목록</h3>
		<div class="row">
			<input type="button" value="사원 읽기" class="btn-sm btn-primary">
		</div>
		<div style="height:10px"></div>
		<div class="row" id="print">
		
		</div>
	</div>
</body>
</html>