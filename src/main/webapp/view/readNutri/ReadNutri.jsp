<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../js/jquery-3.7.1.js"></script>
<script>
	function setThumbnail(event){
		var reader = new FileReader();
		
		reader.onload = function(event){ 
			var img = document.createElement("img");
			img.setAttribute("src", event.target.result);
			document.querySelector("div#image_container").appendChild(img);
		};
		
		reader.readAsDataURL(event.target.files[0]);
	}
	
	$(function(){
		$("#btn").click(function(){
			$.ajax({
				url:"../ajaxx/read",
				type:"get",
				success:function(ttt){
					console.log(ttt)
				},
				error:function(e){
					console.log(e.responseText)
				}
			})	
		})
	})
</script>
<style>
	img{
		width:498px;
		height:568px;
	}
</style>
<title>성분표 업로드</title>
</head>
<body>
	<h2>성분표 업로드</h2>
	<form action="ReadNutriReg" method="post" enctype="multipart/form-data">
		<div style="justify-content: space-around; display: flex; align-items: center; width: 1200px; height: 60px;">
			<input type="file" name="nutriFile" onchange="setThumbnail(event);" style="border: 1px solid #000; width: 800px;">
			<input type="submit" value="확인" style=" width: 100px;">
		</div>
	</form>
	<input id="btn" type="button" value="ajax" style=" width: 100px;">
	<form action="">
		<div style="justify-content: space-around; display:flex; width: 1200px; height: 602px">
			<div style="border: 1px solid #000; width: 500px;  height: 570px;">
				<table class="table table-striped-columns">
					<tr>
						<td class="table-dark">칼로리</td>
						<td><input class="form-control" id="kcal" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">나트륨</td>
						<td><input class="form-control" id="na" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">탄수화물</td>
						<td><input class="form-control" id="carbo" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">당류</td>
						<td><input class="form-control" id="sugar" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">지방</td>
						<td><input class="form-control" id="fat" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">트랜스지방</td>
						<td><input class="form-control" id="tFat" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">포화지방</td>
						<td><input class="form-control" id="sFat" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">콜레스테롤</td>
						<td><input class="form-control" id="chole" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">단백질</td>
						<td><input class="form-control" id="protein" type="text"></td>
					</tr>
				</table>
			</div>
			<div style="border: 1px solid #000; width: 500px; height: 570px;">
				<div id="image_container"></div>
			</div>
		</div>
		<div id="con"></div>
	</form>
</body>
</html>