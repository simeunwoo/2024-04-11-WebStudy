<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.14.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://code.jquery.com/ui/1.14.0/jquery-ui.js"></script>
<script>
$(function(){
	$("#tabs").tabs()
	$('#emailBtn').click(function(){
		let name=$('#e_name').val()
		if(name.trim()==="")
		{
			$('#e_name').focus()
			$('#result_email').html('<font color="red">이름을 입력하세요</font>')
			return
		}
		let email=$('#email').val()
		if(email.trim()==="")
		{
			$('#email').focus()
			$('#result_email').html('<font color="red">이메일을 입력하세요</font>')
			return
		}
		$.ajax({
			type:'post',
			url:'../member/idcheck_ok.do',
			data:{"name":name,"email":email},
			success:function(result)
			{
				if(result==='no')
				{
					$('#result_email').html('<h3><font color="red">이름이나 이메일이 존재하지 않습니다</font></h3>')
					$('#e_name').val("")
					$('#email').val("")
					$('#e_name').focus()
				}
				else
				{
					$('#result_email').html('<h3><font color="blue">'+result+'</font></h3>')
				}
			},
			error:function(request,status,error)
			{
				console.log(error)
			}
		})
	})
})
</script>
<style type="text/css">
#tabs{
	width: 600px;
}
</style>
</head>
<body>
	<div class="wrapper row3">
		<main class="container clear">
			<h2 class="sectiontitle">회원 가입</h2>
			<div id="tabs">
			  <ul>
			    <li><a href="#tabs-1">이메일로 찾기</a></li>
			    <li><a href="#tabs-2">전화번호로 찾기</a></li>
			  </ul>
			  <div id="tabs-1">
			  	<table class="table">
			  		<tr>
			  			<td width="20%">이름 : </td>
			  			<td width="80">
			  				<input type="text" class="input-sm" name="name" size="25" id="e_name">
			  			</td>
			  		</tr>
			  		<tr>
			  			<td width="20%">이메일 : </td>
			  			<td width="80">
			  				<input type="text" class="input-sm" name="email" size="25" id="email">
			  			</td>
			  		</tr>
			  		<tr>
			  			<td class="text-center" colspan="2">
			  				<input type="button" class="btn-sm btn-primary" value="검색" id="emailBtn">
			  			</td>
			  		</tr>
			  		<tr>
			  			<td class="text-center" colspan="2">
			  				<span id="result_email"></span>
			  			</td>
			  		</tr>			  		
			  	</table>
			  </div>
			  <div id="tabs-2">
			  	<table class="table">
			  		<tr>
			  			<td width="20%">이름 : </td>
			  			<td width="80">
			  				<input type="text" class="input-sm" name="name" size="25" id="p_name">
			  			</td>
			  		</tr>
			  		<tr>
			  			<td width="20%">전화번호 : </td>
			  			<td width="80">
			  				<input type="text" class="input-sm" name="phone" size="25" id="phone">
			  			</td>
			  		</tr>
			  		<tr>
			  			<td class="text-center" colspan="2">
			  				<input type="button" class="btn-sm btn-primary" value="검색" id="phoneBtn">
			  			</td>
			  		</tr>
			  		<tr>
			  			<td class="text-center" colspan="2">
			  				<span id="result_phone"></span>
			  			</td>
			  		</tr>			  		
			  	</table>
			  </div>
			</div>
		</main>
	</div>
</body>
</html>