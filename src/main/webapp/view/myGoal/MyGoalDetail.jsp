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
<input type="hidden" name="gender" value="${mdata.gender }">
${today.regDate }
<table class="table table-striped">
 	<tr>
 		<td>목표칼로리</td>
 	 	<c:forEach items="${data}" var="dto">
 		<td>
 			<input type="range" min="0" max="3000" step="1" style="width: 300px" class="slider" value="${dto.kcal }"/>
			<input type="number" class="goalKcal" value="${dto.kcal }" name="kcal" min="0" max="3000">kcal
 			<input type="submit" value="수정"/>
 		</td>	 	
 	</tr>
 </table>
</form>
<table class="table">
  <thead>
    <tr>
      <th scope="col">성분</th>
      <th scope="col">권장 섭취량</th>
      <th scope="col">총 섭취량</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">칼로리</th>
      <td>${dto.kcal}kcal</td>
      <td>${total.kcal }kcal</td>
    </tr>
    <tr>
      <th scope="row">나트륨</th>
      <td>${dto.na}mg</td>
      <td>${total.na }mg</td>
    </tr>
     <tr>
      <th scope="row">탄수화물</th>
      <td>${dto.carbo}g</td>
      <td>${total.carbo }g</td>
    </tr>
     <tr>
      <th scope="row">당류</th>
      <td>${dto.sugar}g</td>
      <td>${total.sugar }g</td>
    </tr>
     <tr>
      <th scope="row">지방</th>
      <td>${dto.fat}g</td>
      <td>${total.fat }g</td>
    </tr>
     <tr>
      <th scope="row">트렌스지방</th>
      <td>${dto.tFat}g</td>
      <td>${total.tFat }g</td>
    </tr>
     <tr>
      <th scope="row">포화지방</th>
      <td>${dto.sFat}g</td>
      <td>${total.sFat }g</td>
    </tr>
    <tr>
      <th scope="row">콜레스테롤</th>
      <td>${dto.chole}mg</td>
      <td>${total.chole }mg</td>
    </tr>
    <tr>
      <th scope="row">단백질</th>
      <td>${dto.protein}g</td>
      <td>${total.protein }g</td>
    </tr>
  </tbody>
</table>
 	

  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>부트스트랩 차트그리기</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <!-- 차트 링크 -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

  <div class="container">
    <canvas id="myChart"></canvas>
  </div>


  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
    
 <script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
      // 챠트 종류를 선택
      type: 'line',

      // 챠트를 그릴 데이타
      data: {
        labels: ['칼로리', '나트륨', '탄수화물', '당류', '지방', '트렌스지방', '포화지방', '콜레스테롤', '단백질'],
        datasets: [{
          label: '내 점수',
          backgroundColor: 'transparent',
          borderColor: 'skyblue',
          data: [${ndata.kcal}, ${ndata.na}, ${ndata.carbo}, ${ndata.sugar}, ${ndata.fat}, ${ndata.tFat}, ${ndata.sFat}, ${ndata.chole}, ${ndata.protein}]
        }]
      },

      options: {}
    });
</script>

</c:forEach>



 
 

