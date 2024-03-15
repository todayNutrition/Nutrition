<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    body{
        background-image: linear-gradient(-225deg, #FFFEFF 0%, #D7FFFE 100%);
    }
</style>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <title>오늘도 영양해!</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="../js/jquery-3.7.1.js"></script>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<jsp:include page="inc/header.jsp" />
<c:choose>
    <c:when test="${mainUrl == '/Nutrition/realStart/RealStart' or '/Nutrition/main/Main' or '/Nutrition/main/Start'}">
        <main class="zz container">
            <div class="row">
                <div class="col-sm-12 col-md-6"> <!-- 화면 폭에 따라 반응형으로 조절 -->
                    <jsp:include page="${mainUrl}"/>
                </div>
            </div>
        </main>
    </c:when>
    <c:otherwise>
        <main>
        	<jsp:include page="${mainUrl}"/>
        </main>
    </c:otherwise>
</c:choose>
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>