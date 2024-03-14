<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../js/jquery-3.7.1.js"></script>
<script>
/* 	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				document.getElementById('preview').src = e.target.result;
			};
		    reader.readAsDataURL(input.files[0]);
		} else {
			document.getElementById('preview').src = "";
		}
	} */
		
	$(function(){
		$("#nuUp").on("click",function(){
			
			var fData = new FormData()
			fData.append("nuImg", $("#nuImg")[0].files[0])
			
			console.log(fData)
			
			$.ajax({
				url:"../ajaxx/read",
				//type:"get",
				type:"post",
				enctype:"multipart/form-data",
				data:fData,
				processData:false,
				contentType:false,
				success:function(ttt){
					var arr = ttt.split("..")
					$("#kcal").val(arr[0].substring(0,arr[0].indexOf("k")))
					$("#na").val(arr[1].substring(0,arr[1].indexOf("m")))
					$("#carbo").val(arr[2].substring(0,arr[2].indexOf("9")))
					$("#sugar").val(arr[3].substring(0,arr[3].indexOf("9")))
					$("#fat").val(arr[4].substring(0,arr[4].indexOf("9")))
					$("#tFat").val(arr[5].substring(0,arr[5].indexOf("9")))
					$("#sFat").val(arr[6].substring(0,arr[6].indexOf("9")))
					$("#chole").val(arr[7].substring(0,arr[7].indexOf("m")))
					$("#protein").val(arr[8].substring(0,arr[8].indexOf("9")))
					
					$('#preview').attr("src","../fff/"+arr[9])
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
	
		<div style="justify-content: space-around; display: flex; align-items: center; width: 1200px; height: 60px;">
			<input class="form-control" id="nuImg" type="file" name="nuImg"  style="border: 1px solid #000; width: 800px;">
			<input type="button" value="성분표올리기" id="nuUp"  >
		</div>
	<form action="ReadNutriReg" method="post" enctype="multipart/form-data">
		<div style="justify-content: space-around; display:flex; width: 1200px; height: 602px">
			<div style="border: 1px solid #000; width: 500px;  height: 570px;">
				<table class="table table-striped-columns">
					<tr>
						<td class="table-dark">칼로리</td>
						<td><input class="form-control" id="kcal" name="kcal" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">나트륨</td>
						<td><input class="form-control" id="na" name="na" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">탄수화물</td>
						<td><input class="form-control" id="carbo" name="carbo" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">당류</td>
						<td><input class="form-control" id="sugar" name="sugar" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">지방</td>
						<td><input class="form-control" id="fat" name="fat" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">트랜스지방</td>
						<td><input class="form-control" id="tFat" name="tFat" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">포화지방</td>
						<td><input class="form-control" id="sFat" name="sFat" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">콜레스테롤</td>
						<td><input class="form-control" id="chole" name="chole" type="text"></td>
					</tr>
					<tr>
						<td class="table-dark">단백질</td>
						<td><input class="form-control" id="protein" name="protein" type="text"></td>
					</tr>
				</table>
			</div>
			<div style="border: 1px solid #000; width: 500px; height: 570px;">
				<div id="image_container">
					<img id="preview">
				</div>
			</div>
		</div>
			<div align="right" style="width: 1150px;">
				<input class="btn btn-dark" type="submit" value="등록">
			</div>
	</form>
</body>
</html>