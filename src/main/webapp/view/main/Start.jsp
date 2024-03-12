<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="/Nutrition/main/StartReg" method="post">
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
			<td><input type="radio" name="gender" value="남"/>남자<input type="radio" name="gender" value="여"/>여자</td>
		</tr>
		<tr>
			<td colspan="2">시작하시겠습니까?<input type="submit" value="Start"/></td>
		</tr>
	</table>
</form>
