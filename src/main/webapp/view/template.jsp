<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘도 영양해!</title>
<script src="../js/jquery-3.7.1.js"></script>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>

	<%-- 헤더 어떻게 할지
	<jsp:include page=".jsp" /> --%>
	
	<main>
		<jsp:include page="${mainUrl}"/>
	</main>

</body>
</html>