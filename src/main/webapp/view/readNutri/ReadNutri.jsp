<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<script src="../js/jquery-3.7.1.js"></script>
<script>
	$(function(){
		$("#nuUp").prop('disabled', true);
		
		$("#nuImg").on('input',function(){
			const inputValue = $("#nuImg").val().trim();
			
			$("#nuUp").prop('disabled', inputValue ==='')
		})
		
		
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
					if(ttt=='err'){
						alert("이미지 데이터 오류 사진을 재업로드 해주세요");
						return 
					}else if(ttt=='FileErr'){
						alert("이미지 파일만 가능합니다(JPG,PNG,JPEG,BMP)");
						return
					}else if(ttt=='ValueErr'){
						alert("데이터 밸류 에러 사진을 재업로드 해주세요");
						return
					}
					
					var arr = ttt.split("/")
					$("#kcal").val(arr[0].substring(0,arr[0].indexOf(" ")))
					$("#na").val(arr[1].substring(0,arr[1].indexOf(" ")))
					$("#carbo").val(arr[2].substring(0,arr[2].indexOf(" ")))
					$("#sugar").val(arr[3].substring(0,arr[3].indexOf(" ")))
					$("#fat").val(arr[4].substring(0,arr[4].indexOf(" ")))
					$("#tFat").val(arr[5].substring(0,arr[5].indexOf(" ")))
					$("#sFat").val(arr[6].substring(0,arr[6].indexOf(" ")))
					$("#chole").val(arr[7].substring(0,arr[7].indexOf(" ")))
					$("#protein").val(arr[8].substring(0,arr[8].indexOf(" ")))
					
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
		width:100%;
		height:100%;
	}
	.input-group mb-3{
		align-items: center; 
		height: 60px; 
		width: 100%;
	}
	.ffBox{
		justify-content: center; 
		display: grid; 
		margin: 10px;
	}
	.ttBox{
		justify-content: space-around; 
		display:flex; 
		height: 600px
	}
	.textBox{
		width: 500px; 
		height: 570px;
	}
	.imgBox{
		width: 500px; 
		height: 570px;
	}

	@media (max-width: 767px)  {
		.input-group mb-3{
			align-items: center; 
			height: 60px; 
			width: 95%;
		}
		.ffBox{
			justify-content: center; 
			display: grid; 
			margin: 10px;
		}
		.ttBox{
            flex-direction: column;
            align-items: center; 
			display:flex;  
			height: 900px;
		}
		.textBox{
			width: 95%; 
			height: 570px;
		}
		.imgBox{
			width: 95%; 
			height: 300px;
		}

	}
</style>
<title>성분표 업로드</title>
</head>
<body>
<div style="width: 100%;">
	<h2 style="text-align: center; margin: 20px;">성분표 업로드</h2>
	<div class="ffBox">
		<div class="input-group mb-3">
			<input class="form-control" id="nuImg" type="file" name="nuImg">
			<input class="btn btn-success" type="button" value="성분표올리기" id="nuUp">
		</div>
	</div>
	<form action="ReadNutriReg" method="post" enctype="multipart/form-data">
		<div class="ttBox">
			<div  class="textBox">
				<table class="table table-striped-columns">
					<tr>
						<td class="table-dark">칼로리</td>
						<td><input class="form-control" id="kcal" name="kcal" type="number" required></td>
					</tr>
					<tr>
						<td class="table-dark">나트륨</td>
						<td><input class="form-control" id="na" name="na" type="number" required></td>
					</tr>
					<tr>
						<td class="table-dark">탄수화물</td>
						<td><input class="form-control" id="carbo" name="carbo" type="number" required></td>
					</tr>
					<tr>
						<td class="table-dark">당류</td>
						<td><input class="form-control" id="sugar" name="sugar" type="number" required></td>
					</tr>
					<tr>
						<td class="table-dark">지방</td>
						<td><input class="form-control" id="fat" name="fat" type="number" required></td>
					</tr>
					<tr>
						<td class="table-dark">트랜스지방</td>
						<td><input class="form-control" id="tFat" name="tFat" type="number" required></td>
					</tr>
					<tr>
						<td class="table-dark">포화지방</td>
						<td><input class="form-control" id="sFat" name="sFat" type="number" required></td>
					</tr>
					<tr>
						<td class="table-dark">콜레스테롤</td>
						<td><input class="form-control" id="chole" name="chole" type="number" required></td>
					</tr>
					<tr>
						<td class="table-dark">단백질</td>
						<td><input class="form-control" id="protein" name="protein" type="number" required></td>
					</tr>
				</table>
			</div>
			<div class="imgBox">
				<img id="preview">
			</div>
		</div>
			<div align="center">
				<input class="btn btn-dark" type="submit" value="등록">
			</div>
	</form>
</div>
</body>
</html>