<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
 <!-- 부트스트랩 -->  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a href="/Nutrition/realStart/RealStart" class="navbar-brand">TodayNutrition</a>

        <button class="navbar-toggler" data-toggle="collapse" data-target="#expand">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        
        <!-- 부트스트랩의 일부, 요소를 숨기거나 나타내게 할 수 있음 -->
        <c:choose>
			<c:when test="${UserSS==null}">
		        <div class="collapse navbar-collapse" id="expand">
		            <div class="navbar-nav">
		            </div>
		        </div>
		    </c:when>
		    <c:otherwise>
		    	<div class="collapse navbar-collapse" id="expand">
		            <div class="navbar-nav">
		                <a href="/Nutrition/main/Main" class="nav-item nav-link">메인페이지</a>
		                <a href="/Nutrition/readNutri/ReadNutri" class="nav-item nav-link">성분표 업로드</a>
		                <a href="/Nutrition/graph/Graph" class="nav-item nav-link">그래프</a>
		                <a href="/Nutrition/myGoal/MyGoalDetail" class="nav-item nav-link">목표 설정</a>
		                <a href="/Nutrition/calendar/CalendarMain" class="nav-item nav-link">달력</a>
		            </div>
		        </div>
		    </c:otherwise>
		</c:choose>
    </nav> 
  <!-- 햄버거 부트스트랩 -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>