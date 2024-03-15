<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
    
<script>
$(function(){
	var gradient_value = 100 / 3000
	var color = 'linear-gradient(to right, #7fccde 0%, #7fccde '+gradient_value * $(".rangeInput").val() +'%, rgb(236, 236, 236) ' +gradient_value * $(".rangeInput").val() + '%, rgb(236, 236, 236) 100%)';
	$(".rangeInput").css("background",color);
	$(".rangeInput").on("input",function(event){
		$(".goalKcal").val($(this).val())		
		event.target.style.background = 'linear-gradient(to right, #7fccde 0%, #7fccde '+gradient_value * event.target.value +'%, rgb(236, 236, 236) ' +gradient_value *  event.target.value + '%, rgb(236, 236, 236) 100%)';
	})	
})
 </script>
 
<style>
.myGoalPage{
	width: 100%;
}
.myGoalTitle{
	display: flex;
	justify-content: space-evenly;
	align-items: center;
	text-align:center;
	height: 100px;
	line-height: 100px;
	
}
.todayMyGoal{
	text-align: center;
	font-weight: bold;
	font-size: 24px;
}
.changeMyGoal{
	text-align: center;
	display: flex;
	justify-content: space-around;
	padding-bottom: 40px;
	align-items: center;
}

.rangeInput{
  width: 100%;
  border-radius: 8px;
  outline: none;
  transition: background 400ms ease-in;
  -webkit-appearance: none;
  accent-color: #6EB4F0;
}
.goalKcal{
	border:none;
	text-align: center;
}
.btn-mini {
  color: white; 
  padding: 2.5px 12px;  
  display: inline-block;
  border: 1px solid rgba(0,0,0,0.21);
  border-bottom-color: rgba(0,0,0,0.34);
  text-shadow:0 1px 0 rgba(0,0,0,0.15);
  box-shadow: 0 1px 0 rgba(255,255,255,0.34) inset, 
              0 2px 0 -1px rgba(0,0,0,0.13), 
              0 3px 0 -1px rgba(0,0,0,0.08), 
              0 3px 13px -1px rgba(0,0,0,0.21);
  background-color: #7fccde;
  font-size: 12px;
  margin-left: 5px;
}
.btn-mini:active {
  top: 1px;
  border-color: rgba(0,0,0,0.34) rgba(0,0,0,0.21) rgba(0,0,0,0.21);
  box-shadow: 0 1px 0 rgba(255,255,255,0.89),0 1px rgba(0,0,0,0.05) inset;
  position: relative;
}
.chart {float: left; width: 50px; height: 50px; text-align: center;}
.chart span.title{position: relative; display: block; width: 100%; text-align: center; }
</style>

<div class="myGoalPage">
<div class="myGoalTitle">
	<div class="todayMyGoal"><fmt:formatDate value="<%= new Date() %>" pattern="yyyy-MM-dd (E) "/></div>
	<div style="width: 70px;">
		<canvas id="doughnutChartCanvas"></canvas>
	</div>
</div>

<form action="MyGoalModify">
<input type="hidden" name="age" value="${mdata.age }">
<input type="hidden" name="gender" value="${mdata.gender }">
<input type="hidden" name="dayAvg" value="${dayAvg }">
	<div class="changeMyGoal">
		<div>목표칼로리</div>
 	 	<c:forEach items="${data}" var="dto">	
 		<div><input type="range" min="0" max="3000" step="1" style="id="rangeInput" class="rangeInput" value="${mdata.goalKcal }"/></div>
		<div><input type="number" class="goalKcal" value="${mdata.goalKcal }" name="kcal" min="0" max="3000">kcal</div>
 		<div><input type="submit" value="수정" class="btn-mini"/></div>
 		
 	</div>
	
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

  <div class="container pb-3">
    <canvas id="myChart"></canvas>
  </div>

 <script>
 var data = {
		  labels: [
		    "total",
		  ],
		  datasets: [
		    {
		      data: [${dayAvg},${100-dayAvg}],
		      backgroundColor: [
		    	  "#6EB4F0", "#ffffff00"
		      ],
		      hoverBackgroundColor: [
		    	  "#6EB4F0", "#ffffff00"
		      ]
		    }]
		};

		Chart.pluginService.register({
		  beforeDraw: function(chart) {
		    var width = chart.chart.width,
		        height = chart.chart.height,
		        ctx = chart.chart.ctx;

		    ctx.restore();
		   
		    ctx.font = "16px " + "Arial";

		    var fontSize = (height / 114).toFixed(2);
		        console.log( ctx)
		        ctx.textBaseline = "middle";
		   var text = ${dayAvg}+"점",
		        textX = Math.round((width - ctx.measureText(text).width) / 2),
		        textY = height / 2;
		   
		    ctx.fillText(text, textX, textY);
		    ctx.save();
		  }
		});

		var chart = new Chart(document.getElementById('doughnutChartCanvas'), {
		  type: 'doughnut',
		  data: data,
		  options: {
		  	legend: {
		      display: false
		    },
		     cutoutPercentage: 70,
		  }
		});
 
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
</div>


