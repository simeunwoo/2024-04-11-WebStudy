<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function ok(zip,addr){
	opener.frm.post.value=zip
	opener.frm.address.value=addr
	self.close()

<td><a href="javascript:ok('${vo.zipcode }','${vo.address }')">${vo.address}</a></td>
</script>
</head>
<body>

</body>
</html>