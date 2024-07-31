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
	width:600px;
}
</style>
<script type="text/javascript">
/*
 * 	브라우저 자체에서 처리 : JavaScript
 
 	JavaScript : 사용자 이벤트 (사용자 선택, 마우스 클릭 ...)
 		=> on~ : 많이 사용하는 event
 			onclick : 버튼, 이미지 클릭 시 처리
 			onchange : select => 콤보 박스 => 선택이 변경된 경우
 			onmouseover : 이미지, text => 마우스 커서로 갔다 댔을 때
 			onmouseout
 			onkeyup / onkeydown
 */
let bCheck=false
function boardDelete(){
	if(bCheck==false)
	{
		let btn=document.querySelector("#delBtn")
		btn.value='취소'
		let tr=document.querySelector("#delTr")
		tr.style.display=''
		bCheck=true
	}
	else
	{
		let btn=document.querySelector("#delBtn")
		btn.value='삭제'
		let tr=document.querySelector("#delTr")
		tr.style.display='none'
		bCheck=false
	}
}
</script>
</head>
<body>
		<div class="container clear">
			<div class="row">
				<h3 class="text-center">내용 보기</h3>
				<table class="table">
					<tr>
						<th width="20%" class="text-center">번호</th>
						<td width="30%" class="text-center">${vo.no }</td>
						<th width="20%" class="text-center">작성일</th>
						<td width="30%" class="text-center">${vo.dbday }</td>
					</tr>
					<tr>
						<th width="20%" class="text-center">이름</th>
						<td width="30%" class="text-center">${vo.name }</td>
						<th width="20%" class="text-center">조회수</th>
						<td width="30%" class="text-center">${vo.hit }</td>
					</tr>
					<tr>
						<th width="20%" class="text-center">제목</th>
						<td colspan="3">${vo.subject }</td>
					</tr>
					<tr>
						<td colspan="4" class="text-left" valign="top" height="200">
<pre style="white-space:pre-wrap;background-color:white;border:none">
${vo.content }
</pre>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="text-right">
							<input type="button" class="btn btn-xs btn-info" value="수정">
							<input type="button" class="btn btn-xs btn-success" value="삭제"
								onclick="boardDelete()" id="delBtn">
							<a href="../board/list.do" class="btn btn-xs btn-danger">목록</a>
						</td>
					</tr>
					<tr id="delTr" style="display:none">
						<td colspan="4" class="text-right">
							비밀 번호 : <input type="password" id="pwd" size="15" class="input-sm">
							<input type="button" value="삭제" class="btn btn-sm btn-warning">
						</td>
					</tr>					
				</table>
			</div>
		</div>
	
</body>
</html>