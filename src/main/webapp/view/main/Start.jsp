<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="StartReg" method="set">
	<table border="">
		<h1>기초 정보 입력</h1>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>키</td>
			<td><input type="text" name="height"/></td>
		</tr>
		<tr>
			<td>몸무게</td>
			<td><input type="text" name="weight"/></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age"/></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input type="radio" name="gender" value="남자"/>남자<input type="radio" name="gender" value="여자"/>여자</td>
		</tr>
		
<!-- 		<h1>일일 섭취 목표 설정</h1>
		<tr>
			<td>나트륨</td>
			<td><input type="text" name="na" placeholder="미입력시 DB기본 권장량"/></td>
		</tr>
		<tr>
			<td>탄수화물</td>
			<td><input type="text" name="carbo"placeholder="DB기본 권장량"/></td>
		</tr>
		<tr>
			<td>당류</td>
			<td><input type="text" name="sugar"placeholder="DB기본 권장량"/></td>
		</tr>
		<tr>
			<td>지방</td>
			<td><input type="text" name="fat" placeholder="DB기본 권장량"/></td>
		</tr>
		<tr>
			<td>트렌스지방</td>
			<td><input type="text" name="tFat" placeholder="DB기본 권장량"/></td>
		</tr>
		<tr>
			<td>포화지방</td>
			<td><input type="text" name="sFat" placeholder="DB기본 권장량"/></td>
		</tr>
		<tr>
			<td>콜레스테롤</td>
			<td><input type="text" name="chole" placeholder="DB기본 권장량"/></td>
		</tr>
		<tr>
			<td>단백질</td>
			<td><input type="text" name="protein" placeholder="DB기본 권장량"/></td>
		</tr>
		<tr>
			<td>칼로리</td>
			<td><input type="text" name="kcal" placeholder="DB기본 권장량"/></td>
		</tr> -->
		<tr>
			<td colspan="2">시작하시겠습니까?<input type="submit" value="Start"/></td>
		</tr>
	</table>
</form>

