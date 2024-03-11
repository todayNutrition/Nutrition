<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<script>
$(function(){
	$(".slider").on("input",function(){
		$(".goalKcal").val($(this).val())
	})
})
 </script>
<style>
.progress{
	width: 200px;
}
</style>

<form action="MyGoalModify">
<input type="hidden" name="age" value="${mdata.age }">
${ndata.regDate }
<table class="table table-striped">
 	<tr>
 		<td>목표칼로리</td>
 	 	<c:forEach items="${data}" var="dto">
 	 		<c:if test="${mdata.gender == dto.gender}">
 				<td>
 					<input type="range" min="0" max="3000" step="1" style="width: 300px" class="slider" value="${dto.kcal }"/>
					<input type="number" class="goalKcal" value="${dto.kcal }" name="kcal" min="0" max="3000">kcal
 					<input type="submit" value="수정"/>
 				</td>	 	
 			</c:if>
 		</c:forEach>
 	</tr>
 	
 		<%--
 		하루 먹은 칼로리 권장칼로리 대비 퍼센트 - 점수 : % 다 더해서 평균내기
 		(먹은칼로리 / 권장칼로리)*100 = 퍼센트 계산
 		 --%>
 	<tr>
 		<td>섭취</td>
 		<td>점수</td>
 	</tr>	
 	<c:forEach items="${data}" var="dto">
 	<c:if test="${mdata.gender == dto.gender}">
 	
 	<tr>
 		<td>칼로리 ${ndata.kcal }kcal</td>
 		<td>
 			<div class="progress">
  				<div class="progress-bar" style="width: ${(ndata.kcal/dto.kcal)*100}%">
  				<fmt:formatNumber maxFractionDigits="0" value="${(ndata.kcal/dto.kcal)*100}" />점
			</div>
			</div>${dto.kcal }kcal
	</td>
 	</tr>
 	<tr>
 		<td>탄수화물 ${ndata.carbo }g</td>
 		<td>
 		 	<div class="progress">
  				<div class="progress-bar" style="width: ${(ndata.carbo/dto.carbo)*100}%">
  				<fmt:formatNumber maxFractionDigits="0" value="${(ndata.carbo/dto.carbo)*100}" />점
				</div>
			</div>${dto.carbo }g 
 		</td>
 	</tr>
 	<tr>
 		<td>나트륨 ${ndata.na }mg</td>
 		<td>
	 		<div class="progress">
	  				<div class="progress-bar" style="width: ${(ndata.na/dto.na)*100}%">
	  				<fmt:formatNumber maxFractionDigits="0" value="${(ndata.na/dto.na)*100}" />점
				</div>
			</div>${dto.na }mg
	 	</td> 	
 	</tr>
 	<tr>
 		<td>당 ${ndata.sugar }g</td>
 		<td>
 			<div class="progress">
  				<div class="progress-bar" style="width: ${(ndata.sugar/dto.sugar)*100}%">
  				<fmt:formatNumber maxFractionDigits="0" value="${(ndata.sugar/dto.sugar)*100}" />점
			</div>
			</div>${dto.sugar }g
 		</tr>
 	<tr> 	
 		<td>단백질 ${ndata.protein }g</td>
 		<td>
 			<div class="progress">
  				<div class="progress-bar" style="width: ${(ndata.protein/dto.protein)*100}%">
  				<fmt:formatNumber maxFractionDigits="0" value="${(ndata.protein/dto.protein)*100}" />점
			</div>
			</div>${dto.protein }g
 		</td>
 	</tr>
 	<tr>
 		<td>지방 ${ndata.fat }g</td>
 		<td>
 			<div class="progress">
  				<div class="progress-bar" style="width: ${(ndata.fat/dto.fat)*100}%">
  				<fmt:formatNumber maxFractionDigits="0" value="${(ndata.fat/dto.fat)*100}" />점
			</div>
			</div>${dto.fat }g
 		</td> 	
 	</tr>
 	<tr> 	
 		<td>트랜스지방 ${ndata.tFat }g</td>
 		<td>
 			<div class="progress">
  				<div class="progress-bar" style="width: ${(ndata.tFat/dto.tFat)*100}%">
  				<fmt:formatNumber maxFractionDigits="0" value="${(ndata.tFat/dto.tFat)*100}" />점
			</div>
			</div>${dto.tFat }g
 		</td>
 	</tr>
 	<tr> 	
 		<td>포화지방 ${ndata.sFat }g</td>
 		<td>
 			<div class="progress">
  				<div class="progress-bar" style="width: ${(ndata.sFat/dto.sFat)*100}%">
  				<fmt:formatNumber maxFractionDigits="0" value="${(ndata.sFat/dto.sFat)*100}" />점
			</div>
			</div>${dto.sFat }g
 		</td>
 	</tr>
 	<tr>
 		<td>콜레스테롤 ${ndata.chole }mg</td>
 		<td>
 			<div class="progress">
  				<div class="progress-bar" style="width: ${(ndata.chole/dto.chole)*100}%">
  				<fmt:formatNumber maxFractionDigits="0" value="${(ndata.chole/dto.chole)*100}" />점
			</div>
			</div>${dto.chole }mg
 		</td>	
  	</tr>
 	</c:if>
 	</c:forEach>
</table>
</form>