<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav>안녕</nav>
<form action="" method="set">
	<table border="">
		<h1>나의 프로필</h1>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name="name" value=""/>수정가능</td>
		</tr>
		<tr>
			<td>키</td>
			<td><input type="text" name="height" value=""/>수정가능</td>
		</tr>
		<tr>
			<td>몸무게</td>
			<td><input type="text" name="weight" value=""/>수정가능</td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value=""/>수정가능</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${param.gender}</td>
		</tr>
		<tr>
			<td>목표 칼로리</td>
			<td>고정값 - 혜성언니</td>
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
			<td><input type="text" name="kcal"/>kcal</td>
		</tr>
		<tr>
			<td>나트륨</td>
			<td><input type="text" name="na"/>mg</td>
		</tr>
		<tr>
			<td>탄수화물</td>
			<td><input type="text" name="carbo"/>mg</td>
		</tr>
		<tr>
			<td>당류</td>
			<td><input type="text" name="sugar"/>mg</td>
		</tr>
		<tr>
			<td>지방</td>
			<td><input type="text" name="fat"/>mg</td>
		</tr>
		<tr>
			<td>트렌스지방</td>
			<td><input type="text" name="tFat"/>mg</td>
		</tr>
		<tr>
			<td>포화지방</td>
			<td><input type="text" name="sFat"/>mg</td>
		</tr>
		<tr>
			<td>콜레스테롤</td>
			<td><input type="text" name="chole"/>mg</td>
		</tr>
		<tr>
			<td>단백질</td>
			<td><input type="text" name="protein"/>mg</td>
		</tr>
	</table>