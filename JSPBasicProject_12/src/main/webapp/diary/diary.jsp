<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%
	String[] strWeek={"일","월","화","수","목","금","토"};
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
	// MM => 09 08 => 자바에서 8진법
	String today=sdf.format(date);
	StringTokenizer st=new StringTokenizer(today,"-");
	String strYear=st.nextToken();
	String strMonth=st.nextToken();
	String strDay=st.nextToken();
	
	// 오늘 날짜 저장
	int tYear=Integer.parseInt(strYear);
	int tMonth=Integer.parseInt(strMonth);
	int tDay=Integer.parseInt(strDay);
	
	String sy=request.getParameter("year");
	if(sy==null)
		sy=strYear;
	
	String sm=request.getParameter("month");
	if(sm==null)
		sm=strMonth;
	
	int year=Integer.parseInt(sy);
	int month=Integer.parseInt(sm);
	int day=Integer.parseInt(strDay);
	
	// 요일 구하기
	Calendar cal=Calendar.getInstance();
	cal.set(Calendar.YEAR,year);
	cal.set(Calendar.MONTH,month-1); // month는 0번부터 시작
	cal.set(Calendar.DATE,1); // day는 1번부터 시작
	
	int week=cal.get(Calendar.DAY_OF_WEEK); // week=1
	week=week-1;
	// 마지막 날 구하기
	int lastday=cal.getActualMaximum(Calendar.DATE);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 800px;
}
h3{
	text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
function change()
{
	let f=document.frm;
	f.submit();
}
</script>
</head>
<body>
	<div class=container>
		<h3><%=session.getAttribute("name") %>님의 일정 관리</h3>
		<div class=row>
		<form method=post action="diary.jsp" name="frm">
			<table class=table>
				<tr>
					<td>
						<select class="input-sm" name=year onchange="change()">
							<%
								for(int i=2024;i<=2030;i++)
								{
							%>
									<option <%=i==year?"selected":"" %>><%=i %></option>
							<%		
								}
							%>
						</select>&nbsp;년도&nbsp;&nbsp;
						<select class="input-sm" name=month onchange="change()">
							<%
								for(int i=1;i<=12;i++)
								{
							%>
									<option <%=i==month?"selected":"" %>><%=i %></option>
							<%		
								}
							%>  
						</select>&nbsp;월
					</td>
				</tr>
			</table>
			<hr>
			<table class=table>
				<tr class=success>
					<%
						for(int i=0;i<7;i++)
						{
							String color="";
							if(i==0)
								color="red";
							else if(i==6)
								color="blue";
							else
								color="black";
					%>
							<th width=100 class="text-center"><span style="color:<%=color%>"><%=strWeek[i] %></span></th>
					<%		
						}
					%>
				</tr>
				<%-- 달력 출력 --%>
					<%
						for(int i=1;i<=lastday;i++)
						{
							if(i==1)
							{
								// 공백 출력
					%>
								<tr>
								<%
									for(int j=0;j<week;j++)
									{
								%>
										<td width=100 height=100 valign=top>&nbsp;</td>
								<%		
									}
								%>
					<%
							}
					%>
							<%
								if(day<=i || tMonth!=month || tYear!=year)
								{
							%>
									<td width=100 height=100 valign=top <%=i==day?"class=danger":"" %>>
										<a href="input.jsp?year=<%=year%>&month=<%=month%>&day=<%=i%>"><%=i %></a>
									</td>
							<%
								}
								else
								{
							%>
									<td width=100 height=100 valign=top <%=i==day?"class=danger":"" %>>
										<%=i %>
									</td>
							<%		
								}
							%>
					<%
							week++;
							if(week>6)
							{
								week=0;
					%>
								</tr>
								<tr>
								
					<%
							}
						}
					%>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>