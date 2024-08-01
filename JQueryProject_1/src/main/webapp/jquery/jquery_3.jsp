<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){ // $(document).ready(function(){})
	// 태그 읽기 => CSS Selector
	$('td:nth-child(7n+4)').css('backgroundColor','green')
	$('td:nth-child(7n+2)').css('backgroundColor','yellow')
})
</script>
</head>
<body>
	<table border="1" bordercolor="black">
		<tr>
			<td>100</td>
			<td>90</td>
			<td>80</td>
			<td>70</td>
			<td>60</td>
			<td>50</td>
			<td>40</td>
		</tr>
		<tr>
			<td>100</td>
			<td>90</td>
			<td>80</td>
			<td>70</td>
			<td>60</td>
			<td>50</td>
			<td>40</td>
		</tr>
		<tr>
			<td>100</td>
			<td>90</td>
			<td>80</td>
			<td>70</td>
			<td>60</td>
			<td>50</td>
			<td>40</td>
		</tr>
		<tr>
			<td>100</td>
			<td>90</td>
			<td>80</td>
			<td>70</td>
			<td>60</td>
			<td>50</td>
			<td>40</td>
		</tr>
		<tr>
			<td>100</td>
			<td>90</td>
			<td>80</td>
			<td>70</td>
			<td>60</td>
			<td>50</td>
			<td>40</td>
		</tr>
	</table>
</body>
</html>