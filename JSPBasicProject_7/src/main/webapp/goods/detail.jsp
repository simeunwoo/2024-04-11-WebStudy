<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<jsp:useBean id="dao" class="com.sist.dao.GoodsDAO"/>
<jsp:useBean id="rDao" class="com.sist.dao.ReplyDAO"/>
<%
    String id=(String)session.getAttribute("id");
    String no=request.getParameter("no");
    // include => 파일전체에서 request를 공유할 수 있다 
    // mode => 화면 변경 => include되는 파일 찾기 
    // 나머지 데이터는 해당 JSP에서 처리 
    GoodsVO vo=dao.goodsDetailData(Integer.parseInt(no));
    // 댓글목록 => fno
    List<ReplyVO> list=rDao.replyListData(Integer.parseInt(no),2);
    
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let u=0; // 전역변수 
// 변수 => var : let, const(상수형)
$(function(){ // main => window.onload=function(){}
	$('.updates').click(function(){
		$('.ups').hide();
		let rno=$(this).attr("data-no");
		if(u==0)
		{
			u=1;
			$(this).text("취소");
			$('#ups'+rno).show(); // document.getElementById("ups"+rno)
		}
		else
		{
			u=0;
			$(this).text("수정");
			$('#ups'+rno).hide();
		}
	})
})
</script>
</head>
<body>
  <div class="row">
    <div class="col-sm-8">
      <%-- 맛집 상세 , 댓글 
      goods_poster,goods_name,goods_price,"
				    +"goods_sub,goods_delivery,goods_discount
      --%>
      <table class="table">
       <tr>
         <td width="30%" class="text-center" rowspan="3">
          <img src="<%=vo.getGoods_poster() %>" style="width: 100%">
         </td>
         <td colspan="2"><h3><%=vo.getGoods_name() %></h3>
          <sub style="color:gray"><%=vo.getGoods_sub() %></sub>
         </td>
       </tr>
       <tr>
         <th class="text-center" width="15%">가격</th>
         <td width="55%"><span style="color:magenta"><%=vo.getGoods_discount() %>%</span>&nbsp;<%=vo.getGoods_price() %></td>
       </tr>
       <tr>
         <th class="text-center" width="15%">배송</th>
         <td width="55%"><%=vo.getGoods_delivery() %></td>
       </tr>
      </table>
      <table class="table">
        <tr>
          <td class="text-right">
            <a href="#" class="btn btn-xs btn-info">찜하기</a>
            <a href="#" class="btn btn-xs btn-success">좋아요</a>
            <a href="#" class="btn btn-xs btn-warning">예약</a>
            <a href="../main/main.jsp?mode=2" class="btn btn-xs btn-primary">목록</a>
          </td>
        </tr>
      </table>
      <div style="height: 15px"></div>
      <table class="table">
        <tr>
         <td>
           <%
              for(ReplyVO rvo:list)
              {
           %>
                 <table class="table">
                  <tr>
                    <td class="text-left">
                    ◑<%=rvo.getName() %>&nbsp;(<%=rvo.getDbday() %>)
                    </td>
                    <td class="text-right">
                      <%
                         if(rvo.getId().equals(id))
                         {
                      %>
                            <span class="btn btn-danger btn-xs updates" data-no="<%=rvo.getRno()%>">수정</span>
                            <a href="../reply/delete.jsp?rno=<%=rvo.getRno() %>&fno=<%=rvo.getFno() %>&type=<%=rvo.getType() %>" class="btn btn-primary btn-xs">삭제</a>
                      <%
                         }
                      %>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2"><pre style="white-space: pre-wrap;background-color: white;border:none"><%=rvo.getMsg() %></pre></td>
                  </tr>
                  
                   <tr style="display: none" class="ups" id="ups<%=rvo.getRno()%>">
			          <td>
			           <form method="post" action="../reply/update.jsp">
			            <input type="hidden" name=type value="<%=rvo.getType()%>">
			            <input type="hidden" name=fno value="<%=vo.getNo()%>">
			            <input type="hidden" name=rno value="<%=rvo.getRno()%>">
			            <textarea rows="4" cols="45" name="msg" style="float: left" required><%=rvo.getMsg() %></textarea>
			            <button style="height: 82px;width: 100px;background-color: blue;color:white;float: left">댓글수정</button>
			           </form>
			          </td>
			        </tr>
                 </table>
           <%  	  
              }
           %>
         </td>
        </tr>
      </table>
      <%
         if(id!=null)
         {
      %>
      <table class="table">
        <tr>
          <td>
           <form method="post" action="../reply/insert.jsp">
            <input type="hidden" name=type value="2">
            
            <input type="hidden" name=fno value="<%=vo.getNo()%>">
            <textarea rows="4" cols="60" name="msg" style="float: left" required></textarea>
            <button style="height: 82px;width: 120px;background-color: blue;color:white;float: left">댓글쓰기</button>
           </form>
          </td>
        </tr>
      </table>
      <%
         }
      %>
    </div>
    <div class="col-sm-4">
      <%-- 지도 , 근처 맛집 --%>
    </div>
  </div>
</body>
</html>