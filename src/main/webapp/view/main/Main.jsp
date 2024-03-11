<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<form action="ModifyReg" method="post">
	<table border="">
		<h1>나의 프로필</h1>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name="name" value="${MainUser.name}"/>수정가능</td>
		</tr>
		<tr>
			<td>키</td>
			<td><input type="text" name="height" value="${MainUser.height}"/>수정가능</td>
		</tr>
		<tr>
			<td>몸무게</td>
			<td><input type="text" name="weight" value="${MainUser.weight}"/>수정가능</td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="${MainUser.age}"/>수정가능</td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input type="text" name="gender" value="${MainUser.gender}" readonly="readonly"/></td>
		</tr>
		<tr>
			<td>목표 칼로리</td>
			<td><%-- ${MainUser.goalKcal} --%></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정"/></td>
		</tr>
	</table>
</form>
	<table>
			<h1>일일 섭취량</h1>
		<tr>
			<td>칼로리</td>

			<td>${param.goalKcal}mg</td>
		</tr>
		<tr>
			<td>나트륨</td>
			<td>${param.na}mg</td>
		</tr>
		<tr>
			<td>탄수화물</td>
			<td>${param.carbo}mg</td>
		</tr>
		<tr>
			<td>당류</td>
			<td>${param.sugar}mg</td>
		</tr>
		<tr>
			<td>지방</td>
			<td>${param.fat}mg</td>
		</tr>
		<tr>
			<td>트렌스지방</td>
			<td>${param.tFat}mg</td>
		</tr>
		<tr>
			<td>포화지방</td>
			<td>${param.sFat}mg</td>
		</tr>
		<tr>
			<td>콜레스테롤</td>
			<td>${param.chole}mg</td>
		</tr>
		<tr>
			<td>단백질</td>
			<td>${param.protein}mg</td>
		</tr>
	</table>