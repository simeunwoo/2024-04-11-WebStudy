<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

$(function(){
	$('#logBtn').on('click',function(){
		let id=$('#id').val()
		if(id.trim()==="")
		{
			$('#id').focus
			return
		}
		let pwd=$('#pwd').val()
		if(pwd.trim()==="")
		{
			$('#pwd').focus
			return
		}
		
		$.ajax({
			type:'post',
			url:'../member/login.do',
			data:{"id":id,"pwd":pwd}, // ex) ?id=aaa&pwd=1234
			success:function(result)
			{
				// 정상 수행 => status : 200
				// NOID / NOPWD / OK
				if(result=='NOID')
				{
					alert("존재하지 않는 아이디입니다")
					$('#id').val("")
					$('#pwd').val("")
					$('#id').focus()
				}
				else if(result=='NOPWD')
				{
					alert("존재하지 않는 비밀 번호입니다")
					$('#pwd').val("")
					$('#pwd').focus()
				}
				else
				{
					location.href="../main/main.do"
				}
			},
			error:function(request,status,error)
			{
				// 오류 발생
				console.log("code : "+request.status)
				console.log("message : "+request.responseText)
				console.log("error : "+error) // 404, 500 ...
			}
		})
	})
	$('#logoutBtn').click(function(){
		$.ajax({
			type:'post',
			url:'../member/logout.do',
			success:function(result)
			{
				location.href="../main/main.do"
			},
			error:function(request,status,error)
			{
				console.log("code : "+request.status)
				console.log("message : "+request.responseText)
				console.log("error : "+error)
			}
		})
	})
})
function ok(zip,addr){
	opener.frm.post.value=zip
	opener.frm.address.value=addr
	self.close()

<td><a href="javascript:ok('${vo.zipcode }','${vo.address }')">${vo.address}</a></td>
window.onload=()=>{
	let btn=document.querySelector("button")
	btn.addEventListener('click',()=>{
		window.open('js_7.jsp','winname','width=500,height=700,scrollbars=yes')
	})
}
</script>
</head>
<body>

</body>
</html>