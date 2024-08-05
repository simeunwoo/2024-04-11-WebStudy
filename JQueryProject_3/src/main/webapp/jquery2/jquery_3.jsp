<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	// button, td, div, h1~h6, span, a ===> click
	// select, checkbox ===> change
	// img => click / mouse
	$('select').on('change',function(){
		let price=$('#price').text()
		let count=$('select').val()
		let total=price*count
		$('#total').text(total)
	})
})
</script>
</head>
<body>
	<select>
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
		<option>6</option>
		<option>7</option>
	</select>
	<span id="price">10000</span>
	<p>
		<span id="total"></span>
	</p>
</body>
</html>