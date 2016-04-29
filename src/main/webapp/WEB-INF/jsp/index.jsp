<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="/locus/resources/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/locus/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="/locus/resources/js/jquery.validate.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#send").click(function() {
			var path = $("#path").val();
			$.ajax({
				type : 'GET',
				data : {
					path : path
				},
				url : "insertData.html",
				success : function(message) {
					alert(message);
				}
			});
		});

	});
</script>
<title>Insert title here</title>
</head>
<body>
	文件路径：
	<input id="path" name="path" />
	<button id="send">发送</button>
</body>
</html>