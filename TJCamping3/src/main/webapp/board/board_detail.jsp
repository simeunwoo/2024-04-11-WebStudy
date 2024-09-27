<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600&family=Roboto&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
<style type="text/css">
.row1{margin: 0px auto; width: 1080px;}

.bg-breadcrumb{background: url(../img/subscribe-img.jpg)}	/* toolbar 배경 이미지 */
.boardtitlecolor{}		/* board 메뉴 색상 */
.boardcheckbox{color: yellow;}	/* checkbox 글자 색상 */
a.pagetagcolor{color: yellow; background: ;}
.boardlistsytle{ text-align: center;}
nav{float: right;}
.gaechulist{width:100px; height:20px; margin: 0px auto;}
.shadowed-text {
   color: white; /* 텍스트 색상 */
   text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7); /* 그림자 설정 */
   font-size: 50px !important;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

let bCheck=true; // 전역변수 
$(function(){ 
	 $('#delBtn').click(function(){
		 if(bCheck===true)
		 {
			 $('#delBtn').text("취소")
			 $('#delTr').show() // display:none , display:''
			 bCheck=false
		 }
		 else
		 {
			 $('#delBtn').text("삭제")
			 $('#delTr').hide() // display:none , display:''
			 bCheck=true
		 }
	 })
	 $('#deleteBtn').on('click',function(){
		 let no=$('.del_no').text()
		 let pwd=$('#del_pwd').val()
		 if(pwd.trim()==="")
		 {
			 $('#del_pwd').focus()
			 return
		 }
		 console.log("no="+no+",pwd="+pwd)
		 $.ajax({
			type:'post',
			url:'../board/delete.do',
			data:{"no":no,"pwd":pwd},
			success:function(result)
			{
				// yes/no
				if(result==='yes')
				{
					// 이동 
					location.href="../boardcamp/list.do"
				}
				else
				{
				   alert("비밀번호가 틀립니다!!")
				   $('#del_pwd').val("")
				   $('#del_pwd').focus()
				}
			},
			error:function(request,status,error)
			{
				console.log(error)
			}
		 })
	 })

	 // 댓글 읽기
	 let bno=$('.del_no').text()
	 replyList(bno)
	 // 댓글 쓰기
	 $('#writeBtn').click(function(){
		 //alert("Call...")
		 let msg=$('#msg').val()
		 console.log(msg)
		 let bno=$('.del_no').text()
		 console.log(bno)
		 if(msg.trim()==="")
		 {
			 $('#msg').focus()
			 return
		 }
		 $.ajax({
			 type:'post',
			 url:'../boardreply/boardreply_insert.do',
			 data:{"bno":bno,"msg":msg},
			 success:function(result)
			 {
				 let res=result
				 console.log(res)
				 if(res==='OK')
				 {
					 replyList(bno)
				 }
				 $('#msg').val("")
			 },
			 error:function(request,status,error)
			 {
				 console.log(error)
			 }
		 })
	 }) 		
 })
 
 // 댓글 수정 	
 let u=0;
 function replyUpdate(rno)
 {
	  $('.updates').hide()
	  $('#m'+rno).show()
 }
 function replyDelete(rno,bno)
 {
	 $.ajax({
		 type:'post',
		 url:'../boardreply/boardreply_delete.do',
		 data:{"rno":rno},
		 success:function(result)
		 {
			 if(result==='OK')
			 {
				 replyList(bno)
			 }
		 },
		 error:function(request,status,error)
		 {
			 console.log(error)
		 }
	 })
 }
 function replyUpdataData(rno)
 {
	  let msg=$('#msg'+rno).val()
	  //alert(rno+"."+msg)
	  $.ajax({
		  type:'post',
		  url:'../boardreply/boardreply_update.do',
		  data:{"rno":rno,"msg":msg},
		  success:function(result)
		  {
			  if(result==='OK')
			  {
				  let bno=$('.del_no').text()
				  replyList(bno)
			  }
			  $('#m'+rno).hide()
		  },
		  error:function(request,status,error)
		  {
				 console.log(error)
		  }
	  })
 }
 function replyList(bno)
 {
	 $.ajax({
		 type:'post',
		 url:'../boardreply/boardreply_list.do',
		 data:{"bno":bno},
		 success:function(json)
		 {
			 let html=''
			 json=JSON.parse(json)

			 
			 json.map(function(reply){
				 //for(let reply of json){
				 html+='<table class="table">'
					 html+='<tr>'
					 html+='<td class="text-left" style="color:blue">◑'+reply.name+'('+reply.day+	')</td>'
					 html+='<td class="text-right">'
				      if(reply.id===reply.sessionId){
				    	  html+='<span class="btn btn-xs btn-success ups" onclick="replyUpdate('+reply.rno+')">수정</span>&nbsp;' 
				    	  html+='<input type=button class="btn btn-xs btn-warning" value="삭제" onclick="replyDelete('+reply.rno+','+reply.bno+')">' 
				      }
					 html+='</td>'
					 html+='</tr>'
					 html+='<tr>'
					 html+='<td colspan="2">'
					 html+='<pre style="white-space:pre-wrap;border:none;background:white">'+reply.msg+'</pre>'
					 html+='</td>'
					 html+='</tr>'
				     html+='<tr class="updates" id="m'+reply.rno+'" style="display:none">'
				     html+='<td>'
				     html+='<textarea rows="4" cols="70" id="msg'+reply.rno+'" style="float: left">'+reply.msg+'</textarea>'
				     html+='<input type=button value="댓글수정" onclick="replyUpdataData('+reply.rno+')" style="width: 100px;height: 85px;background-color: green;color:black">'
				     html+='</td>'
				     html+='</tr>'
					 html+='</table>'
				 //}
			 })
			 console.log(html)
			 $('#reply').html(html)
		 },
		 error:function(request,status,error)
		 {
			 console.log(error)
		 }
	 })
 }

</script>
</head>
<body>
	<!-- header start -->
	<div class="ccontainer-fluid bg-breadcrumb">
		<div class="container text-center py-5" style="max-width: 900px;">
		<h1 class="display-3 mb-4 shadowed-text">게시글 상세보기</h1>
		</div>
	</div>
	<!-- header end -->
	<!-- board start css -->
	<div class="container-fluid py-3">
		<div class="container py-3">
			<div class="row1">
	<!-- board css end -->
	<!-- board start -->
	<table class="table">
		<tr>
			<td colspan="4" class="text-right">
			<nav>
				<a href="../board/update.do?no=${vo.no }" class="btn btn-xs btn-success" >수정</a>
				<span class="btn btn-xs btn-warning" id="delBtn">삭제</span>
			</nav>
			</td>
		</tr>
       <tr id="delTr" style="display: none">
         <td colspan="4" class="text-right inline" style="color: yellow;">
         <nav>
         비밀번호 : <input type=password id="del_pwd" class="input-sm" size=15>
         <input type=button value="삭제" class="btn-warning btn-sm" id="deleteBtn">
         </nav>
         </td>
       	</tr>
       <tr>
        <th width=20% class="text-center boardtitlecolor">번호</th>
        <td width=30% class="text-center del_no boardtitlecolor">${vo.no }</td>
        <th width=20% class="text-center boardtitlecolor">작성일</th>
        <td width=30% class="text-center boardtitlecolor">${vo.dbday }</td>
       </tr>
       <tr>
        <th width=20% class="text-center boardtitlecolor">이름</th>
        <td width=30% class="text-center boardtitlecolor">${vo.name }</td>
        <th width=20% class="text-center boardtitlecolor">조회수</th>
        <td width=30% class="text-center boardtitlecolor">${vo.hit }</td>
       </tr>
       <tr>
        <th width=20% class="text-center boardtitlecolor">제목</th>
        <td colspan="3" class="boardtitlecolor">${vo.subject }</td>
       </tr>
       <c:if test="${vo.imgsize>0}">
         <tr>
          <th width=20% class="text-center boardtitlecolor">이미지</th>
          <td colspan="3" ><img src="../boardcamp/download.do?fn=${vo.imgname }" width="853" height="480">(${vo.imgsize}Bytes)</td>
         </tr>
       </c:if>
       <%--
            데이터베이스 : Update,Delete
            업로드된 파일       
        --%>
       <tr>
         <td colspan="4" valign="top">
         <!-- 이미지 삽입 -->
          <pre class="text-left" style="white-space: pre-wrap; border:none; height: 200px;">${vo.content }</pre>
          <div style="text-align: center; bottom:0px;">
          		<a onclick="javascript:history.back()" class="btn btn-xs btn-info">목록으로</a>
          		<%-- &nbsp; <a type="button" style="color: blue;"><img src="../img/thumb_up.png" width="40" height="40">추천(${vo.no })</a> --%>					
          </div>
         </td>
     </table>

     <table class="table">
      <tr>
       <td id="reply"></td>
      </tr>
     </table>
     <table class="table">
     <c:if test="${sessionScope.id==null }">
       <tr>
        <td>
         <textarea readonly rows="3" cols="100" id="msg" style="float: left; height: 30px;" placeholder="댓글을 입력하려면 로그인하여 주십시오."></textarea>
        </td>
       </tr>
     </c:if>
      
     <c:if test="${sessionScope.id!=null }">
       <tr>
        <td>
         <textarea rows="3" cols="100" id="msg" style="float: left" placeholder="내용을 입력해 주십시오"></textarea>
         <input type=button value="댓글 작성" style="width: 100px; height: 85px; color:black" id="writeBtn">
        </td>
       </tr>
     </c:if>
     </table>
     </div>
     </div>
   </div>
</body>
</html>