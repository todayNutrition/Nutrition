<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1px">
 	<tr>
 		<td>목표칼로리 => 입력하지 않을 경우 권장 칼로리를 가져옴</td>
 		<td><input type="text">kcal</input></td>	
 		<td colspan="7"></td>
 	</tr>
 	<tr>
 		<td>권장칼로리</td>
 		<td>권장 칼로리의 데이터를 조건(성별, 연령)에 맞게 읽어와서 내가 등록한 칼로리와 수치 비교 => 점수 계산하기</td>
 		<td>권장 칼로리 대비 목표 칼로리가 넘었을 경우 => 경고...? </td>
 		<td colspan="6"></td>
 	</tr>
 	
 	<tr>
 	<c:forEach items="${data }" var="dto">
 		<td>${dto.kcal }</td>
 		<td>${dto.carbo }g</td>
 		<td>${dto.na }mg</td>
 		<td>${dto.sugar }g</td>
 		<td>${dto.protein }g</td>
 		<td>${dto.fat }g</td>
 		<td>${dto.tFat }g</td>
 		<td>${dto.sFat }</td>
 		<td>${dto.chole }mg</td>
 	</c:forEach>
 	</tr>
 	
</table>