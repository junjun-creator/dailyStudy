<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 예약</title>
</head>
<body>
	<form name="paging" action="./myreservation" method="post">
		<input type="hidden" name="resrv_email" value="${resrv_email}"/>
	</form>
	
	<script>
		var f = document.paging;
		f.submit();
	</script>
</body>
</html>